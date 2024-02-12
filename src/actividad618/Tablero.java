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

}
