package com.cellwego.iphone_inspector.device;

import java.util.ArrayList;
import java.util.List;

import com.cellwego.iphone_inspector.MainFrame;
import com.cellwego.iphone_inspector.inspector.Inspector;

public class DeviceDetector {
	public void detect() {
		List<String> iphone =  Inspector.runCommand("idevice_id.exe", "-l");
		if(iphone.size() != 0) {
			if(!iphone.get(0).contains("ERROR")) {
				MainFrame.log("Device detected!");
				List<String> informations = Inspector.runCommand("ideviceinfo.exe");
				List<String> mappedInformations = new ArrayList<>();
				String modelNumberRegion = "";
				
				if(informations.size() != 0) {
					for(String info : informations) {
						if(info.contains("InternationalMobileEquipmentIdentity:")) {
							String[] parts = info.split(" ");
							mappedInformations.add("IMEI/MEID: " + parts[1]);
							continue;
						}
						
						if(info.contains("InternationalMobileEquipmentIdentity2:")) {
							String[] parts = info.split(" ");
							mappedInformations.add("IMEI2: " + parts[1]);
							continue;
						}
						
						if(info.contains("SerialNumber:")) {
							String[] parts = info.split(" ");
							mappedInformations.add("(S) Serial No: " + parts[1]);
							continue;
						}
						
						if(info.contains("ModelNumber:") || info.contains("RegionInfo:")) {
							String[] parts = info.split(" ");
							modelNumberRegion += parts[1];
							continue;
						}
						
						if(info.contains("ProductName:")) {
							String[] parts = info.split(" ");
							mappedInformations.add("Product Name: " + parts[1]);
							continue;
						}
						
						if(info.contains("ProductType:")) {
							String[] parts = info.split(" ");
							mappedInformations.add("Product Type: " + parts[1]);
							continue;
						}
						
						if(info.contains("ProductVersion:")) {
							String[] parts = info.split(" ");
							mappedInformations.add("Product Version: " + parts[1]);
							continue;
						}
						
					}
				}
				mappedInformations.add("Model Number: " + modelNumberRegion);
				for(String mi : mappedInformations) {
					MainFrame.log(mi);
				}
			}
		} else {
			MainFrame.log("No device has been detected!");
			MainFrame.log("Plug your device");
			MainFrame.log("Then on your device click \"Trust\"");
		}
	}
}
