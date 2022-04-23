package DBMS;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.text.*;//for the use of date class
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
class connector{
PreparedStatement c1(String query)
{
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms_project?"
			+ "characterEncoding=latin1", "root", "yourpassword");
	PreparedStatement preparedSt = con.prepareStatement(query);
return preparedSt;	
	}
	catch(Exception e)
	{
		System.out.println(""+e);
	return null;	
}
	}
ResultSet c2(String query)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms_project?"
					+ "characterEncoding=latin1", "root", "yourpassword");
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
	return rs;
		}
catch(Exception e)
		{
	System.out.println(""+e);
return null;
		}}
}
class login{
	login(int k,String check)
	{
		String ID=DBMS.userid;
		String password=DBMS.password;
		try {
		String query="select password from "+check+" where ID=?";
        PreparedStatement preparedSt =DBMS.c.c1(query);
    	preparedSt.setString(1,ID);	    
	    ResultSet rs=preparedSt.executeQuery();
		if(rs.next())
        	if(password.equals(rs.getString(1)))
        	{   
        	}
      	else {
      		JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Please enter correct credentials");
	    	DBMS.main(null);
    		}
        else {
        	JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Please enter correct credentials");        	
	    	DBMS.main(null);
        	}
		}
        catch(Exception e)
        {
        	JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Select a User Type to Sign Up for ");        	
	    	DBMS.main(null);}}
    	 public static boolean validpassword(String password) {
		 if (password.length() < 8) {
		 return false; }
		 if (password.contains(" ")) {
		 return false; }
		 if (true) {
		 int count = 0;
		 for (int i = 0; i <= 9; i++) {
		 String str1 = Integer.toString(i);
		 if (password.contains(str1)) { 
		 count = 1; } }
		 if (count == 0) {
		 return false; }}
		 if (!(password.contains("@") || password.contains("#")
		 || password.contains("!") || password.contains("~")
		 || password.contains("$") || password.contains("%")
		 || password.contains("^") || password.contains("&")
		 || password.contains("*") || password.contains("(")
		 || password.contains(")") || password.contains("-")
		 || password.contains("+") || password.contains("/")
		 || password.contains(":") || password.contains(".")
		 || password.contains(", ") || password.contains("<")
		 || password.contains(">") || password.contains("?")
		 || password.contains("|"))) {
		 return false; }
		 if (true) {
		 int count = 0;
		 for (int i = 65; i <= 90; i++) {
		 char c = (char)i;
		 String str1 = Character.toString(c);
		 if (password.contains(str1)) {
		 count = 1; } }
		 if (count == 0) {
		 return false; }}
		 if (true) {
		 int count = 0;
		 for (int i = 90; i <= 122; i++) {
		 char c = (char)i;
		 String str1 = Character.toString(c);
		 if (password.contains(str1)) {
		 count = 1; } }
		 if (count == 0) {
		 return false; } }
		 return true; }
	 }
class signup{
	JFrame frmsignupPage;
	 signup(int f) throws SQLException {
         login obj;
	    	JFrame signup = new JFrame();
			signup.setTitle("Signup Page");
			signup.setBounds(100, 200,990, 725);
			signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			signup.getContentPane().setLayout(null);
			JPanel panel = new JPanel();
			panel.setBackground(new Color(220, 20, 60));
			panel.setBounds(0, 0, 1100, 58);
			signup.add(panel);
			panel.setLayout(null);
			JLabel	status = new JLabel("status");
			status.setFont(new Font("Tahoma", Font.BOLD, 18));
			status.setBounds(725, 336, 90, 39);
			String[] statusvalues = {"Yes", "No"};
			JComboBox status_comboBox = new JComboBox(statusvalues);
			status_comboBox.setBackground(new Color(255, 255, 255));
			status_comboBox.setBounds(795, 336, 85, 41);
			    JTextField LDD = new JTextField();
    			LDD.setBounds(357, 259, 172, 41);
    		JLabel label1 = new JLabel("LDD");
    		label1.setFont(new Font("Tahoma", Font.BOLD, 18));
    		label1.setBounds(298, 259, 85, 35);
    		JButton	backButton = new JButton("");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					signup.dispose();
					DBMS myStart_Page=null;	
					myStart_Page.main(null);
				}});
			backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
			backButton.setBackground(new Color(220, 20, 60));
			backButton.setBounds(12, 13, 51, 42);
			panel.add(backButton);
			String table;
			if(f==0) {
				signup.add(status);	
				signup.add(status_comboBox);	
				signup.add(label1);
				signup.add(LDD);
				table="Donor";
			}
			else {
				table="Patient";
			}String query="Select * from "+table;
    		JLabel Agelabel = new JLabel("Age");
    		Agelabel.setFont(new Font("Tahoma", Font.BOLD, 18));
    		Agelabel.setBounds(400, 89, 45, 35);
    		signup.add(Agelabel);
		    JTextField nameField = new JTextField();
			nameField.setBounds(122, 89, 272, 41);
			signup.add(nameField);
			nameField.setColumns(10);
		    JTextField AgeField = new JTextField();
			AgeField.setBounds(462, 89, 72, 41);
			signup.add(AgeField);
			nameField.setColumns(10);
			JTextField phonenumberField = new JTextField();
			phonenumberField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
						e.consume();
					}}});
			phonenumberField.setColumns(10);
			phonenumberField.setBounds(439, 336, 255, 41);
			signup.add(phonenumberField);
			String[] Bloodgropus = {"ABpositive", "ABnegative", "Bpositive", "Bnegative","Opositive","Onegative","HH"};
			JComboBox bloodtype_comboBox = new JComboBox(Bloodgropus);
			bloodtype_comboBox.setBackground(new Color(255, 255, 255));
			bloodtype_comboBox.setBounds(122, 336, 108, 41);
			signup.add(bloodtype_comboBox);
            JLabel nameLabel = new JLabel("Name");
			nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			nameLabel.setBounds(12, 91, 69, 35);
			signup.add(nameLabel);
		    JLabel passwordLabel = new JLabel("Password");
			passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			passwordLabel.setBounds(12, 161, 92, 35);
			signup.add(passwordLabel);
			JLabel	phonenumberLabel = new JLabel("Phone number");
			phonenumberLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			phonenumberLabel.setBounds(275, 336, 134, 39);
			signup.add(phonenumberLabel);
     		JLabel	cityLabel = new JLabel("Address");
			cityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			cityLabel.setBounds(12, 259, 146, 35);
			signup.add(cityLabel);
			JLabel lblBloodType = new JLabel("Blood type");
			lblBloodType.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblBloodType.setBounds(12, 336, 100, 35);
			signup.add(lblBloodType);
		    JPasswordField	passwordField = new JPasswordField();
			passwordField.setBounds(122, 159, 272, 41);
			signup.add(passwordField);
		    JTextField BID = new JTextField();
			BID.setBounds(677, 259, 172, 41);
			signup.add(BID);
		    JLabel neighborhoodLabel = new JLabel("Blood BankID");
			neighborhoodLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			neighborhoodLabel.setBounds(542, 259, 128, 35);
			signup.add(neighborhoodLabel);
		    JLabel confirmpasswordLabel = new JLabel("Confirm Password");
			confirmpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			confirmpasswordLabel.setBounds(422, 161, 164, 39);
			signup.add(confirmpasswordLabel);
			JPasswordField confirmpasswordField = new JPasswordField();
			confirmpasswordField.setBounds(595, 161, 272, 41);
			signup.add(confirmpasswordField);
		    JTextField Address = new JTextField();
		    Address.setBounds(102, 259, 172, 41);
            signup.add(Address);
            JButton signupButton = new JButton("Sign up");
    		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    		signupButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if(passwordField.getText().isEmpty() || confirmpasswordField.getText().isEmpty() || nameField.getText().isEmpty() || phonenumberField.getText().isEmpty()) {
    					JOptionPane myOption = new JOptionPane();
    			    	myOption.showMessageDialog(null, "Field can not be empty");
    				}else if (String.valueOf(passwordField.getPassword()).equals(confirmpasswordField.getPassword())) {
    					JOptionPane myOption = new JOptionPane();
    			    	myOption.showMessageDialog(null, "Your passwords are not the same");
    				}else if(phonenumberField.getText().length() > 10 || phonenumberField.getText().length() < 10) {
    					JOptionPane myOption = new JOptionPane();
    			    	myOption.showMessageDialog(null, "Enter a valid phone number");
    				}		Random random=new Random();
    				int num = random.nextInt(900) + 10;
    			      long millis=System.currentTimeMillis();  
    			      java.sql.Date date=new java.sql.Date(millis);  
    				num=Integer.valueOf(String.valueOf(BID.getText())+String.valueOf(num));
if(f==0)
{
      String query="insert into DONORLOGIN values(?,?)";
	  PreparedStatement stmt = DBMS.c.c1(query);
	  try {
		  String snum="D"+String.valueOf(num);
		stmt.setString(1, String.valueOf(snum));
		stmt.setString(2, String.valueOf(passwordField.getText()));
		stmt.executeUpdate();}
	  catch (SQLException e1) {
			e1.printStackTrace();
		}
	  query="insert into DONORDATA values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt1 = DBMS.c.c1(query);
	  try {
		  String snum="D"+String.valueOf(num);
		stmt1.setString(1, String.valueOf(snum));
		stmt1.setString(2, String.valueOf(BID.getText()));
		stmt1.setString(3, String.valueOf(nameField.getText()));
		stmt1.setString(7, String.valueOf(phonenumberField.getText()));
		stmt1.setInt(5, Integer.valueOf(AgeField.getText()));
		stmt1.setString(6, String.valueOf(Address.getText()));
		stmt1.setDate(8, Date.valueOf(LDD.getText()));
		stmt1.setInt(10,30);
		stmt1.setDate(9,date);
		stmt1.setString(11, String.valueOf(status_comboBox.getSelectedItem()));
		stmt1.setString(4, String.valueOf(bloodtype_comboBox.getSelectedItem()));
		stmt1.executeUpdate();
		stmt1.close();
		 JOptionPane myOption = new JOptionPane();
		 myOption.showMessageDialog(null, "Signed Up Successfully, your User ID is " + num);
		 signup.dispose();
		 DBMS myStart_Page = new DBMS();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
}
else
{
    String query="insert into PatientLOGIN values(?,?)";
	  PreparedStatement stmt = DBMS.c.c1(query);
	  try {
		  String snum="P"+String.valueOf(num);
		stmt.setString(1, String.valueOf(num));
		stmt.setString(2, String.valueOf(passwordField.getText()));
		stmt.executeUpdate();}
	  catch (SQLException e1) {
			e1.printStackTrace();
		}
	  query="insert into PatientDATA values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt1 = DBMS.c.c1(query);
	  try {
		  String snum="P"+String.valueOf(num);
		stmt1.setString(1, String.valueOf(snum));
		stmt1.setString(4, String.valueOf(BID.getText()));
		stmt1.setString(2, String.valueOf(nameField.getText()));
		stmt1.setString(6, String.valueOf(Address.getText()));
		stmt1.setString(7, String.valueOf(phonenumberField.getText()));
		stmt1.setInt(3, Integer.valueOf(AgeField.getText()));
		stmt1.setInt(10,30);
		stmt1.setDate(9,date);
		stmt1.setString(5, String.valueOf(bloodtype_comboBox.getSelectedItem()));
		stmt1.executeUpdate();
		stmt1.close();
		 JOptionPane myOption = new JOptionPane();
		 myOption.showMessageDialog(null, "Signed Up Successfully, your User ID is " + snum);
		 signup.dispose();
		 DBMS myStart_Page = new DBMS();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
}}});
            signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\signup1.png"));
            signupButton.setBounds(405, 600, 100, 50);
    		signup.add(signupButton);
			signup.setVisible(true);
		}}
class display{
	display(String str1,String str2)
	{
		try {
			String query="select "+str1+" from "+str2;
	        ResultSet rs = DBMS.c.c2(query);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int a=rsmd.getColumnCount();
	    	for(int i=1;i<a+1;i++) 
        		System.out.print(" "+rsmd.getColumnName(i)+" | ");
	    	System.out.println("");
	        while(rs.next())
	        {
	        	for(int i=1;i<a+1;i++) {
	        		System.out.print(" "+rs.getString(i)+" | ");
	        	}	System.out.println("\n");
	        }}
		catch(Exception e)
		{	
			System.out.println(""+e);
		}}
display(String str1,String str2,String str3,String str4)
	{
		try {
			String query="select "+str1+" from "+str2+" where "+str3+"="+"'"+str4+"'";
	        ResultSet rs = DBMS.c.c2(query);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int a=rsmd.getColumnCount();
	    	for(int i=1;i<a+1;i++) 
        		System.out.print(" "+rsmd.getColumnName(i)+" | ");
	    	System.out.println("");
	        while(rs.next())
	        {
	        	for(int i=1;i<a+1;i++) {
	        	System.out.print(" "+rs.getString(i)+" | ");
	        	}System.out.println("\n");
	        }}
		catch(Exception e)
		{
			System.out.println(""+e);
		}}
display(String str1,String str2,String str3,String str4,String str5,String str6)
{
	try {
		String query="select "+str1+" from "+str2+" where "+str3+"="+"'"+str4+"' and "+str5+"="+"'"+str6+"'";
        ResultSet rs = DBMS.c.c2(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int a=rsmd.getColumnCount();
    	for(int i=1;i<a+1;i++) 
    		System.out.print(" "+rsmd.getColumnName(i)+" | ");
    	System.out.println("");
             while(rs.next())
        {
        	
        	for(int i=1;i<a+1;i++) {
        	System.out.print(" "+rs.getString(i)+" | ");
        	}System.out.println("\n");
        }}
	catch(Exception e)
	{
		System.out.println(""+e);
	}}
}
class administrator extends JFrame{
    JFrame	frmadminPage;
    private JPanel contentPane;
public administrator(){
     	login obj=new login(0,"adminstrationlogin");	
     	create();
     	    }
void create() {
	JFrame frmadminPage = new JFrame();
	frmadminPage.setTitle("Admin Home Page");
	frmadminPage.setBounds(100, 100, 727, 725);
	frmadminPage.setBackground(new Color(255, 255, 255));
	frmadminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmadminPage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 231,725);
	frmadminPage.add(side_panels);
	JButton btnProfile = new JButton("Profile");
	btnProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadminPage.dispose();
				profile();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JLabel profile_icon = new JLabel("");
	profile_icon.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\profile.jpg"));
	profile_icon.setBounds(117,1142,68,67);
	side_panels.add(profile_icon);
	JButton	logoutButton = new JButton("");
	logoutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frmadminPage.dispose();
			DBMS myStart_Page=null;	
		    myStart_Page.main(null);
		}});
	logoutButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\logout.png"));
	logoutButton.setBackground(Color.white);
	logoutButton.setBounds(658,0, 51, 42);
	contentPane.add(logoutButton);
	btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 14));
	btnProfile.setBackground(Color.white);
	btnProfile.setBounds(88, 54, 100, 50);
	side_panels.add(btnProfile);
	JLabel welcom_label = new JLabel("Welcome Admin!");
	welcom_label.setForeground(Color.red);
	welcom_label.setFont(new Font("Times New Roman", Font.BOLD, 36));
	welcom_label.setHorizontalAlignment(SwingConstants.CENTER);
	welcom_label.setBounds(255, 60, 399, 90);
	frmadminPage.add(welcom_label);
	JButton adminButton = new JButton(" ");
	adminButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
    		frmadminPage.dispose();
            admindata();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}}});
	adminButton.setBackground(new Color(255, 255, 255));
	adminButton.setForeground(new Color(255, 102, 153));
	adminButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\administrator.jpg"));
	adminButton.setBounds(387, 175, 110, 145);
	frmadminPage.add(adminButton);
	JButton BempButton = new JButton(" ");
	BempButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadminPage.dispose();
				BBempdata();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	BempButton.setBackground(new Color(255, 255, 255));
	BempButton.setForeground(new Color(255, 102, 153));
	BempButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\bbemp.jpg"));
	BempButton.setBounds(377, 355, 139, 140);
	frmadminPage.add(BempButton);
	JButton feedButton = new JButton(" ");
	feedButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadminPage.dispose();
                 feedback();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	feedButton.setBackground(new Color(255, 255, 255));
	feedButton.setForeground(new Color(255, 102, 153));
	feedButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\feedback.png"));
	feedButton.setBounds(380, 529,138, 110);
	frmadminPage.add(feedButton);
	frmadminPage.setVisible(true);
}
void feedback() throws SQLException
{
String Query="Select Q1,Q2,Q3,Q4,Q5,Q6,Q7 from feedback";
int count[][]=new int[7][5];
for(int l=0;l<count.length;l++)
	for(int m=0;m<count[0].length;m++)
		count[l][m]=0;
ResultSet rs=DBMS.c.c2(Query);
while(rs.next())
{
	for(int j=0;j<7;j++) {
	if(rs.getInt(j+1)==5)
	count[j][4]++;
	if(rs.getInt(j+1)==4)
	count[j][3]++;
	if(rs.getInt(j+1)==3)
	count[j][2]++;
	if(rs.getInt(j+1)==2)
	count[j][1]++;
	if(rs.getInt(j+1)==1)
	count[j][0]++;
	}
}
int rating[][]=new int[7][5];
for(int l=0;l<count.length;l++)
	for(int m=0;m<count[0].length;m++)
		rating[l][m]=0;
for(int j=0;j<7;j++)
{int sum=0;
	for(int k=0;k<5;k++) {
	 sum=sum+count[j][k];
		}	
	for(int k=0;k<5;k++) {	
	rating[j][k]=((count[j][k]*100)/sum);}}
graph(rating);
}
static JFrame frmFeedPage = new JFrame();
static JProgressBar b1,b2,b3,b4,b5;
void graph(int rating[][]) {
	frmFeedPage.setTitle("FeedBack Page");
	frmFeedPage.setBounds(100, 190, 1227, 775);
	frmFeedPage.setBackground(new Color(255, 255, 255));
	frmFeedPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmFeedPage.setVisible(true);	
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmFeedPage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 231,725);
	frmFeedPage.add(side_panels);
	JLabel welcom = new JLabel("Analysis of Feedback");
	welcom.setForeground(new Color(220, 20, 60));
	welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
	welcom.setHorizontalAlignment(SwingConstants.CENTER);
	welcom.setBounds(185,10,399,90);
	frmFeedPage.add(welcom);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
      frmFeedPage.dispose();
