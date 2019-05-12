import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

public class front {
    public static int width = 800, height = 600;

    public static int p_per_disk(String col) {
        char c = col.charAt(0);
        switch (c) {
        case 'b':
            return 8;
        case 'g':
            return 10;
        case 'p':
            return 12;
        case 'y':
            return 16;
        case 'o':
            return 18;
        case 'r':
            return 20;
        default:
            return 24;
        }
    }

    public static void welcome() {
        class A_go implements ActionListener {
            private JFrame ff;

            public A_go(JFrame f) {
                ff = f;
            }

            public void actionPerformed(ActionEvent e) {
                System.out.println("meile");
                ff.setVisible(false);
                // second();
            }
        }
        class A_quit implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        // ---------------init--------------
        JFrame f = new JFrame("Settle Account");
        f.setSize(width, height);
        f.setLocation(580, 240);
        f.setLayout(null);
        // --------------add text --------------
        JLabel title = new JLabel("欢迎使用自助结账！");
        title.setForeground(Color.black);
        title.setBounds(50, 100, 500, 50);
        title.setFont(new Font("黑体", Font.PLAIN, 36));
        f.add(title);
        // --------------add button------------
        int but_w = 100, but_h = 50;
        JButton b_go = new JButton("开始使用");
        b_go.setFont(new Font("宋体", Font.BOLD, 14));
        b_go.setBounds(475, height * 3 / 4 - but_h, 100, 50);
        b_go.addActionListener(new A_go(f));
        f.add(b_go);
        JButton b_quit = new JButton("退出");
        b_quit.setFont(new Font("宋体", Font.BOLD, 16));
        b_quit.setBounds(600, height * 3 / 4 - but_h, 100, 50);
        b_quit.addActionListener(new A_quit());
        f.add(b_quit);
        // -----------add background------------
        ImageIcon img1 = new ImageIcon("bg.jpg");
        JLabel label1 = new JLabel(img1);
        f.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(width / 2, 0, width / 2, height / 2);
        ImageIcon img2 = new ImageIcon("bg2.jpg");
        JLabel label2 = new JLabel(img2);
        f.getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(0, height / 2, width / 2, height / 2);
        JPanel p = (JPanel) f.getContentPane();
        p.setOpaque(false);
        //
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        welcome();
    }
}