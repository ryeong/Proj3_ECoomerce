package proj.ecom.product.domain;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int product_id;
	private String product_type;
	private String product_name;
	private int product_price;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(int product_id, String product_type, String product_name, int product_price) {
		super();
		this.product_id = product_id;
		this.product_type = product_type;
		this.product_name = product_name;
		this.product_price = product_price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
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
		return "ProductDTO [product_id=" + product_id + ", product_type=" + product_type + ", product_name="
				+ product_name + ", product_price=" + product_price + "]";
	}
	
	
	
}
