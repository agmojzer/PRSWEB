package prs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.Product;
import prs.domain.ProductRepository;
import prs.main.util.PRSMaintenanceReturn;


@Controller
@RequestMapping(path = "/Products")
public class ProductController extends BaseController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable <Product> getAllProdcuts(){
		return productRepository.findAll();
		
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody PRSMaintenanceReturn addNewProduct (@RequestBody Product product) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try{
        	productRepository.save(product);
        	System.out.println("Product saved: "+product);
        }
        catch (Exception e) {
        	product = null;
        }
        return PRSMaintenanceReturn.getMaintReturn(product);
    }


	@GetMapping(path = "/Get")
	public @ResponseBody List<Product> getProduct (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		
		Product p = productRepository.findOne(id);
		return getReturnArray(p);
	}

	@GetMapping(path = "/Update")
	public @ResponseBody PRSMaintenanceReturn updateProduct (@RequestBody Product product) {
		try {
		productRepository.save(product);
		System.out.println("Product '" +product+ "' updated.");
		}
		catch (Exception e) {
			product = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(product);

}
	@GetMapping(path = "/Delete")
	public @ResponseBody PRSMaintenanceReturn deleteProduct (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		Product product = productRepository.findOne(id);
			try {
		productRepository.delete(product);
			System.out.println("User "+product+" deleted");
			}
			catch (Exception e) {
				product = null;
			}
			return PRSMaintenanceReturn.getMaintReturn(product);
	}
	
//	private Product[] getReturnArray(Product p) {
//		Product[] returnArray;
//
//		if (p==null) {
//			returnArray = new Product[0];
//		}
//		else {
//			returnArray = new Product[1];
//			returnArray[0]=p;
//		}
//		return returnArray;
//	}
}