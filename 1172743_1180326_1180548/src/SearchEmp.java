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

public class SearchEmp extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textcid;
	private JTextField textsid;
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmp frame = new SearchEmp();
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
	public SearchEmp() {
		setTitle("Search of Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 476, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(3, 3, 454, 41);
		contentPane.add(panel);
		
		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(8, 5, 32, 32);
		panel.add(lblgirl);
		 Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		 lblgirl.setIcon(new ImageIcon(girl));

		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Employee ID you want to search for it :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 11, 379, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(13, 62, 435, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE ID");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 26, 121, 36);
		panel_1.add(lblNewLabel);
		
		textid = new JTextField();
		textid.setBounds(159, 29, 116, 27);
		panel_1.add(textid);
		textid.setColumns(10);
		
		JButton btnNewButton = new JButton("FIND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {     
					 connectDB();
					 
					  String sql = "select * from Employees where eid=?";
					  if(textid.getText() ==null)
					   		 JOptionPane.showMessageDialog(null, "No Data Entered !");
						PreparedStatement st = con.prepareStatement(sql);
						st.setInt(1, Integer.parseInt(textid.getText()));
						ResultSet rs = st.executeQuery();
						
						

			
		 if(rs.next()==false)
		 {
		 JOptionPane.showMessageDialog(null, "Sorry This Employee Not Found");
		                                textcid.setText(null);
		                                textsid.setText(null);
		                                textid.setText(null);
		         }
		                        else
		                        {
		 
		 textcid.setText(rs.getString("eid"));
		                        textsid.setText(rs.getString("phone_num"));
		                        textField.setText(rs.getString("address_name"));
		                        textField_1.setText(rs.getString("TypeE"));
		                        
		 }
		            
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
		btnNewButton.setBounds(321, 24, 89, 36);
		panel_1.add(btnNewButton);
		
		textcid = new JTextField();
		textcid.setBounds(276, 200, 156, 30);
		contentPane.add(textcid);
		textcid.setColumns(10);
		
		textsid = new JTextField();
		textsid.setColumns(10);
		textsid.setBounds(276, 260, 156, 30);
		contentPane.add(textsid);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmp.this.dispose();
			}
		});
		btnExit.setBackground(new Color(128, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExit.setBounds(170, 462, 116, 41);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("EMPLOYEE ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(32, 197, 121, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblServantId = new JLabel("PHONE NUMBER");
		lblServantId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblServantId.setBounds(32, 260, 201, 33);
		contentPane.add(lblServantId);
		
		JLabel lblCustomerId = new JLabel("ADDRESS");
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomerId.setBounds(32, 318, 121, 33);
		contentPane.add(lblCustomerId);
		
		JLabel lblEmployeeType = new JLabel("EMPLOYEE TYPE");
		lblEmployeeType.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmployeeType.setBounds(33, 371, 164, 36);
		contentPane.add(lblEmployeeType);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(276, 318, 156, 30);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(276, 377, 156, 30);
		contentPane.add(textField_1);
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
