/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad618;

/**
 *
 * @author batoi
 */
public class Tablero {

    public static final int DIMENSION = 5;
    private EstadoCasilla[][] casillas;

    public Tablero() {
        this.casillas = new EstadoCasilla[DIMENSION + 1][DIMENSION + 1];
        vaciar();
    }

    public void vaciar() {
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                casillas[i][j] = EstadoCasilla.VACIO;
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < this.casillas.length; i++) {
            for (int j = 0; j < this.casillas[i].length; j++) {
                if (i == 0 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) {
                    System.out.printf("|%d", j);
                } else if ((j == 0) && (i == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
                    System.out.printf("|%d", i);
                } else {
                    System.out.printf("|%s", this.casillas[i][j]);
                }
            }
            System.out.println("|");
        }
    }

    public boolean isOcupada(Coordenada casilla) {
        if (casillas[casilla.getFila()][casilla.getColumna()] != EstadoCasilla.VACIO) {
            return true;
        } else {
            return false;
        }
    }

    public void ponerFicha(Coordenada casilla, EstadoCasilla color) {
        casillas[casilla.getFila()][casilla.getColumna()] = color;
    }

    public boolean estaLleno() {
        for (int i = 1; i < this.casillas.length; i++) {
            for (int j = 1; j < this.casillas[i].length; j++) {
                if (casillas[i][j] == EstadoCasilla.VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public void rellenarTablero(EstadoCasilla color) {
        for (int i = 1; i <= DIMENSION; i++) {
            for (int j = 1; j <= DIMENSION; j++) {
                Coordenada casilla = new Coordenada(i, j);
                ponerFicha(casilla, color);
            }
        }
    }

    public boolean hayTresEnRaya() {
        if (hayTresEnRaya(EstadoCasilla.FICHA_O) || hayTresEnRaya(EstadoCasilla.FICHA_X)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {
        // Filas
        for (int i = 1; i <= DIMENSION; i++) {
            for (int j = 1; j <= DIMENSION - 2; j++) {
                if (casillas[i][j] == color && casillas[i][j + 1] == color && casillas[i][j + 2] == color) {
                    return true;
                }
            }
        }

        // Columnas
        for (int j = 1; j <= DIMENSION; j++) {
            for (int i = 1; i <= DIMENSION - 2; i++) {
                if (casillas[i][j] == color && casillas[i + 1][j] == color && casillas[i + 2][j] == color) {
                    return true;
                }
            }
        }

        // Diagonal izquierda
        for (int i = 1; i <= DIMENSION - 2; i++) {
            for (int j = 1; j <= DIMENSION - 2; j++) {
                if (casillas[i][j] == color && casillas[i + 1][j + 1] == color && casillas[i + 2][j + 2] == color) {
                    return true;
                }
            }
        }

        // Diagonal derecha
        for (int i = 1; i <= DIMENSION - 2; i++) {
            for (int j = DIMENSION; j >= 3; j--) {
                if (casillas[i][j] == color && casillas[i + 1][j - 1] == color && casillas[i + 2][j - 2] == color) {
                    return true;
                }
            }
        }

        return false;
    }
}
