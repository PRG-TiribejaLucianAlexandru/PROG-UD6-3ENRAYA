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
        Coordenada coordenada = recogerCoordenada(teclado);
        while (tablero.isOcupada(coordenada)) {
            System.out.println("La coordenada introducida no es válida o está ocupada. Inténtalo de nuevo.");
            coordenada = recogerCoordenada(teclado);
        }
        tablero.ponerFicha(coordenada, ficha);
    }
    
    private Coordenada recogerCoordenada(Scanner teclado) {
        int fila, columna;
        do {
            System.out.printf("Introduce fila [1-%d]: ", Tablero.DIMENSION);
            while (!teclado.hasNextInt()) {
                System.out.println("¡Error! Debe introducir un número entero válido.");
                teclado.next();
            }
            fila = teclado.nextInt();
        } while (fila < 1 || fila > Tablero.DIMENSION);
        
        do {
            System.out.printf("Introduce columna [1-%d]: ", Tablero.DIMENSION);
            while (!teclado.hasNextInt()) {
                System.out.println("¡Error! Debe introducir un número entero válido.");
                teclado.next();
            }
            columna = teclado.nextInt();
        } while (columna < 1 || columna > Tablero.DIMENSION);

        return new Coordenada(fila, columna);
    }
    
    public void cantarVictoria() {
        if (this.ficha == EstadoCasilla.FICHA_X) {
            System.out.println("¡El jugador con X es el ganador!");
        } else {
            System.out.println("¡El jugador con O es el ganador!");
        }
    }
}

