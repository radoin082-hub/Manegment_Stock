package Controllers.Products.Cells;

import Controllers.Products.ProductsViewController;
import Model.Product;
import Service.ProductService;
import Storage.Products_Storage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.krysalis.barcode4j.impl.code39.Code39;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.function.Consumer;

public class ProductCellController {

    @FXML private Label productName;
    @FXML private Label productBuyPrice;
    @FXML private Label productSellPrice;
    @FXML private ImageView productBarCode;
    @FXML private HBox productContainer;
    @FXML private ImageView productImage;

    private Product product;
    private ProductService productService;
    private ListView<Product> productListView;

    public ProductCellController() {
        this.productService = new ProductService(new Products_Storage());
    }

    public void setProduct(Product product) {
        this.product = product;
        this.productName.setText(product.getNameProduct());
        this.productBuyPrice.setText(String.valueOf(product.getOldPrice() + " DA"));
        this.productSellPrice.setText(String.valueOf(product.getNewPrice() + " DA"));
        if(product.getProductImage()!=null){
            productImage.setImage(new Image(new ByteArrayInputStream(product.getProductImage())));
        }
        productContainer.setStyle("-fx-background-color: " + "#" + product.getColor().replace("0x", ""));

        try {
            Code39 code39 = new Code39();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BitmapCanvasProvider bitmapCanvasProvider = new BitmapCanvasProvider(byteArrayOutputStream, "image/png", 500, BufferedImage.SCALE_SMOOTH, true, 0);
            code39.generateBarcode(bitmapCanvasProvider, product.getqBar());
            bitmapCanvasProvider.finish();
            Platform.runLater(() -> {
                productBarCode.setImage(new Image(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setProductListView(ListView<Product> productListView) {
        this.productListView = productListView;
    }

    @FXML
    private void handleRemoveProduct() {
        if (product != null) {
            int productId = product.getIdProduct();
            boolean success = productService.deleteProduct(productId);
            if (success) {
                productListView.getItems().remove(product);
            } else {
                System.err.println("Error deleting product with ID: " + productId);
            }
        }
    }

    @FXML void handleEditProduct(){
        productsViewController.openEditProduct(product);
    }
    private ProductsViewController  productsViewController;



    public void setController(ProductsViewController productsViewController) {
        this.productsViewController=productsViewController;
    }
}