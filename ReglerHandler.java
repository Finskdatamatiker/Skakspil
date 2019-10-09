import java.util.Arrays;

/**
 * @author Paivi
 * @since 18.9.19
 */
public class ReglerHandler {

    private Brik[][] braetMedBrikker;

    public ReglerHandler(Brik[][] braetMedBrikker) {
        this.braetMedBrikker = braetMedBrikker;
    }

    //tjekker, om slutfeltet og felterne frem til slutfeltet, er tomme, sådan at brikken kan gå frem til slutfeltet
    public boolean erMuligtAtGaa(Felt slutfelt, Brik brik) {
        Felt[] felterSomSkalTjekkes = hvilkeFelterTjekkesNaarGaar(slutfelt, brik);
        boolean svar = false;
        if(slutfelt.getX() <= brik.getFelt().getX()+felterSomSkalTjekkes.length && slutfelt.getY() == brik.getFelt().getY()){
        for (int i = 0; i < felterSomSkalTjekkes.length; i++) {
          if (erFeltetTomt(felterSomSkalTjekkes[i])){
              svar = true;
             }
          if (!erFeltetTomt(felterSomSkalTjekkes[i])){
              svar = false;
            }
         }
        }
        return svar;
    }

    //Returnerer de felter, som skal tjekkes, når brikken går frem, gemt i et array
    public Felt[] hvilkeFelterTjekkesNaarGaar(Felt slutfelt, Brik brik) {
        if (slutfelt.getX() >= 0 & slutfelt.getX() < 8) {
            int antalTilladteFelter = brik.getAntalTilladteFelterFrem();

            Felt[] felterTjekkesSort = new Felt[antalTilladteFelter];
            Felt[] felterTjekkesHvid = new Felt[antalTilladteFelter];

            for (int i = 0; i < antalTilladteFelter; i++) {
                felterTjekkesSort[i] = new Felt(brik.getFelt().getX() + i + 1, brik.getFelt().getY());
                felterTjekkesHvid[i] = new Felt(brik.getFelt().getX() - i - 1, brik.getFelt().getY());
            }
            if (brik.isErSort()) {
                return felterTjekkesSort;
            }
          return felterTjekkesHvid;
        }
        return null;
    }

    //tjekker, om der står en brik på det felt, som bonden vil slå og om brikken er modstander
    public boolean erMuligtAtSlaaBonde(Felt slutfelt, Brik brik) {
        int forskelX = slutfelt.getX() - brik.getFelt().getX();
        int forskelY = slutfelt.getY() - brik.getFelt().getY();

        if (slutfelt.getX() >= 0 & slutfelt.getX() < 8) {
            if (brik.isErSort()) {
                if (forskelX == 1 && (forskelY == -1 || forskelY == 1)) {
                    if (!this.staarDerSammeFarve(slutfelt, brik) && !this.erFeltetTomt(slutfelt)) {
                        return true;
                    } } }
            if (!brik.isErSort()) {
                if (forskelX == -1 && (forskelY == -1 || forskelY == 1)) {
                    if (!this.staarDerSammeFarve(slutfelt, brik) && !this.erFeltetTomt(slutfelt)) {
                        return true;
                    } } }
        }
        return false;
    }

    //tjekker, om feltet er tomt
    public boolean erFeltetTomt(Felt slutfelt) {
        if (braetMedBrikker[slutfelt.getX()][slutfelt.getY()] instanceof Tom) return true;
        return false;
    }

    //Tester, om der står en modstander, når man vil slå
    public boolean staarDerSammeFarve(Felt slutfelt, Brik brik) {
        if (!this.erFeltetTomt(slutfelt)) {
            boolean erModstanderSort = braetMedBrikker[slutfelt.getX()][slutfelt.getY()].isErSort();
            return erModstanderSort == brik.isErSort();
        }
        return false;
    }

    /*
     * Brikkers x og y skal byttes om.
     * Men vi skal også bytte deres pladser i todimensionel array.
     * Den ene brik skal gemmes i en midlertidig beholder, mens man bytter.
     */
    public void bytToBrikker(Brik[][] braetMedBrikker, Brik brik1, Brik slutfeltBrik) {

            int x = brik1.getFelt().getX();
            int y = brik1.getFelt().getY();
            int x2 = slutfeltBrik.getFelt().getX();
            int y2 = slutfeltBrik.getFelt().getY();

            brik1.getFelt().setX(x2);
            brik1.getFelt().setY(y2);
            slutfeltBrik.getFelt().setX(x);
            slutfeltBrik.getFelt().setY(y);

            Brik temp;
            temp = braetMedBrikker[x][y];
            braetMedBrikker[x][y] = braetMedBrikker[x2][y2];
            braetMedBrikker[x2][y2] = temp;
    }

    //Brikken laves til Tom, dvs. den doer
    public void brikkenDoer(Brik[][] braetMedBrikker, Brik brik) {
        braetMedBrikker[brik.getFelt().getX()][brik.getFelt().getY()] = new Tom(' ', false, new Felt(brik.getFelt().getX(), brik.getFelt().getY()));
    }

    //Bonden laves til Dronning i samma farve
    public void lavBondeTilDronning(Brik[][] braetMedBrikker, Brik brik) {
        if (braetMedBrikker[brik.getFelt().getX()][brik.getFelt().getY()] instanceof Bonde && (brik.getFelt().getX() == 7 || brik.getFelt().getX() == 0)) {
            braetMedBrikker[brik.getFelt().getX()][brik.getFelt().getY()] = new Dronning('D', brik.isErSort(), new Felt(brik.getFelt().getX(), brik.getFelt().getY()));
        }
    }
}





