package Storage;

import Model.Suppliers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Suppliers_Storage {
    private static final String CONNECTION_URL = "jdbc:sqlserver://localhost:8080;databaseName=GestionStock;user=sa;password=123456;encrypt=false;trustServerCertificate=false;";


    public List<Suppliers> getAllSuppliers() throws SQLException {
        List<Suppliers> suppliers = new ArrayList<>();

        String sql = "SELECT TOP (1000) Id_suppliers, Name_suppliers, Name_Product, Quantity_suppliers, Price, Description FROM dbo.Suppliers";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idSuppliers = resultSet.getInt("Id_suppliers");
                String nameSuppliers = resultSet.getString("Name_suppliers");
                String nameProduct = resultSet.getString("Name_Product");
                int quantitySuppliers = resultSet.getInt("Quantity_suppliers");
                double price = resultSet.getDouble("Price");
                String description = resultSet.getString("Description");

                Suppliers supplier = new Suppliers(idSuppliers, nameSuppliers, nameProduct, quantitySuppliers, price, description);
                suppliers.add(supplier);
            }
        }

        return suppliers;
    }


    public void addSupplier(Suppliers supplier) throws SQLException {
        String sql = "INSERT INTO dbo.Suppliers (Name_suppliers, Name_Product, Quantity_suppliers, Price, Description) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, supplier.getNameSuppliers());
            statement.setString(2, supplier.getNameProduct());
            statement.setInt(3, supplier.getQuantitySuppliers());
            statement.setDouble(4, supplier.getPrice());
            statement.setString(5, supplier.getDescription());

            statement.executeUpdate();
        }
    }


    public void updateSupplier(Suppliers supplier) throws SQLException {
        String sql = "UPDATE dbo.Suppliers SET Name_suppliers = ?, Name_Product = ?, Quantity_suppliers = ?, Price = ?, Description = ? WHERE Id_suppliers = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, supplier.getNameSuppliers());
            statement.setString(2, supplier.getNameProduct());
            statement.setInt(3, supplier.getQuantitySuppliers());
            statement.setDouble(4, supplier.getPrice());
            statement.setString(5, supplier.getDescription());
            statement.setInt(6, supplier.getIdSuppliers());

            statement.executeUpdate();
        }
    }

    // Delete a supplier
    public void deleteSupplier(int idSuppliers) throws SQLException {
        String sql = "DELETE FROM dbo.Suppliers WHERE Id_suppliers = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idSuppliers);
            statement.executeUpdate();
        }
    }
}
