import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainWindow extends JFrame
{
private JTextField txtName = new JTextField();
private JButton cmdAdd = new JButton("Add");
private JButton cmdClr = new JButton("Clear");
private JButton cmdCount = new JButton("Count"); // Count 버튼 생성
private JList lstNames;
private DefaultListModel model = new DefaultListModel();

public MainWindow()
{
setTitle("Hello Swing 2");
setSize(500, 300);
setDefaultCloseOperation(EXIT_ON_CLOSE);
addListeners();
createWindow();
setVisible(true);
}

private void createWindow()
{
JPanel panel = new JPanel(new BorderLayout(0, 10));
panel.setBorder(new EmptyBorder(10, 10, 10, 10));

panel.add(createTop(), BorderLayout.NORTH);
panel.add(createBottom(), BorderLayout.SOUTH);
panel.add(createCenter());
add(panel);
}

private JPanel createTop()
{
JPanel panel = new JPanel(new BorderLayout(10, 10));
JLabel label = new JLabel("Enter a name");
panel.add(label, BorderLayout.WEST);
panel.add(cmdAdd, BorderLayout.EAST);
panel.add(txtName);
return panel;
}

private JPanel createCenter()
{
lstNames = new JList(model);
JPanel panel = new JPanel(new BorderLayout());

panel.add(new JScrollPane(lstNames));
return panel;
}

private JPanel createBottom()
{
JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
cmdCount.setPreferredSize(new Dimension(80, 27));
cmdClr.setPreferredSize(new Dimension(80, 27));
panel.add(cmdCount); // Count 버튼 추가
panel.add(cmdClr);
return panel;
}

private void addListeners()
{
cmdAdd.addActionListener(new AddAction());
cmdCount.addActionListener(new CountAction()); // Count 버튼 눌렀을 때
cmdClr.addActionListener(new ActionListener() // 삭제 확인
{
public void actionPerformed(ActionEvent e)
{
if (JOptionPane.showConfirmDialog(MainWindow.this, 
		"Are you sure you want to delete the list?", 
		"Warning", JOptionPane.YES_NO_OPTION, 
		JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) 
	model.clear();
}
});
}

class AddAction implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
String name = txtName.getText().trim();
if (name.length() > 0)
{
model.addElement(name);
txtName.setText("");
txtName.requestFocus();
}
}
}

class CountAction implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
JOptionPane.showMessageDialog(MainWindow.this, 
		"You have entered " + model.getSize() + 
		" names", "Message", JOptionPane.INFORMATION_MESSAGE);
}
}

}

