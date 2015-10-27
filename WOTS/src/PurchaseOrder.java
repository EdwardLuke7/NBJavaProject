import java.util.ArrayList;

public class PurchaseOrder extends Order {
	private enum Status { PENDING, DELIVERED, COMPLETE };
	private Status status = Status.PENDING;
	
	public PurchaseOrder(int id, ArrayList<OrderLine> orderLines, boolean checkout, Status status) {
		super(id, orderLines, checkout);
		this.status = status;
		this.DBTable = "purchase_order";
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus (Status status) {
		this.status = status;
	}
}
