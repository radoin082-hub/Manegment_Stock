package Model;

public class Client {
    private int idClient;
    private String nameClient;
    private String nameProduct;
    private double priceClient;
    private String description;


    public Client(int idClient, String nameClient, String nameProduct, double priceClient, String description) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.nameProduct = nameProduct;
        this.priceClient = priceClient;
        this.description = description;
    }


    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceClient() {
        return priceClient;
    }

    public void setPriceClient(double priceClient) {
        this.priceClient = priceClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
