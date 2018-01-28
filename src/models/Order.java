/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    private HashMap<Integer, OrderLine> orderLines;
    
    public void addOrderLine(OrderLine oLine)
    {
        orderTotal = orderTotal + oLine.getLineTotal();
        orderLines.put(oLine.getOrderLineId(), oLine);
        DBManager db = new DBManager();
        db.addOrderLine(oLine, orderId);
    }
    
    public int generateUniqueOrderLineId()
    {
        int orderLineId = 0;
        for(Map.Entry<Integer, OrderLine> orderLineEntry : orderLines.entrySet())
        {
            if(orderLines.containsKey(orderLineId))
            {orderLineId++;}
        }
        return orderLineId;
    }
    
    //Getter methods
	public int getOrderId()
	{return orderId;}

	public Date getOrderDate()
	{return orderDate;}

	public double getOrderTotal()
	{return orderTotal;}

	public String getStatus()
	{return status;}
        
        public HashMap<Integer, OrderLine> getOrderLines()
        {return orderLines;}

    //Setter methods
	public void setOrderId(int orderIdIn)
	{orderId = orderIdIn;}

	public void setOrderDate(Date orderDateIn)
	{orderDate = orderDateIn;}

	public void setOrderTotal(double orderTotalIn)
	{orderTotal = orderTotalIn;}

	public void setStatus(String statusIn)
	{status = statusIn;}
        
        public void setOrderLines(HashMap<Integer, OrderLine> oLines)
        {orderLines = oLines;}

    //Constructor - Default values
	public Order()
	{
		orderId = 0;
		orderDate = new Date();
		orderTotal = 0;
		status = "New";
                orderLines = new HashMap<>();
	}
        
    //Overloaded Constructor
	public Order(int oId, Date oDate, double oTotal, String oStatus)
	{
		orderId = oId;
		orderDate = oDate;
		orderTotal = oTotal;
		status = oStatus;
                orderLines = new HashMap<>();
	}   
        
}
