package Controllers.Products.Cells;

import Controllers.Products.ProductsViewController;
import Model.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.io.Console;
import java.io.IOException;
import java.util.function.Consumer;

public class ProductCell extends ListCell<Product> {
    private FXMLLoader mLLoader;
    private HBox hBox;
    private ProductCellController productCellController;


    public ProductCell(ListView<Product> productListView, ProductsViewController productsViewController) {

        mLLoader = new FXMLLoader(getClass().getResource("/Views/Products/Cells/ProductCellLayout.fxml"));
        try {
            hBox = mLLoader.load();
            productCellController = mLLoader.getController();
            productCellController.setProductListView(productListView);
            productCellController.setController(productsViewController);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void updateItem(Product product, boolean empty) {
        super.updateItem(product, empty);

        if (empty || product == null) {
            setGraphic(null);
            setText(null);
        } else {


            productCellController.setProduct(product);
            setText(null);
            setGraphic(hBox);
        }
    }
}