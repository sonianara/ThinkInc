package Models;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {

  public Main() {
    // TODO Auto-generated constructor stub
  }
  
  /**
   * Function that validates the username and password
   */
  public void checkPassword(TextField username, PasswordField password) {
    
  }

  /**
   * Login Screen    
   * @param primaryStage
   */
  public void start(final Stage primaryStage) {
    StackPane root = new StackPane();
    VBox authentication = new VBox();
    TextField username = new TextField();
    Button loginButton = new Button();
    PasswordField password = new PasswordField();
    // www.logomakr.com/5mcZwA
    Image img = new Image("file:images/PlanIt.png");
    ImageView imgView = new ImageView(img);
    BooleanProperty firstTime = new SimpleBooleanProperty(true); 

    username.setStyle("-fx-background-radius: 10 10 10 10");
    password.setStyle("-fx-background-radius: 10 10 10 10");
    loginButton.setStyle("-fx-background-radius: 10 10 10 10");
    
    authentication.setAlignment(Pos.CENTER);
    authentication.setPadding(new Insets(0, 100, 0, 100));
    username.setPromptText("Username");
    password.setPromptText("Password");
    loginButton.setText("Login");
    
    //check if the username and password is correct 
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
          checkPassword(username, password);
      }
    });
    
    //remove default focus from text field
    username.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
      if(newValue && firstTime.get()){
          authentication.requestFocus(); // Delegate the focus to container
          firstTime.setValue(false); // Variable value changed for future references
      }
    });
    
    authentication.setSpacing(15);
    authentication.getChildren().addAll(imgView, username, password, loginButton);
    root.getChildren().addAll(authentication);
    root.setStyle("-fx-background-color: transparent;");
    primaryStage.setTitle("ThinkInc");
    primaryStage.setScene(new Scene(root, 800, 800, Color.LIGHTGRAY));
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);

  }

}
