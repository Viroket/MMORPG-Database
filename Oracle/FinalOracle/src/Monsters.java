import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Monsters extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfMonsterName;
	private JTextField tfHp;
	private JTextField tfDamage;
	private JTextField tfLocation;
	public String monsterName;
	public int hp , damage , location;
	
	public Monsters() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(223, 138, 251, 14);
		getContentPane().add(lblWronginput);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					monsterName = tfMonsterName.getText();
					hp = Integer.parseInt(tfHp.getText());
					damage = Integer.parseInt(tfDamage.getText());
					location = Integer.parseInt(tfLocation.getText());
					db.insertIntoMonsters(monsterName, hp, damage, location);
					lblWronginput.setText("Record is inserted");
				}catch (Exception ex) {
					lblWronginput.setText("Wrong input");
				}
				
			}
		});
		button.setBounds(201, 11, 89, 23);
		getContentPane().add(button);
		
		tfMonsterName = new JTextField();
		tfMonsterName.setColumns(10);
		tfMonsterName.setBounds(127, 79, 86, 20);
		getContentPane().add(tfMonsterName);
		
		JLabel lblMonsterName = new JLabel("Monster name");
		lblMonsterName.setBounds(10, 82, 107, 14);
		getContentPane().add(lblMonsterName);
		
		JLabel lblHp = new JLabel("Hp");
		lblHp.setBounds(10, 117, 89, 14);
		getContentPane().add(lblHp);
		
		tfHp = new JTextField();
		tfHp.setColumns(10);
		tfHp.setBounds(127, 114, 86, 20);
		getContentPane().add(tfHp);
		
		tfDamage = new JTextField();
		tfDamage.setColumns(10);
		tfDamage.setBounds(127, 151, 86, 20);
		getContentPane().add(tfDamage);
		
		JLabel lblDamage = new JLabel("Damage");
		lblDamage.setBounds(10, 154, 89, 14);
		getContentPane().add(lblDamage);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 189, 108, 14);
		getContentPane().add(lblLocation);
		
		tfLocation = new JTextField();
		tfLocation.setColumns(10);
		tfLocation.setBounds(127, 186, 86, 20);
		getContentPane().add(tfLocation);
		
		
	}
}
