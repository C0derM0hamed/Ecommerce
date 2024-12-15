/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;



/**
 *
 * @author moham
 */
public class Order  {
    private int Id;   
    private String Location;
    private double TotalPrice;
    private String type;
    private String CstmrName;

    public Order( String Location, double TotalPrice, String type,String cstmrName) {
        this.Location = Location;
        this.TotalPrice = TotalPrice;
        this.type = type;
        this.CstmrName=cstmrName;
    }

    public int getId() {
        return Id;
    }

    public String getLocation() {
        return Location;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public String getType() {
        return type;
    }

    public String getCstmrName() {
        return CstmrName;
    }
    
  
}
