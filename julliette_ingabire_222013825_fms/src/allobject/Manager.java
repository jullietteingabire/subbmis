package allobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Manager {
	private int id;
	private String mrname ;
	private String username;
	private String telephone;
	private String email;
	
	
	public  Manager(int id, String mrname, String username, String telephone,String email) {
		super();
		this. id=id;
		this.mrname =mrname;
		this.username=username;
		this.telephone=telephone;
		this.email=email; 
		
	}


	public Manager() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getmrname() {
		return mrname;
	}


	public void setMrname(String mrname) {
		this.mrname = mrname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/julliette_ingabire_fms";
String user = "222013825";
String password = "222013825";

// SQL query to insert dataFirst_Name
String sql = "INSERT INTO Manager ( Manager_name, username, Telephone,Email) VALUES (?,?,?,?)";

try (
// Establish the connection
Connection cone = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = cone.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this.mrname);
preparedStatement.setString(2, this.username);
preparedStatement.setString(3, this.telephone);
preparedStatement.setString(4, this.email);

// Execute the query
int rowsAffected = preparedStatement.executeUpdate();

// Check the result
if (rowsAffected > 0) {
	System.out.println("Data inserted sucessfully");
    JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
} else {
    System.out.println("Failed to insert data.");
    JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

}

} catch (SQLException e) {
e.printStackTrace();
}	
}

public void update(int inputid) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/julliette_ingabire_fms";
String user = "222013825";
String password = "222013825";

// SQL query to update data

String sql = "UPDATE manager SET  Manager_name=?,username=?, Telephone=?, Email=? WHERE Manager_Id = ?";

try (
// Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement mr = co.prepareStatement(sql);
) {
// Set the new values for the update
 mr.setString(1, this.getmrname());
 mr.setString(2, this.getUsername());
 mr.setString(3, this.getTelephone());
 mr.setString(4, this.getEmail());
 mr.setInt(5, inputid);

// Execute the update
int rowsAffected = mr.executeUpdate();

// Check the result
if (rowsAffected > 0) {
    System.out.println("Data updated successfully!");
    JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
} else {
    System.out.println("Failed to update data. No matching record found.");
    JOptionPane.showMessageDialog(null, "Failed to update data!","After update",JOptionPane.INFORMATION_MESSAGE);
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
     String query= "SELECT * FROM manager";
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



