package Models;

import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;

public class Main extends Application {

  public Main() {
    // TODO Auto-generated constructor stub
  }
  
  /**
   * Function that validates the username and password
   */
  public int checkPassword(TextField username, PasswordField password) {
    int departmentScheduler = 1;
    int faculty = 2;
    int guest = 3;
    
    if (true) {
      return 1;
    }
    return 0;
  }

  /**
   * Function that fits the application to the screen size
   * @param primaryStage
   */
  public static void fitToScreen(Stage primaryStage) {
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    primaryStage.setX(primaryScreenBounds.getMinX());
    primaryStage.setY(primaryScreenBounds.getMinY());
    primaryStage.setWidth(primaryScreenBounds.getWidth());
    primaryStage.setHeight(primaryScreenBounds.getHeight());
  }
  
  /**
   * Login Screen    
   * @param primaryStage
   */
  public void start(final Stage primaryStage) {
    StackPane root = new StackPane();
    VBox authentication = new VBox();
    HBox guestLogin = new HBox();
    TextField username = new TextField();
    Button loginButton = new Button();
    PasswordField password = new PasswordField();
    Image img = new Image("file:images/Logo.png");    // www.logomakr.com/5mcZwA
    ImageView imgView = new ImageView(img);
    BooleanProperty firstTime = new SimpleBooleanProperty(true); 
    Label guestLabel = new Label("Not a registered user?");
    Hyperlink guestUser = new Hyperlink();
    
    guestUser.setText("Login here");
    username.setStyle("-fx-background-radius: 10 10 10 10");
    password.setStyle("-fx-background-radius: 10 10 10 10");
    loginButton.setStyle("-fx-background-radius: 10 10 10 10");
    
    imgView.setFitHeight(500);
    imgView.setFitWidth(500);
    imgView.setPreserveRatio(true);
    
    authentication.setAlignment(Pos.CENTER);
    authentication.setPadding(new Insets(0, 100, 0, 100));
    username.setPromptText("Username");
    password.setPromptText("Password");
    loginButton.setText("Login");
    guestLogin.setAlignment(Pos.CENTER);
    
    //check if the username and password is correct 
    loginButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
          int permission = checkPassword(username, password);
          
          if (permission == 1) {
            dptSchedulerMainPage(primaryStage);
          }
      }
    });
    
    //remove default focus from text field
    username.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
      if(newValue && firstTime.get()){
          authentication.requestFocus(); // Delegate the focus to container
          firstTime.setValue(false); // Variable value changed for future references
      }
    });
    
    guestLogin.getChildren().addAll(guestLabel, guestUser);
    authentication.setSpacing(15);
    authentication.getChildren().addAll(imgView, username, password, loginButton, guestLogin);
    root.getChildren().addAll(authentication);
    root.setStyle("-fx-background-color: transparent;");
    primaryStage.setTitle("ThinkInc");
    fitToScreen(primaryStage);
    primaryStage.setScene(new Scene(root, Color.LIGHTGREY));
    primaryStage.show();
  }
  
  /**
   * Main Page for the department scheduler after logging in 
   */
  public static void dptSchedulerMainPage(Stage primaryStage) {
    BorderPane bp = new BorderPane();
    StackPane sp = new StackPane();
    HBox menuBar = new HBox();
    Image img = new Image("file:images/icon.png");   
    ImageView imgView = new ImageView(img); 

    
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    imgView.setFitHeight(25);
    imgView.setFitWidth(25);
    imgView.setPreserveRatio(true);
  
    bp.setTop(menuBar);
    menuBar.setStyle("-fx-background-color: #545454");
    menuBar.setMinHeight(40);
    menuBar.getChildren().addAll(imgView);
    menuBar.setAlignment(Pos.TOP_LEFT);
    sp.getChildren().addAll(bp);
    sp.setStyle("-fx-background-color: transparent;");
  
    fitToScreen(primaryStage);
    primaryStage.setScene(new Scene(sp, Color.LIGHTGRAY));
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);

  }

}
