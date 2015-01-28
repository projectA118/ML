package com.balafoutas.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.balafoutas.Main;
import com.balafoutas.crypt.Base64;

public class Registration {

	public static void registerAccount(String username, String password, String again, String firstName, String lastName) throws UnsupportedEncodingException, NoSuchAlgorithmException, ClassNotFoundException, SQLException
	{
		
		
		if(!password.equals(again))
		{
			return;
		}
		
		int accId = Rnd.get(100000000, 999999999);
		MessageDigest md = MessageDigest.getInstance("SHA");
		final byte[] raw = password.getBytes("UTF-8");
		final byte[] hash = md.digest(raw);
				 
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("INSERT INTO account (id,username,password,admin) VALUES (?,?,?,?)");
			stmt.setInt(1, accId);
			stmt.setString(2, username);
			stmt.setString(3, Base64.encodeBytes(hash));
			stmt.setInt(4,0);
			stmt.execute();
			stmt.close();
			
			PreparedStatement stmt2 = con.prepareStatement("INSERT INTO customers (customerid, cus_first_name, cus_last_name) VALUES (?,?,?)");
			stmt2.setInt(1, accId);
			stmt2.setString(2, firstName);
			stmt2.setString(3, lastName);

			stmt2.execute();
			stmt2.close();
			
			Main.btnConfirm.setText("Account created!");
			System.out.println("Ola ok maga mou");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static boolean userExists(String username)
	{
		boolean exists = false;
		
		
		
		return exists;
		
	}
}
