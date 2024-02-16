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

    public static final int DIMENSION = 3;
    private EstadoCasilla[][] casillas;
    Simbolos simbolos;

    public Tablero(Simbolos simbolos) {
        this.casillas = new EstadoCasilla[DIMENSION + 1][DIMENSION + 1];
        this.simbolos = simbolos;
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
        for (int i = 0; i <= DIMENSION; i++) {
            for (int j = 0; j <= DIMENSION; j++) {
                if (i == 0 && j > 0) {
                    System.out.printf("|%d", j);
                } else if (j == 0 && i > 0) {
                    System.out.printf("|%d", i);
                } else {
                    EstadoCasilla estadoCasilla = casillas[i][j];
                    String simbolo = simbolos.obtenerSimbolo(estadoCasilla);
                    System.out.printf("|%s", simbolo);
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
                if (casillas[i][j] == color) {
                    boolean hayTres = true;
                    for (int k = 1; k < DIMENSION; k++) {
                        if (casillas[i][j + k] != color) {
                            hayTres = false;
                            break;
                        }
                    }
                    if (hayTres) {
                        return true;
                    }
                }
            }
        }

        // Columnas
        for (int j = 1; j <= DIMENSION; j++) {
            for (int i = 1; i <= DIMENSION - 2; i++) {
                if (casillas[i][j] == color) {
                    boolean hayTres = true;
                    for (int k = 1; k < DIMENSION; k++) {
                        if (casillas[i + k][j] != color) {
                            hayTres = false;
                            break;
                        }
                    }
                    if (hayTres) {
                        return true;
                    }
                }
            }
        }

        // Diagonal izquierda
        for (int i = 1; i <= DIMENSION - 2; i++) {
            for (int j = 1; j <= DIMENSION - 2; j++) {
                if (casillas[i][j] == color) {
                    boolean hayTres = true;
                    for (int k = 1; k < DIMENSION; k++) {
                        if (casillas[i + k][j + k] != color) {
                            hayTres = false;
                            break;
                        }
                    }
                    if (hayTres) {
                        return true;
                    }
                }
            }
        }

        // Diagonal derecha
        for (int i = 1; i <= DIMENSION - 2; i++) {
            for (int j = DIMENSION; j >= 3; j--) {
                if (casillas[i][j] == color) {
                    boolean hayTres = true;
                    for (int k = 1; k < DIMENSION; k++) {
                        if (casillas[i + k][j - k] != color) {
                            hayTres = false;
                            break;
                        }
                    }
                    if (hayTres) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
