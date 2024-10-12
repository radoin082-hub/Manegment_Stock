package Controllers.Products;

import Controllers.Products.Cells.ProductCell;
import Model.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;


public class ProductsViewController implements Initializable {
    @FXML private  StackPane overlay;
    @FXML private  AnchorPane addProductsOverlay;
    @FXML private  ListView<Product> productListView;
    @FXML private  TextField productNameField,productBuyPriceField,productSellPriceField,productQuantityField,productBarCodeField;
    @FXML private ColorPicker productColor;
    private ObservableList<Product> products;





@FXML private void addNewProduct(){
   String color= productColor.getValue().toString();
Product newProduct=new Product(1,productNameField.getText(),Double.parseDouble(productBuyPriceField.getText()),
        Double.parseDouble(productSellPriceField.getText()),color,Integer.parseInt(productQuantityField.getText())
                ,productBarCodeField.getText());

products.add(newProduct);

}




@FXML private void  openAddProducts(){
    overlay.setVisible(true);
    addProductsOverlay.setVisible(true);
}

@FXML private void closeAddProducts(){
    overlay.setVisible(false);
    addProductsOverlay.setVisible(false);
}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        products=FXCollections.observableArrayList();
        productColor.setValue(Color.WHITE);
        productListView.setItems(products);
        productListView.setCellFactory(productListView1 -> new ProductCell());

    }
}
