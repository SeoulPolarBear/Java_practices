import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainWindow extends JFrame
{
private JTextField txtNum1 = new JTextField();
private JTextField txtNum2 = new JTextField();

private JButton cmdAdd = new JButton("+");
private JButton cmdSub = new JButton("-");
private JButton cmdMul = new JButton("*");
private JButton cmdDiv = new JButton("/");
private JButton cmdClr = new JButton("Clear");
private JList lstRes;
private DefaultListModel model = new DefaultListModel();

public MainWindow()
{
setTitle("Calculator");
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
panel.add(createRight(), BorderLayout.EAST);
panel.add(createLeft());
return panel;
}

private JPanel createLeft()
{
JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
panel.add(txtNum1);
panel.add(txtNum2);
return panel;
}

private JPanel createRight()
{
JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
initButton(cmdAdd);
initButton(cmdSub);
initButton(cmdMul);
initButton(cmdDiv);
panel.add(cmdAdd);
panel.add(cmdSub);
panel.add(cmdMul);
panel.add(cmdDiv);
return panel;
}

private JPanel createCenter()
{
lstRes = new JList(model);
JPanel panel = new JPanel(new BorderLayout());
panel.add(new JScrollPane(lstRes));
return panel;

}

private JPanel createBottom()
{
JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
panel.add(cmdClr, BorderLayout.EAST);
return panel;
}

private void initButton(JButton cmd)
{
cmd.setPreferredSize(new Dimension(29, 29));
cmd.setFont(new Font("Liberation Sherif", Font.PLAIN, 16));
cmd.setMargin(new Insets(0, 0, 0, 0));
}

private void calculate(char ch)
{
try
{
double tal1 = Double.parseDouble(txtNum1.getText());
double tal2 = Double.parseDouble(txtNum2.getText());
double res = 0;
switch (ch)
{
case '+': res = tal1 + tal2; break;
case '-': res = tal1 - tal2; break;
case '*': res = tal1 * tal2; break;
case '/': res = tal1 / tal2; break;
}
model.addElement(String.format("%f %s %f = %f", tal1, "" + ch, tal2, res));
}
catch (Exception ex)
{
model.addElement(ex.toString());
}
txtNum1.setText("");
txtNum2.setText("");
txtNum1.requestFocus();
}

private void addListeners()
{
cmdClr.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
model.clear();
}
});
cmdAdd.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
calculate('+');
}
});
cmdSub.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
calculate('-');
}
});

cmdMul.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
calculate('*');
}
});
cmdDiv.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
calculate('/');
}
});
}
}


