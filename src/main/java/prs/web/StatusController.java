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

import prs.domain.Status;
import prs.domain.StatusRepository;
import prs.main.util.PRSMaintenanceReturn;


@Controller
@RequestMapping(path = "/Status")
public class StatusController extends BaseController{
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable <Status> getAllStatus(){
		return statusRepository.findAll();
		
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody PRSMaintenanceReturn addNewStatus (@RequestBody Status status) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
			
		try {
		statusRepository.save(status);
			System.out.println("Status saved: "+status);
		}
		catch (Exception e) {
			status = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(status);
    }
	

	@GetMapping(path = "/Get")
	public @ResponseBody List<Status> getStatus (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		Status s = statusRepository.findOne(id);
		return getReturnArray(s);
	}
	
	@GetMapping(path = "/Update")
	public @ResponseBody PRSMaintenanceReturn updateStatus (@RequestBody Status status) {
		try {
			statusRepository.save(status);
			System.out.println("Status '" +status+ "' updated.");
		}
		catch (Exception e) {
			status = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(status);
	
	}
	@GetMapping(path = "/Delete")
	public @ResponseBody PRSMaintenanceReturn deleteStatus (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		Status status = statusRepository.findOne(id);
			try {
				statusRepository.delete(status);
				System.out.println("Status '"+status+"' deleted");
			}
			catch (Exception e) {
				status = null;
			}
			return PRSMaintenanceReturn.getMaintReturn(status);
	}

	
//	private Status[] getReturnArray(Status s) {
//		Status[] returnArray;
//
//		if (s==null) {
//			returnArray = new Status[0];
//		}
//		else {
//			returnArray = new Status[1];
//			returnArray[0]=s;
//		}
//		return returnArray;
//	}
}