import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryLogic {
    
    private ArrayList<ProductModel> productList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    public void addProduct() {
        String reply="";
        do {
            ProductModel obj = new ProductModel();
            System.out.println("Enter Product ID: ");
            int id = sc.nextInt();
            obj.setProductId(id);
            
            System.out.println("Enter Product Name: ");
            obj.setProductName(sc.next());
            
            System.out.println("Enter Product Quantity: ");
            obj.setQuantity(sc.nextInt());
            
            System.out.println("Enter Product Price: ");
            obj.setPrice(sc.nextDouble());
            
            productList.add(obj);
            
            System.out.println("Want to add more products? (Y/N) ");
            reply = sc.next();
        } while(reply.equalsIgnoreCase("y"));
    }

    public void displayAllProducts() {
        for(ProductModel obj: productList) {
            System.out.println("Product ID: " + obj.getProductId());
            System.out.println("Product Name: " + obj.getProductName());
            System.out.println("Product Quantity: " + obj.getQuantity());
            System.out.println("Product Price: " + obj.getPrice());
            System.out.println();
        }
    }
    
    public void deleteProduct() {
        System.out.println("Enter Product ID to delete: ");
        int id = sc.nextInt();
        ProductModel tempObj = null;
        
        for(ProductModel product: productList) {
            if (product.getProductId() == id) {
                tempObj = product;
                break;
            }
        }
        
        if(tempObj != null) {
            productList.remove(tempObj);
            System.out.println("Product Deleted Successfully.");
        } else {
            System.out.println("Invalid Product ID.");
        }
    }
    
    public void searchProductById() {
        System.out.println("Enter Product ID to search: ");
        int id = sc.nextInt();
        ProductModel tempObj = null;
        
        for(ProductModel product: productList) {
            if (product.getProductId() == id) {
                tempObj = product;
                break;
            }
        }
        
        if(tempObj != null) {
            System.out.println("Product ID: " + tempObj.getProductId());
            System.out.println("Product Name: " + tempObj.getProductName());
            System.out.println("Product Quantity: " + tempObj.getQuantity());
            System.out.println("Product Price: " + tempObj.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }
    
    public void updateProductDetailsById() {
        System.out.println("Enter Product ID to update: ");
        int id = sc.nextInt();
        ProductModel tempObj = null;
        
        for(ProductModel product: productList) {
            if (product.getProductId() == id) {
                tempObj = product;
                break;
            }
        }
        
        if(tempObj != null) {
            System.out.println("Enter New Product Name: ");
            tempObj.setProductName(sc.next());
            
            System.out.println("Enter New Product Quantity: ");
            tempObj.setQuantity(sc.nextInt());
            
            System.out.println("Enter New Product Price: ");
            tempObj.setPrice(sc.nextDouble());
            
            System.out.println("Product details updated successfully.");
        } else {
            System.out.println("Invalid Product ID.");
        }
    }
    
    public void generateReport() {
        System.out.println("Generating report...");
        // Logic to generate report goes here
        System.out.println("Report generated successfully.");
    }
    
    public void saleOrderManagement() {
        System.out.println("Sale order management...");
        // Logic for sale order management goes here
    }
    
    public void purchaseOrder() {
        System.out.println("Purchase order...");
        // Logic for purchase order goes here
    }
    
    public void writeArrayListToFile() {
        try {
            FileOutputStream fout = new FileOutputStream("productList.ser");
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(productList);
            System.out.println("Data saved to file.");
            oout.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readArrayListFromFile() {
        try {
            FileInputStream fin = new FileInputStream("productList.ser");
            ObjectInputStream oin = new ObjectInputStream(fin);
            productList = (ArrayList<ProductModel>) oin.readObject();
            oin.close();
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty inventory.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
