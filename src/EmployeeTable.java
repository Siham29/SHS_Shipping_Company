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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.EtchedBorder;

public class EmployeeTable extends JFrame {

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
	private JButton btnShippingInformation;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeTable frame = new EmployeeTable();
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
	public EmployeeTable() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 200, 1090, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 0, 0), new Color(128, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 74, 1032, 265);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Phone number", "address name", "Employee's Type"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(123);
		table.getColumnModel().getColumn(3).setPreferredWidth(414);
		
		JLabel lblex = new JLabel("X");
		lblex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		 		EmployeeTable.this.dispose();
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
		lblex.setBounds(1073, 0, 17, 28);
		contentPane.add(lblex);
		
		btnNewButton = new JButton("Show Table");
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
		btnNewButton.setBounds(683, 370, 153, 39);
		contentPane.add(btnNewButton);
		
		btnShippingInformation = new JButton("GO BACK");
		btnShippingInformation.setForeground(new Color(255, 255, 255));
		btnShippingInformation.setBackground(new Color(128, 0, 0));
		btnShippingInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EmployeeTable.this.dispose();
			}
		});
		btnShippingInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnShippingInformation.setBounds(294, 370, 165, 39);
		contentPane.add(btnShippingInformation);
		
		lblNewLabel = new JLabel("Employee Data Table");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lblNewLabel.setBounds(301, 10, 502, 54);
		contentPane.add(lblNewLabel);
	}

	private void ShowData() throws ClassNotFoundException, SQLException {
		  DefaultTableModel model = new DefaultTableModel();
		  
		  try{
		  ArrayList<employee>data = new ArrayList<>();

		  connectDB();
		  String sql = "select * from employees;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while ( rs.next() ) 
				data.add(new employee(Integer.parseInt(rs.getString(1)),(rs.getString(2)),
						rs.getString(3),rs.getString(4)));

			 
			  
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
	
	 public void Show_Users_In_JTable(ArrayList <employee>list)
	 {
	     
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	     Object[] row = new Object[6];
	     for(int i = 0; i < list.size(); i++)
	     {
	         row[0] = list.get(i).geteID();
	         row[1] = list.get(i).getPhone_num();
	         row[2] = list.get(i).getAddress_name();
	         row[3] = list.get(i).getEmployeeType();
	         
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
