import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Character extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfNickName;
	private JTextField tfClass;
	private JTextField tfRace;
	private JTextField tfEp;
	private JTextField tfHp;
	private JTextField tfMana;
	private JTextField tfGold;
	private JTextField tfLvl;
	private JTextField tfLocation;
	private JTextField tfUserId;
	public String nickName , charClass , race;
	public int exp , hp , mana , gold , lvl , location , userId;
	
	
	public Character() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		tfUserId = new JTextField();
		tfUserId.setColumns(10);
		tfUserId.setBounds(340, 217, 86, 20);
		getContentPane().add(tfUserId);
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(10, 42, 218, 14);
		getContentPane().add(lblWronginput);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int userNum = Integer.parseInt(tfUserId.getText());
					
					int  id = db.getIds("USERID" , "MMOUSERS" , userNum);
					if(id != 0) {
						nickName = tfNickName.getText();
						charClass = tfClass.getText();
						race = tfRace.getText();
						exp = Integer.parseInt(tfEp.getText());
						hp = Integer.parseInt(tfHp.getText());
						mana = Integer.parseInt(tfMana.getText());
						gold = Integer.parseInt(tfGold.getText());
						lvl = Integer.parseInt(tfLvl.getText());
						location = Integer.parseInt(tfLocation.getText());
						userId = Integer.parseInt(tfUserId.getText());
						db.insertIntoCharecter(nickName, charClass, race, exp, hp, mana, gold, lvl, location, userId);
					
						lblWronginput.setText("Record is inserted");
					}
					else {
						lblWronginput.setText("No User Exsist");
					}
					
				}catch (Exception ex) {
					lblWronginput.setText("Wrong input");
				}
			}
		});
		button.setBounds(201, 11, 89, 23);
		getContentPane().add(button);
		
		tfNickName = new JTextField();
		tfNickName.setColumns(10);
		tfNickName.setBounds(127, 79, 86, 20);
		getContentPane().add(tfNickName);
		
		JLabel lblNickName = new JLabel("Nick name");
		lblNickName.setBounds(10, 82, 77, 14);
		getContentPane().add(lblNickName);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(10, 117, 89, 14);
		getContentPane().add(lblClass);
		
		tfClass = new JTextField();
		tfClass.setColumns(10);
		tfClass.setBounds(127, 114, 86, 20);
		getContentPane().add(tfClass);
		
		tfRace = new JTextField();
		tfRace.setColumns(10);
		tfRace.setBounds(127, 151, 86, 20);
		getContentPane().add(tfRace);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(10, 154, 89, 14);
		getContentPane().add(lblRace);
		
		JLabel lblEperi = new JLabel("Eperience");
		lblEperi.setBounds(10, 189, 108, 14);
		getContentPane().add(lblEperi);
		
		tfEp = new JTextField();
		tfEp.setColumns(10);
		tfEp.setBounds(127, 186, 86, 20);
		getContentPane().add(tfEp);
		
		tfHp = new JTextField();
		tfHp.setColumns(10);
		tfHp.setBounds(127, 217, 86, 20);
		getContentPane().add(tfHp);
		
		JLabel lblHp = new JLabel("Hp");
		lblHp.setBounds(10, 220, 108, 14);
		getContentPane().add(lblHp);
		
		JLabel lblMana = new JLabel("Mana");
		lblMana.setBounds(221, 82, 77, 14);
		getContentPane().add(lblMana);
		
		tfMana = new JTextField();
		tfMana.setColumns(10);
		tfMana.setBounds(338, 79, 86, 20);
		getContentPane().add(tfMana);
		
		tfGold = new JTextField();
		tfGold.setColumns(10);
		tfGold.setBounds(338, 111, 86, 20);
		getContentPane().add(tfGold);
		
		JLabel lblGold = new JLabel("Gold");
		lblGold.setBounds(221, 114, 77, 14);
		getContentPane().add(lblGold);
		
		tfLvl = new JTextField();
		tfLvl.setColumns(10);
		tfLvl.setBounds(338, 151, 86, 20);
		getContentPane().add(tfLvl);
		
		JLabel lblLvl = new JLabel("Lvl");
		lblLvl.setBounds(221, 154, 77, 14);
		getContentPane().add(lblLvl);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(223, 192, 77, 14);
		getContentPane().add(lblLocation);
		
		tfLocation = new JTextField();
		tfLocation.setColumns(10);
		tfLocation.setBounds(340, 189, 86, 20);
		getContentPane().add(tfLocation);
		
		JLabel lblUserId = new JLabel("User id");
		lblUserId.setBounds(223, 220, 77, 14);
		getContentPane().add(lblUserId);
		
		
		
		
	}
	
}
