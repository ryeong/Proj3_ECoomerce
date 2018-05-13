package proj.ecom.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import proj.ecom.product.domain.ProductDTO;
import proj.ecom.util.Criteria;

@Repository
public class ProductDAO implements ProductDAO_Interface{
	static final String NAMESPACE = "proj.ecom.product.ProductMapper";
	@Inject
	private SqlSession sqlSession;



	@Override
	public List<ProductDTO> listProduct(int product_itemType, int product_sortType, Criteria cri) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemType", product_itemType);
		map.put("sortType", product_sortType);
		map.put("cri", cri);
		
		return sqlSession.selectList(NAMESPACE+".listProduct", map);
	}
}
