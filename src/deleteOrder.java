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
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class deleteOrder extends JFrame {
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
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
					deleteOrder frame = new deleteOrder();
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
	public deleteOrder() {
		setTitle("Delete Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 422, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(3, 3, 400, 40);
		contentPane.add(panel_1);
		
		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(10, 3, 32, 32);
		panel_1.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));

		
		JLabel lblNewLabel_1 = new JLabel("Enter Order ID you want to delete :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(52, 11, 300, 20);
		panel_1.add(lblNewLabel_1);
		
		txtDELETE = new JTextField();
		txtDELETE.setBounds(74, 79, 267, 40);
		contentPane.add(txtDELETE);
		txtDELETE.setColumns(10);
		
		JButton btnDeleteOrder = new JButton("DELETE ORDER");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
 		 			
 		 			connectDB();
 		 			System.out.println("");
 		 			String sql = "delete from orders where oid ="+Integer.parseInt( txtDELETE.getText());
 		 			PreparedStatement st = con.prepareStatement(sql);
 		 			int num =st.executeUpdate();
 		 			if (num == 1)
 		 			JOptionPane.showMessageDialog(null,"Order Deleted Successfuly");
 		 			else
	 		 			JOptionPane.showMessageDialog(null,"Invlid Order ID");

		 			 txtDELETE.setText(null);
		 			 con.close();
 		 			
 		 		}
 		 		catch(Exception ee) {
 		 			JOptionPane.showMessageDialog(null,"NO data Entered !");
 		 			
 		 		}
 		 		
				
				
				
				
				
				
				
				
			}
		});
		btnDeleteOrder.setBackground(new Color(128, 0, 0));
		btnDeleteOrder.setForeground(new Color(255, 255, 255));
		btnDeleteOrder.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeleteOrder.setBounds(96, 161, 224, 32);
		contentPane.add(btnDeleteOrder);
		
		JButton btnDeleteOrder_1 = new JButton(" ORDERS TABLE");
		btnDeleteOrder_1.setBackground(new Color(128, 0, 0));
		btnDeleteOrder_1.setForeground(new Color(255, 255, 255));
		btnDeleteOrder_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDeleteOrder_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderTable order = new OrderTable();
				order.setVisible(true);
			}
		});
		btnDeleteOrder_1.setBounds(96, 230, 224, 32);
		contentPane.add(btnDeleteOrder_1);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteOrder.this.dispose();
				
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(169, 299, 89, 32);
		contentPane.add(btnNewButton);
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