create();
}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(1160,0, 51, 42);
	contentPane.add(backButton);
    JButton Q1 = new JButton("Question-1");
	Q1.setForeground(Color.black);
	Q1.setBackground(Color.LIGHT_GRAY);
	Q1.setFont(new Font("Arial", Font.PLAIN,18));
	Q1.setHorizontalAlignment(SwingConstants.CENTER);
	Q1.setBounds(520,120,79,90);
	side_panels.add(Q1);
	Q1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JButton Q2 = new JButton("Question-2");
	Q2.setForeground(Color.black);
	Q2.setFont(new Font("Arial", Font.PLAIN,18));
	Q2.setBackground(Color.LIGHT_GRAY);
	Q2.setHorizontalAlignment(SwingConstants.CENTER);
	Q2.setBounds(520,120,79, 90);
	side_panels.add(Q2);
	Q2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[1]);
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JButton Q3 = new JButton("Question-3");
	Q3.setForeground(Color.black);
	Q3.setFont(new Font("Arial", Font.PLAIN,18));
	Q3.setHorizontalAlignment(SwingConstants.CENTER);
	Q3.setBounds(175, 200, 789, 90);
	Q3.setBackground(Color.LIGHT_GRAY);
	side_panels.add(Q3);
	Q3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[2]);
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JButton Q4 = new JButton("Question-4");
	Q4.setForeground(Color.black);
	Q4.setFont(new Font("Arial", Font.PLAIN,18));
	Q4.setHorizontalAlignment(SwingConstants.CENTER);
	Q4.setBounds(149, 257, 789, 90);
	Q4.setBackground(Color.LIGHT_GRAY);
	side_panels.add(Q4);
	Q4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	JButton Q5 = new JButton("Question-5");
	Q5.setForeground(Color.black);
	Q5.setFont(new Font("Arial", Font.PLAIN,18));
	Q5.setHorizontalAlignment(SwingConstants.CENTER);
	Q5.setBounds(99, 310, 789, 90);
	Q5.setBackground(Color.LIGHT_GRAY);
	side_panels.add(Q5);
	Q5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[4]);
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JButton Q6 = new JButton("Question-6");
	Q6.setForeground(Color.black);
	Q6.setFont(new Font("Arial", Font.PLAIN,18));
	Q6.setHorizontalAlignment(SwingConstants.CENTER);
	Q6.setBounds(85, 370, 789, 90);
	Q6.setBackground(Color.LIGHT_GRAY);
	side_panels.add(Q6);
	Q6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[5]);
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JButton Q7 = new JButton("Question-7");
	Q7.setForeground(Color.black);
	Q7.setFont(new Font("Arial", Font.PLAIN,18));
	Q7.setHorizontalAlignment(SwingConstants.CENTER);
	Q7.setBounds(19, 430, 789, 90);
	Q7.setBackground(Color.LIGHT_GRAY);
	side_panels.add(Q7);
	Q7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
		displaygraph(rating[6]);
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	JButton Q8 = new JButton("Suggestions");
	Q8.setForeground(Color.black);
	Q8.setFont(new Font("Arial", Font.PLAIN,18));
	Q8.setHorizontalAlignment(SwingConstants.CENTER);
	Q8.setBounds(19, 430, 789, 90);
	Q8.setBackground(Color.LIGHT_GRAY);
	side_panels.add(Q8);
	Q8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
frmFeedPage.dispose();				
suggestions();
} catch (Exception e) {
				e.printStackTrace();
}}});}
static void displaygraph(int f[])
{
        b1 = new JProgressBar(SwingConstants.VERTICAL);
        b1.setValue(0);
        b1.setStringPainted(true);
        b1.setBounds(300,100,60,300);
        frmFeedPage.add(b1);
        b1.setValue(f[0]);
        b2 = new JProgressBar(SwingConstants.VERTICAL);
        b2.setValue(0);
        b2.setStringPainted(true);
        b2.setBounds(400,100,60,300);
        frmFeedPage.add(b2);
        b2.setValue(f[1]);
        b3 = new JProgressBar(SwingConstants.VERTICAL);
        b3.setValue(0);
        b3.setStringPainted(true);
        b3.setBounds(500,100,60,300);
        frmFeedPage.add(b3);
        b3.setValue(f[2]);
        b4 = new JProgressBar(SwingConstants.VERTICAL);
        b4.setValue(0);
        b4.setStringPainted(true);
        b4.setBounds(600,100,60,300);
        frmFeedPage.add(b4);
        b4.setValue(f[3]);
        b5 = new JProgressBar(SwingConstants.VERTICAL);
        b5.setValue(0);
        b5.setStringPainted(true);
        b5.setBounds(700,100,60,300);
        frmFeedPage.add(b5);
        b5.setValue(f[4]);
           }
void suggestions() throws SQLException{
	JFrame frmFeedPage = new JFrame();
	frmFeedPage.setTitle("FeedBack Page");
	frmFeedPage.setBounds(100, 190, 1227, 775);
	frmFeedPage.setBackground(new Color(255, 255, 255));
	frmFeedPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmFeedPage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JLabel suggestion_label = new JLabel("Suggestions");
	suggestion_label.setForeground(new Color(220, 20, 60));
	suggestion_label.setFont(new Font("Times New Roman", Font.BOLD,30));
	suggestion_label.setHorizontalAlignment(SwingConstants.CENTER);
	suggestion_label.setBounds(165,10,399,90);
	frmFeedPage.add(suggestion_label);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		frmFeedPage.dispose();
		try {
			feedback();
		} catch (SQLException e) {
			e.printStackTrace();
		}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(1160,0, 51, 42);
	contentPane.add(backButton);
	JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 231,725);
	frmFeedPage.add(side_panels);
	String query="select Q8 from feedback";
    ResultSet rs = DBMS.c.c2(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    String query2="SELECT COUNT(*) FROM feedback";
    ResultSet rs1 = DBMS.c.c2(query2);
    int b=0;
	try {
		if(rs1.next())
		b = rs1.getInt(1);
	} catch (SQLException e) {
		e.printStackTrace();}
    String suggestions[][]=new String [b][1];
    int j=0;
    while(rs.next())
    {
    	for(int i=1;i<2;i++) {
			int type=rsmd.getColumnType(i);
			if(type == Types.VARCHAR)
				suggestions[j][i-1]=rs.getString(i);
      		    	}	
    	j++;
    }
    int k=160;
    for(int i=0;i<b;i++) {
	JLabel suggestion = new JLabel(suggestions[i][0]);
	suggestion.setForeground(Color.black);
	suggestion.setFont(new Font("Arial", Font.PLAIN,18));
	suggestion.setHorizontalAlignment(SwingConstants.CENTER);
	suggestion.setBounds(55, k, 899, 90);
	frmFeedPage.add(suggestion);
	k=k+70;
	frmFeedPage.setVisible(true);
	}}
void profile() throws SQLException
{
	JFrame frmProfilePage = new JFrame();
	frmProfilePage.setTitle("Profile Page");
	frmProfilePage.setBounds(100, 100, 727, 725);
	frmProfilePage.setBackground(new Color(255, 255, 255));
	frmProfilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmProfilePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	frmProfilePage.setVisible(true);
	contentPane.setVisible(true);
	JLabel ProfilePagePhoto = new JLabel("");
	ProfilePagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	ProfilePagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	ProfilePagePhoto.setBounds(0,0,820,820);
	JButton backButton = new JButton(" ");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
				frmProfilePage.dispose();
         create();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	backButton.setBackground(new Color(255, 255, 255));
	backButton.setForeground(new Color(255, 102, 153));
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBounds(12, 13, 43, 42);
	contentPane.add(backButton);
	JLabel Name_label = new JLabel("Name");
	Name_label.setHorizontalAlignment(SwingConstants.CENTER);
	Name_label.setForeground(new Color(220, 20, 60));
	Name_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Name_label.setBounds(486,159,159, 68);
	contentPane.add(Name_label);	
	JLabel Mail_label = new JLabel("Mail");
	Mail_label.setHorizontalAlignment(SwingConstants.CENTER);
	Mail_label.setForeground(new Color(220, 20, 60));
	Mail_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Mail_label.setBounds(396,453,369, 68);
	contentPane.add(Mail_label);
	JLabel PhoneNum_label = new JLabel("Phone number");
	PhoneNum_label.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNum_label.setForeground(new Color(220, 20, 60)); 
	PhoneNum_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	PhoneNum_label.setBounds(396,339,369,68);
	contentPane.add(PhoneNum_label);
	JLabel Designation_label = new JLabel("Designation");
	Designation_label.setHorizontalAlignment(SwingConstants.CENTER);
	Designation_label.setForeground(new Color(220,20,60));
	Designation_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Designation_label.setBounds(336,200,502,160);
	contentPane.add(Designation_label);
	JLabel NameFixed = new JLabel("Name:");
	NameFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	NameFixed.setForeground(new Color(255, 255, 255));
	NameFixed.setHorizontalAlignment(SwingConstants.CENTER);
	NameFixed.setBounds(46, 151, 369, 68);
	contentPane.add(NameFixed);	
	JLabel MailFixed = new JLabel("Mail ID:");
	MailFixed.setHorizontalAlignment(SwingConstants.CENTER);
	MailFixed.setForeground(Color.WHITE);
	MailFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	MailFixed.setBounds(46, 451, 369, 68);
	contentPane.add(MailFixed);
	JLabel PhoneNumberFixed = new JLabel("Phone Number:");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	PhoneNumberFixed.setBounds(46, 336, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JLabel DesignationFixed = new JLabel("Designation:");
	DesignationFixed.setHorizontalAlignment(SwingConstants.CENTER);
	DesignationFixed.setForeground(Color.WHITE);
	DesignationFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	DesignationFixed.setBounds(46, 245, 369, 68);
	contentPane.add(DesignationFixed);
	JLabel profile_label = new JLabel("Profile");
	profile_label.setHorizontalAlignment(SwingConstants.CENTER);
	profile_label.setForeground(Color.BLACK);
	profile_label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
	profile_label.setBounds(190,0, 369, 68);
	contentPane.add(profile_label);
    String query ="select * from adminstratordata where ID = '"+DBMS.userid+"'";
    ResultSet rs= DBMS.c.c2(query);
	    while(rs.next()) {
	        Name_label.setText(String.valueOf(rs.getString(2)));
	    	Mail_label.setText(String.valueOf(rs.getString(5)));
	    	PhoneNum_label.setText(String.valueOf(rs.getString(4)));
	    	Designation_label.setText(String.valueOf(rs.getString(3)));
	        }
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmProfilePage.dispose();
				updatedetails();
			} catch (Exception e) {
			}}});
	frmProfilePage.add(ProfilePagePhoto);}
void updatedetails() throws SQLException
{
	JFrame frmadminupdatePage = new JFrame();
	frmadminupdatePage.setTitle("Update details");
	frmadminupdatePage.setBounds(100, 100, 727, 725);
	frmadminupdatePage.setBackground(new Color(255, 255, 255));
	frmadminupdatePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmadminupdatePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JButton backButton = new JButton(" ");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				dispose();
create();
} catch (Exception e) {
				e.printStackTrace();
			}}});
	backButton.setBackground(new Color(255, 255, 255));
	backButton.setForeground(new Color(255, 102, 153));
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBounds(12, 13, 43, 42);
	contentPane.add(backButton);
	JLabel ProfilePagePhoto = new JLabel("");
	ProfilePagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	ProfilePagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	ProfilePagePhoto.setBounds(0,0,820,820);
	String roles[]={"Position","Mobile","Mail"};        
	final JComboBox updatelabel=new JComboBox(roles);
	updatelabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	updatelabel.setBackground(new Color(245, 245, 245));
	updatelabel.setBounds(389, 188, 234, 41);
	contentPane.add(updatelabel);
	JTextField updated = new JTextField();
    updated.setBounds(389, 288, 172, 41);
    frmadminupdatePage.add(updated);
    JLabel UserIDFixed = new JLabel("Field");
	UserIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	UserIDFixed.setForeground(Color.WHITE);
	UserIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	UserIDFixed.setBounds(46, 173, 369, 68);
	contentPane.add(UserIDFixed);
	JLabel PhoneNumberFixed = new JLabel("New value");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	PhoneNumberFixed.setBounds(46, 273, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadminupdatePage.dispose();
			    String query="Update adminstratordata set "+String.valueOf(updatelabel.getSelectedItem())+"='"+String.valueOf(updated.getText())+"'where ID='"+DBMS.userid+"'";
				PreparedStatement stmt=DBMS.c.c1(query);
				stmt.execute();
				JOptionPane myOption = new JOptionPane();
				myOption.showMessageDialog(null, "Details Updated successfully");
			create();
			} catch (Exception e) {				
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "Unable to Update details successfully\nTry after some Time");
			System.out.print(e);
		create();
		}}
	});
contentPane.add(ProfilePagePhoto);
frmadminupdatePage.dispose();
frmadminupdatePage.setVisible(true);
}
void admindata() throws SQLException {
	JFrame frmadmindata = new JFrame();
	frmadmindata.setTitle("Administrator Data Page");
	frmadmindata.setBounds(100, 100, 727, 725);
	frmadmindata.setBackground(new Color(255, 255, 255));
	frmadmindata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(Color.white);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmadmindata.setContentPane(contentPane);
	contentPane.setLayout(null);
	JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 131,725);
	frmadmindata.add(side_panels);
	JButton btnProfile = new JButton("Profile");
	btnProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadmindata.dispose();
				profile();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 14));
	btnProfile.setBackground(Color.white);
	btnProfile.setBounds(88, 54, 100, 50);
	side_panels.add(btnProfile);
	JLabel profile_icon = new JLabel("");
	profile_icon.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\profile.jpg"));
	profile_icon.setBounds(117,1142,68,67);
	side_panels.add(profile_icon);
	String query= "Select * from adminstratordata";
	ResultSet	 rs= DBMS.c.c2(query);
    JTable table = new JTable(buildTableModel(rs));
    table.setBounds(185,150,500,100);
    frmadmindata.add(table);
	JLabel welcom = new JLabel("Administrator Data");
	welcom.setForeground(Color.blue);
	welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
	welcom.setHorizontalAlignment(SwingConstants.CENTER);
	welcom.setBounds(70,10,399,90);
	JLabel fields = new JLabel("ID                Name             Designation             Mobile              Mail");
	fields.setForeground(Color.red);
	fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
	fields.setHorizontalAlignment(SwingConstants.CENTER);
	fields.setBounds(135,100,600,90);
	frmadmindata.add(fields);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frmadmindata.dispose();
		create();
		}
	});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(658,0, 51, 42);
	contentPane.add(backButton);
	frmadmindata.add(welcom);
	JButton quote = new JButton("");
	quote.setBackground(new Color(255, 255, 255));
	quote.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\donate-blood-and-save-life-isolated-icon-vector-26547407.jpg"));
	quote.setBounds(250,330,300,200);
	contentPane.add(quote);
	frmadmindata.setVisible(true);
	}
void BBempdata() throws SQLException {
	JFrame frmBBempdata = new JFrame();
	frmBBempdata.setTitle("Blood Bank Employee Data");
	frmBBempdata.setBounds(100, 90, 727, 705);
	frmBBempdata.setBackground(new Color(255, 255, 255));
	frmBBempdata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(Color.white);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmBBempdata.setContentPane(contentPane);
	contentPane.setLayout(null);
	String query= "Select * from employdata";
	ResultSet rs=DBMS.c.c2(query);
	JButton quote = new JButton("");
	quote.setBackground(Color.red);
	quote.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\TAGLINE.png"));
	quote.setBounds(0,0,135,725);
	contentPane.add(quote);
    JTable table = new JTable(buildTableModel(rs));
    table.setBounds(185,130,500,200);
    frmBBempdata.add(table);
	JLabel welcom = new JLabel("Blood Bank Employee Data");
	welcom.setForeground(Color.blue);
	welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
	welcom.setHorizontalAlignment(SwingConstants.CENTER);
	welcom.setBounds(120,10,399,90);
	JLabel fields = new JLabel("ID                BBID              Name             Mobile             Mail              City");
	fields.setForeground(Color.red);
	fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
	fields.setHorizontalAlignment(SwingConstants.CENTER);
	fields.setBounds(135,77,600,90);
	frmBBempdata.add(fields);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frmBBempdata.dispose();
	create();	}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(658,0, 51, 42);
	contentPane.add(backButton);
	frmBBempdata.add(welcom);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(319, 550, 160, 48);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempdata.dispose();
				updateBBempdetails();
			} catch (Exception e) {
			}}});
	frmBBempdata.setVisible(true);
}
void updateBBempdetails() throws IOException {
 	JFrame frmBBempupdatePage = new JFrame();
 	frmBBempupdatePage.setTitle("BBEmployee Update Details");
 	frmBBempupdatePage.setBounds(100, 100, 727, 725);
 	frmBBempupdatePage.setBackground(Color.gray);
 	frmBBempupdatePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(Color.lightGray);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmBBempupdatePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\blood bank image.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	frmBBempupdatePage.add(picLabel);
	picLabel.setBounds(0, 0, 181,725);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	    frmBBempupdatePage.dispose();
create();
}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(658,0, 51, 42);
	contentPane.add(backButton);
	JButton addDataButton = new JButton("");
	addDataButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
               addBBempdata();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	addDataButton.setBackground(new Color(255, 255, 255));
	addDataButton.setForeground(new Color(255, 102, 153));
	addDataButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\addbbemp.png"));
	addDataButton.setBounds(355, 115, 140, 145);
	frmBBempupdatePage.add(addDataButton);
	JButton DeletedataButton = new JButton("");
	DeletedataButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
				DeleteBBempdata();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	DeletedataButton.setBackground(new Color(255, 255, 255));
	DeletedataButton.setForeground(new Color(255, 102, 153));
	DeletedataButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\datadelete.png"));
	DeletedataButton.setBounds(355, 295, 140, 145);
	frmBBempupdatePage.add(DeletedataButton);
	JButton UpdateButton = new JButton(" ");
	UpdateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
				updateBBEMPdetails();
				} catch (Exception e) {
				e.printStackTrace();
			}}});
	UpdateButton.setBackground(new Color(255, 255, 255));
	UpdateButton.setForeground(new Color(255, 102, 153));
	UpdateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\data_edit.png"));
	UpdateButton.setBounds(355, 469,140, 145);
	frmBBempupdatePage.add(UpdateButton);
	frmBBempupdatePage.setVisible(true);
	}
