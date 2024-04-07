import java.util.Scanner;

public class InventoryMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reply="";
        InventoryLogic obj = new InventoryLogic(); 
        do {
            System.out.println("WELCOME TO INVENTORY MANAGEMENT SYSTEM");
            System.out.println("1. ADD PRODUCT ");
            System.out.println("2. DELETE PRODUCT ");
            System.out.println("3. SEARCH PRODUCT ");
            System.out.println("4. UPDATE PRODUCT DETAILS ");
            System.out.println("5. DISPLAY ALL PRODUCTS ");
            System.out.println("6. GENERATE REPORT");
            System.out.println("7. SALE ORDER MANAGEMENT");
            System.out.println("8. PURCHASE ORDER (PO)");
            System.out.println("9. EXIT");
            
            System.out.println("ENTER YOUR CHOICE ");
            int option = sc.nextInt();
            
            switch(option) {
                case 1:
                    obj.readArrayListFromFile();
                    obj.addProduct();
                    obj.writeArrayListToFile();
                    break;
                case 2:
                    obj.readArrayListFromFile();
                    obj.deleteProduct();
                    obj.writeArrayListToFile();
                    break;
                case 3:
                    obj.readArrayListFromFile();
                    obj.searchProductById();
                    break;
                case 4:
                    obj.readArrayListFromFile();
                    obj.updateProductDetailsById();
                    obj.writeArrayListToFile();
                    break;
                case 5:
                    obj.readArrayListFromFile();
                    obj.displayAllProducts();
                    break;
                case 6:
                    obj.generateReport();
                    break;
                case 7:
                    obj.saleOrderManagement();
                    break;
                case 8:
                    obj.purchaseOrder();
                    break;
                case 9:
                    System.out.println("Thank you for using the Inventory Management System!");
                    System.exit(0);
                default:
                    System.out.println("PLEASE ENTER VALID INPUT ");
            }
            
            System.out.println("DO YOU WANT TO CONTINUE Y/N ");
            reply = sc.next();
        } while(reply.equalsIgnoreCase("y"));
    }
}
