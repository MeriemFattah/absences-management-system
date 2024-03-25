package Enseignant;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import com.sun.jdi.connect.spi.Connection;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class Espace_Enseignant_choix extends JFrame {

	private JPanel contentPane;
	JFrame frame;



	/**
	 * Create the frame.
	 */
	public Espace_Enseignant_choix() {
		initialize();
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1222, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WORKSPACE");
		lblNewLabel.setForeground(new Color(51, 204, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 45));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(450, 11, 357, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Available Services");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(44, 139, 217, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("your info ");
		btnNewButton.setBackground(new Color(51, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        			Home_enseignant   home_Enseignant = new Home_enseignant();
	        			// home_Enseignant.setVisible(true);
	                     
}
			
	        		
	                   
	           
	        
	        
			
				});
		frame.setVisible(true);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBounds(274, 134, 241, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Grades");
		btnNewButton_1.setBackground(new Color(51, 204, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				module_notes m1 = new module_notes();
				m1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(546, 134, 241, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Attendance");
		btnNewButton_2.setBackground(new Color(51, 204, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modules m =new modules();
				m.setVisible(true);
			}
		});
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_2.setBounds(811, 134, 241, 44);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\espace_enseignant_choix.png"));
		lblNewLabel_2.setBounds(187, 188, 746, 420);
		frame.getContentPane().add(lblNewLabel_2);
		}

}