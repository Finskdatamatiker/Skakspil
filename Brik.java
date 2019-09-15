public class Brik {
    char forkortelse;
    boolean erSort;
    boolean erLevende;

    public Brik() {
    }

    public Brik(char forkortelse, boolean erSort) {
        this.forkortelse = forkortelse;
        this.erSort = erSort;
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

