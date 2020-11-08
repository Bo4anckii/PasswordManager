package passwordmanager.utils.generator.decorator;

import passwordmanager.utils.Randomizer;

public class Digits extends PasswordDecorator{

    public Digits(String password) {
        super(password);
    }

    @Override
    public String getPassword() {
        return addDigits(super.getPassword());
    }

    private String addDigits(String password){
        StringBuilder passwordBuilder = new StringBuilder(password);
        for(int i=0;i<password.length();i+=password.length()/4){
            passwordBuilder.setCharAt((int)(Math.random()*password.length()), Randomizer.randomDigit());
        }
        return passwordBuilder.toString();
    }
}
