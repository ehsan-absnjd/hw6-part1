package shop.menus;

import shop.entities.Product;
import shop.entities.User;
import shop.utils.Scanner;

import java.util.Random;


public class Shop {
    private Scanner sc =new Scanner();
    private Product[] products;
    public Shop(int num){
        products = new Product[num];
        for(int i=0; i<num ; i++){
            Random rn = new Random();
            Product.Type type = i%3 ==0 ? Product.Type.ELECTRIC : (i%3 ==1 ? Product.Type.READABLE : Product.Type.SHOE );
            products[i]=new Product( type , rn.nextInt(1000)*1000 , rn.nextInt(5)+2  );
        }
    }
    public void run(User user){
        int command;
        do {
            System.out.println("1)show product list 2)add to cart 3)remove from cart 4)show cart detail 5)show cart total fee 6)show credit 7)add credit 8)sumbit purchase 9)log out");
            command=sc.getInt();
            switch(command){
                case 1:
                    showShopProducts();
                    break;
                case 2:
                    addToCart(user);
                    break;
                case 3:
                    removeFromCart(user);
                    break;
                case 4:
                    user.printCartInfo();
                    break;
                case 5:
                    user.printTotalFee();
                    break;
                case 6:
                    System.out.println("user's credit is: " + user.getBalance());
                    break;
                case 7:
                    addBalance(user);
                    break;
                case 8:
                    user.commit();
                    break;
                case 9:
                    System.out.println("logging out...");
                    user.release();
                    break;
                default:
                    System.out.println("invalid command!");

            }
        }while(command!=9);
    }

    private void addBalance(User user) {
        System.out.println("how much do you want to add?");
        user.addBalance(sc.getInt());
    }


    private void removeFromCart(User user) {
        System.out.println("enter product id");
        int id = sc.getInt();
        user.removeFromCart(id);
    }

    private void addToCart(User user) {
        System.out.println("enter product id");
        int id = sc.getInt();
        if(id<products.length) {
            Product product = products[id-1];
            if (product.getQuantity()<=0){
                System.out.println("we're out of stock!");
                return;
            }
            if(product.getUncommitedQuantity()<=0){
                System.out.println("you've already ordered the last piece(s)");
                return;
            }
            user.addToCart(product);
        }else{
            System.out.println("there's no product with such id");
        }
    }

    private void showShopProducts() {
        for( int i=0; i<products.length ; i++){
            System.out.println(products[i]);
        }
    }
}
