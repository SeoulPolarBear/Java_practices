package dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ShowView extends JDialog
{
private DefaultListModel model;
private CloseListener listener;

public ShowView(DefaultListModel model, CloseListener listener)
{
super(null, "Names", Dialog.ModalityType.MODELESS);
this.model = model;
this.listener = listener;
setSize(400, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
addWindowListener(new ClosingHandler());
createView();
setVisible(true);
}

private void createView()
{
setLayout(new BorderLayout());
JPanel panel = new JPanel(new BorderLayout(0, 20));
panel.setBorder(new EmptyBorder(20, 20, 20, 20));
panel.add(new JScrollPane(new JList(model)));
panel.add(createBottom(), BorderLayout.SOUTH);
add(panel);
}

private JPanel createBottom()
{
JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
panel.add(createButton("Close", 90, 25, this::close));
return panel;
}

private JButton createButton(String text, int width, int height, ActionListener listener)
{
JButton cmd = new JButton(text);
cmd.addActionListener(listener);
cmd.setPreferredSize(new Dimension(width, height));
return cmd;
}

private void close(ActionEvent e)
{
listener.dialogClosed();
dispose();
}

class ClosingHandler extends WindowAdapter
{
public void windowClosing(WindowEvent e)
{
listener.dialogClosed();
}
}
}
