package passwordmanager.utils.generator.decorator;


import passwordmanager.utils.Randomizer;

public class UpperRusLetters extends PasswordDecorator{

    public UpperRusLetters(String password) {
        super(password);
    }

    @Override
    public String getPassword() {
        return addLetters(super.getPassword());
    }

    private String addLetters(String password){
        StringBuilder passwordBuilder = new StringBuilder(password);
        for(int i=0;i<password.length();i+=password.length()/4){
            passwordBuilder.setCharAt((int)(Math.random()*password.length()), Randomizer.randomUpperRus());
        }
        return passwordBuilder.toString();
    }
}
