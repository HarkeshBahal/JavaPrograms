package com.electronic.storewithlist;

public class StoreInventory {
	private String itemName, make, model;
	private int numbers;
	private Double price;
	
	public StoreInventory(){
		
	}
	
	public StoreInventory(String itemName, String make, String model, int numbers, double price){
		this.itemName = itemName;
		this.make = make;
		this.model = model;
		this.numbers = numbers;
		this.price = price;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getNumbers() {
		return numbers;
	}
	
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}
