import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryLogic {
    
    private ArrayList<ProductModel> productList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private boolean isAdminLoggedIn = false;
    
    // Admin Login Function
    public boolean adminLogin() {
    	System.out.println("");
        System.out.print("Enter Admin Username\n> ");
        String username = sc.next();
        System.out.print("Enter Admin Password\n> ");
        String password = sc.next();
        
        // Assuming predefined admin credentials
        if (username.equals("virakyuth") && password.equals("virakyuth123")) {
            isAdminLoggedIn = true;
            return true;
        } else {
            isAdminLoggedIn = false;
            return false;
        }
    }
    
    // Add Product Function
    public void addProduct() {
    	System.out.println("");
        // Check if admin is logged in
        if (!isAdminLoggedIn) {
            System.out.println("Admin login required to perform this action.");
            return;
        }
        
        ProductModel product = new ProductModel();
        System.out.print("Enter Product ID\n> ");
        product.setProductId(sc.nextInt());
        
        System.out.print("Enter Product Name\n> ");
        product.setProductName(sc.next());
        
        System.out.print("Enter Product Quantity\n> ");
        product.setQuantity(sc.nextInt());
        
        System.out.print("Enter Product Price\n> $");
        product.setPrice(sc.nextDouble());
        
        productList.add(product);
        System.out.println("Product Added Successfully.");
    }

    // Update Product Function
    public void updateProduct() {
    	System.out.println("");
        // Check if admin is logged in
        if (!isAdminLoggedIn) {
            System.out.println("Admin login required to perform this action.");
            return;
        }
        
        System.out.print("Enter Product ID to update\n> ");
        int productId = sc.nextInt();
        for (ProductModel product : productList) {
            if (product.getProductId() == productId) {
                System.out.print("Enter New Product Name\n> ");
                product.setProductName(sc.next());
                
                System.out.print("Enter New Product Quantity\n> ");
                product.setQuantity(sc.nextInt());
                
                System.out.print("Enter New Product Price\n> $");
                product.setPrice(sc.nextDouble());
                
                System.out.println("Product Updated Successfully.");
                return;
            }
        }
        System.out.println("Product ID not found.");
    }
    
    // Remove Product Function
    public void removeProduct() {
    	System.out.println("");
        // Check if admin is logged in
        if (!isAdminLoggedIn) {
            System.out.println("Admin login required to perform this action.");
            return;
        }
        
        System.out.print("Enter Product ID to remove\n> ");
        int productId = sc.nextInt();
        for (ProductModel product : productList) {
            if (product.getProductId() == productId) {
                productList.remove(product);
                System.out.println("Product Removed Successfully.");
                return;
            }
        }
        System.out.println("Product ID not found.");
    }
    
    // Search Product Function
    public void searchProduct() {
    	System.out.println("");
        System.out.print("Enter Product ID to search\n> ");
        int productId = sc.nextInt();
        for (ProductModel product : productList) {
            if (product.getProductId() == productId) {
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Quantity: " + product.getQuantity());
                System.out.println("Product Price: $" + product.getPrice());
                return;
            }
        }
        System.out.println("Product ID not found.");
    }
    
    // Display Product Function
    public void displayAllProducts() {
        System.out.println("\nDisplay All Products");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-12s%-20s%-10s%-10s%n", 
                "Product ID", "Name", "Quantity", "Price");
        System.out.println("-----------------------------------------------");

        for (ProductModel product : productList) {
            System.out.printf("%-12s%-20s%-10s%-10s%n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getQuantity(),
                    product.getPrice());
        }
        System.out.println("-----------------------------------------------");
    }
    
    // Sale Order Management Function
    public void saleOrderManagement() {
    	System.out.println("");
        System.out.print("Enter Product ID to place an order\n> ");
        int productId = sc.nextInt();
        for (ProductModel product : productList) {
            if (product.getProductId() == productId) {
                System.out.print("Enter Quantity to order\n> ");
                int quantity = sc.nextInt();
                
                if (quantity <= product.getQuantity()) {
                    // Reduce the quantity from inventory
                    product.setQuantity(product.getQuantity() - quantity);
                    System.out.println("Order Placed Successfully.");
                    writeArrayListToFile(); // Update product list in file
                } else {
                    System.out.println("Insufficient Quantity in Stock.");
                }
                return;
            }
        }
        System.out.println("Product ID not found.");
    }

    // Purchase Order Function
	public void purchaseOrder() {
		System.out.println("");
	    // Check if admin is logged in
	    if (!isAdminLoggedIn) {
	        System.out.println("Admin login required to perform this action.");
	        return;
	    }
	    
	    System.out.print("Enter Product ID to add to inventory\n> ");
	    int productId = sc.nextInt();
	    for (ProductModel product : productList) {
	        if (product.getProductId() == productId) {
	            System.out.print("Enter Quantity to add\n> ");
	            int quantity = sc.nextInt();
	            
	            // Increase the quantity in inventory
	            product.setQuantity(product.getQuantity() + quantity);
	            System.out.println("Product Added to Inventory Successfully.");
	            writeArrayListToFile(); // Update product list in file
	            return;
	        }
	    }
	    System.out.println("Product ID not found.");
	}

    // Exit Function
    public void exit() {
    	System.out.println("");
        System.out.println("Thank you for using the Inventory Management System!");
        System.exit(0);
    }
    
    // Write ArrayList to File Function
    public void writeArrayListToFile() {
        try {
            FileOutputStream fout = new FileOutputStream("productList.ser");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(productList);
            oout.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Read ArrayList from File Function
    public void readArrayListFromFile() {
        try {
            FileInputStream fin = new FileInputStream("productList.ser");
            ObjectInputStream oin = new ObjectInputStream(fin);
            productList = (ArrayList<ProductModel>) oin.readObject();
            oin.close();
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("Product list file not found. Starting with an empty product list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
