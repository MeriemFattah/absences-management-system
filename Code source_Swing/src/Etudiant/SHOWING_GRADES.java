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
import java.awt.Color;

public class SHOWING_GRADES extends JFrame{

	private JPanel contentPane;
	private JTable table;

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
	public SHOWING_GRADES() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String connectionUrl="jdbc:mysql://localhost:3306/absence";
		String dbUser="root";
		String dbPwd="Mama@Baba123";
		Connection conn=null;

		setContentPane(contentPane);

		
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 91, 936, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
		scrollPane.setViewportView(table);
		JLabel lblNewLabel = new JLabel("See Your Grades :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 39, 321, 35);
		contentPane.add(lblNewLabel);
	
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{  conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 Statement stat = ((java.sql.Connection) conn).createStatement();
					 String query=" select nom_module ,TP,Controle,examen from module_etudiant inner join modules on modules.idm=module_etudiant.idm where CNE='"+LOGIN_ETUDIANTS.getTextusername()+"';";
					 ResultSet rs= stat.executeQuery(query);
					 ResultSetMetaData rsmd=rs.getMetaData();
					 DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String[] colName= new String [4];
					 colName[0]="Course";
					 colName[1]=" TP ";
					 colName[2]="CC";
					 colName[3]="Exam";
					
					
					 model.setColumnIdentifiers(colName);
					 String no,name,lna,Exam;
					 while(rs.next()) {
						 no=rs.getString(1);
						 name=rs.getString(2);
						 lna=rs.getString(3);
						 Exam=rs.getString(4);
						;
					
						
						 String [] row= {no,name,lna,Exam};
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