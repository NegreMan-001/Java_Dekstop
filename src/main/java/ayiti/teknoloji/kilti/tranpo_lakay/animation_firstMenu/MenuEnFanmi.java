/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ayiti.teknoloji.kilti.tranpo_lakay.animation_firstMenu;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import ayiti.teknoloji.kilti.tranpo_lakay.App;
import ayiti.teknoloji.kilti.tranpo_lakay.SystemInfo;
import static ayiti.teknoloji.kilti.tranpo_lakay.SystemInfo.mp;
import static ayiti.teknoloji.kilti.tranpo_lakay.SystemInfo.st;
import ayiti.teknoloji.kilti.tranpo_lakay.parametre.Parametre;
import ayiti.teknoloji.kilti.tranpo_lakay.platform.PlatformEmailChauffeur;
import ayiti.teknoloji.kilti.tranpo_lakay.platform.PlatformEmailPassager;
import ayiti.teknoloji.kilti.tranpo_lakay.traitement.AffichageParOnglet;


/**
 *
 * @author negre
 */
public class MenuEnFanmi {
    
    public static MenuBar the_menu(){
    
        // la barre du menu
        MenuBar menuBar = new MenuBar();
        
        // Les menus et leurs sous-menus et menus
        
        Menu option = new Menu("Opsyon");
        Menu paiement = new Menu("tranzaksyon");
        MenuItem monCash = new MenuItem("Mon-Cash");
        MenuItem natCash = new MenuItem("Nat-Cash");
        paiement.getItems().addAll(monCash, natCash);
                
        Menu course = new Menu("Kous");
        MenuItem creerCourse = new MenuItem("Kreye kous");
        creerCourse.setOnAction(eh->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Ale nan ==>  Afichay " );
             alert.setTitle("Enstriksyon");

       alert.showAndWait();
       
        });
        course.getItems().add(creerCourse);
                
        Menu compte = new Menu("Kont");
        MenuItem creerCompte = new MenuItem("Kreye kont");
        creerCompte.setOnAction(eh->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Ale nan ==>  Afichay " );
             alert.setTitle("Enstriksyon");

       alert.showAndWait();
        });
        compte.getItems().add(creerCompte);
        
        MenuItem parametre = new MenuItem("Paramèt");
        parametre.setOnAction(eh->{
        
            Parametre.methodeParametre();
            
        });
        
        MenuItem pagePrincipale = new MenuItem("Tounen a 0");
        pagePrincipale.setOnAction(eh->{
            App.pane1.setCenter(AnimationEnFanmi.completeMethod());
        });
        
        MenuItem quitter = new MenuItem("Kite");
        quitter.setOnAction(eh->{
           // DAO.closeConnection();         // Ici, on ferme e=la connection avec la base
            Platform.exit();
        });
        
        option.getItems().addAll(course, 
                   new SeparatorMenuItem(),
                compte, 
                new SeparatorMenuItem(),
                paiement,
                new SeparatorMenuItem(),
                parametre, 
                new SeparatorMenuItem(),
                pagePrincipale,
                new SeparatorMenuItem(),
                quitter);
        menuBar.getMenus().add(option);
        
        
        Menu afficher = new Menu("Afichay");
        MenuItem tout = new MenuItem("Koze sou sikilasyon");
        tout.setOnAction(eh->{
            try {
                // TableViewDestination.methodeTableViewDestination()
                App.pane1.setCenter(AffichageParOnglet.afficherParOngle());
            } catch (SQLException ex) {
                Logger.getLogger(MenuEnFanmi.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        MenuItem onglet = new MenuItem("Tout Koze");
        onglet.setOnAction(eh->{
            try {
                App.pane1.setCenter(AffichageParOnglet.afficherParOngle());
            } catch (SQLException ex) {
                Logger.getLogger(MenuEnFanmi.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        afficher.getItems().addAll(tout, 
                new SeparatorMenuItem(),
                onglet);
         menuBar.getMenus().add(afficher);
        
        
         
         Menu communaute = new Menu("Kominote");
         Menu passagers = new Menu("pasaje");
         MenuItem mailPa = new MenuItem("Platfòm 'E-mail'");
         mailPa.setOnAction(eh->{
             PlatformEmailPassager.methodeFenetreMailsPassager();
         });
//         MenuItem smsPa = new MenuItem("Platfom SMS");
//         MenuItem whatsappPa = new MenuItem("Platfom watsap");
         passagers.getItems().addAll(mailPa);
         
         Menu chauffeur = new Menu("chofe");
         MenuItem mailCh = new MenuItem("Platfòm 'E-mail'");
         mailCh.setOnAction(eh->{
             PlatformEmailChauffeur.methodeFenetreMailsChauffeur();
         });
//         MenuItem smsCh = new MenuItem("Platfom SMS");
//         MenuItem whatsappCh = new MenuItem("Platfom watsap");
         chauffeur.getItems().addAll(mailCh);
         
//         MenuItem melange = new MenuItem("pasaje ak chofe");
//         melange.setOnAction(eh->{
//            // CommunauteMails.methodeVoyeMeyl();
//         });
         
         communaute.getItems().addAll(passagers, new SeparatorMenuItem(), chauffeur);
         menuBar.getMenus().add(communaute);
         
         
         Menu aide = new Menu("Lòt koze...");
         MenuItem aPropos = new MenuItem("Transpò Lakay");
         aPropos.setOnAction(eh->{
            App.pane1.setCenter(SystemInfo.methodeText());
            //App.pane1.setCenter(AnimationEnFanmi.animationAcc());
         });
         MenuItem culture = new MenuItem("Koze Sikilasyon ak Kilti");
         culture.setOnAction(eh->{
             // Appel a la methode qui fait le stage avec ces videos au hasard
             SystemInfo.methodeMedia();
            st.showingProperty().addListener(
                       new InvalidationListener() {
                            public void invalidated(Observable ov) {                  
                       
                                    if(st.showingProperty().getValue() == false){
                                       mp.stop();
                                    }
                            }         
                          }
                       
                       
                       );
             
         });
         MenuItem help = new MenuItem("Kout men");
         MenuItem update = new MenuItem("Fouye plis dwet nan kalalou...");
         update.setOnAction(eh->{
                  // On va mettre a jour les donnees dans les tableview
                
                     //  SystemInfo.methodeUpdateTableView();
                  
         });
//         MenuItem deconnexion = new MenuItem("Dekonekte Baz Done a");
//         deconnexion.setOnAction(eh->{
////             DAO.deconnexion();
//         });
//         
         aide.getItems().addAll(aPropos, 
                 new SeparatorMenuItem(),
                 culture,
                 new SeparatorMenuItem(),
                 help, 
                 new SeparatorMenuItem(),
                 update);
         menuBar.getMenus().add(aide);
         
        
        return menuBar;

    }
    
    
}
