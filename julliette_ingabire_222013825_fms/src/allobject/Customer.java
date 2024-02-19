package allobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.Spring;
import javax.swing.table.DefaultTableModel;

public class Customer {
	private int id;
	private String  cname ;
	private String address;
	private String email;
	private String gender;
	

	 
	public Customer (int Customer_id,String cname,String address , String email, String gender) {
		super();
		this.id=id;
		this.cname=cname;
		this.address=address;
		this.email=email; 
		this.gender=gender;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/julliette_ingabire_fms";
	    String user = "222013825";
	    String password = "222013825";

	    // SQL query to insert data
	    String sql = "INSERT INTO Customers(	Customername,Email, Address,Gender) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection cone = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = cone.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.cname);
	       preparedStatement.setString(2, this.email);
	       preparedStatement.setString(3, this.address);
	       preparedStatement.setString(4, this.gender);
	  
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data registered successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	public void readwithID(int inputCustomer_id ) {
		// JDBC URL,username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/julliette_ingabire_fms";
	    String user = "222013825";
	    String password = "222013825";

	    // SQL query to select all columns from student where id = ?
	    String sql = "SELECT * FROM Customers WHERE Customer_id = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //int studentId = 1; // Replace with the desired student id
	        //if()
	    	preparedStatement.setInt(1, inputCustomer_id );

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	           this.setId(resultSet.getInt("Customer_id"));
	           this.setCname(resultSet.getString("cname"));
	           this.setAddress(resultSet.getString("address"));
	           this.setEmail(resultSet.getString("email"));
	           this.setGender(resultSet.getString("gender"));
	           System.out.println( ",Customer_id: " + id + ", Customername: " + cname+ ", Email: " + email + ", Address: " + address+ ", Gender: " +gender );
	            JOptionPane.showMessageDialog(null, "Data are displayed!","After displayed",JOptionPane.INFORMATION_MESSAGE);
	    
	         
	            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void delete(int inputid) {
		// JDBC URL, username, and password of MySQL server
		String url = "jdbc:mysql://localhost/julliette_ingabire_fms";
		String user = "222013825";
		String password = "222013825";

		// SQL query to delete data
		String sql = "DELETE FROM  Manager WHERE Manager_Id = ?";

		try (
		// Establish the 
		Connection co = DriverManager.getConnection(url, user, password);

		// Create a prepared statement
		PreparedStatement pl = co.prepareStatement(sql);
		) {
		// Set the value for the WHERE clause
		pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

		// Execute the delete
		int rowsAffected = pl.executeUpdate();

		// Check the result
		if (rowsAffected > 0) {
		    System.out.println("Data deleted successfully!");
		    JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
		} else {
		    System.out.println("Failed to delete data. No matching record found.");
		    JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
		}

		} catch (SQLException e) {
		e.printStackTrace();
		}}


		public DefaultTableModel populateTable() {
			 String host = "jdbc:mysql://localhost/julliette_ingabire_fms";
		     String user = "222013825";
		     String password = "222013825";
		     String query= "SELECT * FROM customers";
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
		 

		}




	public void update(int inputCustomer_id){
		// JDBC URL,username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/julliette_ingabire_fms";
	    String cname = "222013825";
	    String address = "222013825";

	    // SQL query to update data
	    String sql = "UPDATE Customers SET  Customername= ?, Address = ?,Email = ?,Gender = ?  WHERE Customer_id = ?";

	    try (
	        // Establish the cone
	        Connection cone = DriverManager.getConnection(url, cname, address);

	        // Create a prepared statement
	        PreparedStatement Customers = cone.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	Customers.setString(1, this.getCname());
	        Customers.setString(2, this.getAddress());
	        Customers.setString(3, this.getEmail());
	        Customers.setString(4, this.getGender());
	        Customers.setInt(5, inputCustomer_id);
	       
	       // Assuming there is a column named 'id' for the WHERE clause
	       
	        
	       
	        // Execute the update
	        int rowsAffected = Customers.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Data updated fail!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	
	}
	





