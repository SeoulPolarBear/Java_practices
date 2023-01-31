import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame
{
public MainWindow()
{
setTitle("Font and color");
setSize(500, 300);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null); // 윈도우를 중앙에 위치시킴
createWindow();
setVisible(true);
}

private void createWindow()
{
add(createLabel("North", Color.blue, Color.white, new Font("Liberation Serif", Font.PLAIN, 24), 0, 30), BorderLayout.NORTH);
add(createLabel("South", Color.green, Color.black, new Font("Liberation Serif", Font.BOLD, 36), 0, 50), BorderLayout.SOUTH);
add(createLabel("West", Color.magenta, Color.black, new Font("Liberation Serif", Font.ITALIC, 18), 60, 0), BorderLayout.WEST);
add(createLabel("East", Color.red, Color.white, new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 24), 60, 0), BorderLayout.EAST);
add(createLabel("Center", new Color(240, 240, 240), Color.pink, new Font("Liberation Serif", Font.BOLD, 96), 0, 0));
}

private JLabel createLabel(String text, Color bg, Color fg, Font font, int width, int height)
{
JLabel label = new JLabel(text);
label.setOpaque(true); // 백그라운드가 투명하지 않도록 설정
label.setBackground(bg);
label.setForeground(fg);
label.setFont(font);
label.setHorizontalAlignment(JLabel.CENTER);
label.setPreferredSize(new Dimension(width, height)); // 크기
return label;
}
}
