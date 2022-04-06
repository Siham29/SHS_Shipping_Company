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

public class serTable extends JFrame {

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
	private JLabel lblnext;
	private JButton btnNewButton_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serTable frame = new serTable();
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
	public serTable() {
		setTitle("Service Table");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 579, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 0, 0), new Color(128, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 77, 559, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Service ID", "Service owner  ID ", "Services Officer ID"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		
		btnNewButton = new JButton("LOAD SERVICE DATA");
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
		btnNewButton.setBounds(350, 341, 211, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Service Data Table");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(147, 12, 296, 54);
		contentPane.add(lblNewLabel);
		
		lblback = new JLabel("");
		lblback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				serTable.this.dispose();
			}
		});
		lblback.setBounds(1, 402, 32, 28);
		contentPane.add(lblback);
		 Image back = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		 lblback.setIcon(new ImageIcon(back));
		 
		 lblnext = new JLabel("");
		 lblnext.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		insertSer in = new insertSer();
		 		in.setVisible(true);
		 		serTable.this.dispose();
		 	}
		 });
		 lblnext.setBounds(530, 402, 32, 28);
		 contentPane.add(lblnext);
		 Image next = new ImageIcon(this.getClass().getResource("/Next.png")).getImage();
		 lblnext.setIcon(new ImageIcon(next));
		 
		 JLabel label = new JLabel("");
		 label.setBounds(2, 0, 65, 65);
		 contentPane.add(label);
		 Image shs = new ImageIcon(this.getClass().getResource("/com.png")).getImage();
		 label.setIcon(new ImageIcon(shs));
		 
		 btnNewButton_1 = new JButton("NUMBER OF SERVICE ");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
	 				

		 			  connectDB();
		 			  
		 			  System.out.println("Connected");

             String sql = "SELECT COUNT(sid) FROM service S " ;
             		
             PreparedStatement  stmt = con.prepareStatement(sql);
 			ResultSet rs = stmt.executeQuery();

 			if(rs.next()) {
 				String sernum = rs.getString("COUNT(sid)");
 				textField.setText(sernum);
 				
 			}

		 		  con.close();
		 			                     
		 			}
		 			catch(Exception ee) {
		 					 		
		 					 			
		 					 		 
		 			}
		 	}
		 });
		 btnNewButton_1.setForeground(Color.WHITE);
		 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 btnNewButton_1.setBackground(new Color(128, 0, 0));
		 btnNewButton_1.setBounds(2, 341, 175, 29);
		 contentPane.add(btnNewButton_1);
		 
		 textField = new JTextField();
		 textField.setBounds(177, 341, 45, 29);
		 contentPane.add(textField);
		 textField.setColumns(10);

	}

	private void ShowData() throws ClassNotFoundException, SQLException {
		  DefaultTableModel model = new DefaultTableModel();
		  
		  try{
		  ArrayList<Service>data = new ArrayList<>();

		  connectDB();
		  String sql = "select * from service;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while ( rs.next() ) 
				data.add(new Service(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3))));
			 
			  
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
	
	 public void Show_Users_In_JTable(ArrayList <Service>list)
	 {
	     
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	     Object[] row = new Object[6];
	     for(int i = 0; i < list.size(); i++)
	     {
	         row[0] = list.get(i).getSid();
	         row [1]= list.get(i).getCid();
	         row [2]= list.get(i).getEid();

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
