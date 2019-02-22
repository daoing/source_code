package springmvc1.controller;

import springmvc1.ExtController;
import springmvc1.ExtRequestMapping;

@ExtController
@ExtRequestMapping("/ext")
public class ExtIndexController {
	//ext/test/?name=122&age=6440654
	@ExtRequestMapping("/test")
	public String test(String name,Integer age) {
		System.out.println("手写springmvc框架...");
		return "index";
	}

}
