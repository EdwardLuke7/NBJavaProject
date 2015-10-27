import java.util.ArrayList;

public abstract class Order {
	protected final int ID;
	protected ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
	protected boolean checkout = false;
	public String DBTable = new String();
	protected enum Status { PENDING, COMPLETE };
	protected Status status = Status.PENDING;
	
	public Order(int ID, ArrayList<OrderLine> orderLines, boolean checkout) {
		this.ID = ID;
		this.orderLines = orderLines;
		this.checkout = checkout;
	}
	
	public void setStatus (int status) {
		switch (status) {
			case 0:
				this.status = Status.PENDING;
				break;
			case 1:
				this.status = Status.COMPLETE;
				break;
			default:
				this.status = Status.PENDING;
		}
	}
	
	public int length() {
		int num = orderLines.size();
		return num;
	}
	
	public int getID() {
		return ID;
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
