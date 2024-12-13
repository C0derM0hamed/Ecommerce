/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.factory;

import models.Order;
/*
 * @author mohamedmostafa,
 * Yasmeen Elewa,
 * Tarek Abdallah,
 * Asmaa Khaled,
 * Carol Moussa   
 */
public class OrderFactory {                //( String Location, double TotalPrice, String type,String cstmrName
    public static Order createOrderProcessor( String Location, double TotalPrice, String type,String CstmrName) {
        switch (type.toLowerCase()) {
            case "standard":
                return new Order(Location,TotalPrice,"Standard",CstmrName);
            case "express":
                return new Order(Location,TotalPrice,"Standard",CstmrName);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
      
}
