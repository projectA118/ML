package com.balafoutas.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.balafoutas.util.MysqlHandler;

public class UserForm extends JFrame {

	private JPanel contentPane;
	JButton star1;
	JButton star2;
	JButton star3;
	JButton star4;
	private JButton star6;
	private JButton star5;
	private JButton star8;
	private JButton star7;
	private JButton star10;
	private JButton star9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserForm frame = new UserForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int starLevel = 0;
	private JLabel lblNewLabel;
	private JLabel lblEmployeeName;
	private JLabel lblServiceType;
	private JLabel lblDate;
	private JLabel lblRating;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblThanksForRating;
	private JLabel lblComments;
	private JTextArea txtServId;
	private JLabel lblEnterServiceid;
	private JTextPane textPane;
	
	
	public int getStarLevel()
	{
		
		return starLevel;
	}
	
	public void setStarLevel(int level)
	{
		starLevel = level;
		starLevelCheck();
		
	}
	
	public void starLevelCheck()
	{
		if(starLevel == 0)
		{
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 1){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 2){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			
		}
		if(starLevel == 3){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			
		}
		if(starLevel == 4){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 5){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 6){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 7){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 8){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 9){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		}
		if(starLevel == 10){
			star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
			star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
			star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
		}
	}
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws NumberFormatException 
	 */
	public UserForm() throws NumberFormatException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		star1 = new JButton("");
		star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
		star1.setBounds(113, 185, 13, 26);
		contentPane.add(star1);
		
		star2 = new JButton("");
		star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		star2.setBounds(125, 185, 13, 26);
		contentPane.add(star2);
		
		star3 = new JButton("");
		star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
		star3.setBounds(136, 185, 13, 26);
		contentPane.add(star3);
		
		star4 = new JButton("");
		star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		star4.setBounds(148, 185, 13, 26);
		contentPane.add(star4);
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);

		
		txtServId = new JTextArea();
		txtServId.setBounds(121, 16, 105, 20);
		contentPane.add(txtServId);
		txtServId.setBorder(border1);
		//.setBorder(border1);
		
		lblEnterServiceid = new JLabel("Enter ServiceID:");
		lblEnterServiceid.setBounds(20, 16, 108, 14);
		contentPane.add(lblEnterServiceid);
		
		lblNewLabel = new JLabel("Customer Name:");
		lblNewLabel.setBounds(18, 41, 103, 14);
		contentPane.add(lblNewLabel);
		
		lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(18, 65, 103, 14);
		contentPane.add(lblEmployeeName);
		
		lblServiceType = new JLabel("Service Type:");
		lblServiceType.setBounds(20, 90, 103, 14);
		contentPane.add(lblServiceType);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(20, 115, 80, 14);
		contentPane.add(lblDate);
		
		lblRating = new JLabel("Rating:");
		lblRating.setBounds(20, 190, 52, 14);
		contentPane.add(lblRating);
		
		label = new JLabel("");
		label.setBounds(121, 41, 105, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(121, 65, 105, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(121, 90, 105, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(121, 115, 184, 14);
		contentPane.add(label_3);
		
		lblThanksForRating = new JLabel("");
		lblThanksForRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForRating.setVerticalAlignment(SwingConstants.TOP);
		lblThanksForRating.setBounds(10, 222, 295, 14);
		contentPane.add(lblThanksForRating);
		
		lblComments = new JLabel("Comments:");
		lblComments.setBounds(18, 140, 72, 14);
		contentPane.add(lblComments);
		
		textPane = new JTextPane();
		textPane.setBounds(89, 136, 216, 47);
		
		textPane.setBorder(border1);
		contentPane.add(textPane);
		
		star6 = new JButton("");
		star6.setBounds(171, 185, 13, 26);
		contentPane.add(star6);
		
		star5 = new JButton("");
		star5.setBounds(159, 185, 13, 26);
		contentPane.add(star5);
		
		star8 = new JButton("");
		star8.setBounds(197, 185, 13, 26);
		contentPane.add(star8);
		
		star7 = new JButton("");
		star7.setBounds(185, 185, 13, 26);
		contentPane.add(star7);
		
		star10 = new JButton("");
		star10.setBounds(220, 185, 13, 26);
		contentPane.add(star10);
		
		star9 = new JButton("");
		star9.setBounds(208, 185, 13, 26);
		contentPane.add(star9);
		star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
		star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
		star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfoff.png")));
		star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightoff.png")));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 0);
		star1.setBorder(border);
		star2.setBorder(border);
		star3.setBorder(border);
		star4.setBorder(border);
		star5.setBorder(border);
		star6.setBorder(border);
		star7.setBorder(border);
		star8.setBorder(border);
		star9.setBorder(border);
		star10.setBorder(border);
		eventRegistration();
	}
	
	
	
	long serviceId = -1;

	private void eventRegistration() throws NumberFormatException, ClassNotFoundException
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		
		txtServId.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode()==KeyEvent.VK_ENTER){
					 serviceId = Long.parseLong(txtServId.getText());
					
					 try {
						label.setText(String.valueOf(MysqlHandler.getCustInfoById(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[0]))[0] + " " +
								String.valueOf(MysqlHandler.getCustInfoById(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[0]))[1])));
						
						label_1.setText(String.valueOf(MysqlHandler.getEmpInfoById(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[1]))[0] + " " +
								String.valueOf(MysqlHandler.getEmpInfoById(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[1]))[1])));
						
						label_2.setText(String.valueOf(MysqlHandler.getInfoByServiceId(serviceId)[2]));
						Date date = new Date(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[3]));

						label_3.setText(String.valueOf(sdf.format(date)));
						 
						 
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 try {
							if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
							 {
								textPane.setText(String.valueOf(MysqlHandler.getInfoByServiceId(serviceId)[5]));
								 lblThanksForRating.setText("You did not rate us yet.");
							 }
							else
							{
								setStarLevel(Integer.parseInt(MysqlHandler.getInfoByServiceId(serviceId)[4]));
								lblThanksForRating.setText("Thanks for rating the service!");
								
							}
						} catch (NumberFormatException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					
					
				 }
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		// on click listener for the txtUsername field
		star1.addMouseListener(new MouseListener()
				{
				
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						//if(getStarLevel()==0)
						star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						starLevelCheck();
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
								
						try {
							if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
							 {
								setStarLevel(1);
								try {
									MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
									lblThanksForRating.setText("Thanks for rating the service!");
								} catch (NumberFormatException | ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							 }
							else
							{
								lblThanksForRating.setText("You already rated this service.");
								return;
							}
						} catch (NumberFormatException | ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
					
				});
		
		star2.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0)
				//{
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				//}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(2);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
										
			}
			
		});
		star3.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0)
				//{
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				//}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(3);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star4.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(4);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star5.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(5);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star6.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(6);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star7.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(7);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star8.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(8);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star9.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(9);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		star10.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//if(getStarLevel()==0){
				star1.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star2.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star3.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star4.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star5.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star6.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star7.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star8.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				star9.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfleftfull.png")));
				star10.setIcon(new ImageIcon(this.getClass().getResource("/resources/halfrightfull.png")));
				
				
		//	}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				starLevelCheck();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					if(Long.parseLong(MysqlHandler.getInfoByServiceId(serviceId)[4]) == -1)
					 {
						setStarLevel(10);
						try {
							MysqlHandler.updateServiceInfoById(txtServId.getText(), getStarLevel(), textPane.getText());
							lblThanksForRating.setText("Thanks for rating the service!");
						} catch (NumberFormatException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 }
					else
					{
						lblThanksForRating.setText("You already rated this service.");
						return;
					}
				} catch (NumberFormatException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
