package voetbal;

import java.util.*;
import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import voetbal.doelpunt.Doelpunt;
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
		
		ArrayList<Ploeg> ploegen = (ArrayList<Ploeg>) ploegenManager.getAll();
		ArrayList<Game> games = (ArrayList<Game>) gameManager.getAll();
		ArrayList<Doelpunt> doelpunten = (ArrayList<Doelpunt>) doelpuntManager.getAll();
		Ploeg brugge = ploegen.get(0);
		Game game0 = games.get(0);
		Doelpunt doelpunt = doelpunten.get(0);
		
		System.out.println(brugge);
		System.out.println(game0);
		System.out.println(doelpunt);
	}

}
