package com.electronic.storewithdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * This class is used for operations like Add, purchase, displaying and generating the bill
 *  item in inventory. 
 */
public class ActionsOnInventory {
	Scanner scan;
	StoreInventory inventory;
	OperationsOnStoreInventory inventoryStore;
	
	
	public ActionsOnInventory() throws ClassNotFoundException, SQLException {
		scan = new Scanner(System.in);
		inventory = new StoreInventory();
		inventoryStore = new OperationsOnStoreInventory();
	}
	
	public void addItemInInventory() throws ClassNotFoundException, SQLException {
		
		String itemName = returnStringInput("Item Name");
		String make = returnStringInput("Make");
		String model = returnStringInput("Model");
		int numbers = returnItemCount();
		Double price = returnItemPrice();

		inventory = new StoreInventory(itemName, make, model, numbers, price);		
		inventoryStore.addItemInStoreInventory(inventory);
		
	}
	
	
	public void purchaseItem() throws SQLException {
		if(inventoryStore.storeInventoryIsEmpty()) {
			return;
		}
		this.displayInventoryItem();
		
		ResultSet resultSet = inventoryStore.getAllInventoryItems();
		List<Integer> srNos = new ArrayList<Integer>();
		while(resultSet.next()) {
			srNos.add(resultSet.getInt(1));
		}
		int selection = returnSelection("\nEnter sr. no of the item you want to purchase");
		if(!srNos.contains(selection)) {
			System.out.println("\nInvalid Choice. Try again.\n");
			purchaseItem();
		}else {
			resultSet.beforeFirst();
			while(resultSet.next()) {
				if(resultSet.getInt(1) == selection) {
					break;
				}
			}
			int availableItemCount = resultSet.getInt(5);
			String itemName = resultSet.getString(2);
			System.out.println("\nThe Available Units : " +availableItemCount);
			int units = returnItemCount();
			if(units > availableItemCount) {
				System.out.println("\nOnly " +availableItemCount +" unit of your selected item " + itemName + " are available in stock.\n");
			}else {
				inventoryStore.updateInventoryItemCount(units, selection);
				Bill(resultSet, units);
			}
			
		}
		
		System.out.println("\n**************************************************************");
	}                         
	
	public void displayInventoryItem() throws SQLException {
		if(inventoryStore.storeInventoryIsEmpty()) {
			return;
		}
		
		ResultSet resultSet = inventoryStore.getAllInventoryItems();
	    	System.out.printf("%-6s\t%-10s\t%-10s\t%-10s\t%-15s\t%-15s\n", "Sr.No.", "Name", "Make", "Model", "Price", "Available Units");
		System.out.println("________________________________________________________________________________________");
	    	while(resultSet.next()) {
	    		System.out.printf("%-6s\t%-10s\t%-10s\t%-10s\t%-13.2f\t%-15d", 
						resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
						resultSet.getString(4), resultSet.getDouble(6), resultSet.getInt(5));
				System.out.println();
	    	}
	}
	
	public String returnStringInput(String s) {		
		System.out.println("Enter "+s +":");
		return scan.nextLine();
		
	}
	
	public int returnItemCount() {
		System.out.println("Enter number of items : \t");
		while (!scan.hasNextInt()) {
			System.out.println("\nInvalid input. Try again.");
			scan.nextLine();
		}
		int count = scan.nextInt();
		if(count < 0) {
			System.out.println("\nInvalid input. Try again.");
			return returnItemCount();
		}
		return count;
	}
	
	public double returnItemPrice() {
		System.out.println("Enter price of product: \t ");
		while (!scan.hasNextDouble()) {
			System.out.println("\nInvalid input. Try again.");
			scan.nextLine();
		}
		Double price = scan.nextDouble();
		scan.nextLine();
		if(price < 0) {
			System.out.println("\nInvalid input. Try again.");
			return returnItemPrice();
		}
		return price;
	}
	
	public int returnSelection(String s) {
		System.out.println(s+" :\t");
		while (!scan.hasNextInt()) {
			System.out.println("\nInvalid input. Try again.");
			scan.nextLine();
		}
		return scan.nextInt();				
	}
	
	int billCounter = 0;
	public void Bill(ResultSet resultSet, int unitsPurchased) throws SQLException {
		billCounter++;
		System.out.println("___________________________________________________");
		System.out.println("********* Electornic Store Inventory Bill*********");
		System.out.println("___________________________________________________");
		System.out.println("Bill Reference Number:DemoBill_"+billCounter+ "\n");
		System.out.printf("%-15s\t%-15s\n%-15s\t%-15s\n%-15s\t%-15s\n%-15s\t%-15d", 
		"Name", resultSet.getString("item_name"),"Make", resultSet.getString("make"),
		"Model", resultSet.getString("model"),"Units", unitsPurchased);
		System.out.println("\n___________________________________________________");
		System.out.printf("%-15s\t%-13.2f", "Total Price", resultSet.getDouble("price")*unitsPurchased);
	}
}
