/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay;



/**
 *
 * @author negre
 */
public class Zone {

    

    // Une inner-Class   / Une classe interne


        private  int zoneId;

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneNom() {
        return zoneNom;
    }

    public void setZoneNom(String zoneNom) {
        this.zoneNom = zoneNom;
    }
        private  String zoneNom;

    

        // Les constructeurs
        public Zone(int id, String nom) {
            this.zoneId = id;
            this.zoneNom = nom;
        }

        
       
   


}
