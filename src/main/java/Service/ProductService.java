package Service;

import Model.Product;
import Storage.Products_Storage;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final Products_Storage productsStorage;


    public ProductService(Products_Storage productsStorage) {
        this.productsStorage = productsStorage;
    }


    public List<Product> getAllProducts() {
        try {
            return productsStorage.getAllProducts();
        } catch (SQLException e) {

            System.err.println("Error fetching products: " + e.getMessage());
            return null;
        }
    }


    public boolean addProduct(Product product) {
        try {

            productsStorage.addProduct(product);
            return true;
        } catch (SQLException e) {

            System.err.println("Error adding product: " + e.getMessage());
            return false;
        }
    }


    public boolean updateProduct(Product product) {
        try {

            productsStorage.updateProduct(product);
            return true;
        } catch (SQLException e) {

            System.err.println("Error updating product: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteProduct(int idProduct) {
        try {
            productsStorage.deleteProduct(idProduct);
            return true;
        } catch (SQLException e) {

            System.err.println("Error deleting product: " + e.getMessage());
            return false;
        }
    }
}
