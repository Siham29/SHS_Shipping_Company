import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.Properties;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class deleteService extends JFrame {
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField txtDELETE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteService frame = new deleteService();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void clearFeilds() {
		   
		txtDELETE.setText(null);

	}
	/**
	 * Create the frame.
	 */
	public deleteService() {
		setTitle("Delete Service");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 403, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(255, 250, 240));
		 panel.setBounds(3, 3, 468, 41);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBackground(new Color(222, 184, 135));
		 panel_1.setBounds(0, 0, 381, 40);
		 panel.add(panel_1);
		 panel_1.setLayout(null);
		 
		 JLabel lblgirl = new JLabel("");
		 lblgirl.setBounds(10, 3, 32, 32);
		 panel_1.add(lblgirl);
		 
		 		 lblgirl.setIcon(new ImageIcon(girl));
		 		 
		 		 JLabel lblNewLabel_1 = new JLabel("Enter Service ID you want to delete");
		 		 lblNewLabel_1.setBounds(52, 11, 300, 20);
		 		 panel_1.add(lblNewLabel_1);
		 		 lblNewLabel_1.setForeground(new Color(0, 0, 139));
		 		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 		 
		 		 txtDELETE = new JTextField();
		 		 txtDELETE.setToolTipText("");
		 		 txtDELETE.setBounds(80, 78, 222, 40);
		 		 panel.add(txtDELETE);
		 		 txtDELETE.setColumns(10);
		 		 
		 		 JButton btnNewButton = new JButton("SERVICE TABLE ");
		 		 btnNewButton.addActionListener(new ActionListener() {
		 		 	public void actionPerformed(ActionEvent e) {
		 		 		
		 		 		serTable sertable = new serTable();
		 		 		sertable.setVisible(true);
		 		 		
		 		 	}
		 		 });
		 		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 		 btnNewButton.setForeground(new Color(255, 255, 255));
		 		 btnNewButton.setBackground(new Color(128, 0, 0));
		 		 btnNewButton.setBounds(207, 157, 164, 47);
		 		 panel.add(btnNewButton);
		 		 
		 		 JButton btnDelete = new JButton("DELETE SERVICE");
		 		 btnDelete.addActionListener(new ActionListener() {
		 		 	public void actionPerformed(ActionEvent e) {
		 		 		
		 		 		try {
		 		 			
		 		 			connectDB();
		 		 			System.out.println("");
		 		 			String sql = "delete from service where sid ="+Integer.parseInt( txtDELETE.getText());
		 		 			PreparedStatement st = con.prepareStatement(sql);
		 		 			int num =st.executeUpdate();
		 		 			if (num == 1)
		 		 			JOptionPane.showMessageDialog(null,"Service Deleted Successfuly");
		 		 			else
			 		 			JOptionPane.showMessageDialog(null,"Invlid Service ID");

				 			 clearFeilds();
				 			 con.close();
		 		 			
		 		 		}
		 		 		catch(Exception ee) {
		 		 			JOptionPane.showMessageDialog(null,"NO data Entered !");
		 		 			
		 		 		}
		 		 		
		 		 		
		 		 		
		 		 		
		 		 		
		 		 	}
		 		 });
		 		 btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 		 btnDelete.setForeground(new Color(255, 255, 255));
		 		 btnDelete.setBackground(new Color(128, 0, 0));
		 		 btnDelete.setBounds(10, 157, 164, 47);
		 		 panel.add(btnDelete);
		 		 
		 		 JButton btnNewButton_1 = new JButton("EXIT");
		 		 btnNewButton_1.addActionListener(new ActionListener() {
		 		 	public void actionPerformed(ActionEvent e) {
		 		 		
		 		 		deleteService.this.dispose();
		 		 	}
		 		 });
		 		 btnNewButton_1.setForeground(new Color(255, 255, 255));
		 		 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 		 btnNewButton_1.setBackground(new Color(128, 0, 0));
		 		 btnNewButton_1.setBounds(143, 235, 89, 40);
		 		 panel.add(btnNewButton_1);
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
