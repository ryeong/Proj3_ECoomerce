package proj.ecom.product.domain;

import java.io.Serializable;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int product_id;
	private int product_itemType;
	private int product_sortType;
	private String product_name;
	private String product_image;
	private int product_price;
	private int product_quantity;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int product_id, int product_itemType, int product_sortType, String product_name,
			String product_image, int product_price, int product_quantity) {
		super();
		this.product_id = product_id;
		this.product_itemType = product_itemType;
		this.product_sortType = product_sortType;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
	}





	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	
	public int getProduct_itemType() {
		return product_itemType;
	}


	public void setProduct_itemType(int product_itemType) {
		this.product_itemType = product_itemType;
	}




	public int getProduct_sortType() {
		return product_sortType;
	}


	public void setProduct_sortType(int product_sortType) {
		this.product_sortType = product_sortType;
	}




	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + product_id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (product_id != other.product_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_itemType=" + product_itemType + ", product_sortType="
				+ product_sortType + ", product_name=" + product_name + ", product_image=" + product_image
				+ ", product_price=" + product_price + ", product_quantity=" + product_quantity + "]";
	}



	
	
	
}

