package allobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Payment {
	private int id;
	private String Amaunt ;
	private String PaymentDate ;
	private String PaymentMethod;
	
	
	public  Payment(int id, String Amaunt, String PaymentMethod,String PaymentDate) {
		super();
		this. id=id;
		this.Amaunt =Amaunt;
		this.PaymentDate=PaymentDate;
		this.PaymentMethod=PaymentMethod; 
		
	}


	



public Payment() {
		// TODO Auto-generated constructor stub
	}






public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getAmaunt() {
		return Amaunt;
	}






	public void setAmaunt(String amaunt) {
		Amaunt = amaunt;
	}






	public String getPaymentDate() {
		return PaymentDate;
	}






	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}






	public String getPaymentMethod() {
		return PaymentMethod;
	}






	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}






public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/julliette_ingabire_fms";
String user = "222013825";
String password = "222013825";

// SQL query to insert dataFirst_Name
String sql = "INSERT INTO Payment ( Amaunt, PaymentDate, PaymentMethod) VALUES (?,?,?)";

try (
// Establish the connection
Connection cone = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = cone.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this. Amaunt);
preparedStatement.setString(2, this. PaymentDate);
preparedStatement.setString(3, this. PaymentMethod );


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
public DefaultTableModel populateTable() {
	 String host = "jdbc:mysql://localhost/julliette_ingabire_fms";
    String user = "222013825";
    String password = "222013825";
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


}




public void update(int inputid) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/julliette_ingabire_fms";
String user = "222013825";
String password = "222013825";

// SQL query to update data

String sql = "UPDATE Payment SET  Amaunt=?, PaymentDate=?, PaymentMethod=? WHERE Payment_Id = ?";

try (
// Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement st = co.prepareStatement(sql);
) {
// Set the new values for the update
 st.setString(1, this.getAmaunt());
st.setString(2, this.getPaymentDate());
 st.setString(3, this.getPaymentMethod());
 
 
 // Assuming there is a column named 'id' for the WHERE clause
 
 st.setInt(4, inputid);

// Execute the update
int rowsAffected = st.executeUpdate();

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
String sql = "DELETE FROM  Payment WHERE Payment_Id = ?";

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







	
	
}

