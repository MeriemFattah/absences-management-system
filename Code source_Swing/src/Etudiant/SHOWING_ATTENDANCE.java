package Etudiant;

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
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SHOWING_ATTENDANCE extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

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
	public SHOWING_ATTENDANCE() {
		
	
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
		scrollPane.setBounds(58, 180, 395, 241);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		scrollPane.setViewportView(table);
		JLabel lblNewLabel = new JLabel("See Your Sanctions :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(58, 134, 319, 35);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Keep your eyes peeled!!!");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(747, 320, 319, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\showing-attendance.jpg"));
		lblNewLabel_2.setBounds(754, 314, 361, 248);
		contentPane.add(lblNewLabel_2);
	
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{  conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 Statement stat = ((java.sql.Connection) conn).createStatement();
					 String query="select nom,prenom,sanction from etudiants where CNE='"+LOGIN_ETUDIANTS.getTextusername()+"';";
					 ResultSet rs= stat.executeQuery(query);
					 ResultSetMetaData rsmd=rs.getMetaData();
					 DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String[] colName= new String [3];
					 colName[0]="Name";
					 colName[1]="Last Name ";
					 colName[2]="Sanction";
					
					
					 model.setColumnIdentifiers(colName);
					 String no,name,lna;
					 while(rs.next()) {
						 no=rs.getString(1);
						 name=rs.getString(2);
						 lna=rs.getString(3);
						;
					
						
						 String [] row= {no,name,lna};
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
				}}}