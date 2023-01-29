package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainView extends JFrame implements CloseListener
{
private DefaultListModel model = new DefaultListModel();
private JButton cmdShow;

public MainView()
{
setTitle("Dialogs");
setSize(200, 160);
setResizable(false);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
createWindow();
setVisible(true);
}

private void createWindow()
{
JPanel panel = new JPanel(new GridLayout(2, 1, 0, 20));
panel.setBorder(new EmptyBorder(20, 20, 20, 20));
panel.add(createButton("Enter a name", this::openEnter));
panel.add(cmdShow = createButton("Open list", this::openShow));
add(panel);
}

private JButton createButton(String text, ActionListener listener)
{
JButton cmd = new JButton(text);
cmd.addActionListener(listener);
return cmd;
}

private void openEnter(ActionEvent e)
{
new EnterView(model);
}

private void openShow(ActionEvent e)
{
cmdShow.setEnabled(false);
new ShowView(model, this);
}

public void dialogClosed()
{
cmdShow.setEnabled(true);
}
}

interface CloseListener
{
	public void dialogClosed();
}
