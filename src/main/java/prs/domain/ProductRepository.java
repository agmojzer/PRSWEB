//https://spring.io/guides/gs/accessing-data-mysql/
package prs.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Integer>{
	
		List<Product> findAllByVendorID(int id);
		List<Product> findAllByVendorIDNot(int id);

}
