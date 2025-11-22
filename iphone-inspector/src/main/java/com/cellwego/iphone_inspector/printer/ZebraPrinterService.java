package com.cellwego.iphone_inspector.printer;

import com.zebra.sdk.printer.*;
import com.zebra.sdk.printer.discovery.*;
import com.zebra.sdk.comm.*;

public class ZebraPrinterService {

	public ZebraPrinter connect() throws Exception {
		DiscoveredUsbPrinter printer = null;
		
		for(DiscoveredUsbPrinter usbPrinter : UsbDiscoverer.getZebraUsbPrinters()) {
			printer = usbPrinter;
		}
		
		if(printer == null) {
			throw new Exception("No Zebra USB printer detected.");
		}
		
		Connection conn = printer.getConnection();
		conn.open();
		
		return ZebraPrinterFactory.getInstance(conn);
	}
	
    public void printLabel(String zpl) throws Exception {
        ZebraPrinter printer = connect();
        // printer.getConnection().write(zpl.getBytes());
		printer.sendCommand("^XA^XZ");
		Thread.sleep(200);

		// Print the real label
		printer.sendCommand(zpl);
        printer.getConnection().close();
    }
}
