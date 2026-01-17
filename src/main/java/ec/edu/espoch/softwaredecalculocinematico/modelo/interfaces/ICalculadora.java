package ec.edu.espoch.softwaredecalculocinematico.modelo.interfaces;

import ec.edu.espoch.softwaredecalculocinematico.modelo.objetos.DatosCinematica;
import java.util.List;

public interface ICalculadora {
    
    public String calcularDatos(DatosCinematica cinematica, boolean soloFunciones);

    public void agregarAlHistorial(DatosCinematica cinematica);

    public void eliminarDelHistorial(DatosCinematica cinematica);

    public List<DatosCinematica> obtenerHistorial();
}