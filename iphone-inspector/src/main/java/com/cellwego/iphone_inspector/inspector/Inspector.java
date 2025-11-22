package com.cellwego.iphone_inspector.inspector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.cellwego.iphone_inspector.MainFrame;


public class Inspector {
	
    public static List<String> runCommand(String... cmd) {
    	List<String> result = new ArrayList<>();
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = 
                new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
//                MainFrame.log(line);
                result.add(line);
            }

            int exitCode = process.waitFor();
        } catch (Exception e) {
            MainFrame.log("Error: " + e.getMessage());
        }
        
        return result;
    }

}
