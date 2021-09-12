package shop.menus;

import shop.entities.User;
import shop.utils.Scanner;

public class Auth {
    User[] users;

    Scanner sc = new Scanner();
    public Auth(User[] users){
        this.users =users;
    }
    public User run(){
        int command;
        do{
            System.out.println("1) login , 2) register , 3) exit");
            command=sc.getInt();
            switch (command){
                case 1 :
                    User user = login();
                    if(user!=null)
                        return user;
                    break;
                case 2:
                    User newUser =  register();
                    if(newUser!=null)
                        return newUser;
                    break;
                case 3:
                    System.out.println("bye!");
                    break;
                default :
                    System.out.println("invalid command");
            }
        }while(command !=3);
        return null;
    }
    private User login(){
        System.out.println("enter username:");
        String username = sc.getString();
        System.out.println("enter password");
        String password = sc.getString();
        for(int i=0; i<users.length ; i++){
            User user = users[i];
            if (user!=null && user.getUsername().equals(username )) {
                if(user.getPassword().equals(password))
                    return user;
                else {
                    System.out.println("wrong password");
                    return null;
                }
            }
        }
        System.out.println("username doesn't exist");
        return null;
    }
    private User register(){
        User newUser;
        System.out.println("enter your username:");
        String username=sc.getString();
        boolean taken;
        do {
            taken = false;
            for (int i = 0; i < users.length; i++) {
                User user = users[i];
                if (user != null && user.getUsername() == username) {
                    taken = true;
                }
            }
            if(taken){
                System.out.println("username taken, choose another username:");
                username=sc.getString();
            }
        }while(taken);
        System.out.println("enter your password:");
        String password=sc.getPassword();
        System.out.println("enter your first name:");
        String firstName=sc.getString();
        System.out.println("enter your last name:");
        String lastName=sc.getString();
        System.out.println("enter your phone number:");
        String phone= sc.getString();
        System.out.println("enter your email:");
        String email=sc.getEmail();
        System.out.println("enter your province:");
        String province=sc.getString();
        System.out.println("enter your city:");
        String city=sc.getString();
        System.out.println("enter your street:");
        String street=sc.getString();
        System.out.println("enter your post code:");
        String postalcode=sc.getString();
        System.out.println("enter your initial credit:");
        int balance=sc.getInt();
        newUser = new User(username , password, firstName, lastName, phone, email, province, city,street, postalcode , balance );
        boolean isFull=true;
        for(int i=0; i< users.length ; i++){
            if(users[i]==null){
                users[i]=newUser;
                isFull= false;
                break;
            }
        }
        if(isFull)
            System.out.println("users array is full, you won't be able to login again");
        return newUser;
    }
}
