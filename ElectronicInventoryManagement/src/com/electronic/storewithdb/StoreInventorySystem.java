package com.electronic.storewithdb;

import java.sql.SQLException;
import java.util.Scanner;

public class StoreInventorySystem {
	static ActionsOnInventory actionsOnInventory;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")	
		Scanner scan = new Scanner(System.in);
		actionsOnInventory = new 	ActionsOnInventory();
		System.out.println("------- Welcome to Electronic Store Inventory System -Using DB-------    ");
		do {
			System.out.println(""
				+"1- to add to Inventory\n" + 
				"2- to display Inventory \n" + 
				"3- to make purchase\n" + 
				"4- Exit from the program\n" + 
				""); 
			while (!scan.hasNextInt()) {
				System.out.println("Input doesn't match specifications. Try again.\n");
				scan.nextInt();
			}
		}while(inventoryOperations(scan.nextInt()) != 4);
		
	}
	public static int inventoryOperations(int choice) throws ClassNotFoundException, SQLException {
		switch (choice) {
			case 1:
				System.out.println(" *** Add Items in the Store Inventory ***");
				System.out.println("____________________________________________________________________");
				actionsOnInventory.addItemInInventory();
				System.out.println("____________________________________________________________________\n");
				break;
			case 2:
				System.out.println(" *** Items Available in the Store ***");
				System.out.println("____________________________________________________________________");
				actionsOnInventory.displayInventoryItem();
				System.out.println("____________________________________________________________________\n");
				break;			
			case 3:
				System.out.println(" *** Details of Items Purchase ***");
				System.out.println("_____________________________________________________________________");
				actionsOnInventory.purchaseItem();
				System.out.println("_____________________________________________________________________\n");
				break;
			case 4:
				System.out.println("Come again Have a Nice Day. Bye !!");
				System.out.println("##############################################################");
				return 4;
			default:
				System.out.println("Invalid selection. Try again!!");
				break;
		}
		return 0;
	}
}
/*OutPut
 * 
------- Welcome to Electronic Store Inventory System -Using DB-------    
1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

2
 *** Items Available in the Store ***
____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	2              
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	8              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

1
 *** Add Items in the Store Inventory ***
____________________________________________________________________
Enter Item Name:
Inspiron Laptop
Enter Make:
Dell
Enter Model:
2012
Enter number of items : 	
10
Enter price of product: 	 
600
Item successfully added in the Inventory of Store

____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

2
 *** Items Available in the Store ***
____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	2              
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	8              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
6     	Inspiron Laptop	Dell      	2012      	600.00       	10             
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

1
 *** Add Items in the Store Inventory ***
____________________________________________________________________
Enter Item Name:
Lumia
Enter Make:
Microsoft
Enter Model:
2015
Enter number of items : 	
10
Enter price of product: 	 
200
Item successfully added in the Inventory of Store

____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

2
 *** Items Available in the Store ***
____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	2              
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	8              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
6     	Inspiron Laptop	Dell      	2012      	600.00       	10             
7     	Lumia     	Microsoft 	2015      	200.00       	10             
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

3
 *** Details of Items Purchase ***
_____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	2              
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	8              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
6     	Inspiron Laptop	Dell      	2012      	600.00       	10             
7     	Lumia     	Microsoft 	2015      	200.00       	10             

Enter sr. no of the item you want to purchase :	
1

The Available Units : 1
Enter number of items : 	
1
Information of Item is successfully updated in the Inventory of Store

___________________________________________________
********* Electornic Store Inventory Bill*********
___________________________________________________
Bill Reference Number:DemoBill_1

Name           	MacPro         
Make           	Apple          
Model          	2017           
Units          	1              
___________________________________________________
Total Price    	1120.00      
**************************************************************
_____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

2
 *** Items Available in the Store ***
____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	1 
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	8              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
6     	Inspiron Laptop	Dell      	2012      	600.00       	10             
7     	Lumia     	Microsoft 	2015      	200.00       	10             
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

3
 *** Details of Items Purchase ***
_____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	1 
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	8              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
6     	Inspiron Laptop	Dell      	2012      	600.00       	10             
7     	Lumia     	Microsoft 	2015      	200.00       	10             

Enter sr. no of the item you want to purchase :	
3

The Available Units : 8
Enter number of items : 	
2
Information of Item is successfully updated in the Inventory of Store

___________________________________________________
********* Electornic Store Inventory Bill*********
___________________________________________________
Bill Reference Number:DemoBill_2

Name           	SonyTV         
Make           	Sony           
Model          	2016           
Units          	2              
___________________________________________________
Total Price    	2000.00      
**************************************************************
_____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

2
 *** Items Available in the Store ***
____________________________________________________________________
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	MacPro    	Apple     	2017      	1120.00      	1 
2     	iPhoneX   	Apple     	2017      	1400.00      	1395           
3     	SonyTV    	Sony      	2016      	1000.00      	6              
4     	iPhone6s  	Apple     	2016      	700.00       	40             
5     	iPhone8   	Apple     	2017      	800.00       	30             
6     	Inspiron Laptop	Dell      	2012      	600.00       	10             
7     	Lumia     	Microsoft 	2015      	200.00       	10             
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

4
Come again Have a Nice Day. Bye !!
##############################################################

 * 
 * 
 */
