package passwordmanager.ui.generator;

import javafx.collections.FXCollections;
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
        lengthFromSpinner.setOnInputMethodTextChanged(event -> model.setMin(lengthFromSpinner.getValue()));
        lengthToSpinner.setOnInputMethodTextChanged(event -> model.setMax(lengthToSpinner.getValue()));
        amount.setOnInputMethodTextChanged(event -> model.setAmount(amount.getValue()));
        firstLetterCB.setOnAction(event -> model.setLetterFirst(firstLetterCB.isSelected()));
        lowerEngCB.setOnAction(event -> model.setLowerEng(lowerEngCB.isSelected()));
        upperEngCB.setOnAction(event -> model.setUpperEng(upperEngCB.isSelected()));
        digitsCB.setOnAction(event -> model.setDigits(digitsCB.isSelected()));
        symbolsCB.setOnAction(event -> model.setSymbols(symbolsCB.isSelected()));
        lowerRusCB.setOnAction(event -> model.setLowerRus(lowerRusCB.isSelected()));
        upperRusCB.setOnAction(event -> model.setUpperRus(upperRusCB.isSelected()));
        similarCB.setOnAction(event -> model.setRemoveSimilar(similarCB.isSelected()));
        generateBtn.setOnAction(event -> generatePassword());
    }

    private void generatePassword(){

    }
}
