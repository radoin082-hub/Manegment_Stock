package Model;

public class Suppliers {
    private int idSuppliers;
    private String nameSuppliers;
    private String nameProduct;
    private int quantitySuppliers;
    private double price;
    private String description;


    public Suppliers(int idSuppliers, String nameSuppliers, String nameProduct, int quantitySuppliers, double price, String description) {
        this.idSuppliers = idSuppliers;
        this.nameSuppliers = nameSuppliers;
        this.nameProduct = nameProduct;
        this.quantitySuppliers = quantitySuppliers;
        this.price = price;
        this.description = description;
    }


    public int getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(int idSuppliers) {
        this.idSuppliers = idSuppliers;
    }

    public String getNameSuppliers() {
        return nameSuppliers;
    }

    public void setNameSuppliers(String nameSuppliers) {
        this.nameSuppliers = nameSuppliers;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantitySuppliers() {
        return quantitySuppliers;
    }

    public void setQuantitySuppliers(int quantitySuppliers) {
        this.quantitySuppliers = quantitySuppliers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
