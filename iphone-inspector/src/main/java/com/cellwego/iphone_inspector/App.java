package com.cellwego.iphone_inspector;

import com.cellwego.iphone_inspector.device.DeviceDetector;
import com.cellwego.iphone_inspector.device.DeviceInfo;

/**
 * @author Seiyrikon
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("CellWeGo IPhone Inspector");
    	DeviceDetector deviceDetector = new DeviceDetector();
    	
        deviceDetector.detect();
    }
}
