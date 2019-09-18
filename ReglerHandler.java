/**
 * @author Paivi
 * @since 18.9.19
 */
public class ReglerHandler {
    /**
     * Glemte reglen, om at det kun er 1. omgang, at bonden kan tage 2 skridt.
     * Nu kan bonden tage 1 eller 2 skrift, slaa og blive til dronning til sidst.
     * Tanken er, at man kan genbruge reglerne med modifikationer med de andre brikker.  
     */

    private Brik[][] braetMedBrikker;

    public ReglerHandler(Brik[][] braetMedBrikker) {
        this.braetMedBrikker = braetMedBrikker;
    }

    /**
     * Er det muligt at gaa 1 eller 2 felter frem uden at slaa nogen?
     * Tjek: er det en Bonde?
     * Slutfelt inde i braettet?
     * Hvis brikken er sort: forskellen på x skal vaere 1 eller 2
     * Hvis brikken er hvid: forskellen på x skal vaere -1 eller -2
     * Er feltet paa ruten tom?
     * @param slutfelt feltet hvor brikken vil gaa
     * @param brik
     * @return om det er muligt at gaa
     */
    public boolean muligtGaaFremUdenAtSlaaBonde(Felt slutfelt, Brik brik) {
        if (brik instanceof Bonde) {
            Felt iVejenForSort = new Felt(brik.getFelt().getX() + 1, brik.getFelt().getY());
            Felt iVejenForHvid = new Felt(brik.getFelt().getX() - 1, brik.getFelt().getY());
            int forskelX = slutfelt.getX() - brik.getFelt().getX();

            if (slutfelt.getX() > 0 & slutfelt.getX() < 8) {
                if (brik.isErSort()) {
                    if (forskelX > 0 && forskelX < 3) {
                        if (erFeltetTomt(iVejenForSort)) return true;
                    } }
                else if (!brik.isErSort()) {
                    if ((forskelX < 0 && forskelX > -3)) {
                        if (erFeltetTomt(iVejenForHvid)) return true;
                    } }
            }
        }
        return false;
    }

    /**
     * Er det muligt at slaa?
     * Tjek:er det en Bonde?
     * Slutfelt inde i braettet?
     * Hvis bonden sort: x maa vaere 1 stoerre, y maa vaere 1 mindre eller 1 stoerre (slaa skraadt)
     * Er det en modstander, som staar på feltet? Metoden indeholder først tjek, om feltet er tomt. Ellers kan man ikke slaa.
     * @param slutfelt feltet, hvor brikken vil gaa hen
     * @return boolean, om det er mulidt at slaa
     */
    public boolean muligtAtSlaaBonde(Felt slutfelt, Brik brik) {

        if (brik instanceof Bonde) {

            int forskelX = slutfelt.getX() - brik.getFelt().getX();
            int forskelY = slutfelt.getY() - brik.getFelt().getY();

            if (slutfelt.getX() > 0 & slutfelt.getX() < 8) {
                if (brik.isErSort()) {
                    if (forskelX == 1 && (forskelY == -1 || forskelY == 1)) {
                        if (!this.staarDerSammeFarve(slutfelt, brik)) {
                            return true;
                        } } }
                else if (!brik.isErSort()) {
                    if (forskelX == -1 && (forskelY == -1 || forskelY == 1)) {
                        if (!this.staarDerSammeFarve(slutfelt, brik)) {
                            return true;
                        } } }
            }

        }
        return false;
    }

    //tjekker, om feltet er tomt
    public boolean erFeltetTomt(Felt slutfelt) {
        if (braetMedBrikker[slutfelt.getX()][slutfelt.getY()] instanceof Tom) return true;
        return false;
    }

    //staar der modstander på slutfeltet? Forudsaetter foerst test, om feltet er tomt
    //slutfelt = der, hvor modstander staar
    public boolean staarDerSammeFarve(Felt slutfelt, Brik brik) {
        if (!this.erFeltetTomt(slutfelt)) {
            boolean erModstanderSort = braetMedBrikker[slutfelt.getX()][slutfelt.getY()].isErSort();
            return erModstanderSort == brik.isErSort();
        }
        return false;
    }

    /**
     * Brikkers x og y skal byttes om.
     * Men vi skal også bytte deres pladser i todimensionel array.
     * Den ene brik skal gemmes i en midlertidig beholder, mens man bytter.
     * @param braetMedBrikker
     * @param brik1
     * @param brik2
     */
    public void bytToBrikker(Brik[][] braetMedBrikker, Brik brik1, Brik brik2) {

            int x = brik1.getFelt().getX();
            int y = brik1.getFelt().getY();
            int x2 = brik2.getFelt().getX();
            int y2 = brik2.getFelt().getY();

            brik1.getFelt().setX(x2);
            brik1.getFelt().setY(y2);
            brik2.getFelt().setX(x);
            brik2.getFelt().setY(y);

            Brik temp;
            temp = braetMedBrikker[x][y];
            braetMedBrikker[x][y] = braetMedBrikker[x2][y2];
            braetMedBrikker[x2][y2] = temp;
    }

    /**
     * Brikken laves til Tom, dvs. den doer
     * @param braetMedBrikker
     * @param brik
     */
    public void brikkenDoer(Brik[][] braetMedBrikker, Brik brik){
        braetMedBrikker[brik.getFelt().getX()][brik.getFelt().getY()] = new Tom(' ', false, new Felt(brik.getFelt().getX(), brik.getFelt().getY()));
    }

    /**
     * Bonden laves til Dronning i samma farve
     * @param braetMedBrikker
     * @param brik
     */
    public void lavBondeTilDronning(Brik[][] braetMedBrikker, Brik brik) {
            braetMedBrikker[brik.getFelt().getX()][brik.getFelt().getY()] = new Dronning('D', brik.isErSort(), new Felt(brik.getFelt().getX(), brik.getFelt().getY()));
        }
    }





