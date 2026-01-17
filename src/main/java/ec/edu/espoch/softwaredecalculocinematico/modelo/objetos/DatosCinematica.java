package ec.edu.espoch.softwaredecalculocinematico.modelo.objetos;

public class DatosCinematica {
    private String idDesc;
    private double coeficienteA;
    private double coeficienteB;
    private double coeficienteC;
    private double tiempo;

    public DatosCinematica() {
    }

    public String getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(String idDesc) {
        this.idDesc = idDesc;
    }

    public double getCoeficienteA() {
        return coeficienteA;
    }

    public void setCoeficienteA(double coeficienteA) {
        this.coeficienteA = coeficienteA;
    }

    public double getCoeficienteB() {
        return coeficienteB;
    }

    public void setCoeficienteB(double coeficienteB) {
        this.coeficienteB = coeficienteB;
    }

    public double getCoeficienteC() {
        return coeficienteC;
    }

    public void setCoeficienteC(double coeficienteC) {
        this.coeficienteC = coeficienteC;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "DatosCinematica{" + "idDesc=" + idDesc + ", A=" + coeficienteA + ", B=" + coeficienteB + ", C=" + coeficienteC + ", t=" + tiempo + '}';
    }
}