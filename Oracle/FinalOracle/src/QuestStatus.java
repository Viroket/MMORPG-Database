import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestStatus extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfCharectureId;
	private JTextField tfQuestId;
	private JTextField tfStatus;
	public String status;
	public int questId , charectureId; 
	public QuestStatus() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(223, 117, 251, 14);
		getContentPane().add(lblWronginput);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int questNum = Integer.parseInt(tfQuestId.getText());
				//int charecturNum = Integer.parseInt(tfCharectureId.getText());
				
				try {
					status = tfStatus.getText();
					questId = Integer.parseInt(tfQuestId.getText());
					charectureId = Integer.parseInt(tfCharectureId.getText());
					db.insertIntoQuestStatus(charectureId, questId, status);
					lblWronginput.setText("Record is inserted");
				}catch (Exception ex) {
					lblWronginput.setText("Wrong input");
				}
					
					
				
				
				
				
			}
		});
		button.setBounds(201, 11, 89, 23);
		getContentPane().add(button);
		
		JLabel lblCharectureId = new JLabel("Charecture id");
		lblCharectureId.setBounds(10, 82, 77, 14);
		getContentPane().add(lblCharectureId);
		
		tfCharectureId = new JTextField();
		tfCharectureId.setColumns(10);
		tfCharectureId.setBounds(127, 79, 86, 20);
		getContentPane().add(tfCharectureId);
		
		tfQuestId = new JTextField();
		tfQuestId.setColumns(10);
		tfQuestId.setBounds(127, 114, 86, 20);
		getContentPane().add(tfQuestId);
		
		JLabel lblQuestId = new JLabel("Quest id");
		lblQuestId.setBounds(10, 117, 89, 14);
		getContentPane().add(lblQuestId);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 154, 89, 14);
		getContentPane().add(lblStatus);
		
		tfStatus = new JTextField();
		tfStatus.setColumns(10);
		tfStatus.setBounds(127, 151, 86, 20);
		getContentPane().add(tfStatus);
		
		
	}
	

}
