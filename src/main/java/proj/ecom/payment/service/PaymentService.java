package proj.ecom.payment.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import proj.ecom.payment.dao.PaymentDAO;

@Service
public class PaymentService implements PaymentService_Interface{
	@Inject
	private PaymentDAO payment_DAO;
	
	@Override
	public void insertProduct(HashMap<String, Object> payment_map) {
		payment_DAO.insertProduct(payment_map);
	}
}
