package Modification;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Password_Etudiant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password_Etudiant frame = new Password_Etudiant();
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
	public Password_Etudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(529, 37, 235, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName :");
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(818, 129, 149, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(881, 167, 249, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("OldPassword:");
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(818, 220, 193, 27);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(881, 258, 249, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New Password :");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(818, 310, 208, 34);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(881, 355, 249, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password :");
		lblNewLabel_4.setForeground(new Color(0, 191, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(818, 401, 271, 33);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(881, 445, 249, 41);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connectionUrl="jdbc:mysql://localhost:3306/absence";
				String dbUser="root";
				String dbPwd="Mama@Baba123";
				Connection conn=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					Statement stat = conn.createStatement();
					String uid ,opw,npw,cfpw;
					uid=textField.getText();
					opw=textField_1.getText();
					npw=textField_2.getText();
					cfpw=textField_3.getText();
					
				     String ps1=(" Select mot_de_passe from etudiants where CNE='"+uid+"';");
					 String ps=("update etudiants set mot_de_passe='"+npw+"' where CNE='"+uid+"' ;");
					try {
						 ResultSet rs= stat.executeQuery(ps1);
						 if(rs.next()) {
							 if(rs.getString("mot_de_passe").equals(opw)) {
								 if(npw.equals(cfpw)) {
									 stat.executeUpdate(ps);
									 JOptionPane.showMessageDialog(null,"Changed Succefully  ");
								 }
								 else {
									 JOptionPane.showMessageDialog(null,"Confirm Password Does Not Match");
								 }
							 }
							 else {
								 JOptionPane.showMessageDialog(null,"Invalid Old Password");
								 
							 }
							 
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Invalid UserName");
							 
						 }
					}
					catch( Exception E) {
						E.printStackTrace();
						
					}
				
					    
				     
				   	 
					 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setBounds(920, 522, 131, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\Password_Enseignant.jpg"));
		lblNewLabel_5.setBounds(182, 100, 546, 496);
		contentPane.add(lblNewLabel_5);
	}
}

