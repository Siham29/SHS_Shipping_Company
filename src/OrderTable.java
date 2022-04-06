import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class OrderTable extends JFrame {

	private JPanel contentPane;
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblback;
	private JButton btnNewButton_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderTable frame = new OrderTable();
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
	public OrderTable() {
		setBackground(new Color(128, 0, 0));
		setUndecorated(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 170, 1053, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 0, 0), new Color(128, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 76, 1033, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Service ID", "Order ID", "Vehicle Number", "Price of Order", "Shipping Time", "Shipping Date", "Shipping Information"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(414);
		
		JLabel lblex = new JLabel("X");
		lblex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		 		OrderTable.this.dispose();
			}
			@Override
			public void mouseExited(MouseEvent e) {
		 		lblex.setForeground(Color.LIGHT_GRAY);

			}
		});
		lblex.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
		 		lblex.setForeground(new Color(128, 0, 0));

			}
		});
		lblex.setForeground(Color.LIGHT_GRAY);
		lblex.setFont(new Font("Calibri", Font.BOLD, 18));
		lblex.setBounds(1017, 0, 17, 28);
		contentPane.add(lblex);
		
		btnNewButton = new JButton("LOAD ORDERS DATA");
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					ShowData();	
		
		}
		catch(Exception e2) {
			JOptionPane.showMessageDialog(null,e2);
		}
			}
		});
		btnNewButton.setBounds(419, 372, 246, 47);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel(" Orders Data Table ");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblNewLabel.setBounds(340, 11, 388, 54);
		contentPane.add(lblNewLabel);
		
		lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderTable.this.dispose();
				
			}
		});
		lblback.setBounds(2, 413, 32, 28);
		contentPane.add(lblback);
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		 lblback.setIcon(new ImageIcon(back));
		 
		 JLabel label = new JLabel("");
		 label.setBounds(2, 0, 66, 65);
		 contentPane.add(label);
		 Image shs = new ImageIcon(this.getClass().getResource("/com.png")).getImage();
		 label.setIcon(new ImageIcon(shs));
		 
		 btnNewButton_1 = new JButton("NUMBER OF ORDERS");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		try {
	 				

		 			  connectDB();
		 			  
		 			  System.out.println("Connected");

             String sql = "SELECT COUNT(oid) FROM orders o " ;
             		
             PreparedStatement  stmt = con.prepareStatement(sql);
 			ResultSet rs = stmt.executeQuery();

 			if(rs.next()) {
 				String sernum = rs.getString("COUNT(oid)");
 				textField.setText(sernum);
 				
 			}

		 		  con.close();
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			
		 					 		 
		 			}
		 	}
		 });
		 btnNewButton_1.setForeground(Color.WHITE);
		 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 btnNewButton_1.setBackground(new Color(128, 0, 0));
		 btnNewButton_1.setBounds(1, 341, 213, 28);
		 contentPane.add(btnNewButton_1);
		 
		 textField = new JTextField();
		 textField.setColumns(10);
		 textField.setBounds(213, 341, 53, 28);
		 contentPane.add(textField);


	}

	private void ShowData() throws ClassNotFoundException, SQLException {
		  
		  try{
		  ArrayList<Order>data = new ArrayList<>();

		  connectDB();
		  String sql = "select * from orders;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while ( rs.next() ) 
				data.add(new Order(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Double.parseDouble(rs.getString(4)),
						rs.getString(5),rs.getString(6),rs.getString(7)));

			 
			  
			Show_Users_In_JTable(data);
			rs.close();
			st.close();

	con.close();
		  
	  }catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	 }
	
	 public void Show_Users_In_JTable(ArrayList <Order>list)
	 {
	     
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	     Object[] row = new Object[8];
	     for(int i = 0; i < list.size(); i++)
	     {
	         row[0] = list.get(i).getSid();
	         row[1] = list.get(i).getOid();
	         row[2] = list.get(i).getVnumber();
	         row[3] = list.get(i).getPrice();
	         row[4] = list.get(i).getShip_time();
	         row[5] = list.get(i).getShip_date();
	         row[6] = list.get(i).getShip_info();
	         
	         model.addRow(row);
	     }
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
