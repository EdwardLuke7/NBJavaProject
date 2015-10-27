import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCOrderLineDAO extends JDBCDAO implements OrderLineDAO {
	public ArrayList<OrderLine> fetchAll(CustomerOrder order) {
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
		
		ResultSet results = query("SELECT * FROM nbg.customer_order_lines WHERE customer_order_id = " + order.getId());
		
		try {
			while (results.next()) {
				int productID = results.getInt("product_id");
				int quantity = results.getInt("quantity");
				
				OrderLine line = new OrderLine(productID, quantity);
				
				orderLines.add(line);
			}
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderLines;
	}
}
