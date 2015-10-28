import java.util.ArrayList;

public class Product {
	private final int id;
	private String name;
	private int stock;
	private boolean porouswear;
	private ArrayList<Float> location = new ArrayList<Float>(2);
	
	public Product(int id, String name, int stock, boolean porouswear, ArrayList<Float> location) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.porouswear = porouswear;
		this.location = location;
	}
	
	public String toString() {
		String str = id + " " + name + " " + stock + " " + porouswear + " " + location;
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Float> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<Float> location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}
	
	public boolean getPorouswear() {
		return porouswear;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void addStock(int num) {
		this.stock += num;
	}
	
	public void removeStock (int num) {
		this.stock -= num;
	}
}
