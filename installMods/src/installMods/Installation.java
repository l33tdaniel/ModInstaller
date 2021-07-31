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

import org.apache.commons.io.FileUtils;
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

	public void altInstallModsAndConfig() {

		File mods = new File(System.getProperty("user.dir") + "\\mods");
		File modsEnding = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\mods");
		File config = new File(System.getProperty("user.dir") + "\\config");
		File configEnding = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\config");
	
		try {
			if(!modsEnding.exists() && !configEnding.exists()){
				FileUtils.copyDirectory(mods, modsEnding);
				FileUtils.copyDirectory(config, configEnding);
			}
			else {
				String[]entries = modsEnding.list();
				for(String s: entries){
				    File currentFile = new File(modsEnding.getPath(), s);
				    currentFile.delete();
				}
				String[]noobs = configEnding.list();
				for(String s: noobs){
				    File currentFile = new File(modsEnding.getPath(), s);
				    currentFile.delete();
				}
			
				FileUtils.copyDirectory(mods, modsEnding);
				FileUtils.copyDirectory(config, configEnding);
			}
		}
		// this didn't work for jackson when he already had his files in there
		catch(Exception e) {
			System.out.println(e);
		}
	}
	// THIS WORKS!
	public void installMyOptions() {
		File source = new File(System.getProperty("user.dir") + "\\options.txt");
		File endSource = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\options.txt");
		File optifine = new File(System.getProperty("user.dir") + "\\optionsof.txt");
		File endOptifine = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\optionsof.txt");
		
		//source.renameTo(endSource);
		try {
			FileUtils.copyDirectory(source, endSource);
			FileUtils.copyDirectory(optifine, endOptifine);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
