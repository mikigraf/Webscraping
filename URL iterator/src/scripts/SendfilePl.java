package scripts;

import gui.GUI;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class SendfilePl {

	// TODO CHECK IF FOLDER ON THE PATH EXISTS, IF NOT THEN CREATE IT AND SAVE
	// THERE

	public static void createLog() throws InterruptedException {
		try {
			URL sendfile = new URL("http://sendfile.pl/");
			PrintWriter sendfileLogger = new PrintWriter(GUI.TFlocation.getText());
			for (int x = Integer.parseInt(GUI.TFstartingIndex.getText()); x < Integer.parseInt(GUI.TFendingIndex.getText()); x++) {
				int y = x;
				String url = sendfile.toString() + x;
				org.jsoup.nodes.Document sendfileContent = Jsoup.connect(url).get();
				Elements sendfileElements = sendfileContent.select("title");
				while(sendfileElements.toString() == "Plik nie istnieje! - Hosting plików") {
					Thread.sleep(10000);
//					System.out.println("Waiting for a wild file to appear!");
				}
//				System.out.println("A wilde file has apperaed " + x );
				String fileNames = sendfileElements.toString();
				String namesWithoutLeftTag = fileNames.replace("<title>", " ").replace("pobierz za darmo - Hosting plik�w", " ");
				String namesWithoutTag = namesWithoutLeftTag.replace("</title>", " ");
				sendfileLogger.println("<table><td><li><tr><a href=" + url + ">" + namesWithoutTag + "</a></tr> " + "<tr>" + x + "</tr> "
						+ "<tr>" + namesWithoutTag + "</tr> " + "</li></td></table>\n");
				// for testing
				System.out.println(x + " " + namesWithoutTag + " " + url + "\n");

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	

	public static void downloadFiles() {
		try {
			URL sendfile = new URL("http://sendfile.pl/");
			FileWriter downloader = new FileWriter(GUI.TFlocation.getText());
			for (int x = Integer.parseInt(GUI.TFstartingIndex.getText()); x < Integer.parseInt(GUI.TFendingIndex.getText()); x++) {
				String url = sendfile.toString() + x;
				System.out.println(url);
				org.jsoup.nodes.Document sendfileContent = Jsoup.connect(url).get();
				Elements sendfileElements = sendfileContent.select("title");
				String fileNames = sendfileElements.toString();
				String namesWithoutLeftTag = fileNames.replace("<title>", " ").replace("pobierz za darmo - Hosting plik�w", " ");
				String namesWithoutTag = namesWithoutLeftTag.replace("</title>", " ");

				org.jsoup.nodes.Document downloadedFile = Jsoup.connect(url).get();
				String sendfileDirectUrl = "http://sendfile.pl/download.php?id=" + x;
				URL UsendfileDirectUrl = new URL(sendfileDirectUrl);
				ReadableByteChannel sendfileDl = Channels.newChannel(UsendfileDirectUrl.openStream());
				FileOutputStream output = new FileOutputStream(GUI.TFlocation.getText().replace("test.html", "") + namesWithoutTag);
				output.getChannel().transferFrom(sendfileDl, 0, Long.MAX_VALUE);

				// TODO DOWNLOAD FILE WITH BUFFEREDINPUTSTREAM BYTE BY BYTE
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
}
