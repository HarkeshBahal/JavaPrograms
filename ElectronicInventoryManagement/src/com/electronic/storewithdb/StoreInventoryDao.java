package com.electronic.storewithdb;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface StoreInventoryDao {
	public void addItemInStoreInventory(StoreInventory inventory) throws SQLException, ClassNotFoundException;
	public void updateItemsInInventory(StoreInventory inventory, int index) throws SQLException;
	public void updateInventoryItemCount(int count, int index) throws SQLException;
	public void deleteInventoryItem(int index) throws SQLException;
	public ResultSet getAllInventoryItems() throws SQLException;
}
