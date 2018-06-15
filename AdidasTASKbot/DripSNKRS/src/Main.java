public class Main {

    static String url = "https://atcproxys.com/splash-page/";

    public static void main(String[] args) {

        try {
            Thread t1 = new Thread(new Test(url));
            t1.start();
        } catch (Exception e){
            System.out.println("Error; please restart");
        }
    }



}
