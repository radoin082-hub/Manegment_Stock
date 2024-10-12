package Controllers.Products.Cells;

import Model.Product;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.krysalis.barcode4j.impl.code39.Code39;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ProductCellController {
    @FXML private Label productName,productBuyPrice,productSellPrice;
    @FXML private ImageView productBarCode;
    @FXML private HBox productContainer;

void setProduct(Product product) {
    this.productName.setText(product.getNameProduct());
    this.productBuyPrice.setText(String.valueOf(product.getOldPrice() +" DA"));
    this.productSellPrice.setText(String.valueOf(product.getNewPrice() )+" DA" );
    productContainer.setStyle("-fx-background-color: "+"#"+product.getColor().replace("0x",""));


    try{
        Code39 code39=new Code39();

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        BitmapCanvasProvider bitmapCanvasProvider=new BitmapCanvasProvider(byteArrayOutputStream,"image/png",500, BufferedImage.SCALE_SMOOTH,true,0);
        code39.generateBarcode(bitmapCanvasProvider,product.getqBar());
        bitmapCanvasProvider.finish();
        Platform.runLater(() -> {
            productBarCode.setImage(new Image(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        });


    }catch (Exception e){
        e.printStackTrace();

    }


}




}
