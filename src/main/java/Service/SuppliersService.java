package Service;

import Model.Suppliers;
import Storage.Suppliers_Storage;

import java.sql.SQLException;
import java.util.List;

public class SuppliersService {
    private final Suppliers_Storage suppliersStorage;


    public SuppliersService(Suppliers_Storage suppliersStorage) {
        this.suppliersStorage = suppliersStorage;
    }


    public List<Suppliers> getAllSuppliers() {
        try {
            return suppliersStorage.getAllSuppliers();
        } catch (SQLException e) {

            System.err.println("Error fetching suppliers: " + e.getMessage());
            return null;
        }
    }


    public boolean addSupplier(Suppliers supplier) {
        try {
              suppliersStorage.addSupplier(supplier);
            return true;
        } catch (SQLException e) {

            System.err.println("Error adding supplier: " + e.getMessage());
            return false;
        }
    }


    public boolean updateSupplier(Suppliers supplier) {
        try {

            suppliersStorage.updateSupplier(supplier);
            return true;
        } catch (SQLException e) {

            System.err.println("Error updating supplier: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteSupplier(int idSuppliers) {
        try {
            suppliersStorage.deleteSupplier(idSuppliers);
            return true;
        } catch (SQLException e) {

            System.err.println("Error deleting supplier: " + e.getMessage());
            return false;
        }
    }
}
