package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import utils.RoundJTextField;

/**
 * 
 */
public class ConnectGUI extends JPanel implements ActionListener {
	
//--------------------------------------------------------------------//
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -928496846447179820L;
	private JTextField nickName;
	private String nickNameString;
	private JButton createProfile;
	private JTextField connAddr;
	private JTextField port;
	private JButton connect;
	private JButton quitButton;
	private JComboBox<String> amountChatters;
	private BorderLayout layout;
	private JFrame connecting;
	private JPanel nickNamePanel;
	private JPanel connectAddrPanel;
	private JPanel connectPanel;
	private JPanel createProfilePanel;
	private static final String TITLE = "Connect";
	
//---------------------------------------------------------------------//
	
	public ConnectGUI(String nickNameString) {
		this.nickNameString = nickNameString;
		connecting();
	}
	
	private JFrame connecting(){
		connecting = new JFrame();
		connecting.setTitle(TITLE);
		layout = new BorderLayout();
		connecting.setLayout(layout);
		//connecting.add(layOut(), BorderLayout.NORTH);
		connecting.add(connectAddr(), BorderLayout.NORTH);
		connecting.add(chatterChooser(),BorderLayout.CENTER);
		connecting.add(southLayout(),BorderLayout.SOUTH);
		connecting.setVisible(true);
		connecting.setSize(400, 190);
		connecting.setLocationRelativeTo(null);
		connecting.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		return connecting;
	}
	
	private JPanel nickName() {
		nickName = new RoundJTextField(nickNameString, 10);
		nickName.setForeground(Color.WHITE);
		nickName.setBackground(Color.GRAY);
		nickName.setEditable(true);
		nickNamePanel = new JPanel();
		nickNamePanel.setBackground(Color.DARK_GRAY);
		nickNamePanel.add(nickName);
		return nickNamePanel;
	}
	
	private JPanel connectAddr() {
		connAddr = new RoundJTextField("Connect Address", 10);
		connAddr.setForeground(Color.WHITE);
		connAddr.setBackground(Color.GRAY);
		connAddr.setEditable(true);
		port = new RoundJTextField("Port Address", 10);
		port.setForeground(Color.WHITE);
		port.setBackground(Color.GRAY);
		connectAddrPanel = new JPanel();
		connectAddrPanel.setBackground(Color.DARK_GRAY);
		connectAddrPanel.add(connAddr);
		connectAddrPanel.add(port);
		return connectAddrPanel;
	}
	
	public boolean onlyNumbersAbove1023(String numbers){
		boolean result = false;
		for(int x = 0; x < 6000; x++){
			String stringx = Integer.toString(x);
			if(numbers.equals(stringx) && x >= 1024){
				result = true;
			}
		}
		return result;
	}
	
	public boolean onlyNumbersconnAddr(String numbers){
		int resultint = 0;
		String[] splitter = numbers.split("\\.");
		boolean result = false;
		if(splitter.length == 4){
			for(int y = 0; y < splitter.length; y++){
				for(int x = 0; x < 256; x++){
					String stringx = Integer.toString(x);
					if(splitter[y].equals(stringx)){
						resultint++;
						if(resultint == 4){
							result = true;
						}
					}
				}
			}
		}
		return result;
	}
	
	private JPanel createProfile() {
		createProfile = new JButton("<html> <font color='white'>maak profiel aan</font></html>");
		Font profileFont = new Font("28 Days Later",Font.PLAIN,16);
		createProfile.setFont(profileFont);
		createProfile.setOpaque(false);
		createProfile.setContentAreaFilled(false);
		createProfile.setBorderPainted(false);
		createProfile.addActionListener(this);
		createProfilePanel = new JPanel();
		createProfilePanel.setBackground(Color.DARK_GRAY);
		createProfilePanel.add(createProfile);
		return createProfilePanel;
	}
	
	private JPanel quitPanel(){
		JPanel quitPanel = new JPanel();
		quitPanel.setBackground(Color.DARK_GRAY);
		quitButton = new JButton("<html> <font color='white'>Shut down</font></html>");
		Font quitFont = new Font("28 Days Later",Font.PLAIN,20);
		quitButton.setFont(quitFont);
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(false);
		quitButton.addActionListener(this);
		quitPanel.add(quitButton);
		quitPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		return quitPanel;
	}
	
	private JPanel connect() {
		connect = new JButton("<html> <font color='white'>Connect</font></html>");
		Font connectFont = new Font("28 Days Later",Font.PLAIN,20);
		connect.setFont(connectFont);
		connect.setOpaque(false);
		connect.setContentAreaFilled(false);
		connect.setBorderPainted(false);
		connect.addActionListener(this);
		connectPanel = new JPanel();
		connectPanel.setBackground(Color.DARK_GRAY);
		connectPanel.add(connect);
		//connectPanel.add(amountChatters);
		connectPanel.add(quitPanel());
		return connectPanel;
	}
	
	private JPanel chatterChooser(){
		JPanel chatterChooserPanel = new JPanel();
		chatterChooserPanel.setBackground(Color.DARK_GRAY);
		amountChatters = new JComboBox<String>();
		amountChatters.setForeground(Color.WHITE);
		amountChatters.setBackground(Color.DARK_GRAY);
		amountChatters.addItem("Two chatters");
		amountChatters.addItem("Four chatters");
		Font amountFont = new Font("28 Days Later",Font.PLAIN,16);
		amountChatters.setFont(amountFont);
		amountChatters.addActionListener(this);
		chatterChooserPanel.add(amountChatters);
		return chatterChooserPanel;
	}
	
	private JPanel southLayout() {
		JPanel southPaneltje = new JPanel();
		southPaneltje.setBackground(Color.DARK_GRAY);
		southPaneltje.add(connect(), BorderLayout.NORTH);
		
		return southPaneltje;
	}
	
	private JPanel layOut() {
		JPanel paneltje = new JPanel();
		paneltje.setBackground(Color.DARK_GRAY);
		paneltje.add(nickName(), BorderLayout.WEST);
		paneltje.add(createProfile(), BorderLayout.EAST);
		return paneltje;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == createProfile){
			new MaakProfielGUI();
			connecting.dispose();
		}
		if(arg0.getSource() == connect){
			if((/*nickName.getText().equals("Nickname") || nickName.getText().equals(""))&&*/(connAddr.getText().equals("Connect Address") || connAddr.getText().equals("")||port.getText().equals("")))){
				new ErrorGUI("Connect Address en PortNumber incorrect", 260);
			}
//			else if(nickName.getText().equals("Nickname") || nickName.getText().equals("")){
//				new ErrorGUI("Voer nickname in of maak nieuw profiel aan", 280);
//			}
			else if(connAddr.getText().equals("Connect Address") || connAddr.getText().equals("") || !onlyNumbersconnAddr(connAddr.getText())){
				new ErrorGUI("Incorrect connect Address", 200);
			}
			else if(!onlyNumbersAbove1023(port.getText())){
				new ErrorGUI("Voer geldige portnummer in", 230);
			}
			else if(amountChatters.getSelectedItem().equals("Four chatters")){
				connecting.dispose();
				new ChatGUI(nickName.getText(), 4);
			}
			else if(amountChatters.getSelectedItem().equals("Two chatters")){
				connecting.dispose();
				new ChatGUI(nickName.getText(),2);
			}	
			
		}
		
			if(arg0.getSource() == quitButton){
			connecting.dispose();
		}
	}
	
	public static void main(String[] args){
		new ConnectGUI("Hallo");
	}
}
