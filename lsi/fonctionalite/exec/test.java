package lsi.fonctionalite.exec;
import javax.swing.*; 
public class test {

    test() {
        JFrame f = new JFrame("Exemple JButton avec image");
        String imgUrl = "img\\all.png";
        ImageIcon icon = new ImageIcon(imgUrl);
        JButton btn = new JButton("test", icon);
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setBounds(40, 80, 200, 50);
        f.add(btn);
        f.setSize(300, 250);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new test();
        });
    }
}
