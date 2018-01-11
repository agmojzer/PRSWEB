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
import prs.domain.Vendor;
import prs.domain.VendorRepository;
import prs.domain.VendorSummary;
import prs.main.util.PRSMaintenanceReturn;

@Controller
@RequestMapping(path = "/Vendors")
public class VendorController extends BaseController{
	
	@Autowired
	private VendorRepository vendorRepository;
	@Autowired 
	private ProductRepository productRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable <Vendor> getAllVendors(){
		return vendorRepository.findAll();
		
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody PRSMaintenanceReturn addNewVendor (@RequestBody Vendor vendor) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
		try {	
			vendorRepository.save(vendor);
			System.out.println("Vendor '"+vendor+"' saved.");
		}
		catch (Exception e) {
			vendor = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(vendor);
    }
	

	@GetMapping(path = "/Get")
	public @ResponseBody List <Vendor> getVendor (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		
		Vendor v = vendorRepository.findOne(id);
		return getReturnArray(v);
	}
	
	@GetMapping(path = "/Update")
	public @ResponseBody PRSMaintenanceReturn updateVendor (@RequestBody Vendor vendor) {
		try {
		vendorRepository.save(vendor);
		System.out.println("Vendor '" +vendor+ "' updated.");
		}
		catch (Exception e) {
			vendor = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(vendor);
	}	
	
	@GetMapping(path = "/Delete")
	public @ResponseBody PRSMaintenanceReturn deleteVendor (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		Vendor vendor = vendorRepository.findOne(id);
			
		try {
			vendorRepository.delete(vendor);
			System.out.println("Vendor "+vendor+" deleted");
		}
		catch (Exception e) {
			vendor = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(vendor);
	}
	
	@GetMapping(path = "/Summary")
	public @ResponseBody List<VendorSummary> getVendorSummary (@RequestParam int id){
		VendorSummary vs = new VendorSummary();
		Vendor vendor = vendorRepository.findOne(id);
		vs.setVendor(vendor);
		List<Product> products = productRepository.findAllByVendorID(vendor.getId());
		vs.setProducts(products);
		return getReturnArray(vs);
		
	}
	
	@GetMapping (path = "/GetNot")
		public @ResponseBody List<Product> getVendorNot(@RequestParam int id){
			List<Product> products = productRepository.findAllByVendorIDNot(id);
			return products;
	}
	
}