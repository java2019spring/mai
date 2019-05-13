import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class front {
    public static int width = 800, height = 600, num_plate = 7, plate_w = 100, plate_h = 100;
    public static String[] colors = { "blue", "green", "purple", "yellow", "orange", "red", "coffee" };
    public static String[] colors_CN = { "蓝色", "绿色", "紫色", "黄色", "橙色", "红色", "咖啡" };
    public static int[] prices = { 8, 10, 12, 16, 18, 20, 24 };

    public static int p_per_disk(String col) {
        int index = 0;
        for (int i = 0; i < num_plate; i++) {
            if (col.equals(colors[i])) {
                index = i;
                break;
            }
        }
        return prices[index];
    }

    public static void accounting(JFrame f) {
        class A_quit implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setFileFilter(new FileFilter() {

            public String getDescription() {
                return ".jpg";
            }

            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg");
            }
        });
        class open_file implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
                }
            }
        }
        // -------------init------------
        JPanel jp = new JPanel();
        jp.setSize(width, height);
        jp.setLocation(0, 0);
        jp.setLayout(null);
        jp.setOpaque(false);
        f.add(jp);

        System.out.println("accounting");
        // -------------add prices--------------
        JLabel[] lab_pr = new JLabel[num_plate];
        for (int i = 0; i < 4; i++) {
            lab_pr[i] = new JLabel(colors_CN[i] + ":" + prices[i] + "元");
            lab_pr[i].setForeground(Color.black);
            lab_pr[i].setBounds(width / 2 + (i - 2) * (plate_w * 3 / 2) + 15, plate_h + 15, plate_w, plate_h);
            lab_pr[i].setFont(new Font("黑体", Font.PLAIN, 18));
            jp.add(lab_pr[i]);
        }
        for (int i = 4; i < 7; i++) {
            lab_pr[i] = new JLabel(colors_CN[i] + ":" + prices[i] + "元");
            lab_pr[i].setForeground(Color.black);
            lab_pr[i].setBounds(width / 2 - plate_w / 2 + (i - 5) * (plate_w * 3 / 2) + 15, 3 * plate_h + 15, plate_w,
                    plate_h);
            lab_pr[i].setFont(new Font("黑体", Font.PLAIN, 18));
            jp.add(lab_pr[i]);
        }
        jp.repaint();
        // --------------add plates-------------
        ImageIcon[] im_p = new ImageIcon[num_plate];
        JLabel[] lab_p = new JLabel[num_plate];
        for (int i = 0; i < 4; i++) {
            im_p[i] = new ImageIcon("plate/" + colors[i] + ".jpg");
            lab_p[i] = new JLabel(im_p[i]);
            jp.add(lab_p[i], new Integer(Integer.MIN_VALUE));
            lab_p[i].setBounds(width / 2 + (i - 2) * (plate_w * 3 / 2), plate_h / 2, plate_w, plate_h);
        }
        for (int i = 4; i < 7; i++) {
            im_p[i] = new ImageIcon("plate/" + colors[i] + ".jpg");
            lab_p[i] = new JLabel(im_p[i]);
            jp.add(lab_p[i], new Integer(Integer.MIN_VALUE));
            lab_p[i].setBounds(width / 2 - plate_w / 2 + (i - 5) * (plate_w * 3 / 2), 5 * plate_h / 2, plate_w,
                    plate_h);
        }
        // ---------------add buttons---------------
        JButton b_quit = new JButton("退出");
        b_quit.setFont(new Font("宋体", Font.BOLD, 16));
        b_quit.setBounds(600, height * 3 / 4, 100, 50);
        b_quit.addActionListener(new A_quit());
        jp.add(b_quit);
        JButton b_open = new JButton("选择图片");
        b_open.setFont(new Font("宋体", Font.BOLD, 14));
        b_open.setBounds(475, height * 3 / 4, 100, 50);
        b_open.addActionListener(new open_file());
        jp.add(b_open);
    }

    public static void welcome() {
        class A_go implements ActionListener {
            private JFrame ff;
            private JPanel jpp;

            public A_go(JFrame f, JPanel pp) {
                ff = f;
                jpp = pp;
            }

            public void actionPerformed(ActionEvent e) {
                /*
                 * for (Component co : ff.getContentPane().getComponents()) { ff.remove(co); }
                 * for (Component co : ff.getLayeredPane().getComponents()) { if
                 * (!co.getClass().getName().equals("javax.swing.JPanel"))
                 * ff.getLayeredPane().remove(co); }
                 */
                ff.remove(jpp);
                accounting(ff);
            }
        }
        class A_quit implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        System.out.println("welcome");
        // ---------------init--------------
        JFrame f = new JFrame("Settle Account");
        JPanel jp = new JPanel();
        f.setSize(width, height);
        f.setLocation(580, 240);
        f.setLayout(null);
        jp.setSize(width, height);
        jp.setLocation(0, 0);
        jp.setLayout(null);
        jp.setOpaque(false);
        f.add(jp);
        // --------------add text --------------
        JLabel title = new JLabel("欢迎使用自助结账！");
        title.setForeground(Color.black);
        title.setBounds(50, 100, 500, 50);
        title.setFont(new Font("黑体", Font.PLAIN, 36));
        jp.add(title);

        // --------------add button------------
        JButton b_go = new JButton("开始使用");
        b_go.setFont(new Font("宋体", Font.BOLD, 14));
        b_go.setBounds(475, height * 3 / 4 - 50, 100, 50);
        b_go.addActionListener(new A_go(f, jp));
        jp.add(b_go);
        JButton b_quit = new JButton("退出");
        b_quit.setFont(new Font("宋体", Font.BOLD, 16));
        b_quit.setBounds(600, height * 3 / 4 - 50, 100, 50);
        b_quit.addActionListener(new A_quit());
        jp.add(b_quit);
        // -----------add background------------
        ImageIcon img1 = new ImageIcon("bg.jpg");
        JLabel label1 = new JLabel(img1);
        jp.add(label1, new Integer(Integer.MIN_VALUE));
        label1.setBounds(width / 2, 0, width / 2, height / 2);
        ImageIcon img2 = new ImageIcon("bg2.jpg");
        JLabel label2 = new JLabel(img2);
        jp.add(label2, new Integer(Integer.MIN_VALUE));
        label2.setBounds(0, height / 2, width / 2, height / 2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        welcome();
    }
}