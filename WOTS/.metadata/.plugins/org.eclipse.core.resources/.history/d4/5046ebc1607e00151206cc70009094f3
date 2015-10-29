import java.util.ArrayList;

public abstract class Order {
	protected final int id;
	protected ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	protected boolean checkout = false;
	public String DBTable = null;
	
	public Order(int id, ArrayList<OrderLine> orderLines, boolean checkout) {
		this.id = id;
		this.orderLines = orderLines;
		this.checkout = checkout;
	}
	
	public int length() {
		int num = orderLines.size();
		return num;
	}
	
	public String toString() {
		return String.valueOf(id);
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getCheckout() {
		return checkout;
	}
	
	public void checkoutToggle() {
		if (checkout)
			checkout = false;
		else
			checkout = true;		
	}
	
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void sortLinesByLocation() {
		//TODO Implement nearest-neighbour to order the list in picking order
	}
	
}
