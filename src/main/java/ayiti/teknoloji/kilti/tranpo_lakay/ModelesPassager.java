/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay;

/**
 *
 * @author negre
 */
public class ModelesPassager {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nomPassager;
    private String prenomPassager;
    private String sexePassager;
    private String occupationPassager;
    private String telephonePassager;

    public ModelesPassager(int id, String nomPassager, String prenomPassager, String sexePassager, String occupationPassager, String telephonePassager) {
        this.id = id;
        this.nomPassager = nomPassager;
        this.prenomPassager = prenomPassager;
        this.sexePassager = sexePassager;
        this.occupationPassager = occupationPassager;
        this.telephonePassager = telephonePassager;
    }

    public String getNomPassager() {
        return nomPassager;
    }

    public void setNomPassager(String nomPassager) {
        this.nomPassager = nomPassager;
    }

    public String getPrenomPassager() {
        return prenomPassager;
    }

    public void setPrenomPassager(String prenomPassager) {
        this.prenomPassager = prenomPassager;
    }

    public String getSexePassager() {
        return sexePassager;
    }

    public void setSexePassager(String sexePassager) {
        this.sexePassager = sexePassager;
    }

    public String getOccupationPassager() {
        return occupationPassager;
    }

    public void setOccupationPassager(String occupationPassager) {
        this.occupationPassager = occupationPassager;
    }

    public String getTelephonePassager() {
        return telephonePassager;
    }

    public void setTelephonePassager(String telephonePassager) {
        this.telephonePassager = telephonePassager;
    }
    
    
    
    
    
    
    
    
    
    
}
