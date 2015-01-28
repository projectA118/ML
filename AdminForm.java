package com.balafoutas.forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.balafoutas.util.MysqlHandler;
import com.balafoutas.util.Rnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractListModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCXYDataset;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class AdminForm extends JFrame {

	private JPanel ratingPanel;
	private JPanel hirePanel;
	private JPanel blankPanel;
	private JPanel commentsPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm frame = new AdminForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JMenuBar menuBar;
	JMenu mnNewMenu_1;
	JMenuItem mntmHire;
	JMenuItem mntmRatings;
	JMenuItem mntmGraphical;
	private JList<?> list_1;
	private static JList<?> list_2;
	private JLabel lblSpeciality;
	private JList<?> list;
	JButton btnConfirm;
	
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public AdminForm() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu_1 = new JMenu("Employees");
		menuBar.add(mnNewMenu_1);
		
		mntmHire = new JMenuItem("Hire");
		mnNewMenu_1.add(mntmHire);
		
		mntmRatings = new JMenuItem("Ratings");
		mnNewMenu_1.add(mntmRatings);
		
		mntmGraphical = new JMenuItem("Rating Graph");
		mnNewMenu_1.add(mntmGraphical);
		
		// contentpanel default
		blankPanel = new JPanel();
	
		blankPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		commentsPanel = new JPanel();
	
		commentsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		hirePanel= new JPanel();
	
		hirePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//content panel new custoemer
		ratingPanel = new JPanel();
		ratingPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(hirePanel);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setBounds(27, 29, 70, 14);
		hirePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee");
		lblNewLabel_1.setBounds(27, 54, 70, 14);
		hirePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(27, 79, 46, 14);
		hirePanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(27, 104, 46, 14);
		hirePanel.add(lblNewLabel_3);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(106, 132, 89, 23);
		hirePanel.add(btnConfirm);
		
		MysqlHandler.getEmpNames();
		list = new JList(listModel);
		list.setBounds(27, 54, 171, 95);
		ratingPanel.add(list);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(70, 34, 110, 14);
		ratingPanel.add(lblEmployeeName);
		
		list_1 = new JList<Object>();
		list_1.setBounds(167, 57, 1, 1);
		ratingPanel.add(list_1);
		
		list_2 = new JList<Object>();
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"Engineer", "Hydravlic", "Home Cleaner"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_2.setBounds(208, 54, 110, 95);
		ratingPanel.add(list_2);
		
		lblSpeciality = new JLabel("Speciality");
		lblSpeciality.setBounds(282, 34, 91, 14);
		ratingPanel.add(lblSpeciality);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(25, 11, 379, 218);
		commentsPanel.add(table);
		//table.getColumnModel().table.AUTO_RESIZE_ALL_COLUMNS;
		//FillTable(table, "select * employees;");
		  UtilDateModel model=new UtilDateModel();
	      JDatePanelImpl datePanel = new JDatePanelImpl(model);
	      datePicker = new JDatePickerImpl(datePanel);
	      SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
	      springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
	      datePicker.setBounds(96,101,146,20);
	      hirePanel.add(datePicker);
	      
	      textField = new JTextField();
	      textField.setBounds(96, 76, 146, 20);
	      hirePanel.add(textField);
	      textField.setColumns(10);
	      
	      txtFinal = new JLabel("");
	      txtFinal.setHorizontalAlignment(SwingConstants.CENTER);
	      txtFinal.setBounds(60, 166, 182, 14);
	      hirePanel.add(txtFinal);
	      
	      txtCust = new JTextField();
	      txtCust.setBounds(96, 26, 146, 20);
	      hirePanel.add(txtCust);
	      txtCust.setColumns(10);
	      
	      txtEmp = new JTextField();
	      txtEmp.setBounds(96, 51, 146, 20);
	      hirePanel.add(txtEmp);
	      txtEmp.setColumns(10);
		loadData();
		eventRegistration();
	}
	   JDatePickerImpl datePicker;
	   
	private final DefaultTableModel tableModel = new DefaultTableModel();

	   private void loadData() {
	      table.setModel(tableModel);
	        try (Connection conn = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());
	                Statement stmt = conn.createStatement()) {

	            ResultSet rs = stmt.executeQuery("select rating, comments from services");
	           
	            ResultSetMetaData metaData = rs.getMetaData();

	            // Names of columns
	            Vector<String> columnNames = new Vector<String>();
	            int columnCount = metaData.getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                columnNames.add(metaData.getColumnName(i));
	            }

	            // Data of the table
	            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	            while (rs.next()) {
	                Vector<Object> vector = new Vector<Object>();
	                for (int i = 1; i <= columnCount; i++) {
	                    vector.add(rs.getObject(i));
	                }
	                data.add(vector);
	            }

	            tableModel.setDataVector(data, columnNames);
	        } catch (Exception e) {
	          
	        }
	     

	     
	    }
   
	
    public static void display(boolean check) throws ClassNotFoundException {
        JFrame f = new JFrame("Gamaw kai dernw");
       // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(check)
        {
        	JDBCXYDataset jds = createDataset(true,"");
        	JFreeChart chart = ChartFactory.createTimeSeriesChart("Ratings", "Date", "Rating", jds, true, true, false);
	        f.getContentPane().add(new ChartPanel(chart));
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
        }
        if(!check)
        {
        	selection =  list_2.getSelectedValue().toString();
        	JDBCXYDataset jds = createDataset(false,selection);
        	JFreeChart chart = ChartFactory.createTimeSeriesChart("Ratings", "Date", "Rating", jds, true, true, false);
	        f.getContentPane().add(new ChartPanel(chart));
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
        }
    }
     
    
    
    
    private static JDBCXYDataset createDataset(boolean check,String type) throws ClassNotFoundException {
        try {
        	Connection conn = DriverManager.getConnection(MysqlHandler.getUrl(), MysqlHandler.getDbUser(), MysqlHandler.getDbPass());
         
            JDBCXYDataset jds = new JDBCXYDataset(conn);
            String[] splited = selection.split("\\s+");
            if(check)
            	jds.executeQuery("SELECT date,rating FROM services WHERE employeeid=\""+MysqlHandler.getEmpIdByName(splited[0], splited[1])+"\"");
            if(!check)
            	jds.executeQuery("SELECT date,rating FROM services WHERE emp_type=\""+MysqlHandler.getEmpIdByType(type)+"\"");
            return jds;
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
    

	public static DefaultComboBoxModel <String> listModel = new DefaultComboBoxModel <String>();

	
	static String selection;
	private JTable table;
	private JTextField textField;
	private JLabel txtFinal;
	private JTextField txtCust;
	private JTextField txtEmp;
	public void eventRegistration()
	{
		
	
		list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	selection =  list.getSelectedValue().toString();
                	System.out.println(selection);
                	try {
						display(true);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        });
		 
		list_2.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	selection =  list_2.getSelectedValue().toString();
                	System.out.println(selection);
                	try {
						display(false);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        });
		
		
		mntmGraphical.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
				setContentPane(ratingPanel);
				
			}
			
		});
		
		btnConfirm.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
				long id = Rnd.get(10000000, 99999999);
				long empId = 0;
			
					try {
						empId = MysqlHandler.getEmpIdByName(txtEmp.getText().split(" ")[0], txtEmp.getText().split(" ")[1]);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				long custId = 0;
				try {
					custId = MysqlHandler.getCustIdByName(txtCust.getText().split(" ")[0], txtCust.getText().split(" ")[1]);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String type = textField.getText();
				Date date = null;
				try {
					date = new SimpleDateFormat("dd-MMM-yyyy").parse(datePicker.getJFormattedTextField().getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long milliseconds = date.getTime();
				try {
					MysqlHandler.insertNewService(id, custId, empId, type, milliseconds);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtFinal.setText("Entry added with id: " + id + ".");
			}
			
		});
	}
}
