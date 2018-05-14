package proj.ecom.cart.domain;

import proj.ecom.product.domain.ProductDTO;

public class CartDTO {
	private String cart_id;
	private String cart_userId;
	private int cart_Status;
	private ProductDTO product_dto;
	
	
	public CartDTO() {
		super();
	}
	
	
	public CartDTO(String cart_id, String cart_userId, int cart_Status, ProductDTO product_dto) {
		super();
		this.cart_id = cart_id;
		this.cart_userId = cart_userId;
		this.cart_Status = cart_Status;
		this.product_dto = product_dto;
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
	public ProductDTO getProduct_dto() {
		return product_dto;
	}
	public void setProduct_dto(ProductDTO product_dto) {
		this.product_dto = product_dto;
	}
	
	
}
