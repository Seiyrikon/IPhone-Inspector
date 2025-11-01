package com.cellwego.iphone_inspector.device;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeviceDetector {
	private static final Logger log = LoggerFactory.getLogger(DeviceDetector.class);
	
	public void detect() {
		log.info("Detecting Iphone...");
		log.info("IPhone Detected!");
	}
}
