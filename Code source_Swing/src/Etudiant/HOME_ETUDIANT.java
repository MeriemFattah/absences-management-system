package Etudiant;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
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

import Modification.Password_Etudiant;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class HOME_ETUDIANT extends JFrame {

	private JPanel contentPane;
	
	private JFrame frame;
	static JTextField textCIN;
	 static JTextField textlastname;
	 static JTextField textfirstname;
    static JTextField textdateofbirth;
	 static JTextField textcity;
	 static JTextField textstreet;
	 static JTextField textcountry;
	 static JTextField textpostalcode;
	 static JTextField textemail;
	 static JTextField textphonenumber;
	 JTextField textFieldCNE;

	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						  new HOME_ETUDIANT();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	public HOME_ETUDIANT() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(204, 255, 204));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1208, 608);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student's Information");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(464, 27, 393, 34);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" CIN :");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(561, 204, 80, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(561, 282, 109, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("First Name :");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setBounds(561, 364, 133, 34);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of birth :");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_4.setBounds(561, 450, 154, 26);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("City :");
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_5.setBounds(561, 523, 68, 39);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Street :");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_6.setBackground(new Color(240, 240, 240));
		lblNewLabel_6.setForeground(new Color(0, 0, 255));
		lblNewLabel_6.setBounds(882, 99, 80, 27);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Country :");
		lblNewLabel_7.setForeground(new Color(0, 0, 255));
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_7.setBounds(882, 198, 101, 34);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Postal Code :");
		lblNewLabel_8.setForeground(new Color(0, 0, 255));
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_8.setBounds(886, 281, 133, 28);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Email :");
		lblNewLabel_9.setForeground(new Color(0, 0, 255));
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_9.setBounds(882, 368, 101, 27);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Phone Number :");
		lblNewLabel_10.setForeground(new Color(0, 0, 255));
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_10.setBounds(882, 450, 157, 30);
		panel_1.add(lblNewLabel_10);
		
		textCIN = new JTextField();
		textCIN.setBounds(593, 237, 218, 34);
		panel_1.add(textCIN);
		textCIN.setColumns(10);
		
		textlastname = new JTextField();
		textlastname.setBounds(593, 319, 207, 34);
		panel_1.add(textlastname);
		textlastname.setColumns(10);
		
		textfirstname = new JTextField();
		textfirstname.setBounds(593, 409, 207, 34);
		panel_1.add(textfirstname);
		textfirstname.setColumns(10);
		
		textdateofbirth = new JTextField();
		textdateofbirth.setBounds(593, 487, 207, 34);
		panel_1.add(textdateofbirth);
		textdateofbirth.setColumns(10);
		
		textcity = new JTextField();
		textcity.setBounds(593, 563, 207, 34);
		panel_1.add(textcity);
		textcity.setColumns(10);
		
		textstreet = new JTextField();
		textstreet.setBounds(919, 144, 218, 34);
		panel_1.add(textstreet);
		textstreet.setColumns(10);
		
		textcountry = new JTextField();
		textcountry.setBounds(919, 237, 218, 34);
		panel_1.add(textcountry);
		textcountry.setColumns(10);
		
		textpostalcode = new JTextField();
		textpostalcode.setBounds(919, 320, 218, 34);
		panel_1.add(textpostalcode);
		textpostalcode.setColumns(10);
		
		textemail = new JTextField();
		textemail.setBounds(919, 406, 218, 34);
		panel_1.add(textemail);
		textemail.setColumns(10);
		
		textphonenumber = new JTextField();
		textphonenumber.setBounds(919, 491, 218, 34);
		panel_1.add(textphonenumber);
		textphonenumber.setColumns(10);
		
		textFieldCNE = new JTextField();
		textFieldCNE.setBounds(593, 144, 207, 34);
		panel_1.add(textFieldCNE);
		textFieldCNE.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Attendance");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(377, 525, 133, 43);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					  SHOWING_ATTENDANCE SH =new SHOWING_ATTENDANCE();
					  SH.setVisible(true);
				;
					}
				catch (Exception e10) {
					e10.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton("Grades");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(234, 525, 133, 43);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SHOWING_GRADES SG=new SHOWING_GRADES();
				 SG.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Modify Password");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(85, 525, 139, 44);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Password_Etudiant PE = new Password_Etudiant ();
				PE.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\info_etudiant.png"));
		lblNewLabel_12.setBounds(0, 31, 488, 490);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_1_1 = new JLabel(" CNE :");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(SystemColor.menu);
		lblNewLabel_1_1.setBounds(561, 101, 80, 22);
		panel_1.add(lblNewLabel_1_1);
		frame.setBounds(100, 100, 1222, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		



try {
    		//System.out.println(LOGIN_ETUDIANT.getTextusername());
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/absence","root","Mama@Baba123");
    		Statement stmt=con.createStatement();
    		String sql1 = ("select CNE,CNI , nom, prenom, date_de_naissance,ville,rue,pay,code_postale,email,Numero_tele from etudiants where CNE='"+LOGIN_ETUDIANTS.getTextusername()+"' ");
            ResultSet rs1 = stmt.executeQuery(sql1);
    		while(rs1.next()) {
    			 String cne = rs1.getString("CNE");
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
                 
                 textFieldCNE.setText(cne);
                 textFieldCNE.setEnabled(false);
                 textFieldCNE.setDisabledTextColor(new Color(0, 0, 0));
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