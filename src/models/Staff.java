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
public class Staff extends User
{
    
    private double salary;
    private String position;
    
    public String displayGreeting()
    {
        String greeting = "<html>Welcome " + this.getUserName() + "<br>";
        return greeting;
    }
    
    //Getter
    public double getSalary()
    {return salary;}
    
    public String getPosition()
    {return position;}
    
    //Setter
    public void setSalary(double salaryIn)
    {salary = salaryIn;}
    
    public void setPosition(String positionIn)
    {position = positionIn;}
    
    //Constructor
    public Staff()
    {   
        super(); //Staff inherits Constructor from User Class
        salary = 0.0;
        position = "";
    }
    
    //Overloaded
    public Staff(String userNameIn, String passwordIn, String firstNameIn,
            String lastNameIn, double salaryIn, String positionIn)
    {//Calling Overloaded in User Class - passing params to it
        super(userNameIn, passwordIn, firstNameIn, lastNameIn);
        salary = salaryIn;
        position = positionIn;
    }
}