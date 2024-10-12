package Model;

public class Sales {
    private int idSales;
    private int idProduct;
    private String nameProduct;
    private int quantity;
    private String qBar;
    private double price;


    public Sales(int idSales, int idProduct, String nameProduct, int quantity, String qBar, double price) {
        this.idSales = idSales;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.qBar = qBar;
        this.price = price;
    }


    public int getIdSales() {
        return idSales;
    }

    public void setIdSales(int idSales) {
        this.idSales = idSales;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getqBar() {
        return qBar;
    }

    public void setqBar(String qBar) {
        this.qBar = qBar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

