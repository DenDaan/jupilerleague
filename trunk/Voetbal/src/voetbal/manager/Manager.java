package voetbal.manager;

import java.util.List;

public interface Manager<T> {

	public List<T> getAll();
	
	public void add(T t);
	
	public void set(List<T> Ts);
	
	public void remove(T t);
	
}
