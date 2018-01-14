/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 30214590
 */
public class Clothing extends Product
{
    private String measurement;
    
    //Getter
    public String getMeasurement()
    {return measurement;}
    
    //Setter
    public void setMeasurement(String measurementIn)
    {this.measurement = measurementIn;}
    
    //Constructor
    public Clothing()
    {   
        super(); //Clothing inherits Constructor from Product Class
        measurement = "";
    }
    
    //Overloaded
    public Clothing(int productIdIn, String productNameIn, double priceIn,
            int stockLevelIn, String measurementIn)
    {//Calling Overloaded in Product Class - passing params to it
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        this.measurement = measurementIn;
    }
}
