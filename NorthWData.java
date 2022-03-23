import java.awt.*;        
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class NorthWData extends Frame {
   
	private DBLayer database;
	
   public NorthWData () {
    
	  // final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		
	   
      JFrame  frame = new JFrame("Unit 2 NorthWind Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		JButton connectButton = new JButton();
		connectButton.setText("Connect to DataBase ");
		frame.add(connectButton);
		connectButton.setBounds(100,60,190,20);
		connectButton.addActionListener(new ActionListener() {
				 
			public void actionPerformed(ActionEvent arg0) {
					try {
						
						
						
					String jdbcURL =
								"jdbc:sqlserver://LAPTOP-D3JARR3N\\SQLEXPRESS.Northwind;"
								+ "database=Northwind;"
								+ "encrypt=false;"
								+ "trustServerCertificate=false;"
								+ "loginTimeout=10;";
					
						JOptionPane.showMessageDialog(null, "Connected");
					
						} catch (Exception e) {
							JOptionPane.showMessageDialog(connectButton, e.getMessage() );
						}
			}
		});
		
		
		JButton countButton = new JButton();
		countButton.setText("Customer Count ");
		frame.add(countButton);
		countButton.setBounds(100,100,190,20);
		countButton.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent ev) {
				
						try {
								String countValue = database.getCustomerCount();
								JOptionPane.showMessageDialog(null, "Customer count is: " + countValue);
								
							}catch (Exception e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
								
							}
 							
						}
				
			
	});
		
		
		JButton nameButton = new JButton();
		nameButton.setText("Customer Name ");
		frame.add(nameButton);
		nameButton.setBounds(100,140,190,20);
		frame.setLayout(null);
		frame.setVisible(true);
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						String nameValue = database.getCustomerNames();
						javax.swing.JOptionPane.showMessageDialog(null, "Customer names are: " + nameValue);
							
					
				}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
				}			
			}
			
		});
   }

 
   public static void main(String[] args) {

     NorthWData app = new NorthWData();
   }
}
