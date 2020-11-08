package passwordmanager.utils.generator.decorator;

public abstract class PasswordDecorator {
    private String password;

    public PasswordDecorator(String password){
        this.password=password;
    }

    public String getPassword() {
        return password;
    }
}
