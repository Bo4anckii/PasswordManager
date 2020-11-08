package passwordmanager.utils;

public class Randomizer {

    private static char[] russianAlphabetUpper = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    private static char[] russianAlphabetLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    public static char randomLowerEng(){
        System.out.println("LowerEng: "+(char)(97+Math.random()*25  ));
        return (char)(97+Math.random()*25);
    }

    public static char randomUpperEng(){
        System.out.println("UpperEng: "+(char)(65+Math.random()*26));
        return (char)(65+Math.random()*25);
    }

    public static char randomLowerRus(){
        return russianAlphabetLower[(int)(Math.random()*33)];
    }

    public static char randomUpperRus(){
        return russianAlphabetUpper[(int)(Math.random()*33)];
    }

    public static char randomSymbol(){
        System.out.println("Symbol: "+(char)(33+Math.random()*16));
        return (char)(33+Math.random()*15);
    }

    public static char randomDigit(){
        System.out.println("Digit: "+(char)(48+Math.random()*10));
        return (char)(48+Math.random()*10);
    }
}
