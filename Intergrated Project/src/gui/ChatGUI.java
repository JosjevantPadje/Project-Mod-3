package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ChatGUI extends WindowAdapter implements ActionListener{

//--------------------------------------------------------------------------//
	
	private static final String[] emoticonArray = {":-|", ":-[", ":-#", ";-(", ":^D", ":-)", ":-))", ":*-)", ">-<", "*<|:-)", "<:-(", "X-(", ":*)", ">:)", "~:-;", "0:-)", "O:-)", "|-o", "#:-o", "8-]", "8-)", ":'(", "_|:-)", ";-)", ";P", ";-D", "[:-)", ":)", "@}->----", "2B|^2B", ":-P", "B:-)", ":{"};
	private WindowListener listener = new WindowAdapter(){
		public void windowClosing(WindowEvent we){
			chatser.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			quitFrame();
		}	
	};
	private WindowListener listenerEF = new WindowAdapter(){
		public void windowClosing(WindowEvent we){
			emoticonFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
		
	};
	private String myNickName;
	private JFrame chatser;
	private JFrame quitFrame;
	private JFrame emoticonFrame;
	private JButton settings;
	private JButton log_out;
	private JButton name1;
	private JButton name2;
	private JButton name3;
	private JButton extentions;
	private JButton send;
	private JButton yesButton;
	private JButton noButton;
	private JButton choose;
	private JButton close;
	private JButton clear;
	private JButton[] buttons;
	private JTextArea nameAndProfile;
	private JTextField input;
	private JTextArea chatBox;
	private JPanel card1;
	private JPanel card2;
	private JPanel card3;
	private JPanel switchPanel;
	private BorderLayout layout;
	private ImageIcon settingsPic;
	private ImageIcon logoutPic;
	private static final String TITLE = "Chatser";
	private Border blackline = BorderFactory.createLineBorder(Color.BLACK);
	private SettingsGUI settingsGUI;
	private int checker = 0;
	private int chatters;
	
//--------------------------------------------------------------------------//
	
	public ChatGUI(String myNickName, int chatters) {
		this.myNickName = myNickName;
		this.chatters = chatters;
		importPictures();
		chatserFrame();
		makeEmoticonFrame();
	}
	
	public JFrame chatserFrame(){
		chatser = new JFrame();
		chatser.addWindowListener(listener);
		chatser.setTitle(TITLE + " - " + myNickName);
		layout = new BorderLayout();
		chatser.setLayout(layout);
		chatser.add(chatBoxPanel(), BorderLayout.CENTER);
		chatser.add(eastSide(), BorderLayout.EAST);
		chatser.add(toSend_ExtentionsAndSendPanel(), BorderLayout.SOUTH);
		chatser.setVisible(true);
		chatser.setSize(600, 500);
		chatser.setResizable(false);
		chatser.setLocationRelativeTo(null);
		return chatser;
	}
	
	public String getNickName(){
		return this.myNickName;
	}
	
	private void importPictures(){
		settingsPic = new ImageIcon("settings.png");
		logoutPic = new ImageIcon("logout.png");
	}
	
	private JScrollPane chatBoxPanel(){
		chatBox = new JTextArea(25,30);
		chatBox.setBorder(blackline);
		chatBox.setEditable(false);
		JScrollPane chatBoxScrollPane = new JScrollPane(chatBox);
		chatBoxScrollPane.setBackground(Color.GRAY);
		chatBoxScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatBoxScrollPane.setPreferredSize(new Dimension(249, 249));
		return chatBoxScrollPane;
	}
	
	private JPanel eastSide() {
		BorderLayout layOut = new BorderLayout();
		JPanel eastSidePanel = new JPanel(layOut);
		eastSidePanel.setBackground(Color.GRAY);
		eastSidePanel.add(settingsAndLogoutPanel(),BorderLayout.NORTH);
		if(chatters == 4){
			eastSidePanel.add(namesChooser(), BorderLayout.CENTER);
		}
		eastSidePanel.add(switchingPanel(), BorderLayout.SOUTH);
		
		return eastSidePanel;
	}
	
	private JPanel namesChooser(){
		GridLayout grid = new GridLayout();
		grid.setColumns(1);
		grid.setRows(3);
		JPanel namesChooserPanel = new JPanel(grid);
		namesChooserPanel.setBackground(Color.GRAY);
		name1 = new JButton("Name1");
		name2 = new JButton("Name2");
		name3 = new JButton("Name3");
		name1.addActionListener(this);
		name2.addActionListener(this);
		name3.addActionListener(this);
		JPanel name1Panel = new JPanel();
		name1Panel.setBackground(Color.GRAY);
		JPanel name2Panel = new JPanel();
		name2Panel.setBackground(Color.GRAY);
		JPanel name3Panel = new JPanel();
		name3Panel.setBackground(Color.GRAY);
		name1Panel.add(name1);
		name2Panel.add(name2);
		name3Panel.add(name3);
		namesChooserPanel.add(name1Panel);
		namesChooserPanel.add(name2Panel);
		namesChooserPanel.add(name3Panel);
		return namesChooserPanel;
	}
	
	private JPanel profileInfo1(){
		JPanel profileInfoPanel = new JPanel();
		profileInfoPanel.setBackground(Color.GRAY);
		nameAndProfile = new JTextArea(14,20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, "Profile of name1");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}
	
	private JPanel profileInfo2(){
		JPanel profileInfoPanel = new JPanel();
		profileInfoPanel.setBackground(Color.GRAY);
		nameAndProfile = new JTextArea(14,20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, "Profile of name2");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}
	
	private JPanel profileInfo3(){
		JPanel profileInfoPanel = new JPanel();
		profileInfoPanel.setBackground(Color.GRAY);
		nameAndProfile = new JTextArea(14,20);
		nameAndProfile.setEditable(false);
		TitledBorder title = BorderFactory.createTitledBorder(blackline, "Profile of name3");
		title.setTitleJustification(TitledBorder.CENTER);
		nameAndProfile.setBorder(title);
		profileInfoPanel.add(nameAndProfile);
		return profileInfoPanel;
	}
	
	private JPanel toSend_ExtentionsAndSendPanel(){
		JPanel toSend_ExtentionsAndSendPanel = new JPanel();
		toSend_ExtentionsAndSendPanel.setBackground(Color.GRAY);
		input = new JTextField(null,37);
		extentions = new JButton("Extentions");
		extentions.addActionListener(this);
		send = new JButton("Send");
		send.addActionListener(this);
		toSend_ExtentionsAndSendPanel.add(input);
		toSend_ExtentionsAndSendPanel.add(send);
		toSend_ExtentionsAndSendPanel.add(extentions);
		return toSend_ExtentionsAndSendPanel;
	}
	
	private JPanel settingsAndLogoutPanel(){
		JPanel settingsAndLogoutPanel = new JPanel(new BorderLayout());
		settingsAndLogoutPanel.setBackground(Color.GRAY);
		JPanel borderSettingsLogout = new JPanel();
		borderSettingsLogout.setBackground(Color.GRAY);
		settings = new JButton(settingsPic);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.addActionListener(this);
		log_out = new JButton(logoutPic);
		log_out.setOpaque(false);
		log_out.setContentAreaFilled(false);
		log_out.setBorderPainted(false);
		log_out.addActionListener(this);
		borderSettingsLogout.add(settings);
		borderSettingsLogout.add(log_out);
		settingsAndLogoutPanel.add(borderSettingsLogout, BorderLayout.EAST);
		return settingsAndLogoutPanel;
	}
	
	private JPanel switchingPanel() {
		switchPanel = new JPanel(new CardLayout());
		switchPanel.setBackground(Color.GRAY);
		card1 = profileInfo1();
		card2 = profileInfo2();
		card3 = profileInfo3();
		switchPanel.add(card1, "Person1");
		switchPanel.add(card2, "Person2");
		switchPanel.add(card3, "Person3");
		return switchPanel;
	}
	
	public static void main(String[] args){
		new ChatGUI("noNickName", 4);
	}
	
	public void actionPerformed(ActionEvent ae) {
		CardLayout cl = (CardLayout) switchPanel.getLayout();
		if(ae.getSource() == name1){
			cl.show(switchPanel, "Person1");
		}else if(ae.getSource() == name2){
			cl.show(switchPanel, "Person2");
		}else if(ae.getSource() == name3){
			cl.show(switchPanel, "Person3");
		}
		
		if(ae.getSource() == settings){
			if(checker == 0){
				settingsGUI = new SettingsGUI(false);
				checker = 2;
			}else if(settingsGUI.notificationSoundCheckbox.isSelected()){
				settingsGUI = new SettingsGUI(true);
			}else{
				settingsGUI = new SettingsGUI(false);
			}
		}
		if(ae.getSource() == log_out){
			quitFrame();
		}
		if(ae.getSource() == yesButton){
			chatser.dispose();
			quitFrame.dispose();
			new ConnectGUI(myNickName);
		}
		if(ae.getSource() == noButton){
			quitFrame.dispose();
		}
		if(ae.getSource() == extentions){
			emoticonFrame.setVisible(true);
		}
		if(emoticonFrame.isVisible()){
			if(ae.getSource() == close){
				emoticonFrame.setVisible(false);
			}
			if(ae.getSource() == choose){
				for(int x = 0; x < emoticonArray.length; x++){
					if(buttons[x].getBackground() == Color.GRAY){
						input.setText(input.getText() + buttons[x].getText());
					}
				}
			}
				for(int x = 0; x < emoticonArray.length; x++){
					if(ae.getSource() == buttons[x]){
						for(int y = 0; y < emoticonArray.length;y++){
							buttons[y].setBackground(null);
						}
						buttons[x].setBackground(Color.GRAY);
					}
				}
		
				if(ae.getSource() == clear){
					input.setText("");
				}
		}
		if(ae.getSource() == send){
			if(input.getText() != null){
				chatBox.append(input.getText() + "\n");
				input.setText(null);
			}
		}
	}

	//--------------------Quit Frame Methods-----------------------------------//

	public void quitFrame(){
		quitFrame = new JFrame();
		quitFrame.setLayout(new BorderLayout());
		quitFrame.add(textPanel(), BorderLayout.NORTH);
		quitFrame.add(yesPanel(), BorderLayout.WEST);
		quitFrame.add(noPanel(), BorderLayout.EAST);
		quitFrame.setSize(220,110);
		quitFrame.setVisible(true);
		quitFrame.setLocationRelativeTo(null);
		quitFrame.setResizable(false);
		quitFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public JPanel textPanel(){
		JLabel textLabel = new JLabel("Weet u zeker dat u wilt afsluiten?");
		JPanel textPanel = new JPanel();
		textPanel.add(textLabel);
		return textPanel;
	}
	
	public JPanel yesPanel(){
		JPanel yesPanel = new JPanel();
		yesButton = new JButton("Ja");
		yesButton.addActionListener(this);
		yesPanel.add(yesButton);
		yesPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		return yesPanel;
	}
	
	public JPanel noPanel(){
		JPanel noPanel = new JPanel();
		noButton = new JButton("Nee");
		noButton.addActionListener(this);
		noPanel.add(noButton);
		noPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		return noPanel;
	}
	//--------------------End Of Quit Frame Methods-----------------------------//
	
	//--------------------Emoticon Frame Methods--------------------------------//
	
	private JFrame makeEmoticonFrame(){
		emoticonFrame = new JFrame();
		emoticonFrame.addWindowListener(listenerEF);
		emoticonFrame.setTitle(TITLE);
		layout = new BorderLayout();
		emoticonFrame.setLayout(layout);
		emoticonFrame.add(emoticonButtonsFrame(), BorderLayout.CENTER);
		emoticonFrame.add(chooseAndCancel(), BorderLayout.SOUTH);
		emoticonFrame.setVisible(false);
		emoticonFrame.setSize(300,300);
		emoticonFrame.setLocationRelativeTo(null);
		emoticonFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		return emoticonFrame;
	}
	
	private JPanel emoticonButtonsFrame(){
		JPanel emoticonPanel = new JPanel();
		buttons = new JButton[emoticonArray.length];
		for(int x = 0; x < emoticonArray.length; x++){
			buttons[x] = new JButton(emoticonArray[x]);
			buttons[x].addActionListener(this);
			emoticonPanel.add(buttons[x]);
		}
		return emoticonPanel;
	}
	
	private JPanel chooseAndCancel(){
		JPanel chooseAndCancelPanel = new JPanel();
		choose = new JButton("Choose");
		choose.addActionListener(this);
		close = new JButton("Close");
		close.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		chooseAndCancelPanel.add(choose);
		chooseAndCancelPanel.add(close);
		chooseAndCancelPanel.add(clear);
		return chooseAndCancelPanel;
	}

	//--------------------End of Emoticon Frame Methods-------------------------//
	
}
