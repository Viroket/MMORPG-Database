import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Items extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER = "system";
	public DataBase db = new DataBase(DB_USER , DB_PASSWORD);
	private JTextField tfItemName;
	private JTextField tfItemValue;
	private JTextField tfSlot;
	private JTextField tfWeight;
	private JTextField tfType;
	public String itemName , itemType;
	public int value , slot , weight;
	
	public Items() {
		getContentPane().setLayout(null);
		
		this.setVisible(true);
		this.setBounds(200, 100 ,500, 300 );
		
		JLabel lblWronginput = new JLabel("");
		lblWronginput.setBounds(224, 137, 239, 14);
		getContentPane().add(lblWronginput);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					itemName = tfItemName.getText();
					itemType = tfType.getText();
					value = Integer.parseInt(tfItemValue.getText());
					slot = Integer.parseInt(tfSlot.getText());
					weight = Integer.parseInt(tfWeight.getText());
					
					db.insertIntoItems(itemName, value, slot, weight, itemType);
					lblWronginput.setText("Record is inserted");
				}
				catch (Exception e) {
					lblWronginput.setText("Wrong input");
				}
				
			}
		});
		button.setBounds(201, 11, 89, 23);
		getContentPane().add(button);
		
		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setBounds(10, 82, 77, 14);
		getContentPane().add(lblItemName);
		
		tfItemName = new JTextField();
		tfItemName.setColumns(10);
		tfItemName.setBounds(127, 79, 86, 20);
		getContentPane().add(tfItemName);
		
		tfItemValue = new JTextField();
		tfItemValue.setColumns(10);
		tfItemValue.setBounds(127, 114, 86, 20);
		getContentPane().add(tfItemValue);
		
		JLabel lblItemValue = new JLabel("Item value");
		lblItemValue.setBounds(10, 117, 89, 14);
		getContentPane().add(lblItemValue);
		
		JLabel lblSlot = new JLabel("Slot");
		lblSlot.setBounds(10, 154, 89, 14);
		getContentPane().add(lblSlot);
		
		tfSlot = new JTextField();
		tfSlot.setColumns(10);
		tfSlot.setBounds(127, 151, 86, 20);
		getContentPane().add(tfSlot);
		
		tfWeight = new JTextField();
		tfWeight.setColumns(10);
		tfWeight.setBounds(127, 186, 86, 20);
		getContentPane().add(tfWeight);
		
		JLabel lblWeig = new JLabel("Weight");
		lblWeig.setBounds(10, 189, 108, 14);
		getContentPane().add(lblWeig);
		
		JLabel lblItemType = new JLabel("Item type");
		lblItemType.setBounds(10, 220, 108, 14);
		getContentPane().add(lblItemType);
		
		tfType = new JTextField();
		tfType.setColumns(10);
		tfType.setBounds(127, 217, 86, 20);
		getContentPane().add(tfType);
		
		
	}
	
}
