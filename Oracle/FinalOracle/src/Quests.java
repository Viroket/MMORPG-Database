import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quests extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfQuestName;
	private JTextField tfQuestLvl;
	private JTextField tfExpReward;
	private JTextField tfIteamReward;
	private JTextField tfObjective;
	
	
	public Quests() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(223, 120, 239, 14);
		getContentPane().add(lblWronginput);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					db.insertIntoQuets(tfQuestName.getText() ,  Integer.parseInt(tfQuestLvl.getText()), Integer.parseInt(tfExpReward.getText()) , Integer.parseInt(tfIteamReward.getText()) , Integer.parseInt(tfObjective.getText()) );
					lblWronginput.setText("Record is inserted");
				}catch (Exception ex) {
					lblWronginput.setText("Wrong input");
				}
			
			}
		});
		button.setBounds(165, 11, 89, 23);
		getContentPane().add(button);
		
		JLabel lblQuestName = new JLabel("Quest name");
		lblQuestName.setBounds(10, 48, 77, 14);
		getContentPane().add(lblQuestName);
		
		tfQuestName = new JTextField();
		tfQuestName.setColumns(10);
		tfQuestName.setBounds(127, 45, 86, 20);
		getContentPane().add(tfQuestName);
		
		tfQuestLvl = new JTextField();
		tfQuestLvl.setColumns(10);
		tfQuestLvl.setBounds(127, 80, 86, 20);
		getContentPane().add(tfQuestLvl);
		
		JLabel lblQuestLvl = new JLabel("Quest lvl");
		lblQuestLvl.setBounds(10, 83, 89, 14);
		getContentPane().add(lblQuestLvl);
		
		JLabel lblExperienceReward = new JLabel("Experience reward");
		lblExperienceReward.setBounds(10, 120, 108, 14);
		getContentPane().add(lblExperienceReward);
		
		tfExpReward = new JTextField();
		tfExpReward.setColumns(10);
		tfExpReward.setBounds(127, 117, 86, 20);
		getContentPane().add(tfExpReward);
		
		tfIteamReward = new JTextField();
		tfIteamReward.setColumns(10);
		tfIteamReward.setBounds(127, 152, 86, 20);
		getContentPane().add(tfIteamReward);
		
		JLabel lblItemReward = new JLabel("Item reward");
		lblItemReward.setBounds(10, 155, 108, 14);
		getContentPane().add(lblItemReward);
		
		JLabel lblObjective = new JLabel("Objective");
		lblObjective.setBounds(10, 186, 108, 14);
		getContentPane().add(lblObjective);
		
		tfObjective = new JTextField();
		tfObjective.setColumns(10);
		tfObjective.setBounds(127, 183, 86, 20);
		getContentPane().add(tfObjective);
		
	
	}
}
