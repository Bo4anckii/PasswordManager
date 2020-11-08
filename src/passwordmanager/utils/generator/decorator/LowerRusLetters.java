package passwordmanager.utils.generator.decorator;

import passwordmanager.utils.Randomizer;

public class LowerRusLetters extends PasswordDecorator{

    public LowerRusLetters(String password) {
        super(password);
    }

    @Override
    public String getPassword() {
        return addLowerRusLetters(super.getPassword());
    }

    private String addLowerRusLetters(String password){
        StringBuilder passwordBuilder = new StringBuilder(password);
        for(int i=0;i<password.length();i+=password.length()/4){
            passwordBuilder.setCharAt((int)(Math.random()*password.length()), Randomizer.randomLowerRus());
        }
        return passwordBuilder.toString();
    }
}
