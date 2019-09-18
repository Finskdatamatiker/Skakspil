/**
 * @author Paivi
 * @since 18.9.19
 */
public class Brik {
    private Felt felt;
    private char forkortelse;
    private boolean erSort;
    private boolean erLevende = true;

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
    public Felt getFelt() {
        return felt;
    }
    public void setFelt(Felt felt) {
        this.felt = felt;
    }
    public boolean isErLevende() {
        return erLevende;
    }
    public void setErLevende(boolean erLevende) {
        this.erLevende = erLevende;
    }

    public String toString() {
        String besked = "";
        if(erSort == true) besked = forkortelse + "-sort";
        if(erSort == false) besked = forkortelse + "-hvid";
        return besked;
    }
}

