import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

	public class MainWindow extends JFrame
	{
	private JTextField txtName = new JTextField(); // �Է� �ʵ�
	private JButton cmdAdd = new JButton("Add"); // ��ư
	private JButton cmdClr = new JButton("Clear"); // ��ư
	private JList lstNames; // ����Ʈ �ڽ�
	private DefaultListModel model = new DefaultListModel(); // ��jƮ ����Ʈ �� 12.

	
	public MainWindow()
	{
	setTitle("Hello Swing 2"); // ����
	setSize(500, 300); // ũ��
	setDefaultCloseOperation(EXIT_ON_CLOSE); // ����
	addListeners(); // ��ư�� ���� ����� ����
	createWindow(); // ������Ʈ�� �����쿡 ��ġ
	setVisible(true); // �����츦 ȭ�鿡 ǥ��
	}

	private void createWindow()
	{
	add(createLabel(), BorderLayout.NORTH); // ��
	add(createLabel(), BorderLayout.WEST); // ��
	add(createLabel(), BorderLayout.EAST); // ��
	add(createLabel(), BorderLayout.SOUTH); // ��
	JPanel panel = new JPanel(new BorderLayout(0,10)); // ��� ����, ���̾ƿ� ����
	panel.setBorder(new EmptyBorder(10,10,10,10));
	panel.add(createTop(), BorderLayout.NORTH);
	panel.add(createBottom(), BorderLayout.SOUTH);
	panel.add(createCenter());
	add(panel); // �г��� �߾ӿ� ��ġ
	}
   private JLabel createLabel()
   {
	   JLabel label = new JLabel("");
	   label.setPreferredSize(new Dimension(10,10));
	   return label;
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
   lstNames = new JList(model); // ����Ʈ �ڽ��� ������ �� ����
   JPanel panel = new JPanel(new BorderLayout());
   panel.add(createLabel(), BorderLayout.NORTH);
   panel.add(createLabel(), BorderLayout.SOUTH);
   panel.add(new JScrollPane(lstNames)); // ��ũ�� �гη� ������ ��ũ��
   return panel;
   }

   private JPanel createBottom()
   {
	   JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	   cmdClr.setPreferredSize(new Dimension(80, 27));
	   panel.add(cmdClr);
	   return panel;

   }
   
   private void addListeners()
   {
   cmdAdd.addActionListener(new AddAction()); // Add ��ư ������ ��
   cmdClr.addActionListener(new ActionListener() // Clear ��ư ������ ��
   {
   public void actionPerformed(ActionEvent e)
   {if (JOptionPane.showConfirmDialog(MainWindow.this
		   ,"Are you sure you want to delete the list?"
		   , "Warning", JOptionPane.YES_NO_OPTION
		   , JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
	   
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
 }
