package installMods;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
					File sourceConfig = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads\\ModInstaller\\config");
					File endSourceConfig = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\config");
				
					File sourceFile = new File("C:\\Users\\"  + System.getProperty("user.name") + "\\Downloads\\ModInstaller\\mods");
					File endSource = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\mods");
					try {
						sourceConfig.renameTo(endSourceConfig);
						sourceFile.renameTo(endSource);
					}
					catch(Exception e) {
						System.out.println(e);
						altInstallModsAndConfig();
					}	
					
	}
	public void altInstallModsAndConfig() {
		File sourceConfig = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\ModInstaller\\config");
		File endSourceConfig = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\config");
	
		File sourceFile = new File("C:\\Users\\"  + System.getProperty("user.name") + "\\Desktop\\ModInstaller\\mods");
		File endSource = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\mods");
		try {
			sourceConfig.renameTo(endSourceConfig);
			sourceFile.renameTo(endSource);
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
}
