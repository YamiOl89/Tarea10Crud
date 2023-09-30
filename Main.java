package edu.umg;

import edu.umg.conexion.clsConexion;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        clsConexion cone = new clsConexion();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Menú de Operaciones:");
            System.out.println("1. Leer datos");
            System.out.println("2. Insertar datos");
            System.out.println("3. Actualizar datos");
            System.out.println("4. Eliminar datos");
            System.out.println("5. Salir");
            System.out.print("Por favor, seleccione una opción: ");

            try {
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        cone.leerDatos();
                        break;
                    case 2:
                        cone.insertarDatos();
                        cone.leerDatos();
                        esperarEnter();
                        break;
                    case 3:
                        cone.actualizarDatos();
                        cone.leerDatos();
                        esperarEnter();
                        break;
                    case 4:
                        cone.eliminarDatos();
                        cone.leerDatos();
                        esperarEnter();
                        break;
                    case 5:
                        System.out.println("Se esta saliendo del programa. ¡Chauu!");
                        System.exit(0);
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("Error: Ingrese un número válido.");
                sc.nextLine();
            } catch (SQLException var5) {
                System.out.println("Error: " + var5.getMessage());
            }
        }
    }

    private static void esperarEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }
}