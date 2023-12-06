/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.traitement;

import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAO;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAOInsert;
import ayiti.teknoloji.kilti.tranpo_lakay.ModelesChauffeur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

import java.util.regex.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;


/**
 *
 * @author negre
 */
public class CompteChauffeur extends Thread{
    
    TableView<ModelesChauffeur> tableChauffeur;
    
    BorderPane bp;
    static BorderPane bp1;
    TextField nomTF;
    TextField prenomTF;
    TextField sexeTF;
    TextField zoneTF;
    TextField typeTF;
    TextField telTF;
    
    Button btCreer;
    Button btModifier;
    Button btSupprimer;
    
    static HBox hb;
    
    static TextField idTF;
    
    public Pane formnulaireCh(){
        
        
        bp = new BorderPane();
        
    GridPane gridF = new GridPane();
    gridF.setAlignment(Pos.CENTER);
    gridF.setHgap(5);
    gridF.setVgap(5);
    
    Label nomCh = new Label("Siyati ");
    Label prenomCh = new Label("Non ");
    Label sexeCh = new Label("Sèks ");
    Label zoneStationnementCh = new Label("Stasyon ");
    Label typeVoitureCh = new Label("Mak machin ");
    Label telephoneCh = new Label("Telefòn ");
    
    nomTF = new TextField();
    nomTF.setPromptText("15 lèt maksimòm");
    prenomTF = new TextField();
    prenomTF.setPromptText("15 lèt maksimòm");
    sexeTF = new TextField();
    sexeTF.setPromptText("M oubyen maskilen");
    zoneTF = new TextField();
    zoneTF.setPromptText("15 lèt maksimòm");
    typeTF = new TextField();
    typeTF.setPromptText("15 lèt maksimòm");
    telTF = new TextField();
    telTF.setPromptText("xxxx-xx-xx");
    
     btCreer = new Button("Kreye kont");
    btCreer.setOnAction(eh->{
            try {
                methodeTraitementChaqueChauffeur();
            } catch (SQLException ex) {
                Logger.getLogger(CompteChauffeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        });  
    
     btModifier = new Button("Modifye kont");
     btModifier.setOnAction(eh->{
         hb.getChildren().clear();
         hb.getChildren().addAll(tableCh(), methodeId("modifier"));
     });
    // Tant que la propriete de l'element selectionne est nulle, pas de modifier, pas de supprimer
    btModifier.visibleProperty().bind(tableChauffeur.getSelectionModel().selectedItemProperty().isNotNull());
    
     btSupprimer = new Button("Siprime kont");
     btSupprimer.setOnAction(eh->{
         hb.getChildren().clear();
         hb.getChildren().addAll(tableCh(), methodeId("supprimer"));
     });
    btSupprimer.visibleProperty().bind(tableChauffeur.getSelectionModel().selectedItemProperty().isNotNull());
    
    gridF.add(nomCh, 0, 0);
    gridF.add(nomTF, 1, 0);
    gridF.add(prenomCh, 0, 1);
    gridF.add(prenomTF, 1, 1);
    gridF.add(sexeCh, 0, 2);
    gridF.add(sexeTF, 1, 2);
    gridF.add(zoneStationnementCh, 0, 3);
    gridF.add(zoneTF, 1, 3);
    gridF.add(typeVoitureCh, 0, 4);
    gridF.add(typeTF, 1, 4);
    gridF.add(telephoneCh, 0, 5);
    gridF.add(telTF, 1, 5);
    
    gridF.add(btCreer, 0, 7);
    gridF.add(btModifier, 1, 7);
    gridF.add(btSupprimer, 2, 7);
    
    
     Text text1 = new Text("Chofè...");
            text1.setFill(Color.RED);
            text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 60));
    
        bp.setTop(text1);
        bp.setCenter(gridF);
        bp.setPadding(new Insets(10, 5, 10, 5));
    
    
    
    return bp;
    }
    
    
    
    
   public static  ObservableList<ModelesChauffeur> list = null;
    public BorderPane tableCh(){
    
       
       
        
        
         bp1 = new BorderPane();
        
        tableChauffeur = new TableView<ModelesChauffeur>();
        tableChauffeur.setPrefWidth(660);
       
                
                
        TableColumn<ModelesChauffeur, Integer> id = new TableColumn<ModelesChauffeur, Integer>("idantifyan");
        TableColumn<ModelesChauffeur, String> nom = new TableColumn<ModelesChauffeur, String>("Siyati");
        TableColumn<ModelesChauffeur, String> prenom = new TableColumn<ModelesChauffeur, String>("Non");
        TableColumn<ModelesChauffeur, String> sexe = new TableColumn<ModelesChauffeur, String>("Sèks");
        TableColumn<ModelesChauffeur, String> station = new TableColumn<ModelesChauffeur, String>("Stasyon");
        TableColumn<ModelesChauffeur, String> voiture = new TableColumn<ModelesChauffeur, String>("Mak machin");
        TableColumn<ModelesChauffeur, String> telephone = new TableColumn<ModelesChauffeur, String>("telefòn");
        
        
                 
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nomChauffeur"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nomChauffeur"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenomChauffeur"));
        sexe.setCellValueFactory(new PropertyValueFactory<>("sexeChauffeur"));
        station.setCellValueFactory(new PropertyValueFactory<>("zoneStationnementChauffeur"));
        voiture.setCellValueFactory(new PropertyValueFactory<>("typeVoiture"));
        telephone.setCellValueFactory(new PropertyValueFactory<>("telephoneChauffeur"));
        
        
        // On ajoute un ecouteur sur la selection au tableview ----------------------------------------------------
        tableChauffeur.getSelectionModel().selectedItemProperty().addListener(
                    new InvalidationListener() {
                            public void invalidated(Observable ov) {                  
                        if(tableChauffeur.getSelectionModel().selectedItemProperty().isNotNull().get()){
                            
                            // A ce niveau, c'est editable
                       nomTF.setText(tableChauffeur.getSelectionModel().getSelectedItem().getNomChauffeur());
                       prenomTF.setText(tableChauffeur.getSelectionModel().getSelectedItem().getPrenomChauffeur());
                       sexeTF.setText(tableChauffeur.getSelectionModel().getSelectedItem().getSexeChauffeur());
                       zoneTF.setText(tableChauffeur.getSelectionModel().getSelectedItem().getZoneStationnementChauffeur());
                       typeTF.setText(tableChauffeur.getSelectionModel().getSelectedItem().getTypeVoiture());
                       telTF.setText(tableChauffeur.getSelectionModel().getSelectedItem().getTelephoneChauffeur());
                       
                       // Cette forme, c'est quand on ne veut pas que ce soit editable, les champs
                 // nomTF.textProperty().bind(moveToProperty(tableChauffeur.getSelectionModel().getSelectedItem().getNomChauffeur())); 
                 //prenomTF.textProperty().bind(moveToProperty(tableChauffeur.getSelectionModel().getSelectedItem().getPrenomChauffeur()));
                 // sexeTF.textProperty().bind(moveToProperty(tableChauffeur.getSelectionModel().getSelectedItem().getSexeChauffeur()));
                 //zoneTF.textProperty().bind(moveToProperty(tableChauffeur.getSelectionModel().getSelectedItem().getZoneStationnementChauffeur()));
                 //typeTF.textProperty().bind(moveToProperty(tableChauffeur.getSelectionModel().getSelectedItem().getTypeVoiture()));
                 //telTF.textProperty().bind(moveToProperty(tableChauffeur.getSelectionModel().getSelectedItem().getTelephoneChauffeur()));
                        
                 
                 // Profitons du meme coup de mettre a jour les donnees dans la TableView
                 // -> On decharge, -> puis on recharge...
//                 list.clear();
//                 DAO.listeChauffeurs.clear();
//                 DAO.listeChauffeur.clear();
//                 hb.getChildren().clear();
//                 // On recharge
//                 DAO.methodeListeDesti(null, null);
//                 list = DAO.listeChauffeurs;
//                 hb.getChildren().addAll(tableCh(), formnulaireCh()); 
                 
                 
                             
                        }else{
                            try{
                           btModifier.setVisible(false);
                           btSupprimer.setVisible(false);
                            }catch(java.lang.RuntimeException e){}
                        
                        }

                            }         
                    }
        );
        

//------------------------------------------------------------------------
        
       
        
        
        
        
       // if (!list.isEmpty()){
         // list.clear();
          list = DAO.listeChauffeurs;
       // }else
         //list = DAO.listeChauffeurs;
        
        tableChauffeur.setItems(list);
        tableChauffeur.getColumns().addAll(id,nom, prenom, sexe, station, voiture, telephone);
        
        bp1.setCenter(tableChauffeur);
        bp1.setPadding(new Insets(10, 5, 10, 5));
        
            
              
    
    return bp1;
    
    
    
    
   
    }
    
    
    
    
    
    
    
