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

public class searchVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textcid;
	private JTextField textsid;
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "0-x0-x0-x0-h";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchVehicle frame = new searchVehicle();
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
	public searchVehicle() {
		setTitle("Search of Vehicle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 540, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 516, 41);
		contentPane.add(panel);

		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(13, 5, 32, 32);
		panel.add(lblgirl);
		Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		lblgirl.setIcon(new ImageIcon(girl));

		JLabel lblNewLabel_1 = new JLabel("Enter Vehicle Number you want to search for it :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(55, 5, 413, 32);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBounds(13, 62, 503, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("VEHICLE NUMBER");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 26, 169, 36);
		panel_1.add(lblNewLabel);

		textid = new JTextField();
		textid.setBounds(221, 32, 116, 27);
		panel_1.add(textid);
		textid.setColumns(10);

		JButton btnNewButton = new JButton("FIND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectDB();

					String sql = "select vnumber,eid,vtype from Vehicle where vnumber=?";
					if (textid.getText() == null)
						JOptionPane.showMessageDialog(null, "No Data Entered !");
					PreparedStatement st = con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(textid.getText()));
					ResultSet rs = st.executeQuery();

					if (rs.next() == false) {
						JOptionPane.showMessageDialog(null, "Sorry This Vehicle Not Found");
						textcid.setText(null);
						textsid.setText(null);
						textid.setText(null);
					} else {

						textcid.setText(rs.getString("vnumber"));
						textsid.setText(rs.getString("eid"));
						textField.setText(rs.getString("vtype"));

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
		btnNewButton.setBounds(385, 26, 89, 36);
		panel_1.add(btnNewButton);

		JLabel lblVehicleNum = new JLabel("VEHICLE NUMBER");
		lblVehicleNum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblVehicleNum.setBounds(30, 194, 175, 41);
		contentPane.add(lblVehicleNum);

		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmployeeId.setBounds(30, 254, 197, 41);
		contentPane.add(lblEmployeeId);

		JLabel lblVehicleType = new JLabel("VEHICLE TYPE");
		lblVehicleType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblVehicleType.setBounds(30, 314, 197, 41);
		contentPane.add(lblVehicleType);
		
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
				searchVehicle.this.dispose();
			}
		});
		btnExit.setBackground(new Color(128, 0, 0));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnExit.setBounds(186, 412, 116, 41);
		contentPane.add(btnExit);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(276, 320, 156, 30);
		contentPane.add(textField);
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
