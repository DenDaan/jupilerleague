package voetbal.kaart;

import voetbal.Game;
import voetbal.speler.Speler;
import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Kaart {

	@Id
	@GeneratedValue
	@Column(name="Id")
	protected int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	protected Game game;
	
	@Column(name="Time")
	protected int minuut;
	
	@OneToOne(cascade=CascadeType.ALL)
	protected Speler speler;
	
	@Column(name="Color")
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
