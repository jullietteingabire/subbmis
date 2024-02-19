package allforms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import allobject.Flower;
import allobject.Manager;


public class ManagerForm implements ActionListener{
	
	JFrame Frame;
	JLabel id_lb=new JLabel("ID");
	JLabel mrname_lb=new JLabel("mrname");
	JLabel username_lb=new JLabel("username");
	JLabel telephone_lb=new JLabel("telephone_");
	JLabel email_lb=new JLabel("email");
	
	
	
	JTextField id_txf=new JTextField();
	JTextField mrname_txf=new JTextField();
	JTextField username_txf=new JTextField();
	JTextField telephone_txf=new JTextField();
	JTextField email_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new
	JButton("uptade");
	JButton delete_btn=new JButton("Delete");
	 JTable table = new JTable();

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	private JFrame frame;
	public ManagerForm() {
		createForm();
		setLocationSize();
		setFontforall();
		addcomponentforFrame();
		ActionEvent();
	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
	}
	private void createForm() {
			frame=new JFrame();
			frame.setTitle("ManagerForm");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.WHITE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_lb.setBounds(10,10,100,30);
				mrname_lb.setBounds(10,50,100,30);
				 username_lb.setBounds(10,90,100,30);
				 telephone_lb.setBounds(10,130,130,30);
				 email_lb.setBounds(10,170,100,30);
				
				id_txf.setBounds(160,10,130,30);
				mrname_txf.setBounds(160,50,130,30);
				username_txf.setBounds(160,90,130,30);
				telephone_txf.setBounds(160,130,130,30);
				email_txf.setBounds(160,170,130,30);
				
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				 table.setBounds(10, 330, 480, 200);

			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_lb.setFont(font);
			mrname_lb.setFont(font);
			username_lb.setFont(font);
			telephone_lb.setFont(font);
			email_lb.setFont(font);
			
			
			id_txf.setFont(font);
			mrname_txf.setFont(font);
			username_txf.setFont(font);
			telephone_txf.setFont(font);
			email_txf.setFont(font);
			
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_lb);
			frame.add(mrname_lb);
			frame.add(username_lb);
			frame.add(telephone_lb);
			frame.add(email_lb);
			
			
			frame.add(id_txf);
			frame.add(mrname_txf);
			frame.add(username_txf);     
			frame.add(telephone_txf);
			frame.add(email_txf);
			frame.add(table);
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
				
	
		}

	
	
@Override
public void actionPerformed(ActionEvent e) {
	    Manager mr=new Manager();
	    
		if(e.getSource()==insert_btn) {
			mr.setMrname(mrname_txf.getText());
			mr.setUsername(username_txf.getText());
			mr.setTelephone(telephone_txf.getText());
			mr.setEmail(email_txf.getText());
			
		    mr.insertData();
		}else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel=mr.populateTable();
			table.setModel(tableModel);

            
		    }else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(id_txf.getText());
			mr.setMrname(mrname_txf.getText());
			mr.setUsername(username_txf.getText());
			mr.setTelephone(telephone_txf.getText());
			mr.setEmail(email_txf.getText());
			
			mr.update(id);
			} else {
			int id=Integer.parseInt(id_txf.getText());
			mr.delete(id);}

            }
	public static void main(String[] args) {
	ManagerForm mr= new ManagerForm();
	System.out.println(mr);

}
}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
