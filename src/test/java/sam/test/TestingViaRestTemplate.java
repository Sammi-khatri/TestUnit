package sam.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingViaRestTemplate {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("getPojoList")
    public void getPojoList() {
        HttpEntity<String> request = new HttpEntity<>(null, null);
        final String uri = "http://localhost:" + port + "/getAll";
        ResponseEntity<String> exchange = this.restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        System.out.println("status : " + exchange.getStatusCode());
        System.out.println("\n responseData: " + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertTrue(exchange.getBody().contains("id"));

    }

    @Test
    @DisplayName("findById")
    public void findById() {
        HttpEntity<String> request = new HttpEntity<>(null, null);
        final String uri = "http://localhost:" + port + "/findById/3";
        ResponseEntity<String> exchange = this.restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        System.out.println("status : " + exchange.getStatusCode());
        System.out.println("\n responseData: " + exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertTrue(exchange.getBody().contains("id"));

    }

    @Test
    @DisplayName("createPojo")
    public void createPojo() {
        JSONObject datavalue = new JSONObject();
        datavalue.put("name", "one");
        datavalue.put("lastName", "10");
        datavalue.put("address", "12");
        datavalue.put("occupation", "job");
        HttpEntity<String> request = new HttpEntity<>(asJsonString(new TestUnitPojo(1,"sdsa","eew","dewede","dede")), getHeader());
        final String uri = "http://localhost:" + port + "/createData";
        ResponseEntity<String> exchange = this.restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        System.out.println("status : " + exchange.getStatusCode());
        System.out.println("\n responseData: " + exchange.getBody());
        JSONObject jsonObject = new JSONObject(exchange.getBody());
        System.out.println("jsonResponse: " + jsonObject);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertTrue(exchange.getBody().contains("id"));
    }

    private HttpHeaders getHeader() {
        String set_cookie = "cookie value";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", set_cookie);
        headers.setCacheControl("no-cache");
        return headers;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
