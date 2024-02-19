package allforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import allobject.Customer;

public class Customerform implements ActionListener{
	JFrame cname;
	//id;cname;address;email;gender;
	JLabel id_Ib=new JLabel("Custid");
	JLabel cname_Ib=new JLabel("Cusname");
	JLabel address_Ib=new JLabel("address");
	JLabel email_Ib=new JLabel("email");
	JLabel gender_Ib=new JLabel("gender");
	
	JTextField id_txf=new JTextField();
	JTextField cname_txf=new JTextField();
	JTextField address_txf=new JTextField();
	JTextField email_txf=new JTextField();
	String[]gender= {"Male","Female"};
	JComboBox<String>genderBox=new JComboBox<>(gender);
	
	
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
	public Customerform() {
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
			frame.setTitle("CustomerForm");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_Ib.setBounds(10,10,100,30);
				cname_Ib.setBounds(10,50,100,30);
				address_Ib.setBounds(10,90,100,30);
				email_Ib.setBounds(10,130,100,30);
				gender_Ib.setBounds(10,170,100,30);
				
				id_txf.setBounds(160,10,130,30);
				cname_txf.setBounds(160,50,130,30);
				address_txf.setBounds(160,90,130,30);
				email_txf.setBounds(160,130,130,30);
				genderBox.setBounds(160,170,130,30);
				//ButtonCRUD
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				 table.setBounds(10, 330, 480, 200);

			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_Ib.setFont(font);
			cname_Ib.setFont(font);
			address_Ib.setFont(font);
			email_Ib.setFont(font);
			gender_Ib.setFont(font);
			
			id_txf.setFont(font);
			cname_txf.setFont(font);
			address_txf.setFont(font);
			email_txf.setFont(font);
			genderBox.setFont(font);
			//Button CRUD
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_Ib);
			frame.add(cname_Ib);
			frame.add(address_Ib);
			frame.add(email_Ib);
			frame.add(gender_Ib);
			
			frame.add(id_txf);
			frame.add(cname_txf);
			frame.add(address_txf);     
			frame.add(genderBox);
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
			Customer cr= new Customer();
			if(e.getSource()==insert_btn) {
				cr.setCname(cname_txf.getText());
				cr.setAddress(address_txf.getText());
				cr.setEmail(email_txf.getText());
				String selectedOption =(String) genderBox.getSelectedItem();
				cr.setGender(selectedOption);
				cr.insertData();
			}else if ((e.getSource()==Read_btn)) {
				DefaultTableModel tableModel=cr.populateTable();
				table.setModel(tableModel);
			
			}else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(id_txf.getText());
				cr.setCname(cname_txf.getText());
				cr.setAddress(address_txf.getText());
				cr.setEmail(email_txf.getText());
				cr.setGender((String)genderBox.getSelectedItem());
				cr.update(id);
          
				}else {
				int id=Integer.parseInt(id_txf.getText());
				cr.delete(id);
	             }}
	
 public static void main(String[] args) {
		
	 Customerform cr= new Customerform();
		System.out.println(cr);
		
	}

 }



			
		




	


