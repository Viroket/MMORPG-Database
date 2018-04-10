import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserTables extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private static final String DB_PASSWORD = "1212qwerF";
	private static final String DB_USER2 = "C##APP_USER";
	public DataBase db = new DataBase(DB_USER2 , DB_PASSWORD);
	public DefaultTableModel model;
	public ResultSet set;
	public TableColumn width;
	
	
	public UserTables() {
		getContentPane().setLayout(null);
		ButtonGroup bG = new ButtonGroup();
		
		this.setVisible(true);
		this.setBounds(200, 200 ,1400, 700 );
		
		JRadioButton rbServer = new JRadioButton("Server");
		rbServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				set = db.getServerData();
				setNewModelAndGetTable();
			}
		});
		rbServer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rbServer.setBounds(29, 40, 109, 23);
		getContentPane().add(rbServer);
		
		JRadioButton rbUsers = new JRadioButton("Users");
		rbUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getUsersData();
				setNewModelAndGetTable();
			}
		});
		rbUsers.setBounds(29, 66, 109, 23);
		getContentPane().add(rbUsers);
		
		JRadioButton rbCharacters = new JRadioButton("Characters");
		rbCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getCharacterData();
				setNewModelAndGetTable();
			}
		});
		rbCharacters.setBounds(29, 92, 109, 23);
		getContentPane().add(rbCharacters);
		
		JRadioButton rbItems = new JRadioButton("Items");
		rbItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getItemsData();
				setNewModelAndGetTable();
			}
		});
		rbItems.setBounds(29, 118, 109, 23);
		getContentPane().add(rbItems);
		
		JRadioButton rbQuests = new JRadioButton("Quests");
		rbQuests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getQuestsData();
				setNewModelAndGetTable();
			}
		});
		rbQuests.setBounds(29, 144, 109, 23);
		getContentPane().add(rbQuests);
		
		JRadioButton rbMonsters = new JRadioButton("Monsters");
		rbMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getMonstersData();
				setNewModelAndGetTable();
			}
		});
		rbMonsters.setBounds(29, 170, 109, 23);
		getContentPane().add(rbMonsters);
		
		JRadioButton rbQuestStatus = new JRadioButton("Quest Status");
		rbQuestStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				set = db.getQuestsStatusData();
				setNewModelAndGetTable();
			}
		});
		rbQuestStatus.setBounds(29, 196, 109, 23);
		getContentPane().add(rbQuestStatus);
		
		JPanel panel = new JPanel();
		panel.setBounds(144, 36, 1208, 614);
		getContentPane().add(panel);
		
		bG.add(rbServer);
		bG.add(rbUsers);
		bG.add(rbCharacters);
		bG.add(rbItems);
		bG.add(rbQuests);
		bG.add(rbMonsters);
		bG.add(rbQuestStatus);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(20);
		
		panel.add(table);
	}
	
	public void setNewModelAndGetTable() {
		model.setRowCount(0);
		model.setColumnCount(0);
		getTable(model);
	}
	public void getTable(DefaultTableModel model) {
		try {
			
			String[] mainRow = new String[set.getMetaData().getColumnCount()];
			for(int i = 1 ; i < set.getMetaData().getColumnCount()+1 ; i++) {
				model.addColumn(set.getMetaData().getColumnName(i));
				
				mainRow[i-1] = set.getMetaData().getColumnLabel(i).toLowerCase();
				
			}
			model.addRow(mainRow);
			while(set.next()) {
				String[] row = new String[set.getMetaData().getColumnCount()];
				
				for(int i = 1 ; i < set.getMetaData().getColumnCount()+1 ; i++) {
					row[i-1] = set.getString(i);
					//System.out.println(row[i]);
					width = table.getColumnModel().getColumn(i-1); //make the colom larger in size
					width.setPreferredWidth(110);//make it larger
				}
				
				model.addRow(row);
				
				//table.add
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
