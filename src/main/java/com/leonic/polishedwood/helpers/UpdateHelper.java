package com.leonic.polishedwood.helpers;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import com.leonic.polishedwood.References;
/**
 * Class that check for updates for the Polished Wood mod.
 * 
 * @author ZanyLeonic
 * @version 0.1
 */
public class UpdateHelper {
	
	private static String currentVersion = References.VERSION;
	private static String newestVersion;
	private static String newestVersionURL = null;
	public static String updateURL = "";
	public static String updateStatus = "";
	public static boolean show = false;
	
	/**
	 * Calls getNewestVersion() to check for new versions and getNewestVersionURL() for the download link. 
	 */
	public static void init() {
		getNewestVersion();
			if(newestVersion != null) {
				if(newestVersion.equalsIgnoreCase(currentVersion)) {
					updateStatus = "Polished Wood is up to date!";
					LogHelper.info("Polished Wood is up to date!");
					show = false;
				}else {
					show = true;
					getNewestVersionURL();
					updateStatus = "There is a newer version of Balloons. Your version: " + currentVersion + " Latest version: " + newestVersion;
						if(newestVersionURL != null){
							updateURL = "You can download it at " + newestVersionURL;
						}else{
							updateURL = "Couldn't get link, try going to http://ZanyLeonic.github.io/PolishedWood/ .";
						}
						
					LogHelper.info("Polished Wood is out of date! Your version: " + currentVersion + " Latest version: " + newestVersion);
				}
		}else {
			show = true;
			updateStatus = "Polished Wood failed to connect to check if updates are available!";
			LogHelper.error("Failed to connect to check if update are available!");
		}
	}
	
	/**
	 * Checks with my GitHub for the latest released version.
	 */
	private static void getNewestVersion() {
		try {
			URL url = new URL("http://zanyleonic.github.io/PolishedWood/versions/1.7.10/latest.ver");
			Scanner s = new Scanner(url.openStream());
			newestVersion = s.next();
			s.close();
		}catch(IOException ex) {
			LogHelper.error("Cannot check for latest version. Either GitHub is blocked or connection was closed. Could not connect to determine if mod was up to date!");
			LogHelper.error("Stacktrace:");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Checks with with my GitHub to get the link to latest version download link.
	 */
	private static void getNewestVersionURL() {
		try{
			URL url = new URL("http://zanyleonic.github.io/PolishedWood/versions/1.7.10/latest.url");
			Scanner scan = new Scanner(url.openStream());
			newestVersionURL = scan.next();
			scan.close();
		}catch(IOException ex) {
			LogHelper.error("Cannot check for latest URL for update. Either GitHub is blocked or connection was closed.");
			LogHelper.error("Stacktrace:");
			ex.printStackTrace();
		}
	}
}