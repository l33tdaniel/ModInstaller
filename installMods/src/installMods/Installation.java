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

	public void altInstallModsAndConfig() {

		File mods = new File(System.getProperty("user.dir") + "\\mods");
		File modsEnding = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\mods");
		File config = new File(System.getProperty("user.dir") + "\\config");
		File configEnding = new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\.minecraft\\config");
	
		try {
			Files.move(mods.toPath(), modsEnding.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Files.move(config.toPath(), configEnding.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
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
			Files.move(source.toPath(), endSource.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Files.move(optifine.toPath(), endOptifine.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
