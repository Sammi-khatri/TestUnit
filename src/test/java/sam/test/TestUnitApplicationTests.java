package sam.test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class TestUnitApplicationTests {

	@Autowired
	WebApplicationContext webApplicationContext;

	@Test
	@DisplayName("testInt")
	void testInt() {
		int a = 10;
		assertEquals(a, a);
	}

	@Test
	public void getProductsList() {
		try {
			System.out.println("test Called");
			String uri = "/findById/"+1;
			MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			String content = mvcResult.getResponse().getContentAsString();
			System.out.println("status: "+status+" \n content: "+content);
			assertEquals(200, status);
			assertEquals(200,status);

		} catch (Exception e) {
			System.out.println("exception : " + e.getLocalizedMessage());
		}
	}

	@Test
	public void testTwo(){
		assertEquals("one","one");
	}
	@AfterAll
	public static void testAfter(){
		assertEquals(10,10);
	}

}
