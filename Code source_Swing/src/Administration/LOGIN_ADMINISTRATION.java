
package Administration;

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
public class LOGIN_ADMINISTRATION {

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
					new LOGIN_ADMINISTRATION();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	

	/**
	 * Create the application.
	 */
	public LOGIN_ADMINISTRATION() {
		initialize();
		
	}
	public static String getTextusername() {
		return textusername.getText();
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
		panel.setBounds(0, 0, 491, 608);
		frmEspaceEnseignant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\login_administration.png"));
		lblNewLabel_4.setBounds(29, 55, 542, 542);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome Back Administrator");
		lblNewLabel_5.setForeground(new Color(0, 102, 255));
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel_5.setBounds(29, 24, 441, 63);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(140, 166, 92, 95);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 255));
		panel_1.setBounds(491, 0, 717, 620);
		frmEspaceEnseignant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(323, 28, 171, 51);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setToolTipText("");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 204, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_1.setBounds(174, 136, 171, 42);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel_2.setBounds(174, 250, 138, 38);
		panel_1.add(lblNewLabel_2);
		
		textusername = new JTextField();
		textusername.setBackground(new Color(255, 255, 255));
		textusername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textusername.setSelectedTextColor(new Color(245, 255, 250));
		textusername.setBounds(243, 189, 277, 34);
		panel_1.add(textusername);
		textusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtpassword.setBackground(new Color(255, 255, 255));
		txtpassword.setBounds(243, 299, 277, 34);
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
			        else if (textusername.getText().trim().equals("1234") && txtpassword.getText().trim().equals("1234")) {
			        	
			        			JOptionPane.showMessageDialog(null,"Login Sucessfully....");
			        		
			        			 Espace_Administration EA =new Espace_Administration();
			        			 EA.setVisible(true);
			        			
			        			
			        		}
			                    
			        			
			        		else {
			        			JOptionPane.showMessageDialog(null,"Incorrect username and password....");
			        		}
			        			
			        	}
			
		});
		
			     
		
		frmEspaceEnseignant.setVisible(true);
		
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setBounds(313, 404, 144, 42);
		panel_1.add(btnNewButton);
	}
}