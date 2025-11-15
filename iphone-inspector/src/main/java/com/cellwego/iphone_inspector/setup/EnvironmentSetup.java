package com.cellwego.iphone_inspector.setup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cellwego.iphone_inspector.MainFrame;

public class EnvironmentSetup {
	
	public static void ensureEnvironmentReady(MainFrame ui) {
		try {
			ui.log("Checking WSL status...");
//			if(!isWSLInstalled()) {
				ui.log("Installing WSL and Ubuntu...");
				runCommand("wsl.exe --install -d Ubuntu");
				ui.log("Waiting for installation to finish...");
//				while(!isWSLInstalled()) {
//					//wait for wsl to be installed
//				}
				
//			} else {
//				ui.log("WSL already installed.");
//			}
			
			ui.log("Configuring Ubuntu user...");
//			configureUbuntuUser(ui);
			
			ui.log("Installing libmobiledevice...");
//			runCommand("wsl sudo apt update && wsl sudo apt install -y libmobiledevice-utils");
			
			ui.log("Setup complete! Ready to detect iPhone");
		} catch (Exception e) {
			ui.log("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static boolean isWSLInstalled() {
		try {
			Process p = new ProcessBuilder("wsl", "--status").start();
			p.waitFor();
			return p.exitValue() == 0;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static void configureUbuntuUser(MainFrame ui) throws Exception {
		String setupScript = """
				sudo adduser --disabled-password --gecos "" cellwego
				echo 'cellwego:cellwego123' | sudo chpasswd
				sudo usermod -aG sudo cellwego
				sudo bash -c "echo '[user]\\ndefault=cellwego' > /etc/wsl.conf"
				""";
		
		ui.log("Setting up default user 'cellwego'...");
		runCommand("wsl sudo bash -c \"" + setupScript.replace("\n", " ") + "\"");
	}
	
	private static void runCommand(String cmd) throws Exception {
		Process process = new ProcessBuilder("cmd.exe", "/c", cmd)
				.redirectErrorStream(true)
				.start();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
		process.waitFor();
	}
}
