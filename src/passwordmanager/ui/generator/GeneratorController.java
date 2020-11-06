package passwordmanager.ui.generator;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {

    public Spinner<Integer> lengthFromSpinner;
    public Spinner<Integer> lengthToSpinner;
    public Spinner<Integer> amount;
    public CheckBox firstLetterCB;
    public CheckBox lowerEngCB;
    public CheckBox upperEngCB;
    public CheckBox digitsCB;
    public CheckBox symbolsCB;
    public CheckBox lowerRusCB;
    public CheckBox upperRusCB;
    public CheckBox similarCB;
    public ListView<String> passwordList;
    public Button generateBtn;
    private final GeneratorModel model = new GeneratorModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
