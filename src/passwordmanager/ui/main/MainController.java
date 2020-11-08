package passwordmanager.ui.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import passwordmanager.db.AccountDao;
import passwordmanager.db.AccountDaoImpl;
import passwordmanager.models.Account;

public class MainController implements Initializable {
    public TextField searchTF;
    public Button addButton;
    public TableView<Account> table;
    public TableColumn<Account, String> accountName;
    public TableColumn<Account, String> accountLogin;
    public TableColumn<Account, String> accountPassword;
    public TableColumn<Account, String> accountEmail;
    public TableColumn<Account, String> accountURL;
    public Button refreshButton;
    public Button deleteButton;
    private final AccountDao accountDao = new AccountDaoImpl();
    private final MainModel model = new MainModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        addButton.setOnAction(event -> showAddView());
        refreshButton.setOnAction(event -> updateData());
        deleteButton.setOnAction(event -> deleteAccount());
        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {
            model.searchText = searchTF.getText();
            filterData();
        });
    }

    private void initTable() {
        accountName.setCellValueFactory(new PropertyValueFactory<>("name"));
        accountLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        accountPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        accountEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        accountURL.setCellValueFactory(new PropertyValueFactory<>("url"));
        updateData();
    }

    private void showAddView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/add_view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Добавление аккаунта");
            stage.setScene(new Scene(root, 340, 190));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateData() {
        System.out.println("Update Data");
        model.accounts = accountDao.getAccounts();
        table.getItems().setAll(model.accounts);
    }

    private void filterData() {
        ObservableList<Account> filteredList = FXCollections.observableArrayList();
        for (Account acc : model.accounts) {
            if (acc.getName().contains(searchTF.getText())) {
                filteredList.add(acc);
            }
        }
        table.setItems(filteredList);
    }

    private void deleteAccount() {
        accountDao.deleteAccount(table.getSelectionModel().getSelectedItem());
        updateData();
    }
}
