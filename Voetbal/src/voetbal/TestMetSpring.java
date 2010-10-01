package voetbal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import voetbal.manager.*;

public class TestMetSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("conf/voetbalserver.xml");
		Manager ploegenManager = (PloegenManager) ctx.getBean("PloegenManager");
		Manager gameManager = (GameManager) ctx.getBean("GameManager");
		Manager doelpuntManager = (DoelpuntManager) ctx.getBean("DoelpuntManager");
	}

}
