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

public class upOrder extends JFrame {
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textPrice;
	private JTextField textV;
	private JTextField textOid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					upOrder frame = new upOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public upOrder() {
		setTitle("Update Service");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 180, 485, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(3, 0, 463, 41);
		contentPane.add(panel);
		
		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(8, 5, 32, 32);
		panel.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));

		
		JLabel lblNewLabel_1 = new JLabel("Enter Order Data You Want To Update Below :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 11, 394, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblServantId = new JLabel("PRICE OF ORDER");
		lblServantId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblServantId.setBounds(26, 169, 201, 33);
		contentPane.add(lblServantId);
		
		JLabel lblCustomerId = new JLabel("VEHICLE NUMBER");
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomerId.setBounds(28, 225, 156, 33);
		contentPane.add(lblCustomerId);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(270, 165, 182, 33);
		contentPane.add(textPrice);
		
		textV = new JTextField();
		textV.setColumns(10);
		textV.setBounds(270, 226, 182, 33);
		contentPane.add(textV);
		
		JButton btnNewButton = new JButton("UPDATE INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
	 				

		 			  connectDB();
		 			  System.out.println("Connected");

                       String sqlq = "update orders SET vnumber = '"+ textV.getText()+"', price ='"+ textPrice.getText()+"'  where oid ='"+textOid.getText()+"'";

                       PreparedStatement  stmt = con.prepareStatement(sqlq);
                       
                      int num = stmt.executeUpdate();
                      if (num == 1)
     		 			JOptionPane.showMessageDialog(null,"Stored Successfully !");
                      else
       		 			JOptionPane.showMessageDialog(null,"Invalid Service ID !");

                      textOid.setText(null);
                   textPrice.setText(null);
                   textV.setText(null);

		 		  con.close();
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			JOptionPane.showMessageDialog(null,"Invalid Input !");
		 					 		 
		 			}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(147, 293, 192, 41);
		contentPane.add(btnNewButton);
		
		JButton btnShowTable = new JButton("SERVICES  DATA");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				serTable ser = new serTable();
				ser.setVisible(true);
				
			}
		});
		btnShowTable.setBackground(new Color(128, 0, 0));
		btnShowTable.setForeground(new Color(255, 255, 255));
		btnShowTable.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable.setBounds(3, 40, 156, 23);
		contentPane.add(btnShowTable);
		
		JButton btnEmployeesData = new JButton("ORDERS  DATA");
		btnEmployeesData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderTable emp= new OrderTable();
				emp.setVisible(true);
			}
		});
		btnEmployeesData.setForeground(Color.WHITE);
		btnEmployeesData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnEmployeesData.setBackground(new Color(128, 0, 0));
		btnEmployeesData.setBounds(157, 40, 156, 23);
		contentPane.add(btnEmployeesData);
		
		JButton btnCustomersData = new JButton("CUSTOMERS  DATA");
		btnCustomersData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custmTable custm = new custmTable();
				custm.setVisible(true);
			}
		});
		btnCustomersData.setForeground(Color.WHITE);
		btnCustomersData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCustomersData.setBackground(new Color(128, 0, 0));
		btnCustomersData.setBounds(310, 40, 156, 23);
		contentPane.add(btnCustomersData);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upOrder.this.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(201, 355, 89, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblOrderId = new JLabel("ORDER ID");
		lblOrderId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblOrderId.setBounds(27, 104, 121, 33);
		contentPane.add(lblOrderId);
		
		textOid = new JTextField();
		textOid.setColumns(10);
		textOid.setBounds(270, 104, 182, 33);
		contentPane.add(textOid);
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
}


