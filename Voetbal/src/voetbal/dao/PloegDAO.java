package voetbal.dao;

import java.util.List;
import voetbal.Ploeg;

public interface PloegDAO {
	
	public List<Ploeg> getPloegen();

	public void add(Ploeg ploeg);

}
