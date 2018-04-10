import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Users extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfUserName;
	private JTextField tfUserPass;
	private JTextField tfEmail;
	private JTextField tfNumReg;
	private JTextField tfServerId;
	public String userName , userPassword , email;
	public int numreg , serverId;
	
	public Users() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(10, 82, 77, 14);
		getContentPane().add(lblUserName);
		
		tfServerId = new JTextField();
		tfServerId.setColumns(10);
		tfServerId.setBounds(127, 217, 86, 20);
		getContentPane().add(tfServerId);
		
		
		tfUserName = new JTextField();
		tfUserName.setColumns(10);
		tfUserName.setBounds(127, 79, 86, 20);
		getContentPane().add(tfUserName);
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(223, 130, 251, 20);
		getContentPane().add(lblWronginput);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int serverNum = Integer.parseInt(tfServerId.getText());
					
					int  id = db.getIds("SERVERID" , "MMOSERVER" , serverNum);
					if(id != 0) {
						userName = tfUserName.getText();
						userPassword = tfUserPass.getText();
						email = tfEmail.getText();
						numreg = Integer.parseInt(tfNumReg.getText());
						serverId = Integer.parseInt(tfServerId.getText());
						db.insertIntoUsers(userName,  userPassword,  email,  numreg ,  serverId);
						lblWronginput.setText("Record is inserted");
					}
					else {
						lblWronginput.setText("No Server Exsist");
					}
					
				}catch (Exception ex) {
					lblWronginput.setText("Wrong input");
				}
				
				
			}
		});
		button.setBounds(201, 11, 89, 23);
		getContentPane().add(button);
		
		tfUserPass = new JTextField();
		tfUserPass.setColumns(10);
		tfUserPass.setBounds(127, 114, 86, 20);
		getContentPane().add(tfUserPass);
		
		JLabel lblUserPassword = new JLabel("User password");
		lblUserPassword.setBounds(10, 117, 89, 14);
		getContentPane().add(lblUserPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 154, 89, 14);
		getContentPane().add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(127, 151, 86, 20);
		getContentPane().add(tfEmail);
		
		tfNumReg = new JTextField();
		tfNumReg.setColumns(10);
		tfNumReg.setBounds(127, 186, 86, 20);
		getContentPane().add(tfNumReg);
		
		JLabel label_3 = new JLabel("Number registered");
		label_3.setBounds(10, 189, 108, 14);
		getContentPane().add(label_3);
		
		JLabel lblServerId = new JLabel("Server id");
		lblServerId.setBounds(10, 220, 108, 14);
		getContentPane().add(lblServerId);
		
	}
	
}
