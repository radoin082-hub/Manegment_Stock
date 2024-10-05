package Storage;

import Model.Sales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sales_Storage {
    private static final String CONNECTION_URL = "jdbc:sqlserver://localhost:8080;databaseName=GestionStock;user=sa;password=123456;encrypt=false;trustServerCertificate=false;";

    public List<Sales> getAllSales() throws SQLException {
        List<Sales> salesList = new ArrayList<>();

        String sql = "SELECT TOP (1000) Id_Sales, Id_product, Name_product, Quantity, Q_bar, Price FROM dbo.Sales";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idSales = resultSet.getInt("Id_Sales");
                int idProduct = resultSet.getInt("Id_product");
                String nameProduct = resultSet.getString("Name_product");
                int quantity = resultSet.getInt("Quantity");
                String qBar = resultSet.getString("Q_bar");
                double price = resultSet.getDouble("Price");

                Sales sale = new Sales(idSales, idProduct, nameProduct, quantity, qBar, price);
                salesList.add(sale);
            }
        }

        return salesList;
    }

    public void addSale(Sales sale) throws SQLException {
        String sql = "INSERT INTO dbo.Sales (Id_product, Name_product, Quantity, Q_bar, Price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, sale.getIdProduct());
            statement.setString(2, sale.getNameProduct());
            statement.setInt(3, sale.getQuantity());
            statement.setString(4, sale.getqBar());
            statement.setDouble(5, sale.getPrice());

            statement.executeUpdate();
        }
    }


    public void updateSale(Sales sale) throws SQLException {
        String sql = "UPDATE dbo.Sales SET Id_product = ?, Name_product = ?, Quantity = ?, Q_bar = ?, Price = ? WHERE Id_Sales = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, sale.getIdProduct());
            statement.setString(2, sale.getNameProduct());
            statement.setInt(3, sale.getQuantity());
            statement.setString(4, sale.getqBar());
            statement.setDouble(5, sale.getPrice());
            statement.setInt(6, sale.getIdSales());

            statement.executeUpdate();
        }
    }


    public void deleteSale(int idSales) throws SQLException {
        String sql = "DELETE FROM dbo.Sales WHERE Id_Sales = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idSales);
            statement.executeUpdate();
        }
    }
}
