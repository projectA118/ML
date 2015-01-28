package com.balafoutas.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.balafoutas.crypt.Base64;

public class Login {

	public static void login(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, ClassNotFoundException, SQLException
	{
		
		
		MessageDigest md = MessageDigest.getInstance("SHA");
		final byte[] raw = password.getBytes("UTF-8");
		final byte[] hash = md.digest(raw);
		
		try(Connection con = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());)
		{
			Class.forName("com.mysql.jdbc.Driver");  // initialise the driver

			PreparedStatement stmt = con.prepareStatement("SELECT password FROM account WHERE username=?");
			stmt.setString(1, username);
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Ola ok maga mou");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	

	
}
