import java.util.ArrayList;

public interface PurchaseOrderDAO {
	public void create(PurchaseOrder order);
	public void update(PurchaseOrder order);
	public PurchaseOrder fetch(int id);
	public ArrayList<PurchaseOrder> fetchAll();
}
