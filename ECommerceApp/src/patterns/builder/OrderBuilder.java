/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patterns.builder;


import models.Order;
import patterns.factory.OrderFactory;

public class OrderBuilder {
   private int Id;   
    private String Location;
    private double TotalPrice;
    private String type;
    private String CstmrName;

    public OrderBuilder setLocation(String Location) {
        this.Location = Location;
        return this ;
    }

    public OrderBuilder setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
        return this ;
    }

    public OrderBuilder setType(String type) {
        this.type = type;
        return this ;
    }

    public OrderBuilder setCstmrName(String CstmrName) {
        this.CstmrName = CstmrName;
        return this ;
    }
    
  public  Order build()
  {//( String Location, double TotalPrice, String type,String CstmrName)
  return new Order(Location,TotalPrice,type,CstmrName);
  }  
    
    
}
