package sam.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestApis {
	@GetMapping("/products")
	public String test() {
		System.out.println("test APi called");
		return "Success";
	}

	@GetMapping("/")
	private String test1() {
		System.out.println("test APi called");
		return "Success";
	}

}
	