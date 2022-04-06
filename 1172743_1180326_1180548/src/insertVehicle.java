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


public class insertVehicle extends JFrame {
	private ArrayList<employee> dataList;
	 private ArrayList<employee> data ;
	
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNum;
	private JTextField textName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertVehicle frame = new insertVehicle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
   private void clearFeilds() {
	   
		textID.setText(null);
     	textNum.setText(null);
     	textName.setText(null);
     	

}
	/**
	 * Create the frame.
	 */
	public insertVehicle() {

		setVisible(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 170, 533,400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VEHICLE NUMBER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 90, 203, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPriceOfOrder = new JLabel("VEHICLE TYPE");
		lblPriceOfOrder.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPriceOfOrder.setBounds(64, 160, 164, 36);
		contentPane.add(lblPriceOfOrder);
		
		textID = new JTextField();
		textID.setToolTipText("");
		textID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textID.setBounds(277, 90, 214, 30);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textNum = new JTextField();
		textNum.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textNum.setColumns(10);
		textNum.setBounds(277, 160, 214, 30);
		contentPane.add(textNum);
		
		JLabel lblid = new JLabel("");
		lblid.setBounds(14, 93, 40, 27);
		contentPane.add(lblid);
		 Image id = new ImageIcon(this.getClass().getResource("/ID.png")).getImage();
		 lblid.setIcon(new ImageIcon(id));
		
		JLabel lblprice = new JLabel("");
		lblprice.setBounds(14, 160, 40, 27);
		contentPane.add(lblprice);
		 Image price = new ImageIcon(this.getClass().getResource("/phone.png")).getImage();
		 lblprice.setIcon(new ImageIcon(price));

		 JButton btnNewButton = new JButton("BACK");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		insertVehicle.this.dispose();
		 	}
		 });
		 btnNewButton.setBackground(new Color(128, 0, 0));
		 btnNewButton.setForeground(new Color(255, 255, 255));
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnNewButton.setBounds(109, 300, 99, 36);
		 contentPane.add(btnNewButton);
		 
		 JButton btnInsert = new JButton("INSERT");
		 btnInsert.setBackground(new Color(128, 0, 0));
		 btnInsert.setForeground(new Color(255, 255, 255));
		 btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnInsert.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
try {
	

  connectDB();
System.out.println("Connected to database");


		 			 String sql = "insert into vehicle values (?,?,?) ";

		 			PreparedStatement  stmt = con.prepareStatement(sql);
		 			
                     stmt.setInt(1,Integer.parseInt(textID.getText()));
                    stmt.setInt(2,Integer.parseInt(textName.getText()));
                    stmt.setString(3,textNum.getText());


                      stmt.executeUpdate();
  		 			JOptionPane.showMessageDialog(null,"Stored successfully!");

                     clearFeilds();
                     
                     con.close();
                   

}
catch(Exception e1) {
		 		
		 			JOptionPane.showMessageDialog(null,"NO data Entered !");
		 		 
}
		 		
		 		
		 	}
		 });
		 btnInsert.setBounds(323, 300, 99, 36);
		 contentPane.add(btnInsert);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(255, 255, 240));
		 panel.setBounds(3, 3, 527, 41);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblgirl = new JLabel("");
		 lblgirl.setBounds(8, 5, 32, 32);
		 panel.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));
		 
		 JLabel lblNewLabel_1 = new JLabel("Insert Vehicle Information Below :");
		 lblNewLabel_1.setBounds(40, 11, 315, 20);
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(0, 0, 139));
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 Image home = new ImageIcon(this.getClass().getResource("/h.png")).getImage();
		 
		 JLabel lblAddress = new JLabel("EMPLOYEE ID");
		 lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblAddress.setBounds(64, 227, 164, 36);
		 contentPane.add(lblAddress);
		 
		 textName = new JTextField();
		 textName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textName.setColumns(10);
		 textName.setBounds(277, 227, 214, 30);
		 contentPane.add(textName);
		 Image emm = new ImageIcon(this.getClass().getResource("/Mail.png")).getImage(
				 );
		
		
		 JLabel lblcstmrName = new JLabel("");
		 lblcstmrName.setBounds(14, 227, 40, 34);
		 contentPane.add(lblcstmrName);
		 Image cstmr = new ImageIcon(this.getClass().getResource("/cstmr.png")).getImage();
		 lblcstmrName.setIcon(new ImageIcon(cstmr));
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