void addBBempdata()
{
	JFrame signup = new JFrame();
	signup.setTitle("Signup Page");
	signup.setBounds(100, 200,990, 725);
	signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	signup.getContentPane().setLayout(null);
	JPanel panel = new JPanel();
	panel.setBackground(new Color(220, 20, 60));
	panel.setBounds(0, 0, 1100, 58);
	signup.add(panel);
	panel.setLayout(null);
	JButton backButton = new JButton();
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			signup.dispose();
try {
	BBempdata();
} catch (SQLException e) {
	e.printStackTrace();
}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(new Color(220, 20, 60));
	backButton.setBounds(12, 13, 51, 42);
	panel.add(backButton);
	JTextField nameField = new JTextField();
	nameField.setBounds(122, 89, 272, 41);
	signup.add(nameField);
	nameField.setColumns(10);
	JTextField phonenumberField = new JTextField();
	phonenumberField.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
				e.consume();
			}}});
	phonenumberField.setColumns(10);
	phonenumberField.setBounds(439, 336, 195, 41);
	signup.add(phonenumberField);
	JLabel nameLabel = new JLabel("Name");
	nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	nameLabel.setBounds(12, 91, 69, 35);
	signup.add(nameLabel);
    JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	passwordLabel.setBounds(12, 161, 92, 35);
	signup.add(passwordLabel);
	JLabel	phonenumberLabel = new JLabel("Phone number");
 	phonenumberLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	phonenumberLabel.setBounds(288, 336, 134, 39);
	signup.add(phonenumberLabel);
	JLabel	Mail = new JLabel("Mail");
	Mail.setFont(new Font("Tahoma", Font.BOLD, 18));
	Mail.setBounds(12, 336, 100, 35);
	signup.add(Mail);
	JLabel	Address_Label = new JLabel("Address");
	Address_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
	Address_Label.setBounds(12, 259, 146, 35);
	signup.add(Address_Label);
    JPasswordField	passwordField = new JPasswordField();
	passwordField.setBounds(122, 159, 272, 41);
	signup.add(passwordField);
    JTextField UserID = new JTextField();
    UserID.setBounds(437, 259, 172, 41);
	signup.add(UserID);
    JLabel UserID_Label = new JLabel("User ID");
    UserID_Label.setFont(new Font("Tahoma", Font.BOLD, 18));
    UserID_Label.setBounds(342, 259, 128, 35);
	signup.add(UserID_Label);
    JLabel confirmpasswordLabel = new JLabel("Confirm Password");
	confirmpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	confirmpasswordLabel.setBounds(422, 161, 164, 39);
	signup.add(confirmpasswordLabel);
	JPasswordField confirmpasswordField = new JPasswordField();
	confirmpasswordField.setBounds(595, 161, 272, 41);
	signup.add(confirmpasswordField);
   JTextField Address = new JTextField();
   Address.setBounds(102, 259, 172, 41);
   signup.add(Address);
   JTextField mailfield = new JTextField();
   mailfield.setBounds(102, 336, 172, 41);
   signup.add(mailfield);
   JButton signupButton = new JButton("Sign up");
	signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	signupButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(passwordField.getText().isEmpty() || confirmpasswordField.getText().isEmpty() || nameField.getText().isEmpty() || phonenumberField.getText().isEmpty()) {
				JOptionPane myOption = new JOptionPane();
		    	myOption.showMessageDialog(null, "Field can not be empty");
			}else if (String.valueOf(passwordField.getPassword()).equals(confirmpasswordField.getPassword())) {
				JOptionPane myOption = new JOptionPane();
		    	myOption.showMessageDialog(null, "Your passwords are not the same");
			}else if(phonenumberField.getText().length() > 10 || phonenumberField.getText().length() < 10) {
				JOptionPane myOption = new JOptionPane();
		    	myOption.showMessageDialog(null, "Enter a valid phone number");
			}	
			Random random=new Random();
			int num = random.nextInt(99999) + 10000;
String query="insert into BEmployLOGIN values(?,?)";
PreparedStatement stmt = DBMS.c.c1(query);
try {
 String snum="B"+String.valueOf(UserID.getText());
stmt.setString(1, String.valueOf(snum));
stmt.setString(2, String.valueOf(passwordField.getText()));
stmt.executeUpdate();}
catch (SQLException e1) {
	e1.printStackTrace();
}
query="insert into EmployDATA values(?,?,?,?,?,?)";
PreparedStatement stmt1 = DBMS.c.c1(query);
try {
String snum="B"+String.valueOf(UserID.getText());
stmt1.setString(1, String.valueOf(snum));
stmt1.setString(2, String.valueOf(num));
stmt1.setString(3, String.valueOf(nameField.getText()));
stmt1.setString(4, String.valueOf(phonenumberField.getText()));
stmt1.setString(5, String.valueOf(mailfield.getText()));
stmt1.setString(6, String.valueOf(Address.getText()));
stmt1.executeUpdate();
stmt1.close();
JOptionPane myOption = new JOptionPane();
myOption.showMessageDialog(null, "Added Up Successfully\n your Blood Bank ID is " + num);
signup.dispose();
BBempdata();
} 
catch (SQLException e1) {
e1.printStackTrace();
}}});
	signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\signup1.png"));
	signupButton.setBounds(405, 600, 100, 50);
		signup.add(signupButton);
signup.setVisible(true);
	}
void DeleteBBempdata() throws SQLException {
	 JFrame Deletedata = new JFrame();
	 Deletedata.setTitle("Signup Page");
	 Deletedata.setBounds(100, 200,720, 725);
	 Deletedata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Deletedata.getContentPane().setLayout(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Deletedata.setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel side_panels = new JPanel();
   	side_panels.setBackground(new Color(220, 20, 60));
   	side_panels.setBounds(0, 0, 151,725);
   	Deletedata.add(side_panels);
	String query= "Select * from employdata";
		ResultSet rs= DBMS.c.c2(query);
	    JTable table = new JTable(buildTableModel(rs));
	    table.setBounds(185,130,500,200);
	    Deletedata.add(table);
		JLabel welcom = new JLabel("Blood Bank Employee Data");
		welcom.setForeground(Color.blue);
		welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
		welcom.setHorizontalAlignment(SwingConstants.CENTER);
		welcom.setBounds(130,10,399,90);
		JTextField UserIDField = new JTextField();
       UserIDField.setBounds(425,500 ,100,30);
       Deletedata.add(UserIDField);
       JLabel UserID = new JLabel("Enter the User ID");
		UserID.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserID.setBounds(205,500,164,30);
		Deletedata.add(UserID);
		JLabel fields = new JLabel("ID                BBID              Name             Mobile             Mail              City");
		fields.setForeground(Color.red);
		fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
		fields.setHorizontalAlignment(SwingConstants.CENTER);
		fields.setBounds(135,77,600,90);
		Deletedata.add(fields);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deletedata.dispose();
try {
	BBempdata();
} catch (SQLException e) {
	e.printStackTrace();
}		
}
		});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(658,0, 51, 42);
		contentPane.add(backButton);
		Deletedata.add(welcom);
		Deletedata.setVisible(true);
	       JButton signupButton = new JButton("Sign up");
  		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
  		signupButton.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				try {
  		String Query1="Delete from bemploylogin where ID ='"+UserIDField.getText()+"'";	
  		String Query2="Delete from employdata where ID ='"+UserIDField.getText()+"'";	
      PreparedStatement stmt = DBMS.c.c1(Query1);       				
stmt.execute();
stmt=DBMS.c.c1(Query2);
stmt.execute();	
Deletedata.dispose();
JOptionPane myOption = new JOptionPane();
myOption.showMessageDialog(null, "Details Deleted successfully");
BBempdata();
  				}
  				catch(Exception E)
  				{
  					JOptionPane myOption = new JOptionPane();
  					myOption.showMessageDialog(null, "Unable to Delete");
}}});
  	            signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\deleteicon.jpg"));
  	            signupButton.setBounds(380, 600, 90, 50);
  	    		Deletedata.add(signupButton);      				
}
void updateBBEMPdetails() throws SQLException
{
	JFrame frmBBempupdatePage = new JFrame();
	frmBBempupdatePage.setTitle("Update details");
	frmBBempupdatePage.setBounds(100, 100, 727, 725);
	frmBBempupdatePage.setBackground(new Color(255, 255, 255));
	frmBBempupdatePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmBBempupdatePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JButton backButton = new JButton(" ");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
               BBempdata();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	backButton.setBackground(new Color(255, 255, 255));
	backButton.setForeground(new Color(255, 102, 153));
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBounds(12, 13, 43, 42);
	contentPane.add(backButton);
	JLabel StartPagePhoto1 = new JLabel("");
	StartPagePhoto1.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	StartPagePhoto1.setHorizontalAlignment(SwingConstants.CENTER);
	StartPagePhoto1.setBounds(0,0,820,820);
	String roles[]={"Name","MobileNo","Mail"};        
	final JComboBox updatelabel=new JComboBox(roles);
	updatelabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	updatelabel.setBackground(new Color(245, 245, 245));
	updatelabel.setBounds(389, 188, 234, 41);
	contentPane.add(updatelabel);
	JTextField userid = new JTextField();
    userid.setBounds(389, 88, 172, 41);
    frmBBempupdatePage.add(userid);
    JLabel UserIDlabel = new JLabel("Enter the userid");
    UserIDlabel.setHorizontalAlignment(SwingConstants.CENTER);
    UserIDlabel.setForeground(Color.WHITE);
    UserIDlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
    UserIDlabel.setBounds(46, 73, 369, 68);
	contentPane.add(UserIDlabel);
	JTextField updated = new JTextField();
    updated.setBounds(389, 288, 172, 41);
    frmBBempupdatePage.add(updated);
    JLabel FieldFixed = new JLabel("Field");
    FieldFixed.setHorizontalAlignment(SwingConstants.CENTER);
    FieldFixed.setForeground(Color.WHITE);
    FieldFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
    FieldFixed.setBounds(46, 173, 369, 68);
	contentPane.add(FieldFixed);
	JLabel NewvalueFixed = new JLabel("New value");
	NewvalueFixed.setHorizontalAlignment(SwingConstants.CENTER);
	NewvalueFixed.setForeground(Color.WHITE);
	NewvalueFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	NewvalueFixed.setBounds(46, 273, 369, 68);
	contentPane.add(NewvalueFixed);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
			    String query="Update Employdata set "+String.valueOf(updatelabel.getSelectedItem())+"= '"+updated.getText()+"' where ID= '"+userid.getText()+"'";
				PreparedStatement stmt=DBMS.c.c1(query);
				stmt.execute();
				JOptionPane myOption = new JOptionPane();
				myOption.showMessageDialog(null, "Details Updated successfully");
				try {
					BBempdata();
				} catch (SQLException e1) {
					e1.printStackTrace();
					myOption.showMessageDialog(null, "Unable to Update details successfully");
				}} catch (Exception e) {				
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "Unable to Update details successfully");
			try {
				BBempdata();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}}});
contentPane.add(StartPagePhoto1);
frmBBempupdatePage.dispose();
frmBBempupdatePage.setVisible(true);
}
public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }
    return new DefaultTableModel(data, columnNames);
}}
class bloodbankemployee{
	String BID;
	bloodbankemployee() throws SQLException{
		login obj=new login(0,"BEMPLOYLOGIN");	
		create();
}
	void create() throws SQLException {
		String query="select BID from employdata where ID = '"+DBMS.userid+"'";
		ResultSet rs=DBMS.c.c2(query);
		if(rs.next())
		BID=String.valueOf(rs.getString(1));
	 	JFrame frmbbempPage = new JFrame();
	 	frmbbempPage.setTitle("Blood Bank Employee Home Page");
	 	frmbbempPage.setBounds(100, 250, 727, 775);
	 	frmbbempPage.setBackground(new Color(255, 255, 255));
	 	frmbbempPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmbbempPage.setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel side_panels = new JPanel();
		side_panels.setBackground(new Color(220, 20, 60));
		side_panels.setBounds(0, 0, 231,725);
		frmbbempPage.add(side_panels);
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmbbempPage.dispose();
			    	profile();
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		JLabel profile_icon = new JLabel("");
		profile_icon.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\profile.jpg"));
		profile_icon.setBounds(117,1142,59,67);
		side_panels.add(profile_icon);
		JButton	logoutButton = new JButton("");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmbbempPage.dispose();
				DBMS myStart_Page=null;	
				myStart_Page.main(null);
			}});
		logoutButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\logout.png"));
		logoutButton.setBackground(Color.white);
		logoutButton.setBounds(658,0, 51, 42);
		contentPane.add(logoutButton);
		btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnProfile.setBackground(Color.white);
		btnProfile.setBounds(88, 54, 100, 50);
		side_panels.add(btnProfile);
		JLabel welcom_label = new JLabel("Welcome Employee!");
		welcom_label.setForeground(Color.red);
		welcom_label.setFont(new Font("Times New Roman", Font.BOLD, 36));
		welcom_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcom_label.setBounds(285, 60, 399, 90);
		frmbbempPage.add(welcom_label);
		JButton bbempButton = new JButton(" ");
		bbempButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
	    		frmbbempPage.dispose();
	           BBempdata();
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		bbempButton.setBackground(new Color(255, 255, 255));
		bbempButton.setForeground(new Color(255, 102, 153));
		bbempButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\bbemp.jpg"));
		bbempButton.setBounds(387, 175, 138, 145);
		frmbbempPage.add(bbempButton);
		JButton bloodButton = new JButton(" ");
		bloodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		    		frmbbempPage.dispose();
			           Blooddata();
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	    bloodButton.setBackground(new Color(255, 255, 255));
	    bloodButton.setForeground(new Color(255, 102, 153));
	    bloodButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\bloodpacets.jpeg"));
	    bloodButton.setBounds(357, 345, 200, 160);
		frmbbempPage.add(bloodButton);
		JButton BDnonorButton = new JButton(" ");
		BDnonorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmbbempPage.dispose();
                    blooddonordata();	            
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		BDnonorButton.setBackground(new Color(255, 255, 255));
		BDnonorButton.setForeground(new Color(255, 102, 153));
		BDnonorButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\donor.png"));
		BDnonorButton.setBounds(380,529,165,200);
		frmbbempPage.add(BDnonorButton);
		frmbbempPage.setVisible(true);
	}
	void BBempdata() throws SQLException {
		JFrame frmadmindata = new JFrame();
		frmadmindata.setTitle("Blood Bank Employee Data");
		frmadmindata.setBounds(100, 90, 727, 705);
		frmadmindata.setBackground(new Color(255, 255, 255));
		frmadmindata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmadmindata.setContentPane(contentPane);
		contentPane.setLayout(null);
		String query= "Select * from employdata";
		ResultSet rs=DBMS.c.c2(query);
		JButton quote = new JButton("");
		quote.setBackground(Color.red);
		quote.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\TAGLINE.png"));
		quote.setBounds(0,0,135,725);
		contentPane.add(quote);
	    JTable table = new JTable(buildTableModel(rs));
	    table.setBounds(185,130,500,200);
		frmadmindata.add(table);
		JLabel welcom = new JLabel("Blood Bank Employee Data");
		welcom.setForeground(Color.blue);
		welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
		welcom.setHorizontalAlignment(SwingConstants.CENTER);
		welcom.setBounds(120,10,399,90);
		JLabel fields = new JLabel("ID                BBID              Name             Mobile             Mail              City");
		fields.setForeground(Color.red);
		fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
		fields.setHorizontalAlignment(SwingConstants.CENTER);
		fields.setBounds(135,77,600,90);
		frmadmindata.add(fields);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmadmindata.dispose();
				try {
create();
} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(658,0, 51, 42);
		contentPane.add(backButton);
		frmadmindata.add(welcom);
frmadmindata.setVisible(true);
	}
void Blooddata() throws IOException {
	JFrame frmbloodPage = new JFrame();
 	frmbloodPage.setTitle("Blood Bank Employee Home Page");
 	frmbloodPage.setBounds(100, 250, 727, 775);
 	frmbloodPage.setBackground(new Color(255, 255, 255));
 	frmbloodPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmbloodPage.setContentPane(contentPane);
	contentPane.setLayout(null);
	BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote1.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	frmbloodPage.add(picLabel);
	picLabel.setBounds(0, 0, 181,725);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frmbloodPage.dispose();
			try {
            create();
			} catch (SQLException e) {
				e.printStackTrace();
			}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(658,0, 51, 42);
	contentPane.add(backButton);
	JButton	ADDBloodButton = new JButton("ADD Blood");
	ADDBloodButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		  frmbloodPage.dispose();
       try {
		ADDblood();
	} catch (SQLException e) {
		e.printStackTrace();
	}}});
	ADDBloodButton. setFont(new Font("Arial", Font. PLAIN, 18));
	ADDBloodButton.setBackground(Color.RED);
	ADDBloodButton.setBounds(370,210,151,42);
	contentPane.add(ADDBloodButton);
	JButton	removeBloodButton = new JButton("Remove Blood");
	removeBloodButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			 frmbloodPage.dispose();
	try {
		removeblood();
	} catch (SQLException e) {
		e.printStackTrace();
	}}});
	removeBloodButton. setFont(new Font("Arial", Font. PLAIN, 18));
	removeBloodButton.setBackground(Color.RED);
	removeBloodButton.setBounds(370,270,151, 42);
	contentPane.add(removeBloodButton);
	JButton	DisplayBloodButton = new JButton("Display Blood Data");
	DisplayBloodButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	try {
		displayblooddata();
	} catch (SQLException e) {
		e.printStackTrace();
	}}});
	DisplayBloodButton.setFont(new Font("Arial", Font. PLAIN, 16));
	DisplayBloodButton.setBackground(Color.RED);
	DisplayBloodButton.setBounds(370,330,151, 42);
	contentPane.add(DisplayBloodButton);
	JButton	UpdateBloodButton = new JButton("Update Blood Data");
	UpdateBloodButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		updatelist();
		}});
	UpdateBloodButton. setFont(new Font("Arial", Font. PLAIN, 16));
	UpdateBloodButton.setBackground(Color.RED);
	UpdateBloodButton.setBounds(370,390,151, 42);
	contentPane.add(UpdateBloodButton);
    frmbloodPage.setVisible(true);
}
void ADDblood() throws SQLException {
    JFrame removeblood = new JFrame();
    removeblood.setTitle("Signup Page");
    removeblood.setBounds(100, 200,920, 725);
    removeblood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    removeblood.getContentPane().setLayout(null);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(Color.white);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	removeblood.setContentPane(contentPane);
	contentPane.setLayout(null);
	JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 151,725);
	removeblood.add(side_panels);
    String query= "Select * from Bdonor where BID='"+BID+"'";
    ResultSet rs= DBMS.c.c2(query);
    JTable table = new JTable(buildTableModel(rs));
    table.setBounds(185,130,700,200);
    removeblood.add(table);
	JLabel welcom = new JLabel("Blood Bank Donor Data");
	welcom.setForeground(Color.blue);
	welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
	welcom.setHorizontalAlignment(SwingConstants.CENTER);
	welcom.setBounds(130,10,399,90);
	JTextField UserIDField = new JTextField();
    UserIDField.setBounds(445,400 ,100,30);
    removeblood.add(UserIDField);
    JLabel UserID = new JLabel("Enter the User ID");
	UserID.setFont(new Font("Tahoma", Font.BOLD, 18));
	UserID.setBounds(218,400,164,30);
	removeblood.add(UserID);
	JLabel fields = new JLabel("   BBID         BDID         Blood Grp        Name             Age          Address             Mobile        Gender          LDD");
	fields.setForeground(Color.red);
	fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
	fields.setHorizontalAlignment(SwingConstants.CENTER);
	fields.setBounds(135,71,800,90);
	removeblood.add(fields);
	JButton NewButton = new JButton("If new Donor Click here");
	NewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		signup() ;
		}});		
	NewButton.setFont(new Font("Arial", Font. PLAIN, 16));
	NewButton.setBackground(Color.cyan);
	NewButton.setBounds(295,480,201,42);
	contentPane.add(NewButton);
    JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			removeblood.dispose();
			try {
				Blooddata();
			} catch (IOException e) {
				e.printStackTrace();
			}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(860,0, 51, 42);
	contentPane.add(backButton);
	removeblood.add(welcom);
	removeblood.setVisible(true);
       JButton signupButton = new JButton("Sign up");
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long millis=System.currentTimeMillis();  
				java.sql.Date date=new java.sql.Date(millis); 
				String query="Select ldd from blodddonordata where BDID = "+String.valueOf(UserIDField.getText());
			    String grp=null;
			    Date date1=null;
				 ResultSet rs=DBMS.c.c2(query);
						try {
							while(rs.next())
								date1=rs.getDate(1);
						} catch (Exception e1) {
							System.out.println(""+e1);
						}
				long duration  = date.getTime() - date1.getTime();
				int numofDays = (int) (duration / (1000 * 60 * 60 * 24));
				if(numofDays<56)//as per biological norms a person cannot donate blood before 56 days from his last donation
			{
					JOptionPane myOption = new JOptionPane();
					myOption.showMessageDialog(null, "He is not applicable from donation as he donated blood "+numofDays+" ago");
			try {
create();
} catch (SQLException e1) {
e1.printStackTrace();
}}
			  query="Select Bgrp from blodddonordata where BDID = "+String.valueOf(UserIDField.getText());
			    ResultSet rs1=DBMS.c.c2(query);
			   		try {
			   			while(rs1.next())
						 grp=rs1.getString(1);
						} catch (Exception e3) {
			         System.out.println(""+e3);
						}
			      query = "UPDATE Blooddata SET "+grp+" = "+grp+" + 1 WHERE BID = '"+BID+"'";
			      PreparedStatement stmt=DBMS.c.c1(query);
						try {
							stmt.execute();
						} catch (Exception e2) {
							System.out.println(""+e2);
						}
						  query = "UPDATE Blodddonordata SET LDD = '"+date+"',LDD1 = '"+date+"',LDD2 = '"+date+"'  WHERE BDID = '"+String.valueOf(UserIDField.getText())+"'";
					       stmt=DBMS.c.c1(query);
								try {
									stmt.execute();
									JOptionPane myOption = new JOptionPane();
									myOption.showMessageDialog(null, "Blood data added successfully");							
								} catch (Exception e4) {
									System.out.println(""+e4);
								}
			}});
	            signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\next.png"));
	            signupButton.setBounds(350, 600,120, 50);
	    		removeblood.add(signupButton);      				
}
void removeblood() throws SQLException
{
	 JFrame removeblood = new JFrame();
	 removeblood.setTitle("remove Blood");
	 removeblood.setBounds(100, 200,720, 725);
	 removeblood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 removeblood.getContentPane().setLayout(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		removeblood.setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel side_panels = new JPanel();
 	side_panels.setBackground(new Color(220, 20, 60));
 	side_panels.setBounds(0, 0, 151,725);
 	removeblood.add(side_panels);
	String[] Bloodgropus = {"ABpositive", "ABnegative", "Bpositive", "Bnegative","Opositive","Onegative","HH"};
	JComboBox bloodtype_comboBox = new JComboBox(Bloodgropus);
	bloodtype_comboBox.setBackground(new Color(255, 255, 255));
	bloodtype_comboBox.setBounds(425,500 ,100,30);
    removeblood.add(bloodtype_comboBox);
	String query= "Select * from blooddata where BID="+BID;
	ResultSet rs= DBMS.c.c2(query);
   JTable table = new JTable(buildTableModel(rs));
	    table.setBounds(185,130,350,200);
	    removeblood.add(table);
		JLabel welcom = new JLabel("Blood Data");
		welcom.setForeground(Color.blue);
		welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
		welcom.setHorizontalAlignment(SwingConstants.CENTER);
		welcom.setBounds(35,10,399,90);
     JLabel UserID = new JLabel("Choose the Blood Group");
		UserID.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserID.setBounds(165,500,264,30);
		removeblood.add(UserID);
		JLabel fields = new JLabel("BID      AB+       AB-       B+      B-         O+      O-     HH ");
		fields.setForeground(Color.red);
		fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
		fields.setHorizontalAlignment(SwingConstants.CENTER);
		fields.setBounds(60,77,600,90);
		removeblood.add(fields);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeblood.dispose();
try {
	Blooddata();
} catch (IOException e) {
	e.printStackTrace();
}}
		});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(658,0, 51, 42);
		contentPane.add(backButton);
		removeblood.add(welcom);
		removeblood.setVisible(true);
	       JButton signupButton = new JButton("Sign up");
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Query = "UPDATE Blooddata SET "+bloodtype_comboBox.getSelectedItem()+" = "+bloodtype_comboBox.getSelectedItem()+" - 1 WHERE BID = '"+BID+"'";
				      PreparedStatement smt=DBMS.c.c1(Query);
						smt.execute();
								JOptionPane myOption = new JOptionPane();
								myOption.showMessageDialog(null, "Blood Donated successfully");
				                removeblood.dispose();
                                Blooddata();
				}
				catch(Exception E)
				{
					JOptionPane myOption = new JOptionPane();
					myOption.showMessageDialog(null, "Unable to Donate");
                    try {
						Blooddata();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
}
			}});
	            signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\donate.jpg"));
	            signupButton.setBounds(385, 600,136, 40);
	    		removeblood.add(signupButton);      				
			}
