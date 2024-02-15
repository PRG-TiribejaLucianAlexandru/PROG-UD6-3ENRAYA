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

public class TresEnRaya {

    final public static Scanner teclado = new Scanner(System.in);
    Tablero tablero = new Tablero();
    Jugador jugadorX = new Jugador(EstadoCasilla.FICHA_X);
    Jugador jugadorO = new Jugador(EstadoCasilla.FICHA_O);

    public void jugar() {

        boolean volverAJugar = true;

        while (volverAJugar) {
            boolean tresEnRaya = false;
            while (!tablero.estaLleno() && !tresEnRaya) {
                System.out.println("Jugador con X");
                jugadorX.ponerFicha(tablero);
                tablero.mostrar();
                tresEnRaya = tablero.hayTresEnRaya();
                if (tresEnRaya) {
                    jugadorX.cantarVictoria();
                    break;
                }
                if (tablero.estaLleno()) {
                    System.out.println("¡Empate!");
                    break;
                }

                System.out.println("Jugador con O");
                jugadorO.ponerFicha(tablero);
                tablero.mostrar();
                tresEnRaya = tablero.hayTresEnRaya();
                if (tresEnRaya) {
                    jugadorO.cantarVictoria();
                    break;
                }
            }

            System.out.print("¿Quieres volver a jugar? [S/N]: ");
            teclado.nextLine();
            String respuesta = teclado.nextLine().toUpperCase();
            while (!respuesta.equals("S") && !respuesta.equals("N")) {
                System.out.println("¡Error! Debes introducir S o N");
                System.out.print("¿Quieres volver a jugar? [S/N]: ");
                respuesta = teclado.nextLine().toUpperCase();
                teclado.nextLine();
            }
            if (respuesta.equals("N")) {
                volverAJugar = false;
                break;
            } else {
                tablero.vaciar();
            }
        }
    }

    public static void main(String[] args) {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
    }
}
