/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad618;

/**
 *
 * @author batoi
 */
public enum EstadoCasilla {
    FICHA_O, FICHA_X, VACIO;

    @Override
    public String toString() {
        switch (this) {
            case FICHA_O:
                return "O";
            case FICHA_X:
                return "X";
            case VACIO:
                return " ";
            default:
                return "ERROR";
        }
    }
}
