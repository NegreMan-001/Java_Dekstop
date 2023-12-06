/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.traitement;

import ayiti.teknoloji.kilti.tranpo_lakay.App;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAO;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAOInsert;
import ayiti.teknoloji.kilti.tranpo_lakay.Zone;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author negre
 */
public class Course {
    
    // Il faut une methode qui retourne un container 'Pane', et dedans on fera tous les traitements
    // possibles...
    public static ObservableList<Zone> listeDestinationsDisponibles = null;
    public static ObservableList<String> listeNomDestinationsDisponibles = null;
    public static ObservableList<String> listeDestinationsEnCours = null;
    
    public static ListView<String> listeZone = null;
    
     static String pathImg = null;
    static Image img;
    
   
    public static Pane methodeCourses () throws SQLException{
        // Pour avoir les collections toutes remplies, il faut appeler la methode...
        DAO.methodeListeDesti(null, null);
        
        
        BorderPane root = new BorderPane();
    
       // if(listeDestinationsDisponibles == null){
            
            listeDestinationsDisponibles = DAO.listeDestination;
       
            listeNomDestinationsDisponibles = FXCollections.observableArrayList();
      
           listeDestinationsEnCours = FXCollections.observableArrayList();
     
     
 // creation et formatage du gridpane
GridPane gridpane = new GridPane();
gridpane.setPadding(new Insets(5));
gridpane.setHgap(10);
gridpane.setVgap(10);
ColumnConstraints column1 = new ColumnConstraints(150, 170, Double.MAX_VALUE);
ColumnConstraints column2 = new ColumnConstraints(50);
ColumnConstraints column3 = new ColumnConstraints(150, 170, Double.MAX_VALUE);
column1.setHgrow(Priority.ALWAYS);
column3.setHgrow(Priority.ALWAYS);
gridpane.getColumnConstraints().addAll(column1, column2, column3);

// Du texte    pour les zones servant de destinations
//Label zone = new Label("Destination...");
Text text1 = new Text("Lis katye yo...");
            text1.setFill(Color.WHITESMOKE);
            text1.setFont(Font.font("Chilanka", FontPosture.ITALIC, 30));
GridPane.setHalignment(text1, HPos.CENTER);
gridpane.add(text1, 0, 0);
     

// Du texte pour la creation de la course en cour...
Text text2 = new Text("Lis tout destinasyon yo...");
            text2.setFill(Color.YELLOW);
            text2.setFont(Font.font("Chilanka", FontPosture.ITALIC, 30));
gridpane.add(text2, 2, 0);

GridPane.setHalignment(text2, HPos.CENTER);


// Extraxtion de la liste a noms des zones...

 // if(listeNomDestinationsDisponibles.size() == 0 && listeDestinationsDisponibles.size() == 34){
      
     for (Zone k : listeDestinationsDisponibles){
     listeNomDestinationsDisponibles.add(k.getZoneNom());
      }
     
 
  
  

    listeZone = new ListView<>(listeNomDestinationsDisponibles);
 
gridpane.add(listeZone, 0, 1);
     
     
ListView<String> lesDestinationChoisies = new ListView<>(listeDestinationsEnCours);
lesDestinationChoisies.setOnKeyPressed(new EventHandler<KeyEvent>(){      // usage d'une d'une classe sans nom
                       @Override
                        public void handle(KeyEvent k)
                       {
                       if (k.getCode().equals(KeyCode.ENTER))
                            {
                              if(lesDestinationChoisies.getSelectionModel().selectedItemProperty().isNotNull().getValue()){
                                 //  System.out.println("La destination en cour   "+lesDestinationChoisies.getSelectionModel().getSelectedItem());
                                 // Pour chaque destination disponible, une sorte de guide en image...
                                 String d = lesDestinationChoisies.getSelectionModel().getSelectedItem();
//                                 if(d.equalsIgnoreCase("fontamara")){
//                                     // On va charger l'image pour fontamara
//                                     
//                                 }
                                    methodeFenetreImageGuide(d);
                                    System.out.println("La destination ciblee est "+ d);
                              
                              }else{
                                  
                                  //---------------
                                    methodeFenetreImageGuide("nothing");   // il y a rien
                                  //------------------
                                System.out.println("Anyen menm... ");
                              }
                         }
                      }

});
        
        
gridpane.add(lesDestinationChoisies, 2, 1);


// Traitement des boutons...

//Bouton1    Pour ajouter des destination
Button choix = new Button(" > ");
choix.visibleProperty().bind(listeZone.getSelectionModel().selectedItemProperty().isNotNull());

choix.setOnAction((ActionEvent event) -> {
String choisie = listeZone.getSelectionModel().getSelectedItem();
if (choisie != null) {
listeZone.getSelectionModel().clearSelection();
 //listeDestinationsDisponibles.remove(choisie);          // si on allait eviter plusieurs meme choix
listeDestinationsEnCours.add(choisie);           // On fait l'ajout dans la liste, pas listView, car c'est juste la pour que assurer
                                          // la visualite de la liste elle-meme passee en parametre...
}
});
     
 
// Bouton2    pour enlever de la liste des zones selectionnees...
Button enlever = new Button(" X ");
enlever.visibleProperty().bind(lesDestinationChoisies.getSelectionModel().selectedItemProperty().isNotNull());

enlever.setOnAction((ActionEvent event) -> {
String choixEnlevement = lesDestinationChoisies.getSelectionModel().getSelectedItem();
if (choixEnlevement != null) {
lesDestinationChoisies.getSelectionModel().clearSelection();
listeDestinationsEnCours.remove(choixEnlevement);           
}
});

VBox vbox = new VBox(5);
vbox.getChildren().addAll(choix,enlever);
     
     
gridpane.add(vbox, 1, 1);
gridpane.add(methodeAjoutQuartier(), 0, 2);

root.setCenter(gridpane);
GridPane.setVgrow(root, Priority.ALWAYS);
    
    
    
    
    
    
    
 return root;   
    
}
    
    
    
    
    // La methode pour faire des ajouts de quartiers...
     
