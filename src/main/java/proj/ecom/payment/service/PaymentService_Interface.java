package proj.ecom.payment.service;

import java.util.List;

import proj.ecom.cart.domain.CartDTO;

public interface PaymentService_Interface {

	void insertProduct(List<CartDTO> payment_list, String payment_orderNum);

}
