package com.electronic.storewithlist;
import java.util.List;
import java.util.Scanner;
/*
 * This class is used for operations like Add, purchase, displaying and Generating Bill for the item in the inventory. 
 */
public class ActionsOnInventory {
	Scanner scan;
	StoreInventory inventory;
	OperationsOnStoreInventory inventoryStore;
	
	
	public ActionsOnInventory() {
		scan = new Scanner(System.in);
		inventory = new StoreInventory();
		inventoryStore = new OperationsOnStoreInventory();
	}
	
	public void addItemInInventory() {
		try {
			String itemName = returnStringInput("Product Name");
			String make = returnStringInput("Make");
			String model = returnStringInput("Model");
			int numbers = returnItemCount();
			Double price = returnItemPrice();
			
			inventory = new StoreInventory(itemName, make, model, numbers, price);
			
			if(! inventoryExistsInInventoryStore(inventory)) {
				inventoryStore.addItemInInventory(inventory);
			}else {
				System.out.println("You can update only count and price of inventory.");
				this.inventoryUpdateOption();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	
	public void purchaseItem() {
		try {
				System.out.println("===========================================================");
				if(inventoryStore.getListOfInventory().size() == 0) {
				System.out.println("\nThere are no Items in the Store Inventory \n");
				System.out.println("=======================================================");
				return;
				}
			
				displayInventoryItem();
			
				int selection = getSelection("\nEnter the Sr. No of the Item you want to purchase");
				if(selection <= inventoryStore.getListOfInventory().size() && selection > 0) {
					inventory = inventoryStore.getListOfInventory().get(selection - 1);
					System.out.println("\nThe Available Units : " +inventory.getNumbers());
					int units = returnItemCount();
					if(units <= inventory.getNumbers()) {
						inventory.setNumbers(inventory.getNumbers() - units);
						inventoryStore.updateItemInInventory(inventory, selection - 1);
						Bill(inventory, units);
					}else{
						System.out.println("\nOnly " +inventory.getNumbers() +" unit of your selected item " + inventory.getItemName() + " are available in stock.\n");
					}
				}else {
					System.out.println("\nInvalid Choice. Try again.\n");
					purchaseItem();
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			System.out.println("\n*************************************************************");
		}	
	}
	
	public void displayInventoryItem() {
		try {
				List<StoreInventory> inventory = inventoryStore.getListOfInventory();
				if(inventory.size() == 0) {
					System.out.println("*************************************************************");
					System.out.println("\n\nThere is not Item in the Inventory of the Store, Please add some Items \n");
					System.out.println("*************************************************************");
					return;
				}
				int i = 1;
				System.out.printf("%-6s\t%-10s\t%-10s\t%-10s\t%-15s\t%-15s\n", "Sr.No.", "Name", "Make", "Model", "Price", "Available Units");
				System.out.println("________________________________________________________________________________________");
				for (StoreInventory inventory2 : inventory) {
					System.out.printf("%-6s\t%-10s\t%-10s\t%-10s\t%-13.2f\t%-15d", 
							i, inventory2.getItemName(), inventory2.getMake(), 
							inventory2.getModel(), inventory2.getPrice(), inventory2.getNumbers());
					System.out.println();
					i++;
				}
				System.out.println("===================================================");
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	private void inventoryUpdateOption() {
		try {
				System.out.println("===================================================");
				System.out.println("\nDo you want to update inventory? (y/n)");
				String answer = scan.nextLine().trim().toLowerCase();
				if(answer.equals("y")) {
					System.out.println("\n1. Count\n2. Price\n3. Exit\n");
					while (!scan.hasNextInt()) {
						System.out.println("\nInvalid input. Try again.");
						scan.nextLine();
					}
					int selection = scan.nextInt();
					int index = inventoryStore.getInventoryItemIndex(inventory);
					
					switch (selection) {
					case 1:
						inventory.setNumbers(returnItemCount());
						break;
					case 2:
						inventory.setPrice(returnItemPrice());
						break;
					case 3:
						return;
					default:
						break;
					}	
					inventoryStore.updateItemInInventory(inventory, index);
					
				}else if(answer.equals("n")) {
					return;
				}else {
					System.out.println("\nTry Again!! Enter either yes(y) or no(n)");
				}	
				inventoryUpdateOption();			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	
	
	public boolean inventoryExistsInInventoryStore(StoreInventory inventory) {
		try {
				if( inventoryStore.getInventoryItemIndex(inventory) == -1) {
					return false;
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("\nThis inventory already exists in inventory store");
		return true;		
	}
	
	public String returnStringInput(String s) {		
		System.out.println("Enter "+s +" : \t");
		return scan.nextLine();	
	}
	
	public int returnItemCount() {
		System.out.println("Enter number of items : \t");
		while (!scan.hasNextInt()) {
			System.out.println("\nInvalid option. Please Try again!!!");
			scan.nextLine();
		}
		int count = scan.nextInt();
		if(count < 0) {
			System.out.println("Invalid option. Please Try again!!!");
			return returnItemCount();
		}
		return count;
	}
	
	public double returnItemPrice() {
		System.out.println("Enter price of product : \t ");
		while (!scan.hasNextDouble()) {
			System.out.println("\nInvalid option. Please Try again!!!");
			scan.nextLine();
		}
		Double price = scan.nextDouble();
		scan.nextLine();
		if(price < 0) {
			System.out.println("\nInvalid option. Please Try again!!!");
			return returnItemPrice();
		}
		return price;
	}
	
	public int getSelection(String s) {
		System.out.println(s+" :\t");
		while (!scan.hasNextInt()) {
			System.out.println("\nInvalid option. Please Try again!!!");
			scan.nextLine();
		}
		return scan.nextInt();				
	}
	int billCounter = 0;
	public void Bill(StoreInventory inventory, int unitsPurchased) {
		billCounter++;
		System.out.println("___________________________________________________");
		System.out.println("******** Electornic Store Inventory Bill********");
		System.out.println("___________________________________________________");
		System.out.println("Invoice Number: DemoBill_"+billCounter+ "\n");
		System.out.printf("%-15s\t%-15s\n%-15s\t%-15s\n%-15s\t%-15s\n%-15s\t%-15d", 
		"Name", inventory.getItemName(),"Make", inventory.getMake(),"Model", inventory.getModel(),
		"Units", unitsPurchased);
		System.out.println("\n___________________________________________________");
		System.out.printf("%-15s\t%-13.2f", "Total Price", inventory.getPrice()*unitsPurchased);
	}
}
