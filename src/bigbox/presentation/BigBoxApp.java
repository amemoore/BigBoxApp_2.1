package bigbox.presentation;

import java.util.Scanner;
import bigbox.business.Store;
import bigbox.db.DAOFactory;
import bigbox.db.StoreTextFile;
import bigbox.db.StoreDAO;

public class BigBoxApp {
	
	private static StoreDAO storeDAO = null;
	
	public static void main(String[] args)
	{
		//Welcome message
		System.out.println("Welcome to the Big Box App - Iteration #2 using StoreTextFile");
		System.out.println();
		
		storeDAO = DAOFactory.getStoreDAO();
		Scanner sc = new Scanner(System.in);
		String operation = "";
		boolean isValid = false;

		//Loop through each of the menu items (list,division, add, delete, help, exit
		while (isValid == false)
		{
			operation = StoreTextFile.displayMenuAndPrompt(sc,"Enter a command:  ");

			if (operation.equalsIgnoreCase("list"))
			{
				storeDAO.listStores();
			}
			else if (operation.equalsIgnoreCase("div") || operation.equalsIgnoreCase("division"))
			{	
				storeDAO.getAllStoresByDivision();
			}	
			else if (operation.equalsIgnoreCase("add"))
			{
				storeDAO.addStore();
			}
			else if (operation.equalsIgnoreCase("del"))
			{
				Store dStore = storeDAO.getStoreByDivisionAndStoreNumber();
				
				storeDAO.deleteStore(dStore);
			}
			else if (operation.equalsIgnoreCase("help"))
			{
				operation = StoreTextFile.displayMenuAndPrompt(sc,"Enter a command:  ");
			}
			else if (operation.equalsIgnoreCase("exit"))
			{
				
				isValid = true;
				return;
			}
		}
		sc.close();
	}
}
