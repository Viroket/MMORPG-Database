import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Procedure extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	public String itemName;
	public int numOfChosenLetters;
	private JTextField tfItemId;
	
	public Procedure() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(385, 15, 99, 14);
		getContentPane().add(lblWronginput);
		
		JLabel lbWhatWeFound = new JLabel("");
		lbWhatWeFound.setFont(new Font("David", Font.BOLD, 20));
		lbWhatWeFound.setBounds(133, 85, 242, 140);
		getContentPane().add(lbWhatWeFound);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					itemName = db.getItemFromIdProc(Integer.parseInt(tfItemId.getText()));
					lbWhatWeFound.setText(itemName);
				}catch(NumberFormatException e) {
					e.printStackTrace();
				}			
			}
		});
		btnSubmit.setBounds(182, 11, 89, 23);
		getContentPane().add(btnSubmit);
		
		tfItemId = new JTextField();
		tfItemId.setBounds(281, 12, 94, 20);
		getContentPane().add(tfItemId);
		tfItemId.setColumns(10);
		
		JLabel lblEnterItemId = new JLabel("Enter item id to find its name");
		lblEnterItemId.setBounds(10, 15, 162, 14);
		getContentPane().add(lblEnterItemId);
		
		
		
		
		
		
	}
}