void displayblooddata() throws SQLException
{
	 JFrame displayblood = new JFrame();
	 displayblood.setTitle("Display Blood");
	 displayblood.setBounds(100, 200,720, 725);
	 displayblood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 displayblood.getContentPane().setLayout(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		displayblood.setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel side_panels = new JPanel();
 	side_panels.setBackground(new Color(220, 20, 60));
 	side_panels.setBounds(0, 0, 151,725);
 	displayblood.add(side_panels);
	String query= "Select * from blooddata where BID="+BID;
	ResultSet rs= DBMS.c.c2(query);
     JTable table = new JTable(buildTableModel(rs));
	    table.setBounds(185,130,350,200);
	    displayblood.add(table);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayblood.dispose();
     try {
		create();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
		});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(658,0, 51, 42);
		contentPane.add(backButton);
		JLabel fields = new JLabel("BID      AB+       AB-       B+      B-         O+      O-     HH ");
		fields.setForeground(Color.red);
		fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
		fields.setHorizontalAlignment(SwingConstants.CENTER);
		fields.setBounds(60,77,600,90);
		displayblood.add(fields);
		JButton quote = new JButton("");
		quote.setBackground(new Color(255, 255, 255));
		quote.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\donate-blood-and-save-life-isolated-icon-vector-26547407.jpg"));
		quote.setBounds(250,330,300,200);
		contentPane.add(quote);
		displayblood.setVisible(true);
}
void updatelist() {
String query = "select Bgrp,ldd1,ldd2,BDID from blodddonordata where BID = '"+BID+"'";
	ResultSet rsmt= DBMS.c.c2(query);
		try {
			while(rsmt.next())
			{
				Date dat;
				String bgrp=rsmt.getString(1);
				long mill=System.currentTimeMillis();  
				java.sql.Date da=new java.sql.Date(mill); 
				if(rsmt.getDate(3)!=null)
				 dat=rsmt.getDate(2);
				else
					dat=da;
				String DonorID=rsmt.getString(4);
				//getting the duration from his last donation date 
				long dur  = da.getTime() - dat.getTime();
				int nofDays = (int) (dur / (1000 * 60 * 60 * 24));
				//if blood is not utilized for more than 42 days it gets spoiled
				if(nofDays>42){
					query = "UPDATE Blooddata SET "+bgrp+" = "+bgrp+" - 1 WHERE BID = '"+BID+"'";
					PreparedStatement stamt=DBMS.c.c1(query);
					try {
						stamt.execute();
					} catch (Exception e) {
						System.out.println(""+e);
					}
					query="Update blodddonordata SET ldd2 = null where BDID= '"+DonorID+"'";
					stamt=DBMS.c.c1(query);
					try {
						stamt.execute();
					} catch (Exception e) {
						System.out.println(""+e);
					}}}
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "List was updated successfully");
			myOption.showMessageDialog(null, "The unused and spoiled blood has been removed from the list");
		} catch (Exception e) {
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "List was unable to update\n Please try after sometime");
		}}
void blooddonordata() throws IOException {
	JFrame frmblooddonorPage = new JFrame();
 	frmblooddonorPage.setTitle("Blood Donor Data Home Page");
 	frmblooddonorPage.setBounds(100, 250, 727, 775);
 	frmblooddonorPage.setBackground(new Color(255, 255, 255));
 	frmblooddonorPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmblooddonorPage.setContentPane(contentPane);
	contentPane.setLayout(null);
	BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote1.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	frmblooddonorPage.add(picLabel);
	picLabel.setBounds(0, 0, 181,725);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frmblooddonorPage.dispose();
			try {
			create();
			} catch (SQLException e) {
				e.printStackTrace();
			}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(658,0, 51, 42);
	contentPane.add(backButton);
	JButton	removeBlooddonorButton = new JButton("Remove Blood Donor");
	removeBlooddonorButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			 frmblooddonorPage.dispose();
	try {
		removeblooddonor();
	} catch (SQLException e) {
		e.printStackTrace();
	}}});
	removeBlooddonorButton. setFont(new Font("Arial", Font. PLAIN, 22));
	removeBlooddonorButton.setBackground(Color.RED);
	removeBlooddonorButton.setBounds(315,270,281,42);
	contentPane.add(removeBlooddonorButton);
	JButton	DisplayBloodDonorButton = new JButton("Display Blood Donor Data");
	DisplayBloodDonorButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	try {
		displayblooddonordata();
	} catch (SQLException e) {
		e.printStackTrace();
	}}});
	DisplayBloodDonorButton.setFont(new Font("Arial", Font. PLAIN, 20));
	DisplayBloodDonorButton.setBackground(Color.RED);
	DisplayBloodDonorButton.setBounds(315,330,281, 42);
	contentPane.add(DisplayBloodDonorButton);
	JButton	UpdateBloodDonorButton = new JButton("Update Blood Donor Data");
	UpdateBloodDonorButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frmblooddonorPage.dispose();
			updateblooddonordata();
		}});
	UpdateBloodDonorButton.setFont(new Font("Arial", Font. PLAIN, 20));
	UpdateBloodDonorButton.setBackground(Color.RED);
	UpdateBloodDonorButton.setBounds(315,390,281, 42);
	contentPane.add(UpdateBloodDonorButton);
    frmblooddonorPage.setVisible(true);
}
void removeblooddonor() throws SQLException {
	 JFrame deleteblooddonordata = new JFrame();
	 deleteblooddonordata.setTitle("Signup Page");
	 deleteblooddonordata.setBounds(100, 200,920, 725);
	 deleteblooddonordata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 deleteblooddonordata.getContentPane().setLayout(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		deleteblooddonordata.setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton(" ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					deleteblooddonordata.dispose();
					blooddonordata();
	        	} catch (Exception e) {
					e.printStackTrace();
				}}});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 102, 153));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		btnNewButton.setBounds(12, 13, 43, 42);
		contentPane.add(btnNewButton);
		JPanel side_panels = new JPanel();
 	side_panels.setBackground(new Color(220, 20, 60));
 	side_panels.setBounds(0, 0, 151,725);
 	deleteblooddonordata.add(side_panels);
	String query= "Select * from blodddonordata where BID='"+BID+"'";
	ResultSet rs= DBMS.c.c2(query);
	    JTable table = new JTable(buildTableModel(rs));
	    table.setBounds(185,130,700,200);
	    deleteblooddonordata.add(table);
		JLabel welcom = new JLabel("Blood Bank Donor Data");
		welcom.setForeground(Color.blue);
		welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
		welcom.setHorizontalAlignment(SwingConstants.CENTER);
		welcom.setBounds(130,10,399,90);
		JTextField UserIDField = new JTextField();
     UserIDField.setBounds(425,500 ,100,30);
     deleteblooddonordata.add(UserIDField);
     JLabel UserID = new JLabel("Enter the  BDID");
		UserID.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserID.setBounds(205,500,164,30);
		deleteblooddonordata.add(UserID);
		JLabel fields = new JLabel("   BBID         BDID         Blood Grp        Name             Age          Address             Mobile        Gender          LDD");
		fields.setForeground(Color.red);
		fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
		fields.setHorizontalAlignment(SwingConstants.CENTER);
		fields.setBounds(115,71,800,90);
		deleteblooddonordata.add(fields);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteblooddonordata.dispose();
try {
	blooddonordata();
} catch (IOException e) {
	e.printStackTrace();
}			}
		});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(658,700, 51, 42);
		contentPane.add(backButton);
		deleteblooddonordata.add(welcom);
		deleteblooddonordata.setVisible(true);
	       JButton signupButton = new JButton("Sign up");
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		String Query1=" Delete from blodddonordata where BDID= '" +UserIDField.getText()+"' and BID='"+BID+"'";	
    PreparedStatement stmt = DBMS.c.c1(Query1);       				
stmt.execute();
deleteblooddonordata.dispose();
JOptionPane myOption = new JOptionPane();
myOption.showMessageDialog(null, "Details Deleted successfully");
blooddonordata();
				}
				catch(Exception E)
				{
					JOptionPane myOption = new JOptionPane();
					myOption.showMessageDialog(null, "Unable to Delete");
}
			}});
	            signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\deleteicon.jpg"));
	            signupButton.setBounds(380, 600, 90, 50);
	    		deleteblooddonordata.add(signupButton);      			
}
void displayblooddonordata() throws SQLException {
	 JFrame displayblood = new JFrame();
   displayblood.setTitle("Display Blood Donor data");
	 displayblood.setBounds(100, 200,720, 825);
	 displayblood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 displayblood.getContentPane().setLayout(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		displayblood.setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 151,725);
	displayblood.add(side_panels);
	JLabel fields = new JLabel("   BBID         BDID         Blood Grp        Name             Age          Address        Mobile        Gender          LDD");
	fields.setForeground(Color.red);
	fields.setFont(new Font("Times New Roman", Font.PLAIN,14));
	fields.setHorizontalAlignment(SwingConstants.CENTER);
	fields.setBounds(115,71,800,90);
	displayblood.add(fields);
	String query= "Select * from bdonor where BID= '"+BID+"'";
	ResultSet rs= DBMS.c.c2(query);
    JTable table = new JTable(buildTableModel(rs));
	    table.setBounds(185,130,650,500);
	    displayblood.add(table);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayblood.dispose();
try {
	blooddonordata();
} catch (IOException e) {
	e.printStackTrace();
}}});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(858,0, 51, 42);
		contentPane.add(backButton);
		JButton quote = new JButton("");
		quote.setBackground(new Color(255, 255, 255));
		quote.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\donate-blood-and-save-life-isolated-icon-vector-26547407.jpg"));
		quote.setBounds(250,330,300,200);
		contentPane.add(quote);
		displayblood.setVisible(true);
}
void updateblooddonordata() {
	JFrame frmadminupdatePage1 = new JFrame();
	frmadminupdatePage1.setTitle("Update details");
	frmadminupdatePage1.setBounds(100, 100, 727, 725);
	frmadminupdatePage1.setBackground(new Color(255, 255, 255));
	frmadminupdatePage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmadminupdatePage1.setContentPane(contentPane);
	contentPane.setLayout(null);
	JButton btnNewButton = new JButton(" ");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadminupdatePage1.dispose();
				blooddonordata();
        	} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	btnNewButton.setBackground(new Color(255, 255, 255));
	btnNewButton.setForeground(new Color(255, 102, 153));
	btnNewButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	btnNewButton.setBounds(12, 13, 43, 42);
	contentPane.add(btnNewButton);
	JLabel StartPagePhoto1 = new JLabel("");
	StartPagePhoto1.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	StartPagePhoto1.setHorizontalAlignment(SwingConstants.CENTER);
	StartPagePhoto1.setBounds(0,0,820,820);
	String roles[]={"Address","Mobile","Last donted date"};        
	final JComboBox updatelabel=new JComboBox(roles);
	updatelabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	updatelabel.setBackground(new Color(245, 245, 245));
	updatelabel.setBounds(389, 188, 234, 41);
	contentPane.add(updatelabel);
	JTextField userid = new JTextField();
    userid.setBounds(389, 88, 172, 41);
    frmadminupdatePage1.add(userid);
    JLabel UserIDlabel = new JLabel("Enter the BDID");
    UserIDlabel.setHorizontalAlignment(SwingConstants.CENTER);
    UserIDlabel.setForeground(Color.WHITE);
    UserIDlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
    UserIDlabel.setBounds(46, 73, 369, 68);
	contentPane.add(UserIDlabel);
	JTextField updated = new JTextField();
    updated.setBounds(389, 288, 172, 41);
    frmadminupdatePage1.add(updated);
    JLabel UserIDFixed = new JLabel("Field");
	UserIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	UserIDFixed.setForeground(Color.WHITE);
	UserIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	UserIDFixed.setBounds(46, 173, 369, 68);
	contentPane.add(UserIDFixed);
	JLabel PhoneNumberFixed = new JLabel("New value");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	PhoneNumberFixed.setBounds(46, 273, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmadminupdatePage1.dispose();
			    String query="Update blodddonordata set "+String.valueOf(updatelabel.getSelectedItem())+"= '"+updated.getText()+"' where BDID= '"+userid.getText()+"'";
				PreparedStatement stmt=DBMS.c.c1(query);
				stmt.execute();
				JOptionPane myOption = new JOptionPane();
				myOption.showMessageDialog(null, "Details Updated successfully");
				blooddonordata();
			} catch (Exception e) {				
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "Unable to Update details successfully");
			try {
				blooddonordata();
			} catch (IOException e1) {
				e1.printStackTrace();
			}}}});
