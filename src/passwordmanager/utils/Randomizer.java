package passwordmanager.utils;

public class Randomizer {

    private static final char[] russianAlphabetUpper = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    private static final char[] russianAlphabetLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    public static char randomLowerEng(){
        return (char)(97+Math.random()*25);
    }

    public static char randomUpperEng(){
        return (char)(65+Math.random()*25);
    }

    public static char randomLowerRus(){
        return russianAlphabetLower[(int)(Math.random()*33)];
    }

    public static char randomUpperRus(){
        return russianAlphabetUpper[(int)(Math.random()*33)];
    }

    public static char randomSymbol(){
        return (char)(33+Math.random()*15);
    }

    public static char randomDigit(){
        return (char)(48+Math.random()*10);
    }
}
