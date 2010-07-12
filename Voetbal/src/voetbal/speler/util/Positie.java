package voetbal.speler.util;


public enum Positie {
	// TODO: verschillende posities opgeven
	//Doelman
		DM(BreedtePositie.CENTRAAL, DieptePositie.DOELMAN),
	//Verdedigers
		RV(BreedtePositie.RECHTS, DieptePositie.VERDEDIGER),
		CV(BreedtePositie.CENTRAAL, DieptePositie.VERDEDIGER),
		LV(BreedtePositie.LINKS, DieptePositie.VERDEDIGER),
	//Vleugelverdedigers
		RVV(BreedtePositie.RECHTS, DieptePositie.VLEUGELVERDEDIGER),
		LVV(BreedtePositie.LINKS, DieptePositie.VLEUGELVERDEDIGER),
	//Verdedigende middenvelders
		RVM(BreedtePositie.RECHTS, DieptePositie.VERD_MID),
		CVM(BreedtePositie.CENTRAAL, DieptePositie.VERD_MID),
		LVM(BreedtePositie.LINKS, DieptePositie.VERD_MID),
	//Middenvelders
		RM(BreedtePositie.RECHTS, DieptePositie.MIDDENVELDER),
		CM(BreedtePositie.CENTRAAL, DieptePositie.MIDDENVELDER),
		LM(BreedtePositie.LINKS, DieptePositie.MIDDENVELDER),
	//Aanvallende middenvelders
		RAM(BreedtePositie.RECHTS, DieptePositie.AANV_MID),
		CAM(BreedtePositie.CENTRAAL, DieptePositie.AANV_MID),
		LAM(BreedtePositie.LINKS, DieptePositie.AANV_MID),
	//Aanvallers
		RA(BreedtePositie.RECHTS, DieptePositie.AANVALLER),
		CA(BreedtePositie.CENTRAAL, DieptePositie.AANVALLER),
		LA(BreedtePositie.LINKS, DieptePositie.AANVALLER),
	//Spits
		SP(BreedtePositie.CENTRAAL, DieptePositie.SPITS);
	
	private BreedtePositie brpos;
	private DieptePositie dpos;
	Positie(BreedtePositie brpos, DieptePositie dpos){
		this.dpos=dpos;
		this.brpos=brpos;
	}
	
	public BreedtePositie getBreedtePositie(){
		return brpos;
	}
	
	public DieptePositie getDieptePositie(){
		return dpos;
	}
}
