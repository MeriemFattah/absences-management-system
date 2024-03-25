package Enseignant;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;

public class Attendance extends JFrame{
	ButtonGroup group = new ButtonGroup();
	private JPanel contentPane;
	private JTable table;
	JRadioButton CNE = new JRadioButton("CNE");
	JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("ALPHABETIQUE");
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("SEXE");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	
	public Attendance() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String connectionUrl="jdbc:mysql://localhost:3306/absence";
		String dbUser="root";
		String dbPwd="Mama@Baba123";
		Connection conn=null;

		setContentPane(contentPane);

		
		contentPane.setLayout(null);
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(622, 38, 153, 37);
		contentPane.add(formattedTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 1007, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		scrollPane.setViewportView(table);
		JLabel lblNewLabel = new JLabel("Status :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 41, 82, 26);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.addItem("oui           ");
		comboBox.addItem("non           ");
		comboBox.setBounds(91, 38, 153, 37);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel(" Justification :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(254, 40, 136, 26);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.addItem("none       ");
		comboBox_1.addItem("parascolaire      ");
		comboBox_1.addItem("maladie      ");
		comboBox_1.addItem("autres       ");
		comboBox_1.setBounds(390, 38, 153, 37);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(559, 40, 82, 26);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String connectionUrl="jdbc:mysql://localhost:3306/absence";
				String dbUser="root";
				String dbPwd="Mama@Baba123";
				Connection conn=null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					Statement stat = conn.createStatement();
				     int SelectedRowItem = table.getSelectedRow() ;
				     DefaultTableModel model = (DefaultTableModel) table.getModel();
				   
					PreparedStatement ps=conn.prepareStatement("insert into"
				   	 		+ " absence values(?,?,?,?,?)"); 
					 ps.setString(1,null);  
					 ps.setString(2,(String) comboBox.getSelectedItem());  
				   	 ps.setString(3,(String) comboBox_1.getSelectedItem()); 
				   	 ps.setString(4,formattedTextField.getText());  
				   	 ps.setString(5, (String) model.getValueAt(SelectedRowItem,0)); 
			     
				     Object etat = model.getValueAt(SelectedRowItem,3);
				     Object justification = model.getValueAt(SelectedRowItem,4);
				     Object date_abscence = model.getValueAt(SelectedRowItem,5);
				     
				     model.setValueAt(comboBox.getSelectedItem(), SelectedRowItem, 3);
				     model.setValueAt( comboBox_1.getSelectedItem(), SelectedRowItem, 4);
				     model.setValueAt(formattedTextField.getText(), SelectedRowItem, 5);
					 int i=ps.executeUpdate(); 
						 
					 
					 
							 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					// TODO Auto-generated method stub
					
				}
		});
	
		btnNewButton_1.setBounds(1037, 224, 104, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(1037, 373, 104, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					Statement stat = conn.createStatement();
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
				     int SelectedRowItem = table.getSelectedRow() ;
					PreparedStatement ps=conn.prepareStatement("delete from absence where CNE=? and date_absence=? ;"); 
					 ps.setString(2,formattedTextField.getText());  
					 ps.setString(1, (String) model.getValueAt(SelectedRowItem, 0));   

				     
				     model.setValueAt(null, SelectedRowItem, 3);
				     model.setValueAt( null, SelectedRowItem, 4);
				     model.setValueAt(null, SelectedRowItem, 5);
	
					 int i=ps.executeUpdate(); 		 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setBounds(1037, 325, 104, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				Connection conn=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				Statement stat = conn.createStatement();
				 int SelectedRowItem = table.getSelectedRow() ;
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				PreparedStatement ps=conn.prepareStatement("update absence set etat=? ,justif=? ,date_absence=? where CNE =? ;"); 
				 ps.setString(1,(String) comboBox.getSelectedItem());  
			   	 ps.setString(2,(String) comboBox_1.getSelectedItem()); 
			   	 ps.setString(3,formattedTextField.getText());  
			   	 ps.setString(4, (String) model.getValueAt(SelectedRowItem,0)); 
			   	 model.setValueAt(comboBox.getSelectedItem(), SelectedRowItem, 3);
			     model.setValueAt( comboBox_1.getSelectedItem(), SelectedRowItem, 4);
			     model.setValueAt(formattedTextField.getText(), SelectedRowItem, 5);
				 int i=ps.executeUpdate(); 
					 
				 
				 
						 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnNewButton_3.setBounds(1037, 277, 104, 37);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Majors:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(785, 40, 82, 27);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"IID1", "IID2", "GI1", "GI2", "IRIC1", "IRIC2"}));
		comboBox_2.setBounds(864, 37, 153, 37);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_4 = new JButton("Display");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
			
