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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class insertSer extends JFrame {
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
	private JTextField textSID;
	private JTextField textCID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertSer frame = new insertSer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
   private void clearFeilds() {
	   
		textID.setText(null);
     	textSID.setText(null);
         textCID.setText(null);

}
	/**
	 * Create the frame.
	 */
	public insertSer() {
		setTitle("New Service");

		setVisible(false);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 170, 488,450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICE ID");
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
		 Image id = new ImageIcon(this.getClass().getResource("/newID.png")).getImage();
		 lblid.setIcon(new ImageIcon(id));
		 Image price = new ImageIcon(this.getClass().getResource("/phone.png")).getImage();
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 
		 JButton btnInsert = new JButton("ADD NEW SERVICE");
		 btnInsert.setBackground(new Color(128, 0, 0));
		 btnInsert.setForeground(new Color(255, 255, 255));
		 btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnInsert.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		
try {
	
	insertCustomer cust= new insertCustomer ();
	String CID = cust.cid2;
    System.out.println(cust.cid2);

	connectDB();
	System.out.println("CONNECTED!");

  
		 			 String sql = "insert into service values (?,?,?) ";
		 			 PreparedStatement  stmt = con.prepareStatement(sql);
		 			 
                    stmt.setInt(1,Integer.parseInt(textID.getText()));

                    if (textCID.getText()== null)
      		 			JOptionPane.showMessageDialog(null,"Missing Customer ID!");
                    stmt.setInt(2,Integer.parseInt(textCID.getText()));
                    if (textSID.getText()==null)
      		 			JOptionPane.showMessageDialog(null,"Misssing Servant ID!");
                    stmt.setInt(3,Integer.parseInt(textSID.getText()));
                   
                   

                     stmt.executeUpdate();

                 
                    	
      		 			JOptionPane.showMessageDialog(null,"Stored Successfully!");
                    
                     clearFeilds();
                     con.close();
}
catch(Exception e1) {
	if (textID.getText() == null)
			JOptionPane.showMessageDialog(null,"Missing Service ID!");		
    JOptionPane.showMessageDialog(null,"Invalid Data !");
		 		 
}
		 		
		 		
		 	}
		 });
		 btnInsert.setBounds(132, 315, 194, 50);
		 contentPane.add(btnInsert);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(222, 184, 135));
		 panel.setBounds(3, 0, 466, 41);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblgirl = new JLabel("");
		 lblgirl.setBounds(8, 5, 32, 32);
		 panel.add(lblgirl);
		 lblgirl.setIcon(new ImageIcon(girl));
		 
		 JLabel lblNewLabel_1 = new JLabel("Insert Service Information Below :");
		 lblNewLabel_1.setBounds(40, 11, 315, 20);
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(0, 0, 139));
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 Image next = new ImageIcon(this.getClass().getResource("/Next.png")).getImage();
		 
		 JLabel lblprice_1 = new JLabel("");
		 lblprice_1.setBounds(14, 166, 40, 34);
		 contentPane.add(lblprice_1);
		 Image home = new ImageIcon(this.getClass().getResource("/cust-service.png")).getImage();
		 lblprice_1.setIcon(new ImageIcon(home));
		 
		 JLabel lblprice_2 = new JLabel("");
		 lblprice_2.setBounds(14, 245, 40, 34);
		 contentPane.add(lblprice_2);
		 Image emm = new ImageIcon(this.getClass().getResource("/eee.png")).getImage();
		 lblprice_2.setIcon(new ImageIcon(emm));
		 
		 JLabel lblServicedId = new JLabel("SERVICED ID");
		 lblServicedId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblServicedId.setBounds(64, 166, 187, 36);
		 contentPane.add(lblServicedId);
		 
		 textSID = new JTextField();
		 textSID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textSID.setColumns(10);
		 textSID.setBounds(277, 170, 148, 30);
		 contentPane.add(textSID);
		 
		 JLabel lblCustomerId = new JLabel("CUSTOMER ID");
		 lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblCustomerId.setBounds(64, 245, 187, 36);
		 contentPane.add(lblCustomerId);
		 
		 textCID = new JTextField();
		 textCID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textCID.setColumns(10);
		 textCID.setBounds(277, 245, 148, 30);
		 contentPane.add(textCID);
		 
		 JLabel lblnext = new JLabel("");
		 lblnext.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		deleteService delete = new deleteService();
		 		delete.setVisible(true);
		 		insertSer.this.dispose();
		 	}
		 });
		 lblnext.setBounds(437, 380, 32, 28);
		 contentPane.add(lblnext);
		 lblnext.setIcon(new ImageIcon(next));
		 
		 JLabel lblback = new JLabel("");
		 lblback.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		insertSer.this.dispose();
		 	}
		 });
		 lblback.setBounds(2, 380, 32, 28);
		 contentPane.add(lblback);
		 Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		 lblback.setIcon(new ImageIcon(back));
		 
		 JButton btnCustomersData = new JButton("CUSTOMERS  DATA");
		 btnCustomersData.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		custmTable c = new custmTable();
		 		c.setVisible(true);
		 	}
		 });
		 btnCustomersData.setForeground(Color.WHITE);
		 btnCustomersData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 btnCustomersData.setBackground(new Color(128, 0, 0));
		 btnCustomersData.setBounds(3, 40, 156, 23);
		 contentPane.add(btnCustomersData);
		 
		 JButton btnEmployeesData = new JButton("EMPLOYEES  DATA");
		 btnEmployeesData.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		EmployeeTable b= new EmployeeTable();
		 		b.setVisible(true);
		 	}
		 });
		 btnEmployeesData.setForeground(Color.WHITE);
		 btnEmployeesData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 btnEmployeesData.setBackground(new Color(128, 0, 0));
		 btnEmployeesData.setBounds(157, 40, 156, 23);
		 contentPane.add(btnEmployeesData);
		 
		 JButton btnServicesData = new JButton("SERVICES  DATA");
		 btnServicesData.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		serTable ser = new serTable();
		 		ser.setVisible(true);
		 	}
		 });
		 btnServicesData.setForeground(Color.WHITE);
		 btnServicesData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 btnServicesData.setBackground(new Color(128, 0, 0));
		 btnServicesData.setBounds(313, 40, 156, 23);
		 contentPane.add(btnServicesData);
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
