package P48J;

import com.google.gson.*;
import java.io.*;
import java.util.*;
import P48J.*;

public class Main {
    public static Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static String toJson(Autos autos) {
        return gson.toJson(autos);
    }

    public static void main(String[] args) {
        try {
            Autos autos = gson.fromJson(new File("src\\main\\resources\\Autos.json"), Autos.class);

            Scanner entrada = new Scanner(System.in);

            boolean console = true;
            while (console) {
                System.out.println("Elija la opción deseada:\n");
                System.out.println("1. Mostrar el catálogo entero.");
                System.out.println("2. Añadir nuevos autos al catálogo.");
                System.out.println("3. Buscar autos mediante el tipo de marca.");
                System.out.println("4. Salir de la consola.\n");
                int numero = entrada.nextInt();
                entrada.nextLine();

                switch (numero) {
                    case 1:
                        autos.impAutos();
                        break;
                    case 2:
                        Transmision transmision = new Transmision(1);
                        int id = autos.getAutos().size() + 1;
                        Auto newAuto = new Auto(transmision, String.valueOf(id));
                        autos.añadirAutos(newAuto);
                        break;
                    case 3:
                        try {
                            System.out.println("Elija qué autos quieres ver según su marca:");
                            for (Auto auto : autos.getAutos()) {
                                System.out.println(auto.getMarca());
                            }
                            String modelo = entrada.nextLine();
                            autos.buscarAutos(modelo);
                        } catch (InputMismatchException | IndexOutOfBoundsException e) {
                            System.out.println("Debes usar números enteros y que estén dentro de las opciones");
                        }
                        break;
                    case 4:
                        console = false;
                        break;
                    default:
                        System.out.println("Los datos insertados deben estar dentro de las opciones posibles");
                }
            }
            entrada.close();

            // Guardar los cambios en el archivo JSON
            String autosJson = toJson(autos);
            File file = new File("src\\main\\resources\\Autos.json");
            org.apache.commons.io.FileUtils.writeStringToFile(file, autosJson, "UTF-8");

        } catch (IOException | InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
