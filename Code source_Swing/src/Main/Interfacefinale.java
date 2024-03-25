package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Administration.*;
import Enseignant.Espace_Enseignant;
import Etudiant.*;
import Enseignant.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfacefinale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfacefinale frame = new Interfacefinale();
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
	public Interfacefinale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 1215, 613);
			contentPane.add(panel);
			panel.setLayout(null);
				JLabel lblNewLabel_2 = new JLabel("WELCOME");
				lblNewLabel_2.setBounds(465, 21, 224, 52);
				panel.add(lblNewLabel_2);
				lblNewLabel_2.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
				lblNewLabel_2.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 36));
				
				JLabel lblNewLabel_3 = new JLabel("TO YOUR UNIVERSITY SPACE");
				lblNewLabel_3.setBounds(348, 73, 433, 34);
				panel.add(lblNewLabel_3);
				lblNewLabel_3.setBackground(new Color(94, 122, 255));
				lblNewLabel_3.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 28));
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(684, 465, 325, 50);
				panel.add(comboBox);
				comboBox.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
				comboBox.setForeground(UIManager.getColor("FileChooser.listViewBackground"));
				comboBox.setFont(new Font("Tahoma", Font.BOLD, 26));
				comboBox.addItem("student area");
				comboBox.addItem("administration area");
				comboBox.addItem("teachers area ");
				
				JButton btnNewButton = new JButton("ENTER");
				btnNewButton.setBounds(790, 543, 110, 25);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(comboBox.getSelectedItem().equals("student area")) {
							
							try {
								new LOGIN_ETUDIANTS();
								
							} catch (Exception e7) {
								e7.printStackTrace();
							
						}
					}
					else if(comboBox.getSelectedItem().equals("administration area")) {
						new LOGIN_ADMINISTRATION();
					}
					else {
						
							try {
								new Espace_Enseignant();
								
							} catch (Exception e1) {
								e1.printStackTrace();
							
						}}
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\interface_initiale.jpg"));
				lblNewLabel.setBounds(-36, 147, 544, 455);
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Welcome to our institution's university interface. We are delighted to offer you easy and ");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(518, 128, 676, 66);
				panel.add(lblNewLabel_1);
				
				JLabel lblNewLabel_4 = new JLabel("convenient access to all the information you need to succeed in your studies. Whether you");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_4.setBounds(518, 170, 652, 40);
				panel.add(lblNewLabel_4);
				
				JLabel lblNewLabel_5 = new JLabel("are an undergraduate student, graduate, researcher, or professor, our interface is designed");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_5.setBounds(518, 193, 721, 57);
				panel.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("to meet your needs and facilitate your academic journey.");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_6.setBounds(518, 243, 433, 25);
				panel.add(lblNewLabel_6);
				
				JLabel lblNewLabel_7 = new JLabel("Our institution is committed to academic excellence and student success. We are proud of");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_7.setBounds(518, 291, 676, 34);
				panel.add(lblNewLabel_7);
				
				JLabel lblNewLabel_8 = new JLabel("our highly qualified faculty and our stimulating and collaborative learning environment. We");
				lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_8.setBounds(518, 325, 676, 25);
				panel.add(lblNewLabel_8);
				
				JLabel lblNewLabel_9 = new JLabel("are also committed to research and innovation in various fields, offering students the ");
				lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_9.setBounds(518, 352, 637, 40);
				panel.add(lblNewLabel_9);
				
				JLabel lblNewLabel_10 = new JLabel("opportunity to participate in cutting-edge research projects and gain practical experience.");
				lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_10.setBounds(518, 386, 646, 34);
				panel.add(lblNewLabel_10);
			
			
			
	}
}
