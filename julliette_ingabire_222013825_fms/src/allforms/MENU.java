package allforms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MENU implements ActionListener {
	JFrame frame;
	JMenu home, customers, flower,manager,payment,stock,supplier, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,customersDelete,customersUpdate,customersRead;
	JMenuItem flowerDelete,flowerUpdate,flowerRead;
	JMenuItem managerDelete,managerUpdate,managerRead;
	JMenuItem paymentDelete,paymentUpdate,paymentRead;
	JMenuItem stockDelete,stockUpdate,stockRead;
	JMenuItem supplierDelete,supplierUpdate,supplierRead;
	
	
	MENU (){
		createWindow();
	}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		customers = new JMenu("customers");
		flower= new JMenu("flower");
		manager = new JMenu("manager");
		payment=new JMenu("payment");
		stock=new JMenu("stock");
		supplier=new JMenu("supplier");

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		customersRead = new JMenuItem("Read");
		customersUpdate = new JMenuItem("Update");
		customersDelete = new JMenuItem("Delete");
		customers.add(customersRead);
		customers.add(customersUpdate);
		customers.add(customersDelete);

		flowerRead =new JMenuItem("Read");
		flowerUpdate =new JMenuItem("Update");
		flowerDelete =new JMenuItem("Delete");
		
		flower.add(flowerRead);
		flower.add(flowerUpdate);
		flower.add(flowerDelete);
		
		managerRead =new JMenuItem("Read");
		managerUpdate =new JMenuItem("Update");
		managerDelete =new JMenuItem("Delete");
		manager.add(managerRead);
		manager.add(managerUpdate);
		manager.add(managerDelete);
		
		paymentRead =new JMenuItem("Read");
		paymentUpdate =new JMenuItem("Update");
		paymentDelete =new JMenuItem("Delete");
		payment.add(paymentRead);
		payment.add(paymentUpdate);
		payment.add(paymentDelete);
		
		stockRead =new JMenuItem("Read");
		stockUpdate =new JMenuItem("Update");
		stockDelete =new JMenuItem("Delete");
		stock.add(stockRead);
		stock.add(stockUpdate);
		stock.add(stockDelete);
		
		supplierRead =new JMenuItem("Read");
		supplierUpdate =new JMenuItem("Update");
		supplierDelete =new JMenuItem("Delete");
		supplier.add(supplierRead);
		supplier.add(supplierUpdate);
		supplier.add(supplierDelete);
		
		
		

		

		mb.add(home);
		mb.add(customers);
		mb.add(flower);
		mb.add(manager);
		mb.add(payment);
		mb.add(stock);
		mb.add(supplier);
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		customers = new JMenu("customers");
		flower = new JMenu("flower");
		manager =new JMenu("manager");
		payment =new JMenu("payment");
		stock=new JMenu("stock");
		supplier =new JMenu("supplier");
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		customers.add(i2);
		customers.add(i3);
		customers.add(i4);
		flower.add(i2);
		flower.add(i3);
		flower.add(i4);
		manager.add(i2);
		manager.add(i3);
		manager.add(i4);
		payment.add(i2);
		payment.add(i3);
		payment.add(i4);
		stock.add(i2);
		stock.add(i3);
		stock.add(i4);
		supplier.add(i2);
		supplier.add(i3);
		supplier.add(i4);
		addactionEvent();

		
		
	}
	private void addactionEvent() {
		customersRead.addActionListener(this);
		flowerRead.addActionListener(this);
		managerRead.addActionListener(this);
		paymentRead.addActionListener(this);
		stockRead.addActionListener(this);
		supplierRead.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new MENU();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==customersRead) {
			Customerform pf=new Customerform();
			frame.dispose();
		}else if (e.getSource()==flowerRead) {
			FlowerForm df=new FlowerForm();
			frame.dispose();
		}else if (e.getSource()==managerRead) {
			ManagerForm nf=new ManagerForm();
			frame.dispose();
		}else if (e.getSource()==paymentRead) {
			PaymentForm py=new PaymentForm();
			frame.dispose();
			}else if (e.getSource()==stockRead) {
				StockForm af=new StockForm();
				frame.dispose();
				}else if (e.getSource()==supplierRead) {
					SupplierForm sf=new SupplierForm ();
					frame.dispose();
	}

}



}