    static TextField ajoutTF;
    static Boolean test = false;
    public static Pane methodeAjoutQuartier(){
    
    VBox vb = new VBox();
    Label ajout = new Label("Ajoute katye ");
     ajoutTF = new TextField();
    ajoutTF.setPromptText("Katye...");
     
   
    Button bt = new Button(" Antre ");
    bt.setOnAction(eh->{
        
        Zone zone = new Zone(0, ajoutTF.getText());
        
        
        
       // DAOInsert.methodeInsertModeles(zone);
        
         if((ajoutTF.getText().length() >= 2)){          // pas de chaine vide
             if(listeNomDestinationsDisponibles.size() == 0){
                 DAOInsert.methodeInsertModeles(zone);
             }else{
                 for(String k : listeNomDestinationsDisponibles){
                       if(k.equalsIgnoreCase(ajoutTF.getText())){
                         test = true;
                         break;
                       }
                 }
                 if(test == false){
                 DAOInsert.methodeInsertModeles(zone);
                 }else{
                    System.out.println("Chaine existe deja...\n");
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Katye sa la deja... " );
                    alert.setTitle("Pwoblèm");

                    alert.show();
                 }
                     
                       
              }
            
            
        }            
         else{
            System.out.println("Chaine vide...\n");
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ou pa ekri anyen... " );
                    alert.setTitle("Pwoblèm");

                    alert.show();
        }
    });
    
    vb.setSpacing(5);
    vb.getChildren().addAll(ajout,ajoutTF, bt);

    BorderPane pane = new BorderPane();
    
    pane.setPadding(new Insets(15, 0, 0, 20));
    
    pane.setCenter(vb);
    
    return pane;
    }
    
    
    
    
    
    
    
    
    // Methode pour traiter les cas des images... Une fenetre modale et dependante
   
