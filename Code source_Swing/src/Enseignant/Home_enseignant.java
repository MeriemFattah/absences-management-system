package Enseignant;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modification.*;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Home_enseignant extends JFrame {

	private JPanel contentPane;
	
	private JFrame frame;
	JTextField textCIN;
	 JTextField textlastname;
	 JTextField textfirstname;
    JTextField textdateofbirth;
	 JTextField textcity;
	 JTextField textstreet;
	 JTextField textcountry;
	 JTextField textpostalcode;
	 JTextField textemail;
	 JTextField textphonenumber;


	
	public Home_enseignant() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Modify Password");
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Password_Enseignant PE =new Password_Enseignant();
				 PE.setVisible(true);
			}
		});
		btnNewButton.setBounds(63, 452, 214, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBackground(new Color(0, 191, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(287, 452, 132, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		textstreet = new JTextField();
		textstreet.setBounds(893, 149, 196, 28);
		frame.getContentPane().add(textstreet);
		textstreet.setColumns(10);
		
		textcountry = new JTextField();
		textcountry.setBounds(893, 242, 196, 28);
		frame.getContentPane().add(textcountry);
		textcountry.setColumns(10);
		
		textpostalcode = new JTextField();
		textpostalcode.setBounds(893, 330, 196, 28);
		frame.getContentPane().add(textpostalcode);
		textpostalcode.setColumns(10);
		
		textemail = new JTextField();
		textemail.setBounds(893, 412, 196, 28);
		frame.getContentPane().add(textemail);
		textemail.setColumns(10);
		
		textphonenumber = new JTextField();
		textphonenumber.setBounds(893, 497, 196, 24);
		frame.getContentPane().add(textphonenumber);
		textphonenumber.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Street :");
		lblNewLabel_6.setBounds(864, 106, 101, 28);
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_6.setBackground(new Color(240, 240, 240));
		lblNewLabel_6.setForeground(new Color(0, 191, 255));
		
		JLabel lblNewLabel_7 = new JLabel("Country :");
		lblNewLabel_7.setBounds(864, 202, 101, 29);
		frame.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setForeground(new Color(0, 191, 255));
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_8 = new JLabel("Postal Code :");
		lblNewLabel_8.setBounds(864, 281, 132, 28);
		frame.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setForeground(new Color(0, 191, 255));
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_9 = new JLabel("Email :");
		lblNewLabel_9.setBounds(864, 377, 116, 24);
		frame.getContentPane().add(lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(0, 191, 255));
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_10 = new JLabel("Phone Number :");
		lblNewLabel_10.setBounds(864, 451, 153, 28);
		frame.getContentPane().add(lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(0, 191, 255));
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		textCIN = new JTextField();
		textCIN.setBounds(564, 149, 196, 28);
		frame.getContentPane().add(textCIN);
		textCIN.setColumns(10);
		
		textlastname = new JTextField();
		textlastname.setBounds(564, 242, 196, 28);
		frame.getContentPane().add(textlastname);
		textlastname.setColumns(10);
		
		textfirstname = new JTextField();
		textfirstname.setBounds(564, 330, 196, 28);
		frame.getContentPane().add(textfirstname);
		textfirstname.setColumns(10);
		
		textdateofbirth = new JTextField();
		textdateofbirth.setBounds(564, 412, 196, 28);
		frame.getContentPane().add(textdateofbirth);
		textdateofbirth.setColumns(10);
		
		textcity = new JTextField();
		textcity.setBounds(564, 495, 196, 28);
		frame.getContentPane().add(textcity);
		textcity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" CIN :");
		lblNewLabel_1.setBounds(540, 106, 80, 28);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Last Name :");
		lblNewLabel_2.setBounds(540, 192, 124, 29);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(0, 191, 255));
		
		JLabel lblNewLabel_3 = new JLabel("First Name :");
		lblNewLabel_3.setBounds(540, 281, 124, 38);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Date of birth :");
		lblNewLabel_4.setBounds(540, 369, 153, 37);
		frame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(0, 191, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel_5 = new JLabel("City :");
		lblNewLabel_5.setBounds(540, 451, 101, 37);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(0, 191, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Teacher's Information");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBounds(449, 26, 336, 34);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\info_enseignant.png"));
		lblNewLabel_11.setBounds(28, -4, 249, 259);
		frame.getContentPane().add(lblNewLabel_11);
		frame.setBounds(100, 100, 1222, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
try {
    		
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/absence","root","Mama@Baba123");
    		Statement stmt=con.createStatement();
    		String sql1 = "select CNI , nom, prenom, date_de_naissance,ville,rue,pay,code_postale,email,Numero_tele,mot_de_passe from enseignants where CNI = '"+Espace_Enseignant.getTextusername()+"'";
            ResultSet rs1 = stmt.executeQuery(sql1);
    		while(rs1.next()) {
                 String idd = rs1.getString("CNI");
                 String nomE = rs1.getString("nom");
                 String prenomE = rs1.getString("prenom");
                 String dateE = rs1.getString("date_de_naissance");
                 String villeE = rs1.getString("ville");
                 String rueE = rs1.getString("rue");
                 String paysE = rs1.getString("pay");
                 String codepostE = rs1.getString("code_postale");
                 String emailE = rs1.getString("email");
                 String teleE = rs1.getString("Numero_tele");

                textCIN.setText(idd);
                textCIN.setEnabled(false);
                 textCIN.setDisabledTextColor(new Color(0, 0, 0));
                 textlastname.setText(nomE);
                 textlastname.setEnabled(false);
                 textlastname.setDisabledTextColor(new Color(0, 0, 0));
                 textfirstname.setText(prenomE);
                 textfirstname.setEnabled(false);
                 textfirstname.setDisabledTextColor(new Color(0, 0, 0));
                 textdateofbirth.setText(dateE);
                textdateofbirth.setEnabled(false);
                 textdateofbirth.setDisabledTextColor(new Color(0, 0, 0));
                 textcity.setText(villeE);
                 textcity.setEnabled(false);
                 textcity.setDisabledTextColor(new Color(0, 0, 0));
                 textstreet.setText(rueE);
                 textstreet.setEnabled(false);
                 textstreet.setDisabledTextColor(new Color(0, 0, 0));
                 textcountry.setText(paysE);
                 textcountry.setEnabled(false);
                 textcountry.setDisabledTextColor(new Color(0, 0, 0));
                 textpostalcode.setText(codepostE);
                 textpostalcode.setEnabled(false);
                 textpostalcode.setDisabledTextColor(new Color(0, 0, 0));
                 textemail.setText(emailE);
                 textemail.setEnabled(false);
                 textemail.setDisabledTextColor(new Color(0, 0, 0));
                 textphonenumber.setText(teleE);
                 textphonenumber.setEnabled(false);
                 textphonenumber.setDisabledTextColor(new Color(0, 0, 0));
                 
    		}      
                
                 
                 
    			
    		
                
    			
    		
    			
    	} catch (SQLException E) {
			E.printStackTrace();
		}
		
		
	    
		
	
        
               
                
                
                

               
	}
}