contentPane.add(StartPagePhoto1);
frmadminupdatePage1.setVisible(true);
}
void signup() {
	JFrame signup = new JFrame();
	signup.setTitle("Signup Page"); 
	signup.setBounds(100, 200,990, 725);
	signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	signup.getContentPane().setLayout(null);
	JPanel panel = new JPanel();
	panel.setBackground(new Color(220, 20, 60));
	panel.setBounds(0, 0, 1100, 58);
	signup.add(panel);
	panel.setLayout(null);
	JTextField LDD = new JTextField();
	LDD.setBounds(357, 259, 172, 41);
	JLabel label1 = new JLabel("LDD");
	label1.setFont(new Font("Tahoma", Font.BOLD, 18));
	label1.setBounds(298, 259, 85, 35);
	signup.add(label1);
	JLabel Agelabel = new JLabel("Age");
	Agelabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	Agelabel.setBounds(522,119, 85,41);
	signup.add(Agelabel);
	JLabel genderlabel = new JLabel("Gender");
	genderlabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	genderlabel.setBounds(552,259, 85,41);
	signup.add(genderlabel);
    JTextField nameField = new JTextField();
		nameField.setBounds(122, 119, 272, 41);
		signup.add(nameField);
		nameField.setColumns(10);
	    JTextField AgeField = new JTextField();
			AgeField.setBounds(582, 119, 72, 41);
			signup.add(AgeField);
			nameField.setColumns(3);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			signup.dispose();
		try {
			ADDblood();
		} catch (SQLException e) {
			e.printStackTrace();
		}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(new Color(220, 20, 60));
	backButton.setBounds(12, 13, 51, 42);
	panel.add(backButton);
	signup.add(LDD);
	JTextField phonenumberField = new JTextField();
	phonenumberField.addKeyListener(new KeyAdapter() {
	public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
				e.consume();
			}}});
	phonenumberField.setColumns(10);
	phonenumberField.setBounds(439, 336, 255, 41);
	signup.add(phonenumberField);
	String[] Bloodgropus = {"ABpositive", "ABnegative", "Bpositive", "Benagative","Opositive","Onegative","HH"};
	JComboBox bloodtype_comboBox = new JComboBox(Bloodgropus);
	bloodtype_comboBox.setBackground(new Color(255, 255, 255));
	bloodtype_comboBox.setBounds(122, 336, 108, 41);
	signup.add(bloodtype_comboBox);
	String[] Genders = {"M", "F", "Other"};
	JComboBox Gender_box = new JComboBox(Genders);
	Gender_box.setBackground(new Color(255, 255, 255));
	Gender_box.setBounds(637, 259, 102, 41);
	signup.add(Gender_box);
    JLabel nameLabel = new JLabel("Name");
	nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	nameLabel.setBounds(12,121, 69, 35);
	signup.add(nameLabel);
	JLabel	phonenumberLabel = new JLabel("Phone number");
	phonenumberLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	phonenumberLabel.setBounds(275, 336, 134, 39);
	signup.add(phonenumberLabel);
	JLabel	cityLabel = new JLabel("Address");
	cityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	cityLabel.setBounds(12, 259, 146, 35);
	signup.add(cityLabel);
	JLabel lblBloodType = new JLabel("Blood type");
	lblBloodType.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblBloodType.setBounds(12, 336, 100, 35);
	signup.add(lblBloodType);
    JTextField Address = new JTextField();
    Address.setBounds(102, 259, 172, 41);
    signup.add(Address);
    JButton signupButton = new JButton("Sign up");
	signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
	signupButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(phonenumberField.getText().length() > 10 || phonenumberField.getText().length() < 10||phonenumberField.getText().isEmpty()) {
				JOptionPane myOption = new JOptionPane();
		    	myOption.showMessageDialog(null, "Enter a valid phone number");
			}
			String query="insert into BLODDDONORDATA values(?,?,?,?,?,?,?,?,?,?,?)";
			Random rd=new Random();
			int num=rd.nextInt(999)+100;
				PreparedStatement stmt1 = DBMS.c.c1(query);
			  try {
				stmt1.setString(2, String.valueOf(num));
				stmt1.setString(1, String.valueOf(BID));
				stmt1.setString(3, String.valueOf(nameField.getText()));
				stmt1.setInt(5, Integer.valueOf(AgeField.getText()));
				stmt1.setDate(9, Date.valueOf(LDD.getText()));
				stmt1.setDate(10, Date.valueOf(LDD.getText()));
				stmt1.setDate(11, Date.valueOf(LDD.getText()));
				stmt1.setString(6, String.valueOf(Address.getText()));
				stmt1.setString(7, String.valueOf(phonenumberField.getText()));
				stmt1.setString(8, String.valueOf(Gender_box.getSelectedItem()));
				stmt1.setString(4, String.valueOf(bloodtype_comboBox.getSelectedItem()));
				stmt1.executeUpdate();
				stmt1.close();
				 JOptionPane myOption = new JOptionPane();
				 myOption.showMessageDialog(null, "Signed Up Successfully, your User ID is " + num);
				 signup.dispose();
    				ADDblood();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}});
    signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\signup1.png"));
    signupButton.setBounds(405, 600, 100, 50);
	signup.add(signupButton);
	signup.setVisible(true);
}
void profile() throws SQLException {
		JFrame frmBBempPage1 = new JFrame();
		frmBBempPage1.setTitle("Profile Page");
		frmBBempPage1.setBounds(100, 100, 727, 725);
		frmBBempPage1.setBackground(new Color(255, 255, 255));
		frmBBempPage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmBBempPage1.setContentPane(contentPane);
		contentPane.setLayout(null);
		frmBBempPage1.setVisible(true);
		contentPane.setVisible(true);
		JLabel StartPagePhoto1 = new JLabel("");
		StartPagePhoto1.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
		StartPagePhoto1.setHorizontalAlignment(SwingConstants.CENTER);
		StartPagePhoto1.setBounds(0,0,820,820);
		JButton btnNewButton = new JButton(" ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				try {
					frmBBempPage1.dispose();
                    create();
                    }
				catch (Exception e) {
					e.printStackTrace();
				}}});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 102, 153));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		btnNewButton.setBounds(12, 13, 43, 42);
		contentPane.add(btnNewButton);
		JLabel Name_label = new JLabel("Name");
		Name_label.setHorizontalAlignment(SwingConstants.CENTER);
		Name_label.setForeground(new Color(220, 20, 60));
		Name_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		Name_label.setBounds(486, 139, 159, 68);
		contentPane.add(Name_label);	
		JLabel BBID_label = new JLabel("BBID");
		BBID_label.setHorizontalAlignment(SwingConstants.CENTER);
		BBID_label.setForeground(new Color(220, 20, 60));
		BBID_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		BBID_label.setBounds(396, 233, 369, 68);
		contentPane.add(BBID_label);
		JLabel PhoneNum_label = new JLabel("Phone number");
		PhoneNum_label.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNum_label.setForeground(new Color(220, 20, 60)); 
		PhoneNum_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		PhoneNum_label.setBounds(396, 339, 369, 68);
		contentPane.add(PhoneNum_label);
		JLabel Location_label = new JLabel("City");
		Location_label.setHorizontalAlignment(SwingConstants.CENTER);
		Location_label.setForeground(new Color(220, 20, 60));
		Location_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		Location_label.setBounds(336, 386, 502, 160);
		contentPane.add(Location_label);
		JLabel Name_Label = new JLabel("Name");
		Name_Label.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		Name_Label.setForeground(new Color(255, 255, 255));
		Name_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Name_Label.setBounds(46, 151, 369, 68);
		contentPane.add(Name_Label);	
		JLabel BBIDFixed = new JLabel("BBank ID:");
		BBIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
		BBIDFixed.setForeground(Color.WHITE);
		BBIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		BBIDFixed.setBounds(46, 245, 369, 68);
		contentPane.add(BBIDFixed);
		JLabel PhoneNumberFixed = new JLabel("Phone Number:");
		PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberFixed.setForeground(Color.WHITE);
		PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		PhoneNumberFixed.setBounds(46, 336, 369, 68);
		contentPane.add(PhoneNumberFixed);
		JLabel LocationFixed = new JLabel("City:");
		LocationFixed.setHorizontalAlignment(SwingConstants.CENTER);
		LocationFixed.setForeground(Color.WHITE);
		LocationFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		LocationFixed.setBounds(46, 431, 369, 68);
		contentPane.add(LocationFixed);
		JLabel lblNewLabel_1_4 = new JLabel("Profile");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1_4.setBounds(190,0, 369, 68);
		contentPane.add(lblNewLabel_1_4);
		JLabel Mail_Label = new JLabel("Mail:");
		Mail_Label.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		Mail_Label.setForeground(new Color(255, 255, 255));
		Mail_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Mail_Label.setBounds(46, 521, 369, 68);
		contentPane.add(Mail_Label);	
		JLabel Mail_fixedlabel = new JLabel("Mail");
		Mail_fixedlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Mail_fixedlabel.setForeground(new Color(220, 20, 60));
		Mail_fixedlabel.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		Mail_fixedlabel.setBounds(336, 489, 502, 160);
		contentPane.add(Mail_fixedlabel);	
	    String query ="select * from employdata where ID = '"+DBMS.userid+"'";
	    ResultSet rs= DBMS.c.c2(query);
		    while(rs.next()) {
		        Name_label.setText(String.valueOf(rs.getString(3)));
		    	BBID_label.setText(String.valueOf(rs.getString(2)));
		    	PhoneNum_label.setText(String.valueOf(rs.getString(4)));
		    	Location_label.setText(String.valueOf(rs.getString(6)));
		    	Mail_fixedlabel.setText(String.valueOf(rs.getString(5)));
		        }
		JButton updateButton = new JButton("");
		updateButton.setBackground(new Color(255, 255, 255));
		updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
		updateButton.setBounds(239, 600, 200, 60);
		contentPane.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmBBempPage1.dispose();
					updatedetails();
				} catch (Exception e) {
				}}});
frmBBempPage1.add(StartPagePhoto1);
	}
void updatedetails(){
	JFrame frmBBempupdatePage = new JFrame();
	frmBBempupdatePage.setTitle("Update details");
	frmBBempupdatePage.setBounds(100, 100, 727, 725);
	frmBBempupdatePage.setBackground(new Color(255, 255, 255));
	frmBBempupdatePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmBBempupdatePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JButton backButton = new JButton(" ");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
create();
} catch (Exception e) {
				e.printStackTrace();
			}}});
	backButton.setBackground(new Color(255, 255, 255));
	backButton.setForeground(new Color(255, 102, 153));
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBounds(12, 13, 43, 42);
	contentPane.add(backButton);
	JLabel ProfilePagePhoto = new JLabel("");
	ProfilePagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	ProfilePagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	ProfilePagePhoto.setBounds(0,0,820,820);
	String roles[]={"Name","Mobile","Mail"};        
	final JComboBox updatelabel=new JComboBox(roles);
	updatelabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	updatelabel.setBackground(new Color(245, 245, 245));
	updatelabel.setBounds(389, 188, 234, 41);
	contentPane.add(updatelabel);
	JTextField updated = new JTextField();
    updated.setBounds(389, 288, 172, 41);
    frmBBempupdatePage.add(updated);
    JLabel UserIDFixed = new JLabel("Field");
	UserIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	UserIDFixed.setForeground(Color.WHITE);
	UserIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	UserIDFixed.setBounds(46, 173, 369, 68);
	contentPane.add(UserIDFixed);
	JLabel PhoneNumberFixed = new JLabel("New value");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	PhoneNumberFixed.setBounds(46, 273, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmBBempupdatePage.dispose();
			    String query="Update employdata set "+String.valueOf(updatelabel.getSelectedItem())+"='"+String.valueOf(updated.getText())+"' where ID='"+DBMS.userid+"'";
				PreparedStatement stmt=DBMS.c.c1(query);
				stmt.execute();
				JOptionPane myOption = new JOptionPane();
				myOption.showMessageDialog(null, "Details Updated successfully");
				create();
			} catch (Exception e) {				
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "Unable to Update details successfully\nTry after some Time");
			System.out.print(e);
try {
	create();
} catch (SQLException e1) {
	e1.printStackTrace();
}}}});
contentPane.add(ProfilePagePhoto);
frmBBempupdatePage.dispose();
frmBBempupdatePage.setVisible(true);
}
public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }
    return new DefaultTableModel(data, columnNames);
}}
class Donor{
	Donor() throws IOException{
     	login obj=new login(0,"Donorlogin");	
     	create();}
	void create() throws IOException {
		try {
			String query="Select JDD,feed from donordata where ID='"+DBMS.userid+"'";
			ResultSet rs=DBMS.c.c2(query);
			Date d1=null;
			int d2=0;
			while(rs.next())
			{
				d1=rs.getDate(1);
				d2=rs.getInt(2);
			}
	        long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
			long duration  = date.getTime() - d1.getTime();
			int numofDays = (int) (duration / (1000 * 60 * 60 * 24));
			if(numofDays>d2) {
				JOptionPane myOption = new JOptionPane();
				int a=JOptionPane.showConfirmDialog(null,"Loved it Please give us feedback");  
				if(a==JOptionPane.YES_OPTION){  			    	
	        d2=d2+30;
	        String query1="Update donordata set feed ="+d2+" where ID='"+DBMS.userid+"'";
	        PreparedStatement stmt=DBMS.c.c1(query1);
              stmt.execute();
				feedback();
				}}
			else {
				JOptionPane myOption = new JOptionPane();
		    	myOption.showMessageDialog(null, "You have already responded");
			}} catch (Exception e) {
			e.printStackTrace();
		}
	 	JFrame frmDonorPage = new JFrame();
		frmDonorPage.setTitle("Donor Home Page");
		frmDonorPage.setBounds(100, 190, 727, 725);
		frmDonorPage.setBackground(new Color(255, 255, 255));
		frmDonorPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmDonorPage.setContentPane(contentPane);
		contentPane.setLayout(null);
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote2.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		frmDonorPage.add(picLabel);
		picLabel.setBounds(0, 0, 181,725);
		JButton profile_icon = new JButton("");
		profile_icon.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\profile2.jpg"));
		profile_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					profile();
					frmDonorPage.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		profile_icon.setBounds(380,175,135,150);
		frmDonorPage.add(profile_icon);
		JButton	logoutButton = new JButton("");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDonorPage.dispose();
				DBMS myStart_Page=null;	
				myStart_Page.main(null);
			}
		});
		logoutButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\logout.png"));
		logoutButton.setBackground(Color.white);
		logoutButton.setBounds(658,0, 51, 42);
		contentPane.add(logoutButton);
		JLabel welcom_label = new JLabel("Welcome Donor!");
		welcom_label.setForeground(Color.red);
		welcom_label.setFont(new Font("Times New Roman", Font.BOLD, 36));
		welcom_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcom_label.setBounds(255, 60, 399, 90);
		frmDonorPage.add(welcom_label);
		JButton DonationButton = new JButton(" ");
		DonationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane myOption = new JOptionPane();
					int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
					if(a==JOptionPane.YES_OPTION){  			    	
					String query="Select ldd from donordata where ID = '"+String.valueOf(DBMS.userid)+"'";
					long millis=System.currentTimeMillis();  
					java.sql.Date date=new java.sql.Date(millis); 	   
				    Date date1=null;
					 ResultSet rs=DBMS.c.c2(query);
							try {
								while(rs.next())
									date1=rs.getDate(1);
							} catch (Exception e) {
								System.out.println(""+e);
							}
					long duration  = date.getTime() - date1.getTime();
					int numofDays = (int) (duration / (1000 * 60 * 60 * 24));
					if(numofDays<56)//as per biological norms a person cannot donate blood before 56 days from his last donation
				{
					    	myOption.showMessageDialog(null, "You are not applicable from donation as he donated blood "+numofDays+" ago");
create();				}
					else
					{
						query="Update donordata set status ='yes' where ID = '"+String.valueOf(DBMS.userid)+"'";
					     PreparedStatement smt=DBMS.c.c1(query);
							try {
								smt.execute();
						    	myOption.showMessageDialog(null, "Status updated\n Thanks for saving life");
							} catch (Exception e) {
								System.out.println(""+e);
							}
					}
				}		} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		DonationButton.setBackground(new Color(255, 255, 255));
		DonationButton.setForeground(new Color(255, 102, 153));
		DonationButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\make a donation.jpg"));
		DonationButton.setBounds(387, 355, 139, 140);
		frmDonorPage.add(DonationButton);
		JButton feedButton = new JButton(" ");
		feedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Select JDD,JDD2 from donordata where ID='"+DBMS.userid+"'";
					ResultSet rs=DBMS.c.c2(query);
					Date d1=null;
					int d2=0;
					while(rs.next())
					{
						d1=rs.getDate(1);
						d2=rs.getInt(2);
					}
			        long millis=System.currentTimeMillis();  
			        java.sql.Date date=new java.sql.Date(millis);  
					long duration  = date.getTime() - d1.getTime();
					int numofDays = (int) (duration / (1000 * 60 * 60 * 24));
					if(numofDays>d2) {
			        d2=d2+30;
			        String query1="Update donordata set feed ="+d2+"where ID='"+DBMS.userid+"'";
			        PreparedStatement stmt=DBMS.c.c1(query1);
	                  stmt.execute();
						feedback();
					}
					else {
						JOptionPane myOption = new JOptionPane();
				    	myOption.showMessageDialog(null, "You have already responded");
					}
		} catch (Exception e) {
					e.printStackTrace();
				}}});
		feedButton.setBackground(new Color(255, 255, 255));
		feedButton.setForeground(new Color(255, 102, 153));
		feedButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\feedback.png"));
		feedButton.setBounds(380, 529,138, 110);
		frmDonorPage.add(feedButton);
	frmDonorPage.setVisible(true);	
	}
static String a1,a2,a3,a4,a5,a6,a7;
void feedback() throws IOException {
	JFrame frmDonorPage = new JFrame();
	frmDonorPage.setTitle("FeedBack Page");
	frmDonorPage.setBounds(100, 190, 1227, 775);
	frmDonorPage.setBackground(new Color(255, 255, 255));
	frmDonorPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmDonorPage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JLabel welcom = new JLabel("Feedback Form");
	welcom.setForeground(new Color(220, 20, 60));
	welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
	welcom.setHorizontalAlignment(SwingConstants.CENTER);
	welcom.setBounds(85,10,399,90);
	frmDonorPage.add(welcom);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		frmDonorPage.dispose();
try {
	create();
} catch (IOException e) {
	e.printStackTrace();
}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(1160,0, 51, 42);
	contentPane.add(backButton);
	BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote2.jpg"));
	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	frmDonorPage.add(picLabel);
	picLabel.setBounds(0, 0, 181,725);
	JLabel Q1 = new JLabel("BBMS provides a clear documentation about the blood donor and its blood donation activities");
	Q1.setForeground(Color.black);
	Q1.setFont(new Font("Arial", Font.PLAIN,18));
	Q1.setHorizontalAlignment(SwingConstants.CENTER);
	Q1.setBounds(155, 60, 899, 90);
	frmDonorPage.add(Q1);
	JLabel Q2 = new JLabel("BBMS can search fast the list of possible blood donors through its donors’ files.");
	Q2.setForeground(Color.black);
	Q2.setFont(new Font("Arial", Font.PLAIN,18));
	Q2.setHorizontalAlignment(SwingConstants.CENTER);
	Q2.setBounds(149, 130, 789, 90);
	frmDonorPage.add(Q2);
	JLabel Q3 = new JLabel("BBMS can clearly monitor the availability of blood bags or products of all blood types");
	Q3.setForeground(Color.black);
	Q3.setFont(new Font("Arial", Font.PLAIN,18));
	Q3.setHorizontalAlignment(SwingConstants.CENTER);
	Q3.setBounds(175, 200, 789, 90);
	frmDonorPage.add(Q3);
	JLabel Q4 = new JLabel("BBMS allows user to know easily the period of expiration of blood bags/products.");
	Q4.setForeground(Color.black);
	Q4.setFont(new Font("Arial", Font.PLAIN,18));
	Q4.setHorizontalAlignment(SwingConstants.CENTER);
	Q4.setBounds(149, 257, 789, 90);
	frmDonorPage.add(Q4);
	JLabel Q5 = new JLabel("BBMS offers an organized and systematized filing or record system.");
	Q5.setForeground(Color.black);
	Q5.setFont(new Font("Arial", Font.PLAIN,18));
	Q5.setHorizontalAlignment(SwingConstants.CENTER);
	Q5.setBounds(99, 310, 789, 90);
	frmDonorPage.add(Q5);
	JLabel Q6 = new JLabel("BBMS provides easy to use, efficient, effective system to the users.");
	Q6.setForeground(Color.black);
	Q6.setFont(new Font("Arial", Font.PLAIN,18));
	Q6.setHorizontalAlignment(SwingConstants.CENTER);
	Q6.setBounds(85, 370, 789, 90);
	frmDonorPage.add(Q6);
	JLabel Q7 = new JLabel("BBMS acts as bridge between patient and donor");
	Q7.setForeground(Color.black);
	Q7.setFont(new Font("Arial", Font.PLAIN,18));
	Q7.setHorizontalAlignment(SwingConstants.CENTER);
	Q7.setBounds(19, 430, 789, 90);
	frmDonorPage.add(Q7);
	JLabel suggestion = new JLabel("Any suggestion to improve this system??");
	suggestion.setForeground(Color.black);
	suggestion.setFont(new Font("Arial", Font.PLAIN,18));
	suggestion.setHorizontalAlignment(SwingConstants.CENTER);
	suggestion.setBounds(140, 500, 489, 90);
	frmDonorPage.add(suggestion);
	  JTextField suggestionField = new JTextField();
		suggestionField.setBounds(230,570,400,100);
		frmDonorPage.add(suggestionField);
	int j=255;
	for(int i=0;i<5;i++) {
		String a=String.valueOf(5-i);
		JRadioButton r1=new JRadioButton(a); 
		j=j+50;
		r1.setBounds(j,120,40,30);    
		r1.setBackground(Color.white);
		frmDonorPage.add(r1);
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a1=r1.getText();
			}});}
	j=255;
	for(int i=0;i<5;i++) {
		String a=String.valueOf(5-i);
		JRadioButton r2=new JRadioButton(a); 
		j=j+50;
		r2.setBounds(j,190,40,30);    
		r2.setBackground(Color.white);
		frmDonorPage.add(r2);
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a2=r2.getText();
			}});}
	j=255;
	for(int i=0;i<5;i++) {
		String a=String.valueOf(5-i);
		JRadioButton r3=new JRadioButton(a); 
		j=j+50;
		r3.setBounds(j,250,40,30);    
		r3.setBackground(Color.white);
		frmDonorPage.add(r3);
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a3=r3.getText();
			}});
	    }
	j=255;
	for(int i=0;i<5;i++) {
		String a=String.valueOf(5-i);
		JRadioButton r4=new JRadioButton(a); 
		j=j+50;
		r4.setBounds(j,310,40,30);    
		r4.setBackground(Color.white);
		frmDonorPage.add(r4);
		r4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a4=r4.getText();
			}});
	    }
	j=255;
	for(int i=0;i<5;i++) {
		String a=String.valueOf(5-i);
		JRadioButton r5=new JRadioButton(a); 
		j=j+50;
		r5.setBounds(j,370,40,30);    
		r5.setBackground(Color.white);
		frmDonorPage.add(r5);
		r5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a5=r5.getText();
			}});
	    }		
	j=255;
		for(int i=0;i<5;i++) {
			String a=String.valueOf(5-i);
			JRadioButton r6=new JRadioButton(a); 
			j=j+50;
			r6.setBounds(j,430,40,30);    
			r6.setBackground(Color.white);
			frmDonorPage.add(r6);
			r6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a6=r6.getText();
				}});
		    }
		j=255;
		for(int i=0;i<5;i++) {
			String a=String.valueOf(5-i);
			JRadioButton r7=new JRadioButton(a); 
			j=j+50;
			r7.setBounds(j,500,40,30);    
			r7.setBackground(Color.white);
			frmDonorPage.add(r7);
			r7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a7=r7.getText();
				}});}
	String suggest =String.valueOf(suggestionField.getText());
	JButton NextButton = new JButton("");
	NextButton.setBackground(new Color(255, 255, 255));
	NextButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\next.png"));
	NextButton.setBounds(570, 680, 118, 40);
	frmDonorPage.add(NextButton);
	frmDonorPage.setVisible(true);
NextButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
String  query="insert into Feedback values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt1 = DBMS.c.c1(query);
  try {
		stmt1.setInt(1, Integer.valueOf(a1));
		stmt1.setInt(2, Integer.valueOf(a2));
		stmt1.setInt(3, Integer.valueOf(a3));
		stmt1.setInt(4, Integer.valueOf(a4));
		stmt1.setInt(5, Integer.valueOf(a5));
		stmt1.setInt(6, Integer.valueOf(a6));
		stmt1.setInt(7, Integer.valueOf(a7));
		stmt1.setString(8,suggest);
		stmt1.executeUpdate();
		stmt1.close();
		 JOptionPane myOption = new JOptionPane();
		 myOption.showMessageDialog(null, "Thanks for your valuable feedback");
		 frmDonorPage.dispose();
		 DBMS myStart_Page = new DBMS();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}

		}});}
void profile() throws SQLException {
	JFrame frmDonorPage1 = new JFrame();
	frmDonorPage1.setTitle("Profile Page");
	frmDonorPage1.setBounds(100, 100, 727, 725);
	frmDonorPage1.setBackground(new Color(255, 255, 255));
	frmDonorPage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmDonorPage1.setContentPane(contentPane);
	contentPane.setLayout(null);
	frmDonorPage1.setVisible(true);
	contentPane.setVisible(true);
	JLabel StartPagePhoto1 = new JLabel("");
	StartPagePhoto1.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	StartPagePhoto1.setHorizontalAlignment(SwingConstants.CENTER);
	StartPagePhoto1.setBounds(0,0,820,820);
	JButton btnNewButton = new JButton(" ");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
				frmDonorPage1.dispose();
create();			} catch (Exception e) {
				e.printStackTrace();
			}}});
	btnNewButton.setBackground(new Color(255, 255, 255));
	btnNewButton.setForeground(new Color(255, 102, 153));
	btnNewButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	btnNewButton.setBounds(12, 13, 43, 42);
	contentPane.add(btnNewButton);
	JLabel Name_label = new JLabel("Name");
	Name_label.setHorizontalAlignment(SwingConstants.CENTER);
	Name_label.setForeground(new Color(220, 20, 60));
	Name_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Name_label.setBounds(486, 139, 159, 68);
	contentPane.add(Name_label);	
	JLabel BID_label = new JLabel("BID");
	BID_label.setHorizontalAlignment(SwingConstants.CENTER);
	BID_label.setForeground(new Color(220, 20, 60));
	BID_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	BID_label.setBounds(396, 233, 369, 68);
	contentPane.add(BID_label);
	JLabel PhoneNum_label = new JLabel("Phone number");
	PhoneNum_label.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNum_label.setForeground(new Color(220, 20, 60)); 
	PhoneNum_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	PhoneNum_label.setBounds(396, 339, 369, 68);
	contentPane.add(PhoneNum_label);
	JLabel Bgrp_label = new JLabel("Blood Grp");
	Bgrp_label.setHorizontalAlignment(SwingConstants.CENTER);
	Bgrp_label.setForeground(new Color(220, 20, 60));
	Bgrp_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Bgrp_label.setBounds(386, 416,368,68);
	contentPane.add(Bgrp_label);
	JLabel Address_Label = new JLabel("Address");
	Address_Label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Address_Label.setForeground(new Color(220, 20, 60));
	Address_Label.setHorizontalAlignment(SwingConstants.CENTER);
	Address_Label.setBounds(386, 481, 369, 68);
	contentPane.add(Address_Label);	
	JLabel status_Label = new JLabel("Status");
	status_Label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	status_Label.setForeground(new Color(220, 20, 60));
	status_Label.setHorizontalAlignment(SwingConstants.CENTER);
	status_Label.setBounds(336, 561, 369, 68);
	contentPane.add(status_Label);	
	JLabel NameFixed = new JLabel("Name:");
	NameFixed.setHorizontalAlignment(SwingConstants.CENTER);
	NameFixed.setForeground(Color.WHITE);
	NameFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	NameFixed.setBounds(46, 145, 369, 68);
	contentPane.add(NameFixed);
	JLabel BIDFixed = new JLabel("BID:");
	BIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	BIDFixed.setForeground(Color.WHITE);
	BIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	BIDFixed.setBounds(46,233, 369, 68);
	contentPane.add(BIDFixed);
    JLabel PhoneNumberFixed = new JLabel("Phone Number:");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	PhoneNumberFixed.setBounds(46, 316, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JLabel BgrpFixed = new JLabel("Blood Grp:");
	BgrpFixed.setHorizontalAlignment(SwingConstants.CENTER);
	BgrpFixed.setForeground(Color.white);
	BgrpFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	BgrpFixed.setBounds(0, 346, 502, 160);
	contentPane.add(BgrpFixed);
	JLabel Addressfixed = new JLabel("Address :");
	Addressfixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	Addressfixed.setForeground(Color.white);
	Addressfixed.setHorizontalAlignment(SwingConstants.CENTER);
	Addressfixed.setBounds(46, 481, 369, 68);
	contentPane.add(Addressfixed);	
	JLabel STATUSFixed = new JLabel("Status:");
	STATUSFixed.setHorizontalAlignment(SwingConstants.CENTER);
	STATUSFixed.setForeground(Color.WHITE);
	STATUSFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	STATUSFixed.setBounds(46, 551, 369, 68);
	contentPane.add(STATUSFixed);
	JLabel lblNewLabel_1_4 = new JLabel("Profile");
	lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_4.setForeground(Color.BLACK);
	lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
	lblNewLabel_1_4.setBounds(190,0, 369, 68);
	contentPane.add(lblNewLabel_1_4);
    String query ="select * from donordata where ID = '"+DBMS.userid+"'";
    ResultSet rs= DBMS.c.c2(query);
	    while(rs.next()) {
	        Name_label.setText(String.valueOf(rs.getString(3)));
	    	BID_label.setText(String.valueOf(rs.getString(2)));
	    	PhoneNum_label.setText(String.valueOf(rs.getString(7)));
	    	status_Label.setText(String.valueOf(rs.getString(11)));
	    	Address_Label.setText(String.valueOf(rs.getString(6)));
	    	Bgrp_label.setText(String.valueOf(rs.getString(4)));
	        }
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 700, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmDonorPage1.dispose();
			updatedetails();
			} catch (Exception e) {
			}}});
