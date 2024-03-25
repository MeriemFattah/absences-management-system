package Enseignant;
import Administration.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.Window;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.BevelBorder;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Espace_Enseignant {

	private JFrame frmEspaceEnseignant;
	private static JTextField textusername;
	private JPasswordField txtpassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Espace_Enseignant();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	

	/**
	 * Create the application.
	 */
	public Espace_Enseignant() {
		initialize();
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmEspaceEnseignant = new JFrame();
		frmEspaceEnseignant.setBackground(new Color(230, 230, 250));
		frmEspaceEnseignant.setTitle("Espace Enseignant");
		frmEspaceEnseignant.getContentPane().setBackground(new Color(230, 230, 250));
		frmEspaceEnseignant.setBounds(100, 100, 1222, 645);
		frmEspaceEnseignant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEspaceEnseignant.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 501, 608);
		frmEspaceEnseignant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\login_enseignant.jpg"));
		lblNewLabel_4.setBounds(10, 98, 481, 430);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome Back Teacher");
		lblNewLabel_5.setForeground(new Color(0, 191, 255));
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel_5.setBounds(75, 24, 361, 63);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(258, 0, 960, 619);
		frmEspaceEnseignant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(548, 34, 111, 50);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setToolTipText("");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_1.setBounds(422, 123, 129, 34);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_2.setBounds(422, 253, 129, 34);
		panel_1.add(lblNewLabel_2);
		
		textusername = new JTextField();
		textusername.setBackground(new Color(255, 255, 255));
		textusername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textusername.setSelectedTextColor(new Color(245, 255, 250));
		textusername.setBounds(451, 192, 288, 34);
		panel_1.add(textusername);
		textusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtpassword.setBackground(new Color(255, 255, 255));
		txtpassword.setBounds(451, 313, 288, 34);
		panel_1.add(txtpassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
			    String  username=textusername.getText();
				 String  password=txtpassword.getText();
			
				
				if(textusername.getText().trim().isEmpty()){
			        JOptionPane.showMessageDialog(null,"Please enter username");
			        textusername.setText("");
			        textusername.grabFocus();}
			        else if(txtpassword.getText().trim().isEmpty()){
			        JOptionPane.showMessageDialog(null,"Please enter password");
			        txtpassword.setText("");
			        txtpassword.grabFocus();
			    }
			        else {
			        	try {
			        		
			        		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/absence","root","Mama@Baba123");
			        		Statement stmt=con.createStatement();
			        		String sql="SELECT CNI , mot_de_passe FROM  enseignants where CNI = '"+ username+"' and mot_de_passe='"+password+
			        				"'";
			        		ResultSet rs=stmt.executeQuery(sql);
			        		if(rs.next()) {
			        			JOptionPane.showMessageDialog(null,"Login Sucessfully....");
			        		
			        			Espace_Enseignant_choix f = new Espace_Enseignant_choix();
			        			//f.setVisible(true);
			        			
			        			
			        		}
			                    
			        			
			        		else {
			        			JOptionPane.showMessageDialog(null,"Incorrect username and password....");
			        		con.close();}
			        			
			        	} catch (SQLException E) {
							E.printStackTrace();
						}}
			}
		});
		
			     
		
		frmEspaceEnseignant.setVisible(true);
		
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(528, 446, 144, 34);
		panel_1.add(btnNewButton);
	}


	public static String getTextusername() {
		return textusername.getText();
		
	}




	
}
