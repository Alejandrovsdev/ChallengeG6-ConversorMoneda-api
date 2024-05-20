import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Moneda;
import modelo.MonedaApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            String[] monedas = {"USD", "EUR", "ARS"};

            System.out.println("Seleccione la moneda a convertir:");
            for (int i = 0; i < monedas.length; i++) {
                System.out.println((i + 1) + ". " + monedas[i]);
            }
            int opcionMonedaAConvertir = scan.nextInt();
            String monedaAConvertir = monedas[opcionMonedaAConvertir - 1];

            System.out.println("\nSeleccione la moneda requerida:");
            for (int i = 0; i < monedas.length; i++) {
                System.out.println((i + 1) + ". " + monedas[i]);
            }
            int opcionMonedaRequerida = scan.nextInt();
            String monedaRequerida = monedas[opcionMonedaRequerida - 1];

            if (monedaAConvertir.equals(monedaRequerida)) {
                System.out.println("Las monedas seleccionadas son iguales. No se puede realizar la conversión.");
                continue;
            }

            System.out.println("\nIngrese la cantidad a convertir:");
            double cantidadAConvertir = scan.nextDouble();

            String url = "https://v6.exchangerate-api.com/v6/9f348811525e2b8b920fb592/pair/" + monedaAConvertir + "/" + monedaRequerida;

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String jsonBody = response.body();
                MonedaApi miMonedaApi = gson.fromJson(jsonBody, MonedaApi.class);

                Moneda miMoneda = new Moneda(miMonedaApi, cantidadAConvertir);

                System.out.println("Resultado:");
                double resultado = cantidadAConvertir * miMoneda.getTasaDeConversion();
                System.out.printf("\n%.3f %s = %.3f %s\n", cantidadAConvertir, miMoneda.getMonedaAConvertir(), resultado, miMoneda.getMonedaRequerida());

            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            }

            System.out.println("\n¿Desea realizar otra conversión? (s/n):");
            String respuesta = scan.next();
            continuar = respuesta.equalsIgnoreCase("s");
        }

        System.out.println("\nGracias por usar el conversor de monedas. ¡Hasta luego!");
    }
}
