import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;


public class GUI extends JFrame{
	private JRadioButton nums = new JRadioButton("Числа");
	private JRadioButton specialSymbols = new JRadioButton("Специальные символы");
	private JRadioButton bigA = new JRadioButton("Прописные буквы");
	
	private JButton generatePassword = new JButton("генерация пароля");
	/*
	private JLabel lenPass = new JLabel("Введите длинну пароля"); в работе...
	private TextField lengthStr = new TextField();
	*/
	private int length = 12;
	
	private JLabel passShow = new JLabel();
	private JLabel itsPass = new JLabel();
	
	
	public GUI() {
		super("Генератор паролей");
		this.setBounds(150, 150, 300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(6, 3));

		
		nums.setSelected(true);
		specialSymbols.setSelected(true);
		bigA.setSelected(true);
		
		container.add(nums);
		container.add(specialSymbols);
		container.add(bigA);
		
		container.add(itsPass);
		itsPass.setText("Пароль");
		itsPass.setHorizontalAlignment(JLabel.CENTER);
		
		container.add(passShow);
		passShow.setHorizontalAlignment(JLabel.CENTER);
		
		container.add(generatePassword);
		
		
		generatePassword.addActionListener(new GeneratePass ());
		
		
	}
	
	
		class GeneratePass implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String stringForPassword = "abcdefghijklmnopqrstuvwxyz";
				String password = "";
				
				
				stringForPassword += (nums.isSelected() ? "0123456789" : "");
				stringForPassword += (specialSymbols.isSelected() ? "!@#$%^&*()" : "");
				stringForPassword += (bigA.isSelected() ? "ABCDEFGHIJKLMNOPQRSTUVWXYZ" : "");
				
				
				char[] symbolsForPassword = new char[stringForPassword.length()];
				for(int i = 0; i < stringForPassword.length(); ++i) {
					symbolsForPassword[i] = stringForPassword.charAt(i);
				}
					
				Random rand = new Random();
			
				for(int i = 0; i < length; ++i) {
					int randomNum = rand.nextInt(stringForPassword.length());
					password += symbolsForPassword[randomNum];
				passShow.setText(password);
				}
			}
		}

}
