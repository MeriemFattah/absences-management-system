package Enseignant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;

public class modules extends JFrame {
	
	String connectionUrl="jdbc:mysql://localhost:3306/Absence";
	String dbUser="root";
	String dbPwd="Mama@Baba123";
	private JPanel contentPane;
	private JTable table;
	private PreparedStatement prepared;
	private ResultSet resultat;
	
	JButton btnNewButton_1 = new JButton("Next");
	JButton btnNewButton = new JButton("Display");
	private static JTextField textField;
	
	public static String getTextField() {
		return textField.getText();
	}
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					modules frame = new modules();
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
	public void table() {
			
			{
				Connection conn;
				try {
					conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
					 String sql1=("  select nom_module from modules  where CNI=  "+Espace_Enseignant.getTextusername());
				     Statement stat = ((java.sql.Connection) conn).createStatement();
					 ResultSet rs= stat.executeQuery(sql1);
					 ResultSetMetaData rsmd=rs.getMetaData();
					 DefaultTableModel model=(DefaultTableModel) table.getModel();
					 String[] colName= new String [1];
					 colName[0]="les Modules";
					 model.setColumnIdentifiers(colName);
					 String no ;
					 while(rs.next()) {
						 no=rs.getString(1);
					
						 
						 String [] row= {no};
						 model.addRow(row);}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	public modules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 1208, 622);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = table.getSelectedRow();
				 String module =table.getValueAt(ligne, 0).toString();
				 
				 
				 textField.setText(module);
				 
			}
		});
		table.setBackground(SystemColor.window);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(662, 100, 508, 276);
		panel.add(table);
		
		btnNewButton.addActionListener(new Ecouteur());
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setBounds(1016, 384, 97, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("your choice :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(339, 172, 130, 28);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(493, 173, 138, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		
		btnNewButton_1.addActionListener(new Ecouteur());
		btnNewButton_1.setBackground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(877, 387, 97, 32);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\projet\\src\\images\\module_note.png"));
		lblNewLabel.setBounds(0, 173, 719, 426);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COURSES");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(507, 26, 181, 75);
		panel.add(lblNewLabel_1);
	}
	
	class Ecouteur implements ActionListener{
		//pour tester les composantes
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==btnNewButton) {
			 table();
			}
			if (e.getSource()==btnNewButton_1) {
				Attendance f2 =new Attendance();
				 f2.setVisible(true);
				}
			
		}
		}
}
