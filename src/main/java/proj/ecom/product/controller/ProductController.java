package proj.ecom.product.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import proj.ecom.product.service.ProductService;
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
	@RequestMapping(value="listProduct",params={"product_itemType=1", "product_sortType=0"}, method=RequestMethod.GET)
	public String listProduct(@RequestParam("product_itemType") int product_itemType, @RequestParam int product_sortType, 
							Criteria cri, Model model) {		
		
		model.addAttribute("list", productService.listProduct(product_itemType, product_sortType, cri));
		
		if(product_itemType==1) model.addAttribute("content", "../views/product/listProductTop.jsp");
		
		/*PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(productService.getTotalCount());
		model.addAttribute("pm", pm);*/
		
		
		return "main";
	}
	
}