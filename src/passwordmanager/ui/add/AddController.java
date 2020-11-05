package passwordmanager.ui.add;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import passwordmanager.db.AccountDao;
import passwordmanager.db.AccountDaoImpl;
import passwordmanager.models.Account;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    public TextField nameTF;
    public TextField loginTF;
    public TextField passwordTF;
    public TextField emailTF;
    public TextField urlTF;
    public Button addButton;
    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(event -> createNewAccount());
    }

    private void createNewAccount(){
        Account account = new Account(
                System.currentTimeMillis(),
                nameTF.getText(),
                loginTF.getText(),
                passwordTF.getText(),
                emailTF.getText(),
                urlTF.getText()
        );
        accountDao.addAccount(account);
        Stage stage = (Stage)addButton.getScene().getWindow();
        stage.close();
    }
}