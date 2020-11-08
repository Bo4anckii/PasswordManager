package passwordmanager.ui.generator;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.stage.Modality;
import javafx.stage.Stage;
import passwordmanager.Main;
import passwordmanager.ui.add.AddController;
import passwordmanager.utils.generator.Generator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {

    public AddController addController;
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
    public Button selectBtn;
    private final GeneratorModel model = new GeneratorModel();
    private Generator generator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.setAmount(4);
        model.setMin(4);
        model.setMax(4);
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
        selectBtn.setOnAction(event -> selectPassword());
    }

    private ObservableList<String> generatePasswords() {
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

    private void selectPassword() {
        String password = passwordList.getSelectionModel().getSelectedItem();
        addController.setPassword(password);
        ((Stage) (selectBtn.getScene().getWindow())).close();
    }
}
