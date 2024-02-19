package allforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import allobject.Customer;
import allobject.Flower;

public class FlowerForm implements ActionListener{
	
	JFrame Frame;
	JLabel id_lb=new JLabel("ID");
	JLabel Flower_type_lb=new JLabel("Flower_type");
	JLabel Unit_price_lb=new JLabel("Unit_price");
	JLabel Quantity_lb=new JLabel("Quantity");
	
	
	JTextField id_txf=new JTextField();
	JTextField Flower_type_txf=new JTextField();
	JTextField Unit_price_txf=new JTextField();
	JTextField Quantity_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new
	JButton("uptade");
	JButton delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	private JFrame frame;
	public FlowerForm() {
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
			frame.setTitle("FlowerForm");
			frame.setBounds(0,0,600,600);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.GREEN);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_lb.setBounds(10,10,100,30);
				Flower_type_lb.setBounds(10,50,120,30);
				Unit_price_lb.setBounds(10,90,120,30);
				Quantity_lb.setBounds(10,130,100,30);
				
				
				id_txf.setBounds(160,10,130,30);
				Flower_type_txf.setBounds(160,50,130,30);
				Unit_price_txf.setBounds(160,90,130,30);
				Quantity_txf.setBounds(160,130,130,30);
				
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				
		        table.setBounds(10, 330, 480, 200);


				
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_lb.setFont(font);
			Flower_type_lb.setFont(font);
			Unit_price_lb.setFont(font);
			Quantity_lb.setFont(font);
			
			
			id_txf.setFont(font);
			Flower_type_txf.setFont(font);
			Unit_price_txf.setFont(font);
			Quantity_txf.setFont(font);
			
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_lb);
			frame.add(Flower_type_lb);
			frame.add(Unit_price_lb);
			frame.add(Quantity_lb);
			
			
			frame.add(id_txf);
			frame.add(Flower_type_txf);
			frame.add(Unit_price_txf);     
			frame.add(Quantity_txf);
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
			
	        frame.add(table);
				
	
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		    Flower Fr=new Flower();
			if(e.getSource()==insert_btn) {
				Fr.setFlower_type(Flower_type_txf.getText());
				Fr.setUnit_price(Unit_price_txf.getText());
				Fr.setQuantity(Quantity_txf.getText());
				
			    Fr.insertData();
			    }else if ((e.getSource()==Read_btn)) {
					DefaultTableModel tableModel=Fr.populateTable();
					table.setModel(tableModel);

			    }else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(id_txf.getText());
				Fr.setFlower_type(Flower_type_txf.getText());
				Fr.setUnit_price(Unit_price_txf.getText());
				Fr.setQuantity(Quantity_txf.getText());
				
				Fr.update(id);
				}
                else {
				int id=Integer.parseInt(id_txf.getText());
				Fr.delete(id);}

                }
		public static void main(String[] args) {
		FlowerForm FlowerForm= new FlowerForm();
		System.out.println(FlowerForm);

}
}
		
