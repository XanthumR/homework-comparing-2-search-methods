import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class homework {
    public static void main(String[] args) {

long b=0;
long c=0;
        try {
            File source = new File("Source.txt");
            Scanner myReader = new Scanner(source);
            LinkedList<Integer> Source=new LinkedList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Integer a= Integer.valueOf(data);
                if (!(Source.search(a))){
                    Source.insertToEnd(a);
                }
            }
            File search = new File("Search.txt");
            Source.methodC(search);
            System.out.println("total memory access (method c) :"+Source.getMemAccess());
            System.out.println("average memory access (method c) :"+Source.getMemAccess()/10000);
            myReader.close();
            c=Source.getTime();
            System.out.println("time to finish (method c) "+(Source.getTime())+" ms");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(" ");
        try {
            File source = new File("Source.txt");
            Scanner myReader = new Scanner(source);
            LinkedList<Integer> Source=new LinkedList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Integer a= Integer.valueOf(data);
                if (!Source.search(a)){
                    Source.insertToEnd(a);
                }
            }
            File search = new File("Search.txt");
            Source.methodB(search);
            System.out.println("total memory access (method b) :"+Source.getMemAccess());
            System.out.println("average memory access (method b) :"+Source.getMemAccess()/10000);
            myReader.close();

b=Source.getTime();
            System.out.println("time to finish (method b) "+(Source.getTime())+" ms");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("speed difference (method b-method c) :"+(b-c));


    }
}
