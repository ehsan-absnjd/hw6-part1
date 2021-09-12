package shop.entities;

public class User {
    String username;
    String password;
    String firstName;
    String lastName;
    String phone;
    String email;
    String province;
    String city;
    String street;
    String postalcode;

    public User(String username, String password, String firstName, String lastName, String phone, String email, String province, String city, String street, String postalcode) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalcode = postalcode;
    }
}
