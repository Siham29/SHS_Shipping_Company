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
import javax.swing.JTextPane;

public class updateCustomer extends JFrame {
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textcsID;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateCustomer frame = new updateCustomer();
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
	public updateCustomer() {
		setTitle("Update Customer");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 180, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(3, 0, 577, 47);
		contentPane.add(panel);

		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(8, 5, 32, 32);
		panel.add(lblgirl);
		Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		lblgirl.setIcon(new ImageIcon(girl));

		JLabel lblNewLabel_1 = new JLabel("Enter New Customer Information Below :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 11, 356, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("CUSTOMER PHONE NUMBER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 128, 232, 33);
		contentPane.add(lblNewLabel);

		JLabel lblCustomerna = new JLabel("CUSTOMER NAME");
		lblCustomerna.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomerna.setBounds(28, 185, 165, 33);
		contentPane.add(lblCustomerna);

		JLabel lblCustomeradd = new JLabel("CUSTOMER ADDRESS");
		lblCustomeradd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomeradd.setBounds(28, 239, 192, 33);
		contentPane.add(lblCustomeradd);

		JLabel lblCustomeremail = new JLabel("CUSTOMER EMAIL");
		lblCustomeremail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomeremail.setBounds(28, 301, 174, 33);
		contentPane.add(lblCustomeremail);

		textID = new JTextField();
		textID.setBounds(367, 129, 182, 33);
		contentPane.add(textID);
		textID.setColumns(10);

		textcsID = new JTextField();
		textcsID.setColumns(10);
		textcsID.setBounds(367, 186, 182, 33);
		contentPane.add(textcsID);

		JButton btnNewButton = new JButton("UPDATE INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					connectDB();
					System.out.println("Connected");

					String sqlq = "update Customers SET Cid = '"+ textField_3.getText()+"', c_Phone_num ='"+ textID.getText()+"',c_Name ='"+textcsID.getText()+"',C_Address ='"+textField_1.getText()+"',c_Email='"+ textField.getText()+"' where Cid ='"+textField_3.getText()+"'";


					PreparedStatement stmt = con.prepareStatement(sqlq);

					int num = stmt.executeUpdate();
					if (num == 1)
						JOptionPane.showMessageDialog(null, "Stored Successfully !");
					else
						JOptionPane.showMessageDialog(null, "Invalid Customer ID !");

					textID.setText(null);
					
					textcsID.setText(null);
					textField.setText(null);
					textField_3.setText(null);
					textField_1.setText(null);

					con.close();

				} catch (Exception ee) {

					JOptionPane.showMessageDialog(null, "Invalid Input !");

				}

			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(28, 386, 192, 41);
		contentPane.add(btnNewButton);

		JButton btnShowTable = new JButton("SHOW CUSTOMER TABLE");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				custmTable cust = new custmTable();
				cust.setVisible(true);

			}
		});
		btnShowTable.setBackground(new Color(128, 0, 0));
		btnShowTable.setForeground(new Color(255, 255, 255));
		btnShowTable.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable.setBounds(349, 386, 200, 41);
		contentPane.add(btnShowTable);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(367, 302, 182, 33);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(367, 240, 182, 33);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMER ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(28, 74, 232, 33);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(367, 75, 182, 33);
		contentPane.add(textField_3);
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
