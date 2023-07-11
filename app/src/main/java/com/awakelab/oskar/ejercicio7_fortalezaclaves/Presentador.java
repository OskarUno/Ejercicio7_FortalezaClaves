package com.awakelab.oskar.ejercicio7_fortalezaclaves;

public class Presentador {
    private Modelo modelo;
    private VistaPresentador vistaPresentador;

    public Presentador(VistaPresentador vistaPresentador) {
        this.vistaPresentador = vistaPresentador;
        modelo = new Modelo();
    }

    public void evaluarContraseña(String password) {
        int nivelValidacion = modelo.validarClave(password);

        if (nivelValidacion == Modelo.DEBIL) {
            this.vistaPresentador.mostrarClaveDebil();

        } else if (nivelValidacion == Modelo.MEDIA) {
            this.vistaPresentador.mostrarClaveMedia();

        } else if (nivelValidacion == Modelo.FUERTE) {
            this.vistaPresentador.mostrarClaveFuerte();

        } else {
            this.vistaPresentador.mostrarClaveError();
        }
    }
}
