/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.MailsPassager;
import ayiti.teknoloji.kilti.tranpo_lakay.ModelesChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.ModelesPassager;
import ayiti.teknoloji.kilti.tranpo_lakay.Zone;
import ayiti.teknoloji.kilti.tranpo_lakay.traitement.CompteChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.traitement.ComptePassager;
import ayiti.teknoloji.kilti.tranpo_lakay.traitement.Course;
import static ayiti.teknoloji.kilti.tranpo_lakay.traitement.Course.listeNomDestinationsDisponibles;
import ayiti.teknoloji.kilti.tranpo_lakay.traitement.TableViewDestination;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author negre
 */
public class DAOInsert {
    
    public static Connection methodeConnection(){
    
    String url = "jdbc:mysql://127.0.0.1:3306/db_projet_transport";
    String user = "root";
    String password = "Danie-20";

        try{
            
            Connection connection= null;
     
            
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
             connection = DriverManager.getConnection(url,user,password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            // On cree la connection tout en la passant a notre variable de connection
            

            
            return connection;

        }catch(SQLException e){
        
        
            return null;
        }
      


}


    
     static Connection connectionInsert = null;
    public static ArrayList<MouvementDansLaBase> mouvementSurLaBase = new ArrayList<>();  //     notre indicateur de mouvement_en_base
    public static void methodeInsertModeles(Object tob){                   // On insert que des objets... Tout type
        
                 
      
           try{
               
                // Insertion de chauffeurs -----------------------------------------------------------
             if(tob instanceof ModelesChauffeur){

            ModelesChauffeur t = (ModelesChauffeur) tob;
            
            CompteChauffeur.list.add(t);
        
         String nom = t.getNomChauffeur();
         String prenom = t.getPrenomChauffeur();
         String sexe = t.getSexeChauffeur();
         String zone = t.getZoneStationnementChauffeur();
         String type = t.getTypeVoiture();
         String tel = t.getTelephoneChauffeur();
         
         
      String requete = "INSERT INTO t_chauffeur(nom, prenom, sexe, zone_stationnement, type_voiture, telephone) VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+zone+"','"+type+"','"+tel+"')";
           
     connectionInsert = methodeConnection();
      Statement stmt = connectionInsert.createStatement();
      stmt.executeUpdate(requete);
      
     
      // On met a jour la collection
               CompteChauffeur.list.clear();
               DAO.listeChauffeur.clear();
               DAO.listeChauffeurs.clear();
               DAO.methodeListeDesti(null, null);
               CompteChauffeur.list.addAll(DAO.listeChauffeurs);
               
               
      
      System.out.println("Insertion reussie...");
            
        }
        
             
             // Insertion de passagers...------------------------------------------------------------------
         
        if(tob instanceof ModelesPassager){
            ModelesPassager t = (ModelesPassager) tob;
            
             ComptePassager.list.add(t);
        
         String nom = t.getNomPassager();
         String prenom = t.getPrenomPassager();
         String sexe = t.getSexePassager();
         String occup = t.getOccupationPassager();
         String tel = t.getTelephonePassager();
            
            
         String requete = "INSERT INTO t_passager(nom, prenom, sexe, occupation, telephone) VALUES('"+nom+"','"+prenom+"','"+sexe+"','"+occup+"','"+tel+"')";
         Statement stmt = connectionInsert.createStatement();
              stmt.executeUpdate(requete);   
        
            
              // On met a jour la collection
               ComptePassager.list.clear();
               DAO.listePassager.clear();
               DAO.listePassagers.clear();
               DAO.methodeListeDesti(null, null);
               ComptePassager.list.addAll(DAO.listePassagers);
              
       
        }
        
        
        
        
        
        
        
        
        if(tob instanceof Zone){
            
            connectionInsert = methodeConnection();
        
        Zone t = (Zone)tob;
        
        String quartier = t.getZoneNom();
        String requete = "INSERT INTO t_depart(zone_depart) VALUES('"+quartier+"')";
       
        Statement stmt = connectionInsert.createStatement();
              stmt.executeUpdate(requete);   
              
              // On vide toutes les collections concernees
              Course.listeNomDestinationsDisponibles.clear();
               System.out.println("////////******** nom destinations...   "+Course.listeNomDestinationsDisponibles.size());
              
              Course.listeDestinationsDisponibles.clear();
              
              DAO.listeDestination.clear();
             DAO.listeDesti.clear();
              System.out.println("////////******** nom destinations...   "+DAO.listeDestination.size());
              
              
              TableViewDestination.list.clear();
        
              
              // On recharge
              DAO.methodeListeDesti(null, null);
              System.out.println("////////******** nom destinations...   "+DAO.listeDestination.size());
             // Course.listeDestinationsDisponibles.addAll(DAO.listeDestination);
               for (Zone k : DAO.listeDestination){
                    listeNomDestinationsDisponibles.add(k.getZoneNom());
                    }
               System.out.println("////////******** nom destinations...   "+DAO.listeDestination.size());
               
               
               System.out.println("////////******** nom destinations...   "+Course.listeNomDestinationsDisponibles.size());
               Course.listeZone.setItems(listeNomDestinationsDisponibles);
               System.out.println("////////******** nom destinations...   "+Course.listeNomDestinationsDisponibles.size());
              
              
              TableViewDestination.list.addAll(DAO.listeDestination);
              
              //Course.methodeCourses();
              
              
              
              
        }
        
        
        
        //----------------------------------------------------------------------------------------------------------------
        
         if(tob instanceof MailsPassager){
              connectionInsert = methodeConnection();
            MailsPassager t = (MailsPassager) tob;
            
             //ComptePassager.list.add(t);
        
         int idPassager = t.getIdPassager();
         String addressP = t.getAddress();
         String codeP = t.getCode();
            
         System.out.println("/////// Toutes les valeurs  passager "+idPassager+" "+addressP+" "+codeP);
            try{
        String requete = "INSERT INTO t_mailspassager(id_passager, address, code_address) VALUES("+idPassager+",'"+addressP+"','"+codeP+"')";
         Statement stmt = connectionInsert.createStatement();
              stmt.executeUpdate(requete);   
            }catch(SQLException e){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Verifye nimewo pasaje a byen... " );
                          alert.setTitle("Pwoblèm nan done yo");
                          alert.show();
            }
//              // On met a jour la collection
               DAO.listeMailsPassagers.clear();
               DAO.listeMailsPassager.clear();
               DAO.methodeListeDesti(null, null);

              
       
        }
         
     //------------------------------------------------------------------------------------------------------------------
       if(tob instanceof MailsChauffeur){
            connectionInsert = methodeConnection();
            
            MailsChauffeur t = (MailsChauffeur) tob;
            
             //ComptePassager.list.add(t);
        
         int idChaffeur = t.getIdChauffeur();
         String addressCh = t.getAddress();
         String codeCh = t.getCode();
            
         System.out.println("/////// Toutes les valeurs  chauffeur "+idChaffeur+" "+addressCh+" "+codeCh);
            try{
         String requete = "INSERT INTO t_mailschauffeur(id_chauffeur, address, code_address) VALUES("+idChaffeur+",'"+addressCh+"','"+codeCh+"')";
         Statement stmt = connectionInsert.createStatement();
              stmt.executeUpdate(requete);   
            }catch(SQLException e){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Verifye nimewo chofè a byen... " );
                          alert.setTitle("Pwoblèm nan done yo");
                          alert.show();
            }
//              // On met a jour la collection
               DAO.listeMailsChauffeurs.clear();
               DAO.listeMailsChauffeur.clear();
               DAO.methodeListeDesti(null, null);
              
       
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Pour chaque insertion, cette collection nous dit qu'il y a du mouvement...
          //mouvementSurLaBase.add(new MouvementDansLaBase());     
               
          
               
 
               
                // Insertion avec des requetes preparees...
    //             System.out.println("Probleme 1\n");
//  String sqlRequete = "INSERT INTO t_passager(nom, prenom, sexe, zone_stationnement, type_voiture, telephone) VALUES(?,?,?,?,?,?)";
//               System.out.println("Probleme 2\n");
// PreparedStatement prepare = connectionInsert.prepareStatement(sqlRequete);
////  System.out.println("Probleme 3\n");
//////               // prepare.setInt(1, );
//                System.out.println("Probleme A\n");
//                prepare.setString(2, s1);
//                System.out.println("Probleme B\n");
//                prepare.setString(3, s2);
//                System.out.println("Probleme C\n");
//                prepare.setString(4, s3);
//                System.out.println("Probleme D\n");
//                prepare.setString(5, s4);
//                System.out.println("Probleme E\n");
//                prepare.setString(6, s5);
//                System.out.println("Probleme F\n");
//               // prepare.setString(7, s6);
//                System.out.println("Probleme 4\n");
//                prepare.executeUpdate();
//       
//         System.out.println("Probleme 5\n");
//                
//
//                
//                System.out.println("No insert problem.......\n");
//                
//              

      
        
        //return listeDestination;
                  
                  
             //--------------------------------------------------------------------------------------------------
                    
            }catch(SQLException e){
        
              System.out.println("Probleme d'insertion...... \n");
              //  return null;
            }

           
         }
    
    
    
    
    //---------------------------------------------------------------------------------------------------------

    /**
     *
     * @param tob      on en veut juste une instance, pour pouvoir identifier la bonne classe
     * @param id            pour la suppression du bon objet...
     */
    public static void methodeUpdateModeles(Object tob, int id){
    
        try{
            connectionInsert = methodeConnection();
            
             if(tob instanceof ModelesChauffeur){
                 ModelesChauffeur t = (ModelesChauffeur)tob;
                 String n = t.getNomChauffeur();
                 String p = t.getPrenomChauffeur();
                 String s = t.getSexeChauffeur();
                 String z = t.getZoneStationnementChauffeur();
                 String ty = t.getTypeVoiture();
                 String te = t.getTelephoneChauffeur();
                 
                 
                 
 String requete = "UPDATE t_chauffeur SET nom ='"+n+"',prenom='"+p+"',sexe='"+s+"',zone_stationnement='"+z+"',type_voiture='"+ty+"',telephone='"+te+"' WHERE id="+id;
         Statement stmt = connectionInsert.createStatement();
         stmt.executeUpdate(requete);
         
         
         // On met a jour la collection
               CompteChauffeur.list.clear();
               DAO.listeChauffeur.clear();
               DAO.listeChauffeurs.clear();
               DAO.methodeListeDesti(null, null);
               CompteChauffeur.list.addAll(DAO.listeChauffeurs);
                 
                 
             }
             
             
              if(tob instanceof ModelesPassager){
                  
                  ModelesPassager t = (ModelesPassager)tob;
                  
                  String n = t.getNomPassager();
                 String p = t.getPrenomPassager();
                 String s = t.getSexePassager();
                 String o = t.getOccupationPassager();
                 String te = t.getTelephonePassager();
                  
                  
String requete = "UPDATE t_passager SET nom ='"+n+"',prenom='"+p+"',sexe='"+s+"',occupation='"+o+"',telephone='"+te+"' WHERE id="+id;
         Statement stmt = connectionInsert.createStatement();
         stmt.executeUpdate(requete);
         
         
         // On met a jour la collection
              
               ComptePassager.list.clear();
               DAO.listePassager.clear();
               DAO.listePassagers.clear();
               DAO.methodeListeDesti(null, null);
               ComptePassager.list.addAll(DAO.listePassagers);
              
            
       
                  
              }
              
              
               // Pour chaque modification, cette collection nous dit qu'il y a du mouvement...
          mouvementSurLaBase.add(new MouvementDansLaBase());  
          
          
  
    
        }catch(SQLException e){
            
            System.out.println("Probleme dans la modification...");
             
        }
    
    
    
    
    }
    
    
    
    
    
    
    
    //----------------------------------------------------------------------------------------------------

    /**
     *
     * @param tob      on en veut juste un objet sous la forme, pour pouvoir identifier la bonne classe
     * @param id            pour la suppression du bon objet...
     */
    public static void methodeDeleteModeles(Object tob, int id){
    
    
    try{
        connectionInsert = methodeConnection();
      
        
     if(tob instanceof ModelesChauffeur){
         String requete = "DELETE FROM t_chauffeur WHERE id="+id;
         Statement stmt = connectionInsert.createStatement();
         stmt.executeUpdate(requete);
         
          // On met a jour la collection
     for(ModelesChauffeur t : CompteChauffeur.list){
         if(t.getId() == id){
             //int index = ComptePassager.list.indexOf(t);
             try{
             CompteChauffeur.list.remove(t);
             }catch(java.lang.RuntimeException e){}
            
             break;
         }
         
    }
         
     }
    
     if(tob instanceof ModelesPassager){
         String requete = "DELETE FROM t_passager WHERE id="+id;
         
         Statement stmt = connectionInsert.createStatement();
         stmt.executeUpdate(requete);
         
          // On met a jour la collection
          for(ModelesPassager t : ComptePassager.list){
         if(t.getId() == id){
             //int index = ComptePassager.list.indexOf(t);
             ComptePassager.list.remove(t);
            
             break;
         }
    }
         
     }
    
           
      // Pour chaque suppression, cette collection nous dit qu'il y a du mouvement...
         // mouvementSurLaBase.add(new MouvementDansLaBase());     
          // Une suppression dans la collection en cours d'utilisation
   
        
    }catch(SQLException e){
    
        System.out.println("Probleme dans la suppression...\n");

    }
    
    
    }
    
   
    
    
    
    
    
    
    
    //---------------------------- Notre innerClasse mouvementDansLaBase
    // On a cree pour un service, mais on utilise un autre moyen... 
    private static class MouvementDansLaBase{

        public MouvementDansLaBase() {
        }
 
    
    }
    
    
    
    
    
    
    
    
}
