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
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class EmSer extends JFrame {
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textsemID;
	private JTextField TextADD;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmSer frame = new EmSer();
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
	public EmSer() {
		setTitle("Update Service");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 180, 492, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(3, 0, 470, 41);
		contentPane.add(panel);
		
		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(8, 5, 32, 32);
		panel.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));

		
		JLabel lblNewLabel_1 = new JLabel("Entered New Employee Information Below :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 11, 356, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(26, 72, 121, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblServantId = new JLabel("PHONE NUMBER");
		lblServantId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblServantId.setBounds(26, 122, 201, 33);
		contentPane.add(lblServantId);
		
		JLabel lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent e) {
				EmSer.this.dispose();
			}
		});
		
		
		 lblback.setBounds(1, 406, 32, 28);
		 contentPane.add(lblback);
		 
		 Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		 lblback.setIcon(new ImageIcon(back));
		
		
		
		JLabel lblCustomerId = new JLabel("ADDRESS");
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomerId.setBounds(26, 179, 121, 33);
		contentPane.add(lblCustomerId);
		
		textID = new JTextField();
		textID.setBounds(270, 73, 182, 33);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textsemID = new JTextField();
		textsemID.setColumns(10);
		textsemID.setBounds(270, 123, 182, 33);
		contentPane.add(textsemID);
		
		TextADD = new JTextField();
		TextADD.setColumns(10);
		TextADD.setBounds(270, 180, 182, 33);
		contentPane.add(TextADD);
		
		JButton btnNewButton = new JButton("UPDATE INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
	 				

		 			  connectDB();
		 			  System.out.println("Connected");

                       String sqlq = "update Employees SET eid = '"+ textID.getText()+"', phone_num ='"+ textsemID.getText()+"',address_name ='"+TextADD.getText()+"',TypeE ='"+textField.getText()+"' where eid ='"+textID.getText()+"'";

                       PreparedStatement  stmt = con.prepareStatement(sqlq);
                       
                      int num = stmt.executeUpdate();
                      if (num == 1)
     		 			JOptionPane.showMessageDialog(null,"Stored Successfully !");
                      else
       		 			JOptionPane.showMessageDialog(null,"Invalid Service ID !");


                   textID.setText(null);
                   textsemID.setText(null);
                   TextADD.setText(null);
                   textField.setText(null);

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
		btnNewButton.setBounds(26, 340, 192, 41);
		contentPane.add(btnNewButton);
		
		JButton btnShowTable = new JButton("SHOW EMPLOYEE TABLE");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeTable ser = new EmployeeTable();
				ser.setVisible(true);
				
			}
		});
		btnShowTable.setBackground(new Color(128, 0, 0));
		btnShowTable.setForeground(new Color(255, 255, 255));
		btnShowTable.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable.setBounds(260, 340, 192, 41);
		contentPane.add(btnShowTable);
		
		JLabel lblEmployeeType = new JLabel("EMPLOYEE TYPE");
		lblEmployeeType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmployeeType.setBounds(26, 222, 164, 36);
		contentPane.add(lblEmployeeType);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(270, 233, 182, 33);
		contentPane.add(textField);
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


