package installMods;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
// do we have some way to make sure that we download java before forge?
public class Installation {

	public synchronized void installJava() {
		File Java = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop", "Java.exe" );
		try {
			this.wait(5000);
		    Desktop.getDesktop().open(Java);
		}
		catch(java.io.IOException e) {
			System.out.println("The user failed to give access to java." + e);
		}
		catch(Exception e) {
			System.out.print("Something went wrong: " + e);
			installJava();
		}
	}
	public synchronized void installForge() {
		File Forge = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop", "forge-1.12.2-14.23.5.2855-installer.jar" );
		try {
			this.wait(500);
		    Desktop.getDesktop().open(Forge);
		}
		catch(java.io.IOException e) {
			System.out.println("The user failed to give access to java." + e);
		}
		catch(Exception e) {
			System.out.print("Something went wrong: " + e);
			installForge();
		}
	}
	public void installModsAndConfig() {
		File Mods = new File("mods");
		File Config = new File("config");
		File truePath = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\mods");
		File truePathTwo = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\config");
		Mods.renameTo(truePath);
		Config.renameTo(truePathTwo);

	}
}
