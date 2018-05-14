package proj.ecom.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import proj.ecom.product.dao.ProductDAO;
import proj.ecom.product.domain.ProductDTO;
import proj.ecom.util.Criteria;

@Service
public class ProductService implements ProductService_Interface{
	@Inject ProductDAO productDao;
	
	//1. 각 상품 보기 - 목차에서 눌렀을 때 상의, 하의, 신발

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<ProductDTO> listProduct(int product_itemType, int product_sortType, Criteria cri) {
		System.out.println("product_itemType service "+product_itemType);
		System.out.println("product_sortType service "+product_sortType);

		return productDao.listProduct(product_itemType, product_sortType, cri);
	}



	@Override
	public List<ProductDTO> productDetail(int product_id) {
		
		return productDao.productDetail(product_id);
	}


}
