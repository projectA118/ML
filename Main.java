package com.balafoutas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.balafoutas.crypt.Base64;
import com.balafoutas.forms.UserForm;
import com.balafoutas.util.MysqlHandler;
import com.balafoutas.util.Registration;

public class Main extends JFrame {
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JButton btnReg;
	private JButton btnLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	public static JButton btnConfirm;
	private JLabel label;
	private JLabel icon;
	private JLabel lblRegisterId;
	private JTextField regText;
	private JLabel lblLastName;
	private JTextField textField_1;
	
	public String getTxtUser()
	{
		return txtUsername.getText();
	}
	
	public String getTxtPass()
	{
		return passwordField.getText();
	}
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public Main() throws ClassNotFoundException {
		setTitle("Peoductions");
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(204, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 212);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setToolTipText("");
		txtUsername.setBounds(78, 69, 86, 20);
		txtUsername.setColumns(10);
		getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(78, 100, 86, 20);
		passwordField.setText("Password");
		getContentPane().add(passwordField);
		getContentPane().add(txtUsername);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setCaretColor(Color.BLACK);
		txtUsername.setBorder(border);
		passwordField.setBorder(border);
	
		//Cursor cursor = new Cursor();
		txtUsername.setFocusable(false);
		passwordField.setFocusable(false);
		
		btnReg = new JButton("Register");
		btnReg.setBounds(29, 131, 86, 20);
		getContentPane().add(btnReg);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(125, 131, 86, 20);
		getContentPane().add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(102, 174, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(36, 215, 86, 20);
		getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(125, 215, 86, 20);
		getContentPane().add(passwordField_2);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(78, 319, 86, 20);
		getContentPane().add(btnConfirm);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 177, 68, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPasswordTwice = new JLabel("Password twice");
		lblPasswordTwice.setBounds(78, 200, 105, 14);
		getContentPane().add(lblPasswordTwice);
		
		label = new JLabel("");
		label.setBounds(39, 152, 168, 14);
		getContentPane().add(label);
		
		icon = new JLabel("");
		
		icon.setBounds(192, 174, 22, 22);
		getContentPane().add(icon);
		
		lblRegisterId = new JLabel("First name:");
		lblRegisterId.setBounds(41, 249, 81, 14);
		getContentPane().add(lblRegisterId);
		
		regText = new JTextField();
		regText.setBounds(111, 277, 100, 20);
		getContentPane().add(regText);
		regText.setColumns(10);
		
		lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(40, 280, 68, 14);
		getContentPane().add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 246, 99, 20);
		getContentPane().add(textField_1);
		//new ImageIcon(this.getClass().getResource("/resources/no.png"))
		//new ImageIcon(this.getClass().getResource("/resources/yes.png"))
		eventRegistration();
		MysqlHandler.getAllDatabaseUsers();
		//System.out.print(MysqlHandler.getUserList());
	}
	
	public void eventRegistration()
	{
		
		textField.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) {
			
					
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
					if(MysqlHandler.getUserList().contains(String.valueOf(textField.getText())))
						icon.setIcon(new ImageIcon(this.getClass().getResource("/resources/no.png")));
					else
						icon.setIcon(new ImageIcon(this.getClass().getResource("/resources/yes.png")));
										
			}

			@Override
			public void keyTyped(KeyEvent e) {
			
			}
			
		});
		// Listener for setting textfields unfocused
		getContentPane().addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtUsername.getText().equalsIgnoreCase(""))
					txtUsername.setFocusable(false);
				if(passwordField.getText().equalsIgnoreCase(""))
					passwordField.setFocusable(false);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// on click listener for the txtUsername field
		txtUsername.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(txtUsername.getText().equalsIgnoreCase("Username"))
						{
							txtUsername.setFocusable(true);
							txtUsername.requestFocus();
						}	
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
		
		// on click listener for the txtUsername field
		btnLogin.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						if(getTxtUser().equalsIgnoreCase("") || 
								getTxtUser().equalsIgnoreCase("Username")||
								getTxtPass().equalsIgnoreCase("")||
								getTxtPass().equalsIgnoreCase("password"))
						{
							label.setText("Wrong username/password");
							System.out.println("Ti kaneis anathema?");
							return;
						}
						try {
							//SHA1 encryption
							MessageDigest md = MessageDigest.getInstance("SHA");
							final byte[] raw = getTxtPass().getBytes("UTF-8");
							final byte[] hash = md.digest(raw);
							if(Base64.encodeBytes(hash).equals(MysqlHandler.getPassByName(getTxtUser())))
							{
								if(MysqlHandler.isAdmin(getTxtUser()))
								{
									System.out.println("Login succesful (as admin)"); //correct password check in db
								}
								else
								{
									UserForm form = new UserForm();
									
									form.pack();
									form.setLocationByPlatform(true);
									form.setVisible(true);
									form.setBounds(100, 100, 331, 305);
									setVisible(false);
									System.out.println("Login succesful (as normal user)");
								}
							}
							else
							{
								label.setText("Wrong username/password");
								System.out.println("Wrong username/password"); //handles both
							}
							
							
							
							
						} catch (ClassNotFoundException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				});
		
		// focus listener for the txtUsername field
		txtUsername.addFocusListener(
				new FocusListener()
				{
					@Override
					public void focusGained(FocusEvent e) {
						if(txtUsername.getText().equalsIgnoreCase("Username"))
						{
							txtUsername.setText("");
							txtUsername.setForeground(Color.BLACK);
							txtUsername.setFocusable(true);
						}
					}

					@Override
					public void focusLost(FocusEvent e) {
						if(txtUsername.getText().equalsIgnoreCase(""))
						{
							txtUsername.setText("Username");
							txtUsername.setForeground(Color.GRAY);
						}
					}
				});
		
		// on click listener for the password field
		passwordField.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(passwordField.getText().equalsIgnoreCase("Password"))
				{
					passwordField.setFocusable(true);
					passwordField.requestFocus();
				}	

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// focus listener for the password field
		passwordField.addFocusListener(
				new FocusListener()
				{
					@Override
					public void focusGained(FocusEvent e) {
						if(passwordField.getText().equalsIgnoreCase("Password"))
						{
							passwordField.setText("");
							passwordField.setForeground(Color.BLACK);
							passwordField.setFocusable(true);
						}
					}

					@Override
					public void focusLost(FocusEvent e) {
						if(passwordField.getText().equalsIgnoreCase(""))
						{
							passwordField.setText("Password");
							passwordField.setForeground(Color.GRAY);
						}
					}
				});
		
		btnConfirm.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {


				try {
					if(MysqlHandler.getUserList().contains(String.valueOf(textField.getText())))
						return;
					if(textField.getText() != "" || passwordField_1.getText() != "" || passwordField_2.getText() != ""
							||textField_1.getText() != ""||regText.getText() != "")
						return;
					Registration.registerAccount(textField.getText(), passwordField_1.getText(), passwordField_2.getText(),textField_1.getText(),regText.getText() );
					
				} catch (UnsupportedEncodingException
						| NoSuchAlgorithmException | ClassNotFoundException
						| SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		btnReg.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			boolean sure = false;
			@Override
			public void mouseReleased(MouseEvent e) {
				if(!sure)
				{
					setBounds(getX(), getY(), 264, 385);
					btnReg.setText("Close");
					sure = true;
				}
				else if (sure)
				{
					setBounds(getX(), getY(), 264, 212);
					btnReg.setText("Register");
					sure = false;
				}
				
			}

			
			
		}
);

		
	}
}
