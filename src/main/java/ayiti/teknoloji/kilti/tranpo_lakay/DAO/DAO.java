/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.DAO;

import ayiti.teknoloji.kilti.tranpo_lakay.Distance;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsPassager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import ayiti.teknoloji.kilti.tranpo_lakay.ModelesChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.ModelesPassager;
import ayiti.teknoloji.kilti.tranpo_lakay.Zone;



/**
 *
 * @author negre
 */
public class DAO {     // Notre classe de connection a MySql

    
    
/*
    Notre methode s'amuse a nous retourner une connection a la base... 
    On l'appelle pour une connection,... Et on oublie pas de fermer cette connection qu'elle retourne 
    et qu'on aura capte dans une variable_connection...
    */
public static Connection methodeConnection(){
    
    String url = "jdbc:mysql://127.0.0.1:3306/db_projet_transport";
    String user = "root";
    String password = "Danie-20";

        try{
        
            //étape 1: charger la classe de driver
            // C'est la mise en place de la plateforme de connection a MySql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // On cree la connection tout en la passant a notre variable de connection
            Connection connection = DriverManager.getConnection(url,user,password);
            
            // On retourne la connection pour ne pas avoir a se connecter trop de fois
            
            //étape 3: créer l'objet statement (on a notre objet d'instruction)
            //Statement stmt = connection.createStatement();
            
            // On l'utilise pour executer nos requetes. Et on passe et on fait que ce soit
            // pointe par notre instace 'ResultSet'
           // ResultSet res = stmt.executeQuery("SELECT* FROM t_depart");
            
            //étape 4: exécuter la requête
            //while(res.next())
            //System.out.println(res.getInt(1)+" "+res.getString(2));  // 1 et 2  pour les colonnes de la tables
            
            
            return connection;
            
            
            
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        
            return null;
        }
      


}




/*
   Methodes qui se chargent de retourner donnees depuis la base a travers des collections... 
*/

/*
  Normalement on aurait du avoir de    ObservableList,    
  mais, comme classe, c'est abstraite... Du coup, on a ces celles-ci, puis on passe en mode 
  observable...
*/

static public List<Zone> listeDesti = new ArrayList();
static public List<Distance> listeDistance = new ArrayList(); static public List<ModelesChauffeur> listeChauffeur = new ArrayList();
static public List<ModelesPassager> listePassager = new ArrayList();
static public List<MailsChauffeur> listeMailsChauffeur = new ArrayList();
static public List<MailsPassager> listeMailsPassager = new ArrayList();

public static ObservableList<Distance> listeDistances;
public static ObservableList<MailsChauffeur> listeMailsChauffeurs;
public static ObservableList<MailsPassager> listeMailsPassagers;
public static ObservableList<ModelesChauffeur> listeChauffeurs;
public static ObservableList<ModelesPassager> listePassagers;
public static ObservableList<Zone> listeDestination;


       
        public static Connection connection = null;
          
