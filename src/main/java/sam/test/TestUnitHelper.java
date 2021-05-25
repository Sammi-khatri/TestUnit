package sam.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUnitHelper {
    List<TestUnitPojo> pojoList = new ArrayList<>();

    public TestUnitHelper(List<TestUnitPojo> pojoList) {
        this.pojoList = pojoList;
        pojoList.add(new TestUnitPojo(1, "Aone", "Asing", "XYZ", "Job"));
        pojoList.add(new TestUnitPojo(2, "Bone", "Bsing", "XYZ", "Job"));
        pojoList.add(new TestUnitPojo(3, "Cone", "Csing", "XYZ", "Job"));
        pojoList.add(new TestUnitPojo(4, "Done", "Dsing", "XYZ", "Job"));
        pojoList.add(new TestUnitPojo(5, "Eone", "Esing", "XYZ", "Job"));
    }

    /**
     * Here we find the TestPojo according to id
     *
     * @param id
     * @return $ TestUnitPojo
     */
    public TestUnitPojo findById(int id) {
        return pojoList.stream().filter(pojo -> pojo.getId() == id).collect(Collectors.toList()).get(0);
    }

    /**
     * Here we add the pojo in list
     *
     * @param pojo
     * @return $ TestUnitPojo
     */
    public TestUnitPojo createNew(TestUnitPojo pojo) {
        pojo.setId(6);
        pojoList.add(pojo);
        return pojo;

    }

    /**
     * Here we get all the TestUnitPojo list
     * @return $ List of TestUnitPojo
     */
    public List<TestUnitPojo> getAll() {
        return pojoList;
    }
}
