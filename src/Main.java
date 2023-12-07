import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            System.out.println("Please enter first three characters of the bank account:");
            String input= br.readLine();

            URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
            BufferedReader fis = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter fos = new BufferedWriter(new FileWriter("newFile.txt"));

            while (fis.readLine() != null) {
                String[] newStr;
                if(fis.readLine()==null){
                    break;
                }
                newStr =fis.readLine().split("[\t]");
                if (newStr[0].startsWith(input)) {
                    fos.write(newStr[0] + " " + newStr[1] + " " + newStr[2]);
                    fos.newLine();
                    break;
                }
            }
            fos.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}