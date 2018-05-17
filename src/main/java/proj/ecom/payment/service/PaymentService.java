package proj.ecom.payment.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import proj.ecom.cart.domain.CartDTO;
import proj.ecom.payment.dao.PaymentDAO;

@Service
public class PaymentService implements PaymentService_Interface{
	@Inject
	private PaymentDAO payment_DAO;

	@Override
	public void insertProduct(List<CartDTO> payment_list, String payment_orderNum) {
		payment_DAO.insertProduct(payment_list,payment_orderNum);
	}
	
	
}
