package Controllers.Products.Cells;

import Model.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ProductCell extends ListCell<Product> {
    private FXMLLoader mLLoader;
    private HBox hBox;
    private ProductCellController productCellController;


    public ProductCell(ListView<Product> productListView) {

            mLLoader = new FXMLLoader(getClass().getResource("/Views/Products/Cells/ProductCellLayout.fxml"));
            try {
                hBox = mLLoader.load();
                productCellController = mLLoader.getController();
                productCellController.setProductListView(productListView);
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