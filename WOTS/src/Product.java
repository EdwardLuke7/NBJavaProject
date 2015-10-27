public class Product {
	private final int ID;
	private String name;
	private int stock;
	private boolean porouswear;
	private float[] location = new float[2];
	
	public Product(int ID, String name, int stock, boolean porouswear, float[] location) {
		this.ID = ID;
		this.name = name;
		this.stock = stock;
		this.porouswear = porouswear;
		this.location = location;
	}
	
	public String toString() {
		String shortName = new String();
		if (name.length() > 7) {
			shortName = name.substring(0, 7);
		}
		String str = ID + "\t" + shortName + "\t" + stock + "\t" + porouswear + "\t" + location[0] + "," + location[1];
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float[] getLocation() {
		return location;
	}

	public void setLocation(float[] location) {
		this.location = location;
	}

	public int getID() {
		return ID;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void addStock(int num) {
		this.stock += num;
	}
	
	public void removeStock (int num) {
		this.stock -= num;
	}
	
	public boolean getPorous() {
		return porouswear;
	}
}
