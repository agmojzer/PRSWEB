package prs.domain;

import java.util.List;

public class VendorSummary {
	
	private Vendor vendor;
	private List<Product> products;
	
	public VendorSummary(Vendor vendor, List<Product> products) {
		super();
		this.vendor = vendor;
		this.products = products;
	}

	public VendorSummary() {
		
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
	

	


}
