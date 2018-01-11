//https://spring.io/guides/gs/accessing-data-mysql/
package prs.domain;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRequestRepository extends CrudRepository <PurchaseRequest, Integer>{

}