package proj.ecom.cart.domain;

import proj.ecom.product.domain.ProductDTO;

public class CartDTO extends ProductDTO{
	private static final long serialVersionUID = 1L;
	private String cart_id;
	private String cart_userId;
	private int cart_Status;
	private int cart_product_quantity;
	private int cart_product_id;
	private String cart_product_size;

	public CartDTO() {
		super();
	}

	public CartDTO(String cart_id, String cart_userId, int cart_Status, int cart_product_quantity, int cart_product_id,
			String cart_product_size) {
		super();
		this.cart_id = cart_id;
		this.cart_userId = cart_userId;
		this.cart_Status = cart_Status;
		this.cart_product_quantity = cart_product_quantity;
		this.cart_product_id = cart_product_id;
		this.cart_product_size = cart_product_size;
	}

	

	public int getCart_product_id() {
		return cart_product_id;
	}

	public void setCart_product_id(int cart_product_id) {
		this.cart_product_id = cart_product_id;
	}

	public int getCart_product_quantity() {
		return cart_product_quantity;
	}
	public void setCart_product_quantity(int cart_product_quantity) {
		this.cart_product_quantity = cart_product_quantity;
	}
	public String getCart_product_size() {
		return cart_product_size;
	}

	public void setCart_product_size(String cart_product_size) {
		this.cart_product_size = cart_product_size;
	}

	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_userId() {
		return cart_userId;
	}
	public void setCart_userId(String cart_userId) {
		this.cart_userId = cart_userId;
	}
	public int getCart_Status() {
		return cart_Status;
	}
	public void setCart_Status(int cart_Status) {
		this.cart_Status = cart_Status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
