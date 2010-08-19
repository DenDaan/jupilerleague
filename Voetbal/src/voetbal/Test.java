package voetbal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.*;

import datum.Datum;
import datum.DatumException;

import voetbal.doelpunt.Doelpunt;
import voetbal.doelpunt.util.DoelpuntManier;
import voetbal.speler.Speler;
import voetbal.speler.util.Positie;
import voetbal.speler.util.Voet;

public class Test {

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
		ArrayList<String> nationaliteiten = new ArrayList<String>();
		nationaliteiten.add("Marrokkaan");
		Periode periode = new Periode(new GregorianCalendar(2005,12,11), new GregorianCalendar());
		ArrayList<Positie> posities = new ArrayList<Positie>();
		posities.add(Positie.LAM);
		GregorianCalendar caldirar = new GregorianCalendar(1985,12,4);
		GregorianCalendar calbous = new GregorianCalendar(1984,5,14);
		Speler dirar = new Speler("Nabil", "Dirar",nationaliteiten ,caldirar, posities, Voet.BEIDE, brugge,periode);
		Speler bous = new Speler("Mbark", "Boussouffa",nationaliteiten ,calbous, posities, Voet.BEIDE, brugge,periode);
		Game game = new Game();
		game.setSeizoen(new Periode());
		game.setSpeeldag(3);
		game.setThuis(brugge);
		game.setUit(brugge);
		game.addDoelpunt(new Doelpunt(dirar, dirar, 43, DoelpuntManier.VOLLEY, game));
		game.addDoelpunt(new Doelpunt(bous,dirar,57,DoelpuntManier.VRIJETRAP, game));
		em.persist(game);
		tx.commit();
		em.close();
		emf.close();
		System.out.println("Finished");
	}

}
