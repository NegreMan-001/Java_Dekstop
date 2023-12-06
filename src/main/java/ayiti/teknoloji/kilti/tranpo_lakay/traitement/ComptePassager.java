/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.traitement;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAO;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAOInsert;
import ayiti.teknoloji.kilti.tranpo_lakay.ModelesPassager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;


/**
 *
 * @author negre
 */
public class ComptePassager {
    
    TableView<ModelesPassager> tablePassager;
    
    BorderPane bp;
    GridPane gridF;
    TextField nomTF;
    TextField prenomTF;
    TextField sexeTF;
    TextField occupationTF;
    TextField telTF;
    
    Button btModifier;
    Button btSupprimer;
    
    HBox hb;
    
    TextField idTF;
    
    public static ObservableList<ModelesPassager> list;
    
    
    public Pane formnulairePa(){
        
        
        bp = new BorderPane();
        
        gridF = new GridPane();
        gridF.setAlignment(Pos.CENTER);
        gridF.setHgap(5);
        gridF.setVgap(5);
    
    Label nomPa = new Label("Siyati ");
    Label prenomPa = new Label("Non ");
    Label sexePa = new Label("Sèks ");
    Label occupationPa = new Label("Metye ");
    Label telephonePa = new Label("Telefòn ");
    
        nomTF = new TextField();
        nomTF.setPromptText("15 lèt maksimòm");
        prenomTF = new TextField();
        prenomTF.setPromptText("15 lèt maksimòm");
        sexeTF = new TextField();
        sexeTF.setPromptText("M oubyen maskilen");
        occupationTF = new TextField();
        occupationTF.setPromptText("15 lèt maksimòm");
        telTF = new TextField();
        telTF.setPromptText("xxxx-xx-xx");
    
    Button btCreer = new Button("Kreye kont");
    btCreer.setOnAction(eh->{
            try {
                methodeTraitementChaquePassager();
            } catch (SQLException ex) {
                Logger.getLogger(ComptePassager.class.getName()).log(Level.SEVERE, null, ex);
            }
   });
    
     btModifier = new Button("Modifye kont");
     btModifier.setOnAction(eh->{
         hb.getChildren().clear();
         hb.getChildren().addAll(tablePa(), methodeId("modifier"));
     });
    btModifier.disableProperty().bind(tablePassager.getSelectionModel().selectedItemProperty().isNull());
    
     btSupprimer = new Button("Siprime kont");
      btSupprimer.setOnAction(eh->{
         hb.getChildren().clear();
         hb.getChildren().addAll(tablePa(), methodeId("supprimer"));
     });
    btSupprimer.disableProperty().bind(tablePassager.getSelectionModel().selectedItemProperty().isNull());
    
    
    gridF.add(nomPa, 0, 0);
    gridF.add(nomTF, 1, 0);
    gridF.add(prenomPa, 0, 1);
    gridF.add(prenomTF, 1, 1);
    gridF.add(sexePa, 0, 2);
    gridF.add(sexeTF, 1, 2);
    gridF.add(occupationPa, 0, 3);
    gridF.add(occupationTF, 1, 3);
    gridF.add(telephonePa, 0, 4);
    gridF.add(telTF, 1, 4);

    
    gridF.add(btCreer, 0, 6);
    gridF.add(btModifier, 1, 6);
    gridF.add(btSupprimer, 2, 6);
    
    
     Text text1 = new Text("Pasaje...");
            text1.setFill(Color.BLUEVIOLET);
            text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 60));
    
        bp.setTop(text1);
        bp.setCenter(gridF);
        bp.setPadding(new Insets(10, 5, 10, 5));
    
    
    
    return bp;
    }
    
    
    
     public BorderPane tablePa(){
    
       
        BorderPane bp = new BorderPane();
        
             tablePassager = new TableView<ModelesPassager>();
            tablePassager.setPrefWidth(480);
         
        TableColumn<ModelesPassager, Integer> id = new TableColumn<ModelesPassager, Integer>("Idantifyan");
        TableColumn<ModelesPassager, String> nom = new TableColumn<ModelesPassager, String>("Siyati");
        TableColumn<ModelesPassager, String> prenom = new TableColumn<ModelesPassager, String>("Non");
        TableColumn<ModelesPassager, String> sexe = new TableColumn<ModelesPassager, String>("Seks");
        TableColumn<ModelesPassager, String> occupation = new TableColumn<ModelesPassager, String>("Metye");
        TableColumn<ModelesPassager, String> telephone = new TableColumn<ModelesPassager, String>("telefòn");
                 

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nomPassager"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenomPassager"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("sexePassager"));
        occupation.setCellValueFactory(new PropertyValueFactory<>("occupationPassager"));
        telephone.setCellValueFactory(new PropertyValueFactory<>("telephonePassager"));
        
        
        
         // On ajoute un ecouteur sur la selection au tableview ----------------------------------------------------
        tablePassager.getSelectionModel().selectedItemProperty().addListener(
                    new InvalidationListener() {
                            public void invalidated(Observable ov) {                  
                        if(tablePassager.getSelectionModel().selectedItemProperty().isNotNull().get()){
                            
                            // A ce niveau, c'est editable
                       nomTF.setText(tablePassager.getSelectionModel().getSelectedItem().getNomPassager());
                       prenomTF.setText(tablePassager.getSelectionModel().getSelectedItem().getPrenomPassager());
                       sexeTF.setText(tablePassager.getSelectionModel().getSelectedItem().getSexePassager());
                       occupationTF.setText(tablePassager.getSelectionModel().getSelectedItem().getOccupationPassager());
                       telTF.setText(tablePassager.getSelectionModel().getSelectedItem().getTelephonePassager());
                         
                        }else{
                            // Quand rien est selectionne, ces boutons sont invisibles...
                           btModifier.setVisible(false);
                           btSupprimer.setVisible(false);
                        
                        }

                            }         
                    }
        );
        

