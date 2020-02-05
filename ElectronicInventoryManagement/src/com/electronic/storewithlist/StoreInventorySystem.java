package com.electronic.storewithlist;
import java.util.Scanner;

public class StoreInventorySystem {
	static ActionsOnInventory actionsOnInventory = new 	ActionsOnInventory();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("------- Welcome to Electronic Store Inventory System -Using List-------    ");
		do {
			System.out.println(""
				+"1- to add to Inventory\n" + 
				"2- to display Inventory \n" + 
				"3- to make purchase\n" + 
				"4- Exit from the program\n" + 
				""); 
			while (!scan.hasNextInt()) {
				System.out.println("Input doesn't match specifications. Try again.");
				scan.nextLine();
			}
		}while(inventoryOperations(scan.nextInt()) != 5);		
	}

	public static int inventoryOperations(int choice) throws ClassNotFoundException {
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
				System.out.println("Come again, Have a Nice Day. Bye !!");
				System.out.println("##############################################################");
				return 5;
			default:
				System.out.println("Wrong selection. Try again!!");
				break;
		}
			return 0;
	}
}

/*OutPut
 * 
------- Welcome to Electronic Store Inventory System -Using List-------    
1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

1
 *** Add Items in the Store Inventory ***
____________________________________________________________________
Enter Product Name : 	
iPhoneX
Enter Make : 	
Apple
Enter Model : 	
2018
Enter number of items : 	
12
Enter price of product : 	 
1120
Item successfully added in the Inventory of Store

____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

1
 *** Add Items in the Store Inventory ***
____________________________________________________________________
Enter Product Name : 	
Mac Pro
Enter Make : 	
Apple
Enter Model : 	
2018
Enter number of items : 	
10
Enter price of product : 	 
1400
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
1     	iPhoneX   	Apple     	2018      	1120.00      	12             
2     	Mac Pro   	Apple     	2018      	1400.00      	10             
===================================================
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

3
 *** Details of Items Purchase ***
_____________________________________________________________________
===========================================================
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	iPhoneX   	Apple     	2018      	1120.00      	12             
2     	Mac Pro   	Apple     	2018      	1400.00      	10             
===================================================

Enter the Sr. No of the Item you want to purchase :	
1

The Available Units : 12
Enter number of items : 	
2
Information of Item is successfully updated in the Inventory of Store

___________________________________________________
******** Electornic Store Inventory Bill********
___________________________________________________
Invoice Number: DemoBill_1

Name           	iPhoneX        
Make           	Apple          
Model          	2018           
Units          	2              
___________________________________________________
Total Price    	2240.00      
*************************************************************
_____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

3
 *** Details of Items Purchase ***
_____________________________________________________________________
===========================================================
Sr.No.	Name      	Make      	Model     	Price          	Available Units
________________________________________________________________________________________
1     	iPhoneX   	Apple     	2018      	1120.00      	10             
2     	Mac Pro   	Apple     	2018      	1400.00      	10             
===================================================

Enter the Sr. No of the Item you want to purchase :	
2

The Available Units : 10
Enter number of items : 	
1
Information of Item is successfully updated in the Inventory of Store

___________________________________________________
******** Electornic Store Inventory Bill********
___________________________________________________
Invoice Number: DemoBill_2

Name           	Mac Pro        
Make           	Apple          
Model          	2018           
Units          	1              
___________________________________________________
Total Price    	1400.00      
*************************************************************
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
1     	iPhoneX   	Apple     	2018      	1120.00      	10             
2     	Mac Pro   	Apple     	2018      	1400.00      	9              
===================================================
____________________________________________________________________

1- to add to Inventory
2- to display Inventory 
3- to make purchase
4- Exit from the program

4
Come again, Have a Nice Day. Bye !!
##############################################################
 * 
 * 
 */
