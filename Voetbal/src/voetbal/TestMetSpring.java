package voetbal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestMetSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/voetbalserver.xml");
	}

}
