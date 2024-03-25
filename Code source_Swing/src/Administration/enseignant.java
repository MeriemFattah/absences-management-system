package Administration;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;



import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Choice;

public class enseignant extends JFrame {
	
	
	private PreparedStatement prepared;
	private ResultSet resultat;
	
	Connection conn;
	
	String connectionUrl="jdbc:mysql://localhost:3306/Absence";
	String dbUser="root";
	String dbPwd="Mama@Baba123";

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	JButton btnNewButton_2 = new JButton("display");
	JButton btnNewButton_1 = new JButton("Add");
	JButton btnNewButton = new JButton("Update");
	JButton btnNewButton_4 = new JButton("Delete");
	private final JButton btnNewButton_5 = new JButton("Search");
	
	private JTable table;
	
	JLabel lblNewLabel = new JLabel("Nom module :");
	JLabel lblNewLabel_1 = new JLabel("CIN :");
	JLabel lblNewLabel_2 = new JLabel("Last Name :");
	JLabel lblNewLabel_3 = new JLabel("First Name :");
	JLabel lblNewLabel_4 = new JLabel("date of birthday:");
	JLabel lblNewLabel_11 = new JLabel("Phone Number :");
	JLabel lblNewLabel_12 = new JLabel("City :");
	JLabel lblNewLabel_13 = new JLabel("Email :");
	JLabel lblNewLabel_14 = new JLabel("Country :");
	JLabel lblNewLabel_15 = new JLabel("Postal Code :");
	JLabel lblNewLabel_7 = new JLabel("Street :");
	JLabel lblNewLabel_5 = new JLabel("Please choose your major ");
	JLabel lblNewLabel_8 = new JLabel("Password :");
	
	private JTextField textField_7;
	
