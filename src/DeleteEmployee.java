import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.Observable;
import java.util.Properties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.PreparedStatement;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class DeleteEmployee extends JFrame {
	
	
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {

		setVisible(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 170, 474,250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 90, 144, 36);
		contentPane.add(lblNewLabel);
		
		textID = new JTextField();
		textID.setToolTipText("");
		textID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textID.setBounds(277, 90, 148, 30);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblid = new JLabel("");
		lblid.setBounds(14, 93, 40, 27);
		contentPane.add(lblid);
		 Image id = new ImageIcon(this.getClass().getResource("/ID.png")).getImage();
		 lblid.setIcon(new ImageIcon(id));
		 Image price = new ImageIcon(this.getClass().getResource("/phone.png")).getImage();
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 
		 JButton btnNewButton = new JButton("BACK");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		DeleteEmployee.this.dispose();
		 	}
		 });
		 btnNewButton.setBackground(new Color(128, 0, 0));
		 btnNewButton.setForeground(new Color(255, 255, 255));
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnNewButton.setBounds(67, 164, 99, 36);
		 contentPane.add(btnNewButton);
		 
		 JButton btnD = new JButton("DELETE");
		 btnD.setBackground(new Color(128, 0, 0));
		 btnD.setForeground(new Color(255, 255, 255));
		 btnD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnD.addActionListener(new ActionListener() {
		 
		 		public void actionPerformed(ActionEvent e) {
			 		
			 		
		 			try {
		 				

		 			  connectDB();
		 			  System.out.println("CONNECTED");
		 			   String sql = "delete from employees where eid ="+Integer.parseInt(textID.getText());
		 		       PreparedStatement  stmt = con.prepareStatement(sql);
                     int num=  stmt.executeUpdate();
                     if(num==1)
                   JOptionPane.showMessageDialog(null,"Delete successfully!");
                     else
                    	 JOptionPane.showMessageDialog(null,"Invalid Employee ID!"); 

		 			                   clearFeilds();
		 			                     con.close();
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			JOptionPane.showMessageDialog(null,"NO data Entered !");
		 					 		 
		 			}
		 					 		
		 					 		
		 					 	}
		 					 });
		 btnD.setBounds(301, 164, 99, 36);
		 contentPane.add(btnD);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(255, 255, 255));
		 panel.setBounds(3, 3, 468, 41);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblgirl = new JLabel("");
		 lblgirl.setBounds(8, 5, 32, 32);
		 panel.add(lblgirl);
		 lblgirl.setIcon(new ImageIcon(girl));
		 
		 JLabel lblNewLabel_1 = new JLabel("Insert The Employee ID in order To Delete him/her:");
		 lblNewLabel_1.setBounds(40, 11, 428, 20);
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(0, 0, 139));
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 Image home = new ImageIcon(this.getClass().getResource("/h.png")).getImage();
		 Image emm = new ImageIcon(this.getClass().getResource("/eee.png")).getImage();
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
