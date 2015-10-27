import java.util.ArrayList;

public class DummyProductDAO implements ProductDAO {
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Float> location = new ArrayList<Float>();
	
	public DummyProductDAO() {
		location.set(0, (float)0.0);
		location.set(1, (float)0.0);
		products.add(new Product(1, "Dummy1", 10, false, location));
		products.add(new Product(2, "Dummy2", 20, true, location));
		products.add(new Product(3, "Dummy3", 30, true, location));
		products.add(new Product(4, "Dummy4", 40, false, location));
		products.add(new Product(5, "Dummy5", 50, false, location));
	}
	
	public Product fetch(int id) {
		return products.get(id);
	}
	
	public ArrayList<Product> fetchAll() {
		return products;
	}
}
