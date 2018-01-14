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
public class User 
{
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    
    //Getter methods
	public String getUserName()
	{return userName;}

	public String getPassword()
	{return password;}

	public String getFirstName()
	{return firstName;}

	public String getLastName()
	{return lastName;}

    //Setter methods
	public void setUserName(String userNameIn)
	{userName = userNameIn;}

	public void setPassword(String passwordIn)
	{password = passwordIn;}

	public void setFirstName(String firstNameIn)
	{firstName = firstNameIn;}

	public void setLastName(String lastNameIn)
	{lastName = lastNameIn;}


    //Constructor - Default values
	public User()
	{
		userName = "";
		password = "";
		firstName = "";
		lastName = "";
	}
        
    //Overloaded Constructor
	public User(String userNameIn, String passwordIn, String firstNameIn, String lastNameIn)
	{
		userName = userNameIn;
		password = passwordIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
	}   
        
}
