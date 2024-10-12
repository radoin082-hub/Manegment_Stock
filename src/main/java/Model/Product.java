package Model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double oldPrice;
    private double newPrice;
    private String color;
    private int quantity;
    private String qBar;


    public Product(int idProduct, String nameProduct, double oldPrice, double newPrice, String color, int quantity, String qBar) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.color = color;
        this.quantity = quantity;
        this.qBar = qBar;
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

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

}
