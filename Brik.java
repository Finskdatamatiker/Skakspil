public abstract class Brik {
    Felt felt;
    char forkortelse;
    boolean erSort;
    boolean erLevende = true;

    public Brik() {
    }

    public Brik(char forkortelse, boolean erSort, Felt felt) {
        this.forkortelse = forkortelse;
        this.erSort = erSort;
        this.felt = felt;
    }

    public char getForkortelse() { return forkortelse; }
    public void setForkortelse(char forkortelse) { this.forkortelse = forkortelse; }
    public boolean isErSort() { return erSort; }
    public void setErSort(boolean erSort) { this.erSort = erSort;}

    public String toString() {
        String besked = "";
        if(erSort == true) besked = forkortelse + "-sort";
        if(erSort == false) besked = forkortelse + "-hvid";
        return besked;
    }
}

