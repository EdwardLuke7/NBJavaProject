
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCProductDAO extends JDBCDAO implements ProductDAO {
	public Product fetch(int id) {
		ResultSet result = query("SELECT * FROM products WHERE id="+id);
		
		String productName = "";
		int stock = 0;
		boolean pourous = false;
		float[] location = {0,0};
		
		try {
			result.next();
			productName = result.getString("name");
			stock = result.getInt("stock");
			pourous = result.getBoolean("porouswear");
			float locX = result.getFloat("loc_x");
			float locY = result.getFloat("loc_y");
			location[0] = locX;
			location[1] = locY;
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
		
		ResultSet results = query("SELECT * FROM products");

		try {
			while (results.next()) {
				float[] location = new float[2];
				location[0] = results.getFloat("loc_x");
				location[1] = results.getFloat("loc_y");
				Product product = new Product(results.getInt("id"), results.getString("name"), results.getInt("stock"), results.getBoolean("porouswear"), location);
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
