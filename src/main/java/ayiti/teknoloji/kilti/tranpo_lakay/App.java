package ayiti.teknoloji.kilti.tranpo_lakay;

import static ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAO.methodeConnection;
import ayiti.teknoloji.kilti.tranpo_lakay.animation_firstMenu.MenuEnFanmi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import ayiti.teknoloji.kilti.tranpo_lakay.animation_firstMenu.AnimationEnFanmi;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javafx.scene.text.Text;


/**
 * JavaFX App
 */
public class App extends Application {
    public static BorderPane pane1;
    public static Scene scene;
    public static Stage stagePrim;
    public static VBox vb;
    public static HBox hb;
    
    
    // This part is to be done before the app is loaded...
    @Override
    public void init() throws Exception {
       super.init();
    // here is about the database

    methodeConnection();

    }
    
    
    
    

    @Override
    public void start(Stage stage) {
        
          
        
        stagePrim = stage;
          pane1= new BorderPane();
        pane1.setTop(MenuEnFanmi.the_menu());
        pane1.setStyle("-fx-border-color:red; -fx-background-color:write;");
        
        
        pane1.setCenter(AnimationEnFanmi.completeMethod());
        
     
        
                
      scene = new Scene(pane1, 1070, 650, Color.SLATEGRAY);
        
        
        stagePrim.setScene(scene);
        stagePrim.setTitle("transpò_lakay   version 1.0");
        
        
        stagePrim.show();
    }
    
    
    

    public static void main(String[] args) {
        launch();
    }

}