	JComboBox comboBox = new JComboBox();
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_15;
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enseignant frame = new enseignant();
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
	public enseignant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 0, 1198, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1080, 424, 108, 35);
		panel.add(btnNewButton);
		
		
		btnNewButton.addActionListener(new Ecouteur());
		btnNewButton_1.addActionListener(new Ecouteur());
		btnNewButton_2.addActionListener(new Ecouteur());
		btnNewButton_4.addActionListener(new Ecouteur());
		btnNewButton_5.addActionListener(new Ecouteur());
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(1080, 378, 108, 35);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(1080, 328, 108, 35);
		panel.add(btnNewButton_2);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(715, 127, 129, 24);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(854, 124, 164, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(40, 81, 65, 24);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 78, 164, 35);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(23, 116, 129, 25);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 124, 164, 35);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(23, 173, 129, 24);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(162, 170, 164, 35);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(363, 78, 143, 24);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(516, 70, 164, 35);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(282, 14, 225, 24);
		panel.add(lblNewLabel_5);
		
		
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(363, 274, 146, 24);
		panel.add(lblNewLabel_11);
		
		textField_10 = new JTextField();
		textField_10.setBounds(516, 263, 164, 35);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
	
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(401, 116, 65, 24);
		panel.add(lblNewLabel_12);
		
		textField_11 = new JTextField();
		textField_11.setBounds(516, 113, 164, 35);
		panel.add(textField_11);
		textField_11.setColumns(10);
		
		
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setBounds(23, 278, 57, 17);
		panel.add(lblNewLabel_13);
		
		textField_12 = new JTextField();
		textField_12.setBounds(162, 260, 164, 35);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(389, 173, 81, 24);
		panel.add(lblNewLabel_14);
		
		textField_13 = new JTextField();
		textField_13.setBounds(516, 170, 164, 35);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_15.setBounds(366, 227, 129, 24);
		panel.add(lblNewLabel_15);
		
		textField_14 = new JTextField();
		textField_14.setBounds(516, 217, 164, 35);
		panel.add(textField_14);
		textField_14.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 328, 1047, 270);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int ligne = table.getSelectedRow();
				 String module =table.getValueAt(ligne, 0).toString();
				 String CNI =table.getValueAt(ligne, 1).toString();
				 String nom =table.getValueAt(ligne, 2).toString();
				 String prenom =table.getValueAt(ligne, 3).toString();
				 String date_naiss =table.getValueAt(ligne, 4).toString();
				 String ville =table.getValueAt(ligne, 5).toString();
				 String rue =table.getValueAt(ligne, 6).toString();
				 String pay =table.getValueAt(ligne, 7).toString();
				 String codepos =table.getValueAt(ligne, 8).toString();
				 String email =table.getValueAt(ligne, 9).toString();
				 String numtele=table.getValueAt(ligne, 10).toString();
				 String etat=table.getValueAt(ligne, 11).toString();
				 String status=table.getValueAt(ligne, 12).toString();
				 String grades=table.getValueAt(ligne, 13).toString();
				 String pwd=table.getValueAt(ligne, 14).toString();
				 textField.setText(module);
				 textField_1.setText(CNI);
				 textField_2.setText(nom);
				 textField_3.setText(prenom);
				 textField_4.setText(date_naiss);
				 textField_11.setText(ville);
				 textField_7.setText(rue);
				 textField_13.setText(pay);
				 textField_14.setText(codepos);
				 textField_12.setText(email);
				 textField_10.setText(numtele);
				 textField_8.setText(etat);
				 textField_15.setText(status);
				 textField_9.setText(grades);
				 textField_5.setText(pwd);
				
			}
		});
		
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(23, 227, 93, 24);
		panel.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(162, 216, 164, 35);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		
		comboBox.addItem("IID1");
		comboBox.addItem("IID2");
		comboBox.addItem("GI1");
		comboBox.addItem("GI2");
		comboBox.addItem("IRIC1");
		comboBox.addItem("IRIC2");
		comboBox.setBounds(528, 11, 164, 35);
		panel.add(comboBox);
		
		
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(1080, 469, 108, 35);
		panel.add(btnNewButton_4);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(1080, 515, 108, 35);
		
		panel.add(btnNewButton_5);
		
		
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(715, 81, 123, 24);
		panel.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(854, 78, 164, 35);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(922, 11, 163, 35);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID_Major:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(802, 18, 93, 17);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("State :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(715, 173, 93, 24);
		panel.add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(854, 170, 164, 35);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Grades :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(715, 227, 81, 24);
		panel.add(lblNewLabel_10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(854, 217, 164, 35);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Status:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16.setBounds(715, 268, 65, 36);
		panel.add(lblNewLabel_16);
		
		textField_15 = new JTextField();
		textField_15.setBounds(854, 271, 164, 35);
		panel.add(textField_15);
		textField_15.setColumns(10);
	} 
	
	public void display() {
			
			
			try {
				conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				 String sql1=(" select distinct nom_module ,enseignants.CNI ,nom ,prenom ,date_de_naissance ,ville ,rue ,pay , code_postale ,email,Numero_tele,etat,statut,grades,mot_de_passe  from enseignants join modules on modules.CNI=enseignants.CNI where modules.CNI in ( select distinct CNI from est_enseignee where idc in( select idc from classe where nomc='"+comboBox.getSelectedItem()+"'))");
			     prepared = conn.prepareStatement(sql1);
			     resultat=prepared.executeQuery();
			     table.setModel(DbUtils.resultSetToTableModel(resultat));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void modules() {
		try{
			Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			 PreparedStatement ps2=conn.prepareStatement("insert into"
				 		+ " modules(nom_module,CNI) values(?,?)");
			 ps2.setString(1,textField.getText());
			 ps2.setString(2,textField_1.getText()); 
			 int i=ps2.executeUpdate();  
			 System.out.println(i+" records affected"); 

} catch (SQLException e1) {
			e1.printStackTrace();}
	}
	public void est_enseignee(){
		try{
			Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			Statement stmt=conn.createStatement();
			String sql1 = ("select idc from classe where nomc ='"+comboBox.getSelectedItem()+"'");
	        ResultSet rs1 = stmt.executeQuery(sql1);
			while(rs1.next()) {
				String idd = rs1.getString("idc");
				textField_6.setText(idd);
				System.out.println(idd);}
			
			PreparedStatement ps1=conn.prepareStatement("insert into"
			 		+ " est_enseignee values(?,?)"); 
			 ps1.setString(1,textField_1.getText());
			 ps1.setString(2,textField_6.getText());
			 int i=ps1.executeUpdate();  
			 System.out.println(i+" records affected"); 

} catch (SQLException e1) {
			e1.printStackTrace();}
	
}
	public void add() throws ClassNotFoundException {
		

		
		
		try{
		Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
		PreparedStatement ps=conn.prepareStatement("insert into enseignants (CNI,nom,prenom,date_de_naissance,ville,rue,pay,code_postale,email,Numero_tele,etat,statut,grades,mot_de_passe)"
		 		+ "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //pour exécuter une requête paramétrée.  
		 ps.setString(1,textField_1.getText());  
		 ps.setString(2,textField_2.getText()); 
		 ps.setString(3,textField_3.getText()); 
		 ps.setString(4,textField_4.getText()); 
		 ps.setString(5,textField_11.getText()); 
		 ps.setString(6,textField_7.getText()); 
		 ps.setString(7,textField_13.getText());
		 ps.setString(8,textField_14.getText());
		 ps.setString(9,textField_12.getText());
		 ps.setString(10,textField_10.getText());
		 ps.setString(11,textField_8.getText());
		 ps.setString(12,textField_15.getText());
		 ps.setString(13,textField_9.getText());
		 ps.setString(14,textField_5.getText());
		 
		 int i=ps.executeUpdate();  
		 System.out.println(i+" records affected"); 

} catch (SQLException e1) {
		e1.printStackTrace();}
	}
	
	public void update()  {
			try{
			Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			Statement stat = conn.createStatement();
			PreparedStatement ps=conn.prepareStatement("UPDATE enseignants SET CNI='"+textField_1.getText()+"',nom='"+textField_2.getText()+"',prenom='"+textField_3.getText()+"',date_de_naissance='"+textField_4.getText()+"',ville='"+textField_11.getText()+"',rue='"+textField_7.getText()+"',pay='"+textField_13.getText()+"',code_postale='"+textField_14.getText()+"',email='"+textField_12.getText()+"',Numero_tele='"+textField_10.getText()+ "',etat='"+textField_8.getText()+ "',statut='"+textField_15.getText()+ "',grades='"+textField_9.getText()+ "',mot_de_passe='"+textField_5.getText()+ "'where CNI= '"+textField_1.getText()+"';");
			 ps.executeUpdate(); 
			

} catch (SQLException e1) {
			e1.printStackTrace();}
	
		
	}
	public void delete_est_enseignee() {
		try{
			Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			Statement stat = conn.createStatement();
			String sql1 = ("select idc from classe where nomc ='"+comboBox.getSelectedItem()+"'");
	        ResultSet rs1 = stat.executeQuery(sql1);
			while(rs1.next()) {
				String idd = rs1.getString("idc");
				textField_6.setText(idd);}
			PreparedStatement ps=conn.prepareStatement(" delete from est_enseignee where idc='"+textField_6.getText()+"' and  CNI = '"+textField_1.getText() +"'");
			 ps.executeUpdate(); 
			

} catch (SQLException e1) {
			e1.printStackTrace();}
	}
	
	public void delete() {
		try{
			Connection conn= DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
			Statement stat = conn.createStatement();
			PreparedStatement ps=conn.prepareStatement(" delete  from enseignants where CNI = '"+textField_1.getText() +"'");
			 ps.executeUpdate(); 
			

} catch (SQLException e1) {
			e1.printStackTrace();}
	}
	public void search() {
try {
    		
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/absence","root","Mama@Baba123");
    		Statement stmt=con.createStatement();
    		String sql1 = ("select nom_module ,enseignants.CNI ,nom ,prenom ,date_de_naissance ,ville ,rue ,pay , code_postale ,email,Numero_tele,etat,statut,grades,mot_de_passe  from enseignants join modules on modules.CNI=enseignants.CNI where modules.CNI ='"+textField_1.getText()+"' and nom_module='" +textField.getText() +"'");
            ResultSet rs1 = stmt.executeQuery(sql1);
    		while(rs1.next()) {
    			String idd = rs1.getString("nom_module");
                 String CNI = rs1.getString("CNI");
                 String nomE = rs1.getString("nom");
                 String prenomE = rs1.getString("prenom");
                 String dateE = rs1.getString("date_de_naissance");
                 String villeE = rs1.getString("ville");
                 String rueE = rs1.getString("rue");
                 String paysE = rs1.getString("pay");
                 String codepostE = rs1.getString("code_postale");
                 String emailE = rs1.getString("email");
                 String teleE = rs1.getString("Numero_tele");
                 String etat = rs1.getString("etat");
                 String statut = rs1.getString("statut");
                 String grades = rs1.getString("grades");
                 String mot_de_passe = rs1.getString("mot_de_passe");

                 textField.setText(idd);
                 textField_1.setText(CNI);
                 textField_2.setText(nomE);
                 textField_3.setText(prenomE);
                 textField_4.setText(dateE);
                
                 textField_11.setText(villeE);
                
                 textField_7.setText(rueE);
               
                 textField_13.setText(paysE);
                
                 textField_14.setText(codepostE);
               
                 textField_12.setText(emailE);
              
                 textField_10.setText(teleE);
                 textField_8.setText(etat);
        		textField_15.setText(statut);
        		 textField_9.setText(grades);
        		textField_5.setText(mot_de_passe);
                 
    		 } }catch (SQLException e1) {
    				e1.printStackTrace();} 
	
}

	class Ecouteur implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (e.getSource()==btnNewButton_2) 
				display();
				
			if(e.getSource()==btnNewButton_1) {
				
				
				
				
				
				try {
					add();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				est_enseignee();
				modules();
				display();
			}
			
			if(e.getSource()==btnNewButton) {
				update();
				display();}
			
			if(e.getSource()==btnNewButton_4) {
				delete_est_enseignee();
				delete();
				display();}
			if(e.getSource()==btnNewButton_5) {
				search();}
		}			

}
}	
