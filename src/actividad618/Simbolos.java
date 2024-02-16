/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad618;

/**
 *
 * @author batoi
 */
import java.util.Scanner;

public class Simbolos {

    private String[][] packs;
    private int packSeleccionado;

    public Simbolos() {
        this.packs = new String[][]{
            {"X", "O"},
            {"$", "€"},
            {"?", "!"}
        };
        this.packSeleccionado = 0;
    }

    public void seleccionar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vamos a seleccionar los iconos con los que jugar");
        for (int i = 0; i < packs.length; i++) {
            System.out.print("Pack " + (i + 1) + ": ");
            for (int j = 0; j < 2; j++) {
                System.out.print(packs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("Selecciona una opción: [1-%d]\n", packs.length);
        int opcion = scanner.nextInt();

        if (opcion > 0 && opcion <= packs.length) {
            packSeleccionado = opcion - 1;
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public String obtenerSimbolo(EstadoCasilla estadoCasilla) {
        switch (estadoCasilla) {
            case FICHA_X:
                return packs[packSeleccionado][0];
            case FICHA_O:
                return packs[packSeleccionado][1];
            case VACIO:
                return EstadoCasilla.VACIO.toString();
            default:
                return " ";
        }
    }
}
