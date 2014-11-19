/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.tanque.modelo;

/**
 *
 * @author a044533450e
 */
public class ControlRiego {

    
    private String mensaje;
    private EstadoTanque estado;
    private int sequia;
    private int humedad;

    public ControlRiego(EstadoTanque estado) {
        this.estado = estado;
    }

       public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getSequia() {
        return sequia;
    }

    public void setSequia(int sequia) {
        this.sequia = sequia;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public EstadoTanque getEstado() {
        return estado;
    }

    public void setEstado(EstadoTanque estado) {
        this.estado = estado;
    }

    // VALIDADO PARA EL LLENADO DEL TANQUE
    public int permitidoLlenar() {

        if (estado == EstadoTanque.LLENO) {
            mensaje = "No se puede llenar el tanque si esta lleno";
            return 1;
        }

        if (sequia < 0 || sequia > 10) {
            mensaje = "El valor de la sequia no puede ser inferior a 0 o superior a 10";
            return 2;
        }

        if (sequia == 10) {
            mensaje = "El valor de la sequia no puede ser 10";
            return 3;
        }

        if (sequia >= 7 && estado == EstadoTanque.MEDIO) {
            mensaje = "Si el valor de la sequia es mayor o igual que 7 y el tanque está a la mitad no se puede llenar del todo";
            return 4;
        }

        return 0;

    }

    // VALIDACION PARA VACIAR EL TANQUE
    public int permitidoVaciar() {
        // El valor de la humedad del suelo no puede ser mayor que 10 o menor que 0
        if (humedad > 10 || humedad < 0) {
            mensaje = "La humedad del suelo no puede ser mayor que 10 o menor que 0";
            return 1;
        }
        // No se puede vaciar NADA para regar si el tanque ya está vacío.
        if (estado == EstadoTanque.VACIO) {
            mensaje = "No se puede vaciar NADA para regar si el tanque ya está vacío.";
            return 2;
        }
        // No se puede vaciar nada para regar si la humedad del suelo es mayor o igual a 7
        if (humedad >= 7) {
            mensaje = "No se puede vaciar nada para regar si la humedad del suelo es mayor o igual a 7";
            return 3;
        }
        // No se puede vaciar más allá de la mitad para regar si la humedad del suelo es mayor o igual a 3 y menor que 7.
        if (humedad >= 3 && humedad < 7 && estado == EstadoTanque.MEDIO) {
            mensaje = "No se puede vaciar más allá de la mitad para regar si la humedad del suelo es mayor o igual a 3 y menor que 7.";
            return 4;
        }
        return 0;
    }

}