frmDonorPage1.add(StartPagePhoto1);
}
void updatedetails() {
	JFrame frmdonorupdatePage = new JFrame();
	frmdonorupdatePage.setTitle("Update details");
	frmdonorupdatePage.setBounds(100, 100, 727, 725);
	frmdonorupdatePage.setBackground(new Color(255, 255, 255));
	frmdonorupdatePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmdonorupdatePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JButton backButton = new JButton(" ");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmdonorupdatePage.dispose();
  profile();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	backButton.setBackground(new Color(255, 255, 255));
	backButton.setForeground(new Color(255, 102, 153));
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBounds(12, 13, 43, 42);
	contentPane.add(backButton);
	JLabel ProfilePagePhoto = new JLabel("");
	ProfilePagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	ProfilePagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	ProfilePagePhoto.setBounds(0,0,820,820);
	String roles[]={"Age","Mobile","Address","LDD"};        
	final JComboBox updatelabel=new JComboBox(roles);
	updatelabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	updatelabel.setBackground(new Color(245, 245, 245));
	updatelabel.setBounds(389, 188, 234, 41);
	contentPane.add(updatelabel);
	JTextField updated = new JTextField();
    updated.setBounds(389, 288, 172, 41);
    frmdonorupdatePage.add(updated);
    JLabel UserIDFixed = new JLabel("Field");
	UserIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	UserIDFixed.setForeground(Color.WHITE);
	UserIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	UserIDFixed.setBounds(46, 173, 369, 68);
	contentPane.add(UserIDFixed);
	JLabel PhoneNumberFixed = new JLabel("New value");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	PhoneNumberFixed.setBounds(46, 273, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmdonorupdatePage.dispose();
			    String query="Update donordata set "+String.valueOf(updatelabel.getSelectedItem())+"='"+String.valueOf(updated.getText())+"'where ID='"+DBMS.userid+"'";
				PreparedStatement stmt=DBMS.c.c1(query);
				stmt.execute();
				JOptionPane myOption = new JOptionPane();
				myOption.showMessageDialog(null, "Details Updated successfully");
				create();
			} catch (Exception e) {				
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "Unable to Update details successfully\nTry after some Time");
			System.out.print(e);
try {
	create();
} catch (IOException e1) {
	e1.printStackTrace();
}}}});
contentPane.add(ProfilePagePhoto);
frmdonorupdatePage.dispose();
frmdonorupdatePage.setVisible(true);
}}
class Patient {
	Patient() throws Exception{
		login obj=new login(0,"patientlogin");
		create();
			}
	void create() throws IOException {
		try {
			String query="Select JDD,feed from patientdata where ID='"+DBMS.userid+"'";
			ResultSet rs=DBMS.c.c2(query);
			Date d1=null;
			int d2=0;
			while(rs.next())
			{
				d1=rs.getDate(1);
				d2=rs.getInt(2);
			}
	        long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis);  
			long duration  = date.getTime() - d1.getTime();
			int numofDays = (int) (duration / (1000 * 60 * 60 * 24));
			if(numofDays>d2) {
				JOptionPane myOption = new JOptionPane();
				int a=JOptionPane.showConfirmDialog(null,"Loved it Please give us feedback");  
				if(a==JOptionPane.YES_OPTION){  			    	
	        d2=d2+30;
	        String query1="Update patientdata set feed ="+d2+" where ID='"+DBMS.userid+"'";
	        PreparedStatement stmt=DBMS.c.c1(query1);
              stmt.execute();
				feedBack();
				}}
			else {
				JOptionPane myOption = new JOptionPane();
		    	myOption.showMessageDialog(null, "You have already responded");
			}} catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frmPatientPage = new JFrame();
		frmPatientPage.setTitle("Patient Home Page");
		frmPatientPage.setBounds(100, 190, 727, 725);
		frmPatientPage.setBackground(new Color(255, 255, 255));
		frmPatientPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmPatientPage.setContentPane(contentPane);
		contentPane.setLayout(null);
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote2.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		frmPatientPage.add(picLabel);
		picLabel.setBounds(0, 0, 181,725);
		JButton profile_icon = new JButton("");
		profile_icon.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\profile2.jpg"));
		profile_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmPatientPage.dispose();
					profile();
				} catch (Exception e) {
					e.printStackTrace();
				}}});
		profile_icon.setBounds(380,175,135,150);
		frmPatientPage.add(profile_icon);
		JButton	logoutButton = new JButton("");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPatientPage.dispose();
				DBMS myStart_Page=null;	
				myStart_Page.main(null);
			}
		});
		logoutButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\logout.png"));
		logoutButton.setBackground(Color.white);
		logoutButton.setBounds(658,0, 51, 42);
		contentPane.add(logoutButton);
		JLabel welcom_label = new JLabel("Welcome Patient!");
		welcom_label.setForeground(Color.red);
		welcom_label.setFont(new Font("Times New Roman", Font.BOLD, 36));
		welcom_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcom_label.setBounds(255, 60, 399, 90);
		frmPatientPage.add(welcom_label);
		JButton requestButton = new JButton(" ");
		requestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {frmPatientPage.dispose();
					request();
				}
				catch(Exception e) {
				}			}});
		requestButton.setBackground(new Color(255, 255, 255));
		requestButton.setForeground(new Color(255, 102, 153));
		requestButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\requestblood.gif"));
		requestButton.setBounds(367, 355, 148, 170);
		frmPatientPage.add(requestButton);
		JButton feedButton = new JButton(" ");
		feedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmPatientPage.dispose();
					feedBack();
		} catch (Exception e) {
					e.printStackTrace();
				}}});
		feedButton.setBackground(new Color(255, 255, 255));
		feedButton.setForeground(new Color(255, 102, 153));
		feedButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\feedback.png"));
		feedButton.setBounds(380, 569,138, 110);
		frmPatientPage.add(feedButton);
	frmPatientPage.setVisible(true);	
	}
	static String a1,a2,a3,a4,a5,a6,a7;
	void feedBack() throws IOException {
	 	JFrame frmFeedbackPage = new JFrame();
			frmFeedbackPage.setTitle("FeedBack Page");
			frmFeedbackPage.setBounds(100, 190, 1227, 775);
			frmFeedbackPage.setBackground(new Color(255, 255, 255));
			frmFeedbackPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frmFeedbackPage.setContentPane(contentPane);
			contentPane.setLayout(null);
			JLabel welcom = new JLabel("Feedback Form");
			welcom.setForeground(new Color(220, 20, 60));
			welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
			welcom.setHorizontalAlignment(SwingConstants.CENTER);
			welcom.setBounds(85,10,399,90);
			frmFeedbackPage.add(welcom);
			JButton	backButton = new JButton("");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frmFeedbackPage.dispose();
try {
create();
} catch (IOException e) {}}});
			backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
			backButton.setBackground(Color.white);
			backButton.setBounds(1160,0, 51, 42);
			contentPane.add(backButton);
			BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote2.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			frmFeedbackPage.add(picLabel);
			picLabel.setBounds(0, 0, 181,725);
			JLabel Q1 = new JLabel("BBMS provides a clear documentation about the blood donor and its blood donation activities");
			Q1.setForeground(Color.black);
			Q1.setFont(new Font("Arial", Font.PLAIN,18));
			Q1.setHorizontalAlignment(SwingConstants.CENTER);
			Q1.setBounds(155, 60, 899, 90);
			frmFeedbackPage.add(Q1);
			JLabel Q2 = new JLabel("BBMS can search fast the list of possible blood donors through its donors’ files.");
			Q2.setForeground(Color.black);
			Q2.setFont(new Font("Arial", Font.PLAIN,18));
			Q2.setHorizontalAlignment(SwingConstants.CENTER);
			Q2.setBounds(149, 130, 789, 90);
			frmFeedbackPage.add(Q2);
			JLabel Q3 = new JLabel("BBMS can clearly monitor the availability of blood bags or products of all blood types");
			Q3.setForeground(Color.black);
			Q3.setFont(new Font("Arial", Font.PLAIN,18));
			Q3.setHorizontalAlignment(SwingConstants.CENTER);
			Q3.setBounds(175, 200, 789, 90);
			frmFeedbackPage.add(Q3);
			JLabel Q4 = new JLabel("BBMS allows user to know easily the period of expiration of blood bags/products.");
			Q4.setForeground(Color.black);
			Q4.setFont(new Font("Arial", Font.PLAIN,18));
			Q4.setHorizontalAlignment(SwingConstants.CENTER);
			Q4.setBounds(149, 257, 789, 90);
			frmFeedbackPage.add(Q4);
			JLabel Q5 = new JLabel("BBMS offers an organized and systematized filing or record system.");
			Q5.setForeground(Color.black);
			Q5.setFont(new Font("Arial", Font.PLAIN,18));
			Q5.setHorizontalAlignment(SwingConstants.CENTER);
			Q5.setBounds(99, 310, 789, 90);
			frmFeedbackPage.add(Q5);
			JLabel Q6 = new JLabel("BBMS provides easy to use, efficient, effective system to the users.");
			Q6.setForeground(Color.black);
			Q6.setFont(new Font("Arial", Font.PLAIN,18));
			Q6.setHorizontalAlignment(SwingConstants.CENTER);
			Q6.setBounds(85, 370, 789, 90);
			frmFeedbackPage.add(Q6);
			JLabel Q7 = new JLabel("BBMS acts as bridge between patient and donor");
			Q7.setForeground(Color.black);
			Q7.setFont(new Font("Arial", Font.PLAIN,18));
			Q7.setHorizontalAlignment(SwingConstants.CENTER);
			Q7.setBounds(19, 430, 789, 90);
			frmFeedbackPage.add(Q7);
			JLabel suggestion = new JLabel("Any suggestion to improve this system??");
			suggestion.setForeground(Color.black);
			suggestion.setFont(new Font("Arial", Font.PLAIN,18));
			suggestion.setHorizontalAlignment(SwingConstants.CENTER);
			suggestion.setBounds(140, 500, 489, 90);
			frmFeedbackPage.add(suggestion);
			  JTextField suggestionField = new JTextField();
				suggestionField.setBounds(230,570,400,100);
				frmFeedbackPage.add(suggestionField);
			int j=255;
			for(int i=0;i<5;i++) {
				String a=String.valueOf(5-i);
				JRadioButton r1=new JRadioButton(a); 
				j=j+50;
				r1.setBounds(j,120,40,30);    
				r1.setBackground(Color.white);
				frmFeedbackPage.add(r1);
				r1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a1=r1.getText();
					}});
			    }
			j=255;
			for(int i=0;i<5;i++) {
				String a=String.valueOf(5-i);
				JRadioButton r2=new JRadioButton(a); 
				j=j+50;
				r2.setBounds(j,190,40,30);    
				r2.setBackground(Color.white);
				frmFeedbackPage.add(r2);
				r2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a2=r2.getText();
					}});
			    }
			j=255;
			for(int i=0;i<5;i++) {
				String a=String.valueOf(5-i);
				JRadioButton r3=new JRadioButton(a); 
				j=j+50;
				r3.setBounds(j,250,40,30);    
				r3.setBackground(Color.white);
				frmFeedbackPage.add(r3);
				r3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a3=r3.getText();
					}});
			    }
			j=255;
			for(int i=0;i<5;i++) {
				String a=String.valueOf(5-i);
				JRadioButton r4=new JRadioButton(a); 
				j=j+50;
				r4.setBounds(j,310,40,30);    
				r4.setBackground(Color.white);
				frmFeedbackPage.add(r4);
				r4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a4=r4.getText();
					}});
			    }
			j=255;
			for(int i=0;i<5;i++) {
				String a=String.valueOf(5-i);
				JRadioButton r5=new JRadioButton(a); 
				j=j+50;
				r5.setBounds(j,370,40,30);    
				r5.setBackground(Color.white);
				frmFeedbackPage.add(r5);
				r5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a5=r5.getText();
					}});
			    }		
			j=255;
				for(int i=0;i<5;i++) {
					String a=String.valueOf(5-i);
					JRadioButton r6=new JRadioButton(a); 
					j=j+50;
					r6.setBounds(j,430,40,30);    
					r6.setBackground(Color.white);
					frmFeedbackPage.add(r6);
					r6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							a6=r6.getText();
						}});}
				j=255;
				for(int i=0;i<5;i++) {
					String a=String.valueOf(5-i);
					JRadioButton r7=new JRadioButton(a); 
					j=j+50;
					r7.setBounds(j,500,40,30);    
					r7.setBackground(Color.white);
					frmFeedbackPage.add(r7);
					r7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							a7=r7.getText();
						}});
				    }
			String suggest =String.valueOf(suggestion.getText());
			JButton NextButton = new JButton("");
			NextButton.setBackground(new Color(255, 255, 255));
			NextButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\next1.png"));
			NextButton.setBounds(570, 680, 118, 40);
			frmFeedbackPage.add(NextButton);
			frmFeedbackPage.setVisible(true);
		    NextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		String  query="insert into Feedback values(?,?,?,?,?,?,?,?)";
				PreparedStatement stmt1 = DBMS.c.c1(query);
		  try {
				stmt1.setInt(1, Integer.valueOf(a1));
				stmt1.setInt(2, Integer.valueOf(a2));
				stmt1.setInt(3, Integer.valueOf(a3));
				stmt1.setInt(4, Integer.valueOf(a4));
				stmt1.setInt(5, Integer.valueOf(a5));
				stmt1.setInt(6, Integer.valueOf(a6));
				stmt1.setInt(7, Integer.valueOf(a7));
				stmt1.setString(8,suggest);
				stmt1.executeUpdate();
				stmt1.close();
				 JOptionPane myOption = new JOptionPane();
				 myOption.showMessageDialog(null, "Thanks for your valuable feedback");
				 frmFeedbackPage.dispose();
				 DBMS myStart_Page = new DBMS();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}});}
	void request() throws IOException {
	 	JFrame frmPatientPage = new JFrame();
		frmPatientPage.setTitle("Patient Home Page");
		frmPatientPage.setBounds(100, 190, 727, 725);
		frmPatientPage.setBackground(new Color(255, 255, 255));
		frmPatientPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmPatientPage.setContentPane(contentPane);
		contentPane.setLayout(null);
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\quote2.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		frmPatientPage.add(picLabel);
		picLabel.setBounds(0, 0, 181,725);
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPatientPage.dispose();
		try {
			create();
		} catch (IOException e) {
			e.printStackTrace();
		}}});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(Color.white);
		backButton.setBounds(658,0, 51, 42);
		contentPane.add(backButton);
		JLabel Banknolabel = new JLabel("Enter your nearer Blood Bank serial no");
		Banknolabel.setForeground(Color.BLACK);
		Banknolabel.setFont(new Font("Arial", Font.PLAIN,18));
		Banknolabel.setHorizontalAlignment(SwingConstants.CENTER);
		Banknolabel.setBounds(155,60, 399, 90);
		frmPatientPage.add(Banknolabel);
		JTextField phonenumberField = new JTextField();
		phonenumberField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}}});
		phonenumberField.setColumns(6);
		phonenumberField.setBounds(525,83,150,41);
		frmPatientPage.add(phonenumberField);
		JLabel BGrplabel = new JLabel("Enter your nearer Blood Group         ");
		BGrplabel.setForeground(Color.BLACK);
		BGrplabel.setFont(new Font("Arial", Font.PLAIN,18));
		BGrplabel.setHorizontalAlignment(SwingConstants.CENTER);
		BGrplabel.setBounds(155,120, 399, 90);
		frmPatientPage.add(BGrplabel);
		String[] Bloodgropus = {"ABpositive", "ABnegative", "Bpositive", "Bnegative","Opositive","Onegative","HH"};
		JComboBox bloodtype_comboBox = new JComboBox(Bloodgropus);
		bloodtype_comboBox.setBackground(new Color(255, 255, 255));
		bloodtype_comboBox.setBounds(525,140, 108, 41);
		frmPatientPage.add(bloodtype_comboBox);
	    JButton signupButton = new JButton("Sign up");
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phonenumberField.getText().isEmpty()) 
				{
					JOptionPane myOption = new JOptionPane();
			    	myOption.showMessageDialog(null, "Field can not be empty");
				}
				requestresults(String.valueOf(phonenumberField.getText()),String.valueOf(bloodtype_comboBox.getSelectedItem()));			
			}});	
	    signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\request.gif"));
	    signupButton.setBounds(410, 600, 110, 50);
		frmPatientPage.add(signupButton);
		frmPatientPage.setVisible(true);	
	           }
	int BloodBanksData[][];
	 static JFrame displayblood = new JFrame();
	void requestresults(String BID,String Bgrp) {
	 closest1(BID,Bgrp);		
	 closest2(BID,Bgrp);
	}
	void closest2(String str,String s){
		   int Bloodbankdata[][]=getarray1("*","Blooddata");
		   int [][] string22=new int [Bloodbankdata.length][Bloodbankdata[0].length];
		   int b;String h[]= {" ","ABpositive","ABnegative","Bnegative","Bpositive","Onegative","Opositive","HH"};
		for( b=0;b<8;b++) {
if(s.equals(h[b]))
{
	break;
}
}
	int i,l=0;
		int str1=Integer.parseInt(str);
		for( i=0;i<Bloodbankdata.length;i++) {
        if(str1==Bloodbankdata[i][0]) {
        	if(Bloodbankdata[i][b]>0) {
       		   System.out.println(""+string22[0][0]+" "+Bloodbankdata[0][0]);
    	        string22[l]=Bloodbankdata[i];
      		   System.out.println(""+string22[0][0]);
            l++;     }
        	break;}}
int j=i;
++i;
	--j;	for(i=i;i<Bloodbankdata.length;i++) {
	        	if(Bloodbankdata[i][b]>0){
	        string22[l]=Bloodbankdata[i];
	        ++l;}
	       first :for(j=j;j>=0;j--) {
		        if(Bloodbankdata[j][b]>0){
		        string22[l]=Bloodbankdata[j];
		       ++l;
		       --j;
		        break first;
		        }}}
	 displayblood.setTitle("Request results");
	 displayblood.setBounds(100, 200,1120, 925);
	 displayblood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 displayblood.getContentPane().setLayout(null);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		displayblood.setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel side_panels = new JPanel();
	side_panels.setBackground(new Color(220, 20, 60));
	side_panels.setBounds(0, 0, 151,1125);
	displayblood.add(side_panels);
	JButton	backButton = new JButton("");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			displayblood.dispose();
try {
	request();
} catch (IOException e) {
	e.printStackTrace();
}}});
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBackground(Color.white);
	backButton.setBounds(1058,0, 51, 42);
	contentPane.add(backButton);
	JLabel welcom = new JLabel("Blood Bank Data");
	welcom.setForeground(Color.blue);
	welcom.setFont(new Font("Times New Roman", Font.BOLD,30));
	welcom.setHorizontalAlignment(SwingConstants.CENTER);
	welcom.setBounds(130,10,399,90);
   String column[]={"BID","AB+ve","AB-ve","B+ve","B-ve","O+ve","O-ve","HH"}; 
	String BloodBanksData[][]=new String [Bloodbankdata.length][Bloodbankdata[0].length];
   for(int l1=0;l1<string22.length;l1++)
	   for(int l2=0;l2<string22.length;l2++)
   BloodBanksData[l1][l2]=String.valueOf(string22[l1][l2]);
   JTable table = new JTable(BloodBanksData,column);     
	      Font font = new Font("Verdana", Font.PLAIN, 12);
	      table.setFont(font);
	      table.setRowHeight(30);
	      JScrollPane sp=new JScrollPane(table);  
	        displayblood.getContentPane().setLayout(new BorderLayout());
	        displayblood.getContentPane().add(welcom,BorderLayout.PAGE_START);
	        displayblood.getContentPane().add(sp,BorderLayout.CENTER);
	  	    displayblood.add(table);
     	  	table.setBounds(200,90,250,250);
	JLabel welcom1 = new JLabel("Donors Data");
	welcom1.setForeground(Color.blue);
	welcom1.setFont(new Font("Times New Roman",Font.BOLD,30));
	welcom1.setHorizontalAlignment(SwingConstants.CENTER);
	welcom1.setBounds(130,500,399,90);
    }
	static void closest1(String str,String s)
	{
	   String Donors[][]=getarray2("*","sDonor");
	   String [][] string2=new String [Donors.length][Donors[0].length];
		int i,l=0;
		String str1="yes";
		for( i=0;i<Donors.length;i++) {
	    if(str.equals(Donors[i][0])) {
	    	if(s.equals(Donors[i][3]))
	    	if(str1.equals(Donors[i][1]))
		        string2[l]=Donors[i];
	        l++;     
	    	break;}}
	int j=i;
	++i;
	--j;
	for(i=i;i<Donors.length;i++) {
	        if(str1.equals(Donors[i][1]))
	        	if(s.equals(Donors[i][3])){
	        string2[l]=Donors[i];
	        ++l;}
	       first :for(j=j;j>=0;j--) {
		        if(str1.equals(Donors[j][1])) 
		        if(s.equals(Donors[j][3])){
		        string2[l]=Donors[j];
		       ++l;
		       --j;
		        break first;}}}
	   String column[]={"ID","BID","BGrp","Name","Age","Address","Mobile","LDD","status"}; 
	  JTable table = new JTable(Donors,column);     
      Font font = new Font("Verdana", Font.PLAIN, 12);
      table.setFont(font);
      table.setRowHeight(30);
      JScrollPane sp=new JScrollPane(table);  
        displayblood.getContentPane().setLayout(new BorderLayout());
        displayblood.getContentPane().add(sp,BorderLayout.CENTER);
  	    displayblood.add(table);
  	    displayblood.setVisible(true);
 	  	table.setBounds(200,90,250,250);}
	static int[][] getarray1(String str1,String str2)
	{
		try {
			String query="select "+str1+" from "+str2+" order by BID";
	        ResultSet rs = DBMS.c.c2(query);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int a=rsmd.getColumnCount();
	        String query2="SELECT COUNT(*) FROM Blooddata";
	        ResultSet rs1 = DBMS.c.c2(query2);
	        int b=0;
	        if(rs1.next())
	        b=rs1.getInt(1);
	        int bloodbanks[][]=new int [b][a];
	        int j=0;
	        while(rs.next())
	        {
	        	bloodbanks[j][0]=Integer.valueOf(rs.getString(1));
	        	for(int i=2;i<a+1;i++) {
	        		bloodbanks[j][i-1]=Integer.valueOf(rs.getInt(i));
	        	}	
	        	j++;
	        }
	        
	   return bloodbanks;	
		
		}
		catch(Exception e)
		{	
			System.out.println(""+e);
			return null;
		}
		}
	static String[][] getarray2(String str1,String str2)
	{
		try {
			String query="select "+str1+" from "+str2+" order by BID";
	        ResultSet rs = DBMS.c.c2(query);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int a=rsmd.getColumnCount();
	        String query2="SELECT COUNT(*) FROM Donordata";
	        ResultSet rs1 = DBMS.c.c2(query2);
	        int b=0;
	        if(rs1.next())
	        b=rs1.getInt(1);
	        String Donordata[][]=new String [b][a];
	        int j=0;
	        while(rs.next())
	        {
	        	for(int i=1;i<a+1;i++) {
	    			int type=rsmd.getColumnType(i);
	    			if(type == Types.VARCHAR)
	          			Donordata[j][i-1]=rs.getString(i);
	          		else if(type == Types.NUMERIC)
	          			Donordata[j][i-1]=String.valueOf(rs.getInt(i));          		
	          		else if(type==Types.DATE)
	         			Donordata[j][i-1]=String.valueOf(rs.getDate(i));          		          		
	          		else if(type==Types.CHAR)
	          			Donordata[j][i-1]=String.valueOf(rs.getString(i));
	          		else if(type==Types.INTEGER)
	          			Donordata[j][i-1]=String.valueOf(rs.getInt(i));
	        	}	
	        	j++;
	        }
	        
	   return Donordata;	
		}
		catch(Exception e)
		{	
			System.out.println(""+e);
			return null;
		}
		}
void profile() throws SQLException {
	JFrame frmDonorPage1 = new JFrame();
	frmDonorPage1.setTitle("Profile Page");
	frmDonorPage1.setBounds(100, 100, 727, 725);
	frmDonorPage1.setBackground(new Color(255, 255, 255));
	frmDonorPage1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmDonorPage1.setContentPane(contentPane);
	contentPane.setLayout(null);
	frmDonorPage1.setVisible(true);
	contentPane.setVisible(true);
	JLabel StartPagePhoto1 = new JLabel("");
	StartPagePhoto1.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	StartPagePhoto1.setHorizontalAlignment(SwingConstants.CENTER);
	StartPagePhoto1.setBounds(0,0,820,820);
	JButton btnNewButton = new JButton(" ");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			try {
				frmDonorPage1.dispose();
create();
} catch (Exception e) {
				e.printStackTrace();
			}}});
	btnNewButton.setBackground(new Color(255, 255, 255));
	btnNewButton.setForeground(new Color(255, 102, 153));
	btnNewButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	btnNewButton.setBounds(12, 13, 43, 42);
	contentPane.add(btnNewButton);
	JLabel Name_label = new JLabel("Name");
	Name_label.setHorizontalAlignment(SwingConstants.CENTER);
	Name_label.setForeground(new Color(220, 20, 60));
	Name_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Name_label.setBounds(486, 139, 159, 68);
	contentPane.add(Name_label);	
	JLabel BID_label = new JLabel("BID");
	BID_label.setHorizontalAlignment(SwingConstants.CENTER);
	BID_label.setForeground(new Color(220, 20, 60));
	BID_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	BID_label.setBounds(396, 233, 369, 68);
	contentPane.add(BID_label);
	JLabel PhoneNum_label = new JLabel("Phone number");
	PhoneNum_label.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNum_label.setForeground(new Color(220, 20, 60)); 
	PhoneNum_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	PhoneNum_label.setBounds(396, 319, 369, 68);
	contentPane.add(PhoneNum_label);
	JLabel Bgrp_label = new JLabel("Blood Grp");
	Bgrp_label.setHorizontalAlignment(SwingConstants.CENTER);
	Bgrp_label.setForeground(new Color(220, 20, 60));
	Bgrp_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Bgrp_label.setBounds(386, 416,368,68);
	contentPane.add(Bgrp_label);
	JLabel Address_Label = new JLabel("Address");
	Address_Label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
	Address_Label.setForeground(new Color(220, 20, 60));
	Address_Label.setHorizontalAlignment(SwingConstants.CENTER);
	Address_Label.setBounds(386, 481, 369, 68);
	contentPane.add(Address_Label);	
	JLabel NameFixed = new JLabel("Name:");
	NameFixed.setHorizontalAlignment(SwingConstants.CENTER);
	NameFixed.setForeground(Color.WHITE);
	NameFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	NameFixed.setBounds(46, 145, 369, 68);
	contentPane.add(NameFixed);
	JLabel BIDFixed = new JLabel("BID:");
	BIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	BIDFixed.setForeground(Color.WHITE);
	BIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	BIDFixed.setBounds(46,233, 369, 68);
	contentPane.add(BIDFixed);
    JLabel PhoneNumberFixed = new JLabel("Phone Number:");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	PhoneNumberFixed.setBounds(46, 316, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JLabel BgrpFixed = new JLabel("Blood Grp:");
	BgrpFixed.setHorizontalAlignment(SwingConstants.CENTER);
	BgrpFixed.setForeground(Color.white);
	BgrpFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	BgrpFixed.setBounds(20, 346, 502, 160);
	contentPane.add(BgrpFixed);
	JLabel Addressfixed = new JLabel("Address :");
	Addressfixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
	Addressfixed.setForeground(Color.white);
	Addressfixed.setHorizontalAlignment(SwingConstants.CENTER);
	Addressfixed.setBounds(46, 481, 369, 68);
	contentPane.add(Addressfixed);	
	JLabel lblNewLabel_1_4 = new JLabel("Profile");
	lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_4.setForeground(Color.BLACK);
	lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
	lblNewLabel_1_4.setBounds(190,0, 369, 68);
	contentPane.add(lblNewLabel_1_4);
    String query ="select * from patientdata where ID = '"+DBMS.userid+"'";
    ResultSet rs= DBMS.c.c2(query);
	    while(rs.next()) {
	        Name_label.setText(String.valueOf(rs.getString(2)));
	    	BID_label.setText(String.valueOf(rs.getString(4)));
	    	PhoneNum_label.setText(String.valueOf(rs.getString(7)));
	    	Address_Label.setText(String.valueOf(rs.getString(6)));
	    	Bgrp_label.setText(String.valueOf(rs.getString(5)));
	        }
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 700, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmDonorPage1.dispose();
			updatedetails();
			} catch (Exception e) {
			}		}
	});
