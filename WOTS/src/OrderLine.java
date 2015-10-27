public class OrderLine {
	private int productId;
	private String productName;
	// ADD OTHERS?
	private int quantity;
	
	public OrderLine(int productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public String toString() {
		return String.valueOf(productId) + "\t" + String.valueOf(quantity);
	}

	public int getProductId() {
		return productId;
	}
	
	public int getId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