				if ( CNE.isSelected()) {
					

	try {
		DefaultTableModel dm = (DefaultTableModel)table.getModel();
		dm.getDataVector().removeAllElements();
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{ Connection conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
		 Statement stat = ((java.sql.Connection) conn).createStatement();
		 String query="select distinct etudiants.CNE ,etudiants.nom,etudiants.prenom from\r\n"
		 		+ "etudiants inner join classe \r\n"
		 		+ "on etudiants.idc=classe.idc inner join est_enseignee\r\n"
		 		+ "on est_enseignee.idc =classe.idc inner join modules\r\n"
		 		+ "on modules.CNI=est_enseignee.CNI\r\n"
		 		+ " where classe.nomc='"+comboBox_2.getSelectedItem()+"'and modules.nom_module='"+modules.getTextField()+"' Order by CNE ASC ;";
		 ResultSet rs= stat.executeQuery(query);
		 DefaultTableModel model=(DefaultTableModel) table.getModel();
		 String[] colName= new String [6];
		 colName[0]="CNE";
		 colName[1]="Nom";
		 colName[2]="Prenom";
		 colName[3]="Etat";
		 colName[4]="Date Abscence";
		 colName[5]="Justification";
		 model.setColumnIdentifiers(colName);
		 String no,name,lna;
		 while(rs.next()) {
			 no=rs.getString(1);
			 name=rs.getString(2);
			 lna=rs.getString(3);
			
			 String [] row= {no,name,lna};
			 model.addRow(row);}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				}
				else if ( rdbtnNewRadioButton_2 .isSelected()) {
				
					try {
						DefaultTableModel dm = (DefaultTableModel)table.getModel();
						dm.getDataVector().removeAllElements();
						Class.forName("com.mysql.cj.jdbc.Driver");
						try{ Connection conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
						 Statement stat = ((java.sql.Connection) conn).createStatement();
						 String query="select distinct etudiants.CNE ,etudiants.nom,etudiants.prenom from\r\n"
						 		+ "etudiants inner join classe \r\n"
						 		+ "on etudiants.idc=classe.idc inner join est_enseignee\r\n"
						 		+ "on est_enseignee.idc =classe.idc inner join modules\r\n"
						 		+ "on modules.CNI=est_enseignee.CNI\r\n"
						 		+ " where classe.nomc='"+comboBox_2.getSelectedItem()+"'and modules.nom_module='"+modules.getTextField()+"' Order by nom ASC ;";
						 ResultSet rs= stat.executeQuery(query);
						 DefaultTableModel model=(DefaultTableModel) table.getModel();
						 String[] colName= new String [6];
						 colName[0]="CNE";
						 colName[1]="Nom";
						 colName[2]="Prenom";
						 colName[3]="Etat";
						 colName[4]="Date Abscence";
						 colName[5]="Justification";
						 model.setColumnIdentifiers(colName);
						 String no,name,lna;
						 while(rs.next()) {
							 no=rs.getString(1);
							 name=rs.getString(2);
							 lna=rs.getString(3);
							
							 String [] row= {no,name,lna};
							 model.addRow(row);}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				
				else if ( rdbtnNewRadioButton_1 .isSelected()) {
					
					try {
						DefaultTableModel dm = (DefaultTableModel)table.getModel();
						dm.getDataVector().removeAllElements();
						Class.forName("com.mysql.cj.jdbc.Driver");
						try{ Connection conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
						 Statement stat = ((java.sql.Connection) conn).createStatement();
						 String query="select distinct etudiants.CNE ,etudiants.nom,etudiants.prenom from\r\n"
						 		+ "etudiants inner join classe \r\n"
						 		+ "on etudiants.idc=classe.idc inner join est_enseignee\r\n"
						 		+ "on est_enseignee.idc =classe.idc inner join modules\r\n"
						 		+ "on modules.CNI=est_enseignee.CNI\r\n"
						 		+ " where classe.nomc='"+comboBox_2.getSelectedItem()+"'and modules.nom_module='"+modules.getTextField()+"' Order by sexe ;";
						 ResultSet rs= stat.executeQuery(query);
						 DefaultTableModel model=(DefaultTableModel) table.getModel();
						 String[] colName= new String [6];
						 colName[0]="CNE";
						 colName[1]="Nom";
						 colName[2]="Prenom";
						 colName[3]="Etat";
						 colName[4]="Date Abscence";
						 colName[5]="Justification";
						 model.setColumnIdentifiers(colName);
						 String no,name,lna;
						 while(rs.next()) {
							 no=rs.getString(1);
							 name=rs.getString(2);
							 lna=rs.getString(3);
							
							 String [] row= {no,name,lna};
							 model.addRow(row);}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}
				
				else {
					try {
						DefaultTableModel dm = (DefaultTableModel)table.getModel();
						dm.getDataVector().removeAllElements();
						Class.forName("com.mysql.cj.jdbc.Driver");
						try{ Connection conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
						 Statement stat = ((java.sql.Connection) conn).createStatement();
						 String query="select distinct etudiants.CNE ,etudiants.nom,etudiants.prenom from\r\n"
						 		+ "etudiants inner join classe \r\n"
						 		+ "on etudiants.idc=classe.idc inner join est_enseignee\r\n"
						 		+ "on est_enseignee.idc =classe.idc inner join modules\r\n"
						 		+ "on modules.CNI=est_enseignee.CNI\r\n"
						 		+ " where classe.nomc='"+comboBox_2.getSelectedItem()+"'and modules.nom_module='"+modules.getTextField()+"' Order by nom ASC ;";
						 ResultSet rs= stat.executeQuery(query);
						 DefaultTableModel model=(DefaultTableModel) table.getModel();
						 String[] colName= new String [8];
						 colName[0]="CNE";
						 colName[1]="Nom";
						 colName[2]="Prenom";
						 colName[3]="Etat";
						 colName[4]="Date Abscence";
						 colName[5]="Justification";
						 model.setColumnIdentifiers(colName);
						 String no,name,lna;
						 while(rs.next()) {
							 no=rs.getString(1);
							 name=rs.getString(2);
							 lna=rs.getString(3);
							
							 String [] row= {no,name,lna};
							 model.addRow(row);}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}}
		});
		btnNewButton_4.setBounds(1037, 176, 104, 37);
		contentPane.add(btnNewButton_4);
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		
		
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBounds(241, 513, 91, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		CNE.setBackground(new Color(255, 255, 255));
		
		
		CNE.setFont(new Font("Tahoma", Font.BOLD, 20));
		CNE.setBounds(401, 514, 75, 20);
		contentPane.add(CNE);
		
		group.add(CNE);
		group.add(rdbtnNewRadioButton_1);
		JLabel lblNewLabel_4 = new JLabel("Order of list :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(10, 507, 225, 31);
		contentPane.add(lblNewLabel_4);
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		
		
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnNewRadioButton_2.setBounds(537, 506, 209, 37);
		contentPane.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_2);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
} }