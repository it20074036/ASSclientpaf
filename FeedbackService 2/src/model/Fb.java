package model;

import java.sql.*;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

public class Fb {
	//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				//Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/lab", "root", "");
				
				System.out.print("Successfully connected");
			}
		catch (Exception e)
			{
				e.printStackTrace();
		      }
	      return con;
	  }
	 
	  
//GET part
 public String readFeedbacks()
	  {
	    String output = "";
	    
	      try
	      {
	        Connection con = connect();
	        if (con == null) {  
	        return "Error while connecting to the database for reading."; 
	        }
	        
	        // Prepare the html table to be displayed
	        output = "<table class='table'><tr align='center'>"
	        		+ "<th> Username </th>"
	        		+ "<th> Email address</th><th> Feedback </th>"
	        		+"<th> Update </th><th> Delete </th>";
	        
	        String query = "SELECT * FROM feed";
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	    
	       // iterate through the rows in the result set
	      
	      while (rs.next())
	      {
	        String fID = Integer.toString(rs.getInt("fID"));
	        String fName = rs.getString("fName");
	        String eMail = rs.getString("eMail");
	        String feedBack = rs.getString("feedBack");
	    
	       
	        // Add into the html table
	        output += "<tr align='center'><td><input id='hidFeedbackIDUpdate' name='hidFeedbackIDUpdate' type='hidden' value='" + fID + "'>" + fName + "</td>";
	        output += "<td>" + eMail + "</td>";
	        output += "<td>" + feedBack + "</td>";
	        
	        // buttons     
			output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-primary'></td>"
			        + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-feedbackid='"+ fID +"'>"+"</td></tr>";
	       
	      }
	        con.close();
	        // Complete the html table
	        output += "</table>";
	      }
	      catch (Exception e)
	      {
	        output = "Error while reading the units.";
	        System.err.println(e.getMessage());
	      }
	    return output;
	  }
	  
	  
		//POST part
	  public String insertFeedback(String fName, String eMail, String feedBack)
	  {
	     String output = "";
	    try
	    {
	      Connection con = connect();
	      
	      if (con == null)
	    {
	      
	      return "Error while connecting to the database for inserting."; 
	    }
	  
	      // create a prepared statement
	      String query = " INSERT INTO feed(`fID`,`fName`,`eMail`,`feedBack`)"+ " values (?,?,?,?)";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	         
	        // binding values
	      preparedStmt.setInt(1, 0);
	      preparedStmt.setString(2, fName);
	      preparedStmt.setString(3, eMail);
	      preparedStmt.setString(4, feedBack);
	      
	      preparedStmt.execute();
	      con.close();
	      
	    //create JSON Object
		  String newFeedback = readFeedbacks();
		  output = "{\"status\":\"success\", \"data\": \"" + newFeedback + "\"}";
	    }
	    catch (Exception e)
	    {
	      output = "{\"status\":\"error\", \"data\": \"Error while inserting the Unit.\"}";
	      System.err.println(e.getMessage());
	    }
	    return output;
	  }
	  
	  
		//PUT part
	  public String updateFeedback(String fID, String fName,String eMail,String feedBack)
	  {
	    String output = "";
	      try
	      {
	        Connection con = connect();
	        if (con == null)
	      {
	        return "Error while connecting to the database for updating."; 
	      }
	        
	        // create a prepared statement
	          String query = "UPDATE feed SET fName=?,eMail=?,feedBack=? WHERE fID=?";
	          PreparedStatement preparedStmt = con.prepareStatement(query);
	        
	        // binding values
	        preparedStmt.setString(1, fName);
	        preparedStmt.setString(2, eMail);
	        preparedStmt.setString(3, feedBack);
	        preparedStmt.setInt(4, Integer.parseInt(fID));
	        
	        preparedStmt.execute();
	        con.close();
	        
	        
	      //create JSON Object
			  String newFeedback = readFeedbacks();
			  output = "{\"status\":\"success\", \"data\": \"" + newFeedback + "\"}";
	      }
	      catch (Exception e)
	      {
	        output = "{\"status\":\"error\", \"data\": \"Error while updating the Feedback.\"}";
	        System.err.println(e.getMessage());
	      }
	    return output;
	  }
	    
	  
	  
	//DELETE part 
	  public String deleteFeedback(String fID)
	  {
	    String output = "";
	      try
	      {
	          Connection con = connect();
	          
	       if (con == null)
	      {
	        return "Error while connecting to the database for deleting."; 
	      }
	          
	      // create a prepared statement
	          String query = "DELETE FROM feed WHERE fID=?";
	          PreparedStatement preparedStmt = con.prepareStatement(query);
	      
	      // binding values
	          preparedStmt.setInt(1, Integer.parseInt(fID));
	      
	      // execute the statement
	          preparedStmt.execute();
	          con.close();          
	          
	        //create JSON Object
			  String newFeedback = readFeedbacks();
			  output = "{\"status\":\"success\", \"data\": \"" + newFeedback + "\"}";
	      }
	      catch (Exception e)
	      {
	          output = "{\"status\":\"error\", \"data\": \"Error while deleting the Feedback.\"}";
	          System.err.println(e.getMessage());
	      }
	      return output;
	      }
	  }