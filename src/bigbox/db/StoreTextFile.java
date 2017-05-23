package bigbox.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import bigbox.business.Store;
import bigbox.util.Validator;

public class StoreTextFile implements StoreDAO{
	
	//class variables
	private ArrayList<Store> stores = null;
	private Path storesPath = null;
	private File storesFile = null;
	
	private final String FIELD_SEP = "\t";
	
	Scanner sc = new Scanner(System.in);
	
	//constructor
	public StoreTextFile()
	{
		storesPath = Paths.get("stores.txt");
		storesFile = storesPath.toFile();
		stores = getAllStores();
	}
	@Override
	public ArrayList<Store> getAllStores()
	{
		if (stores!=null)
		return stores;
		
		stores = new ArrayList<>();
		
		if (Files.exists(storesPath))
		{
			try (BufferedReader in = new BufferedReader(
										new FileReader(storesFile)))
			{
				String line = in.readLine();
					while (line != null)
					{
						String[] columns = line.split(FIELD_SEP);
						String id = columns[0];
						String name = columns[1];
						String address = columns[2];
						String city = columns[3];
						String state = columns[4];
						String zip = columns[5];
						String divNo = columns[6];
						String strNo = columns[7];
						String sales = columns[8];
						Store s = new Store(Integer.parseInt(id), name, address, city, state, zip, divNo, strNo, sales);
						stores.add(s);
						
						line = in.readLine();
					}
			}
			catch (IOException e)
			{
				System.out.println(e);
				return null;
			}
		}
		return stores;
	}
	private boolean saveStores()
	{
		try (PrintWriter out = new PrintWriter(
								new BufferedWriter(
										new FileWriter(storesFile))))
		{
			for (Store s:stores)
			{
				out.print(s.getId() + FIELD_SEP);
				out.print(s.getName() + FIELD_SEP);
				out.print(s.getAddress() + FIELD_SEP);
				out.print(s.getCity() + FIELD_SEP);
				out.print(s.getState() + FIELD_SEP);
				out.print(s.getZip() + FIELD_SEP);
				out.print(s.getDivNo() + FIELD_SEP);
				out.print(s.getStrNo() + FIELD_SEP);
				out.println(s.getSales());
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	public static String displayMenuAndPrompt(Scanner sc,String prompt)
	{
		Validator.displayMenu();
		String operation = Validator.getString(sc, "Enter a command:  ");
		return operation;
	}
	@Override
	public void addStore() {
		int id = Validator.getInt(sc, "Enter id number:  ");
		String name = Validator.getString(sc, "Enter store name:  ");
		String address = Validator.getString(sc, "Enter store address:  ");
		String city = Validator.getString(sc, "Enter store city:  ");
		String state = Validator.getString(sc, "Enter store state:  ");
		String zip = Validator.getString(sc, "Enter store zip:  ");
		String divNo = Validator.getStringNumeric(sc, "Enter division number:  ", 3);
		String strNo = Validator.getStringNumeric(sc, "Enter store number:  ", 5);
		String sales = Validator.getString(sc, "Enter sales:  ");
		stores.add(new Store(id, name, address, city, state, zip, divNo, strNo, sales));
		saveStores();
	}
	@Override
	public  ArrayList<Store> listStores() 
	{
		for (int i = 0; i<stores.size(); i++)
		{
			System.out.println(stores.get(i));
		}
		return stores;
	}
	@Override
	public boolean deleteStore(Store dStore) {

		stores.remove(dStore);
		
		return saveStores();
	}
	@Override
	public Store getAllStoresByDivision() {
		
		String divNo = Validator.getStringNumeric(sc, "Enter division number:  ", 3);
		Store store = null;	
			
		for (Store s: stores)
			{
				if (s.getDivNo().equals(divNo))
				{
					store = s;
					System.out.println(store);
				}
			}
			return store;
	}
	@Override
	public Store getStoreByDivisionAndStoreNumber() 
	{
		Store store = null;
		String divNo = Validator.getStringNumeric(sc, "Enter division number:  ", 3);
		String strNo = Validator.getStringNumeric(sc, "Enter store number:  ", 5);
		//sgetAllStores();
		for (Store s: stores)
		{
			if ((s.getDivNo().equals(divNo) && (s.getStrNo().equals(strNo))))
			{	store = s;
				System.out.println(store);
			}
			
			
		}
	return store;
	}
}
