/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.traitement;

import java.sql.SQLException;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


/**
 *
 * @author negre
 */
public class AffichageParOnglet {
    
    // We're gonna get a method that returns a 'TabPane'
    
    public static TabPane affiche;
    public static TabPane afficherParOngle() throws SQLException{
    
        Tab tabCourse = new Tab();
        tabCourse.setText("Kous");
        tabCourse.setClosable(false);
        Boolean t4 = tabCourse.isSelected(); 
        if(! (t4)){ // si oui, on charge
            tabCourse.setContent(Course.methodeCourses());
         }
        
        
        Tab tabCompteCh = new Tab();
        tabCompteCh.setText("Kont Chofè");
        tabCompteCh.setClosable(false);
        Boolean t2 = tabCompteCh.isSelected(); 
        if(! (t2)){ // si oui, on charge
            tabCompteCh.setContent(new CompteChauffeur().methodeHBoxChauffeur());
         }
        
        
        
        Tab tabComptePa = new Tab();
        tabComptePa.setText("Kont Pasaje");
        tabComptePa.setClosable(false);
         Boolean t3 = tabComptePa.isSelected(); 
        if(! (t3)){ // si oui, on charge
            tabComptePa.setContent(new ComptePassager().methodeHBoxPassager());
         }
        
        
        
        Tab tabDestination = new Tab();
        tabDestination.setText("Destinasyon");
        tabDestination.setClosable(false);
        //tabDestination.setContent(TableViewDestination.methodeTableViewDestination());
        
        Boolean t = tabDestination.isSelected();       // test pour savoir si c'est selectionne
        
       if(! (t)){ // si oui, on charge
            tabDestination.setContent(TableViewDestination.methodeTableViewDestination());
         }
        
        
        Tab tabDistance = new Tab();
        tabDistance.setText("Distans");
        tabDistance.setClosable(false);
        
        Boolean t1 = tabDistance.isSelected();
         if(! (t1)){ // si oui, on charge
            tabDistance.setContent(TableViewDestination.methodeTableViewDistance());
         }
        
        
        affiche = new TabPane();
        affiche.getTabs().addAll(tabCourse, tabCompteCh, tabComptePa, tabDestination, tabDistance);
        
    
    
    
    
    return affiche;
    }
    
    
    
    
    
    
    
}
