package sam.test;

public class TestUnitPojo {
    private int id;
    private String name;
    private String lastName;
    private String address;
    private String occupation;

    public TestUnitPojo() {
    }

    public TestUnitPojo(int id, String name, String lastName, String address, String occupation) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
