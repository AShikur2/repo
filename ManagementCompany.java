/**
 * A management company class
 * @author Elizabeth Perez
 *
 */
public class ManagementCompany {
	private String name;
	private String taxID;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private Property[] properties;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int counter;
	
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFeePer = 0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		counter = 0;
	}
	
	public ManagementCompany(String companyName, String id, double fee) {
		name = companyName;
		taxID = id;
		mgmFeePer = fee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		counter = 0;
	}
	
	public ManagementCompany(String companyName, String id, double fee, int x, int y, int width, int depth) {
		name = companyName;
		taxID = id;
		mgmFeePer = fee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
		counter = 0;
	}
	
	public ManagementCompany(ManagementCompany company) {
		name = company.name;
		taxID = company.taxID;
		mgmFeePer = company.mgmFeePer;
		plot = company.plot;
		properties = company.properties;
		counter = company.counter;
	}
	
	public String toString() {
		String mes;
		mes = "List of properties for " + name + ", taxID: " + taxID + "\n_____________________________________\n";
		for(int i = 0; i < counter; i++){
			mes += properties[i].toString();
			mes += "\n";
		}
		double totalMNGMFee = (totalRent()*mgmFeePer)/100;
		mes += "_____________________________________\n";
		mes += "Total Management Fee: " + totalMNGMFee;
		
		return mes;
	}
	
	public int addProperty(Property property) {
		if(counter == MAX_PROPERTY) {
			return -1;
		}
		
		if(property == null) {
			return -2;
		}
		
		if(!plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i < counter; i++) {
			if(property.getPlot().overlaps(properties[i].getPlot())) {
				return -4;
			}
		}
		
		Property prop = new Property(property);
		
		properties[counter] = prop;
		counter++;
		
		return counter-1;
		
	}
	
	public int addProperty(String propertyName, String city, double rent, String ownerName) {
		if(counter == MAX_PROPERTY) {
			return -1;
		}
		
		Property prop = new Property(propertyName, city, rent, ownerName);
		properties[counter] = prop;
		counter++;
		System.out.println(counter);
		return counter-1;
	}
	
	public int addProperty(String propertyName, String city, double rent, String ownerName, int x, int y, int width, int depth) {
		Property p = new Property(propertyName, city, rent, ownerName, x, y, width, depth);
		
		if(counter == MAX_PROPERTY) {
			return -1;
		}
	
		if(!plot.encompasses(p.getPlot())) {
			return -3;
		}
		
		for(int i = 0; i < counter; i++) {
			if(properties[i].getPlot().overlaps(p.getPlot())) {
				return -4;
			}
		}
		properties[counter] = p;
		counter++;
		return counter-1;
	}
	
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public double maxRentProp() {
		double max = properties[maxRentPropertyIndex()].getRentAmount();
		return max;
	}
	
	public int maxRentPropertyIndex() {
		int index = 0;
		double highest = properties[0].getRentAmount();
		
		for(int i = 1; i < counter; i++) {
			if(properties[i].getRentAmount() > highest) {
				highest = properties[i].getRentAmount();
				index = i;
			}
		}
		
		return index;
	}
	
	public double totalRent() {
		double total = 0;
		
		for(int i = 0; i < counter; i++) {
			total += properties[i].getRentAmount();
		}
		
		return total;
	}
	public Plot getPlot() {
		return plot;
	}
	public String getName() {
		return name;
	}
	
}