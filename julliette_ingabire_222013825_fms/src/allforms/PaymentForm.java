package allforms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import allobject.Manager;
import allobject.Payment;

public  class PaymentForm implements ActionListener {

	JFrame Frame;
	JLabel id_lb=new JLabel("ID");
	JLabel Amaunt_lb=new JLabel("amaunt");
	JLabel PaymentDate_lb=new JLabel("PaymentDate");
	JLabel PaymentMethod_lb=new JLabel("PaymentMethod_");
	
	
	
	JTextField id_txf=new JTextField();
	JTextField  Amaunt_txf=new JTextField();
	JTextField PaymentDate_txf=new JTextField();
	JTextField PaymentMethod_txf=new JTextField();
	
	
	
	
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
	public PaymentForm() {
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
			frame.setTitle("PaymentrForm");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.PINK);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_lb.setBounds(10,10,100,30);
				Amaunt_lb.setBounds(10,50,100,30);
				 PaymentDate_lb.setBounds(10,90,130,30);
				 PaymentMethod_lb.setBounds(10,130,130,30);
				 
				
				id_txf.setBounds(160,10,130,30);
				Amaunt_txf.setBounds(160,50,130,30);
				PaymentDate_txf.setBounds(160,90,130,30);
				PaymentMethod_txf.setBounds(160,160,130,30);
				
				
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				 table.setBounds(10, 330, 480, 200);

			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_lb.setFont(font);
			Amaunt_lb.setFont(font);
			PaymentMethod_lb.setFont(font);
			PaymentDate_lb.setFont(font);
			
			
			
			id_txf.setFont(font);
			Amaunt_txf.setFont(font);
			PaymentDate_txf.setFont(font);
			PaymentMethod_txf.setFont(font);
			
			
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_lb);
			frame.add(Amaunt_lb);
			frame.add(PaymentDate_lb);
			frame.add(PaymentMethod_lb);
			
			
			
			frame.add(id_txf);
			frame.add(Amaunt_txf);
			frame.add(PaymentDate_txf);     
			frame.add(PaymentMethod_txf);
			frame.add(table);
			
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
				
	
		}
	

@Override

public void actionPerformed(ActionEvent e){
	    Payment py=new Payment();
	    
		if(e.getSource()==insert_btn) {
			py.setAmaunt(Amaunt_txf.getText());
			py.setPaymentDate(PaymentDate_txf.getText());
			py.setPaymentMethod(PaymentMethod_txf.getText());
			
			
			
			
		    py.insertData();
		    }else if ((e.getSource()==Read_btn)) {
				DefaultTableModel tableModel=py.populateTable();
				table.setModel(tableModel);

		    }else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(id_txf.getText());
			py.setAmaunt(Amaunt_txf.getText());
			py.setPaymentDate(PaymentDate_txf.getText());
			py.setPaymentMethod(PaymentMethod_txf.getText());
			
			
			
			py.update(id);
			} else {
			int id=Integer.parseInt(id_txf.getText());
			py.delete(id);}

            }
	public static void main(String[] args) {
	PaymentForm Py= new PaymentForm();
	System.out.println(Py);

	}
public DefaultTableModel populateTable() {
	 String host = "jdbc:mysql://localhost/flowers_management_system";
    String user = "root";
    String password = "";
    String query= "SELECT * FROM payment";
    DefaultTableModel tableModel = null;

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement stm = con.prepareStatement(query);
        ResultSet resultSet = stm.executeQuery();

        int columnCount = resultSet.getMetaData().getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(resultSet.getMetaData().getColumnName(i));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getObject(i));
            }
            data.add(row);
        }

        tableModel = new DefaultTableModel(data, columnNames);
        con.close(); // Close the connection when done to release resources
    } catch (Exception e) {
        e.printStackTrace(); // Print the exception details for debugging purposes
    }
    return tableModel;


}}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	