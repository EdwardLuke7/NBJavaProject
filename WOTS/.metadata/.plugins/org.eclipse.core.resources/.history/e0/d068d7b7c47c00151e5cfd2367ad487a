import java.util.ArrayList;

public class PurchaseOrder extends Order {
	private enum Status { PENDING, DELIVERED, COMPLETE };
	private Status status = Status.PENDING;
	
	public PurchaseOrder(int ID, ArrayList<OrderLine> orderLines, boolean checkout, int status) {
		super(ID, orderLines, checkout);
		this.DBTable = "purchase_order";
		this.setStatus(status);
	}
	
	public String toString() {
		String shortStatus = String.valueOf(status);
		if (shortStatus.length() > 7) {
			shortStatus = shortStatus.substring(0,7);
		}
		return String.valueOf(ID) + "\t" + shortStatus + "\t" + String.valueOf(checkout); 
	}
	
	public int getStatus() {
		return status.ordinal();
	}
	
	public String getStatusString() {
		return String.valueOf(status);
	}
	
	public void setStatus (int status) {
		switch (status) {
			case 0:
				this.status = Status.PENDING;
				break;
			case 1:
				this.status = Status.DELIVERED;
				break;
			case 2:
				this.status = Status.COMPLETE;
				break;
			default:
				this.status = Status.PENDING;
		}
	}
}
