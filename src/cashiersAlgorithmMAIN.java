
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


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
	JPanel tens;
	JPanel fives;
	JPanel ones;
	JPanel quarters;
	JPanel dimes;
	JPanel nickels;
	JPanel pennies;
	
	
	JTextField enterCharged;
	JTextField enterPaid;
	JTextField changeDue;
	JButton calculate;
	JTextField displayTwenties;
	JTextField displayTens;
	JTextField displayFives;
	JTextField displayOnes;
	JTextField displayQuarters;
	JTextField displayDimes;
	JTextField displayNickels;
	JTextField displayPennies;
	
	
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
		displayTwenties.setBounds(60,250,100,50);
		displayTwenties.setEditable(false);
		displayTwenties.setBackground(Color.LIGHT_GRAY);
		displayTwenties.addActionListener(this);
		//displayTwenties.setText(twentyCount);
		
		displayTens = new JTextField();
		displayTens.setBounds(200,250,100,50);
		displayTens.setEditable(false);
		displayTens.setBackground(Color.LIGHT_GRAY);
		displayTens.addActionListener(this);
		
		displayFives = new JTextField();
		displayFives.setBounds(340, 250,100,50);
		displayFives.setEditable(false);
		displayFives.setBackground(Color.LIGHT_GRAY);
		
		displayOnes = new JTextField();
		displayOnes.setBounds(480, 250,100,50);
		displayOnes.setEditable(false);
		displayOnes.setBackground(Color.LIGHT_GRAY);
		displayOnes.addActionListener(this);
		
		
		
		displayQuarters = new JTextField();
		displayQuarters.setBounds(60, 350, 100, 50);
		displayQuarters.setEditable(false);
		displayQuarters.setBackground(Color.LIGHT_GRAY);
		displayQuarters.addActionListener(this);
		
		displayDimes = new JTextField();
		displayDimes.setBounds(200,350,100,50);
		displayDimes.setEditable(false);
		displayDimes.setBackground(Color.LIGHT_GRAY);
		displayDimes.addActionListener(this);
		
		displayNickels = new JTextField();
		displayNickels.setBounds(340, 350, 100, 50);
		displayNickels.setEditable(false);
		displayNickels.setBackground(Color.LIGHT_GRAY);
		displayNickels.addActionListener(this);
		
		displayPennies = new JTextField();
		displayPennies.setBounds(480, 350, 100, 50);
		displayPennies.setEditable(false);
		displayPennies.setBackground(Color.LIGHT_GRAY);
		displayPennies.addActionListener(this);
		
		
		
		
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
		frame.add(displayTens);
		frame.add(displayFives);
		frame.add(displayOnes);
		frame.add(displayQuarters);
		frame.add(displayDimes);
		frame.add(displayNickels);
		frame.add(displayPennies);
		
		
		
		
		
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

				double paid = Double.parseDouble(enterPaid.getText());
				double charged = Double.parseDouble(enterCharged.getText());
				DecimalFormat df = new DecimalFormat("#,###.##");
				double whatToPay = whatToPay(paid, charged);
				double twentyCount = denominationReturn(whatToPay);
				double tensCount = tensReturn(whatToPay, twentyCount);
				double fivesCount = fivesReturn(whatToPay, tensCount, twentyCount);
				double onesCount = onesReturn(whatToPay, twentyCount, tensCount, fivesCount);
				double quartersCount = quartersReturn(whatToPay, twentyCount, tensCount, fivesCount, onesCount);
				double dimesCount = dimesReturn(whatToPay, twentyCount, tensCount, fivesCount, onesCount, quartersCount);
				double nickelsCount = nickelsReturn(whatToPay, twentyCount, tensCount, fivesCount, onesCount, quartersCount, dimesCount);
				double penniesCount = penniesReturn(whatToPay, twentyCount, tensCount, fivesCount, onesCount, quartersCount, dimesCount, nickelsCount);
				
				displayTwenties.setText("Twenties: " + String.valueOf(twentyCount));
				displayTens.setText("Tens: " + String.valueOf(tensCount));
				displayFives.setText("Fives: " + String.valueOf(fivesCount));
				displayOnes.setText("Ones: " + String.valueOf(onesCount));
				displayQuarters.setText("Quarters: " + String.valueOf(quartersCount));
				displayDimes.setText("Dimes: " + String.valueOf(dimesCount));
				displayNickels.setText("Nickels: " + String.valueOf(nickelsCount));
				displayPennies.setText("Pennies: " + String.valueOf(penniesCount));
				
				changeDue.setText(String.valueOf(df.format(whatToPay)));
				
				System.out.println("paid: " + paid);
				System.out.println("charged: " + charged);
				System.out.println("Unformatted:" + whatToPay);
				System.out.println(String.format("%,.2f", whatToPay));
				
			}
			
		}
		






		public double whatToPay(double paid, double charged) {
			
			DecimalFormat df = new DecimalFormat("#,###.##");
			
			double whatToPay =  (paid - charged);
			
			String str = Double.toString(whatToPay);
			
			str = df.format(whatToPay);
			
			whatToPay = Double.parseDouble(str);

			return whatToPay;
			
			
		}
		
		double denominationReturn( double whatToPay){
			double twentyCount = 0;
			double oldAmount = whatToPay;
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while (oldAmount - 20 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 20;
			 
				twentyCount++;
			}
			if (twentyCount > 0) {
				displayTwenties.setBackground(Color.green);
			}
			else {
				displayTwenties.setBackground(Color.red);
			}
			return twentyCount;	
			
		}
		
		double tensReturn(double whatToPay, double twentyCount) {
			double tensCount = 0;
			double oldAmount = whatToPay - (twentyCount * 20);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while (oldAmount - 10 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 10;
			 
				
				tensCount++;
			
			}
			if (tensCount > 0) {
				displayTens.setBackground(Color.green);
			}
			else {
				displayTens.setBackground(Color.red);
			}
			return tensCount;
			
		}
		
		double fivesReturn(double whatToPay, double tensCount, double twentyCount) {
			double fivesCount = 0;
			double oldAmount = whatToPay - (twentyCount * 20) - (tensCount * 10);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while (oldAmount - 5 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 5;
			 
				
				fivesCount++;
			}
			if (fivesCount > 0) {
				displayFives.setBackground(Color.green);
			}
			else {
				displayFives.setBackground(Color.red);
			}
			return fivesCount;
		
		}
		double onesReturn(double whatToPay, double twentyCount, double tensCount, double fivesCount) {
			double onesCount = 0;
			double oldAmount = whatToPay - (twentyCount * 20) - (tensCount * 10) - (fivesCount * 5);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while (oldAmount - 1 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 1;
				
				onesCount++;
			}
			
			if (onesCount > 0) {
				displayOnes.setBackground(Color.green);
			}
			else {
				displayOnes.setBackground(Color.red);
			}
			
			return onesCount;
			
		}
		double quartersReturn(double whatToPay, double twentyCount, double tensCount, double fivesCount, double onesCount) {
			double quartersCount = 0;
			double oldAmount = whatToPay - (twentyCount * 20) - (tensCount * 10) - (fivesCount * 5) - (onesCount * 1);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while(oldAmount - 0.25 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 0.25;
				
				quartersCount++;
			}
			
			if (quartersCount > 0) {
				displayQuarters.setBackground(Color.green);
			}
			else {
				displayQuarters.setBackground(Color.red);
			}
			
			return quartersCount;
		}
		double dimesReturn (double whatToPay, double twentyCount, double tensCount, double fivesCount, double onesCount, double quartersCount) {
			double dimesCount = 0;
			double oldAmount = whatToPay - (twentyCount * 20) - (tensCount * 10) - (fivesCount * 5) - (onesCount * 1) - (quartersCount * 0.25);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while (oldAmount - 0.1 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 0.1;
				
				dimesCount++;
			}
			if (dimesCount > 0) {
				displayDimes.setBackground(Color.green);
			}
			else {
				displayDimes.setBackground(Color.red);
			}
			
			return dimesCount;
			
		}
		double nickelsReturn(double whatToPay, double twentyCount, double tensCount, double fivesCount, 
		double onesCount, double quartersCount, double dimesCount) {
			double nickelsCount = 0;
			double oldAmount = whatToPay - (twentyCount * 20) - (tensCount * 10) - 
			(fivesCount * 5) - (onesCount * 1) - (quartersCount * 0.25) - (dimesCount * 0.1);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			while (oldAmount - 0.05 >= 0) {
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 0.05;
				
				nickelsCount++;
			}
			if (nickelsCount > 0) {
				displayNickels.setBackground(Color.green);
			}
			else {
				displayNickels.setBackground(Color.red);
			}
			return nickelsCount;
			
		}
		double penniesReturn(double whatToPay, double twentyCount, double tensCount, double fivesCount,
				double onesCount, double quartersCount, double dimesCount, double nickelsCount) {
			
			
			double penniesCount = 0;
			
			double oldAmount = whatToPay - (twentyCount * 20) - (tensCount * 10) - 
				(fivesCount * 5) - (onesCount * 1) - (quartersCount * 0.25) - (dimesCount * 0.1) - (nickelsCount * 0.05);
			oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
			
			
			while (oldAmount - 0.01 >= 0) {
				
				oldAmount = (Math.round(oldAmount * 100.0) / 100.0);
				oldAmount = oldAmount - 0.01;
				
				
				penniesCount++;
				
				
			}
			
			if (penniesCount > 0) {
				displayPennies.setBackground(Color.green);
			}
			else {
				displayPennies.setBackground(Color.red);
			}
			
			
			
			return penniesCount;
		}
		

}

