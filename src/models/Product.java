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

public class Product
{
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    @Override
        public String toString()
        {return productName;}
    
    //Getter methods
	public int getProductId()
	{return productId;}

	public String getProductName()
	{return productName;}

	public double getPrice()
	{return price;}

	public int getStockLevel()
	{return stockLevel;}

    //Setter methods
	public void setProductId(int productIdIn)
	{this.productId = productIdIn;}

	public void setproductName(String productNameIn)
	{this.productName = productNameIn;}

	public void setPrice(double priceIn)
	{this.price = priceIn;}

	public void setStockLevel(int stockLevelIn)
	{this.stockLevel = stockLevelIn;}

    //Constructor - Default values
	public Product()
	{
		productId = 0;
		productName = "";
		price = 0;
		stockLevel = 0;
	}
        
    //Overloaded Constructors       
        public Product(String productNameIn, double priceIn, int stockLevelIn)
	{
		productName = productNameIn;
		price = priceIn;
		stockLevel = stockLevelIn;
        }      
        
	public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
	{
		productId = productIdIn;
		productName = productNameIn;
		price = priceIn;
		stockLevel = stockLevelIn;
        }      
}
