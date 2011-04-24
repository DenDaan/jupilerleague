package voetbal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import datum.DatumException;

import voetbal.doelpunt.Doelpunt;
import voetbal.doelpunt.util.DoelpuntManier;
import voetbal.speler.Speler;
import voetbal.speler.util.GoodDate;
import voetbal.speler.util.Positie;
import voetbal.speler.util.Voet;

public class TestWithoutSpring {

	/**
	 * @param args
	 * @throws DatumException 
	 */
	public static void main(String[] args) throws DatumException {
		
		List<Positie> pos = new ArrayList<Positie>();
		pos.add(Positie.CAM);
		pos.add(Positie.DM);
		
//		Speler speler = new Speler("Daan", "Vleugels", null, null, pos, Voet.BEIDE, null, null);
		
//		pos = speler.getPosities();
		System.out.println(pos.get(0).getBreedtePositie());
		System.out.println(pos.get(0).getDieptePositie());
		System.out.println(pos.get(0));
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("voetbal");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Team brugge = new Team("Club Brugge");
		List<String> nationaliteiten = new ArrayList<String>();
		nationaliteiten.add("Marrokkaan");
		Period periode = new Period(GoodDate.createDate(11,12,2005), new Date());
		List<Positie> posities = new ArrayList<Positie>();
		posities.add(Positie.LAM);
		Speler dirar = new Speler("Nabil", "Dirar", null, null, pos, Voet.BEIDE, null, null);
		Speler bous = new Speler("Mbark", "Boussouffa", null, null, pos, Voet.BEIDE, null, null);
//		Speler dirar = new Speler("Nabil", "Dirar",nationaliteiten ,GoodDate.createDate(4, 12, 1985), posities, Voet.BEIDE, brugge,periode);
//		Speler bous = new Speler("Mbark", "Boussouffa",nationaliteiten ,GoodDate.createDate(14, 5, 1985), posities, Voet.BEIDE, brugge,periode);
		
		Game game = new Game();
		game.setSeizoen(new Season(2009));
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
