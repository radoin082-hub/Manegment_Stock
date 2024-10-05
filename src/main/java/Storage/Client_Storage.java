package Storage;

import Model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Client_Storage {

      private static final String CONNECTION_URL = "jdbc:sqlserver://localhost:8080;databaseName=GestionStock;user=sa;password=123456;encrypt=false;trustServerCertificate=false;";



    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();

        String sql = "SELECT TOP (1000) Id_client, Name_client, Name_product, Price_clinet, Description FROM dbo.Clients";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idClient = resultSet.getInt("Id_client");
                String nameClient = resultSet.getString("Name_client");
                String nameProduct = resultSet.getString("Name_product");
                double priceClient = resultSet.getDouble("Price_clinet");
                String description = resultSet.getString("Description");

                Client client = new Client(idClient, nameClient, nameProduct, priceClient, description);
                clients.add(client);
            }
        }

        return clients;
    }


    public void addClient(Client client) throws SQLException {
        String sql = "INSERT INTO dbo.Clients (Name_client, Name_product, Price_clinet, Description) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getNameClient());
            statement.setString(2, client.getNameProduct());
            statement.setDouble(3, client.getPriceClient());
            statement.setString(4, client.getDescription());

            statement.executeUpdate();
        }
    }


    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE dbo.Clients SET Name_client = ?, Name_product = ?, Price_clinet = ?, Description = ? WHERE Id_client = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, client.getNameClient());
            statement.setString(2, client.getNameProduct());
            statement.setDouble(3, client.getPriceClient());
            statement.setString(4, client.getDescription());
            statement.setInt(5, client.getIdClient());

            statement.executeUpdate();
        }
    }


    public void deleteClient(int idClient) throws SQLException {
        String sql = "DELETE FROM dbo.Clients WHERE Id_client = ?";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idClient);
            statement.executeUpdate();
        }
    }
}