frmDonorPage1.add(StartPagePhoto1);
}
void updatedetails() {
	JFrame frmdonorupdatePage = new JFrame();
	frmdonorupdatePage.setTitle("Update details");
	frmdonorupdatePage.setBounds(100, 100, 727, 725);
	frmdonorupdatePage.setBackground(new Color(255, 255, 255));
	frmdonorupdatePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	frmdonorupdatePage.setContentPane(contentPane);
	contentPane.setLayout(null);
	JButton backButton = new JButton(" ");
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmdonorupdatePage.dispose();
  profile();
			} catch (Exception e) {
				e.printStackTrace();
			}}});
	backButton.setBackground(new Color(255, 255, 255));
	backButton.setForeground(new Color(255, 102, 153));
	backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
	backButton.setBounds(12, 13, 43, 42);
	contentPane.add(backButton);
	JLabel ProfilePagePhoto = new JLabel("");
	ProfilePagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\profilepage.png"));
	ProfilePagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	ProfilePagePhoto.setBounds(0,0,820,820);
	String roles[]={"Age","MOBILENO","Address"};        
	final JComboBox updatelabel=new JComboBox(roles);
	updatelabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	updatelabel.setBackground(new Color(245, 245, 245));
	updatelabel.setBounds(389, 188, 234, 41);
	contentPane.add(updatelabel);
	JTextField updated = new JTextField();
    updated.setBounds(389, 288, 172, 41);
    frmdonorupdatePage.add(updated);
    JLabel UserIDFixed = new JLabel("Field");
	UserIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
	UserIDFixed.setForeground(Color.WHITE);
	UserIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	UserIDFixed.setBounds(46, 173, 369, 68);
	contentPane.add(UserIDFixed);
	JLabel PhoneNumberFixed = new JLabel("New value");
	PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
	PhoneNumberFixed.setForeground(Color.WHITE);
	PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
	PhoneNumberFixed.setBounds(46, 273, 369, 68);
	contentPane.add(PhoneNumberFixed);
	JButton updateButton = new JButton("");
	updateButton.setBackground(new Color(255, 255, 255));
	updateButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\update.png"));
	updateButton.setBounds(239, 600, 200, 60);
	contentPane.add(updateButton);
	updateButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				frmdonorupdatePage.dispose();
			    String query="Update donordata set "+String.valueOf(updatelabel.getSelectedItem())+"='"+String.valueOf(updated.getText())+"'where ID='"+DBMS.userid+"'";
				PreparedStatement stmt=DBMS.c.c1(query);
				stmt.execute();
				JOptionPane myOption = new JOptionPane();
				myOption.showMessageDialog(null, "Details Updated successfully");
		create();
			} catch (Exception e) {				
			JOptionPane myOption = new JOptionPane();
			myOption.showMessageDialog(null, "Unable to Update details successfully\nTry after some Time");
			System.out.print(e);
try {
	create();
} catch (IOException e1) {
	e1.printStackTrace();
}}}});
contentPane.add(ProfilePagePhoto);
frmdonorupdatePage.dispose();
frmdonorupdatePage.setVisible(true);
}}


class Editdata{
	display d;
	Scanner sc=new Scanner(System.in);
	void adddata(String table)
	{
		login obj=null;
		try {
      String query="Select * from "+table;
      int count=0;
	   ResultSet rs = DBMS.c.c2(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int n=rsmd.getColumnCount();
		 query=" insert into "+table+" values (";
		for(int i=1;i<=n;i++)
			if(i!=n)
		query=query+"?,";
			else
				query=query+"?)";
        PreparedStatement stmt = DBMS.c.c1(query);
		for(int i=1;i<=n;i++) {
			int type=rsmd.getColumnType(i);
			if(rsmd.getColumnName(i).equals("PASSWORD")) {
				System.out.print(
		    	        "1. A password must have at least eight characters.\n" +
		    	        "2. A password consists of only letters,special characters and digits.\n" +
		    	        "3. A password must contain at least one upper case,lower case,special character,digit \n" );
     		System.out.println("Enter your password");
     		String str=sc.next();
        	while(!obj.validpassword(str))//calling password strength checker
        	{
        		System.err.println("your password strength is not strong");
        		System.out.println("Enter your password");
        		str=sc.next();}
            System.out.println("Confirm your password");
           count++; }
			else
			System.out.println("Enter "+rsmd.getColumnName(i)+" of the person");
      		Date d=null;
			if(type == Types.VARCHAR)
      			stmt.setString(i,sc.next());
      		else if(type == Types.NUMERIC)
      			stmt.setInt(i,sc.nextInt());
      		else if(type==Types.DATE) {
      			 d = Date.valueOf(sc.next());
      			stmt.setDate(i,d);
      			if(rsmd.getColumnName(i).equals("LDD"))
      			{i=i+1;
      				stmt.setDate(i,d);
      				i=i+1;
      			stmt.setDate(i,d);
      			}}
      		else if(type==Types.CHAR)
      			stmt.setString(i,sc.next());
      		else if(type==Types.INTEGER)
			   stmt.setInt(i,sc.nextInt());
		}
		stmt.execute();
		if(count==0) {
		System.out.println("Details added successfully");
        System.out.println("Hit 1 key to display");
        int k=sc.nextInt();
        if(k==1)
        	if(table.equals("blodddonordata"))
                d=new display("*","bdonor");
        	else	
        d=new display("*",table);}
		else {
			System.out.println("Login Details added successfully");
			System.out.println("Enter your personal details");
		}}
		catch(Exception e)
		{
			System.out.println(""+e);
		}}
void deletedata(String table,String table2) {
    String query="Select * from "+table;
	ResultSet rs = DBMS.c.c2(query);
	String str="ID";
	String stri=table2;
	if(table2.equals("")) {
	   try {
		   stri="bdonor";
			ResultSetMetaData rsmd = rs.getMetaData();
			str=rsmd.getColumnName(2);
		} catch (SQLException e1) {
			e1.printStackTrace();}}
	d=new display("*",stri);
    System.out.println("Enter the "+str+" to be deleted");
	String a=sc.next();
     query ="DELETE FROM "+table+" WHERE "+str+" = '"+a+"'";
 	String query1 ="DELETE FROM "+table2+" WHERE "+str+"='"+a+"'";
	try {
		PreparedStatement stmt = DBMS.c.c1(query1);
	    if(!table2.equals("")) {
        stmt.execute();}
        stmt = DBMS.c.c1(query);
        stmt.execute();
	}
	catch(Exception e)
	{
		System.out.println(""+e);
	}
	System.out.println("Details deleted successfully");
    System.out.println("Hit 1 key to display");
    int k=sc.nextInt();
    if(k==1)
    if(!table2.equals(""))
    d=new display("*","bdonor");
    else
    	d=new display("*",table);
	}
void updatedata(String table) {
	String query="Select * from "+table;
    ResultSet rs = DBMS.c.c2(query);
    String str="ID";
	if(table.equals("blodddonordata")) {
		   try {
			   table="bdonor";
				ResultSetMetaData rsmd = rs.getMetaData();
				str=rsmd.getColumnName(2);
			} catch (SQLException e1) {
				e1.printStackTrace();}}
    System.out.println("Enter your "+str);
	String ID = sc.next();
	d=new display("*",table,str,ID);
	System.out.println("Enter the name of the coloumn to be changed(if multiple seperate them by character ',')");
	String c =sc.next();
	String[] words=c.split(",");	
	System.out.println("Enter the detail to be inserted(if multiple seperate them by character ',')");
	String detail=sc.next();
	String[] details=detail.split(",");	
	int n= words.length;
	 query= "UPDATE " +table;
for(int i=0;i<n;i++)    
   if(i!=n-1)
	query = query + " Set "+words[i]+"= '"+details[i]+"',";
   else
	   query=query+" "+words[i]+" "+"="+"'"+details[i]+"'"+" WHERE "+str+" = '"+ID+"';";
try {
    PreparedStatement stmt = DBMS.c.c1(query);
    stmt.execute();
}
catch(Exception e)
{
	System.out.println(""+e);
}
System.out.println("Details updated successfully");
System.out.println("Hit 1 key to display");
int k=sc.nextInt();
if(k==1)
	if(table.equals("blodddonordata"))
        d=new display("*","bdonor");
	else	
   d=new display("*",table);
}}
class Editblooddata {
	Editblooddata(String str){
		display d;
		Editdata obj = new Editdata();
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("Choose the operation");
			System.out.println("1)Add Blood");
			System.out.println("2)Remove Blood");
			System.out.println("3)Display");
			System.out.println("4)Update the list");
			System.out.println("5)logout");
			int b = 0,a=scan.nextInt();
		if(a!=4&&a!=5&&a!=3) {	
        System.out.println("Choose the Blood group to be updated");
		System.out.println("1)AB+ve");
		System.out.println("2)AB-ve");
		System.out.println("3)B+ve");
		System.out.println("4)B-ve");
		System.out.println("5)O+ve");
		System.out.println("6)O-ve");
		System.out.println("7)HH");
		 b=scan.nextInt();
		}
        switch(a){
case 1:
	String[] Bloodgroups = {"Bank id","ABpositive", "ABnegative", "Bpositive", "Benegative","Opositive","Opositive,HH"};
	String bgrp1=Bloodgroups[b];
	d=new display("*","Bdonor","BID",str,"Bgrp",bgrp1);
	System.out.println("Choose the Donor from the data if new donor press 0");
	a=scan.nextInt();
	if(a==0) {
	obj.adddata("BLODDDONORDATA");
	d=new display("*","bdonor","BID",str);
	System.out.println("Choose the Donor from the data displayed");
	a=scan.nextInt();
	}
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis); 
	String query="Select ldd from blodddonordata where BDID = "+String.valueOf(a);
    String grp=null;
    Date date1=null;
	 ResultSet rs=DBMS.c.c2(query);
			try {
				while(rs.next())
					date1=rs.getDate(1);
			} catch (Exception e) {
				System.out.println(""+e);
			}
	long duration  = date.getTime() - date1.getTime();
	int numofDays = (int) (duration / (1000 * 60 * 60 * 24));
	if(numofDays<56)//as per biological norms a person cannot donate blood before 56 days from his last donation
{
		System.out.println("He is not applicable from donation as he donated blood "+numofDays+" ago");
         continue;		
}
  query="Select Bgrp from blodddonordata where BDID = "+String.valueOf(a);
    ResultSet rs1=DBMS.c.c2(query);
   		try {
   			while(rs1.next())
			 grp=rs1.getString(1);
			} catch (Exception e) {
         System.out.println(""+e);
			}
      query = "UPDATE Blooddata SET "+grp+" = "+grp+" + 1 WHERE BID = '"+str+"'";
      PreparedStatement stmt=DBMS.c.c1(query);
			try {
				stmt.execute();
			} catch (Exception e) {
				System.out.println(""+e);
			}
			String da1=String.valueOf(date);
			  query = "UPDATE Blodddonordata SET LDD = '"+date+"',LDD1 = '"+date+"',LDD2 = '"+date+"'  WHERE BDID = '"+String.valueOf(a)+"'";
		       stmt=DBMS.c.c1(query);
					try {
						stmt.execute();
					} catch (Exception e) {
						System.out.println(""+e);
					}
      System.out.println("Details added successfully");
      System.out.println("Enter 1 to display the data");
      int f =scan.nextInt();
      if(f==1)
    	  d=new display("*","blooddata","BID",str);
      continue;
case 2:
	String[] Bloodgropus = {"Bank id","ABpositive", "ABnegative", "Bpositive", "Bnegative","Opositive","Opositive,HH"};
	String grp1=Bloodgropus[b];
	  query = "UPDATE Blooddata SET "+grp1+" = "+grp1+" - 1 WHERE BID ="+str;
      PreparedStatement smt=DBMS.c.c1(query);
			try {
				smt.execute();
			} catch (Exception e) {
				System.out.println(""+e);
			}
      System.out.println("Details updated successfully");
      System.out.println("Enter 1 to display the data");
      int f1 =scan.nextInt();
      if(f1==1)
    	  d=new display("*","blooddata","BID",str);
      continue;
case 3:
	  d=new display("*","blooddata","BID",str);
	  continue;
case 4:
	//updates the list 
		query = "select Bgrp,ldd1,ldd2,BDID from blodddonordata where BID ="+str;
		ResultSet rsmt= DBMS.c.c2(query);
			try {
				while(rsmt.next())
				{
					Date dat;
					String bgrp=rsmt.getString(1);
					long mill=System.currentTimeMillis();  
					java.sql.Date da=new java.sql.Date(mill); 
					if(rsmt.getDate(3)!=null)
					 dat=rsmt.getDate(2);
					else
						dat=da;
					String DonorID=rsmt.getString(4);
					//getting the duration from his last donation date 
					long dur  = da.getTime() - dat.getTime();
					int nofDays = (int) (dur / (1000 * 60 * 60 * 24));
					//if blood is not utilized for more than 42 days it gets spoiled
					if(nofDays>42){
						query = "UPDATE Blooddata SET "+bgrp+" = "+bgrp+" - 1 WHERE BID ="+str;
						PreparedStatement stamt=DBMS.c.c1(query);
						try {
							stamt.execute();
						} catch (Exception e) {
							System.out.println(""+e);
						}
						query="Update blodddonordata SET ldd2 = null where BDID="+DonorID;
						stamt=DBMS.c.c1(query);
						try {
							stamt.execute();
						} catch (Exception e) {
							System.out.println(""+e);
						}}}
				System.out.println("List was Updated successfully");
			} catch (Exception e) {
				System.out.println(""+e);
			}
			continue;
case 5:
	DBMS.main(null);
default :
	System.err.println("You have entered wrong key!!!");
        }}}}
public class DBMS {
	static JFrame frmloginPage;
	private static JTextField user_idField;
	private static JPasswordField passwordField;
    static connector c = new connector();
    static String role,userid,password;
    static DBMS o = new DBMS();
public static void main(String[] args){	
	JFrame frmHomePage = new JFrame();
	frmHomePage.setTitle("Blood Bank Management system Home Page");
	frmHomePage.setBounds(100, 100,915,670);
	frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmHomePage.getContentPane().setLayout(null);
	frmHomePage.setBackground(Color.white);
	JLabel HomePagePhoto = new JLabel("");
	HomePagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\blood1.jpg"));
	HomePagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	HomePagePhoto.setBounds(0,0,900,625);
	frmHomePage.getContentPane().add(HomePagePhoto);
	frmHomePage.setVisible(true);
JButton loginButton = new JButton();
loginButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		frmHomePage.dispose();
		create();
    }});
loginButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\login2.jpg"));
loginButton.setBackground(Color.gray);
loginButton.setBounds(369, 560, 150, 60);
HomePagePhoto.add(loginButton);
}
static void create()
{
	frmloginPage = new JFrame();
	frmloginPage.setTitle("Blood Bank Management system Login Page");
	frmloginPage.setBounds(100, 100, 710, 725);
	frmloginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmloginPage.getContentPane().setLayout(null);
	frmloginPage.setBackground(Color.white);
	JLabel LoginPagePhoto = new JLabel("");
	LoginPagePhoto.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\blood.jpg"));
	LoginPagePhoto.setHorizontalAlignment(SwingConstants.CENTER);
	LoginPagePhoto.setBounds(0,0,700,245);
	frmloginPage.getContentPane().add(LoginPagePhoto);
	JLabel welcomeLabel = new JLabel("Welcome!");
	welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
	welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	welcomeLabel.setBounds(152, 239, 369, 47);
	frmloginPage.getContentPane().add(welcomeLabel);
	String roles[]={"Administrator","Bloodbankemployee","Donor","Patient"};        
	final JComboBox roles_combobox=new JComboBox(roles);
	roles_combobox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	roles_combobox.setBackground(new Color(245, 245, 245));
	roles_combobox.setBounds(189, 288, 334, 41);
	frmloginPage.getContentPane().add(roles_combobox);
	user_idField = new JTextField();
	user_idField.setBounds(189, 350, 334, 41);
	frmloginPage.getContentPane().add(user_idField);
	user_idField.setColumns(10);
	passwordField = new JPasswordField();
	passwordField.setColumns(10);
	passwordField.setBounds(189, 420, 334, 41);
	frmloginPage.getContentPane().add(passwordField);
	JLabel useridLabel = new JLabel("User ID");
	useridLabel.setHorizontalAlignment(SwingConstants.CENTER);
	useridLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	useridLabel.setBounds(39, 350, 121, 41);
	frmloginPage.getContentPane().add(useridLabel);
	JLabel passwordLabel = new JLabel("Password");
	passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
	passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	passwordLabel.setBounds(39, 420, 121, 41);
	frmloginPage.getContentPane().add(passwordLabel);
	JButton signinButton = new JButton("");
	signinButton.setBackground(new Color(255, 255, 255));
	signinButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\signin.png"));
	signinButton.setBounds(275, 489, 118, 40);
	frmloginPage.getContentPane().add(signinButton);
	signinButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
			role = String.valueOf(roles_combobox.getSelectedItem());
			userid=user_idField.getText();
			password=passwordField.getText();
			if(user_idField.getText().isEmpty()||passwordField.getText().isEmpty()||String.valueOf(roles_combobox.getSelectedItem())==null)
			{			
			JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Fields cannot be empty");
	    	frmloginPage.dispose();
	    	create();
			}
			if(role.equals("Administrator")) {
				frmloginPage.dispose();
			 administrator ob=new administrator();
			}
		 if(role.equals("Bloodbankemployee"))
		 {		try {
				frmloginPage.dispose();
					bloodbankemployee obj2=new bloodbankemployee();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} }
		 if(role.equals("Donor"))
		 {		frmloginPage.dispose();
try {
Donor obj=new Donor();
} catch (IOException e1) {
e1.printStackTrace();
}}
		 if(role.equals("Patient"))
		 {		frmloginPage.dispose();
try {
Patient obj=new Patient();
} catch (IOException e1) {
e1.printStackTrace();
} catch (Exception e1) {
	e1.printStackTrace();
}}}});
	JButton signupButton = new JButton("");
	signupButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\signup1.png"));
	signupButton.setBackground(Color.gray);
	signupButton.setBounds(239, 600, 200, 60);
	frmloginPage.getContentPane().add(signupButton);
	frmloginPage.setVisible(true);
	 JFrame frmsignupPage = new JFrame();
	 frmsignupPage.setTitle("Blood bank");
	 frmsignupPage.setBounds(100, 100, 710, 725);
	 frmsignupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frmsignupPage.getContentPane().setLayout(null);
	String sroles[]={"Donor","Patient"};        
	final JComboBox slabel=new JComboBox(sroles);
	slabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	slabel.setBackground(new Color(245, 245, 245));
	slabel.setBounds(296, 89, 255, 41);
	JPanel panel = new JPanel();
	panel.setBackground(new Color(220, 20, 60));
	panel.setBounds(0, 0, 1100, 58);
	frmsignupPage.add(panel);
	frmsignupPage.add(slabel);
	panel.setLayout(null);
   JLabel role_label = new JLabel("Choose your role");
   role_label.setFont(new Font("Tahoma", Font.BOLD, 20));
   role_label.setBounds(101, 91, 169, 35);
	frmsignupPage.add(role_label);
	JButton nextButton = new JButton("");
	nextButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\next.png"));
	nextButton.setBackground(Color.gray);
	nextButton.setBounds(239, 600, 200, 60);
	frmsignupPage.getContentPane().add(nextButton);
	String role2;
		JButton	backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmsignupPage.dispose();
				DBMS myStart_Page=null;	
				myStart_Page.main(null);
			}
		});
		backButton.setIcon(new ImageIcon("C:\\Users\\Chakradhar\\Desktop\\OOPs project\\DBMS\\back.jpg"));
		backButton.setBackground(new Color(220, 20, 60));
		backButton.setBounds(12, 13, 51, 42);
		panel.add(backButton);
	signupButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{		
			frmloginPage.dispose();
         		frmsignupPage.setVisible(true);
         		nextButton.addActionListener(new ActionListener() {
         			public void actionPerformed(ActionEvent e) 
         			{
     				if(String.valueOf(slabel.getSelectedItem()).equals("Donor")) {
						 try {
							 frmsignupPage.dispose();
							signup obj=new signup(0);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						 }
					else {
						 try {							 
							    frmsignupPage.dispose();
								signup obj=new signup(1);
							} catch (SQLException e1) {
								e1.printStackTrace();
				 }}}});}});}}