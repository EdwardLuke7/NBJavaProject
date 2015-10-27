public class OrderLine {
	private int productID;
	private int quantity;
	
	public OrderLine(int productID, int quantity) {
		this.productID = productID;
		this.quantity = quantity;
	}
	
	public String toString() {
		return String.valueOf(productID) + "\t" + String.valueOf(quantity);
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
