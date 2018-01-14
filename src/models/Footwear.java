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
public class Footwear extends Product
{
    private int size;
    
    //Getter
    public int getSize()
    {return size;}
    
    //Setter
    public void setSize(int sizeIn)
    {this.size = sizeIn;}
    
    //Constructor
    public Footwear()
    {   
        super(); //Footwear inherits Constructor from Product Class
        size = 0;
    }
    
    //Overloaded
    public Footwear(int productIdIn, String productNameIn, double priceIn,
            int stockLevelIn, int sizeIn)
    {//Calling Overloaded in Product Class - passing params to it
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        this.size = sizeIn;
    }
}
