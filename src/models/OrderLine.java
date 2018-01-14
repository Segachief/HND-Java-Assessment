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
    private int quantity;
    private double lineTotal;
    
    //Getter methods
	public int getOrderLineId()
	{return orderLineId;}

	public int getQuantity()
	{return quantity;}

	public double getLineTotal()
	{return lineTotal;}

    //Setter methods
	public void setOrderLineId(int orderLineIdIn)
	{orderLineId = orderLineIdIn;}

	public void setQuantity(int quantityIn)
	{quantity = quantityIn;}

	public void setlineTotal(double lineTotalIn)
	{lineTotal = lineTotalIn;}

    //Constructor - Default values
	public OrderLine()
	{
		orderLineId = 0;
		quantity = 0;
		lineTotal = 0.0;
	}
        
    //Overloaded Constructor
	public OrderLine(int orderLineIdIn, int quantityIn, double lineTotalIn)
	{
		orderLineId = orderLineIdIn;
		quantity = quantityIn;
		lineTotal = lineTotalIn;
	}   
        
}
