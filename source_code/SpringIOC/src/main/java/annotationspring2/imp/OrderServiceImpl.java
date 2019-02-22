package annotationspring2.imp;

import annotationspring2.ExtService;
import annotationspring2.OrderService;

@ExtService
public class OrderServiceImpl implements OrderService {
	public void addOrder() {
		System.out.println("addOrder");
	}
}
