package models;

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
