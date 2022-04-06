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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
public class insertOrder extends JFrame {
	
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textoid;
	private JTextField textPrice;
	private JTextField textSid;
	private JTextField textV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertOrder frame = new insertOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
   private void clearFeilds() {
	   
	textoid.setText(null);
	textPrice.setText(null);
	textV.setText(null);
	textSid.setText(null);
}
	/**
	 * Create the frame.
	 */
	public insertOrder() {
		setForeground(new Color(128, 0, 0));
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Add New Order");
		setVisible(false);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 170, 487, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ORDER ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 164, 99, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPriceOfOrder = new JLabel("PRICE OF ORDER");
		lblPriceOfOrder.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPriceOfOrder.setBounds(64, 233, 164, 36);
		contentPane.add(lblPriceOfOrder);
		
		textoid = new JTextField();
		textoid.setToolTipText("");
		textoid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textoid.setBounds(277, 168, 148, 30);
		contentPane.add(textoid);
		textoid.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textPrice.setColumns(10);
		textPrice.setBounds(277, 233, 148, 30);
		contentPane.add(textPrice);
		
		JLabel lblid = new JLabel("");
		lblid.setBounds(14, 170, 40, 27);
		contentPane.add(lblid);
		 Image id = new ImageIcon(this.getClass().getResource("/box.png")).getImage();
		 lblid.setIcon(new ImageIcon(id));
		
		JLabel lblprice = new JLabel("");
		lblprice.setBounds(14, 236, 40, 27);
		contentPane.add(lblprice);
		 Image price = new ImageIcon(this.getClass().getResource("/price.png")).getImage();
		 lblprice.setIcon(new ImageIcon(price));
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 
		 JButton btnInsert = new JButton("ADD NEW ORDER");
		 btnInsert.setBackground(new Color(128, 0, 0));
		 btnInsert.setForeground(new Color(255, 255, 255));
		 btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 btnInsert.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		DateFormat df = new SimpleDateFormat(" HH:mm:ss");
			       Date dateobj = new Date();
			       String time=df.format(dateobj);
			       
			       DateFormat dff = new SimpleDateFormat(" dd/MM/yy");
			       Date dateobbj = new Date();
			       String date=dff.format(dateobbj);
			       
			      insertCustomer customer = new insertCustomer();
		           String infoname = customer.name2;
		           String infoadd = customer.add2;
		           String infomail = customer. mail2;
		        String sh_info = "Customer Name: " +infoname +" //Address: " + infoadd + " //Email: " + infomail;
		        
		        
		         // System.out.println (date+"//" + sh_info);
		 		try {
		 			
		 			  connectDB();

		 			System.out.println("CONNECTED !"); 
		 			 
		 			 
		 			 String sql1 = "insert into orders(sid,oid,price,shipping_time,shipping_date,shipping_info,vnumber) values (?,?,?,?,?,?,?)";

		 			PreparedStatement st = con.prepareStatement(sql1);

		 			 st.setInt(1,Integer.parseInt(textSid.getText()));

		 			 st.setInt(2,Integer.parseInt(textoid.getText()));
		 			 
                     st.setDouble(3,Double.parseDouble(textPrice.getText()));

		 		 st.setString(4, time);

		 			st.setString(5, date);

		 			 st.setString(6, sh_info);

		 			st.setInt(7,Integer.parseInt(textV.getText()));
                     int num = st.executeUpdate();

   		 			if (num == 1)
   		 				JOptionPane.showMessageDialog(null,"Stored Successfully !");


		 			 clearFeilds();
		 			 con.close();

		 		}
		 		 catch(Exception e1) {
		 			JOptionPane.showMessageDialog(null,"Invalid data !");
		 		 }
		 		
		 		
		 		
		 	}
		 });
		 btnInsert.setBounds(148, 366, 174, 41);
		 contentPane.add(btnInsert);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(222, 184, 135));
		 panel.setBounds(3, 0, 465, 41);
		 contentPane.add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblgirl = new JLabel("");
		 lblgirl.setBounds(8, 5, 32, 32);
		 panel.add(lblgirl);
		 lblgirl.setIcon(new ImageIcon(girl));
		 
		 JLabel lblNewLabel_1 = new JLabel("Insert Order Information Below :");
		 lblNewLabel_1.setBounds(40, 11, 274, 20);
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(0, 0, 139));
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 
		 JLabel lblNewLabel_2 = new JLabel("SERVICE ID");
		 lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblNewLabel_2.setBounds(64, 93, 111, 36);
		 contentPane.add(lblNewLabel_2);
		 
		 textSid = new JTextField();
		 textSid.setToolTipText("");
		 textSid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textSid.setColumns(10);
		 textSid.setBounds(277, 93, 148, 30);
		 contentPane.add(textSid);
		 
		 JLabel lblid_1 = new JLabel("");
		 lblid_1.setBounds(14, 100, 40, 27);
		 contentPane.add(lblid_1);
		 
		 Image iid = new ImageIcon(this.getClass().getResource("/newID.png")).getImage();
		 lblid_1.setIcon(new ImageIcon(iid));
		 
		 textV = new JTextField();
		 textV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textV.setColumns(10);
		 textV.setBounds(277, 300, 148, 30);
		 contentPane.add(textV);
		 
		 JLabel lblVehicleNumber = new JLabel("VEHICLE NUMBER");
		 lblVehicleNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 lblVehicleNumber.setBounds(64, 294, 182, 36);
		 contentPane.add(lblVehicleNumber);
		 
		 JLabel lblprice_1 = new JLabel("");
		 lblprice_1.setBounds(14, 300, 40, 27);
		 contentPane.add(lblprice_1);
		 
		 Image carid = new ImageIcon(this.getClass().getResource("/van.png")).getImage();
		 lblprice_1.setIcon(new ImageIcon(carid));
		 
		 JLabel lblback = new JLabel("");
		 lblback.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		insertOrder.this.dispose();
		 	}
		 });
		 lblback.setBounds(1, 406, 32, 28);
		 contentPane.add(lblback);
		 
		 Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		 lblback.setIcon(new ImageIcon(back));
		 
		 JButton btnNewButton = new JButton("VEHICLES  DATA");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		veTable v = new veTable();
		 		v.setVisible(true);
		 	}
		 });
		 btnNewButton.setBackground(new Color(128, 0, 0));
		 btnNewButton.setForeground(Color.WHITE);
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 btnNewButton.setBounds(3, 41, 156, 23);
		 contentPane.add(btnNewButton);
		 
		 JButton btnCustomersData = new JButton("ORDERS  DATA");
		 btnCustomersData.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		OrderTable c= new OrderTable();
		 		c.setVisible(true);
		 	}
		 });
		 btnCustomersData.setBackground(new Color(128, 0, 0));
		 btnCustomersData.setForeground(Color.WHITE);
		 btnCustomersData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 btnCustomersData.setBounds(157, 41, 156, 23);
		 contentPane.add(btnCustomersData);
		 
		 JButton btnServicesData = new JButton("SERVICES  DATA");
		 btnServicesData.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		serTable s = new serTable();
		 		s.setVisible(true);
		 	}
		 });
		 btnServicesData.setBackground(new Color(128, 0, 0));
		 btnServicesData.setForeground(new Color(255, 255, 255));
		 btnServicesData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		 btnServicesData.setBounds(312, 41, 156, 23);
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
}
