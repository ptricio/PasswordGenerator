package generator;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class PasswordGeneratorGui extends JFrame {
	private Generate g = new Generate();
	private String[] length = {"8","9","10","11","12","13","14","15","16"};
	private int[] nums = {8,9,10,11,12,13,14,15,16};
	private JPanel contentPane;
	private JTextArea passField;
	private JComboBox numberChar;
	private JLabel passLength;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordGeneratorGui frame = new PasswordGeneratorGui();
					frame.setTitle("Generate a password");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PasswordGeneratorGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel northPanel = createNorthPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = createCenterPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel southPanel = createSouthPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
	}

	/*
	 * This creates the south panel
	 * that houses the copy button
	 */
	private JPanel createSouthPanel() {
		JPanel southPanel = new JPanel();
		
		JButton cpyBtn = new JButton("Copy to clipboard");
		cpyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(passField.getText());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
			}
		});
		southPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		JLabel passLbl = new JLabel("Password:");
		passLbl.setHorizontalAlignment(SwingConstants.CENTER);
		southPanel.add(passLbl);
		
		passField = new JTextArea();
		southPanel.add(passField);
		southPanel.add(cpyBtn);
		return southPanel;
	}

	/*
	 * Create the center panel that displays 
	 * the randomly generated password
	 */
	private JPanel createCenterPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerNorth = new JPanel();
		centerNorth.setLayout(new GridLayout(0,3,0,0));
		centerPanel.add(centerNorth,BorderLayout.NORTH);
		
		JPanel centerSouth = new JPanel();
		centerSouth.setLayout(new GridLayout(1,0,0,0));
		centerPanel.add(centerSouth,BorderLayout.CENTER);
		
		JCheckBox chckbxCharacters = new JCheckBox("Characters");
		centerNorth.add(chckbxCharacters);
		
		JCheckBox upperCaseCheck = new JCheckBox("Upper case");
		centerNorth.add(upperCaseCheck);
		
		JCheckBox numChckBox = new JCheckBox("Numbers");
		centerNorth.add(numChckBox);
		
		JButton generateBtn = new JButton("Generate Password");
		centerSouth.add(generateBtn);
		generateBtn.requestFocus();
		generateBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				passField.setText("");
				String pass = g.generateRandomPass(nums[numberChar.getSelectedIndex()], upperCaseCheck.isSelected(), numChckBox.isSelected(), chckbxCharacters.isSelected());
				passField.setText(pass);
			}
		});
		return centerPanel;
	}

	/*
	 * Creates the north panel that allows
	 * the user to select the password length
	 * then generate the password with the 
	 * selected length
	 */
	private JPanel createNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		passLength = new JLabel("Password Length:");
		northPanel.add(passLength);
		
		numberChar = new JComboBox(length);
		northPanel.add(numberChar);
		
		
			
		return northPanel;
	}

}
