package ayiti.teknoloji.kilti.tranpo_lakay;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SystemInfo {

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }
    
    
    
    
    
    
    
    public static Pane methodeText(){
    
        TextArea text = new TextArea();
        text.appendText("\n\t\t Transpò Lakay   vesyon-desktòp 1.0 \n\n"
                    + "\tSe yon aplikasyon ki la, yon fason pou bay\n"
                    + "\tyon meye estrikti nan koze transpò nan peyi d'Ayiti\n"
                    + "\tKi se kinan nou... Kozann... Zafe-n...\n"
                    + "\n\t Avek tout posibilite Transpò Lakay ofri, se pou lavi\n"
                    +" \t komanse we jou... "
                    + "\n\t Yon lòt fason ankò pou entegre jenes la... ");
    
    
            BorderPane pane = new BorderPane();
            pane.setCenter(text);
            pane.setPadding(new Insets(30));
            
                    
    return pane;
    }
    
    
    
    
    
    
    
    static File file;
     static int low = 1;                             // the lowest value in the range
     static int high = 2;                             // the highest value in the range

     static int rnd = (int)(Math.random() * (high - low + 1)) + low; 
    
    
    public static Stage st = new Stage();
    
     
    
    
    
    public static MediaPlayer mp;
   public static void methodeMedia(){
       if(rnd == 1){
       file = new File("/home/negre/negre_l3_projet_TRANSPORT/Haiti's decorative tap-tap buses.mp4");
       }else{
        file = new File("/home/negre/negre_l3_projet_TRANSPORT/penti_transport.mp4");
       }
       
        Media md = new Media(file.toURI().toString());
        mp = new MediaPlayer(md);
       MediaView mv = new MediaView(mp);
       mp.play();
       
       Button bt = new Button(" Fèmen ");
       bt.setOnAction(eh->{
             st.close();
       });
       
        BorderPane bp = new BorderPane();
        
        VBox hb = new VBox();
        hb.setSpacing(9);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(mv, bt);
        
//        bp.setBottom(bt);
        bp.setCenter(hb);
    
               
                
			Scene scene = new Scene(bp,800,550 ,Color.SLATEGRAY);
                       
                        
                        
			st.setScene(scene);
//                        st.setWidth(900);
//                        st.setHeight(650);
                        try{
                       st.initStyle(StageStyle.DECORATED);
                       st.initOwner(App.stagePrim);           // Cette fenetre est dependante a   stagePrim
                       st.initModality(Modality.WINDOW_MODAL);
                       
                        bp.setStyle("-fx-border-color:white; -fx-background-color:write;");
                        st.setTitle("Kilti ak Sikilasyon nan peyi n'");

                        }catch(java.lang.IllegalStateException e){
                        
                        }
                       
            
//                       st.showingProperty().addListener(
//                       new InvalidationListener() {
//                            public void invalidated(Observable ov) {                  
//                       
//                                    if(st.showingProperty().getValue() == false){
//                                       mp.stop();
//                                    }
//                            }         
//                          }
//                       
//                       
//                       );


                          
                
                        st.show();
                
                      
                
                        
                         
    
    
    }
    
    
    

}