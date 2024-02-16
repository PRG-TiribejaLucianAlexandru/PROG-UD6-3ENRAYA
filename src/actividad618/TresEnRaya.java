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
    Jugador jugadorX;
    Jugador jugadorO;
    Simbolos simbolos;
    Tablero tablero;

    public TresEnRaya(Simbolos simbolos) {
        this.simbolos = simbolos;
        this.tablero = new Tablero(simbolos);
        seleccionarSimbolos();
        this.jugadorX = new Jugador(simbolos, EstadoCasilla.FICHA_X);
        this.jugadorO = new Jugador(simbolos, EstadoCasilla.FICHA_O);
    }

    private void seleccionarSimbolos() {
        System.out.println("Seleccione los símbolos para jugar:");
        simbolos.seleccionar();
    }

    public void jugar() {
        boolean volverAJugar = true;

        while (volverAJugar) {
            boolean tresEnRaya = false;
            while (!tablero.estaLleno() && !tresEnRaya) {
                System.out.println("Jugador con " + simbolos.obtenerSimbolo(EstadoCasilla.FICHA_X));
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

                System.out.println("Jugador con " + simbolos.obtenerSimbolo(EstadoCasilla.FICHA_O));
                jugadorO.ponerFicha(tablero);
                tablero.mostrar();
                tresEnRaya = tablero.hayTresEnRaya();
                if (tresEnRaya) {
                    jugadorO.cantarVictoria();
                    break;
                }
            }

            System.out.print("¿Quieres volver a jugar? [S/N]: ");
            String respuesta = teclado.nextLine().toUpperCase();
            while (!respuesta.equals("S") && !respuesta.equals("N")) {
                System.out.println("¡Error! Debes introducir S o N");
                System.out.print("¿Quieres volver a jugar? [S/N]: ");
                respuesta = teclado.nextLine().toUpperCase();
            }
            if (respuesta.equals("N")) {
                volverAJugar = false;
                break;
            } else {
                seleccionarSimbolos();
                tablero.vaciar();
            }
        }

    }

    public static void main(String[] args) {
        Simbolos simbolos = new Simbolos();
        TresEnRaya tresEnRaya = new TresEnRaya(simbolos);
        tresEnRaya.jugar();
    }
}
