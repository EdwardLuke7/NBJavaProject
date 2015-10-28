import java.util.ArrayList;

public class CustomerOrder extends Order {
	private enum Status { PENDING, PICKED, PACKED, DISPATCHED };
	private Status status = Status.PENDING;
		
	public CustomerOrder(int id, ArrayList<OrderLine> orderLines, boolean checkout, int status) {
		super(id, orderLines, checkout);
		this.setStatus(status);
		this.DBTable = "customer_order";
	}
	
	public String toString() {
		return String.valueOf(id) + "\t" + status + "\t" + String.valueOf(checkout); 
	}
	
	public int getStatusInt() {
		return status.ordinal();
	}
	
	public String getStatus() {
		return String.valueOf(status);
	}
	
	public void setStatus(int status) {
		switch (status) {
			case 0:
				this.status = Status.PENDING;
				break;
			case 1:
				this.status = Status.PICKED;
				break;
			case 2:
				this.status = Status.PACKED;
				break;
			case 3:
				this.status = Status.DISPATCHED;
				break;
			default:
				this.status = Status.PENDING;
		}
	}
}
