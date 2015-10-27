import java.util.ArrayList;
import java.util.Scanner;

public class WOTS {
	public static void main(String[] args) {		
		//ResultSet results = JDBCDatabaseManager.query("SELECT * FROM customer_orders");
		//JDBCDatabaseManager.update("INSERT INTO customer_orders (status, checked_out) VALUES (1, 1)");
		Scanner input = new Scanner(System.in);
		System.out.println("Warehouse Operations Tracking System");
		System.out.println("Initialising...");
		
		DAOFactory DAOFactory = new DAOFactory();
		CustomerOrderDAO cODAO = DAOFactory.getCODAO("mysql");
		PurchaseOrderDAO pODAO = DAOFactory.getPODAO("mysql");
		OrderLineDAO oLDAO = DAOFactory.getOLDAO("mysql");
		ProductDAO pDAO = DAOFactory.getPDAO("mysql");
		
		boolean run = true;
		
		while (run) {
			System.out.println("\n--Main Menu--\nSelect an option:");
			System.out.println("1. Customer Orders");
			System.out.println("2. Purchase Orders");
			System.out.println("3. Inventory");
			System.out.println("4. Quit");
			
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
					
					System.out.println("\n--Order " + currentOrder.getID() + "--\n" + "Status: " + currentOrder.getStatusString() + "\nChecked Out: " + currentOrder.getCheckout() + "\n\nQUANT.\tID\tNAME\tPOROUS");
					for (OrderLine line : orderLines) {
						Product product = pDAO.fetch(line.getProductID());
						System.out.print(line.getQuantity() + "\t" + product.getID() + "\t" + product.getName() + "\t" + product.getPorous() + "\n");
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
							
							String checkoutString = "checked IN";
							if (currentOrder.getCheckout()) {
								 checkoutString = "checked OUT";
							}

							System.out.println("Order " + currentOrder.getID() + " is now " + checkoutString + ".");
							
							break;
						case '2':
							System.out.println("\n--Update Status--\nSelect an option:");
							System.out.println("1. PENDING");
							System.out.println("2. PICKED");
							System.out.println("3. PACKED");
							System.out.println("4. DISPATCHED");
							System.out.println("5. Return to Main Menu");
							
							int status = input.nextInt();
							if (status == 5) {
								break;
							}
							else if (status > 0 && status < 6) {
								currentOrder.setStatus(status - 1);
								cODAO.update(currentOrder);
							}
							else {
								System.out.println("Invalid status!");
							}
							
							System.out.println("Order " + currentOrder.getID() + " status: " + currentOrder.getStatusString());
							break;
						default:
							break;
					}
					
					break;
				case '2':
					ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
					purchaseOrders = pODAO.fetchAll();
					
					System.out.println("\n--Purchase Orders--");
					System.out.println("ID\tSTATUS\tCHECKOUT");
					
					for (PurchaseOrder order : purchaseOrders) {
						System.out.println(order);
					}
					break;
				case '3':
					ArrayList<Product> inventory = pDAO.fetchAll();
					
					System.out.println("\n--Inventory--");
					System.out.println("ID\tNAME\tSTOCK\tPOROUS\tLOCATION");
					for (Product product : inventory) {
						System.out.println(product);
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
}