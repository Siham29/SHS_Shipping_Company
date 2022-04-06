import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;

public class Employees extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Employees() {
		setBounds(0, 2, 586, 496);
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(0, 0, 289, 496);
		add(panel);
		panel.setLayout(null);
		
		JPanel paneData = new JPanel();
		paneData.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				paneData.setBackground(new Color(222, 184, 135));


			}
		});
		paneData.setBounds(0, 153, 289, 52);
		panel.add(paneData);
		paneData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeTable ot = new EmployeeTable();
				ot.setVisible(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				paneData.setBackground(new Color(255, 222, 173));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneData.setBackground(new Color(255, 204, 153));

			}
		});
		paneData.setBackground(new Color(255, 204, 153));
		paneData.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE DATA");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setBounds(62, 14, 177, 30);
		paneData.add(lblNewLabel);
		
		JLabel lblData = new JLabel("");
		lblData.setBounds(10, 8, 32, 33);
		paneData.add(lblData);
		 Image im = new ImageIcon(this.getClass().getResource("/data.png")).getImage();
		 lblData.setIcon(new ImageIcon(im));
		 
		 JPanel paneAdd = new JPanel();
		 paneAdd.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		paneAdd.setBackground(new Color(255, 204, 153));
		 	}
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		paneAdd.setBackground(new Color(255, 222, 173));
		 		
		 	}
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		InsertEmployee Emp = new InsertEmployee();
		 		Emp.setVisible(true);
		 	}
		 });
		 paneAdd.addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
				paneAdd.setBackground(new Color(222, 184, 135));

		 	}
		 });
		 paneAdd.setLayout(null);
		 paneAdd.setBackground(new Color(255, 204, 153));
		 paneAdd.setBounds(0, 202, 289, 52);
		 panel.add(paneAdd);
		 
		 JLabel lblShippingInfo = new JLabel("NEW  EMPLOYEE");
		 lblShippingInfo.setVerticalAlignment(SwingConstants.BOTTOM);
		 lblShippingInfo.setForeground(new Color(128, 0, 0));
		 lblShippingInfo.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblShippingInfo.setBounds(62, 14, 177, 30);
		 paneAdd.add(lblShippingInfo);
		 
		 JLabel lblnewOrder = new JLabel("");
		 lblnewOrder.setBounds(10, 11, 32, 33);
		 paneAdd.add(lblnewOrder);
		 Image add = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		 lblnewOrder.setIcon(new ImageIcon(add));
		 JPanel paneDelete = new JPanel();
		 
		 paneDelete.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneDelete.setBackground(new Color(255, 204, 153));
			 	}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneDelete.setBackground(new Color(255, 222, 173));
			 		
			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		DeleteEmployee Emp = new DeleteEmployee();
			 		Emp.setVisible(true);
			 	}
			 });
		 paneDelete.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		 paneDelete.setBackground(new Color(222, 184, 135));

			 	}
			 });
		 paneDelete.setLayout(null);
		 paneDelete.setBackground(new Color(255, 204, 153));
		 paneDelete.setBounds(0, 250, 289, 52);
		 panel.add(paneDelete);
		 
		 JLabel lblNewOrder = new JLabel("DELETE EMPLOYEE");
		 lblNewOrder.setForeground(new Color(128, 0, 0));
		 lblNewOrder.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblNewOrder.setBounds(62, 14, 217, 30);
		 paneDelete.add(lblNewOrder);
		 
		 JLabel lbldelete = new JLabel("");
		 lbldelete.setBounds(10, 8, 32, 33);
		 paneDelete.add(lbldelete);
		 Image remove = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		 lbldelete.setIcon(new ImageIcon(remove));
		 JLabel lblbox1 = new JLabel("");
		 lblbox1.setBounds(85, 9, 156, 133);
		 panel.add(lblbox1);
		 Image box1 = new ImageIcon(this.getClass().getResource("/emp.png")).getImage();
		 lblbox1.setIcon(new ImageIcon(box1));
		 
		 JPanel paneUpdate = new JPanel();
		 paneUpdate.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneUpdate.setBackground(new Color(255, 204, 153));
			 	}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneUpdate.setBackground(new Color(255, 222, 173));
			 		
			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		EmSer Emp = new EmSer();
			 		Emp.setVisible(true);
			 	}
			 });
		 paneUpdate.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		paneUpdate.setBackground(new Color(222, 184, 135));

			 	}
			 });
		 paneUpdate.setLayout(null);
		 paneUpdate.setBackground(new Color(255, 204, 153));
		 paneUpdate.setBounds(0, 299, 289, 52);
		 panel.add(paneUpdate);
		 
		 JLabel lblUpdateOrder = new JLabel("UPDATE INFORMATION");
		 lblUpdateOrder.setForeground(new Color(128, 0, 0));
		 lblUpdateOrder.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblUpdateOrder.setBounds(52, 14, 238, 30);
		 paneUpdate.add(lblUpdateOrder);
		 
		 JLabel lblupdate = new JLabel("");
		 lblupdate.setBounds(10, 11, 32, 33);
		 paneUpdate.add(lblupdate);
		 Image update = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		 lblupdate.setIcon(new ImageIcon(update));
		 JPanel paneSearch = new JPanel();
		 paneSearch.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneSearch.setBackground(new Color(255, 204, 153));
			 	}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneSearch.setBackground(new Color(255, 222, 173));
			 		
			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		SearchEmp Emp = new SearchEmp();
			 		Emp.setVisible(true);
			 	}
			 });
		 paneSearch.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		paneSearch.setBackground(new Color(222, 184, 135));

			 	}
			 });
		 paneSearch.setLayout(null);
		 paneSearch.setBackground(new Color(255, 204, 153));
		 paneSearch.setBounds(0, 348, 289, 52);
		 panel.add(paneSearch);
		 
		 JLabel lblSearch = new JLabel("SEARCH OF EMPLOYEE");
		 lblSearch.setForeground(new Color(128, 0, 0));
		 lblSearch.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblSearch.setBounds(62, 14, 227, 30);
		 paneSearch.add(lblSearch);
		 
		 JLabel lblsearch = new JLabel("");
		 lblsearch.setBounds(12, 8, 32, 33);
		 paneSearch.add(lblsearch);
		 Image search = new ImageIcon(this.getClass().getResource("/sear.png")).getImage();
		 lblsearch.setIcon(new ImageIcon(search));
		 
		 JPanel paneSearch_1 = new JPanel();
		 paneSearch_1.setLayout(null);
		 paneSearch_1.setBackground(new Color(255, 204, 153));
		 paneSearch_1.setBounds(0, 402, 289, 52);
		 panel.add(paneSearch_1);
		 paneSearch_1.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		paneSearch_1.setBackground(new Color(255, 204, 153));
			 	}
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		paneSearch_1.setBackground(new Color(255, 222, 173));
			 		
			 	}
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		Rport Emp = new Rport();
			 		Emp.setVisible(true);
			 	}
			 });
		 paneSearch_1.addMouseMotionListener(new MouseMotionAdapter() {
			 	@Override
			 	public void mouseMoved(MouseEvent e) {
			 		paneSearch_1.setBackground(new Color(222, 184, 135));

			 	}
			 });
		 
		 
		 
		 
		 
		 
		 JLabel lblMonthlyReport = new JLabel("MONTHLY REPORT");
		 lblMonthlyReport.setForeground(new Color(128, 0, 0));
		 lblMonthlyReport.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblMonthlyReport.setBounds(62, 14, 227, 30);
		 paneSearch_1.add(lblMonthlyReport);
		 
		 JLabel lblsearch_1 = new JLabel("");
		 lblsearch_1.setBounds(12, 8, 40, 34);
		 paneSearch_1.add(lblsearch_1);
		 Image photo = new ImageIcon(this.getClass().getResource("/rep1.png")).getImage();
		 lblsearch_1.setIcon(new ImageIcon(photo));
		 
		 JLabel lblphoto = new JLabel("");
		 lblphoto.setBounds(248, 133, 338, 338);
		 add(lblphoto);
		 Image photo1= new ImageIcon(this.getClass().getResource("/hand.png")).getImage();
		 lblphoto.setIcon(new ImageIcon(photo1));
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setToolTipText("");
		 panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		 panel_1.setBackground(Color.WHITE);
		 panel_1.setBounds(86, 11, 424, 111);
		 add(panel_1);
		 
		 JLabel lblShsShippingCompany = new JLabel("        SHS Shipping Company ");
		 lblShsShippingCompany.setForeground(new Color(153, 0, 0));
		 lblShsShippingCompany.setFont(new Font("Times New Roman", Font.BOLD, 28));
		 lblShsShippingCompany.setBackground(Color.WHITE);
		 lblShsShippingCompany.setBounds(10, 11, 417, 47);
		 panel_1.add(lblShsShippingCompany);
		 
		 JLabel lblWelcome = new JLabel("                WELCOME ^_^");
		 lblWelcome.setForeground(new Color(153, 0, 0));
		 lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 28));
		 lblWelcome.setBackground(Color.WHITE);
		 lblWelcome.setBounds(10, 64, 359, 47);
		 panel_1.add(lblWelcome);
	}
}
