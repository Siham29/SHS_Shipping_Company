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

public class updateVehicle extends JFrame {
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "12345";
	private String URL = "localhost";
	private String dbName = "shs_shipping_company";
	private String port = "3306";
	private Connection con;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textserID;
	private JTextField textcsID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateVehicle frame = new updateVehicle();
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
	public updateVehicle() {
		setTitle("Update Vehicle");
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 180, 492, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(3, 0, 470, 41);
		contentPane.add(panel);

		JLabel lblgirl = new JLabel("");
		lblgirl.setBounds(8, 5, 32, 32);
		panel.add(lblgirl);
		Image girl = new ImageIcon(this.getClass().getResource("/girl.png")).getImage();
		lblgirl.setIcon(new ImageIcon(girl));

		JLabel lblNewLabel_1 = new JLabel("Entered New Vehicle Information Below :");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 11, 356, 20);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("VEHICLE NUMBER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(26, 72, 154, 33);
		contentPane.add(lblNewLabel);

		JLabel lblCustomerId = new JLabel("EMPLOYEE ID");
		lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCustomerId.setBounds(26, 122, 121, 33);
		contentPane.add(lblCustomerId);

		JLabel lblVehicleType = new JLabel("VEHICLE TYPE");
		lblVehicleType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblVehicleType.setBounds(26, 179, 154, 33);
		contentPane.add(lblVehicleType);

		textID = new JTextField();
		textID.setBounds(270, 73, 182, 33);
		contentPane.add(textID);
		textID.setColumns(10);

		textserID = new JTextField();
		textserID.setColumns(10);
		textserID.setBounds(270, 123, 182, 33);
		contentPane.add(textserID);

		textcsID = new JTextField();
		textcsID.setColumns(10);
		textcsID.setBounds(270, 180, 182, 33);
		contentPane.add(textcsID);

		JButton btnNewButton = new JButton("UPDATE INFORMATION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					connectDB();
					System.out.println("Connected");

					String sqlq = "update vehicle SET eid = '" + textcsID.getText() +"'  where v_num ='" + textID.getText() + "'";

					PreparedStatement stmt = con.prepareStatement(sqlq);

					int num = stmt.executeUpdate();
					if (num == 1)
						JOptionPane.showMessageDialog(null, "Stored Successfully !");
					else
						JOptionPane.showMessageDialog(null, "Invalid Service ID !");

					textID.setText(null);
					textserID.setText(null);
					textcsID.setText(null);

					con.close();

				} catch (Exception ee) {

					JOptionPane.showMessageDialog(null, "Invalid Input !");

				}

			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(29, 250, 192, 41);
		contentPane.add(btnNewButton);

		JButton btnShowTable = new JButton("SHOW VEHICLE TABLE");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				veTable ve = new veTable();
				ve.setVisible(true);

			}
		});
		btnShowTable.setBackground(new Color(128, 0, 0));
		btnShowTable.setForeground(new Color(255, 255, 255));
		btnShowTable.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnShowTable.setBounds(258, 250, 182, 41);
		contentPane.add(btnShowTable);
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
