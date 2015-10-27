import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCustomerOrderDAO extends JDBCDAO implements CustomerOrderDAO {
	public void create(CustomerOrder order) {
		update("INSERT INTO customer_orders (status, checked_out) VALUES (" + order.getStatus() + ", " + order.getCheckout() + ")");
	}

	public void update(CustomerOrder order) {
		System.out.println("UPDATE customer_orders SET status=" + order.getStatus() + ",checked_out=" + order.getCheckout() + " WHERE (id=" + order.getID() + ")");
		update("UPDATE customer_orders SET status=" + order.getStatus() + ",checked_out=" + order.getCheckout() + " WHERE (id=" + order.getID() + ")");
	}
	
	public CustomerOrder fetch(int id) {
		ResultSet results = query("SELECT * FROM customer_orders WHERE id = " + id);
		CustomerOrder order = null;
				
		try {
			results.next();
			int status = results.getInt("status");
			boolean checkout = results.getBoolean("checked_out");
			order = new CustomerOrder(id, null, checkout, status);
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	public ArrayList<CustomerOrder> fetchAll() {
		ArrayList<CustomerOrder> orders = new ArrayList<CustomerOrder>();
		
		ResultSet results = query("SELECT * FROM customer_orders ORDER BY timestamp asc");
		
		try {
			while (results.next()) {
				int id = results.getInt("id");
				int status = results.getInt("status");
				boolean checkout = results.getBoolean("checked_out");
				CustomerOrder order = new CustomerOrder(id, null, checkout, status);
				System.out.println(order.getStatus());
				orders.add(order);
			}
		} 
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return orders;
	}
}
