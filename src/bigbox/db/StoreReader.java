package bigbox.db;
import java.util.ArrayList;

import bigbox.business.Store;

public interface StoreReader {

	public Store getStoreByDivisionAndStoreNumber();
	
	public ArrayList<Store> getAllStores();
	
	public Store getAllStoresByDivision();
	
	public ArrayList<Store> listStores();
}
