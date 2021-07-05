package installMods;
// file should be called something like path
// it turns out that closing the files for the downloading is all it took for it not to be open SE Binary
import java.io.*;
import java.net.*;
public class Downloads implements Runnable{
	String link;
	File out;
	
	public Downloads(String link, File out) {
		this.link = link;
		this.out = out;
	}
	public void run( ) {
		try {
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			double fileSize = (double)http.getContentLengthLong();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			FileOutputStream fos = new FileOutputStream(this.out);
			BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			byte[] buffer = new byte[1024];
			double downloaded = 0.00;
			int read = 0;
			double percentDownloaded = 0.00;
			while((read = in.read(buffer, 0, 1024)) >= 0) {
				bout.write(buffer, 0, read);
				downloaded += read;
				percentDownloaded = (downloaded*100)/fileSize;
				String percent = String.format("%.4f",  percentDownloaded);
				//System.out.println("Downloaded " + percent + "% of a file.");
			}
			bout.close();
			fos.close();
			in.close();
			return;
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}	
}