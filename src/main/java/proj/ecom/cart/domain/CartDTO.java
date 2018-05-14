package proj.ecom.cart.domain;

import proj.ecom.product.domain.ProductDTO;

public class CartDTO extends ProductDTO{
	private static final long serialVersionUID = 1L;
	private String cart_id;
	private String cart_userId;
	private int cart_Status;
	
	
	public CartDTO() {
		super();
	}
	
	public CartDTO(String cart_id, String cart_userId, int cart_Status) {
		super();
		this.cart_id = cart_id;
		this.cart_userId = cart_userId;
		this.cart_Status = cart_Status;
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
