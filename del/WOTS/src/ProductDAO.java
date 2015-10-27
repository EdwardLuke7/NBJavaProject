
import java.util.ArrayList;

public interface ProductDAO {
	public Product fetch(int id);
	public ArrayList<Product> fetchAll();
}