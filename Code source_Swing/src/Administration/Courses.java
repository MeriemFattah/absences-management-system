package Administration;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

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

public class Courses extends JFrame{

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
//					Course frame = new Course();
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
	public Courses() {
		
	
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
		scrollPane.setBounds(10, 85, 996, 378);
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
				     Random random = new Random();
				     int code =  random.nextInt(1000000);
					 PreparedStatement ps=conn.prepareStatement("insert into modules (idm,nom_module,CNI) values(?,?,?) ;"); 
					 ps.setInt(1,code);
					 ps.setString(2,(String) textField.getText());  
				   	 ps.setString(3,(String) textField_1.getText() ); 
				   	 String  no ,id ;
				   	 no= textField.getText();
				   	 id=textField_1.getText() ;
				   	List<Object> collection = new ArrayList<>();
				   	collection.add(code);
				   	collection.add(no);       
				   	collection.add(id);
				   	
				   	Vector<Object> vector = new Vector<>(collection);

				   	model.addRow(vector);
				   	int i=ps.executeUpdate();  
					System.out.println(i+" records affected"); 
					 
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
	
		btnNewButton_1.setBounds(1053, 177, 104, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setBounds(1053, 383, 104, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
				     int SelectedRowItem = table.getSelectedRow() ;
				     
					 PreparedStatement ps1=conn.prepareStatement("delete from abscence_module where idm=?;");
					 ps1.setString(1,(String) model.getValueAt(SelectedRowItem, 0));
					 int i=ps1.executeUpdate();
					 PreparedStatement ps2=conn.prepareStatement("delete from module_etudiant where idm=?;");
					 ps2.setString(1,(String) model.getValueAt(SelectedRowItem, 0));
					 int J=ps2.executeUpdate();
					 PreparedStatement ps=conn.prepareStatement("delete from modules where idm=?;");
					 ps.setString(1,(String) model.getValueAt(SelectedRowItem, 0));
				     model.setValueAt(null, SelectedRowItem, 0);
				     model.setValueAt( null, SelectedRowItem, 1);
				     model.setValueAt(null, SelectedRowItem, 2);
					 int i2=ps.executeUpdate(); 		 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		
		textField = new JTextField();
		textField.setBounds(229, 44, 170, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("The professor's Identifier  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(419, 39, 273, 35);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(730, 44, 170, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		btnNewButton.setBounds(1053, 307, 104, 37);
		contentPane.add(btnNewButton);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = table.getSelectedRow();
				 String module =table.getValueAt(ligne, 1).toString();
				 String CNI =table.getValueAt(ligne, 2).toString();
				 textField.setText(module);
				 textField_1.setText(CNI);
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				Connection conn=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				Statement stat = conn.createStatement();
				 int SelectedRowItem = table.getSelectedRow() ;
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				PreparedStatement ps=conn.prepareStatement("update modules set nom_module=? ,CNI=?  where idm =? ;"); 
			     ps.setString(1,textField.getText() );  
			   	 ps.setString(2,(String) textField_1.getText());   
			   	ps.setInt(3, Integer.parseInt((String) model.getValueAt(SelectedRowItem, 0)));
			 
			    
			     
			     model.setValueAt(textField.getText(), SelectedRowItem, 1);
			     model.setValueAt( textField_1.getText(), SelectedRowItem, 2);
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
		btnNewButton_3.setBounds(1053, 244, 104, 37);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Course Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(29, 44, 170, 23);
		contentPane.add(lblNewLabel);
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{  conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 Statement stat = ((java.sql.Connection) conn).createStatement();
					 String query="select * from modules ;";
					 ResultSet rs= stat.executeQuery(query);
					 ResultSetMetaData rsmd=rs.getMetaData();
					 DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String[] colName= new String [3];
					 colName[0]="Course's Identifier";
					 colName[1]="Coures's Name ";
					 colName[2]="Professor's Identifier";
					
					 model.setColumnIdentifiers(colName);
					 String no,name,lna;
					 while(rs.next()) {
						 no=rs.getString(1);
						 name=rs.getString(2);
						 lna=rs.getString(3);
						
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
				}
		
	
		
	

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});}}