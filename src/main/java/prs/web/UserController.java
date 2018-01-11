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

import prs.domain.User;
import prs.domain.UserRepository;
import prs.main.util.PRSMaintenanceReturn;

@Controller
@RequestMapping(path = "/Users")

public class UserController extends BaseController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable <User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	@PostMapping(path="/Add") // Map ONLY POST Requests
    public @ResponseBody PRSMaintenanceReturn addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
		try {	
			userRepository.save(user);
			System.out.println("User saved: "+user);
		}
		catch (Exception e) {
			user = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(user);
    }

	@GetMapping(path = "/Get")
	public @ResponseBody List <User> getUser (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POST request
		
		User u = userRepository.findOne(id);
		return getReturnArray(u);
	}
	
	@GetMapping(path="/Authenticate") // Map ONLY GET Requests
	public @ResponseBody List <User> authenticate (@RequestParam String uname
			, @RequestParam String pwd) {
		// @RequestParam means it is a parameter from the GET or POST request
		User u = userRepository.findByusernameAndPassword(uname, pwd);
		return getReturnArray(u);
	}
	
	@GetMapping(path = "/Update")
	public @ResponseBody PRSMaintenanceReturn updateUser (@RequestBody User user) {
		try{
			userRepository.save(user);
			System.out.println("User '" +user+ "' updated.");
		}
		catch (Exception e) {
			user = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(user);
	
	}
	
	@GetMapping(path = "/Delete")
	public @ResponseBody PRSMaintenanceReturn deleteUser (@RequestParam int id) {
		//ResponseBody means the returned String is the response, not a view name
		//RequestParam means it is a parameter from the GET or POSE request
		User user = userRepository.findOne(id);
		try {
			userRepository.delete(user);
			System.out.println("User "+user+" deleted");
		}
		catch (Exception e) {
			user = null;
		}
			return PRSMaintenanceReturn.getMaintReturn(user);
	}
	
	
}
