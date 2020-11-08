package passwordmanager.ui.generator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import passwordmanager.utils.generator.Generator;

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
    public ListView<String> passwordList;
    public Button generateBtn;
    private final GeneratorModel model = new GeneratorModel();
    private Generator generator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.setAmount(5);
        model.setMin(5);
        model.setMax(5);
        lengthFromSpinner.valueProperty().addListener((observable, oldValue, newValue) -> model.setMin(newValue));
        lengthToSpinner.valueProperty().addListener((observable, oldValue, newValue) -> model.setMax(newValue));
        amount.valueProperty().addListener((observable, oldValue, newValue) -> model.setAmount(newValue));
        firstLetterCB.setOnAction(event -> model.setLetterFirst(firstLetterCB.isSelected()));
        lowerEngCB.setOnAction(event -> model.setLowerEng(lowerEngCB.isSelected()));
        upperEngCB.setOnAction(event -> model.setUpperEng(upperEngCB.isSelected()));
        digitsCB.setOnAction(event -> model.setDigits(digitsCB.isSelected()));
        symbolsCB.setOnAction(event -> model.setSymbols(symbolsCB.isSelected()));
        lowerRusCB.setOnAction(event -> model.setLowerRus(lowerRusCB.isSelected()));
        upperRusCB.setOnAction(event -> model.setUpperRus(upperRusCB.isSelected()));
        generateBtn.setOnAction(event -> passwordList.setItems(generatePasswords()));
    }

    private ObservableList<String> generatePasswords(){
        generator = new Generator(
                model.getMin(),
                model.getMax(),
                model.getAmount(),
                model.isLetterFirst(),
                model.isLowerEng(),
                model.isUpperEng(),
                model.isDigits(),
                model.isSymbols(),
                model.isLowerRus(),
                model.isUpperRus()
        );
        return FXCollections.observableList(generator.generatePasswords());
    }
}
