package passwordmanager.db;

import passwordmanager.models.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDaoImpl implements AccountDao{

    private DatabaseHandler databaseHandler = new DatabaseHandler();

    @Override
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();
        try (
                Statement statement = databaseHandler.getDbConnection().createStatement();
                ResultSet set = statement.executeQuery(Const.ACCOUNTS_GET_ALL);
        ) {
            while (set.next()) {
                accounts.add(new Account(
                        set.getLong(Const.ACCOUNT_ID),
                        set.getString(Const.ACCOUNT_NAME),
                        set.getString(Const.ACCOUNT_LOGIN),
                        set.getString(Const.ACCOUNT_PASSWORD),
                        set.getString(Const.ACCOUNT_EMAIL),
                        set.getString(Const.ACCOUNT_URL)
                ));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return accounts;
    }

    @Override
    public boolean addAccount(Account account) {
        String command = "INSERT INTO "+Const.ACCOUNTS_TABLE+"("+Const.ACCOUNT_ID+","+Const.ACCOUNT_NAME+","+
                Const.ACCOUNT_LOGIN+","+Const.ACCOUNT_PASSWORD+","+Const.ACCOUNT_EMAIL+","+Const.ACCOUNT_URL+") " +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(command);
            preparedStatement.setString(1, account.getId()+"");
            preparedStatement.setString(2, account.getName()+"");
            preparedStatement.setString(3, account.getLogin()+"");
            preparedStatement.setString(4, account.getPassword()+"");
            preparedStatement.setString(5, account.getEmail()+"");
            preparedStatement.setString(6, account.getUrl()+"");
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAccount(Account account) {
        String command = "DELETE FROM "+Const.ACCOUNTS_TABLE+" WHERE "+Const.ACCOUNT_ID+" = "+account.getId();
        try {
            Statement statement = databaseHandler.getDbConnection().createStatement();
            statement.executeUpdate(command);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
