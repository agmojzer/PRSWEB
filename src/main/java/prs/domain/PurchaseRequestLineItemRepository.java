package prs.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRequestLineItemRepository extends CrudRepository<PurchaseRequestLineItem, Integer> {
	
	List<PurchaseRequestLineItem> findAllByPurchaseRequestID(int purchaseRequestId);
	List<PurchaseRequestLineItem> findAllByPurchaseRequestIDNot(int purchaseRequestId);
}
