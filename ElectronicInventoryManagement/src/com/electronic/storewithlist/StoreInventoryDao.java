package com.electronic.storewithlist;
public interface StoreInventoryDao {
	public void addItemInInventory(StoreInventory inventory);
	public void updateItemInInventory(StoreInventory inventory, int index);
	public void updateInventoryItemCount(StoreInventory inventory, int index);
	public void deleteItemInInventory(int index);
	public int getInventoryItemIndex(StoreInventory inventory);
}
