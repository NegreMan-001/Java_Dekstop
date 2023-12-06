/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay;

/**
 *
 * @author negre
 */
public class Distance {

private int id;
private String depart;
private String arrivee;
private int distance;



    public Distance(int id, String depart, String arrivee, int distance) {
        this.id = id;
        this.depart = depart;
        this.arrivee = arrivee;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }










    
}
