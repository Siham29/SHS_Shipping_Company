
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

public class SHS_shipping_company extends JFrame implements ActionListener {
	private JPanel contentPane;

	public static final long serialVersionUID = 42L;
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    private final JPanel panel = new JPanel();
    private final JLabel lblNewLabel = new JLabel("     SHS Shipping Company ");
   Image img = new ImageIcon(this.getClass().getResource("/shipin.png")).getImage();
   Image image = new ImageIcon(this.getClass().getResource("/s1.png")).getImage();
   private final JLabel lblNewLabel_1 = new JLabel("");
   
    SHS_shipping_company() {
    	contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
    	getContentPane().setBackground(new Color(255, 245, 238));
    	panel.setBounds(3, 3, 379, 46);
    	panel.setBackground(new Color(255, 255, 255));
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
    }

    public void setLocationAndSize() {
        userLabel.setBounds(57, 289, 82, 34);
        userLabel.setBackground(new Color(153, 51, 51));
        userLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(57, 342, 100, 30);
        passwordLabel.setForeground(Color.BLACK);
        userTextField.setBounds(163, 292, 150, 30);
        userTextField.setBackground(Color.WHITE);
        passwordField.setBounds(163, 343, 150, 30);
        passwordField.setBackground(Color.WHITE);
        loginButton.setBounds(57, 428, 100, 30);
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(153, 0, 0));
        resetButton.setBounds(213, 428, 100, 30);
        resetButton.setForeground(new Color(153, 0, 0));
        resetButton.setBackground(new Color(255, 255, 255));
        lblNewLabel.setForeground(new Color(153, 0, 0));

    }

    public void addComponentsToContainer() {
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(3, 198, 379, 55);
        panel_1.setBackground(new Color(255, 255, 255));
        showPassword.setBounds(163, 380, 150, 30);
        showPassword.setBackground(new Color(255, 245, 238));
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Login to manage your SHS shipments ");
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(36, 11, 333, 33);
        panel_1.add(lblNewLabel_2);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
        			.addContainerGap())
        );
        panel.setLayout(gl_panel);
       lblNewLabel.setIcon(new ImageIcon(img));
       lblNewLabel_1.setBounds(4, 52, 379, 140);
       lblNewLabel_1.setIcon(new ImageIcon(image));
       loginButton.setFont(new Font("Times New Roman",Font.BOLD,18));
       resetButton.setFont(new Font("Times New Roman",Font.BOLD,18));
       lblNewLabel_2.setFont(new Font("Times New Roman",Font.BOLD,18));
        lblNewLabel.setFont(new Font("Times New Roman",Font.BOLD,21));
        userLabel.setFont(new Font("Times New Roman",Font.BOLD,14));
        passwordLabel.setFont(new Font("Times New Roman",Font.BOLD,14));
        getContentPane().setLayout(null);
        getContentPane().add(panel);
        getContentPane().add(loginButton);
        getContentPane().add(passwordLabel);
        getContentPane().add(userLabel);
        getContentPane().add(showPassword);
        getContentPane().add(passwordField);
        getContentPane().add(userTextField);
        getContentPane().add(resetButton);
        getContentPane().add(lblNewLabel_1);
        getContentPane().add(panel_1);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("shs") && pwdText.equalsIgnoreCase("12345")) {
                //JOptionPane.showMessageDialog(this, "Login Successful");
                frameDashboard frame = new frameDashboard();
                frame.setVisible(true);
                SHS_shipping_company.this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
}
 

