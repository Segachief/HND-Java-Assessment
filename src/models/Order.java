/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Date;

/**
 *
 * @author 30214590
 */
public class Order 
{
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    
    //Getter methods
	public int getOrderId()
	{return orderId;}

	public Date getOrderDate()
	{return orderDate;}

	public double getOrderTotal()
	{return orderTotal;}

	public String getStatus()
	{return status;}

    //Setter methods
	public void setOrderId(int orderIdIn)
	{orderId = orderIdIn;}

	public void setOrderDate(Date orderDateIn)
	{orderDate = orderDateIn;}

	public void setOrderTotal(double orderTotalIn)
	{orderTotal = orderTotalIn;}

	public void setStatus(String statusIn)
	{status = statusIn;}

    //Constructor - Default values
	public Order()
	{
		orderId = 0;
		orderDate = new Date();
		orderTotal = 0.0;
		status = "";
	}
        
    //Overloaded Constructor
	public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
	{
		orderId = orderIdIn;
		orderDate = orderDateIn;
		orderTotal = orderTotalIn;
		status = statusIn;
	}   
        
}
