package voetbal.dao;

import java.util.List;
import voetbal.Team;

public interface TeamDAO {
	
	public List<Team> getTeams();

	public void add(Team team);

}
