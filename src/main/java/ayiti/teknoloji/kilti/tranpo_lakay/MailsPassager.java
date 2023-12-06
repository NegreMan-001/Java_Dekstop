/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay;

/**
 *
 * @author negre
 */
public class MailsPassager {
    
    private String address;
    private String code;
    private int idPassager;
    
    
     public MailsPassager(int idPassager, String address, String code) {
        this.address = address;
        this.code = code;
        this.idPassager = idPassager;
    }
    
    

    public int getIdPassager() {
        return idPassager;
    }

    public void setIdPassager(int idPassager) {
        this.idPassager = idPassager;
    }

   

    
    
    
    

    public MailsPassager() {
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
