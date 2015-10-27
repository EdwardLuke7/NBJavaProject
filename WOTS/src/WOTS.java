import java.util.ArrayList;
import java.util.Scanner;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;

public class WOTS {

	public static void main(String[] args) {
		DAOFactory DAOFactory = new DAOFactory();
		//CustomerOrderDAO cODAO = DAOFactory.getCustomerOrderDAO("mysql"); 
		//OrderLineDAO oLDAO = DAOFactory.getOrderLineDAO("mysql");
		//ProductDAO pDAO = DAOFactory.getProductDAO("mysql");
		
		Scanner input = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			mainMenu();
			
			switch(input.nextInt()) {
			case 1:
				printCustomerOrders(DAOFactory);
				System.out.println("1. View Customer Order");
				System.out.println("2. Exit to Main Menu");
				
				switch(input.nextInt()) {
				case 1: 
					System.out.println("Enter Customer Order ID:");
					int id = input.nextInt();
					printCustomerOrder(DAOFactory, id);
					break;
				default:
					break;
				}
				break;
			case 2:
				System.out.println("Enter the order ID:");
				checkoutCustomerOrder(DAOFactory, input.nextInt());
				break;
			case 3:
				System.out.println("Enter the order ID:");
				int id = input.nextInt();
				System.out.println("1. Pending\n2. Picked\n3. Packed\n4. Dispatched\nEnter the new status: ");
				customerOrderStatus(DAOFactory, id, input.nextInt());
				break;
			case 8:
				System.out.println("--Inventory--");
				printInventory(DAOFactory);
				break;
			case 9:
				run = false;
				System.out.println("Goodbye.");
				break;
			default:
				break;
			}
		}
	}
	
	public static void mainMenu() {
		System.out.println("\n--Main Menu--");
		System.out.println("1. List Customer Orders");
		System.out.println("2. Checkout Customer Order");
		System.out.println("3. Update Customer Order status");
		System.out.println("-------------");
		System.out.println("4. Create Purchase Order");
		System.out.println("5. View Purchase Orders");
		System.out.println("6. Checkout Customer Order");
		System.out.println("7. Update Purchase Orders status");
		System.out.println("-------------");
		System.out.println("8. List Inventory");
		System.out.println("9. Quit");
		System.out.println("Select an option:");
	}
	
	public static void printCustomerOrders(DAOFactory DAO) {
		ArrayList<CustomerOrder> orders = DAO.getCustomerOrderDAO().fetchAll();
		IASCIITableAware asciiTableAware = new CollectionASCIITableAware<CustomerOrder>(orders, "id", "checkout", "status"); 
        ASCIITable.getInstance().printTable(asciiTableAware);
	}
	
	public static void printCustomerOrder(DAOFactory DAO, int id) {
		CustomerOrder order = DAO.getCustomerOrderDAO().fetch(id);
		ArrayList<OrderLine> lines = DAO.getOrderLineDAO().fetchAll(order);
		if (lines.size() > 0) {
			IASCIITableAware asciiTableAware = new CollectionASCIITableAware<OrderLine>(lines, "id", "quantity"); 
	        ASCIITable.getInstance().printTable(asciiTableAware);
		}
		else {
			System.out.println("No order lines!");
		}
		System.out.println("ID: " + order.getId() + ", Status: " + order.getStatus() + ", Checked Out: " + order.getCheckout());
	}
	
	public static void printInventory(DAOFactory DAO) {
		ArrayList<Product> products = DAO.getProductDAO().fetchAll();
		if (products.size() > 0) {
			IASCIITableAware asciiTableAware = new CollectionASCIITableAware<Product>(products, "id", "name", "stock", "porouswear"); 
	        ASCIITable.getInstance().printTable(asciiTableAware);
		}
		else {
			System.out.println("No products in inventory.");
		}
	}
	
	public static void checkoutCustomerOrder(DAOFactory DAO, int id) {
		CustomerOrder order = DAO.getCustomerOrderDAO().fetch(id);
		order.checkoutToggle();
		DAO.getCustomerOrderDAO().update(order);
	}
	
	public static void customerOrderStatus(DAOFactory DAO, int id, int status) {
		CustomerOrder order = DAO.getCustomerOrderDAO().fetch(id);
		order.setStatus(status);
		DAO.getCustomerOrderDAO().update(order);
	}
}
/*
public class WOTS {
	public static void main(String[] args) {		
		//ResultSet results = JDBCDatabaseManager.query("SELECT * FROM customer_orders");
		//JDBCDatabaseManager.update("INSERT INTO customer_orders (status, checked_out) VALUES (1, 1)");
		Scanner input = new Scanner(System.in);
		System.out.println("Warehouse Operations Tracking System");
		System.out.println("Initialising...");
		
		DAOFactory DAOFactory = new DAOFactory();
		CustomerOrderDAO cODAO = DAOFactory.getCustomerOrderDAO("mysql"); 
		OrderLineDAO oLDAO = DAOFactory.getOrderLineDAO("mysql");
		ProductDAO pDAO = DAOFactory.getProductDAO("dummy");
		
		boolean run = true;
		
		while (run) {
			System.out.println("\n--Main Menu--");
			System.out.println("1. Customer Orders");
			System.out.println("2. Purchase Orders");
			System.out.println("3. Inventory");
			System.out.println("4. Quit");
			System.out.println("Select an option:");
			
			switch (input.next().charAt(0)) {
				case '1':
					ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
					customerOrders = cODAO.fetchAll();
					
					System.out.println("\n--Customer Orders--");
					System.out.println("ID\tSTATUS\tCHECKOUT");
					
					for (CustomerOrder order : customerOrders) {
						System.out.println(order);
					}
					
					System.out.println("Choose an order: ");
					int orderNum = input.nextInt();
					
					CustomerOrder currentOrder = cODAO.fetch(orderNum);
					
					currentOrder.setOrderLines(oLDAO.fetchAll(currentOrder));
					//System.out.println(currentOrder.getOrderLines());
					
					ArrayList<OrderLine> orderLines = currentOrder.getOrderLines();
					
					System.out.println("\n--Order " + currentOrder.getID() + "--\n" + "Status: " + currentOrder.getStatusString() + "\nChecked Out: " + currentOrder.getCheckout() + "\n\nPRODUCT\tQUANTITY");
					for (OrderLine line : orderLines) {
						System.out.println(line);
					}
					System.out.println("-----------");
					
					System.out.println("Select an option:");
					System.out.println("1. Checkout/return");
					System.out.println("2. Update status");
					System.out.println("3. Return to Main Menu");
					switch (input.next().charAt(0)) {
						case '1':
							currentOrder.checkoutToggle();
							cODAO.update(currentOrder);
							break;
						case '2':
							System.out.println("\n--Update Status--\nSelect an option:");
							System.out.println("1. PENDING");
							System.out.println("2. PICKED");
							System.out.println("3. PACKED");
							System.out.println("4. DISPATCHED");
							System.out.println("5. Return to Main Menu");
							
							int status = input.nextInt() - 1;
							if (status > 0 && status < 6) {
								currentOrder.setStatus(status);
								cODAO.update(currentOrder);
							}
							else {
								System.out.println("Invalid status!");
							}
							break;
						default:
							break;
					}
					
					break;
				case '2':
					System.out.println("Puchase Orders mode coming Soon");
					break;
				case '3':
					System.out.println("--Inventory--");
					System.out.println("ID\tNAME\tSTOCK\tPOROUS\tLOCATION");
					
					ArrayList<Product> products = pDAO.fetchAll();
					
					for (Product product : products) {
						System.out.println(product.getID() + "\t" + product.getName() + "\t" + product.getStock() + "\t" + product.getPorouswear() + "\t" + product.getLocation()[0] + "," + product.getLocation()[1]);
					}
					
					break;
				default:
					run = false;
					System.out.println("Exiting...");
					break;
			}
		}
		
		System.exit(0);
		
	}
} */