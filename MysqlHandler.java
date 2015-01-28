package com.balafoutas.util;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.balafoutas.forms.AdminForm;

public class MysqlHandler {
	
	private static String dbUser = "root";
	private static String dbPass = "23";
	private static String url = "jdbc:mysql://83.212.109.125:3306/balabase";
	private static ArrayList<String> list = new ArrayList<String>();
	
	public static ArrayList<String> getUserList()
	{
		return list;
	}
	
	public static String getPassByName(String user) throws ClassNotFoundException
	{
		
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			String password = "";
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT password FROM account WHERE username=?");
			stmt.setString(1, user);
			ResultSet rset = stmt.executeQuery();
			while(rset.next())
			{
				password = rset.getString(1);
			}
			stmt.execute();
			stmt.close();
			
		//	System.out.println(password);
			return password;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean isAdmin(String user) throws ClassNotFoundException
	{
		boolean isAdm = false;
		int admin = 0;
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT admin FROM account WHERE username=?");
			stmt.setString(1, user);
			ResultSet rset = stmt.executeQuery();
			while(rset.next())
			{
				admin = rset.getInt(1);
				if(admin == 1)
					isAdm= true;
			}
			stmt.execute();
			stmt.close();
			
		//	System.out.println(password);
			return isAdm;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return isAdm;
	}
	
	public static void getAllDatabaseUsers() throws ClassNotFoundException
	{
		
		
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT username FROM account");
			
			ResultSet rset = stmt.executeQuery();
			ResultSetMetaData metadata = rset.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			while(rset.next())
			{
				int i = 1;
				while(i <= numberOfColumns)
					list.add(rset.getString(i++));
			}
			stmt.execute();
			stmt.close();		
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	}
	
	public static int getEmpNames() throws ClassNotFoundException
	{
		
		int rows = 0;
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT emp_first_name,emp_last_name,emp_type FROM employees");
			ResultSet rset = stmt.executeQuery();
			ResultSetMetaData metadata = rset.getMetaData();
			int numberOfColumns = metadata.getColumnCount();
			while(rset.next())
			{
				AdminForm.listModel.addElement(rset.getString(1) + " " + rset.getString(2) );

				rows = numberOfColumns;
			}
			
			stmt.execute();
			stmt.close();
		
			return rows;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	
	public static long getEmpIdByName(String firstName, String lastName) throws ClassNotFoundException
	{
		
		long id = 0;
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT employeeid FROM employees WHERE emp_first_name=? AND emp_last_name=?");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			ResultSet rset = stmt.executeQuery();
			
			while(rset.next())
			{
				id = rset.getLong(1);
			}
			
			stmt.execute();
			stmt.close();
		
			return id;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public static long getCustIdByName(String firstName, String lastName) throws ClassNotFoundException
	{
		
		long id = 0;
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT customerid FROM customers WHERE cus_first_name=? AND cus_last_name=?");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			ResultSet rset = stmt.executeQuery();
			
			while(rset.next())
			{
				id = rset.getLong(1);
			}
			
			stmt.execute();
			stmt.close();
		
			return id;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public static long getEmpIdByType(String type) throws ClassNotFoundException
	{
		
		long id = 0;
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT employeeid FROM employees WHERE emp_type=?");
			stmt.setString(1, type);
			ResultSet rset = stmt.executeQuery();
			
			while(rset.next())
			{
				id = rset.getLong(1);
			}
			
			stmt.execute();
			stmt.close();
		
			return id;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public static String[] getCustInfoById(long custId) throws ClassNotFoundException
	{
		
		String[] names = new String[2];
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT cus_first_name,cus_last_name FROM customers WHERE customerid=?");
			stmt.setLong(1, custId);
			ResultSet rset = stmt.executeQuery();

			while(rset.next())
			{
				names[0] = rset.getString(1);
				names[1] = rset.getString(2);
			}
			stmt.execute();
			stmt.close();
		
			return names;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return names;
	}
	
	public static String[] getCustInfoById1(long custId) throws ClassNotFoundException
	{
		
		String[] names = new String[2];
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT cus_first_name,cus_last_name FROM customers WHERE customerid=?");
			stmt.setLong(1, custId);
			ResultSet rset = stmt.executeQuery();

			while(rset.next())
			{
				names[0] = rset.getString(1);
				names[1] = rset.getString(2);
			}
			stmt.execute();
			stmt.close();
		
			return names;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return names;
	}
	
	public static String[] getEmpInfoById(long empId) throws ClassNotFoundException
	{
		
		String[] names = new String[3];
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT emp_first_name,emp_last_name,emp_type FROM employees WHERE employeeid=?");
			stmt.setLong(1, empId);
			ResultSet rset = stmt.executeQuery();
			
			while(rset.next())
			{
				names[0] = rset.getString(1);
				names[1] = rset.getString(2);
				names[2] = rset.getString(3);
			}
			stmt.execute();
			stmt.close();
		
			return names;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return names;
	}
	
	public static void insertNewService(long servid,long custId,long empId,String serviceType,long dateId) throws ClassNotFoundException
	{
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("INSERT INTO services (serviceid,customerid,employeeid,servicetype,date,rating,comments) VALUES (?,?,?,?,?,?,?);");
			
			stmt.setLong(1, servid);
			stmt.setLong(2, custId);
			stmt.setLong(3, empId);
			stmt.setString(4, serviceType);
			stmt.setLong(5, dateId);
			stmt.setInt(6, -1);
			stmt.setString(7, "");
			stmt.execute();
			stmt.close();
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void updateServiceInfoById(String servId,int rating, String comments) throws ClassNotFoundException
	{
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("UPDATE services SET rating=?, comments=? WHERE serviceid=?");
			
			stmt.setInt(1, rating);
			stmt.setString(2, comments);
			stmt.setString(3, servId);
			
			stmt.execute();
			stmt.close();
				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String[] getInfoByServiceId(long servId) throws ClassNotFoundException
	{
		
		String[] info = new String[6];
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT customerid,employeeid,servicetype,date,rating,comments FROM services WHERE serviceid=?");
			stmt.setLong(1, servId);
			ResultSet rset = stmt.executeQuery();
			
			while(rset.next())
			{
				info[0] = rset.getString(1);
				info[1] = rset.getString(2);
				info[2] = rset.getString(3);
				info[3] = rset.getString(4);
				info[4] = rset.getString(5);
				info[5] = rset.getString(6);
			}
			stmt.execute();
			stmt.close();
		
			return info;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return info;
	}
	
	public static String getDbUser()
	{
		return dbUser;
	}
	
	public static String getDbPass()
	{
		return dbPass;
	}
	
	public static String getUrl()
	{
		return url;
	}
}
