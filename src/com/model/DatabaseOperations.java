package com.model;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DatabaseOperations {

        Connection conn;
    	public DatabaseOperations () {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/surpriseme","root","");
			System.out.println("isClosed() = " + conn.isClosed());
		}
		catch(ClassNotFoundException e) {
			System.out.println("com.mysql.jdbc.Driver class not found.");
		}
		catch(SQLException e) {
			System.out.println("Connection failed.");
		}
		catch(Exception e) {
			System.out.println("Unknown Exception raised in the constructor of DatabaseOperations class.");
		}
	}
        public int executeNonQuery(String query) {
        	try{
        		Statement statement = conn.createStatement();
        		return statement.executeUpdate(query);
        	}
        	catch (SQLException e) {
        		return 0;
        	}
        	
        	
        }
        
        
        
        public ResultSet executeQueryProcedure(String procedure, String code) {
        	ResultSet rs = null;
        	try {
				CallableStatement cs = conn.prepareCall(procedure);
				cs.setString(1, code);
				rs = cs.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return rs;
        }
    	
        public ResultSet getAllArticles(){
            ResultSet rs = null;
            try{
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("select articleid, title, substring(content,1,300) as abstract, source, views, upvotes, downvotes from article");
            } catch(SQLException e) {
                
            }
            return rs;
        }
        
        public int getUserID(String email) {
        	
        	try {
        		CallableStatement cs = conn.prepareCall("{ ? = call getUserID(?) }");
        		cs.registerOutParameter(1, Types.BIGINT);
        		cs.setString(2, email);
        		boolean b = cs.execute();
        		return cs.getInt(1);
        	}
        	catch (SQLException e) {
        		return 0;
        	}
        }
        
        public ResultSet executeQuery(String query){
            ResultSet rs = null;
            try{
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            } catch(SQLException e) {
                
            }
            return rs;
        }
        //(IN suid INT, IN un varchar(20), IN pwd varchar(50), IN eml varchar(20), IN fn varchar(20), IN ln varchar(20), IN db date, IN st varchar(20), IN ct varchar(20), IN cntry varchar(20))
        public void registerUser(int signupid, String username,  String password, String email, String firstname, String lastname, Date date, String state,  String city, String country){
        	try {
				CallableStatement cs = conn.prepareCall("{ call saveUserDetails(?,?,?,?,?,?,?,?,?,?) }");
				cs.setInt(1, signupid);
				cs.setString(2, username);
				cs.setString(3, password);
				cs.setString(4, email);
				cs.setString(5, firstname);
				cs.setString(6, lastname);
				cs.setDate(7, date);
				//cs.setString(7, date);
				cs.setString(8, state);
				cs.setString(9, city);
				cs.setString(10, country);
				cs.execute();
				System.out.println("Done");
			} catch (SQLException e) {
				System.out.println("Error in preparing call");
			}
        }
        
        /*public boolean registerUser (int signupid, String username, String password, String email, String firstname, String lastname, String dob, String state, String city, String country)  throws SQLException {
        	System.out.println("Reached in register user");
        	CallableStatement cs = conn.prepareCall("{ call saveUserDetails(?,?,?,?,?,?,?,?,?,?) }");
        	cs.setInt(1, signupid);
        	cs.setString(2, username);
        	cs.setString(3, password);
        	cs.setString(4, email);
        	cs.setString(5, firstname);
        	cs.setString(6, lastname);
        	cs.setString(7, dob);
        	cs.setString(8, state	);
        	cs.setString(9, city);
        	cs.setString(10, country);
        	return cs.execute();
        	
        }*/
        
        public static void main (String args[]) throws SQLException {
        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        	Date dob = null;
        	try{
        		dob = (Date) df.parse("1990-11-08");
        		System.out.println(dob.toString());
        	}
        	catch(ParseException e) {
        		
        	}
        	DatabaseOperations dop = new DatabaseOperations();
        	dop.registerUser(9, "hirenjaydeen", "jaydeep", "harmishrulz@indiatimes.com", "hiren", "shah", dob, "Maharastra", "Mumbai", "India");
        	
        }
       

}
