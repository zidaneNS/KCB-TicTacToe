package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        new MainFrame();
    }

    public MainFrame(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic-Tac-Toe");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    
        // main panel isine title dan button
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setPreferredSize(new Dimension(400,480));
        mainPanel.setLayout(new FlowLayout());

        // isine button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
        buttonPanel.setPreferredSize(new Dimension(200,100));
        buttonPanel.setLayout(new GridLayout(2,1,10,10));

        JLabel title = new JLabel("Tic-Tac-Toe");
        title.setFocusable(false);
        title.setBackground(Color.black);
        title.setFont(new Font("Sans-Serif", Font.CENTER_BASELINE, 65));
        title.setForeground(new Color(0xFF5733));

        JButton playButton = new JButton("Play");
        JButton aboutButton = new JButton("About");

        buttonPanel.add(playButton);
        buttonPanel.add(aboutButton);
        mainPanel.add(title);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);

        // menampilkan opsi permainan dengan ai atau multiplayer
        playButtonListener(playButton, buttonPanel);

        this.setVisible(true);
    }

    public void playButtonListener(JButton button, JPanel panel){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton playWithAi = new JButton("Play With Ai");
                JButton playMulti = new JButton("Play With Friend");

                // menghapus playbutton dan aboutbutton
                panel.removeAll();

                // inisialisasi tok
                playWithAi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Ini nanti isinya main dengan ai");
                    }
                    
                });

                // inisialisasi tok
                playMulti.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Ini nanti main dengan teman");
                    }
                    
                });

                // nambah button baru
                panel.add(playWithAi);
                panel.add(playMulti);

                // mereload
                panel.revalidate();
                panel.repaint();
            }
            
        });
    }
}
