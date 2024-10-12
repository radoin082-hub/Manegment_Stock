package Service;

import Model.Client;
import Storage.Client_Storage;

import java.sql.SQLException;
import java.util.List;

public class ClientService {

    private final Client_Storage clientStorage;

    public ClientService() {
        this.clientStorage = new Client_Storage();
    }


    public List<Client> getAllClients() {
        try {
            return clientStorage.getAllClients();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving clients", e);
        }
    }


    public void addClient(Client client) {
        try {
            clientStorage.addClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding client", e);
        }
    }


    public void updateClient(Client client) {
        try {
            clientStorage.updateClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating client", e);
        }
    }


    public void deleteClient(int idClient) {
        try {
            clientStorage.deleteClient(idClient);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting client", e);
        }
    }
}
