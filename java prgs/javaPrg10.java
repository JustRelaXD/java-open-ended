import java.io.*;
import java.util.*;

public class FileMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name (along with path if required)");
        String fileName=sc.nextLine();
        File f = new File(fileName);

        if(f.exists()){
            System.out.println("File Properties: ");
            System.out.println("1. File exists: YES");
            System.out.println("2. File is readable: "+ f.canRead());
            System.out.println("3. File is writable: "+ f.canWrite());
            if(f.isFile())
                System.out.println("4. Type of file: Regular file ");
            else if(f.isDirectory())
                System.out.println("4. Type of file: Directory ");
            else
                System.out.println("4. Type of file: : Unknown");
            System.out.println("5. Size of file: "+f.length());
        }
        else{
             System.out.println("1. File exists: NO");
             System.out.println("Other properties cannnot displayed");
        }
    }    
}