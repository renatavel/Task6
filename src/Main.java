import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader fis = new BufferedReader(new FileReader("task6Task.txt"))){

            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            System.out.println("Please enter first three characters of the bank account:");
            String input= br.readLine();


            while (fis.readLine() != null) {
                String[] newStr;
                if(fis.readLine()==null){
                    break;
                }
                newStr =fis.readLine().split("[\t]");
                if (newStr[0].startsWith(input)) {
                    System.out.println(newStr[1] + " " + newStr[2]);
                    break;
                }
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}