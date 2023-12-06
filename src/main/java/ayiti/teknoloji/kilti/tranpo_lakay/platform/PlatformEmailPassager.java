/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.platform;

import ayiti.teknoloji.kilti.tranpo_lakay.App;
import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAO;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsPassager;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author negre
 */
public class PlatformEmailPassager {
    
    
     // Pour la methode qui va generer la forme pour l'envoie des mails...
    static Stage stage1;
    static TextField addrReceveur;
    static BorderPane bp;
    static TextField addrEnvoyeur;
    static TextField sujet;
    static TextArea messageA;
    static public Button bt, bt1;
    static public GridPane gpa = new GridPane();
    static StringProperty code;
    public static Pane methodePourLenvoieDesMails(){
        
         bp = new BorderPane();
    
         VBox vb1 = new VBox();
         vb1.setSpacing(10);
         vb1.setAlignment(Pos.CENTER);
         //VBox vb2 = new VBox();
         
          bt = new Button(" Voye ale ");
          bt.setOnAction(eh->{
             
             try {
                 methodeVoyeMeyl0();
             } catch (IOException ex) {
                 Logger.getLogger(PlatformEmailPassager.class.getName()).log(Level.SEVERE, null, ex);
             }
             
          });
          bt1 = new Button(" Fèmen ");
          bt1.setOnAction(eh->{
              stage1.close();
          });
         
         
      HBox hb1 = new HBox();
      hb1.setAlignment(Pos.CENTER);
      hb1.setSpacing(5);
      HBox hb2 = new HBox();
      hb2.setAlignment(Pos.CENTER);
      hb2.setSpacing(5);
      HBox hb3 = new HBox();
      hb3.setAlignment(Pos.CENTER);
      hb3.setSpacing(5);
      HBox hb0 = new HBox();
      hb0.setAlignment(Pos.CENTER);
      hb0.setSpacing(5);
      
      
      Text tx = new Text("Platfom masaj meyl ");
          tx.setFill(Color.WHITE);
          tx.setFont(Font.font("Helvetica", FontPosture.ITALIC, 30));
      hb0.getChildren().add(tx);
      
     addrEnvoyeur = new TextField();
     addrEnvoyeur.setPromptText(" mounkapvoyea@gmail.com ");
     gpa.add(new Label("                  "), 0, 0);
     gpa.add(new Label(" Moun kap voye a: "), 1, 1);
     gpa.add(addrEnvoyeur, 2, 1);
     addrReceveur = new TextField();
     addrReceveur.setPromptText(" mounkapresevwaa@gmail.com ");
     gpa.add(new Label(" Moun kap resevwa a: "), 1, 2);
     gpa.add(addrReceveur, 2, 2);
     sujet = new TextField();
     sujet.setPromptText(" Poukisa wap voye mesay sa? ");
     gpa.add(new Label(" Sijè a: "), 1, 3);
     gpa.add(sujet, 2, 3);
     gpa.add(new Label("                  "), 2, 4);
     gpa.add(new Label("                  "), 2, 5);
     gpa.setHgap(5);
     gpa.setVgap(5);
     
     
     vb1.getChildren().addAll(hb0, gpa);
     
     
     messageA = new TextArea();
     messageA.setPromptText("Kinan nou yo, kouman nou ye, \n\n"
                     + "ti bat bouch sa, se nan lide rive\n"
                     + "fe w konnen ki kokennchenn plezi sa fe\n"
                     + "paske w ave nou nan transpo a...\n\n"
                     + "Transpo_Lakay   \n\n"
                     + "Lizay...");
     
     GridPane gpb = new GridPane();
     gpb.setHgap(5);
     gpb.setVgap(5);
     gpb.add(new Label("                   "), 0, 0);
     gpb.add(vb1, 1, 1);
     gpb.add(new Label("                "), 0, 2);
     gpb.add(messageA, 1, 3, 5, 9);
     
     gpb.add(new Label("                      "), 1, 16);
     gpb.add(new Label("                      "), 1, 17);
     gpb.add(bt1, 4, 18);
     gpb.add(bt, 5, 18);
     
    
      bp.setPadding(new Insets(10, 10, 15, 30));
      bp.setCenter(gpb);
    
    
    
    
    
    
    
    
    
    
    
    return bp;
    }
    
    
    
    
    
    
    
    
    
// Pour la methode qui va gerer le tableview des adresses aux chauffeurs... 

    

