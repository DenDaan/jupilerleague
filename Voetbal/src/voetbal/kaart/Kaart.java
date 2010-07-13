package voetbal.kaart;

import voetbal.Game;
import voetbal.speler.Speler;
import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Kaart {

	@Id
	@GeneratedValue
	protected int id;
	
	@ManyToOne
	protected Game game;
	
	protected int minuut;
	
	@OneToOne
	protected Speler speler;
	
	protected String kleur;
	
	public Kaart(){};
	
	public Game getGame(){
		return game;
	}
	
	public Speler getSpeler(){
		return speler;
	}
	
	public String getKleur(){
		return kleur;
	}
}
