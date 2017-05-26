package CarRentalApp;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class DB {
	DecimalFormat myformat=new DecimalFormat("$###,##0.00");
	DefaultTableModel car_mang = new DefaultTableModel(new String[]{"CAR ID","CAR MODEL","COLOR","RENTING PRICE","COMMENT"}, 0);
	DefaultTableModel customer_mang = new DefaultTableModel(new String[]{"Customer ID","FULL NAME","PHONE","ADDRESS","COMMENT"}, 0);
	DefaultTableModel rent_mang = new DefaultTableModel(new String[]{"#Rent","CAR ID","Customer Name","#Renting Days","Paid Amount"}, 0);
	DefaultTableModel accounting = new DefaultTableModel(new String[]{"#Transaction","CAR ID","Customer Name","#Renting Days","Total Amount","Paid Amount","Reqiured"}, 0);

    String carCost;
    String jtable="";

	ArrayList<String> carIds = new ArrayList<String>();
	ArrayList<String> cnames = new ArrayList<String>();

	//DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
	public void select(String table)
	{
	
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/car_rental";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	       
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query="SELECT * FROM "+table;
	      if(table=="carIDcombo"){
	    	  query = "SELECT id FROM car_mang";
	      }
	      if(table==jtable){
	    	  query = "SELECT price_rent FROM car_mang";
	      }
	      if(table=="customerName")
	      {
	    	  query = "select customer_name from customer_mang";
	      }
	      if(table=="accounting")
	      {
	    	  query = "select customer_name from customer_mang";
	      }
	      // create the java statement
	      Statement st = conn.createStatement();
	       
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	       
	      // iterate through the java resultset
	      if(table=="car_mang")
	      {
	    		 car_mang.setRowCount(0);
	      while (rs.next())
	      { 

		        String id = rs.getString("id");
		        String carModel = rs.getString("car_model");
		        String color = rs.getString("color");
		        String priceRent = rs.getString("price_rent");
		        String comment = rs.getString("comment");
		        car_mang.addRow(new Object[]{id,carModel,color,priceRent,comment});
	  	 
	      }
	    
	      }
	      if(table=="customer_mang")
	      {
	    	  customer_mang.setRowCount(0);
		      while (rs.next())
		      {
		        String customerId = rs.getString("id");
		        String customerName = rs.getString("customer_name");
		        String customerPhone = rs.getString("customer_phone");
		        String customerAddress = rs.getString("customer_address");
		        String comment = rs.getString("comment");
		        customer_mang.addRow(new Object[]{customerId,customerName,customerPhone,customerAddress,comment});
		        // print the results
		      //  System.out.format("%s, %s, %s, %s, %s, %s\n", id, carModel, color, priceRent, comment);
		      }
	      }
	      //here i am trying to get the data from my sql and send it to the combobox in AddToRentMang.java
		      if(table=="carIDcombo") {
		    	  
		    	    try
		    	    {
		    	    ///	car_mang.setRowCount(0);
		    	rs= st.executeQuery("select id from car_mang");
		    	    while(rs.next()){                            
		    	    	 String carID = rs.getString("id");
		         carIds.add(carID);
		    	    	 }

		    	    }
		    	    
		    	    catch(Exception e)
		    	    {
		    	        System.out.println("Error"+e);
		    	    }    
		    	}
		      

		      
		      
		      
		      if(table=="customerName") {
		    	  
		    	    try
		    	    {
		    	    ///	car_mang.setRowCount(0);
		    	rs= st.executeQuery("select customer_name from customer_mang");
		    	    while(rs.next()){                            
		    	    	 String cname = rs.getString("customer_name");
		                 cnames.add(cname);
		    	    	 }

		    	    }
		    	    
		    	    catch(Exception e)
		    	    {
		    	        System.out.println("Error"+e);
		    	    }    
		    	}//finish the try with successful results
	     
                   
	      if(table=="accounting")
	      {
	    	  rs= st.executeQuery("select * from rent_mang");
	    	//  query = "select customer_name from customer_mang";
	    	  accounting.setRowCount(0);
		      while (rs.next())
		      {
		        String id = rs.getString("id");
		        String carId = rs.getString("car_id");
		        String customerName = rs.getString("customer_name");
		        String date = rs.getString("date");
		        String tamount = rs.getString("cost");
		        String pamount = rs.getString("paid_cost");
		        String total = rs.getString("total");
		        String teto=myformat.format(Double.parseDouble(total));
		        accounting.addRow(new Object[]{id,carId,customerName,date,tamount,pamount,teto});
		        // print the results
		        //System.out.format("%s, %s, %s, %s, %s, %s\n", id, carModel, color, priceRent, comment);
		      }
	      }
	    /*  if(table!="car_mang"||table!="rent_mang"||table!="customer_mang")
	      {
	         JOptionPane.showMessageDialog(null, "Error in the provided table"+table);
	      }*/
	      if(table==jtable){
		    	    try
		    	    {
		    	    ///	car_mang.setRowCount(0);
				   // 	JOptionPane.showMessageDialog(null, jtable);
		    	rs= st.executeQuery("select price_rent from car_mang where id="+"'"+jtable+"'");
		    	   while(rs.next()){                            
		    	    	 String carCostt = rs.getString("price_rent");
		    	    	 this.carCost=(carCostt);
		    	    	 }

		    	    }
		    	    
		    	    catch(Exception e)
		    	    {
		    	        System.out.println("Error"+e);
		    	    }    
		    	}
	      
	      if(table=="rent_mang")
	      {
	    	  rent_mang.setRowCount(0);
		      while (rs.next())
		      {
		        String id = rs.getString("id");
		        String carId = rs.getString("car_id");
		        String customerName = rs.getString("customer_name");
		        String date = rs.getString("date");
		        String pamount = rs.getString("paid_cost");
		        rent_mang.addRow(new Object[]{id,carId,customerName,date,pamount});
		        // print the results
		        //System.out.format("%s, %s, %s, %s, %s, %s\n", id, carModel, color, priceRent, comment);
		      }
	      }
	    /*  if(table!="car_mang"||table!="rent_mang"||table!="customer_mang")
	      {
	         JOptionPane.showMessageDialog(null, "Error in the provided table"+table);
	      }*/
	      if(table==jtable){
		    	    try
		    	    {
		    	    ///	car_mang.setRowCount(0);
				   // 	JOptionPane.showMessageDialog(null, jtable);
		    	rs= st.executeQuery("select price_rent from car_mang where id="+"'"+jtable+"'");
		    	   while(rs.next()){                            
		    	    	 String carCostt = rs.getString("price_rent");
		    	    	 this.carCost=(carCostt);
		    	    	 }

		    	    }
		    	    
		    	    catch(Exception e)
		    	    {
		    	        System.out.println("Error"+e);
		    	    }    
		    	}
	     
	      st.close();
	      }
	
	    
	    catch (Exception e)
	    {
	JOptionPane.showMessageDialog(null, "Error ! Got an exception \n"+e.getMessage());
	    }
	    
	}
    
   
    
	public void delet(Object id,String table)
	{
		   // JDBC driver name and database URL
		  // String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/car_rental", "root", "");
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      String sql = "DELETE FROM "+table+" WHERE id = "+"'"+id+"'";
	                   
		      stmt.executeUpdate(sql);

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}
	public void update(String sql)
	{
		   try{
			      // create a mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/car_rental";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			       
			      Statement st = conn.createStatement();
			 
			      // updating
			  /*    sql="UPDATE car_mang " +
		                   "SET color = 30 WHERE id in (100, 101)";*/
			      st.executeUpdate(sql);
			 
			      conn.close();
		   }
		
			      catch (Exception e)
			      {
			        System.err.println("Got an exception!");
			        System.err.println(e.getMessage());
			      }
	}
public void insert(String query)
{
    try
    {
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/car_rental";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
       
      Statement st = conn.createStatement();
 
      // adding
      st.executeUpdate(query);
 
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
}
public boolean areUsuretoDelete()
{
	int con=JOptionPane.showConfirmDialog(null, "Do you want to delete the selected record ?","Confirm",JOptionPane.YES_NO_OPTION);
	if(con==1)
		return false;
	else
		return true;
}
public String carCost()
{return this.carCost;
}
public void setJtable(String a)
{
	this.jtable=a;
}
public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
}
}
