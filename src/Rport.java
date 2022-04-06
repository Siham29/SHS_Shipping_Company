import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Rport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnShowTable;
	private JButton btnShowTable_1;
	private JButton btnShowTable_2;
	
	
	

	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private JTextField textID;
	private Connection con;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rport frame = new Rport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	   private void clearFeilds() {
		   
			textID.setText(null);
	     
	         

	}
	
	
	/**
	 * Create the frame.
	 */
	public Rport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(-12, 0, 498, 44);
		contentPane.add(panel);
		
		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(31, 5, 32, 32);
		panel.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/rep1.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));
		
		JLabel lblNewLabel_1 = new JLabel("EMPLOYEE REPORT");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(161, 17, 356, 20);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(313, 90, 159, 33);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 171, 159, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(313, 244, 159, 33);
		contentPane.add(textField_2);
		
		
		
		
		
		btnShowTable = new JButton("SHOW THE NUMBER OF DRIVERS");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	 				

		 			  connectDB();

		 			   String sql = "SELECT COUNT(TypeE) FROM Employees e WHERE e.eid>199 and e.eid<=249;";

		 		       PreparedStatement  stmt = con.prepareStatement(sql);
		 		      ResultSet rs = stmt.executeQuery();

		 			  if(rs.next()) { 
		 				  
		 				 String count=rs.getString("COUNT(TypeE)") ;
		 				  
		 				 textField.setText(count);	
		 				 
		 			     con.close(); 
		 				  
		 			  }
     
                   
              

		 			                  
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			JOptionPane.showMessageDialog(null,"NO data Entered !");
		 					 		 
		 			}
		 					 		
		 					 		
		 					 	}
				
				
				
				
				
				
				
				
				
			
		});
		btnShowTable.setForeground(Color.WHITE);
		btnShowTable.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable.setBackground(new Color(128, 0, 0));
		btnShowTable.setBounds(47, 86, 249, 44);
		contentPane.add(btnShowTable);
		
		btnShowTable_1 = new JButton("NUMBER OF SERVICES EMPLOYEES");
		btnShowTable_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
	 				

		 			  connectDB();

		 			   String sql = "SELECT COUNT(TypeE) FROM Employees e WHERE e.eid>=250 and e.eid<=299;";

		 		       PreparedStatement  stmt = con.prepareStatement(sql);
		 		      ResultSet rs = stmt.executeQuery();

		 			  if(rs.next()) { 
		 				  
		 				 String count=rs.getString("COUNT(TypeE)") ;
		 				  
		 				 textField_1.setText(count);	
		 			
		 			     con.close(); 
		 				  
		 			  }
   
                 
            

		 			                  
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			JOptionPane.showMessageDialog(null,"NO data Entered !");
		 					 		 
		 			}
		 					 		
		 					 		
		 					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnShowTable_1.setForeground(Color.WHITE);
		btnShowTable_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable_1.setBackground(new Color(128, 0, 0));
		btnShowTable_1.setBounds(47, 165, 249, 44);
		contentPane.add(btnShowTable_1);
		
		btnShowTable_2 = new JButton("SHOW EMPLOYEE NUMBER");
		btnShowTable_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	 				

		 			  connectDB();

		 			   String sql = "SELECT COUNT(TypeE) FROM Employees e ;";

		 		       PreparedStatement  stmt = con.prepareStatement(sql);
		 		      ResultSet rs = stmt.executeQuery();

		 			  if(rs.next()) { 
		 				  
		 				 String count=rs.getString("COUNT(TypeE)") ;
		 				  
		 				 textField_2.setText(count);	
		 				 
		 			     con.close(); 
		 				  
		 			  }
     
                   
              

		 			                  
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			JOptionPane.showMessageDialog(null,"NO data Entered !");
		 					 			ee.printStackTrace();
		 			}
		 					 		
		 					 		
		 					 	}
				
		});
		btnShowTable_2.setForeground(Color.WHITE);
		btnShowTable_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable_2.setBackground(new Color(128, 0, 0));
		btnShowTable_2.setBounds(47, 240, 249, 41);
		contentPane.add(btnShowTable_2);
		
		JLabel lblgirl_1 = new JLabel("");
		lblgirl_1.setBounds(10, 86, 32, 32);
		contentPane.add(lblgirl_1);
		Image de = new ImageIcon(this.getClass().getResource("/de.png")).getImage();
		lblgirl_1.setIcon(new ImageIcon(de));
		
		JLabel lblgirl_2 = new JLabel("");
		lblgirl_2.setBounds(10, 172, 32, 32);
		contentPane.add(lblgirl_2);
		Image se = new ImageIcon(this.getClass().getResource("/vice.png")).getImage();
		lblgirl_2.setIcon(new ImageIcon(se));
		
		JLabel lblgirl_3 = new JLabel("");
		lblgirl_3.setBounds(10, 244, 32, 33);
		contentPane.add(lblgirl_3);
		Image se1 = new ImageIcon(this.getClass().getResource("/lo.png")).getImage();
		lblgirl_3.setIcon(new ImageIcon(se1));
		
		
		
	}
private void connectDB() throws ClassNotFoundException, SQLException {

	dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
	Properties p = new Properties();
	p.setProperty("user", dbUsername);
	p.setProperty("password", dbPassword);
	p.setProperty("useSSL", "false");
	p.setProperty("autoReconnect", "true");
	Class.forName("com.mysql.jdbc.Driver");

	con = DriverManager.getConnection(dbURL, p);

}

public void ExecuteStatement(String SQL) throws SQLException {

	try {
		Statement stmt = con.createStatement();
		stmt.executeUpdate(SQL);
		stmt.close();
	
		 
	}
	catch(SQLException s) {
		s.printStackTrace();
		System.out.println("SQL statement is not executed!");
		  
	}
	
	
}
}
