package shop.entities;

public class User {
    private Product[] cart = new Product[5];
    private int cartIndex =0;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String province;
    private String city;
    private String street;
    private String postalcode;
    private int balance;

    public User(String username, String password, String firstName, String lastName, String phone, String email, String province, String city, String street, String postalcode, int balance) {
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
        this.balance=balance;
    }
    public void addToCart(Product p){
        if(cartIndex<5) {
            p.setUncommitedQuantity(p.getUncommitedQuantity()-1);
            cart[cartIndex++] = p;
        }else{
            System.out.println("cart capacity is full");
        }
    }
    public void removeFromCart(int id){
        int index= getProductIndexById(id);
        while(index!=-1){
            removeByIndex(index);
            index=getProductIndexById(id);
        }
    }
    private void removeByIndex(int index){
        cart[index].setUncommitedQuantity(cart[index].getUncommitedQuantity()+1);
        for(int i =index; i<cartIndex;i++){
            cart[i]=cart[i+1];
        }
        cartIndex--;
    }

    public void printCartInfo(){
        System.out.println("there are " +cartIndex + " items in your cart:" );
        for(int i=0; i<cartIndex; i++){
            System.out.println(cart[i]);
        }
    }
    public void commit(){
        int sum= getTotalFee();
        if(balance>=sum){
            balance-=sum;
            for(int i=0;i<cartIndex;i++){
                cart[i].setQuantity(cart[i].getUncommitedQuantity());
            }
            for(int i=cartIndex;i<5;i++){
                if(cart[i]!=null)
                    removeByIndex(i);
            }
        }else{
            System.out.println("you don't have enough credit");
        }
    }
    private int getTotalFee(){
        int sum=0;
        for(int i=0; i<cartIndex; i++){
            sum= cart[i].getPrice();
        }
        return sum;
    }
    public void printTotalFee(){
        System.out.println("yotal fee for items in your cart is:" + getTotalFee());
    }
    private int getProductIndexById(int id){
        for(int i=0; i<cartIndex;i++){
            if(cart[i].getId()==id)
                return i;
        }
        return -1;
    }

    public Product[] getCart() {
        return cart;
    }

    public int getCartIndex() {
        return cartIndex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalcode() {
        return postalcode;
    }
}
