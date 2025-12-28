public class javaPrg4 {

    public static void noException(){
        try{
            System.out.println("try of noEx");
            int x=10/2;
        }
        catch (Exception e) {
            System.out.println("catch of noEx");
        }
        finally{
            System.out.println("finally of noEx");
        }
        System.out.println("end of noEx");
    }

    public static void withException(){
        try{
            System.out.println("try of withEx");
            int x=10/0;
        }
        catch (Exception e) {
            System.out.println("catch of withEx");
        }
        finally{
            System.out.println("finally of withEx");
        }
        System.out.println("end of withEx");
    }

    public static void withReturn(){
        try{
            System.out.println("try of withReturn");
            return;
        }
        catch (Exception e) {
            System.out.println("catch of withReturn");
        }
        finally{
            System.out.println("finally of withReturn");
        }
        System.out.println("end of withReturn");
    }
    public static void main(String[] args) {
        noException();
        withException();
        withReturn();
    }


}