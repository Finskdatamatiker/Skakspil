/**
 * @author Paivi
 * @since 18.9.19
 */
public class Tom extends Brik{

    public Tom(char forkortelse, boolean erSort, Felt felt) {
        super(forkortelse, erSort, felt);
    }
    //p.s. tom er hvid per default, fordi boolen erSort er false som default i klassen Brik

    @Override
    public void setForkortelse(char forkortelse) {
        super.setForkortelse(' ');
    }

    @Override
    public String toString() {
        return "  \t";
    }
}
