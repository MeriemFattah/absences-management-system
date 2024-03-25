package Administration;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Attendance extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Attendance frame = new Attendance();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 92, 962, 368);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		scrollPane.setViewportView(table);

		
		JButton btnNewButton_1 = new JButton("Add");
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
				     DefaultTableModel model = (DefaultTableModel) table.getModel();
					 int SelectedRowItem = table.getSelectedRow() ;
				     PreparedStatement ps1=conn.prepareStatement(" SET FOREIGN_KEY_CHECKS=0;");
					 PreparedStatement ps=conn.prepareStatement("update etudiants set sanction=? where CNE=? ;");
					 ps.setString(1,(String) textField_1.getText());  
				   	 ps.setString(2,(String) model.getValueAt(SelectedRowItem,0) ); 
					    
				     
				     model.setValueAt(textField_1.getText(), SelectedRowItem, 5);
				   	  int j=ps1.executeUpdate();
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
	
		btnNewButton_1.setBounds(1034, 156, 104, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setBounds(1034, 385, 104, 37);
		contentPane.add(btnNewButton_2);
		JLabel lblNewLabel = new JLabel("Students's Identifier :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(182, 42, 219, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(431, 45, 183, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sanctions :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(656, 45, 144, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(793, 44, 190, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					Statement stat = conn.createStatement();
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
				     int SelectedRowItem = table.getSelectedRow() ;
					PreparedStatement ps=conn.prepareStatement("update  etudiants set sanction=?  where CNE=?  ;"); 
					 ps.setString(1," ");  
					 ps.setString(2,(String) model.getValueAt(SelectedRowItem, 0));   

				     
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
		btnNewButton.setBounds(1034, 229, 104, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton(" Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{  Connection conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					Statement stat = conn.createStatement();
				     DefaultTableModel model = (DefaultTableModel) table.getModel();
					 int SelectedRowItem = table.getSelectedRow() ;
				     PreparedStatement ps1=conn.prepareStatement(" SET FOREIGN_KEY_CHECKS=0;");
					 PreparedStatement ps=conn.prepareStatement("update etudiants set sanction=? where CNE=? ;");
					 ps.setString(1,(String) textField_1.getText());  
				   	 ps.setString(2,(String) model.getValueAt(SelectedRowItem,0) ); 
					    
				     
				     model.setValueAt(textField_1.getText(), SelectedRowItem, 5);
				   	  int j=ps1.executeUpdate();
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
		btnNewButton_3.setBounds(1034, 311, 104, 35);
		contentPane.add(btnNewButton_3);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = table.getSelectedRow();
				 String module =table.getValueAt(ligne, 0).toString();
			
				 textField.setText(module);

				
			}
		});
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{  conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 Statement stat = ((java.sql.Connection) conn).createStatement();
					 String query="select etudiants.CNE ,nom,prenom,etat,count(absence.ida)as nombre_absence ,etudiants.sanction from\r\n"
					 		+ "etudiants inner join absence \r\n"
					 		+ "on etudiants.CNE=absence.CNE \r\n"
					 		+ "where absence.etat=\"oui\" \r\n"
					 		+ "group by etudiants.CNE ;";
					 ResultSet rs= stat.executeQuery(query);
					 ResultSetMetaData rsmd=rs.getMetaData();
					 DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String[] colName= new String [6];
					 colName[0]="ID";
					 colName[1]="Name ";
					 colName[2]="Last Name";
					 colName[3]="Statut";
					 colName[4]="Attendance_Number";
					 colName[5]="Sanction";
					
					 model.setColumnIdentifiers(colName);
					 String no,name,lna,LN,ST,oo;
					 while(rs.next()) {
						 no=rs.getString(1);
						 name=rs.getString(2);
						 lna=rs.getString(3);
						 LN=rs.getString(4);
						 ST=rs.getString(5);
						 oo=rs.getString(6);
					
						
						 String [] row= {no,name,lna,LN,ST,oo};
						 model.addRow(row);
						 
					 }
					 stat.close();
					 ((java.sql.Connection) conn).close();
						 
					 
					 
							 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	
		
	

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});}}
