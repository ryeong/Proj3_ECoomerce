package proj.ecom.payment.domain;

import proj.ecom.cart.domain.CartDTO;

public class PaymentDTO extends CartDTO{
	private static final long serialVersionUID = 1L;
	private String payment_orderDate;
	private String payment_orderNum;
	private String payment_orderId;
	
	
	public PaymentDTO() {
		super();
	}
	
	public PaymentDTO(String payment_orderDate, String payment_orderNum, String payment_orderId) {
		super();
		this.payment_orderDate = payment_orderDate;
		this.payment_orderNum = payment_orderNum;
		this.payment_orderId = payment_orderId;
	}

	public String getPayment_orderDate() {
		return payment_orderDate;
	}
	public void setPayment_orderDate(String payment_orderDate) {
		this.payment_orderDate = payment_orderDate;
	}
	public String getPayment_orderNum() {
		return payment_orderNum;
	}
	public void setPayment_orderNum(String payment_orderNum) {
		this.payment_orderNum = payment_orderNum;
	}
	public String getPayment_orderId() {
		return payment_orderId;
	}
	public void setPayment_orderId(String payment_orderId) {
		this.payment_orderId = payment_orderId;
	}

	@Override
	public String toString() {
		return "PaymentDTO [payment_orderNum=" + payment_orderNum + ", payment_orderId=" + payment_orderId + "]";
	}
	
	
}
