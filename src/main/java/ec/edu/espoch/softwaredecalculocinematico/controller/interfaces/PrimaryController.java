package ec.edu.espoch.softwaredecalculocinematico.controller.interfaces;

import ec.edu.espoch.softwaredecalculocinematico.controller.usecase.ControladorCinematica;
import ec.edu.espoch.softwaredecalculocinematico.modelo.objetos.DatosCinematica;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {
    
    @FXML private TextField txtDesc, txtA, txtB, txtC, txtT;
    @FXML private CheckBox cbSoloFunciones;
    @FXML private TableView<FilaTabla> tablaResultados;
    @FXML private TableColumn<FilaTabla, String> colID, colVf, colAf, colVn, colAn;

    private ControladorCinematica gestor;

    public PrimaryController() {
        this.gestor = new ControladorCinematica(this);
    }

    @FXML
    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colVf.setCellValueFactory(new PropertyValueFactory<>("velocidadFunc"));
        colAf.setCellValueFactory(new PropertyValueFactory<>("aceleracionFunc"));
        colVn.setCellValueFactory(new PropertyValueFactory<>("velocidadNum"));
        colAn.setCellValueFactory(new PropertyValueFactory<>("aceleracionNum"));
        
        txtT.disableProperty().bind(cbSoloFunciones.selectedProperty());
    }

    @FXML
    private void botonCalcular() {
        gestor.ejecutarCalculo(txtDesc.getText(), txtA.getText(), txtB.getText(), 
        txtC.getText(), txtT.getText(), cbSoloFunciones.isSelected());
    }

    @FXML
    private void botonLimpiar() {
        txtDesc.clear(); txtA.clear(); txtB.clear(); txtC.clear(); txtT.setText("0");
        cbSoloFunciones.setSelected(false);
    }

    @FXML
    private void botonEliminar() {
        FilaTabla seleccionado = tablaResultados.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Seleccione una fila de la tabla para eliminar.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Seguridad");
        dialog.setHeaderText("Confirmar eliminación");
        dialog.setContentText("Contraseña:");
        
        String clave = dialog.showAndWait().orElse("");
        if (clave.equals("admin123")) {
            tablaResultados.getItems().remove(seleccionado);
        } else {
            mostrarError("Contraseña incorrecta.");
        }
    }

    public void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void actualizarTabla(DatosCinematica datos, String resultado) {
        String[] partes = resultado.split(";");
        tablaResultados.getItems().add(new FilaTabla(
            datos.getIdDesc(), partes[0], partes[1], partes[2], partes[3]
        ));
    }

    public static class FilaTabla {
        private String descripcion;
        private String velocidadFunc;
        private String aceleracionFunc;
        private String velocidadNum;
        private String aceleracionNum;

        public FilaTabla(String desc, String vF, String aF, String vN, String aN) {
            this.descripcion = desc; 
            this.velocidadFunc = vF; 
            this.aceleracionFunc = aF; 
            this.velocidadNum = vN; 
            this.aceleracionNum = aN;
        }

        public String getDescripcion() { return descripcion; }
        public String getVelocidadFunc() { return velocidadFunc; }
        public String getAceleracionFunc() { return aceleracionFunc; }
        public String getVelocidadNum() { return velocidadNum; }
        public String getAceleracionNum() { return aceleracionNum; }
    }
}