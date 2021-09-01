import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * TO DO:
 * implement KeyListener. enter key makes things do stuff
 * 
 * implement denomination counter.
 */

//C:\Users\torch\eclipse-workspace\CashiersAlgorithm\src
public class cashiersAlgorithmMAIN implements ActionListener{
	ImageIcon iconImage = new ImageIcon ("C:\\Users\\torch\\eclipse-workspace\\CashiersAlgorithm\\src\\calculatorAlgorithm.png");

	
	JFrame frame;
	JPanel transactionPanel;
	JPanel amountPanel;
	JPanel duePanel;
	JPanel denominations;
	JPanel twenties;
	JTextField enterCharged;
	JTextField enterPaid;
	JTextField changeDue;
	JTextField displayTwenties;
	JButton calculate;
	
	JLabel amountCharged;
	JLabel amountReceived;
	JLabel changeDuetoCustomer;
	JLabel displayDenominations[];
	
	
	cashiersAlgorithmMAIN(){
		
		
	/* 32.56
	 * 32.56 - 20.00 = 12.56
	 * 12.56 - 20 = NEGATIVE, move on to next denominaiton
	 * 
	 * 12.56 - 10 = 2.56
	 * 2.56 - 10 = NEGATIVE
	 * 
	 * 2.56 - 5 = NEGATIVE
	 * 
	 * 2.56 - 1 = 1.56
	 * 1.56 - 1 = .56
	 * .56 - 1 = NEGATIVE
	 * 
	 * .56 - .25 = .31
	 * 
	 *.31 - .25 = .06
	 *.06 - .25 = NEGATIVE
	 *
	 *.06 - .1 = NEGATIVE
	 *
	 *.06 - .05 = .01
	 *
	 *if value < .05, pennies++
	 */
	
	
	
		frame = new JFrame("CashierView");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,500);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setAlwaysOnTop(true);
		frame.setIconImage(iconImage.getImage());
		//frame.addKeyListener(keyInput);
		
		transactionPanel = new JPanel();
		transactionPanel.setBounds(-40, 105, 200, 40);
		transactionPanel.setBackground(Color.LIGHT_GRAY);
		amountCharged = new JLabel("Transaction Total:");
		transactionPanel.add(amountCharged);
		
		amountPanel = new JPanel();
		amountPanel.setBounds(-40, 145, 200, 40);
		amountPanel.setBackground(Color.LIGHT_GRAY);
		amountReceived = new JLabel("Amount Received:");
		amountPanel.add(amountReceived);
		
		duePanel = new JPanel();
		duePanel.setBounds(-40, 185, 200, 40);
		duePanel.setBackground(Color.LIGHT_GRAY);
		changeDuetoCustomer = new JLabel("Change Due:");
		duePanel.add(changeDuetoCustomer);
		
		
		
		
		enterCharged = new JTextField();
		enterCharged.setBounds(150, 105, 200, 30);
		enterCharged.setEditable(true);
		enterCharged.setBackground(Color.WHITE);
		enterCharged.addActionListener(this);
		
		enterPaid = new JTextField();
		enterPaid.setBounds(150, 145, 200, 30);
		enterPaid.setEditable(true);
		enterPaid.setBackground(Color.white);
		enterPaid.addActionListener(this);
		
		displayTwenties = new JTextField();
		displayTwenties.setBounds(200,200,200,200);
		displayTwenties.setEditable(false);
		displayTwenties.setBackground(Color.cyan);
		displayTwenties.addActionListener(this);
		displayTwenties.setText(twentyCount);
		
		
		changeDue = new JTextField();
		changeDue.setBounds(150, 185, 200, 30);
		changeDue.setEditable(false);
		changeDue.setBackground(Color.white);
		changeDue.addActionListener(this);
		
		calculate = new JButton();
		calculate.setBounds(350, 145, 90, 30);
		calculate.setFocusable(false);
		calculate.setText("Calculate");
		calculate.addActionListener(this);
		
		
		
		
		
		frame.setVisible(true);
		frame.add(transactionPanel);
		frame.add(amountPanel);
		frame.add(enterCharged);
		frame.add(enterPaid);
		frame.add(changeDue);
		frame.add(calculate);
		frame.add(duePanel);
		frame.add(displayTwenties);
		
		//amountPanel.setBackground(Color.cyan);
		//transactionPanel.setBackground(Color.CYAN);
		//duePanel.setBackground(Color.cyan);
		
		
	
		
		
		
	}

	
	
	
	
	
		public static void main(String[] args) {
			cashiersAlgorithmMAIN cashier = new cashiersAlgorithmMAIN();
			
			
		}





		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == calculate) {
				double twentyCount = 0;
				double paid = Double.parseDouble(enterPaid.getText());
				double charged = Double.parseDouble(enterCharged.getText());
				DecimalFormat df = new DecimalFormat("#,###.##");
				double whatToPay =  (paid - charged);
				
				twenties =	Double.parseDouble(twentyCount.getText());
				
				changeDue.setText(String.valueOf(df.format(whatToPay)));
				System.out.println("paid: " + paid);
				System.out.println("charged: " + charged);
				System.out.println(String.format("%,.2f", whatToPay));
			}
			
		}
		
		double denominationReturn(double whatToPay, double twentyCount){
			double newAmount;
			double oldAmount = newAmount;
			while (whatToPay - 20 > 0) {
				double newAmount = whatToPay;
				newAmount = whatToPay - 20;
				newAmount = oldAmount;
				twentyCount++;
			
			}
			return twentyCount;
			
			
			
			
			
		}
		

}


