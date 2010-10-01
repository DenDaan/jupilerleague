package voetbal;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

import datum.DatumException;

import voetbal.doelpunt.Doelpunt;
import voetbal.doelpunt.util.DoelpuntManier;
import voetbal.speler.Speler;
import voetbal.speler.util.GoodDate;
import voetbal.speler.util.Positie;
import voetbal.speler.util.Voet;

public class TestZonderSpring {

	/**
	 * @param args
	 * @throws DatumException 
	 */
	public static void main(String[] args) throws DatumException {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Ploeg brugge = new Ploeg("Club Brugge");
		List<String> nationaliteiten = new ArrayList<String>();
		nationaliteiten.add("Marrokkaan");
		Periode periode = new Periode(GoodDate.createDate(11,12,2005), new Date());
		List<Positie> posities = new ArrayList<Positie>();
		posities.add(Positie.LAM);
		Speler dirar = new Speler("Nabil", "Dirar",nationaliteiten ,GoodDate.createDate(4, 12, 1985), posities, Voet.BEIDE, brugge,periode);
		Speler bous = new Speler("Mbark", "Boussouffa",nationaliteiten ,GoodDate.createDate(14, 5, 1985), posities, Voet.BEIDE, brugge,periode);
		
		Game game = new Game();
		game.setSeizoen(new Periode());
		game.setSpeeldag(3);
		game.setThuis(brugge);
		game.setUit(brugge);
		game.addDoelpunt(new Doelpunt(dirar, dirar, 43, DoelpuntManier.VOLLEY, game));
		game.addDoelpunt(new Doelpunt(bous,dirar,57,DoelpuntManier.VRIJETRAP, game));
		
		System.out.println(dirar);
		System.out.println(bous);
		em.persist(game);
		tx.commit();
		em.close();
		emf.close();
		System.out.println("Finished");
	}

}
