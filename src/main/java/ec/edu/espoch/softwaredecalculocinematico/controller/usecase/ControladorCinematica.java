package ec.edu.espoch.softwaredecalculocinematico.controller.usecase;

import ec.edu.espoch.softwaredecalculocinematico.controller.interfaces.PrimaryController;
import ec.edu.espoch.softwaredecalculocinematico.modelo.implementation.Calculadora;
import ec.edu.espoch.softwaredecalculocinematico.modelo.interfaces.ICalculadora;
import ec.edu.espoch.softwaredecalculocinematico.modelo.objetos.DatosCinematica;

public class ControladorCinematica {
    private PrimaryController ventana;
    private ICalculadora miCalculadora;

    public ControladorCinematica(PrimaryController ventana) {
        this.ventana = ventana;
        this.miCalculadora = new Calculadora();
    }

    public void ejecutarCalculo(String descripcion, String coefA, String coefB, String coefC, String tiempo, boolean soloFunciones) {  
        // Validación con nombres 
        if (descripcion.isEmpty() || coefA.isEmpty() || coefB.isEmpty() || coefC.isEmpty() || (!soloFunciones && tiempo.isEmpty())) {
            ventana.mostrarError("Error: Hay campos vacíos. Por favor complete todos los datos.");
            return; 
        }

        try {
            DatosCinematica datos = new DatosCinematica();
            datos.setIdDesc(descripcion);
            datos.setCoeficienteA(Double.parseDouble(coefA));
            datos.setCoeficienteB(Double.parseDouble(coefB));
            datos.setCoeficienteC(Double.parseDouble(coefC));

            if (soloFunciones) {
                datos.setTiempo(0);
            } else {
                datos.setTiempo(Double.parseDouble(tiempo));
            }

            // La calculadora realiza el cálculo
            String respuesta = miCalculadora.calcularDatos(datos, soloFunciones);
            // Guarda el dato
            miCalculadora.agregarAlHistorial(datos);           
            //La ventana solo recibe la orden de mostrar
            ventana.actualizarTabla(datos, respuesta);

        } catch (NumberFormatException error) {
            ventana.mostrarError("Error de formato: Ha ingresado letras o símbolos en campos numéricos.");
        }
    }

    public void eliminarRegistro(DatosCinematica registro) {
        miCalculadora.eliminarDelHistorial(registro);
    }
}