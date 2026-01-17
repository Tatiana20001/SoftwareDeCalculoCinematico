package ec.edu.espoch.softwaredecalculocinematico.modelo.implementation;

import ec.edu.espoch.softwaredecalculocinematico.modelo.interfaces.ICalculadora;
import ec.edu.espoch.softwaredecalculocinematico.modelo.objetos.DatosCinematica;
import java.util.ArrayList;
import java.util.List;

public class Calculadora implements ICalculadora {
    
    private List<DatosCinematica> historial = new ArrayList<>();

    @Override
    public String calcularDatos(DatosCinematica cin, boolean soloFunciones) {
        //At^2+Bt+C
        String velocidadFunc = (2 * cin.getCoeficienteA()) + "t + " + cin.getCoeficienteB();
        String aceleracionFunc = String.valueOf(2 * cin.getCoeficienteA());

        if (soloFunciones) {
            return velocidadFunc + ";" + aceleracionFunc + ";---;---";
        } else {
            double velocidadResult = (2 * cin.getCoeficienteA() * cin.getTiempo()) + cin.getCoeficienteB();
            double aceleracionResult = 2 * cin.getCoeficienteA();
            return velocidadFunc + ";" + aceleracionFunc + ";" + velocidadResult + ";" + aceleracionResult;
        }
    }
    //Guarda el objeto en el arreglo
    @Override
    public void agregarAlHistorial(DatosCinematica cin) {
        this.historial.add(cin);
    }
    //Elimina el objeto 
    @Override
    public void eliminarDelHistorial(DatosCinematica cin) {
        this.historial.remove(cin);
    }
    // Permite que la vista vea los datos guardados
    @Override
    public List<DatosCinematica> obtenerHistorial() {
        return this.historial;
    }
}