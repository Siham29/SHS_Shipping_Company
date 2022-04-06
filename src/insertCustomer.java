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


public class insertCustomer extends JFrame {
	private ArrayList<employee> dataList;
	 private ArrayList<employee> data ;
	
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNum;
	private JTextField textName;
	private JTextField textAdd;
	private JTextField textMail;
	static String name ;
	static String add ;
	static String mail;
	static String name2 = name; 
	static String add2 = add;
	static String mail2= mail;
	static String cid ;
	static String cid2 = cid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertEmployee frame = new InsertEmployee();
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
     	textAdd.setText(null);
        textMail.setText(null); 

}
	/**
	 * Create the frame.
	 */
	public insertCustomer() {

		setVisible(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 170, 533,486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 90, 144, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPriceOfOrder = new JLabel("PHONE NUMBER");
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
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 
		 JButton btnNewButton = new JButton("BACK");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		insertCustomer.this.dispose();
		 	}
		 });
		 btnNewButton.setBackground(new Color(128, 0, 0));
		 btnNewButton.setForeground(new Color(255, 255, 255));
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnNewButton.setBounds(109, 430, 99, 36);
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
 name = textName.getText();
 add = textAdd.getText();
 mail = textMail.getText();
 cid = textID.getText();
cid2= cid;
name2 = name;
add2 = add; 
mail2 = mail;
		 			 String sql = "insert into customers values (?,?,?,?,?) ";

		 			PreparedStatement  stmt = con.prepareStatement(sql);
		 			
                     stmt.setInt(1,Integer.parseInt(textID.getText()));
                    stmt.setString(2,(textNum.getText()));
                    stmt.setString(3,textName.getText());
                    stmt.setString(4, textAdd.getText());
                    stmt.setString(5, textMail.getText());

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
		 btnInsert.setBounds(323, 430, 99, 36);
		 contentPane.add(btnInsert);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(255, 255, 255));
		 panel.setBounds(3, 3, 527, 41);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblgirl = new JLabel("");
		 lblgirl.setBounds(8, 5, 32, 32);
		 panel.add(lblgirl);
		 lblgirl.setIcon(new ImageIcon(girl));
		 
		 JLabel lblNewLabel_1 = new JLabel("Insert Customer Information Below :");
		 lblNewLabel_1.setBounds(40, 11, 315, 20);
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(0, 0, 139));
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 
		 JLabel lblprice_1 = new JLabel("");
		 lblprice_1.setBounds(14, 292, 40, 34);
		 contentPane.add(lblprice_1);
		 Image home = new ImageIcon(this.getClass().getResource("/h.png")).getImage();
		 lblprice_1.setIcon(new ImageIcon(home));
		 
		 JLabel lblAddress = new JLabel("CUSTOMER NAME");
		 lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblAddress.setBounds(64, 227, 164, 36);
		 contentPane.add(lblAddress);
		 
		 textName = new JTextField();
		 textName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textName.setColumns(10);
		 textName.setBounds(277, 227, 214, 30);
		 contentPane.add(textName);
		 
		 JLabel lblprice_2 = new JLabel("");
		 lblprice_2.setBounds(14, 356, 40, 34);
		 contentPane.add(lblprice_2);
		 Image emm = new ImageIcon(this.getClass().getResource("/Mail.png")).getImage();
		 lblprice_2.setIcon(new ImageIcon(emm));
		 
		 JLabel lblEmployeeType = new JLabel("ADDRESS");
		 lblEmployeeType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblEmployeeType.setBounds(64, 290, 164, 36);
		 contentPane.add(lblEmployeeType);
		 
		 textAdd = new JTextField();
		 textAdd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textAdd.setColumns(10);
		 textAdd.setBounds(277, 290, 214, 30);
		 contentPane.add(textAdd);
		 
		 JLabel lblEmployeeType_1 = new JLabel("CUSTOMER EMAIL");
		 lblEmployeeType_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblEmployeeType_1.setBounds(64, 356, 185, 36);
		 contentPane.add(lblEmployeeType_1);
		 
		 textMail = new JTextField();
		 textMail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textMail.setColumns(10);
		 textMail.setBounds(277, 357, 214, 30);
		 contentPane.add(textMail);
		 
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
