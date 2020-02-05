package com.electronic.storewithlist;
import java.util.ArrayList;
import java.util.List;

public class OperationsOnStoreInventory implements StoreInventoryDao {
	
	ArrayList<StoreInventory> inventoryList;
	
	public OperationsOnStoreInventory() {
		inventoryList = new ArrayList<StoreInventory>();
	}
	
	public List<StoreInventory> getListOfInventory() {
		return this.inventoryList;
	}

	@Override
	public void addItemInInventory(StoreInventory inventory) {
		try {
			this.inventoryList.add(inventory);
			System.out.println("Item successfully added in the Inventory of Store\n");	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void updateItemInInventory(StoreInventory inventory, int index) {
		try {
			this.inventoryList.get(index).setPrice(inventory.getPrice());
			this.updateInventoryItemCount(inventory, index);
			System.out.println("Information of Item is successfully updated in the Inventory of Store\n");		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateInventoryItemCount(StoreInventory inventory, int index) {
		try {
				if(inventory.getNumbers() == 0) {
					deleteItemInInventory(index);
				}else {
					this.inventoryList.get(index).setNumbers(inventory.getNumbers());
				}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteItemInInventory(int index) {
		try {
			this.inventoryList.remove(inventoryList.get(index));	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public int getInventoryItemIndex(StoreInventory inventory) {
		int index = -1;
		try {
			for(int i=0; i< inventoryList.size(); i++) {
				StoreInventory inventoryItem = inventoryList.get(i);
				if(inventoryItem.getItemName().equalsIgnoreCase(inventory.getItemName())  ) {
					if(inventoryItem.getMake().equalsIgnoreCase(inventory.getMake())) {
						if(inventoryItem.getModel().equalsIgnoreCase(inventory.getModel())) {
							return i;
						}
					}
				}
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return index;
	}
}
