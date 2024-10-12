package Controllers.Home;



import Controllers.Products.Cells.ProductCell;
import Model.Product;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewController implements Initializable {
private @FXML StackPane mainScreen;
private @FXML StackPane productsButton,clientsButton,suppliersButton,sellButton;

private String [] urls={"/Views/Products/ProductsView.fxml"};

private StackPane selectedTab=null;





private @FXML void handleMouseOvers(Event event){

    final Node source=(Node) event.getSource();
    if(selectedTab!=null && selectedTab.getId().equals(source.getId())){
        return;
    }
    ScaleTransition scaleTransition=new ScaleTransition();
    scaleTransition.setNode(source);
    scaleTransition.setFromX(1);
    scaleTransition.setFromY(1);
    scaleTransition.setToX(1.1);
    scaleTransition.setToY(1.1);
    scaleTransition.play();

}


private @FXML void handleMouseExits(Event event){
    final Node source=(Node) event.getSource();
    if(selectedTab!=null && selectedTab.getId()==source.getId()){
        return;
    }

    ScaleTransition scaleTransition=new ScaleTransition();
    scaleTransition.setNode(source);
    scaleTransition.setFromX(1.1);
    scaleTransition.setFromY(1.1);
    scaleTransition.setToX(1);
    scaleTransition.setToY(1);
    scaleTransition.play();

}


private void selectButton(StackPane selectedButton){
  if(selectedTab==null){
      selectedButton.getStyleClass().remove("navButtonNormal");
      selectedButton.getStyleClass().add("selected");
      selectedButton.setMouseTransparent(true);
  }
  else{
      selectedTab.getStyleClass().remove("selected");
      selectedTab.getStyleClass().add("navButtonNormal");
      selectedButton.getStyleClass().remove("navButtonNormal");
      selectedButton.getStyleClass().add("selected");
      ScaleTransition scaleTransition=new ScaleTransition();
      scaleTransition.setNode(selectedTab);
      scaleTransition.setFromX(1.1);
      scaleTransition.setFromY(1.1);
      scaleTransition.setToX(1);
      scaleTransition.setToY(1);
      scaleTransition.play();
      selectedButton.setMouseTransparent(true);
      selectedTab.setMouseTransparent(false);
  }


    selectedTab=selectedButton;
}
private @FXML void handleClicks(Event event){
final var node=(StackPane) event.getSource();
switch (node.getId()){

}
selectButton(node);
}


private void switchScreens(String url){
    try{
        FXMLLoader loader =new FXMLLoader(getClass().getResource(url));
        mainScreen.getChildren().add(loader.load());
    }catch (Exception e){
        e.printStackTrace();
    }
}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchScreens(urls[0]);
        selectButton(productsButton);

    }
}
