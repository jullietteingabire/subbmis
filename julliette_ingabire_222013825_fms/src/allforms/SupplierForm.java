package allforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import allobject.Stock;
import allobject.supplier;

public class SupplierForm implements ActionListener {
	
	JFrame Frame;
	JLabel id_lb=new JLabel("ID");
	JLabel SupplierName_lb=new JLabel("SupplierName");
	JLabel Telephone_lb=new JLabel("Telephone");
	JLabel Email_lb=new JLabel("Email_");
	
	
	
	
	JTextField id_txf=new JTextField();
	JTextField SupplierName_txf=new JTextField();
	JTextField Telephone_txf=new JTextField();
	JTextField Email_txf=new JTextField();
	
	
	
	
	
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
	public SupplierForm() {
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
			frame.setTitle("SupplierForm");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.CYAN);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_lb.setBounds(10,10,100,30);
				SupplierName_lb.setBounds(10,50,100,30);
				 Telephone_lb.setBounds(10,90,100,30);
				Email_lb.setBounds(10,130,100,30);
								 
				
				id_txf.setBounds(160,10,130,30);
				SupplierName_txf.setBounds(160,50,130,30);
				 Telephone_txf.setBounds(160,90,130,30);
				 Email_txf.setBounds(160,130,130,30);
				
				
				
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				table.setBounds(10, 330, 480, 200);
				
				
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_lb.setFont(font);
			SupplierName_lb.setFont(font);
			 Telephone_lb.setFont(font);
			 Email_lb.setFont(font);
			
			
			
			id_txf.setFont(font);
			SupplierName_txf.setFont(font);
			Telephone_txf.setFont(font);
			 Email_txf.setFont(font);
			
			
			
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_lb);
			frame.add(SupplierName_lb);
			frame.add(Telephone_lb);
			frame.add(Email_lb);
			
			
			
			
			frame.add(id_txf);
			frame.add( SupplierName_txf);
			frame.add(Telephone_txf); 
			frame.add(Email_txf); 
			frame.add(table);
			
			
			
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
				
	
		}
	
	
	
	
@Override
public void actionPerformed(ActionEvent e) {
	    supplier sp=new supplier();
		if(e.getSource()==insert_btn) {
			sp.setSupplierName(SupplierName_txf.getText());
			sp.setTelephone(Telephone_txf.getText());
			sp.setEmail(Email_txf.getText());
		
		    sp.insertData();
		
		}else if ((e.getSource()==Read_btn)) {
			DefaultTableModel tableModel= sp.populateTable();
			table.setModel(tableModel);

		
		}else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(id_txf.getText());
			sp.setSupplierName(SupplierName_txf.getText());
			sp.setTelephone(Telephone_txf.getText());
			sp.setEmail(Email_txf.getText());
			
			
			sp.update(id);
			} else {
			int id=Integer.parseInt(id_txf.getText());
			sp.delete(id);}

            }
	public static void main(String[] args) {
	SupplierForm sp= new SupplierForm();
	System.out.println(sp);

}
}


