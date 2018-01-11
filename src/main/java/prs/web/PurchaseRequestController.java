package prs.web;

import java.sql.Timestamp;
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
import prs.domain.PurchaseRequest;
import prs.domain.PurchaseRequestLineItem;
import prs.domain.PurchaseRequestLineItemRepository;
import prs.domain.PurchaseRequestRepository;
import prs.domain.PurchaseRequestSummary;
import prs.main.util.PRSMaintenanceReturn;

@Controller
@RequestMapping(path = "/PurchaseRequests")

public class PurchaseRequestController extends BaseController {
	
	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable <PurchaseRequest> getAllPurchaseRequests(){
		return purchaseRequestRepository.findAll();
		
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody PRSMaintenanceReturn addNewPR (@RequestBody PurchaseRequest pr) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		pr.setSubmittedDate(ts);
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
			
		try{
			purchaseRequestRepository.save(pr);
			System.out.println("User saved: "+pr);
		}
		catch (Exception e) {
			pr = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(pr);
    }


	@GetMapping(path = "/Get")
	public @ResponseBody List <PurchaseRequest> getPR (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		
		PurchaseRequest pr = purchaseRequestRepository.findOne(id);
		return getReturnArray(pr);
	}
	
	@GetMapping(path= "/Summary")
	public @ResponseBody List<PurchaseRequestSummary> getPurchaseRequestSummary(@RequestParam int id){
		PurchaseRequestSummary prs = new PurchaseRequestSummary();
		PurchaseRequest pr = purchaseRequestRepository.findOne(id);
		prs.setPurchaseRequest(pr);
		List<PurchaseRequestLineItem> prlis = purchaseRequestLineItemRepository.findAllByPurchaseRequestID(pr.getId());
		prs.setLineItems(prlis);
		return getReturnArray(prs);
		
	}
	
	@GetMapping(path = "/Update")
	public @ResponseBody PRSMaintenanceReturn updatePurchaseRequest (@RequestBody PurchaseRequest pr) {
		
		try{
			purchaseRequestRepository.save(pr);
			System.out.println("Purchase Request updated.");
		}
		catch (Exception e) {
			pr = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(pr);
	
	}
//	
	@GetMapping(path = "/Delete")
	public @ResponseBody PRSMaintenanceReturn deletePurchaseRequest (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		PurchaseRequest pr = purchaseRequestRepository.findOne(id);
			
		try{
			purchaseRequestRepository.delete(pr);
			System.out.println("Purchase request deleted");
		}
		catch (Exception e) {
			pr = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(pr);
	}
	
	@GetMapping (path = "/GetNot")
	public @ResponseBody List<PurchaseRequestLineItem> getPRLINot(@RequestParam int id){
		List<PurchaseRequestLineItem> purchaseRequestLineItems = PurchaseRequestLineItemRepository.findAllByPurchaseRequestIDNot(id);
		return purchaseRequestLineItems;
	}
	
	
}