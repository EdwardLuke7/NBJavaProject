

public class DAOFactory {
	public CustomerOrderDAO getCODAO() {
		return this.getCODAO("mysql");
	}
	
	public PurchaseOrderDAO getPODAO() {
		return this.getPODAO("mysql");
	}
	
	public ProductDAO getPDAO() {
		return this.getPDAO("mysql");
	}

	public OrderLineDAO getOLDAO() {
		return this.getOLDAO("mysql");
	}
	
	public ProductDAO getPDAO(String databaseType) {
		if (databaseType == "mysql") {
			System.out.println("Products source: MySQL DB");
			return new JDBCProductDAO();
		}
		else if (databaseType == "file") {
			System.out.println("Products source: file");
			//TODO
			return null;
		}
		else {
			System.out.println("Product DAOFactory error.");
			return null;
		}
	}
	
	public PurchaseOrderDAO getPODAO(String databaseType) {
		if (databaseType == "mysql") {
			System.out.println("Purchase Orders source: MySQL DB");
			return new JDBCPurchaseOrderDAO();
		}
		else if (databaseType == "file") {
			System.out.println("Purchase Orders source: file");
			//TODO
			return null;
		}
		else {
			System.out.println("PurchaseOrder DAOFactory error.");
			return null;
		}
	}
	
	public CustomerOrderDAO getCODAO(String databaseType) {
		if (databaseType == "mysql") {
			System.out.println("Customer Orders source: MySQL DB");
			return new JDBCCustomerOrderDAO();
		}
		else if (databaseType == "file") {
			System.out.println("Customer Orders source: file");
			//TODO
			return null;
		}
		else {
			System.out.println("CustomerOrder DAOFactory error.");
			return null;
		}
	}
	
	public OrderLineDAO getOLDAO(String databaseType) {
		if (databaseType == "mysql") {
			System.out.println("Order Lines source: MySQL DB");
			return new JDBCOrderLineDAO();
		}
		else if (databaseType == "file") {
			System.out.println("Order Lines source: file");
			//TODO
			return null;
		}
		else {
			System.out.println("OrderLine DAOFactory error.");
			return null;
		}
	}
}