    static BorderPane bp1;
    static TableView<MailsPassager> tableMailsPassager;
    
    
    public static Pane methodeTableViewMailsPassager(){
   
        


    
       
       
        
        
         bp1 = new BorderPane();
        
        tableMailsPassager = new TableView<>();
         tableMailsPassager.setPrefWidth(460);
       
                
                
        TableColumn<MailsPassager, Integer> idC = new TableColumn<>("  idantifyan  ");
        TableColumn<MailsPassager, String> addressC = new TableColumn<>("  Adres elektronik  ");
        TableColumn<MailsPassager, String> codeC = new TableColumn<>("  Kod  ");
      
        
        
                 
        idC.setCellValueFactory(new PropertyValueFactory<>("idPassager"));
        addressC.setCellValueFactory(new PropertyValueFactory<>("address"));
        codeC.setCellValueFactory(new PropertyValueFactory<>("code"));
       
        
        
        // On ajoute un ecouteur sur la selection au tableview ----------------------------------------------------
        tableMailsPassager.getSelectionModel().selectedItemProperty().addListener(
                    new InvalidationListener() {
                            public void invalidated(Observable ov) {                  
                        if(tableMailsPassager.getSelectionModel().selectedItemProperty().isNotNull().get()){
                 
                 // Cette forme, c'est quand on ne veut pas que ce soit editable, les champs,
                 // On aura une adresse selectionnee dedans...
                addrEnvoyeur.textProperty().bind(moveToProperty(tableMailsPassager.getSelectionModel().getSelectedItem().getAddress())); 
                 code = new SimpleStringProperty();
                code.bind(moveToProperty( tableMailsPassager.getSelectionModel().getSelectedItem().getCode()));
                             
                        }else{
                          bt.setVisible(false);
                         //  btSupprimer.setVisible(false);
                        
                        }

                            }         
                    }
        );
        

//------------------------------------------------------------------------
        
       
        
        
        
        
       // if (!list.isEmpty()){
         // list.clear();
         // listMailsChauf = DAO.listeMailsChauffeurs;
       // }else
         //list = DAO.listeChauffeurs;
        
        tableMailsPassager.setItems(DAO.listeMailsPassagers);
        tableMailsPassager.getColumns().addAll(idC,addressC, codeC);
        
        bp1.setCenter(tableMailsPassager);
        bp1.setPadding(new Insets(10, 5, 10, 5));
        
            
              
    
    return bp1;
    
    }
    

  //-----------------------------------------------------------------------------------------------------------  
    
    
     public static void methodeFenetreMailsPassager(){
     stage1 = new Stage();
     
     BorderPane b = new BorderPane();
     HBox h = new HBox();
     h.getChildren().addAll(methodeTableViewMailsPassager(), methodePourLenvoieDesMails());
     b.setCenter(h);
    
    Scene scene1 = new Scene(b, 1098, 600);
                       
                        stage1.setScene(scene1);
                 
                        stage1.initStyle(StageStyle.DECORATED);
                        stage1.initOwner(App.stagePrim);           // Cette fenetre est dependante au stage     st, qui represente une fenetre
                        stage1.initModality(Modality.WINDOW_MODAL);
                        stage1.setTitle("   Platfom mesaj 'E-mail' Passaje   ");
                        
            
                
                        stage1.show();
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        public static StringProperty moveToProperty(String m){
            if(m.isEmpty()){
               return new SimpleStringProperty();
            }
          StringProperty t = new SimpleStringProperty();
           t.setValue(m);
           return t;
         
        }
    
    
        
        
        
        
        
        
        //-----------------------------------------------------------------------------------------------------
        // Pour le tranfert des mails...
        // Recipient's email ID needs to be mentioned.
       // static String to = "negreman6@gmail.com";

        // Sender's email ID needs to be mentioned
       // static String from = "danydaniedany1@gmail.com";

        // Assuming you are sending email from through gmails smtp
        static String host = "smtp.gmail.com";

        // Get system properties
        static Properties properties = System.getProperties();

        public static void methodeVoyeMeyl0() throws IOException{
            
            if((addrReceveur.getText().isEmpty()) || (addrEnvoyeur.getText().isEmpty()) || 
                                (sujet.getText().isEmpty()) || (messageA.getText().isEmpty())){
                Alert al = new Alert(Alert.AlertType.ERROR, " Tout chan yo dwe gen kichoy ladan... ");
                al.setTitle(" Pwoblem avek done chan yo... ");
                al.show();
            }else{
        
             // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = null;
        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(addrEnvoyeur.getText(), code.getValue());

            }

        });
       

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(addrEnvoyeur.getText()));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(addrReceveur.getText()));

            // Set Subject: header field
            message.setSubject(sujet.getText());

            // Now set the actual message
            message.setText(messageA.getText());

            System.out.println("Mesaj la nan wout...");
            // Send message
            Transport.send(message);
            System.out.println("Tout bagay byen pase...");
                Alert al = new Alert(Alert.AlertType.INFORMATION, " Mesaj la ale jwenn "+addrReceveur.getText());
                al.setTitle(" Anfom... ");
                al.show();
        } catch (MessagingException mex) {
                Alert al = new Alert(Alert.AlertType.ERROR, " Konsilte koneksyon entenet ou, ak tout done ki antre yo... ");
                al.setTitle(" Pwoblem... ");
                al.show();
        }
        
        
        
        
        
        
            }
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    
}
