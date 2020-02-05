package com.electronic.storewithdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OperationsOnStoreInventory implements StoreInventoryDao {
	
	Connection connection;
	Scanner scanner;
	int srNo;
	    
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String dbUrl, dbUsername, dbPassword; 

		
	public OperationsOnStoreInventory() throws ClassNotFoundException, SQLException {
		scanner = new Scanner(System.in);
		dbUrl = "jdbc:mysql://127.0.0.1:3306/electronic_device_management";
		dbUsername = "root";
		dbPassword = "root";
		connection = getConnection();
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			return connection;
		}else {
			return connection;
		}		
	}
	
	@Override
	public void addItemInStoreInventory(StoreInventory inventory) throws SQLException, ClassNotFoundException {
		if(inventoryItemExists(inventory)) {
			updateItemsInInventory(inventory, this.srNo);
			this.srNo=0;
			return;
		}
		
		String query = "insert into inventory (item_name, make, model, count, price ) values (?, ?, ?, ?, ?)";
		
		preparedStatement = this.connection.prepareStatement(query);
		preparedStatement.setString(1, inventory.getItemName());
		preparedStatement.setString(2, inventory.getMake());
		preparedStatement.setString(3, inventory.getModel());
		preparedStatement.setInt(4, inventory.getNumbers());
		preparedStatement.setDouble(5, inventory.getPrice());
		
		preparedStatement.execute();
		
		System.out.println("Item successfully added in the Inventory of Store\n");
	}

	@Override
	public void updateItemsInInventory(StoreInventory inventory, int index) throws SQLException {		
		String query = "select * from inventory where sr_no='"+index+"';";
		ResultSet resultSet = this.connection.createStatement().executeQuery(query);
		resultSet.next();
		int count = inventory.getNumbers() + resultSet.getInt(5);
		
		query = "update inventory set count='"+count+"' AND price='"+inventory.getPrice()+"' where sr_no='"+this.srNo+"';";
		this.connection.createStatement().executeUpdate(query);

		
		System.out.println("Information of Item is successfully updated in the Inventory of Store\n");
	}

	@Override
	public void updateInventoryItemCount(int count, int index) throws SQLException {
		String query = "select * from inventory where sr_no='"+index+"';";
		ResultSet resultSet = this.connection.createStatement().executeQuery(query);
		resultSet.next();
		count = resultSet.getInt(5) - count;
		if(count > 0) {
			query = "update inventory set count='"+count+"' where sr_no='"+index+"';";
		}else {
			query = "delete from inventory where sr_no='"+index+"';";
		}
		
		this.connection.createStatement().executeUpdate(query);
		System.out.println("Information of Item is successfully updated in the Inventory of Store\n");

	}

	@Override
	public void deleteInventoryItem(int index) throws SQLException {
		String query = "delete from inventory where sr_no='"+srNo+"';";
		this.connection.createStatement().executeUpdate(query);
	}

	@Override
	public ResultSet getAllInventoryItems() throws SQLException {
		String query = "select * from inventory;";
	    	return this.connection.createStatement().executeQuery(query);
		
		
	}
	
	public boolean inventoryItemExists(StoreInventory inventory) throws ClassNotFoundException, SQLException {
 		ResultSet resultSet;
 		String query = "select * from inventory where item_name='"+ inventory.getItemName().toString()
 					+"' AND make='"+inventory.getMake().toString()+"' AND model='"+inventory.getModel().toString()+"';";
 		
 		resultSet = this.connection.createStatement().executeQuery(query);
 		if(resultSet.next()) {
 			this.srNo = resultSet.getInt(1);
 			return true;
 		}
 		return false;
	}
	 
	 public boolean storeInventoryIsEmpty() throws SQLException {
 		ResultSet resultSet;
	    String query = "select * from inventory;";
	    	resultSet = this.connection.createStatement().executeQuery(query);

	    	if(!resultSet.next()) {
			System.out.println("=============================================================");
			System.out.println("\n\nStore Inventory is empty. Please add some Device in the Inventory. \n");
			System.out.println("=============================================================");
			return true;
		}
 		return false;
	 }

}
