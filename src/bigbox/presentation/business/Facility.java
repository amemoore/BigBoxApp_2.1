package bigbox.business;

public class Facility 
{
	 private int id;
	 private String name;
	 private String address;
	 private String city;
	 private String state;
	 private String zip;
	
	public Facility(int idIn, String nameIn, String addressIn, String cityIn, String stateIn, String zipIn)
	{ 
		id = idIn;
		name = nameIn;
		address = addressIn;
		city = cityIn;
		state = stateIn;
		zip = zipIn;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int idIn) {
		id = idIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameIn) {
		name = nameIn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addressIn) {
		address = addressIn;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String cityIn) {
		city = cityIn;
	}

	public String getState() {
		return state;
	}

	public void setState(String stateIn) {
		state = stateIn;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zipIn) {
		zip = zipIn;
	}
	@Override
    public String toString()
    {
        return "[FACILITY-- Id: " + id +  ", Name: " + name + ", Address: " + address + 
        		", City: " + city + ", State: " + state + ", Zip: " + zip + "]";
    }
}