    public static void methodeFenetreImageGuide(String nomDestination){
    
            if(!nomDestination.isEmpty()){
                
                // delmas, 
                if((nomDestination.equalsIgnoreCase("delmas"))){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Delmas.png").toURI().toString(); 
                    img = new Image(imageURI);
                }
                // carrefour, 
                else if((nomDestination.equalsIgnoreCase("carrefour"))){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Carrefour.png").toURI().toString(); 
                    img = new Image(imageURI);
                }
                // petionville
                else if((nomDestination.equalsIgnoreCase("petionville"))){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Carte1.png").toURI().toString(); 
                    img = new Image(imageURI);
                }// fouchard, route des dalles, martissant, bolosse, mullet, sicot, titus, avenue N, Rue O, sapotille, 
                 // rue cameau, rue nicolas, rue roy, fontamara
                 else if((nomDestination.equalsIgnoreCase("fourchard")) || (nomDestination.equalsIgnoreCase("route des dalles")) 
                         || (nomDestination.equalsIgnoreCase("martissant")) || (nomDestination.equalsIgnoreCase("Bolosse"))
                         || (nomDestination.equalsIgnoreCase("Mullet")) || (nomDestination.equalsIgnoreCase("Sicot"))
                         || (nomDestination.equalsIgnoreCase("Titus")) || (nomDestination.equalsIgnoreCase("Avenue N"))
                         || (nomDestination.equalsIgnoreCase("Rue O")) || (nomDestination.equalsIgnoreCase("Sapotille"))
                         || (nomDestination.equalsIgnoreCase("Rue cameau")) || (nomDestination.equalsIgnoreCase("Rue Nicolas"))
                         || (nomDestination.equalsIgnoreCase("Rue Roy")) || (nomDestination.equalsIgnoreCase("Fontamara"))
                         ){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Martissant.png").toURI().toString(); 
                    img = new Image(imageURI);
                }// mariani, lambi, 
                 else if((nomDestination.equalsIgnoreCase("mariani")) || (nomDestination.equalsIgnoreCase("lambi")) ){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Mariani_Lambi.png").toURI().toString(); 
                    img = new Image(imageURI);
                }// rue des cesars, rue du peuple, rue bonne foi, 
                else if((nomDestination.equalsIgnoreCase("Rue des Cesars")) || (nomDestination.equalsIgnoreCase("rue du peuple"))
                     || (nomDestination.equalsIgnoreCase("rue bonne foi")) || (nomDestination.equalsIgnoreCase("rue docteur Aubry"))
                     || (nomDestination.equalsIgnoreCase("rue caonabo")) || (nomDestination.equalsIgnoreCase("rue sylvio cator"))
                     || (nomDestination.equalsIgnoreCase("poupelard")) || (nomDestination.equalsIgnoreCase("rue pavee"))
                     || (nomDestination.equalsIgnoreCase("rue de la reunion")) || (nomDestination.equalsIgnoreCase("rue des casernes"))
                     || (nomDestination.equalsIgnoreCase("rue du quai")) || (nomDestination.equalsIgnoreCase("rue saint-honore"))
                     || (nomDestination.equalsIgnoreCase("rue dufort")) || (nomDestination.equalsIgnoreCase("avenue john brown"))
                     || (nomDestination.equalsIgnoreCase("rue berne")) || (nomDestination.equalsIgnoreCase("rue robin"))
                     || (nomDestination.equalsIgnoreCase("Avenue lamartiniere")) || (nomDestination.equalsIgnoreCase("rue joseph janvier"))
                     || (nomDestination.equalsIgnoreCase("rue chareron")) || (nomDestination.equalsIgnoreCase("rue mandela"))
                        ){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Rue_bonne_foie.png").toURI().toString(); 
                    img = new Image(imageURI);
                }// tabarre
                else if((nomDestination.equalsIgnoreCase("tabarre"))){
                
                  final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Tabarre.png").toURI().toString(); 
                    img = new Image(imageURI);
                }else{
                    // Sinon, 
                    // un algo avec des valeurs au hasard pour afficher des images... 
                     String imageURI2 = null;
                          int low = 1;                             // the lowest value in the range
                          int high = 7;                             // the highest value in the range

                          int rnd = (int)(Math.random() * (high - low + 1)) + low; 
                          System.out.println("La valeur tiree dans le hasard "+rnd);
                          switch(rnd){
                          
                               case 1: 
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/Tabarre.png").toURI().toString();
                            img = new Image(imageURI2);
                            break;
   
                                case 2:
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/Mariani_Lambi.png").toURI().toString();
                            img = new Image(imageURI2);
                            break;
   
                                case 3:
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/Fouchard.png").toURI().toString();
                            img = new Image(imageURI2);
                            break;
                                case 4:
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/Haiti.png").toURI().toString();
                            img = new Image(imageURI2);
                            break;
                                case 5:
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/Port-au-Prince.png").toURI().toString();
                            img = new Image(imageURI2);
                            break;
                                case 6:
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/transport2.jpg").toURI().toString();
                            img = new Image(imageURI2);
                            break;
                                case 7:
                            imageURI2 = new File("/home/negre/negre_l3_projet_TRANSPORT/transportA.png").toURI().toString();
                            img = new Image(imageURI2);    
                            break;
                                default:
                                    // ce qui n'arrivera pas
                                    System.out.println("Choix incorrect");
                                break;
                          
                          }
                
                    //final String imageURI = new File("/home/negre/negre_l3_projet_TRANSPORT/Tabarre.png").toURI().toString(); 
                    
                
                }
                
                
               

              //  if(!pathImg.isEmpty()){
                
                Stage imageGuide = new Stage();
                BorderPane root = new BorderPane();
                
                 
                 ImageView imgV = new ImageView(img);
              //  Button bt = new Button("Autre Truc...");
                    
                root.setCenter(imgV);
                
			Scene scene = new Scene(root,1300,550 );
//                        img.widthProperty().addListener(
//                                        new InvalidationListener() {
//                            public void invalidated(Observable ov) {                  
//                               
//                                
//                            }         
//                           }
//                        );
                        
                        
			imageGuide.setScene(scene);
                        imageGuide.setWidth(1300);
                        imageGuide.setHeight(550);
                        imageGuide.initStyle(StageStyle.DECORATED);
                        imageGuide.initOwner(App.stagePrim);           // Cette fenetre est dependante a   stagePrim
                        imageGuide.initModality(Modality.WINDOW_MODAL);
                        if(nomDestination.equalsIgnoreCase("nothing")){
                            imageGuide.setTitle("Gid sikilasyon pou" +" 0 destinasyon");
                        }else{
                            imageGuide.setTitle("Gid sikilasyon pou " + nomDestination);   
                        }
                       
            
                
                        imageGuide.show();
//                }else{
//                     
//                    System.out.println("Probleme d'image...");
//                    
//                
//                }
                
            
            
            
            }else{
            
                System.out.println("La chaine passee est vide... On n'a pas de destination ciblee...");
                
            }
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
}
