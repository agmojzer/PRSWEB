package prs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.PurchaseRequestLineItem;
import prs.domain.PurchaseRequestLineItemRepository;
import prs.main.util.PRSMaintenanceReturn;

@Controller
@RequestMapping(path="/PurchaseRequestLineItems")
public class PurchaseRequestLineItemController extends BaseController {
	
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/Get")
	public @ResponseBody List<PurchaseRequestLineItem> getPurchaseRequestLineItem (@RequestParam int id){
		
		PurchaseRequestLineItem prli = purchaseRequestLineItemRepository.findOne(id);
		return getReturnArray(prli);
		
	}
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllLineItems(){
		return purchaseRequestLineItemRepository.findAll();
	}
	
	@PostMapping(path="/Add")
	public @ResponseBody PRSMaintenanceReturn addNewPurchaseRequestLineItem (@RequestBody PurchaseRequestLineItem purchaseRequestLineItem,
			HttpServletRequest req) {
		try {
			purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
			System.out.println("Line Item added: "+purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		System.out.println("Line Item saved");
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}
	
	@PostMapping(path="/Update")
	public @ResponseBody PRSMaintenanceReturn updatePurchaseRequestLineItem (@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
		try {
			purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
			System.out.println("Line Item updated: "+purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deletePurchaseRequestLineItem(@RequestParam int id) {
		PurchaseRequestLineItem purchaseRequestLineItem = purchaseRequestLineItemRepository.findOne(id);
		try {
			purchaseRequestLineItemRepository.delete(purchaseRequestLineItem);
			System.out.println("Line Item deleted");
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
		
	}

}
