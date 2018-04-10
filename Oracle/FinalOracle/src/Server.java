import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Server extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfName;
	private JTextField tfMaxCapa;
	private JTextField tfCurrOnline;
	private JTextField tfNumRegis;
	public String name , maxCapa , CurrOnline , NumRegis;
	
	public Server() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		JLabel jfWoungInput = new JLabel("");
		jfWoungInput.setBounds(219, 117, 265, 31);
		getContentPane().add(jfWoungInput);
		
		JLabel label = new JLabel("");
		label.setBounds(219, 159, 265, 31);
		getContentPane().add(label);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					name = tfName.getText();
					maxCapa = tfMaxCapa.getText();
					CurrOnline = tfCurrOnline.getText();
					NumRegis = tfNumRegis.getText();
					
					int maxCapa1 = Integer.parseInt(maxCapa);
					int CurrOnline1 = Integer.parseInt(CurrOnline);
					int NumRegis1 = Integer.parseInt(NumRegis);
					if(CurrOnline1 <  NumRegis1 && maxCapa1 > NumRegis1) {
						db.insertIntoServer(name, maxCapa1, CurrOnline1,NumRegis1);
						jfWoungInput.setText("Record is inserted");
					}else {
						jfWoungInput.setText("Regist players must be higher then ");
						label.setText("online players and lower then capacity");
					}
					
				} catch (Exception e){
					jfWoungInput.setText("Woung input try again");
				}
				
				
			}
		});
		btnInsert.setBounds(201, 11, 89, 23);
		getContentPane().add(btnInsert);
		
		JLabel lblServerName = new JLabel("Server name");
		lblServerName.setBounds(10, 82, 77, 14);
		getContentPane().add(lblServerName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(127, 79, 86, 20);
		getContentPane().add(tfName);
		
		JLabel lblMaxCapacity = new JLabel("Max capacity");
		lblMaxCapacity.setBounds(10, 117, 89, 14);
		getContentPane().add(lblMaxCapacity);
		
		JLabel lblCurrentOnline = new JLabel("Current online");
		lblCurrentOnline.setBounds(10, 154, 89, 14);
		getContentPane().add(lblCurrentOnline);
		
		JLabel lblNumberRe = new JLabel("Number registered");
		lblNumberRe.setBounds(10, 189, 108, 14);
		getContentPane().add(lblNumberRe);
		
		tfMaxCapa = new JTextField();
		tfMaxCapa.setColumns(10);
		tfMaxCapa.setBounds(127, 114, 86, 20);
		getContentPane().add(tfMaxCapa);
		
		tfCurrOnline = new JTextField();
		tfCurrOnline.setColumns(10);
		tfCurrOnline.setBounds(127, 151, 86, 20);
		getContentPane().add(tfCurrOnline);
		
		tfNumRegis = new JTextField();
		tfNumRegis.setColumns(10);
		tfNumRegis.setBounds(127, 186, 86, 20);
		getContentPane().add(tfNumRegis);
		
		
		
		
	}
}
