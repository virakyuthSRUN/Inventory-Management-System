import java.util.Scanner;

public class InventoryMain {

    public static void main(String[] args) {
    	
    	
        Scanner sc = new Scanner(System.in);
        String reply="";
        InventoryLogic obj = new InventoryLogic(); 
        boolean isLoggedIn = false;
        
        do {
        	System.out.println("");
            System.out.println("🤖 WELCOME TO INVENTORY MANAGEMENT SYSTEM");
            System.out.println("1. Admin Login ");
            System.out.println("2. EXIT");
            System.out.println("");
            
            System.out.print("ENTER YOUR CHOICE\n> ");
            int option = sc.nextInt();
            
            switch(option) {
                case 1:
                    isLoggedIn = obj.adminLogin();
                    if(isLoggedIn) {
                    	System.out.println("");
                        System.out.println("Login Successful!");
                        inventoryMenu(obj);
                    } else {
                    	System.out.println("");
                        System.out.println("Login Failed. Please try again.");
                    }
                    break;
                case 2:
                	System.out.println("");
                    System.out.println("Thank you for using the Inventory Management System!");
                    System.exit(0);
                default:
                	
                    System.out.println("PLEASE ENTER VALID INPUT ");
            }
            
            System.out.println("");
            System.out.print("🤖 DO YOU WANT TO CONTINUE? (Y/N)\n> ");
            reply = sc.next();
        } while(reply.equalsIgnoreCase("y"));
    }
    
    public static void inventoryMenu(InventoryLogic obj) {
        Scanner sc = new Scanner(System.in);
        String reply="";
        do {	
        	System.out.println("");
            System.out.println("1. Add Product ");
            System.out.println("2. Update Product ");
            System.out.println("3. Remove Product ");
            System.out.println("4. Search Product ");
            System.out.println("5. Display Product ");
            System.out.println("6. Sale Order Management ");
            System.out.println("7. Purchase Order (PO) ");
            System.out.println("8. Logout");
            System.out.println("");
            
            System.out.print("🤖 ENTER YOUR CHOICE\n> ");
            int option = sc.nextInt();
            
            switch(option) {
                case 1:
                    obj.readArrayListFromFile();
                    obj.addProduct();
                    obj.writeArrayListToFile();
                    break;
                case 2:
                    obj.readArrayListFromFile();
                    obj.updateProduct();
                    obj.writeArrayListToFile();
                    break;
                case 3:
                    obj.readArrayListFromFile();
                    obj.removeProduct();
                    obj.writeArrayListToFile();
                    break;
                case 4:
                    obj.readArrayListFromFile();
                    obj.searchProduct();
                    break;
                case 5:
                    obj.readArrayListFromFile();
                    obj.displayAllProducts();
                    break;
                case 6:
                    obj.saleOrderManagement();
                    break;
                case 7:
                    obj.purchaseOrder();
                    break;
                case 8:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("PLEASE ENTER VALID INPUT ");
            }
            
            System.out.println("");
            System.out.print("🤖 DO YOU WANT TO CONTINUE (Y/N)\n> ");
            reply = sc.next();
        } while(reply.equalsIgnoreCase("y"));
    }
}
