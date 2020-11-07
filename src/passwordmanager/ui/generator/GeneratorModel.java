package passwordmanager.ui.generator;

public class GeneratorModel {
    private int min;
    private int max;
    private int amount;
    private boolean letterFirst;
    private boolean lowerEng;
    private boolean upperEng;
    private boolean digits;
    private boolean symbols;
    private boolean lowerRus;
    private boolean upperRus;
    private boolean removeSimilar;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isLetterFirst() {
        return letterFirst;
    }

    public void setLetterFirst(boolean letterFirst) {
        this.letterFirst = letterFirst;
    }

    public boolean isLowerEng() {
        return lowerEng;
    }

    public void setLowerEng(boolean lowerEng) {
        this.lowerEng = lowerEng;
    }

    public boolean isUpperEng() {
        return upperEng;
    }

    public void setUpperEng(boolean upperEng) {
        this.upperEng = upperEng;
    }

    public boolean isDigits() {
        return digits;
    }

    public void setDigits(boolean digits) {
        this.digits = digits;
    }

    public boolean isSymbols() {
        return symbols;
    }

    public void setSymbols(boolean symbols) {
        this.symbols = symbols;
    }

    public boolean isLowerRus() {
        return lowerRus;
    }

    public void setLowerRus(boolean lowerRus) {
        this.lowerRus = lowerRus;
    }

    public boolean isUpperRus() {
        return upperRus;
    }

    public void setUpperRus(boolean upperRus) {
        this.upperRus = upperRus;
    }

    public boolean isRemoveSimilar() {
        return removeSimilar;
    }

    public void setRemoveSimilar(boolean removeSimilar) {
        this.removeSimilar = removeSimilar;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
