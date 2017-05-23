package bigbox.db;
import bigbox.business.Store;

public interface StoreWriter {
	
	public void addStore();
	
	public boolean deleteStore(Store inStore);
	
}
