/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay;

/**
 *
 * @author negre
 */
public class MailsChauffeur {
    
    private String address;
    private String code;
    private int idChauffeur;

    
    
    public MailsChauffeur(int idChauffeur, String address, String code ) {
        this.address = address;
        this.code = code;
        this.idChauffeur = idChauffeur;
    }

    
    
    
    public int getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(int idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

   
    
    
    
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
    
    
    
    
    
}
