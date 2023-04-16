import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funkce {

    private Constructor constructor = new Constructor(0,0,0);

    public void cteni(File soubor){
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(soubor)));
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            int c = Integer.parseInt(scanner.nextLine());
            constructor = new Constructor(a,b,c);
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void ukladani(File soubor){
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(soubor)));
            int a = constructor.getA();
            int b = constructor.getB();
            int c = constructor.getC();
            writer.println(a);
            writer.println(b);
            writer.println(c);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
}
