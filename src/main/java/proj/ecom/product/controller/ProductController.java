package proj.ecom.product.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import proj.ecom.product.service.ProductService_Interface;
import proj.ecom.util.Criteria;
import proj.ecom.util.PageMaker;


@Controller
@RequestMapping("product")
public class ProductController {
	
	@Inject
	private ProductService_Interface productService;
	
	/*@RequestMapping(value= {"listProduct?product_itemType=0&listProduct_sortType=0", 
			"listProduct?product_itemType=1&product_sortType=0",
			"listProduct?product_itemType=2&listProduct_sortType=0",
			"listProduct?product_itemType=3&listProduct_sortType=0"}, method=RequestMethod.GET)*/
	//2. 상의 조회
	/*@RequestMapping(value = "/product/listProduct?product_itemType={product_itemType}&product_sortType={product_sortType}", method = RequestMethod.GET)
	public String listproduct(@PathVariable("product_itemType") int product_itemType, @PathVariable("product_sortType") int product_sortType, 
							Criteria cri, Model model){	
					
	}*/
	/*@RequestMapping(value="listProduct", method=RequestMethod.GET)
	public String listProduct(@RequestParam("product_itemType") int product_itemType, @RequestParam int product_sortType 
							, Criteria cri, Model model) {	*/	
	
	
	@RequestMapping(value="listProduct",params={"product_itemType=1", "product_sortType=0"}, method=RequestMethod.GET)
	public String listProduct(@RequestParam("product_itemType") int product_itemType, @RequestParam int product_sortType 
							, Criteria cri, Model model) {	
		model.addAttribute("list", productService.listProduct(product_itemType, product_sortType, cri));
		System.out.println("product_itemType : "+ product_itemType);
		System.out.println("product_sortType : "+ product_sortType);
		System.out.println("cri : "+cri);

		model.addAttribute("content", "../views/product/listProductTop.jsp");
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(productService.getTotalCount());
		
		System.out.println("getTotalCount 전체 상품게시글의 수 " + productService.getTotalCount());
		System.out.println("getTotalCount 전체 상품게시글의 수 " + pm.getTotalCount());
		System.out.println("cri + " + pm.getCri());
		model.addAttribute("pm", pm);
		
		return "main";
	}
	//상품 자세히보기
	@RequestMapping(value="productDetail", method=RequestMethod.GET)
	public String productDetail(//@RequestParam("product_id") int product_id, 
			//@RequestParam("product_size") String product_size, 
			@RequestParam("product_id") int product_id,
			@ModelAttribute("cri")Criteria cri, Model model) {
		//view에서 id를 보내준다. 이 메소드에서 id를 보내준다. 

		model.addAttribute("productDtoList", productService.productDetail(product_id, cri));
		model.addAttribute("content", "../views/product/productDetail.jsp");
		
		
		return "main";
	}
	@RequestMapping(value="productQuantityCheck", method=RequestMethod.GET)
	public String productQuantityCheck(
			@RequestParam("product_id") int product_id, Model model) {
		//id를 통해서 size와 quantity 조회해오기(선택칸에서 움직이게) mapper에서 sql문 만들어주기
		model.addAttribute("productDTOCheck", productService.productQuantityCheck(product_id));
		model.addAttribute("content", "../views/product/productDetail.jsp");
		//돌아갈주소를 다르게 해줘야하지 않나 상품별로 다르게 줄 텐데
		
		return "main";
	}
	
}
