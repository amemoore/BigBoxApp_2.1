package bigbox.business;

public class Store extends Facility{
	
	private String strNo;
	private String divNo;
	private String sales;
	
	
	public Store(int idIn, String nameIn, String addressIn, String cityIn, String stateIn, String zipIn, 
			String divNoIn, String strNoIn, String salesIn)
	{
		super (idIn, nameIn, addressIn, cityIn, stateIn, zipIn);
		strNo = strNoIn;
		divNo = divNoIn;
		sales = salesIn;
	}
	
	public String getStrNo() {
		return strNo;
	}
	public void setStrNo(String strIn) {
		strNo = strIn;
	}
	public String getDivNo() {
		return divNo;
	}
	public void setDivNo(String divNoIn) {
		divNo = divNoIn;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String salesIn) {
		sales = salesIn;
	}
	@Override
	public String toString(){
		
		return "[STORE-- Div No: " + divNo + ", Store No.: " + strNo + ", Sales: " + sales + "]\n" 
				+ super.toString() + "\n";
	}
}
