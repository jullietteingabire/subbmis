package allobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Flower {
	private int id;
	private String Flower_type ;
	private String Unit_price;
	private String Quantity;
	
	
	
	public  Flower (int Flower_id,String Flower_type,String Unit_price,String Quantity) {
		super();
		this. id=id;
		this. Flower_type=Flower_type;
		this.Unit_price=Unit_price;
		this.Quantity=Quantity;
		}


public Flower() {
		// TODO Auto-generated constructor stub
	}


public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFlower_type() {
		return Flower_type;
	}


	public void setFlower_type(String flower_type) {
		Flower_type = flower_type;
	}


	public String getUnit_price() {
		return Unit_price;
	}


	public void setUnit_price(String unit_price) {
		Unit_price = unit_price;
	}


	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		Quantity = quantity;
	}


public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/julliette_ingabire_fms";
String user = "222013825";
String password = "222013825";

// SQL query to insert dataFirst_Name
String sql = "INSERT INTO Flower ( Flower_type, Unit_price, Quantity) VALUES (?,?,?)";

try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this. Flower_type);
preparedStatement.setString(2, this. Unit_price);
preparedStatement.setString(3, this. Quantity);

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

String sql = "UPDATE Flower SET  Flower_type=?, Unit_price=?, Quantity=? WHERE Flower_Id = ?";

try (
// Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement Fr = co.prepareStatement(sql);
) {
// Set the new values for the update
 Fr.setString(1, this.getFlower_type());
 Fr.setString(2, this.getUnit_price());
 Fr.setString(3, this.getQuantity()); // Assuming there is a column named 'id' for the WHERE clause
 
 Fr.setInt(4, inputid);

// Execute the update
int rowsAffected = Fr.executeUpdate();

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
String sql = "DELETE FROM  Flower WHERE Flower_Id = ?";

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
     String query= "SELECT * FROM flower";
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

}


