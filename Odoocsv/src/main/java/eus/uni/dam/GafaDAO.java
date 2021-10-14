package eus.uni.dam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public interface GafaDAO {

	
	public Collection<Gafa> getGafas();

	public void init() throws IOException, ClassNotFoundException, SQLException;

	public Collection<Gafa> findAll();

	public void insert(Gafa gafa);

	public void edit(Gafa gafa);

	public void delete(String id);
	
}
