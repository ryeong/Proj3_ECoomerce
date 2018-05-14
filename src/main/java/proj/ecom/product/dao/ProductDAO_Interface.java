package proj.ecom.product.dao;

import java.util.List;

import proj.ecom.product.domain.ProductDTO;
import proj.ecom.util.Criteria;

public interface ProductDAO_Interface {
	//1. 각 상품 보기 - 목차에서 눌렀을 때 상의, 하의, 신발

		List<ProductDTO> listProduct(int product_itemType, int product_sortType, Criteria cri);
}
