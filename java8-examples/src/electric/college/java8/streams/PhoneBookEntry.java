package electric.college.java8.streams;

public class PhoneBookEntry {
    String name;

    public PhoneBookEntry(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone;

    @Override
    public String toString() {
        return name + " " + phone;
    }
}
