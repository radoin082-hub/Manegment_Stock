package Storage;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Products_Storage {
    private static final String CONNECTION_URL = "jdbc:sqlserver://localhost:8080;databaseName=GestionStock;user=sa;password=123456;encrypt=false;trustServerCertificate=false;";



    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT TOP (1000) Id_product, Name_product, Old_price, New_price, Color, Quantity, Q_bar FROM dbo.Products";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("Id_product");
                String nameProduct = resultSet.getString("Name_product");
                double oldPrice = resultSet.getDouble("Old_price");
                double newPrice = resultSet.getDouble("New_price");
                String color = resultSet.getString("Color");
                int quantity = resultSet.getInt("Quantity");
                String qBar = resultSet.getString("Q_bar");

                Product product = new Product(idProduct, nameProduct, oldPrice, newPrice, color, quantity, qBar);
                products.add(product);
            }
        }

        return products;
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO dbo.Products (Name_product, Old_price, New_price, Color, Quantity, Q_bar) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, product.getNameProduct());
            statement.setDouble(2, product.getOldPrice());
            statement.setDouble(3, product.getNewPrice());
            statement.setString(4, product.getColor());
            statement.setInt(5, product.getQuantity());
            statement.setString(6, product.getqBar());

            statement.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE dbo.Products SET Name_product = ?, Old_price = ?, New_price = ?, Color = ?, Quantity = ?, Q_bar = ? WHERE Id_product = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, product.getNameProduct());
            statement.setDouble(2, product.getOldPrice());
            statement.setDouble(3, product.getNewPrice());
            statement.setString(4, product.getColor());
            statement.setInt(5, product.getQuantity());
            statement.setString(6, product.getqBar());
            statement.setInt(7, product.getIdProduct());

            statement.executeUpdate();
        }
    }

    public void deleteProduct(int idProduct) throws SQLException {
        String sql = "DELETE FROM dbo.Products WHERE Id_product = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idProduct);
            statement.executeUpdate();
        }
    }
}
