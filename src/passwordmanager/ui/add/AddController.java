package passwordmanager.ui.add;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import passwordmanager.db.AccountDao;
import passwordmanager.db.AccountDaoImpl;
import passwordmanager.models.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    public TextField nameTF;
    public TextField loginTF;
    public TextField passwordTF;
    public TextField emailTF;
    public TextField urlTF;
    public Button addButton;
    public Button genButton;
    private final AccountDao accountDao = new AccountDaoImpl();
    private final AddModel model = new AddModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(event -> createNewAccount());
        genButton.setOnAction(event -> openGenerator());
    }

    private void createNewAccount() {
        Account account = new Account(
                System.currentTimeMillis(),
                nameTF.getText(),
                loginTF.getText(),
                passwordTF.getText(),
                emailTF.getText(),
                urlTF.getText()
        );
        accountDao.addAccount(account);
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    private void openGenerator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/generator_view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Генератор паролей");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}