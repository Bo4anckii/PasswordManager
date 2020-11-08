package passwordmanager.utils.generator;

import passwordmanager.utils.Randomizer;
import passwordmanager.utils.generator.decorator.*;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private final int min;
    private final int max;
    private final int amount;
    private final boolean letterFirst;
    private final boolean lowerEng;
    private final boolean upperEng;
    private final boolean digits;
    private final boolean symbols;
    private final boolean lowerRus;
    private final boolean upperRus;

    public Generator(int min, int max, int amount, boolean letterFirst, boolean lowerEng, boolean upperEng, boolean digits, boolean symbols, boolean lowerRus, boolean upperRus) {
        this.min = min;
        this.max = max;
        this.amount = amount;
        this.letterFirst = letterFirst;
        this.lowerEng = lowerEng;
        this.upperEng = upperEng;
        this.digits = digits;
        this.symbols = symbols;
        this.lowerRus = lowerRus;
        this.upperRus = upperRus;
    }

    public ArrayList<String> generatePasswords(){
        ArrayList<String> passwords = new ArrayList<>();
        for(int i=0;i<amount;i++){
            String newPassword = initPassword((int)(min+Math.random()*max));
            if(lowerEng){
                newPassword = new LowerEngLetters(newPassword).getPassword();
            }
            if(upperEng){
                newPassword = new UpperEngLetters(newPassword).getPassword();
            }
            if(lowerRus){
                newPassword = new LowerRusLetters(newPassword).getPassword();
            }
            if(upperRus) {
                newPassword = new UpperRusLetters(newPassword).getPassword();
            }
            if(digits){
                newPassword = new Digits(newPassword).getPassword();
            }
            if(symbols){
                newPassword = new Symbols(newPassword).getPassword();
            }
            if(letterFirst){
                newPassword = ((char)(97+(int)(Math.random()*25)))+newPassword.substring(1);
            }
            passwords.add(newPassword);
        }
        return passwords;
    }

    private String initPassword(int length){
        char[] pass = new char[length];
        for(int i=0; i<length;i++){
            if(lowerRus) {
                pass[i]= Randomizer.randomLowerRus();
            } else if(upperRus){
                pass[i]= Randomizer.randomUpperRus();
            } else if(upperEng){
                pass[i]= Randomizer.randomUpperEng();
            } else {
                pass[i]= Randomizer.randomLowerEng();
            }
        }
        return String.copyValueOf(pass);
    }
}