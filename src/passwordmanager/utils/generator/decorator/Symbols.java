package passwordmanager.utils.generator.decorator;

import passwordmanager.utils.Randomizer;

public class Symbols extends PasswordDecorator{

    public Symbols(String password) {
        super(password);
    }

    @Override
    public String getPassword() {
        return addSymbols(super.getPassword());
    }

    private String addSymbols(String password){
        StringBuilder passwordBuilder = new StringBuilder(password);
        for(int i=0;i<password.length();i+=password.length()/4){
            passwordBuilder.setCharAt((int)(Math.random()*password.length()), Randomizer.randomSymbol());
        }
        return passwordBuilder.toString();
    }
}
