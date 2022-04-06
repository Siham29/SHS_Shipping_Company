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
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import javax.swing.JScrollBar;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class extraSer extends JFrame {
	
	private JPanel contentPane;
	private String dbURL; 
	private String dbUsername= "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JTextField textsid;
	private JTable table;
	private JTextField textcount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					extraSer frame = new extraSer();
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
	public extraSer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(62, 3, 461, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number of Orders in Specific Service");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 385, 60);
		panel_1.add(lblNewLabel);
		
		textsid = new JTextField();
		textsid.setBounds(30, 122, 190, 30);
		contentPane.add(textsid);
		textsid.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 82, 190, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Service ID ");
		lblNewLabel_1.setBounds(10, 0, 175, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 74, 177, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ORDER ID"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
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
		btnNewButton.setBounds(312, 309, 177, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SHOW NUMBER OF ORDERS");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {     
					 connectDB();
					
					  String sql = "select count(o.oid) from orders o ,service s  where s.sid= o.sid and s.sid =?";
					  if(textsid.getText() ==null)
					   		 JOptionPane.showMessageDialog(null, "No Data Entered !");
						PreparedStatement st = con.prepareStatement(sql);
						st.setInt(1, Integer.parseInt(textsid.getText()));
						ResultSet rs = st.executeQuery();
						
						

			
		 if(rs.next()==false)
		 {
		 JOptionPane.showMessageDialog(null, "Sorry This Service Not Found");
		                               
		         }
		                        else
		                        {
		                        	textcount.setText(rs.getString("count(o.oid)"));
		
		                        
		                        
		 }
		            
		        } catch (SQLException ex) {

		        } catch (ClassNotFoundException e1) {
			   		 JOptionPane.showMessageDialog(null, "No Data Entered !");

					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(30, 192, 203, 41);
		contentPane.add(btnNewButton_1);
		
		textcount = new JTextField();
		textcount.setBounds(232, 192, 45, 41);
		contentPane.add(textcount);
		textcount.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(3, 3, 66, 60);
		contentPane.add(label);
		 Image shs = new ImageIcon(this.getClass().getResource("/com.png")).getImage();
		 label.setIcon(new ImageIcon(shs));
		 
		 JButton btnNewButton_2 = new JButton("New button");
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		extraSer.this.dispose();
		 		
		 	}
		 });
		 btnNewButton_2.setBounds(30, 311, 104, 27);
		 contentPane.add(btnNewButton_2);
	}
	private void ShowData() throws ClassNotFoundException, SQLException {
		  
		  try{
		  ArrayList<Order>data = new ArrayList<>();

		  connectDB();
		  String sql = "select (o.oid) from orders o ,service s  where s.sid= o.sid and s.sid =?";
		  ; 
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(textsid.getText()));
			ResultSet rs = st.executeQuery();
		
			
				
        	while ( rs.next() ) 
        		       

        		data.add(new Order(Integer.parseInt(rs.getString(1))));

        	Show_Users_In_JTable(data); 
        	
        	 
        		if(textsid.getText() ==null)
 		   		 JOptionPane.showMessageDialog(null, "No Data Entered !");
        
              //textsid.setText(null);
        
			
		  
	  }catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	 }
	
	 public void Show_Users_In_JTable(ArrayList <Order>list)
	 {
	     
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	     Object[] row = new Object[3];
	     for(int i = 0; i < list.size(); i++)
	     {
	        
	         
	         row[0] = list.get(i).getOid();
	        
	         
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
