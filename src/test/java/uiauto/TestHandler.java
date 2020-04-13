package uiauto;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class TestHandler {
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger("1");
//		new XMLFormatter();
		FileHandler fh = new FileHandler("D:\\testlogml0.log");
		log.addHandler(fh);
		log.info("info");
		log.warning("warning");
		log.severe("severe");
		fh.close();
	}

}
