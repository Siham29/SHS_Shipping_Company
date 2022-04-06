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

public class custmTable extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custmTable frame = new custmTable();
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
	public custmTable() {
		setTitle("Customer Table");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 170, 893, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 0, 0), new Color(128, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 76, 808, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Name", "Phone Number", "Address", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(74);
		table.getColumnModel().getColumn(1).setPreferredWidth(158);
		table.getColumnModel().getColumn(2).setPreferredWidth(141);
		table.getColumnModel().getColumn(3).setPreferredWidth(195);
		table.getColumnModel().getColumn(4).setPreferredWidth(195);
		
		btnNewButton = new JButton("LOAD CUSTOMERS DATA");
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
		btnNewButton.setBounds(330, 373, 241, 39);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel(" Customers Data Table ");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblNewLabel.setBounds(206, 11, 455, 54);
		contentPane.add(lblNewLabel);
		
		lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				custmTable.this.dispose();
			}
		});
		lblback.setBounds(1, 413, 32, 28);
		contentPane.add(lblback);
		Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		 lblback.setIcon(new ImageIcon(back));
		
	}

	private void ShowData() throws ClassNotFoundException, SQLException {
		  DefaultTableModel model = new DefaultTableModel();
		  
		  try{
		  ArrayList<Customer>data = new ArrayList<>();

		  connectDB();

		  String sql = "select Cid,c_Name,c_Phone_num ,C_Address,c_Email from customers;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while ( rs.next() ) 
				data.add(new Customer(Integer.parseInt(rs.getString(1)),rs.getString(2),Integer.parseInt(rs.getString(3)),
						rs.getString(4),rs.getString(5)));

			 
			  
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
	
	 public void Show_Users_In_JTable(ArrayList <Customer>list)
	 {
	     
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	     Object[] row = new Object[6];
	     for(int i = 0; i < list.size(); i++)
	     {
	         row[0] = list.get(i).getCid();
	         row[1] = list.get(i).getCname();
	         row[2] = list.get(i).getCphone_num();
	         row[3] = list.get(i).getCaddress();
	         row[4] = list.get(i).getCemail();

	         
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
