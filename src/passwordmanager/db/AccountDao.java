package passwordmanager.db;

import passwordmanager.models.Account;

import java.util.ArrayList;

public interface AccountDao {
    ArrayList<Account> getAccounts();
    boolean addAccount(Account account);
    boolean deleteAccount(Account account);
}
