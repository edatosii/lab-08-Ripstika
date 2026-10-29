package co.umariana;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Calculadora ===");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Verificar si un número es par");
                System.out.println("6. Salir");

                Integer opcion = leerEntero(scanner, "Seleccione una opción: ");
                if (opcion == null || opcion == 6) {
                    System.out.println("Hasta luego.");
                    return;
                }

                if (opcion >= 1 && opcion <= 4) {
                    Integer a = leerEntero(scanner, "Ingrese el primer número: ");
                    Integer b = leerEntero(scanner, "Ingrese el segundo número: ");
                    if (a == null || b == null) {
                        System.out.println("Hasta luego.");
                        return;
                    }

                    try {
                        String resultado = switch (opcion) {
                            case 1 -> Integer.toString(calculadora.sumar(a, b));
                            case 2 -> Integer.toString(calculadora.restar(a, b));
                            case 3 -> Integer.toString(calculadora.multiplicar(a, b));
                            default -> Double.toString(calculadora.dividir(a, b));
                        };
                        System.out.println("Resultado: " + resultado);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (opcion == 5) {
                    Integer numero = leerEntero(scanner, "Ingrese un número: ");
                    if (numero == null) {
                        System.out.println("Hasta luego.");
                        return;
                    }
                    System.out.println(numero + (calculadora.esPar(numero) ? " es par." : " es impar."));
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }

    private static Integer leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (!scanner.hasNextLine()) {
                return null;
            }

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingrese un número entero.");
            }
        }
    }
}