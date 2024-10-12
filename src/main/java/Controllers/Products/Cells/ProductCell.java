package Controllers.Products.Cells;

import Model.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ProductCell extends ListCell<Product> {
    private HBox layout;
    private ProductCellController productCellController;
    public ProductCell(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/Views/Products/Cells/ProductCellLayout.fxml"));
            layout=loader.load();
            productCellController=loader.getController();
            ImageView removeProduct= (ImageView) loader.getNamespace().get("removeProduct");
            removeProduct.setOnMouseClicked(event -> {
                getListView().getItems().remove(getItem());
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void updateItem(Product product, boolean b) {
        super.updateItem(product, b);
        if(product==null || b){
            setGraphic(null);
            setText(null);
        }
        else{
            productCellController.setProduct(product);
            setGraphic(layout);
            setText(null);
        }
    }


}
