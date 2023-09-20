import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        // Ruta de archivo
        String rutaArchivo = "C:/Users/Kiraft/Desktop/correos.txt";
        ArrayList<String> correos = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new File(rutaArchivo));

            String expresion = "\\w+\\@\\w+\\.(com|mx|es)";
            Pattern pattern = Pattern.compile(expresion);

            // Lee el archivo línea por línea y los añade al arraylist
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                Matcher matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    String email = matcher.group();
                    correos.add(email);
                }
            }

            if (correos.size() != 0) {
                for (String correo : correos) {
                    System.out.println(correo);
                }
            } else {
                System.out.println("No se encontraron correos");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo o no existe");
        }
    }
}
