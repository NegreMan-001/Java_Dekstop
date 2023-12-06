/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ayiti.teknoloji.kilti.tranpo_lakay.parametre;

import ayiti.teknoloji.kilti.tranpo_lakay.App;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAOInsert;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsPassager;
import java.sql.SQLException;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author negre
 */


public class Parametre {
    
                      
                       static Stage stage = new Stage();
                
                       
                       
                       static GridPane gp = new GridPane();

                       
                        public static void methodeParametre(){
                            
                            BorderPane rob = new BorderPane();
                        
                            // Pour les couleurs de la scene
                            VBox paneRadio = new VBox();
                            paneRadio.setSpacing(5);
                            paneRadio.setAlignment(Pos.CENTER);
                            paneRadio.setPrefSize(170, 150);
                            paneRadio.setStyle("-fx-border-color:black;");
                            
                            
                            Label labelC = new Label("Pran koulè ou vle a ");
                            
                            RadioButton rouge = new RadioButton("Wouj");
                            RadioButton blanc = new RadioButton("Blan");
                            RadioButton noir = new RadioButton("Nwa");
                            RadioButton jaune = new RadioButton("Jon");
                            RadioButton vert = new RadioButton("Vèt");
                            RadioButton bleu = new RadioButton("Ble");
                            paneRadio.getChildren().addAll(labelC,rouge, blanc, noir, jaune, vert, bleu);
                            ToggleGroup groupRadio = new ToggleGroup();
                            rouge.setToggleGroup(groupRadio);
                            blanc.setToggleGroup(groupRadio);
                            noir.setToggleGroup(groupRadio);
                            jaune.setToggleGroup(groupRadio);
                            vert.setToggleGroup(groupRadio);
                            bleu.setToggleGroup(groupRadio);
                            
                           // gp.setAlignment(Pos.CENTER);
                            gp.setVgap(10);
                            gp.setHgap(10);
                            gp.setPadding(new Insets(15, 5, 10, 5));
                            gp.add(new Label(" "), 0, 0);
                            gp.add(paneRadio, 1, 1);
                            //-----------------------------------------------------------------------------------
                            
                            // Pour la securite
                            VBox vbSecure = new VBox();
                            vbSecure.setAlignment(Pos.CENTER);
                            
                            
                            Label labelSecure = new Label(" Mòd sekirite ");
                            
                            ComboBox<String> comboSecure = new ComboBox<>(); 
                           // comboSecure.setPrefWidth(98);
                            comboSecure.setPadding(new Insets(8));
                            comboSecure.getItems().addAll(" Aktive ", " Dezaktive ");
                            vbSecure.getChildren().addAll(labelSecure, comboSecure);
                            
                            gp.add(new Label(), 1, 2);
                            gp.add(new Label(), 1, 3);
                            gp.add(vbSecure, 1, 4);
                            
                            //gp.add(new Label(), 1, 3);
                            
                            
                            
                            //-------------------------------------------------------------------------
                            // COnfiguration e-mail, ...
                            Button btConfig = new Button(" Konfigirasyon 'E-mail' ");
                            gp.add(new Label(), 1, 5);
                            gp.add(new Label(), 1, 6);
                            gp.add(btConfig, 1, 7);
                            btConfig.setOnAction(eh->{
                                 methodeGestionEmail(stage);
                            });
                            
                            
                            
                            
                            // fermeture de la fenetre parametre
                            Button btFermer = new Button(" Fèmen ");
                            btFermer.setOnAction(eh->{
                                stage.close();
                            });
                            gp.add(new Label("              "), 2, 8);
                            gp.add(new Label("              "), 3, 8);
                             gp.add(new Label("              "), 4, 8);
                            gp.add(new Label("              "), 5, 8);
                             gp.add(new Label("              "), 6, 8);
                            gp.add(new Label("              "), 7, 8);
                            gp.add(btFermer, 8, 8);
                            
                            
                            
                            
                            
                            rob.setCenter(gp);     
                            
                            rob.setStyle("-fx-background-color:SLATEGRAY;");    //Color.
                            
                            
                            
                            
                            
                         
         	        Scene scene = new Scene(rob,800,550 , Color.SLATEGRAY);
                      
                        
			
                        stage.setScene(scene);
                        try{
                        stage.initStyle(StageStyle.DECORATED);
                        stage.initOwner(App.stagePrim);           // Cette fenetre est dependante a   stagePrim
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.setTitle("   Paramèt   ");
                        }catch(Exception e){}
                        
                        
                        
            
                
                        stage.show();
                       


                        
                        
                        
                        
                        
                        } 
                       
                       
/**
 *   La methode qui va se charger de la fenetre dependante traitant le cas de 
 * @param st          la fenetre mere
 */
   static Button btValiderOuFermerFenetre;
    static Stage stage1;
    static ComboBox<String> comboChPa;
    static TextField textId;
    static PasswordField textCode;
    static TextField textEmail;
 public static void methodeGestionEmail(Stage st){
 
           stage1 = new Stage();
          
          GridPane gp1 = new GridPane();
          gp1.setPadding(new Insets(10));
          
          BorderPane bp1 = new BorderPane();
          
 
          Label labelEmail = new Label(" Antre adrès la avèk swen");
           textEmail = new TextField();
          textEmail.setPromptText("EX: sikilasyon@gmail.com");
 
          Label labelCode = new Label(" Antre kòd la avèk swen ");
           textCode = new PasswordField();
          
           btValiderOuFermerFenetre = new Button(" Fèmen ");
          
          textEmail.textProperty().addListener(
                         new InvalidationListener() {
                            @Override
                            public void invalidated(Observable ov) {                  
                       
                                 if(!textEmail.getText().isEmpty()){
                    btValiderOuFermerFenetre.setText(" Valide ");
                  }else{
                     btValiderOuFermerFenetre.setText(" Fèmen ");
                  }
                                
                    }
                 }
          
          );
          
          btValiderOuFermerFenetre.setOnAction(eh->{
             // une methode qui traite le bouton...
             methodeFemenValide();
          });
          
          
          //--------------
          
                VBox vbChPa = new VBox();
                           Label chOUpa = new Label(" Chofè oubyen Pasaje ? ");
                            
                             comboChPa = new ComboBox<>(); 
                           // comboSecure.setPrefWidth(98);
                           // comboSecure.setPadding(new Insets(8));
                            comboChPa.getItems().addAll(" Chofè ", " Pasaje ");
                      vbChPa.setSpacing(5);
                      vbChPa.getChildren().addAll(chOUpa, comboChPa);
                      
                      
                      
          
          //-------------
                VBox vbId = new VBox();
                        Label labelId = new Label(" Antre ID an ");
                         textId = new TextField();
                      vbId.setSpacing(5);
                      vbId.getChildren().addAll(labelId, textId);
          
          
          
          
          
         
          
          gp1.add(new Label("              "), 0, 0);
          gp1.add(labelEmail, 1, 1);
          gp1.add(vbChPa, 4, 1);
          gp1.add(textEmail, 1, 2);
          gp1.add(vbId, 4, 3);
          gp1.add(new Label("              "), 1, 3);
          gp1.add(labelCode, 1, 4);
          gp1.add(textCode, 1, 5);
          gp1.add(new Label("              "), 2, 5);
          gp1.add(new Label("              "), 3, 5);
          gp1.add(new Label("              "), 5, 5);
          gp1.add(new Label("              "), 5, 6);
          
          gp1.add(btValiderOuFermerFenetre, 5, 7);
          
          bp1.setCenter(gp1);
          bp1.setStyle("-fx-background-color:SLATEGRAY;");      
 
           Scene scene1 = new Scene(bp1, 700, 300);
                       
                        stage1.setScene(scene1);
                 
                        stage1.initStyle(StageStyle.DECORATED);
                        stage1.initOwner(st);           // Cette fenetre est dependante au stage     st, qui represente une fenetre
                        stage1.initModality(Modality.WINDOW_MODAL);
                        stage1.setTitle("   Konfigirasyon 'E-mail'   ");
                        
            
                
                        stage1.show();
 
 
 
 
 }
                        
                        
                        
                        
                        
                      
 
 
 
 
 public static void methodeFemenValide(){
             if(btValiderOuFermerFenetre.getText().equalsIgnoreCase(" Fèmen ")){
                  stage1.close();
              }else{
              //------------------ on determine quoi faire pour valider
              // On fait a la methode qui doit transferer les donnees a la base...
              // test pour le code du mail...
              if(textCode.getText().isEmpty()){
                 Alert alert = new Alert(Alert.AlertType.ERROR,"Ou pa antre KOD 'E-mail' la... " );
                 alert.setTitle("Pwoblèm kod");
                 alert.show();
              }else{
              
                  if(comboChPa.getSelectionModel().isEmpty()){
                      // On test si le choix est nul...
                      
                 Alert alert = new Alert(Alert.AlertType.ERROR,"Di si se chofè oubyen pasaje... " );
                 alert.setTitle("Pwoblèm chwa");
                 alert.show();
                      
              }else{
                  
                if(comboChPa.getSelectionModel().isSelected(0)){
                  if(textId.getText().isEmpty()){
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Antre ID chofè a svp... " );
                     alert.setTitle("Pwoblèm ID");
                     alert.show();
                  }else{
                      MailsChauffeur mailsCh = new MailsChauffeur(Integer.parseInt(textId.getText()), textEmail.getText(), textCode.getText());
                      //try{
                          DAOInsert.methodeInsertModeles(mailsCh);
//                      }catch(Exception ex){
//                          Alert alert = new Alert(Alert.AlertType.ERROR,"Verifye nimewo chofè a byen... " );
//                          alert.setTitle("Pwoblèm nan done yo");
//                          alert.show();
//                      }
                  }                
              
              }else{
              // Eh bien, c'est un passager
              if(textId.getText().isEmpty()){
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Antre ID pasaje a svp... " );
                     alert.setTitle("Pwoblèm ID");
                     alert.show();
                  }else{
                   MailsPassager mailPa = new MailsPassager(Integer.parseInt(textId.getText()), textEmail.getText(), textCode.getText());
                      // try{
                          DAOInsert.methodeInsertModeles(mailPa);
//                      }catch(Exception ex){
//                          Alert alert = new Alert(Alert.AlertType.ERROR,"Verifye nimewo pasaje a byen... " );
//                          alert.setTitle("Pwoblèm nan done yo");
//                          alert.show();
//                      }
                  }
              
              }
                  
                  
                  
                  
                  }
                  
                  
              }
              
              
              
              
              
              
              }
 
 
 
 
 
 }
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
}
