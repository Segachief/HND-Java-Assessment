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
public class Customer extends User
{
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    
     public String displayGreeting()
    {
        String greeting = "<html>Welcome " + this.getUserName() + "<br>";
        return greeting;
    }
    
    //Getter
    public String getAddressLine1()
    {return addressLine1;}
    
    public String getAddressLine2()
    {return addressLine2;}
    
    public String getTown()
    {return town;}
    
    public String getPostcode()
    {return postcode;}
    
    //Setter
    public void setAddressLine1(String addressLine1In)
    {this.addressLine1 = addressLine1In;}
    
    public void setAddressLine2(String addressLine2In)
    {this.addressLine2 = addressLine2In;}
     
    public void setTown(String townIn)
    {this.town = townIn;}
    
    public void setPostcode(String postcodeIn)
    {this.postcode = postcodeIn;}
    
    //Constructor
    public Customer()
    {   
        super(); //Customer inherits Constructor from User Class
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
    }
    
    //Overloaded
    public Customer(String userNameIn, String passwordIn, String firstNameIn,
            String lastNameIn, String addressLine1In, String addressLine2In,
            String townIn, String postcodeIn)
    {//Calling Overloaded in User Class - passing params to it
        super(userNameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;
    }
}