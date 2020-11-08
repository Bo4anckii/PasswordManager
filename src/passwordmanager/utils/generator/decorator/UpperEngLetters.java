package passwordmanager.utils.generator.decorator;

import passwordmanager.utils.Randomizer;

public class UpperEngLetters extends PasswordDecorator{

    public UpperEngLetters(String password) {
        super(password);
    }

    @Override
    public String getPassword() {
        return addLowerEngLetters(super.getPassword());
    }

    private String addLowerEngLetters(String password){
        StringBuilder passwordBuilder = new StringBuilder(password);
        for(int i=0;i<password.length();i+=password.length()/4){
            passwordBuilder.setCharAt((int)(Math.random()*password.length()), Randomizer.randomUpperEng());
        }
        return passwordBuilder.toString();
    }
}
