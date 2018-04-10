import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = -4847569599721799776L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	private static final String DB_USER2 = "C##APP_USER";
	
	private JTextField tfuserName;
	private JTextField tfPassword;
	public Tables table;

	public Login() {
		getContentPane().setLayout(null);
		
		this.setBounds(200, 100 ,500, 300 );
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.awt.EventQueue.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						if(tfuserName.getText().equals(DB_USER) && tfPassword.getText().equals(DB_PASSWORD)) {
							table = new Tables();
							table.setVisible(true);
						}
						else if(tfuserName.getText().equals(DB_USER2) && tfPassword.getText().equals(DB_PASSWORD)) {
							new UserTables();
							
						}
						
						
					}
				});
				
				
			}
		});
		btnLogin.setBounds(188, 162, 89, 23);
		getContentPane().add(btnLogin);
		
		tfuserName = new JTextField();
		tfuserName.setBounds(212, 59, 120, 20);
		getContentPane().add(tfuserName);
		tfuserName.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(212, 107, 120, 20);
		getContentPane().add(tfPassword);
		tfPassword.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(139, 62, 63, 14);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(139, 110, 63, 14);
		getContentPane().add(lblPassword);
	}
}
