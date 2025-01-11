package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    static List<String> historial = new ArrayList<>();
    static int contador = 1;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner (System.in);


        int opcion = 0;
        do {

            opcion = menu(sc);

            operacion(opcion, sc);

        } while(opcion !=9);
    }

    public static int menu (Scanner sc) {
        System.out.println("==== CALCULADORA ====");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Potencia");
        System.out.println("6. Raíz cuadrada");
        System.out.println("7. Módulo");
        System.out.println("8. Ver historial");
        System.out.println("9. Salir");
        return Integer.parseInt(sc.nextLine());
    }
    public static void operacion(int opcion, Scanner sc) {
        double resultado = 0;

        switch(opcion) {
            case 1:
                double numeros[] = obtenerNumeros(sc, 2);
                resultado = numeros[0] + numeros[1];
                historial.add(contador + ". " + numeros[0] + " + " + numeros[1] + " = " + resultado);

                break;

            case 2:
                numeros = obtenerNumeros(sc, 2);
                resultado = numeros[0] - numeros[1];
                historial.add(contador + ". " + numeros[0] + " - " + numeros[1] + " = " + resultado);
                break;

            case 3:
                numeros = obtenerNumeros(sc, 2);
                resultado = numeros[0] * numeros[1];
                historial.add(contador + ". " + numeros[0] + " * " + numeros[1] + " = " + resultado);
                break;

            case 4:
                numeros = obtenerNumeros(sc, 2);
                resultado = numeros[0] / numeros[1];
                historial.add(contador + ". " + numeros[0] + " / " + numeros[1] + " = " + resultado);
                break;

            case 5:
                numeros = obtenerNumeros(sc, 2);
                resultado = Math.pow(numeros[0], numeros[1]);
                historial.add(contador + ". " + numeros[0] + " ^ " + numeros[1] + " = " + resultado);
                break;

            case 6:
                numeros = obtenerNumeros(sc, 1);
                if (numeros[0] < 0){
                    System.out.println("El número tiene que ser positivo");
                    return;
                }
                resultado = Math.sqrt(numeros[0]);
                historial.add(contador + ". √" + numeros[0] + " = " + resultado);
                break;

            case 7:
                numeros = obtenerNumeros(sc, 2);
                resultado = numeros[0] % numeros[1];
                historial.add(contador + ". " + numeros[0] + " % " + numeros[1] + " = " + resultado);
                break;

            case 8:
                historial.forEach(System.out::println);
                break;

            case 9:
                System.out.println("Saliendo del programa");
                break;

                default:
                    System.out.println("Opcion no valida");
        }

        if (opcion != 8 && opcion != 9) {
            System.out.println("Resultado: " + resultado);
        }
        contador++;

    }
    public static double[] obtenerNumeros(Scanner sc, int cantidad){
        double[] numeros = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce el número " + (i+1));
            numeros[i] = Double.parseDouble(sc.nextLine());
        }
        return numeros;
    }

}
