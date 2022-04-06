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

public class Vehicles extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Vehicles() {
		setBounds(0, 2, 586, 496);
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(0, 0, 268, 496);
		add(panel);
		panel.setLayout(null);
		
		JPanel paneData = new JPanel();
		paneData.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				paneData.setBackground(new Color(222, 184, 135));


			}
		});
		paneData.setBounds(0, 174, 268, 52);
		panel.add(paneData);
		paneData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				veTable ot = new veTable();
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
		
		JLabel lblNewLabel = new JLabel("VEHICLE DATA");
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
		 		insertVehicle ve = new insertVehicle();
		 		ve.setVisible(true);
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
		 paneAdd.setBounds(0, 225, 268, 52);
		 panel.add(paneAdd);
		 
		 JLabel lblShippingInfo = new JLabel("NEW VEHICLE ");
		 lblShippingInfo.setVerticalAlignment(SwingConstants.BOTTOM);
		 lblShippingInfo.setForeground(new Color(128, 0, 0));
		 lblShippingInfo.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblShippingInfo.setBounds(63, 14, 177, 30);
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
		 	public void mouseClicked(MouseEvent e) {
		 		deleteVehicle de = new deleteVehicle();
		 		de.setVisible(true);
		 		
		 	
		 	}
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		paneDelete.setBackground(new Color(255, 222, 173));
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
		 paneDelete.setBounds(0, 276, 268, 52);
		 panel.add(paneDelete);
		 
		 JLabel lblNewOrder = new JLabel("DELETE VEHICLE");
		 lblNewOrder.setForeground(new Color(128, 0, 0));
		 lblNewOrder.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblNewOrder.setBounds(62, 14, 185, 30);
		 paneDelete.add(lblNewOrder);
		 
		 JLabel lbldelete = new JLabel("");
		 lbldelete.setBounds(10, 8, 32, 33);
		 paneDelete.add(lbldelete);
		 Image remove = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		 lbldelete.setIcon(new ImageIcon(remove));
		 JLabel lblbox1 = new JLabel("");
		 lblbox1.setBounds(72, 11, 156, 133);
		 panel.add(lblbox1);
		 Image box1 = new ImageIcon(this.getClass().getResource("/vehicles.png")).getImage();
		 lblbox1.setIcon(new ImageIcon(box1));
		 Image update = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		 Image search = new ImageIcon(this.getClass().getResource("/sear.png")).getImage();
		 JPanel paneSearch = new JPanel();
		 paneSearch.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent e) {
		 		paneSearch.setBackground(new Color(255, 222, 173));
		 	}
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		paneSearch.setBackground(new Color(255, 204, 153));	 

		 	}
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		searchVehicle serve= new searchVehicle();
		 		serve.setVisible(true);
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
		 paneSearch.setBounds(0, 326, 268, 52);
		 panel.add(paneSearch);
		 
		 JLabel lblSearch = new JLabel("SEARCH OF VEHICLE");
		 lblSearch.setForeground(new Color(128, 0, 0));
		 lblSearch.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblSearch.setBounds(62, 14, 197, 30);
		 paneSearch.add(lblSearch);
		 
		 JLabel lblsearch = new JLabel("");
		 lblsearch.setBounds(12, 8, 32, 33);
		 paneSearch.add(lblsearch);
		 //Image search = new ImageIcon(this.getClass().getResource("/sear.png")).getImage();
		 lblsearch.setIcon(new ImageIcon(search));
		 
		 JPanel panenum = new JPanel();
		 panenum.setLayout(null);
		 panenum.setBackground(new Color(255, 204, 153));
		 panenum.setBounds(0, 378, 268, 52);
		 panel.add(panenum);
		 panenum.addMouseMotionListener(new MouseMotionAdapter() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					panenum.setBackground(new Color(222, 184, 135));


				}
			});
		 panenum.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					
					panenum.setBackground(new Color(255, 222, 173));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panenum.setBackground(new Color(255, 204, 153));

				}
			});
		 
		 JLabel lblShippingInfo_1 = new JLabel("NUMBER OF VEHICLE");
		 lblShippingInfo_1.setVerticalAlignment(SwingConstants.BOTTOM);
		 lblShippingInfo_1.setForeground(new Color(128, 0, 0));
		 lblShippingInfo_1.setFont(new Font("Calibri", Font.BOLD, 23));
		 lblShippingInfo_1.setBounds(63, 14, 205, 30);
		 panenum.add(lblShippingInfo_1);
		 
		 JLabel lblcalc = new JLabel("");
		 lblcalc.setBounds(10, 11, 32, 33);
		 panenum.add(lblcalc);
		 Image calc = new ImageIcon(this.getClass().getResource("/calc.png")).getImage();
		 lblcalc.setIcon(new ImageIcon(calc));
		 JLabel lblphoto = new JLabel("");
		 lblphoto.setBounds(248, 133, 338, 338);
		 add(lblphoto);
		 Image photo = new ImageIcon(this.getClass().getResource("/hand.png")).getImage();
		 lblphoto.setIcon(new ImageIcon(photo));
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setToolTipText("");
		 panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		 panel_1.setBackground(Color.WHITE);
		 panel_1.setBounds(86, 11, 432, 122);
		 add(panel_1);
		 
		 JLabel lblShsShippingCompany = new JLabel("        SHS Shipping Company ");
		 lblShsShippingCompany.setForeground(new Color(153, 0, 0));
		 lblShsShippingCompany.setFont(new Font("Times New Roman", Font.BOLD, 28));
		 lblShsShippingCompany.setBackground(Color.WHITE);
		 lblShsShippingCompany.setBounds(10, 11, 417, 47);
		 panel_1.add(lblShsShippingCompany);
		 
		 JLabel lblWelcome = new JLabel("                WELCOME !");
		 lblWelcome.setForeground(new Color(153, 0, 0));
		 lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 28));
		 lblWelcome.setBackground(Color.WHITE);
		 lblWelcome.setBounds(10, 64, 359, 47);
		 panel_1.add(lblWelcome);
	}
}