    /**
     *
     * @param ob     l'objet en question
     * @param s       pour preciser si c'est  insertion, update, delete
     *            En fait, on laisse cette idee pour l'instant
     */
    public static void methodeListeDesti(Object ob, String s){  // envoie de l'exception, pour aider la fermeture de l'instance connection
           
      
           try{
             
                connection = DAO.methodeConnection();
                Statement stmt = connection.createStatement();
                ResultSet res = stmt.executeQuery("SELECT* FROM t_depart");
               
                
                Statement stmt1 = connection.createStatement();
                ResultSet res1 = stmt1.executeQuery("SELECT* FROM t_distance");
                
                Statement stmt2 = connection.createStatement();
                ResultSet re2 = stmt2.executeQuery("SELECT* FROM t_chauffeur");
                
                Statement stmt3 = connection.createStatement();
                ResultSet res3 = stmt3.executeQuery("SELECT* FROM t_passager");
                
                Statement stmt4 = connection.createStatement();
                ResultSet res4 = stmt4.executeQuery("SELECT* FROM t_mailspassager");
                
                Statement stmt5 = connection.createStatement();
                ResultSet res5 = stmt5.executeQuery("SELECT* FROM t_mailschauffeur");
                
                
                
                while(res.next()){

                   listeDesti.add(new Zone((int)res.getInt(1), (String)res.getString(2)));       // Remplissage de la liste

                }
                
                while(res1.next()){

                   listeDistance.add(new Distance((int)res1.getInt(1), (String)res1.getString(2), (String) res1.getString(3), (int)res1.getInt(4)));       // Remplissage de la liste

                }
                 
                 
                while(re2.next()){

                   listeChauffeur.add(new ModelesChauffeur(re2.getInt(1), (String)re2.getString(2), (String)re2.getString(3), (String)re2.getString(4), (String)re2.getString(5), (String)re2.getString(6), (String)re2.getString(7)));       // Remplissage de la liste

               }
                  
                
                  
                while(res3.next()){

                   listePassager.add(new ModelesPassager(res3.getInt(1),(String)res3.getString(2), (String)res3.getString(3), (String)res3.getString(4), (String)res3.getString(5), (String)res3.getString(6)));       // Remplissage de la liste

               }
                
                while(res4.next()){

                   listeMailsPassager.add(new MailsPassager(res4.getInt(2),(String)res4.getString(3), (String)res4.getString(4)));       // Remplissage de la liste

               }
                
                
                while(res5.next()){

                   listeMailsChauffeur.add(new MailsChauffeur(res5.getInt(2),(String)res5.getString(3), (String)res5.getString(4)));       // Remplissage de la liste

               }
                 
                 
                 
                 
                 
                 
                 
                 
                 

               // if(!listeDistances.isEmpty()){
                 //  listeDistances.clear();
                    listeDistances = FXCollections.observableArrayList(listeDistance);
               // }else
                   //  listeDistances = FXCollections.observableArrayList(listeDistance);
                
              // if(!listeChauffeurs.isEmpty()){
                //   listeChauffeurs.clear();
                   listeChauffeurs = FXCollections.observableArrayList(listeChauffeur);
              // }else
                 //  listeChauffeurs = FXCollections.observableArrayList(listeChauffeur);
               
              // if(!listePassagers.isEmpty()){
               //  listePassagers.clear();
                  listePassagers = FXCollections.observableArrayList(listePassager);
               //}else
                //    listePassagers = FXCollections.observableArrayList(listePassager);
               
              // if(!listeDestination.isEmpty()){
                 //  listeDestination.clear();
                   listeDestination = FXCollections.observableArrayList(listeDesti);
              // }else
               //    listeDestination = FXCollections.observableArrayList(listeDesti);
               
                listeMailsPassagers = FXCollections.observableArrayList(listeMailsPassager);
                
                
                listeMailsChauffeurs = FXCollections.observableArrayList(listeMailsChauffeur);
                System.out.println("==============> Taille 1    "+listeMailsChauffeur.size());
                System.out.println("==============> Taille 2    "+listeMailsChauffeurs.size());
                
                // Insertion ----------------------------------------------------------------------
               
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                 System.out.println("Valeur de la connection avant d'etre coupee "+connection);

                 // On va avoir une deconnection manuelle
          // connection.close();
        
        //return listeDestination;
                  
                  
             //--------------------------------------------------------------------------------------------------
                    
            }catch(Exception e){
        
              
              //  return null;
            }

           
         }
    
    
    public static void deconnexion(){
        
        if(connection != null){
      
    try {
        connection.close();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Dekoneksyon reyisi !" );
       alert.setTitle("Dekoneksyon");

       alert.showAndWait();
        
    } catch (SQLException ex) {
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }else{}
     
    }
        
        
        
        
        
        
        
        
        
        
        
/*
        
        Methodes qui permettent de faire des insertions dans la base... 
        On va avoir une le moment une seule... En parametre, ce sera une collection "Object"...
        Meme si cela ne doit pas pouvoir poser probleme, on fera de Cast...
        
        Apres chaque insertion, on fait appelle a la methode qui retourne la bonne collection,
        puis la methode qui utilise la ou les collections, tout en faisant un nettoyage de collection...
        
*/
        
        
        







}
