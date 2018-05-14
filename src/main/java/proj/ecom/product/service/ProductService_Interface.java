package proj.ecom.product.service;

import java.util.List;

import proj.ecom.product.domain.ProductDTO;
import proj.ecom.util.Criteria;

public interface ProductService_Interface {
	//페이징 처리
	int getTotalCount();
	//상품 카테고리 보기
	List<ProductDTO> listProduct(int product_itemType, int product_sortType, Criteria cri);
	
	//상품 자세히 보기
	List<ProductDTO> productDetail(int product_id, Criteria cri);
	ProductDTO productQuantityCheck(int product_id);
	
}
