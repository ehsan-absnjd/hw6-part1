package shop.menus;

import shop.entities.User;

public class Main {
    User user;
    User[] users = new User[10];
    Auth auth = new Auth(users);
    Shop shop = new Shop(20);
    public void run() {
        while (true) {
            if(user==null){
                user = auth.run();
                if(user==null){
                    break;
                }
            }else{
                System.out.println("welcome to shop");
                shop.run(user);
                user=null;
            }
        }
    }
}
