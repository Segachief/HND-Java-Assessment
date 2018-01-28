/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 *
 * @author 30214590
 */
public class DBManager
{
    //This is the address of the Database, change this here to update all connections in DBManager
    private final String databaseLink = "jdbc:ucanaccess://D:\\SegaChief\\Documents\\HND - Hub\\HND - Java\\ShopDB.accdb";
    
    public void addOrderLine(OrderLine oLine, int orderId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, ProductId, Quantity, " +
                    "LineTotal, OrderId) VALUES ('" + oLine.getOrderLineId() + "','" + oLine.getProduct().getProductId() +
                     "','" + oLine.getQuantity() + "','" + oLine.getLineTotal()+ "','" + orderId + "')");
            conn.close();
            updateOrderTotal(orderId, oLine.getLineTotal());
        }
        catch(Exception ex)
        {String message = ex.getMessage();}
    }
    
    public void updateOrderTotal(int orderId, double lineTotal)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET OrderTotal= OrderTotal + " +
                              lineTotal + " WHERE OrderId= '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {String message = ex.getMessage();}
    }
    
    public int addOrder(String personId, Order o)
    {
        int orderId = 0;     
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, Customer, OrderTotal, " +
                    "Status) VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate()) +
                    "','" + personId + "','" + o.getOrderTotal() + "','" + o.getStatus() + "')");
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next())
            {orderId = rs.getInt(1);}           
            conn.close();
        }
        catch(Exception ex)
        {String message = ex.getMessage();}  
        return orderId;
    }
    
    public HashMap<Integer, Product> loadProducts()
    {
        HashMap<Integer, Product> products = new HashMap();
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            
            
                while(rs.next())
                {
                    int productId = rs.getInt("ProductId");
                    String productName = rs.getString("ProductName");
                    double price = rs.getDouble("Price");
                    int stockLevel = rs.getInt("StockLevel");
                    
                    String measurement = rs.getString("Measurement");
                    
                    if(measurement != null && !measurement.isEmpty())
                    {
                        Clothing clothing = new Clothing(productId, productName, price, stockLevel, measurement);
                        products.put(productId, clothing);
                    }
                    else
                    {
                        int size = rs.getInt("Size");
                        Footwear footwear = new Footwear(productId, productName, price, stockLevel, size);
                        products.put(productId, footwear);
                    }
                }
                conn.close();
                return products;
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }
    
    public void addProduct(Product newProduct)
    {
        String measurement = "";
        String size = "NULL";
        
        if(newProduct.getClass().getName().equals("models.Clothing"))
        {
            Clothing newClothing = (Clothing)newProduct;
            measurement = newClothing.getMeasurement();
        }
        else
        {
            Footwear newFootwear = (Footwear)newProduct;
            size = String.valueOf(newFootwear.getSize());
        }
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Products (ProductName, Price, StockLevel, Measurement, Size) " +
            "VALUES ('" + newProduct.getProductName() + "','" + newProduct.getPrice() + "','" + newProduct.getStockLevel() + "','" + measurement + "'," + size + ")");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void updateProduct(Product updateProduct)
    {
        String measurement = "";
        String size = "NULL";
        
        if(updateProduct.getClass().getName().equals("models.Clothing"))
        {
            Clothing clothing = (Clothing)updateProduct;
            measurement = clothing.getMeasurement();
        }
        else
        {
            Footwear footwear = (Footwear)updateProduct;
            size = String.valueOf(footwear.getSize());
        }
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Products SET ProductName= '" + updateProduct.getProductName() + "', "
            + "Price = '" + updateProduct.getPrice() + "', StockLevel= '" + updateProduct.getStockLevel() + "', "
            + "Measurement= '" + measurement + "', size=" + size + " WHERE ProductId = '" + updateProduct.getProductId() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void deleteProduct(Product newProduct)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM Products WHERE ProductId = '" + 
                    newProduct.getProductId() + "'");
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    public HashMap<String, Customer> loadCustomers()
    {
        HashMap<String, Customer> customers = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = 
                    DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                while(rs.next())
                {
                    String userName = rs.getString("Username");
                    String password = rs.getString("Password");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String addressLine1 = rs.getString("AddressLine1");
                    String addressLine2 = rs.getString("AddressLine2");
                    String town = rs.getString("Town");
                    String postcode = rs.getString("Postcode");
                
                    Customer customer = new Customer(userName, password, firstName, 
                        lastName, addressLine1, addressLine2, town, postcode);
                
                    customers.put(userName, customer);
                }
                
            }
            
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return customers; 
        }
    }
    
    public Customer customerLogIn(String userNameIn, String passwordIn)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE Username = '" + userNameIn  + "' AND Password = '" + passwordIn + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                String userName = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");
                
                conn.close();
                Customer customer = new Customer(userName, password, firstName, 
                        lastName, addressLine1, addressLine2, town, postcode);
                return customer;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }
    
    public boolean registerCustomer(Customer newCustomer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE Username = '" + newCustomer.getUserName() + "'");
            if(rs.next())
            {
                conn.close();
                return false;
            }
            else
            {
                stmt.executeUpdate("INSERT INTO Customers (Username, Password, FirstName," +
                        "LastName, Addressline1, Addressline2, Town, Postcode) " +
                        "VALUES ('" + newCustomer.getUserName() + "','" + newCustomer.getPassword() +
                        "','" + newCustomer.getFirstName() + "','" + newCustomer.getLastName() +
                        "','" + newCustomer.getAddressLine1() + "','" + newCustomer.getAddressLine2() + 
                        "','" + newCustomer.getTown() + "','" + newCustomer.getPostcode() + "')");
                conn.close();
                return true;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
    }
    
    public void updateCustomer(Customer customer)
    {//Remember to double-check database table heads vs. Database
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE Customers SET Password= '" + customer.getPassword() + "', "
                    + "FirstName= '" + customer.getFirstName() + "', "
                    + "LastName= '" + customer.getLastName() + "', "
                    + "AddressLine1= '" + customer.getAddressLine1() + "', "
                    + "AddressLine2= '" + customer.getAddressLine2() + "', "
                    + "Town= '" + customer.getTown() + "', "
                    + "Postcode= '" + customer.getPostcode() + "' "
                    + "WHERE Username= '" + customer.getUserName() + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void deleteCustomer(Customer customer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM Customers WHERE Username = '" + 
                    customer.getUserName() + "'");
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    public HashMap<String, Staff> loadStaff()
    {
        HashMap<String, Staff> staffHash = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = 
                    DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                while(rs.next())
                {
                    String userName = rs.getString("Username");
                    String password = rs.getString("Password");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String position = rs.getString("Position");
                    double salary = rs.getDouble("Salary");
                
                    Staff staff = new Staff(userName, password, firstName, 
                        lastName, salary, position);
                
                    staffHash.put(userName, staff);
                }
                
            }
            
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return staffHash; 
        }
    }
    
    public Staff staffLogIn(String userNameIn, String passwordIn)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(databaseLink);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff WHERE Username = '" + userNameIn  + "' AND Password = '" + passwordIn + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                
                conn.close();
                Staff staff = new Staff(userName, password, firstName, 
                        lastName, salary, position);
                return staff;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }
    
}
