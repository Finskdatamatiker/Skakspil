/**
 * @author Paivi
 * @since 18.9.19
 */
public class Bonde extends Brik {

    public Bonde(char forkortelse, boolean erSort, Felt felt) {
        super(forkortelse, erSort, felt);
    }
    //bonden kan bevæge sig 2 frem i først omgang, men ellers kun 1
    public int getAntalTilladteFelterFrem(){
        if((isErSort() && getFelt().getX() == 1) || (!isErSort() && getFelt().getX() == 6)){
            return 2;
        }
        return 1;
    }
}
