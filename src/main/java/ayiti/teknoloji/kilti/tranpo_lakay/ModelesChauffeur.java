/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay;

/**
 *
 * @author negre
 */
public class ModelesChauffeur {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nomChauffeur;
    private String prenomChauffeur;
    private String sexeChauffeur;
    private String zoneStationnementChauffeur;
    private String typeVoiture;
    private String telephoneChauffeur;

    public ModelesChauffeur(int id, String nomChauffeur, String prenomChauffeur, String sexeChauffeur, String zoneStationnementChauffeur, String typeVoiture, String telephoneChauffeur) {
        this.id = id;
        this.nomChauffeur = nomChauffeur;
        this.prenomChauffeur = prenomChauffeur;
        this.sexeChauffeur = sexeChauffeur;
        this.zoneStationnementChauffeur = zoneStationnementChauffeur;
        this.typeVoiture = typeVoiture;
        this.telephoneChauffeur = telephoneChauffeur;
    }
    
    
    public ModelesChauffeur(){
    }
    
    

    public String getNomChauffeur() {
        return nomChauffeur;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    public String getPrenomChauffeur() {
        return prenomChauffeur;
    }

    public void setPrenomChauffeur(String prenomChauffeur) {
        this.prenomChauffeur = prenomChauffeur;
    }

    public String getSexeChauffeur() {
        return sexeChauffeur;
    }

    public void setSexeChauffeur(String sexeChauffeur) {
        this.sexeChauffeur = sexeChauffeur;
    }

    public String getZoneStationnementChauffeur() {
        return zoneStationnementChauffeur;
    }

    public void setZoneStationnementChauffeur(String zoneStationnementChauffeur) {
        this.zoneStationnementChauffeur = zoneStationnementChauffeur;
    }

    public String getTypeVoiture() {
        return typeVoiture;
    }

    public void setTypeVoiture(String typeVoiture) {
        this.typeVoiture = typeVoiture;
    }

    public String getTelephoneChauffeur() {
        return telephoneChauffeur;
    }

    public void setTelephoneChauffeur(String telephoneChauffeur) {
        this.telephoneChauffeur = telephoneChauffeur;
    }

   
    
    
    
}
