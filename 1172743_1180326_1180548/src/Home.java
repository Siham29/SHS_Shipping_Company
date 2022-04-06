import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Home extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Home() {
		setBounds(0, 2, 586, 496);
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(36, 133, 491, 338);
		add(lblNewLabel);
		Image s = new ImageIcon(this.getClass().getResource("/s.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(s));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(36, 11, 491, 125);
		add(panel_1);
		
		JLabel lblShsShippingCompany = new JLabel("        SHS Shipping Company ");
		lblShsShippingCompany.setBackground(Color.WHITE);
		lblShsShippingCompany.setForeground(new Color(153, 0, 0));
		lblShsShippingCompany.setFont(new Font("Times New Roman", Font.BOLD, 28));
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
