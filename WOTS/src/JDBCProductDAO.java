import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCProductDAO extends JDBCDAO implements ProductDAO {
	public Product fetch(int id) {
		ResultSet result = query("SELECT * FROM products WHERE id="+id);
		
		String productName = "";
		int stock = 0;
		boolean pourous = false;
		ArrayList<Float> location = new ArrayList<Float>(2);
		
		try {
			result.next();
			productName = result.getString("name");
			stock = result.getInt("stock");
			pourous = result.getBoolean("porouswear");
			float locX = result.getFloat("loc_x");
			float locY = result.getFloat("loc_y");
			location.add(0, locX);
			location.add(1, locY);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Product product = new Product(id, productName, stock, pourous, location);
		
		return product;
	}
	
	public ArrayList<Product> fetchAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		ResultSet result = query("SELECT * FROM products");
		
		try {
			while (result.next()) {
				int id = result.getInt("id");
				String productName = result.getString("name");
				int stock = result.getInt("stock");
				boolean pourous = result.getBoolean("porouswear");
				float locX = result.getFloat("loc_x");
				float locY = result.getFloat("loc_y");
				ArrayList<Float> location = new ArrayList<Float>(2);
				location.add(0, locX);
				location.add(1, locY);
				
				Product product = new Product(id, productName, stock, pourous, location);
				products.add(product);
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
		
	}
}
