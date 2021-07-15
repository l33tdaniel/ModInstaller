/* 
 We must find some way to close the program and then open the files that need to be opened
 // as of right now, you're able to launch it as a runnable jar but not as a default one
 */ 
package installMods;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener{
	// you have to make the buttons outside of a function since multiple functions use it
	//Downloads downloadItems = new Downloads();
	JButton button;
	JButton buttonFirstNo;
	JButton buttonSecondNo;
	JButton buttonSecondYes;
	JButton buttonThirdYes;
	JButton buttonThirdNo;
	JButton buttonFourthYes;
	JButton buttonFourthNo;
	boolean needsMyOptions;
	boolean needsJava;
	boolean needsForge;
	boolean needsConfigOrMods;
	JFrame frame = new JFrame();
	Installation filesNeeded = new Installation();
	public void create() {
		JLabel label = new JLabel(); // creates the image
		JLabel questionOne = new JLabel();
		JLabel questionTwo = new JLabel();
		JLabel questionThree = new JLabel();
		JLabel questionFour = new JLabel();
		
	
		ImageIcon image = new ImageIcon(getClass().getResource("/javlogo.jpg"));
		questionOne.setText("Do you need to download forge?");
		questionOne.setBounds(535, 0, 200, 200);
		questionTwo.setText("Do you have the most recent version of java installed?");
		questionTwo.setBounds(470, 160, 320, 200);
		questionThree.setText("Do you need to move the mods and config in?");
		questionThree.setBounds(495, 300, 320, 200);
		questionFour.setText("Would you like to use my settings for optimal FPS?");
		questionFour.setBounds(475, 450, 320, 200);
		
		label.setIcon(image);
		label.setForeground(new Color(0,0,0));
		label.setIconTextGap(90);
		label.setBounds(50, 25, 700, 700); //this is setting where you want the label to be
		
		//frame.setLayout(null); // this cancels out everything we did down here I think
		frame.setSize(810,810);
		frame.setResizable(false); // this can make it where they can't resize
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minecraft mods"); //titles the project. duh
		frame.setIconImage(image.getImage()); // this pulls emma watson in.. (a necessity)
		frame.getContentPane().setBackground(new Color(220,220,220)); // neutral grey 
		// setting up the first yes button
		button  = new JButton();
		button.setBounds(500, 120, 70, 70);
		button.addActionListener(this);
		button.setText("yes");
		button.setFocusable(false);
		// setting up the first no button
		buttonFirstNo = new JButton();
		buttonFirstNo.setBounds(670, 120, 70, 70);
		buttonFirstNo.addActionListener(e -> buttonOneNoWasPressed());
		buttonFirstNo.setText("no");
		buttonFirstNo.setFocusable(false);
		// setting up the second yes button
		buttonSecondYes  = new JButton();
		buttonSecondYes.setBounds(500, 280, 70, 70);
		buttonSecondYes.addActionListener(e -> buttonTwoYesWasPressed());
		buttonSecondYes.setText("yes");
		buttonSecondYes.setFocusable(false);
		//setting up the second no button
		buttonSecondNo = new JButton();
		buttonSecondNo.setBounds(670, 280, 70, 70);
		buttonSecondNo.addActionListener(e -> buttonTwoNoWasPressed());
		buttonSecondNo.setText("no");
		buttonSecondNo.setFocusable(false);
		// setting up the third yes button
		buttonThirdYes  = new JButton();
		buttonThirdYes.setBounds(500, 420, 70, 70);
		buttonThirdYes.addActionListener(e -> buttonThreeYesWasPressed());
		buttonThirdYes.setText("yes");
		buttonThirdYes.setFocusable(false);
		// setting up the third no button
		buttonThirdNo = new JButton();
		buttonThirdNo.setBounds(670, 420, 70, 70);
		buttonThirdNo.addActionListener(e -> buttonThreeNoWasPressed());
		buttonThirdNo.setText("no");
		buttonThirdNo.setFocusable(false);
		// setting up the fourth yes button
		buttonFourthYes  = new JButton();
		buttonFourthYes.setBounds(500, 570, 70, 70);
		buttonFourthYes.addActionListener(e -> buttonFourYesWasPressed());
		buttonFourthYes.setText("yes");
		buttonFourthYes.setFocusable(false);
		// setting up the fourth no button
		buttonFourthNo = new JButton();
		buttonFourthNo.setBounds(670, 570, 70, 70);
		buttonFourthNo.addActionListener(e -> buttonFourNoWasPressed());
		buttonFourthNo.setText("no");
		buttonFourthNo.setFocusable(false);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		// adding everything into the frame
		frame.add(button);
		frame.add(buttonFirstNo);
		frame.add(buttonSecondNo);
		frame.add(buttonSecondYes);
		frame.add(buttonThirdYes);
		frame.add(buttonThirdNo);
		frame.add(label);
		frame.add(questionOne);
		frame.add(questionTwo);
		frame.add(questionThree);
		frame.add(questionFour);
		frame.add(buttonFourthYes);
		frame.add(buttonFourthNo);
		button.setVisible(true);
		buttonFirstNo.setVisible(true);
		buttonSecondNo.setVisible(true);
		buttonThirdYes.setVisible(true);
		buttonThirdNo.setVisible(true);
		buttonFourthYes.setVisible(true);
		buttonFourthNo.setVisible(true);
		label.setVisible(true);
		questionOne.setVisible(true);
		questionTwo.setVisible(true);
		questionThree.setVisible(true);
		questionFour.setVisible(true);
		frame.setVisible(true);
		
	}
	// the code below is what the buttons are calling
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("You have designated that you don't already have forge 1.12.2.\n The program will attempt to download it for you now!");
			button.setEnabled(false);
			buttonFirstNo.setEnabled(false);
			needsForge = true;
			try {
				// attempts to download java onto their desktop for them to install it.
				String link = "https://maven.minecraftforge.net/net/minecraftforge/forge/1.12.2-14.23.5.2855/forge-1.12.2-14.23.5.2855-installer.jar";
				File out = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop", "forge-1.12.2-14.23.5.2855-installer.jar" );
				new Thread(new Downloads(link, out)).start();
				
			}
			catch(Exception d) {
				System.out.print("Something went wrong: " + d + "\nYou were unable the download the files for whatever reason");
			}
			startInstalls();
		}
	}
	public void buttonOneNoWasPressed() {
		System.out.println("You have designated that you already have forge 1.12.2.");
		buttonFirstNo.setEnabled(false);
		button.setEnabled(false);
		needsForge = false;
		startInstalls();
	}
	public void buttonTwoNoWasPressed() {
		System.out.println("You have designated that you don't have java installed; \nThe program will now work to download Java");
		buttonSecondNo.setEnabled(false);
		buttonSecondYes.setEnabled(false);
		try {
			// attempts to download java onto their desktop for them to install it.
			String link = "https://javadl.oracle.com/webapps/download/AutoDL?BundleId=244584_d7fc238d0cbf4b0dac67be84580cfb4b";
			File out = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop", "Java.exe" );
			new Thread(new Downloads(link, out)).start();
			needsJava = true;
			
		}
		catch(Exception e) {
			System.out.print("Something went wrong: " + e + "\nYou were unable the download the files for whatever reason");
		}
		startInstalls();
		
	}
	public void buttonTwoYesWasPressed() {
		// nothing is needed to be downloaded
		System.out.println("You have designated that you have java installed");
		buttonSecondNo.setEnabled(false);
		buttonSecondYes.setEnabled(false);
		needsJava = false;
		startInstalls();
	}
	public void buttonThreeYesWasPressed() {
		System.out.println("You have designated that you downloaded the mods and config <3");
		buttonThirdYes.setEnabled(false);
		buttonThirdNo.setEnabled(false);
		needsConfigOrMods = true;
		startInstalls();
	}
	public void buttonThreeNoWasPressed() {
		System.out.println("You have designated that you haven't downloaded the mods and config; \nThe program will now work to download the mods and config");
		buttonThirdYes.setEnabled(false);
		buttonThirdNo.setEnabled(false);
		needsConfigOrMods = false;
		startInstalls();
	}
	public void buttonFourYesWasPressed() {
		System.out.println("You have designated that you want my options for optimal fps");
		buttonFourthNo.setEnabled(false);
		buttonFourthYes.setEnabled(false);
		needsMyOptions = true;
		startInstalls();
	}
	public void buttonFourNoWasPressed() {
		System.out.println("You have designated that you don't need the optimal fps");
		buttonFourthNo.setEnabled(false);
		buttonFourthYes.setEnabled(false);
		needsMyOptions = false;
		startInstalls();
	}
	
	// once all the buttons are pressed, we must close the JFrame and call another process to start running them
	public void startInstalls() {
		if(buttonThirdYes.isEnabled() == false && buttonSecondNo.isEnabled() == false && buttonFirstNo.isEnabled() == false && buttonFourthNo.isEnabled() == false) {
			System.out.println("test");
			frame.dispose();
			if(needsConfigOrMods == true) {
				filesNeeded.altInstallModsAndConfig();
			}
			if(needsJava == true) {
				filesNeeded.installJava();
			}
			if(needsForge == true) {
				filesNeeded.installForge();
			}
			if(needsMyOptions == true) {
				filesNeeded.installMyOptions();
			}
		}
	}
}
