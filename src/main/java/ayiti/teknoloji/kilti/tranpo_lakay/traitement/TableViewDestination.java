/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.traitement;


import ayiti.teknoloji.kilti.tranpo_lakay.DAO.DAO;
import ayiti.teknoloji.kilti.tranpo_lakay.Distance;
import ayiti.teknoloji.kilti.tranpo_lakay.Zone;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//import negre.man.rapha.taxis.dao.Zone;


/**
 *
 * @author negre
 */
public class TableViewDestination {
    
    
     
        
  
            
    
    
    public static ObservableList<Zone> list =null;
    public static TableView methodeTableViewDestination() throws SQLException{
    
    
        
       

           
         
            
            TableView<Zone> tableDestination = new TableView<Zone>();
            
            
            
        TableColumn<Zone, Integer> colonneId = new TableColumn<Zone, Integer>("Identifyan chak Katye");
        TableColumn<Zone, String> colonneNom = new TableColumn<Zone, String>("Destinasyon ki disponib yo");
                 

        
        colonneId.setCellValueFactory(new PropertyValueFactory<>("zoneId"));
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("zoneNom"));


        list = DAO.listeDestination;
tableDestination.setItems(list);
tableDestination.getColumns().addAll(colonneId, colonneNom);
        
        
            
            
  
    
    return tableDestination;


    }
    
    
    
    
    
    
    //------------------------------------------------------------------------------------------------
    
    
    public static TableView methodeTableViewDistance() throws SQLException{
    
    
        
       

           
         
            
            TableView<Distance> tableDistance = new TableView<Distance>();
            
            
        TableColumn<Distance, Integer> colonneId = new TableColumn<Distance, Integer>("Identifyan chak Distans");
        TableColumn<Distance, String> colonneDepart = new TableColumn<Distance, String>("Katye avan");
        TableColumn<Distance, String> colonneArrivee = new TableColumn<Distance, String>("Katye apre");
        TableColumn<Distance, Integer> colonneDistance = new TableColumn<Distance, Integer>("Mwayen pou kontwole");
                 

        
        colonneId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colonneDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        colonneArrivee.setCellValueFactory(new PropertyValueFactory<>("arrivee"));
        colonneDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));


ObservableList<Distance> list1 = DAO.listeDistances;
tableDistance.setItems(list1);
tableDistance.getColumns().addAll(colonneId, colonneDepart, colonneArrivee, colonneDistance);
        
        
            
            
  
    
    return tableDistance;


    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    // ------------------------------------------------------------------------------------ Pour les retours de listes
    

    
    
    
    
    
    
}