//------------------------------------------------------------------------
        
        
        
        
        
        
        
        
        
        
        
        


        list = DAO.listePassagers;
        tablePassager.setItems(list);
        tablePassager.getColumns().addAll(id, nom, prenom, sexe, occupation, telephone);
        
        bp.setCenter(tablePassager);
        bp.setPadding(new Insets(10, 5, 10, 5));
        
            
            
  
    
    return bp;
    
    
    
    
   
    }
    
    
    
    
    
    
    
      public HBox methodeHBoxPassager(){
    
          hb = new HBox(5);
         hb.setSpacing(8);
         hb.setAlignment(Pos.CENTER);
         hb.getChildren().addAll(tablePa(), formnulairePa());    
    
    
     return hb;
    }
    
    
    
    
      
      
      
      
      
      // -----------------------------------------------------------------
         public void methodeTraitementChaquePassager() throws SQLException{
        
       String chN = nomTF.getText();
       String chPn = prenomTF.getText();
       String chSx = sexeTF.getText();
       String chOc = occupationTF.getText();
       String chTel = telTF.getText();
        
       Boolean testLengh = false;
       Boolean test1Regex = false;
       
       
       /*
          Traitement du format pour les numeros de tel
       */
       String regex, chaineEntree;
       Pattern pattern = null;
       Matcher matcher = null; 
       
       
        regex = "\\d{4}-\\d{2}-\\d{2}";
        try
        {
        pattern = Pattern.compile(regex);      // Creation de notre modele
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test1Regex = false;
         }
       
       chaineEntree = chTel;
       if(chaineEntree.length() == 0){
          testLengh = false;
       }else{
           matcher = pattern.matcher(chaineEntree);   // On essaie de voir si le format est bon...
           if (matcher.matches()){
               test1Regex = true;
           }
           else{
            test1Regex = false;
        }
    }
    
       
      
       
       
       
       
       
       
       
       
       
       if((chN.length()==0 || chN.length() > 15) || (chPn.length()==0 || chPn.length() > 15) || ( chSx.length()==0 || chSx.length() > 15) 
               || (chOc.length()==0 || chOc.length() > 15)){
       
            testLengh = false;  
             Alert alert = new Alert(Alert.AlertType.ERROR,"Ta sanble gen chan ki vid..." );
              alert.setTitle("Pwoblèm");

           alert.showAndWait();
           
       }else{
           
            testLengh = true;
         
       } 
           
       if(testLengh == true){
           
                 if( test1Regex == true){
       
           // On passe les valeurs a la base
           ModelesPassager passag = new ModelesPassager(0, chN, chPn, chSx, chOc, chTel);
           
               DAOInsert.methodeInsertModeles(passag);
               
               //  On met toutes tables a jour...
              

       
           }else{
       
       // On fait sortir l'alert
       
       Alert alert = new Alert(Alert.AlertType.ERROR,"Ta sanble gen pwoblèm nan valè ki antre yo..." );
       alert.setTitle("Pwoblèm");

       alert.showAndWait();
       
       }
                 
       }
       
    
    
    
    
    
    
    // On fait des tests sur les valeurs saisies, si ca va, on passe dans une collection, puis
    // on appelle la methode de la classe DAO... pour la passer
    // Moindre probleme signale, on fait sortir une alerte...
    
    
    }
      
      
      
      
      
      
         //----------------------------------------------------------------
         static int idInt =0;
     public Pane methodeId(String quoiFaire){               // si c'est     modifier    ou       supprimer         la variable 'quoifaire'
         
         String chN = nomTF.getText();
       String chPn = prenomTF.getText();
       String chSx = sexeTF.getText();
       String chOc = occupationTF.getText();
       String chTel = telTF.getText();
         
         
         
     
         Label id = new Label("Antre nimewo idantifyan an tanpri...");
          idTF = new TextField();
         Button enter = new Button(" Antre ");
         enter.setOnAction(eh->{
             // 1   test pour savoir si c'est bien un nombre que la personne entre
             if(list.size() == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Pwoblèm anrejistreman..." );
              alert.setTitle("Pwoblèm");
               alert.showAndWait();
               // On revient la ou on etait
               hb.getChildren().clear();
               hb.getChildren().addAll(tablePa(), formnulairePa());  
             }else{
                 try{
                     
                     // On traite le cas de l'ID a part...
                   try{
                     idInt = Integer.parseInt(idTF.getText());
                     }catch(Exception e){
                          Alert alert = new Alert(Alert.AlertType.ERROR,"Sa pa yon antye... " );
                         alert.setTitle("Pwoblèm");
                         alert.showAndWait();
                         System.out.println(e.getMessage());
                     }
                   
                   
                    // Appel a la methode qui supprime
             if(quoiFaire.equalsIgnoreCase("modifier")){
DAOInsert.methodeUpdateModeles(new ModelesPassager(0, chN, chPn, chSx, chOc, chTel), idInt); 
             
                 
                 hb.getChildren().clear();
                 hb.getChildren().addAll(tablePa(), formnulairePa()); 
                 // Ou celle qui modifie, suivant le string saisi
             }else if(quoiFaire.equalsIgnoreCase("supprimer")){
DAOInsert.methodeDeleteModeles(new ModelesPassager(0, chN, chPn, chSx, chOc, chTel), idInt);
             
                 hb.getChildren().clear();
                 hb.getChildren().addAll(tablePa(), formnulairePa());   
             }else{
                //--------------- Que dalle !
             }
             
             
             
                   
                   
                   
                   
                }catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Ou dwe antre yon antye..." );
                        alert.setTitle("Pwoblèm");

                        alert.showAndWait();
                         // On revient la ou on etait
                         hb.getChildren().clear();
                         hb.getChildren().addAll(tablePa(), formnulairePa()); 
                         
                  }
             
             }
             
             
            
             
         
         });     // ===> enter   on action
         
         
         
         
         
         
         VBox v = new VBox();
         v.getChildren().addAll(id, idTF, enter);
         v.setAlignment(Pos.CENTER);
         v.setPadding(new Insets(10));
         v.setSpacing(5);
     
     
     return v;
     }
      
      
      
      
      
      
    
    
    
    
    
}
