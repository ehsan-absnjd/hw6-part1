package shop.utils;


public class Scanner {
    java.util.Scanner sc = new java.util.Scanner(System.in );
    public int getInt(){
        int a;
        while(true){
            try{
                String st = sc.next();
                a = Integer.valueOf(st);
                break;
            }catch (Exception e){
                System.out.println("invalid input, try again");
            }
        }
        return a;
    }
    public double getDouble(){
        double a;
        while(true){
            try{
                String st = sc.next();
                a = Double.valueOf(st);
                break;
            }catch (Exception e){
                System.out.println("invalid input, try again");
            }
        }
        return a;
    }
    public String getString(){
        return sc.next();
    }
    public String getEmail(){
        String st ;
        while(true) {
            st = sc.next();
            if(st.indexOf("@")>0 &&
                    st.lastIndexOf(".") >st.indexOf("@")+1 &&
                    st.lastIndexOf(".") <st.length()-1 )
                break;
            System.out.println("invalid email, try again");
        }
        return st;
    }
}
