package Enseignant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class notes extends JFrame {
	String connectionUrl="jdbc:mysql://localhost:3306/absence";
	String dbUser="root";
	String dbPwd="Mama@Baba123";

	private JPanel contentPane;
	private JTable table;
	private PreparedStatement prepared;
	private ResultSet resultat;
	
	JButton btnNewButton = new JButton("Display List");
	JButton btnNewButton_1 = new JButton("Update");
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	JComboBox comboBox = new JComboBox();
	
	JLabel lblNewLabel = new JLabel("CNE :");
	JLabel lblNewLabel_4 = new JLabel("Nom :");
	JLabel lblNewLabel_5 = new JLabel("Prenom :");
	JLabel lblNewLabel_1 = new JLabel("Note de TP:");
	JLabel lblNewLabel_2 = new JLabel("Note de Controle:");
	JLabel lblNewLabel_3 = new JLabel("Note d'examen :");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notes frame = new notes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void table() {
		
			Connection conn;
			try {
				conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				 String sql1=" SELECT etudiants.CNE ,nom,prenom,nom_module,TP,Controle,Examen FROM (etudiants  JOIN classe ON etudiants.idc = classe.idc) join (module_etudiant JOIN modules ON modules.idm = module_etudiant.idm) ON etudiants.CNE = module_etudiant.CNE where nom_module='"+module_notes.getTextField()+"' and nomc in (select nomc from classe where nomc='"+comboBox.getSelectedItem()+"') and classe.idc in (select idc from est_enseignee where CNI='"+Espace_Enseignant.getTextusername()+"')" ;
				 
				 prepared = conn.prepareStatement(sql1);
			     resultat=prepared.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(resultat));
					 
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
	public void update_table() {
		try {
			
			
			Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			Statement stat = conn.createStatement();
			PreparedStatement ps=conn.prepareStatement("UPDATE module_etudiant SET TP ='"+textField_1.getText()+ "',Controle='"+textField_2.getText()+"',Examen='"+textField_3.getText()+ "'where CNE= '"+textField.getText()+"' and idm = (select idm from modules where nom_module='"+module_notes.getTextField()+"');");
			 ps.executeUpdate(); 
		   	

		} catch (SQLException e1) {
			e1.printStackTrace();}
		
	}
	public notes() {
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1208, 638);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(748, 114, 422, 431);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = table.getSelectedRow();
				 String CNE =table.getValueAt(ligne, 0).toString();
				 String nom =table.getValueAt(ligne, 1).toString();
				 String prenom =table.getValueAt(ligne, 2).toString();
				 
				 textField.setText(CNE);
				 textField_4.setText(nom);
				 textField_5.setText(prenom);
			}
		});
		scrollPane.setViewportView(table);
		
		
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1027, 553, 143, 39);
		btnNewButton.addActionListener(new Ecouteur());
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(33, 181, 183, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 148, 50, 22);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 403, 183, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(33, 485, 183, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(33, 559, 183, 30);
		panel.add(textField_3);
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 370, 117, 22);
		panel.add(lblNewLabel_1);
		

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 444, 151, 30);
		panel.add(lblNewLabel_2);
		
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(33, 526, 148, 22);
		panel.add(lblNewLabel_3);
		
		
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setBounds(857, 556, 137, 39);
		btnNewButton_1.addActionListener(new Ecouteur());
		panel.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(33, 329, 183, 30);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(33, 255, 183, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(33, 296, 72, 22);
		panel.add(lblNewLabel_4);
		
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(33, 222, 87, 22);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\notes.jpg"));
		lblNewLabel_6.setBounds(194, 12, 544, 580);
		panel.add(lblNewLabel_6);
		


		comboBox.setBounds(33, 107, 183, 30);
		panel.add(comboBox);
		
		comboBox.addItem("IID1");
		comboBox.addItem("IID2");
		comboBox.addItem("GI1");
		comboBox.addItem("GI2");
		comboBox.addItem("IRIC1");
		comboBox.addItem("IRIC2");
		
		JLabel lblNewLabel_8 = new JLabel("Mjors");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(33, 54, 72, 39);
		panel.add(lblNewLabel_8);
	}
	
	class Ecouteur implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==btnNewButton) {
				
				table();
			}
			if (e.getSource()==btnNewButton_1) {
				update_table();
				table();
			}
			
			
		}
		}
}