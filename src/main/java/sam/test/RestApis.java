package sam.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class RestApis {
    @Autowired
    TestUnitHelper testUnitHelper;

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        List<TestUnitPojo> pojoList = testUnitHelper.getAll();
        if (!pojoList.isEmpty())
            return new ResponseEntity(pojoList, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity findById(@PathVariable("id") int id) {
        System.out.println("id : "+id);
        TestUnitPojo pojoData = testUnitHelper.findById(id);
        if (pojoData != null)
            return new ResponseEntity(pojoData, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createData")
    private ResponseEntity createData(@RequestBody TestUnitPojo pojo) {
        System.out.println("createData called");
        TestUnitPojo p1 = testUnitHelper.createNew(pojo);
        if (p1 != null) return new ResponseEntity(p1, HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @Bean
    @Primary
    public TestUnitHelper getHelper(){
        return new TestUnitHelper();
    }
}
	