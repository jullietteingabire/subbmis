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

import allobject.Manager;
import allobject.Stock;


public class StockForm implements ActionListener{
	JFrame Frame;
	JLabel id_lb=new JLabel("ID");
	JLabel ProductName_lb=new JLabel("ProductName");
	JLabel UnitPrice_lb=new JLabel("UnitPrice");
	JLabel DateReceived_lb=new JLabel("DateReceived_");
	JLabel QuantityAvailable_lb=new JLabel("QuantityAvailable_");
	
	
	
	JTextField id_txf=new JTextField();
	JTextField  ProductName_txf=new JTextField();
	JTextField UnitPrice_txf=new JTextField();
	JTextField DateReceived_txf=new JTextField();
	JTextField QuantityAvailable_txf=new JTextField();
	
	
	
	
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
	public StockForm() {
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
			frame.setTitle("StockForm");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.ORANGE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_lb.setBounds(10,10,100,30);
				ProductName_lb.setBounds(10,50,100,30);
				 UnitPrice_lb.setBounds(10,90,100,30);
				DateReceived_lb.setBounds(10,130,100,30);
				QuantityAvailable_lb.setBounds(10,170,100,30);
				 
				
				id_txf.setBounds(160,10,130,30);
				ProductName_txf.setBounds(160,50,130,30);
				UnitPrice_txf.setBounds(160,90,130,30);
				DateReceived_txf.setBounds(160,130,130,30);
				QuantityAvailable_txf.setBounds(160,170,130,30);
				
				
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				table.setBounds(10, 330, 480, 200);
				
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_lb.setFont(font);
			ProductName_lb.setFont(font);
			UnitPrice_lb.setFont(font);
			DateReceived_lb.setFont(font);
			QuantityAvailable_lb.setFont(font);
			
			
			
			id_txf.setFont(font);
			ProductName_txf.setFont(font);
			UnitPrice_txf.setFont(font);
			DateReceived_txf.setFont(font);
			QuantityAvailable_txf.setFont(font);
			
			
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_lb);
			frame.add(ProductName_lb);
			frame.add(UnitPrice_lb);
			frame.add(DateReceived_lb);
			frame.add(QuantityAvailable_lb);
			
			
			
			frame.add(id_txf);
			frame.add(ProductName_txf);
			frame.add(UnitPrice_txf); 
			frame.add(DateReceived_txf); 
			frame.add(QuantityAvailable_txf); 
			frame.add(table);
			
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
				
	
		}
	
	
	
	
	
	

@Override
public void actionPerformed(ActionEvent e) {
	    Stock st=new Stock();
		if(e.getSource()==insert_btn) {
			st.setProductName(ProductName_txf.getText());
			st.setUnitPrice(UnitPrice_txf.getText());
			st.setDateReceived(DateReceived_txf.getText());
			st.setQuantityAvailable(QuantityAvailable_txf.getText());
			
		    st.insertData();
		}
else if ((e.getSource()==Read_btn)) {
	DefaultTableModel tableModel= st.populateTable();
	table.setModel(tableModel);

            
}else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(id_txf.getText());
			st.setProductName(ProductName_txf.getText());
			st.setUnitPrice(UnitPrice_txf.getText());
			st.setDateReceived(DateReceived_txf.getText());
			st.setQuantityAvailable(QuantityAvailable_txf.getText());
			
			st.update(id);
			} else {
			int id=Integer.parseInt(id_txf.getText());
			st.delete(id);}

            }
	public static void main(String[] args) {
	StockForm mr= new StockForm();
	System.out.println(mr);

}
}


		
	
	
	
	
	
	
	
	
	
	
	
	
	

	