package patterns.factory;

//Use Factory to create opject without know the details of concrete class

import models.Order;

public class OrderFactory {  
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
