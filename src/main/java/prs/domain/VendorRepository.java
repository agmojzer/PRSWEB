//https://spring.io/guides/gs/accessing-data-mysql/
package prs.domain;

import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository <Vendor, Integer>{
	
	//Status findStatus(String desc);

}