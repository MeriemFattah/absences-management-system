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
import java.awt.SystemColor;

public class Filiere extends JFrame{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filiere frame = new Filiere();
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
	public Filiere() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String connectionUrl="jdbc:mysql://localhost:3306/absence";
		String dbUser="root";
		String dbPwd="Mama@Baba123";
		Connection conn=null;

		setContentPane(contentPane);

		
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 902, 367);
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
					conn.createStatement();
				     DefaultTableModel model = (DefaultTableModel) table.getModel();
				     Random random = new Random();
				     int code =  random.nextInt(1000000);
					 PreparedStatement ps=conn.prepareStatement("insert into classe(idc,nbr_eleve,nomc) values(?,?,?) ;");
					 ps.setInt(1,code);  
					 ps.setString(2, textField_1.getText());  
				   	 ps.setString(3, textField.getText() ); 
				   	 ps.executeUpdate();
				   	 String no ,id ;
				   	 no= textField.getText();
				   	 id=textField_1.getText() ;
				 	List<Object> collection = new ArrayList<>();
				   	collection.add(code);
				   	collection.add(no);       
				   	collection.add(id);
				   	
				   	Vector<Object> vector = new Vector<>(collection);

				   	model.addRow(vector);
					 
					 
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
	
		btnNewButton_1.setBounds(1042, 75, 104, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(1042, 345, 104, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					conn.createStatement();
					 DefaultTableModel model = (DefaultTableModel) table.getModel();
				     int SelectedRowItem = table.getSelectedRow() ;
					PreparedStatement ps1=conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
					ps1.executeUpdate();
					PreparedStatement ps2 =conn.prepareStatement("delete from est_enseignee where idc=?;");
					ps2.setInt(1, (int) model.getValueAt(SelectedRowItem, 0)); 
					 ps2.executeUpdate();
					PreparedStatement ps=conn.prepareStatement("delete from classe where idc=?;");
					 ps.setInt(1,(int) model.getValueAt(SelectedRowItem, 0));   

				     ps.executeUpdate();
				     model.setValueAt(null, SelectedRowItem, 0);
				     model.setValueAt( null, SelectedRowItem, 1);
				     model.setValueAt(null, SelectedRowItem, 2);
				     
				     
					 		 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});

		
		JLabel lblNewLabel = new JLabel("Major's Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(55, 37, 153, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(247, 43, 164, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("POssible number of Students :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(421, 43, 255, 31);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(686, 43, 164, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		btnNewButton.setBounds(1042, 255, 104, 37);
		contentPane.add(btnNewButton);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = table.getSelectedRow();
				 String module =table.getValueAt(ligne, 1).toString();
				 String CNI =table.getValueAt(ligne, 2).toString();
				 textField_1.setText(CNI);
				 textField.setText(module);
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				Connection conn=null;
				Class.forName("com.mysql.cj.jdbc.Driver");
				try{ conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				conn.createStatement();
				 int SelectedRowItem = table.getSelectedRow() ;
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				PreparedStatement ps1=conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
				PreparedStatement ps=conn.prepareStatement("update classe set nbr_eleve=? ,nomc=?  where idc =? ;"); 
			     ps.setString(1,textField_1.getText() );  
			   	 ps.setString(2,(String) textField.getText());   
			   	 ps.setInt(3,(int) model.getValueAt(SelectedRowItem,0)); 
			   	 
			     model.getValueAt(SelectedRowItem,1);
			     model.getValueAt(SelectedRowItem,2);
			    
			     
			     model.setValueAt(textField.getText(), SelectedRowItem, 1);
			     model.setValueAt( textField_1.getText(), SelectedRowItem, 2);
			     ps1.executeUpdate();
				 ps.executeUpdate(); 
					 
				 
				 
						 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnNewButton_3.setBounds(1042, 166, 104, 37);
		contentPane.add(btnNewButton_3);
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try{  conn= (Connection) DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 Statement stat = ((java.sql.Connection) conn).createStatement();
					 String query="select * from classe ;";
					 ResultSet rs= stat.executeQuery(query);
					 DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String[] colName= new String [3];
					 colName[0]="Major's Identifier";
					 colName[1]="Major's Name ";
					 colName[2]="Students'Number";
					
					 model.setColumnIdentifiers(colName);
					 int no;
					 String name;
					String lna ;
					
					 while(rs.next()) {
						no=rs.getInt(1);
						 name=rs.getString(2);
						 lna=rs.getString(3);
						
						 List<Object> collection = new ArrayList<>();
						   	collection.add(no);
						   	collection.add(lna);       
						   	collection.add(name);
						   	
						   	Vector<Object> vector = new Vector<>(collection);

						   	model.addRow(vector);
						 
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
		});}
}
