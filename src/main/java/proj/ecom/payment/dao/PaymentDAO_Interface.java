package proj.ecom.payment.dao;

import java.util.List;

import proj.ecom.cart.domain.CartDTO;

public interface PaymentDAO_Interface {
	public void insertProduct(List<CartDTO> payment_list, String payment_orderNum);
}
