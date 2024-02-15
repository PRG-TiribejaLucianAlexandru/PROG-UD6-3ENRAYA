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

public class Jugador {

    private EstadoCasilla ficha;

    public Jugador(EstadoCasilla ficha) {
        this.ficha = ficha;
    }

    public void ponerFicha(Tablero tablero) {
        Scanner teclado = TresEnRaya.teclado;
        int fila, columna;
        do {
            System.out.printf("Introduce fila [1-%d]: ", Tablero.DIMENSION);
            if (teclado.hasNextInt()) {
                fila = teclado.nextInt();
                if (fila >= 1 && fila <= Tablero.DIMENSION) {
                    break;
                }
            }
            System.out.println("¡Error! Debe introducir un número entero válido.");
            teclado.nextLine();
        } while (true);

        do {
            System.out.printf("Introduce columna [1-%d]: ", Tablero.DIMENSION);
            if (teclado.hasNextInt()) {
                columna = teclado.nextInt();
                if (columna >= 1 && columna <= Tablero.DIMENSION) {
                    break;
                }
            }
            System.out.println("¡Error! Debe introducir un número entero válido.");
            teclado.nextLine();
        } while (true);

    }
    
    private Coordenada recogerCoordenada() {
        
        return null;
        
    }
}
