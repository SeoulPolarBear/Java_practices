import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

	public class MainWindow extends JFrame
	{
	private JTextField txtName = new JTextField(); // 입력 필드
	private JButton cmdAdd = new JButton("Add"); // 버튼
	private JButton cmdClr = new JButton("Clear"); // 버튼
	private JList lstNames; // 리스트 박스
	private DefaultListModel model = new DefaultListModel(); // 디퐅트 리스트 모델 12.

	
	public MainWindow()
	{
	setTitle("Hello Swing 2"); // 제목
	setSize(500, 300); // 크기
	setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료
	addListeners(); // 버튼에 대한 기능을 배정
	createWindow(); // 콤포넌트를 윈도우에 배치
	setVisible(true); // 윈도우를 화면에 표시
	}

	private void createWindow()
	{
	add(createLabel(), BorderLayout.NORTH); // 북
	add(createLabel(), BorderLayout.WEST); // 서
	add(createLabel(), BorderLayout.EAST); // 동
	add(createLabel(), BorderLayout.SOUTH); // 남
	JPanel panel = new JPanel(new BorderLayout(0,10)); // 페널 생성, 레이아웃 가짐
	panel.setBorder(new EmptyBorder(10,10,10,10));
	panel.add(createTop(), BorderLayout.NORTH);
	panel.add(createBottom(), BorderLayout.SOUTH);
	panel.add(createCenter());
	add(panel); // 패널을 중앙에 위치
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
   lstNames = new JList(model); // 리스트 박스에 데이터 모델 배정
   JPanel panel = new JPanel(new BorderLayout());
   panel.add(createLabel(), BorderLayout.NORTH);
   panel.add(createLabel(), BorderLayout.SOUTH);
   panel.add(new JScrollPane(lstNames)); // 스크롤 패널로 내용을 스크롤
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
   cmdAdd.addActionListener(new AddAction()); // Add 버튼 눌렀을 때
   cmdClr.addActionListener(new ActionListener() // Clear 버튼 눌렀을 때
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
