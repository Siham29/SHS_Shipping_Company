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
import javax.swing.JTextField;
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
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;

public class searchOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchOrder frame = new searchOrder();
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
	public searchOrder() {
		setTitle("Search of Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 780, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(3, 3, 758, 41);
		contentPane.add(panel);
		
		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(8, 5, 32, 32);
		panel.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));

		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Order ID you want to search for it :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 11, 346, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(74, 62, 605, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ORDER  ID");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(52, 25, 129, 36);
		panel_1.add(lblNewLabel);
		
		textid = new JTextField();
		textid.setBounds(217, 32, 176, 27);
		panel_1.add(textid);
		textid.setColumns(10);
		
		JButton btnNewButton = new JButton("FIND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {     
					 connectDB();
					 ShowData();
					 
		            
		        } catch (SQLException ex) {

		        } catch (ClassNotFoundException e1) {
			   		 JOptionPane.showMessageDialog(null, "No Data Entered !");

					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(457, 26, 89, 36);
		panel_1.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchOrder.this.dispose();
			}
		});
		btnExit.setBackground(new Color(128, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExit.setBounds(325, 337, 116, 41);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 168, 758, 137);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(128, 0, 0));
		table.setFont(new Font("Times New Roman", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Service ID", "Vehicle Number", "Price", "Shipping Time", "Shipping Date", "Shipping Information"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(220);
	}
	private void ShowData() throws ClassNotFoundException, SQLException {
		  
		  try{
		  ArrayList<Order>data = new ArrayList<>();

		  connectDB();
		  String sql = "select sid,oid,vnumber,price,shipping_time,shipping_date,shipping_info from orders where oid=?";
		  
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(textid.getText()));
			ResultSet rs = st.executeQuery();
		
			
				
          	while ( rs.next() ) 
          		       

          		data.add(new Order(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Double.parseDouble(rs.getString(4)),
            				rs.getString(5),rs.getString(6),rs.getString(7)));

          	Show_Users_In_JTable(data); 
          	
          	 
          		if(textid.getText() ==null)
   		   		 JOptionPane.showMessageDialog(null, "No Data Entered !");
          
                textid.setText(null);
          
			
		  
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