    public HBox methodeHBoxChauffeur(){
        
       
    
          hb = new HBox(5);
         hb.setSpacing(8);
         hb.setAlignment(Pos.CENTER);
         hb.getChildren().addAll(tableCh(), formnulaireCh());    
    
    
     return hb;
    }
    
    
    /*
       Comme nos variables de champs sont de portees globales, pas besoin de prend des parametres...
       Et pour preuve, cette methode va mettre a jour <le tableView> en appelant a chaque fois la methode
       qui remplit la collection de chauffeurs...
    
       Pour les insertions, il y a la methode qui gere dans la classe DAO... On va juste appeler...  Elle
       prend une collection d'Object...
    
    */
    
    public void methodeTraitementChaqueChauffeur() throws SQLException{
        
       String chN = nomTF.getText();
       String chPn = prenomTF.getText();
       String chSx = sexeTF.getText();
       String chZ = zoneTF.getText();
       String chTy = typeTF.getText();
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
               || (chZ.length()==0 || chZ.length() > 15) || (chTy.length()== 0 || chTy.length() > 15) ){
       
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
           ModelesChauffeur chauf = new ModelesChauffeur(0,chN, chPn, chSx, chZ, chTy, chTel);
           
               DAOInsert.methodeInsertModeles(chauf);
       
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
    
    
    
    
    
    
    
    
    
    
    
    /*
    Une methode qui 
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Methode concue pour transformer les       String      en       StringProperty
    // Mais on ne s'en sert pas vraiment
     public StringProperty moveToProperty(String m){
            if(m.isEmpty()){
               return new SimpleStringProperty();
            }
          StringProperty t = new SimpleStringProperty();
           t.setValue(m);
           return t;
         
        }
     
     // Methode pour avoir l'id   de l'objet a supprimer ou modifier,
     // le nombre representant la ligne... 
     static int idInt =0;
     public Pane methodeId(String quoiFaire){               // si c'est     modifier    ou       supprimer
         String chN = nomTF.getText();
         String chPn = prenomTF.getText();
       String chSx = sexeTF.getText();
       String chZ = zoneTF.getText();
       String chTy = typeTF.getText();
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
               hb.getChildren().addAll(tableCh(), formnulaireCh());  
             }else{
                 try{
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
             
                 DAOInsert.methodeUpdateModeles(new ModelesChauffeur(0, chN, chPn, chSx, chZ, chTy, chTel), idInt);
             
                 
                 hb.getChildren().clear();
                 hb.getChildren().addAll(tableCh(), formnulaireCh());  
                 // Ou celle qui modifie, suivant le string saisi
             }else if(quoiFaire.equalsIgnoreCase("supprimer")){
             
                 DAOInsert.methodeDeleteModeles(new ModelesChauffeur(0,chN, chPn, chSx, chZ, chTy, chTel), idInt);
             
                 hb.getChildren().clear();
                 hb.getChildren().addAll(tableCh(), formnulaireCh());  
             }else{
                //--------------- Que dalle !
             }
             
             
             
                   
                   
                   
                   
                }catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Ou dwe antre yon antye..." );
                        alert.setTitle("Pwoblèm");

                        alert.showAndWait();
                         // On revient la ou on etait
                         hb.getChildren().clear();
                         hb.getChildren().addAll(tableCh(), formnulaireCh());  
                         
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
