package Service;

import Model.Sales;
import Storage.Sales_Storage;

import java.sql.SQLException;
import java.util.List;

public class SalesService {
    private final Sales_Storage salesStorage;


    public SalesService(Sales_Storage salesStorage) {
        this.salesStorage = salesStorage;
    }


    public List<Sales> getAllSales() {
        try {
            return salesStorage.getAllSales();
        } catch (SQLException e) {

            System.err.println("Error fetching sales: " + e.getMessage());
            return null;
        }
    }


    public boolean addSale(Sales sale) {
        try {
               salesStorage.addSale(sale);
            return true;
        } catch (SQLException e) {

            System.err.println("Error adding sale: " + e.getMessage());
            return false;
        }
    }


    public boolean updateSale(Sales sale) {
        try {

            salesStorage.updateSale(sale);
            return true;
        } catch (SQLException e) {

            System.err.println("Error updating sale: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteSale(int idSales) {
        try {
            salesStorage.deleteSale(idSales);
            return true;
        } catch (SQLException e) {

            System.err.println("Error deleting sale: " + e.getMessage());
            return false;
        }
    }
}
