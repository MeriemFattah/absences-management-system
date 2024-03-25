package Administration;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Administration.*;
import Enseignant.Espace_Enseignant;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Espace_Administration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Espace_Administration frame = new Espace_Administration();
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
	public Espace_Administration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Professors");
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignant en= new enseignant();
				en.setVisible(true);
			}
		});
		btnNewButton.setBounds(421, 185, 127, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Students");
		btnNewButton_1.setBackground(new Color(0, 204, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiant et = new etudiant();
				et.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(581, 185, 126, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Attendance");
		btnNewButton_2.setBackground(new Color(51, 204, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Attendance at =new Attendance();
				at.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(744, 185, 125, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Courses");
		btnNewButton_3.setBackground(new Color(0, 204, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Courses CR= new Courses();
				CR.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(898, 185, 124, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Majors");
		btnNewButton_4.setBackground(new Color(0, 204, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filiere F =new Filiere();
				F.setVisible(true);
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(1053, 186, 122, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\espace_administration.jpg"));
		lblNewLabel.setBounds(10, 118, 370, 386);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Accessing Important Information in the Administration Area");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(141, 11, 936, 80);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_5 = new JButton("Close");
		btnNewButton_5.setBackground(new Color(0, 204, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(717, 479, 125, 35);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to the administration area of our institution. This space is dedicated to");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(416, 313, 752, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("administrators and team members who work together to maintain the smooth operation of ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(390, 350, 818, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("our establishment. Through this area, you will have access to all relevant information,");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(408, 382, 790, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("including administrative updates, financial data, and performance reports.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(421, 418, 684, 22);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome back  conductor");
		lblNewLabel_6.setForeground(new Color(102, 204, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_6.setBounds(581, 267, 338, 35);
		contentPane.add(lblNewLabel_6);
	}
}