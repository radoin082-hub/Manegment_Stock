package Controllers.Products;

import Controllers.Products.Cells.ProductCell;
import Model.Product;
import Service.ProductService;
import Storage.Products_Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.function.Consumer;

public class ProductsViewController implements Initializable {
    @FXML private StackPane overlay;
    @FXML private AnchorPane addProductsOverlay;
    @FXML private ListView<Product> productListView;
    @FXML private TextField productNameField, productBuyPriceField, productSellPriceField, productQuantityField, productBarCodeField;
    @FXML private ColorPicker productColor;
    @FXML private Button addButton;
    @FXML private ImageView productImage;


    private boolean isEditMode=false;

    private ObservableList<Product> products;
    private ProductService productService;


    @FXML public void addProductImage(){
       pickImage();
    }


    private byte[] newProductImageData;
    private void pickImage(){
        try{
            FileChooser fileChooser=new FileChooser();

            Stage currentStage=(Stage) addButton.getScene().getWindow();
            File fileImage= fileChooser.showOpenDialog(currentStage);
            FileInputStream fileInputStream=new FileInputStream(fileImage.getPath());
            byte[] bytes=fileInputStream.readAllBytes();

            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
            Image productImage=new Image(byteArrayInputStream);
            this.productImage.setImage(productImage);
            this.newProductImageData=bytes;



        }catch (Exception e){
            e.printStackTrace();
        }
    }

     private void addNewProduct() {
        String color = productColor.getValue().toString();
        Product newProduct = new Product(1,newProductImageData,productNameField.getText(),
                Double.parseDouble(productBuyPriceField.getText()),
                Double.parseDouble(productSellPriceField.getText()),
                color, Integer.parseInt(productQuantityField.getText()),
                productBarCodeField.getText());

        if (productService.addProduct(newProduct)) {
            products.add(newProduct);

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("اضافة منتج");
            alert.setHeaderText(null);
            alert.setContentText("تمت اضافة منتج بنجاح !");
            alert.showAndWait();

        } else {
            System.err.println("Error adding product");
        }
    }


    private Product editedProduct;

    private void updateProduct() {
         int productId=editedProduct.getIdProduct();
         int productIndex=products.indexOf(editedProduct);

        String color = productColor.getValue().toString();
        editedProduct = new Product(productId, newProductImageData,productNameField.getText(),
                Double.parseDouble(productBuyPriceField.getText()),
                Double.parseDouble(productSellPriceField.getText()),
                color, Integer.parseInt(productQuantityField.getText()),
                productBarCodeField.getText());

        if (productService.updateProduct(editedProduct)) {
            products.set(productIndex,editedProduct);
            productListView.refresh();

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("تعديل منتج");
            alert.setHeaderText(null);
            alert.setContentText("تم التعديل منتج بنجاح !");
            alert.showAndWait();

        } else {
            System.err.println("Error adding product");
        }
    }
    



    @FXML private void closeAddProducts() {
        overlay.setVisible(false);
        addProductsOverlay.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productService = new ProductService(new Products_Storage());
        products = FXCollections.observableArrayList();
        productColor.setValue(Color.WHITE);
        productListView.setItems(products);

        productListView.setCellFactory(productListView -> new ProductCell(productListView,this));
        loadProducts();


    }

    private void loadProducts() {
        List<Product> productList = productService.getAllProducts();
        if (productList != null) {
            products.setAll(productList);
        } else {
            System.err.println("Failed to load products");
        }
    }


    
    public void openEditProduct(Product productToUpdate){
        addButton.setText("تأكيد تعديل المنتج");
        this.editedProduct=productToUpdate;
        addButton.setOnMousePressed(event -> updateProduct());

                productNameField.setText(productToUpdate.getNameProduct());
                productBuyPriceField.setText(String.valueOf(productToUpdate.getOldPrice()));
                productSellPriceField.setText(String.valueOf(productToUpdate.getNewPrice()));
                productQuantityField.setText(String.valueOf(productToUpdate.getQuantity()));
                productBarCodeField.setText(String.valueOf(productToUpdate.getqBar()));

        openOverlay();
    }
    public void openOverlay () {
        overlay.setVisible(true);
        addProductsOverlay.setVisible(true);
    }

    @FXML private void openAddProduct(){
        addButton.setText("اضافة منتج جديد");
        addButton.setOnMouseClicked(event -> addNewProduct());
        openOverlay();
    }


}