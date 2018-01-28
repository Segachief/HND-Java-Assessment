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
public class OrderLine 
{
    private int orderLineId;
    private Product product;
    private int quantity;
    private double lineTotal;
    
    //Getter methods
	public int getOrderLineId()
	{return orderLineId;}

	public int getQuantity()
	{return quantity;}

	public double getLineTotal()
	{return lineTotal;}
        
        public Product getProduct()
        {return product;}

    //Setter methods
	public void setOrderLineId(int orderLineIdIn)
	{orderLineId = orderLineIdIn;}

	public void setQuantity(int quantityIn)
	{quantity = quantityIn;}

	public void setlineTotal(double lineTotalIn)
	{lineTotal = lineTotalIn;}
        
        public void setProduct (Product productIn)
        {product = productIn;}

    //Constructor - Default values
	public OrderLine(Order o, Product productIn)
	{
		orderLineId = o.generateUniqueOrderLineId();
                product = productIn;
		quantity = 1;
		lineTotal = product.getPrice() * quantity;
	}     
}
