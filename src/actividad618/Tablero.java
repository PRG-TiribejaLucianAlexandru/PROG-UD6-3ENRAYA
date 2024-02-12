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

    private int dimension = 3;
    private EstadoCasilla[][] casillas;

    public Tablero() {
        casillas = new EstadoCasilla[dimension + 1][dimension + 1];
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
            if (i == 0 && (j == 1 || j == 2 || j == 3)) { 
                System.out.printf("|%d", j);
            } else if ((j == 0) && (i == 1 || i == 2 || i == 3)) {
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
        for (int j = 1; j < this.casillas.length; j++) {
            if (casillas[i][j] != EstadoCasilla.VACIO) {
                
            } else {
                return false;
            }
        }
    }
    return true;
}
/* - Método de debugging para rellenar todo el tablero
public void rellenarTablero(EstadoCasilla color) {
    for (int i = 1; i <= dimension; i++) {
        for (int j = 1; j <= dimension; j++) {
            Coordenada casilla = new Coordenada(i, j);
            ponerFicha(casilla, color);
        }
    }

}
*/
}
