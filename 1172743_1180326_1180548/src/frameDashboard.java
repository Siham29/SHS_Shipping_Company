import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.lang.module.FindException;
import java.lang.module.InvalidModuleDescriptorException;
public class frameDashboard extends JFrame {

	private JPanel contentPane;
	private Home panelHome;/////////////////////////////////////////////
	private Orders panelOrder;
	private Employees panelEmp;
	private Customers panelCustomer;
	private Services panelServices;
	private Vehicles panelVehicles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameDashboard frame = new frameDashboard();
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


	public frameDashboard() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 110, 843, 501);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 0, 0), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelEmp  = new Employees();
		panelEmp.setLocation(0, 3);
		panelEmp.setSize(630, 501);
		panelCustomer = new Customers();///////////////////////////
		panelCustomer.setLocation(0, 3);
		panelCustomer.setSize(630, 501);
		panelServices = new Services();
		panelServices.setLocation(0, 3);
		panelServices.setSize(630, 501);
		panelVehicles = new Vehicles();
		panelVehicles.setLocation(0, 3);
		panelVehicles.setSize(630, 501);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 228, 508);
		panel.setBorder(new LineBorder(new Color(128, 0, 0)));
		panel.setBackground(new Color(128, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelicon = new JLabel("");
		labelicon.setHorizontalAlignment(SwingConstants.CENTER);
		labelicon.setBounds(38, 25, 146, 95);
		panel.add(labelicon);
		 Image img = new ImageIcon(this.getClass().getResource("/tru.png")).getImage();
		 labelicon.setIcon(new ImageIcon(img));
		 
		 JPanel paneHome = new JPanel();
		 paneHome.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneHome.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
				 paneHome.setBackground(new Color(222, 184, 135));
			 		menuClicked(panelHome);

		 	}
		 });
		 paneHome.setBackground(new Color(128, 0, 0));
		 paneHome.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseExited(MouseEvent e) {
				 paneHome.setBackground(new Color(128, 0, 0));

		 	}
		 	@Override
		 	public void mousePressed(MouseEvent e) {
				 paneHome.setBackground(new Color(255, 222, 173));

		 	}
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		menuClicked(panelHome);
                
		 	}
		 });
		 paneHome.setBounds(0, 148, 228, 40);
		 panel.add(paneHome);
		 paneHome.setLayout(null);
		 
		 JLabel lblHome = new JLabel("HOME");
		 lblHome.setForeground(new Color(255, 255, 255));
		 lblHome.setFont(new Font("Calibri", Font.BOLD, 20));
		 lblHome.setBounds(67, 12, 61, 28);
		 paneHome.add(lblHome);
		 
		 JLabel lblhomeicon = new JLabel("");
		 lblhomeicon.setBounds(10, 0, 37, 40);
		 paneHome.add(lblhomeicon);
		 Image im = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		 lblhomeicon.setIcon(new ImageIcon(im));

		 JPanel paneCustomers = new JPanel();
		 paneCustomers.setForeground(new Color(255, 255, 255));
		 paneCustomers.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneCustomers.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		paneCustomers.setBackground(new Color(128, 0, 0));

		 	}
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		paneCustomers.setBackground(new Color(255, 222, 173));

		 	}
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		menuClicked(panelCustomer);
                
		 	}
		 });
		 paneCustomers.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
		 		paneCustomers.setBackground(new Color(222, 184, 135));
		 		menuClicked(panelCustomer);

		 	}
		 });
		 paneCustomers.setBackground(new Color(128, 0, 0));
		 paneCustomers.setBounds(0, 188, 228, 40);
		 panel.add(paneCustomers);
		 paneCustomers.setLayout(null);
		 
		 JLabel lblCustomer = new JLabel("CUSTOMERS");
		 lblCustomer.setBounds(63, 11, 112, 24);
		 lblCustomer.setForeground(new Color(255, 255, 255));
		 lblCustomer.setFont(new Font("Calibri", Font.BOLD, 20));
		 paneCustomers.add(lblCustomer);
		 
		 JLabel lblcus = new JLabel("");
		 lblcus.setBounds(10, 0, 37, 40);
		 paneCustomers.add(lblcus);
		 Image user = new ImageIcon(this.getClass().getResource("/User.png")).getImage();
		 lblcus.setIcon(new ImageIcon(user));
		 
		 JLabel lblnxt1_1 = new JLabel("");
		 lblnxt1_1.setBounds(196, 0, 32, 40);
		 paneCustomers.add(lblnxt1_1);

		 JPanel paneOrders = new JPanel();
		 paneOrders.setForeground(new Color(255, 255, 255));
		 paneOrders.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneOrders.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneOrders.setBackground(new Color(128, 0, 0));
			 		}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneOrders.setBackground(new Color(255, 222, 173));

			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		menuClicked(panelOrder);
	                
			 	}
			 });
		 paneOrders.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		paneOrders.setBackground(new Color(222, 184, 135));
			 		menuClicked(panelOrder);

			 	}
			 	
			 });
		 paneOrders.setBackground(new Color(128, 0, 0));
		 paneOrders.setBounds(0, 228, 228, 40);
		 panel.add(paneOrders);
		 paneOrders.setLayout(null);
		 
		 JLabel lblOrder = new JLabel("ORDERS");
		 lblOrder.setBounds(63, 11, 102, 24);
		 lblOrder.setForeground(new Color(255, 255, 255));
		 lblOrder.setFont(new Font("Calibri", Font.BOLD, 20));
		 paneOrders.add(lblOrder);
		 
		 JLabel lblorder = new JLabel("");
		 lblorder.setBounds(10, 0, 32, 40);
		 paneOrders.add(lblorder);
		 Image od = new ImageIcon(this.getClass().getResource("/box.png")).getImage();
		 lblorder.setIcon(new ImageIcon(od));
		 
		 JLabel lblnxt1 = new JLabel("");
		 lblnxt1.setBounds(196, 0, 32, 40);
		 paneOrders.add(lblnxt1);
		 Image nxt = new ImageIcon(this.getClass().getResource("/nxt.png")).getImage();
		 lblnxt1.setIcon(new ImageIcon(nxt));
		 lblnxt1_1.setIcon(new ImageIcon(nxt));
		


		 JPanel paneEmp = new JPanel();
		 paneEmp.setForeground(new Color(255, 255, 255));
		 paneEmp.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneEmp.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneEmp.setBackground(new Color(128, 0, 0));

			 	}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneEmp.setBackground(new Color(255, 222, 173));

			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		menuClicked(panelEmp);
	                
			 	}
			 });
		 paneEmp.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		paneEmp.setBackground(new Color(222, 184, 135));
			 		menuClicked(panelEmp);

			 	}
			 });
		 paneEmp.setBackground(new Color(128, 0, 0));
		 paneEmp.setBounds(0, 268, 228, 40);
		 panel.add(paneEmp);
		 paneEmp.setLayout(null);
		 
		 JLabel lblEmp = new JLabel("EMPLOYEES");
		 lblEmp.setBounds(64, 11, 112, 24);
		 lblEmp.setForeground(new Color(255, 255, 255));
		 lblEmp.setFont(new Font("Calibri", Font.BOLD, 20));
		 paneEmp.add(lblEmp);
		 
		 JLabel lblem = new JLabel("");
		 lblem.setBounds(10, 0, 38, 40);
		 paneEmp.add(lblem);
		 Image em = new ImageIcon(this.getClass().getResource("/Preppy.png")).getImage();
		 lblem.setIcon(new ImageIcon(em));
		 
		 JLabel lblnxt1_2 = new JLabel("");
		 lblnxt1_2.setBounds(196, 0, 32, 40);
		 paneEmp.add(lblnxt1_2);
		 
		 JPanel paneService = new JPanel();
		 paneService.setForeground(new Color(255, 255, 255));
		 paneService.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneService.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneService.setBackground(new Color(128, 0, 0));

			 	}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneService.setBackground(new Color(255, 222, 173));

			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		menuClicked(panelServices);
	                
			 	}
			 });
		 paneService.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		paneService.setBackground(new Color(222, 184, 135));
			 		menuClicked(panelServices);

			 	}
			 });
		 paneService.setBackground(new Color(128, 0, 0));
		 paneService.setBounds(0, 348, 228, 40);
		 panel.add(paneService);
		 paneService.setLayout(null);
		 
		 JLabel lblService = new JLabel("SERVICES");
		 lblService.setBounds(64, 9, 89, 24);
		 lblService.setForeground(new Color(255, 255, 255));
		 lblService.setFont(new Font("Calibri", Font.BOLD, 20));
		 paneService.add(lblService);
		 
		 JLabel lblser = new JLabel("");
		 lblser.setBounds(13, 6, 32, 24);
		 paneService.add(lblser);
		 Image ser = new ImageIcon(this.getClass().getResource("/ser.png")).getImage();
		 lblser.setIcon(new ImageIcon(ser));
		 
		 JLabel lblnxt1_3 = new JLabel("");
		 lblnxt1_3.setBounds(196, 0, 32, 40);
		 paneService.add(lblnxt1_3);
		 
		 JPanel paneVihcles = new JPanel();
		 paneVihcles.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		paneVihcles.setBackground(new Color(128, 0, 0));
		 	}
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		paneVihcles.setBackground(new Color(255, 222, 173));

		 	}
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		menuClicked(panelVehicles);

		 	}
		 });
		 paneVihcles.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
		 		paneVihcles.setBackground(new Color(222, 184, 135));
		 		menuClicked(panelVehicles);

		 	}
		 });
		 paneVihcles.setLayout(null);
		 paneVihcles.setForeground(Color.WHITE);
		 paneVihcles.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneVihcles.setBackground(new Color(128, 0, 0));
		 
		 paneVihcles.setBounds(0, 308, 228, 40);
		 panel.add(paneVihcles);
		 
		 JLabel lblVihcles = new JLabel(" VEHICLES");
		 lblVihcles.setForeground(Color.WHITE);
		 lblVihcles.setFont(new Font("Calibri", Font.BOLD, 20));
		 lblVihcles.setBounds(60, 9, 83, 24);
		 paneVihcles.add(lblVihcles);
		 
		 JLabel lblVan = new JLabel("");
		 lblVan.setBounds(14, 6, 38, 23);
		 paneVihcles.add(lblVan);
		 Image van = new ImageIcon(this.getClass().getResource("/van.png")).getImage();
		 lblVan.setIcon(new ImageIcon(van));
		 
		 JLabel lblnxt1_4 = new JLabel("");
		 lblnxt1_4.setBounds(196, 0, 32, 40);
		 paneVihcles.add(lblnxt1_4);
		 lblnxt1_2.setIcon(new ImageIcon(nxt));
		 lblnxt1_3.setIcon(new ImageIcon(nxt));
		 lblnxt1_4.setIcon(new ImageIcon(nxt));
		 JPanel paneSignout = new JPanel();
		 paneSignout.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		paneSignout.setBackground(new Color(128, 0, 0));

		 	}
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		paneSignout.setBackground(new Color(255, 222, 173));

		 	}
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		SHS_shipping_company shs = new SHS_shipping_company();
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out ?")==0) {
		 		shs.setVisible(true);
		 		frameDashboard.this.dispose();
		 	}
		 	}
		 });
		 paneSignout.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
		 		paneSignout.setBackground(new Color(222, 184, 135));
		 		menuClicked(panelHome);


		 	}
		 });
		 paneSignout.setLayout(null);
		 paneSignout.setForeground(Color.WHITE);
		 paneSignout.setBorder(new LineBorder(new Color(128, 0, 0)));
		 paneSignout.setBackground(new Color(128, 0, 0));
		 paneSignout.setBounds(0, 388, 228, 40);
		 panel.add(paneSignout);
		 
		 JLabel lblSignout = new JLabel(" SIGN OUT");
		 lblSignout.setForeground(Color.WHITE);
		 lblSignout.setFont(new Font("Calibri", Font.BOLD, 20));
		 lblSignout.setBounds(59, 9, 89, 24);
		 paneSignout.add(lblSignout);
		 
		 JLabel lblsignout = new JLabel("");
		 lblsignout.setBounds(13, 5, 24, 24);
		 paneSignout.add(lblsignout);
		 Image signout = new ImageIcon(this.getClass().getResource("/signout.png")).getImage();
		 lblsignout.setIcon(new ImageIcon(signout));
		JLabel lblex = new JLabel("X");
		lblex.setBounds(828, 0, 17, 28);
		contentPane.add(lblex);
		 
		 lblex.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
		 		lblex.setForeground(new Color(128, 0, 0));

		 	}
	
		 });
		 lblex.setForeground(Color.LIGHT_GRAY);
		 lblex.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		frameDashboard.this.dispose();
		 		
		 	}
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		lblex.setForeground(Color.LIGHT_GRAY);

		 	}
		 });
		 lblex.setFont(new Font("Calibri", Font.BOLD, 18));
		 
		 JPanel panelMenuContent = new JPanel();
		 panelMenuContent.setBackground(new Color(255, 250, 240));
		 panelMenuContent.setBounds(229, 2, 586, 496);
		 contentPane.add(panelMenuContent);
		 panelMenuContent.setLayout(null);
		 panelHome = new Home();
		 panelHome.setBounds(0, 2, 586, 498);
		 panelMenuContent.add(panelHome);
		 panelOrder= new Orders();
		 panelOrder.setLocation(0, 3);
		 panelOrder.setSize(586, 498);
		 panelMenuContent.add(panelOrder);/////////////////////////////////////
		 panelMenuContent.add(panelEmp);
		 panelMenuContent.add(panelCustomer);
		 panelMenuContent.add(panelServices);
		 panelMenuContent.add(panelVehicles);



		 //Image s = new ImageIcon(this.getClass().getResource("/s.png")).getImage();

	}
	public void menuClicked(JPanel panel) {
		panelHome.setVisible(false);//////////////////////////////
		panelOrder.setVisible(false);
		panelEmp.setVisible(false);
		panelCustomer.setVisible(false);
		panelServices.setVisible(false);
		panelVehicles.setVisible(false);
		panel.setVisible(true);
	}
	
	

}
