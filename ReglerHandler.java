/**
 * @author Paivi
 * @since 18.9.19
 */
public class ReglerHandler {
    /**
     * Der mangler reglen om, at det kun er foerste omgang, at bonden kan tage 2 skridt.
     * Nu kan bondentage 1 eller 2 skrift og den kan slaa.
     */

    private Brik[][] braetMedBrikker;

    public ReglerHandler(Brik[][] braetMedBrikker) {
        this.braetMedBrikker = braetMedBrikker;
    }

    /**
     * Er det muligt at gaa 1 eller 2 felter frem uden at slaa nogen?
     * Foerst gemmes felter frem til slutfeltet i to arrays. Den ene for de sorte, den anden for de hvide.
     * Det er for at kunne genbruge metoden kun med smaa justeringer, naar fx taarn skal rykke frem og der er
     * flere felter på vejen til slutfeltet. Dem kan vi loope i denne samme metode.
     * Slutfelt inde i braettet?
     * max 2 skridt frem
     * Hvis brikken er sort: vi tjekker om felterne er tomme frem til slutfeltet
     * Hvis brikken er hvid: vi tjekker det samme
     * @param slutfelt feltet hvor brikken vil gaa
     * @param brik
     * @return om det er muligt at gaa
     */
        public boolean muligtGaaFremUdenAtSlaaBonde(Felt slutfelt, Brik brik) {
            int antalFelterFrem = Math.abs(slutfelt.getX()-brik.getFelt().getX());
            Felt[] felterIVejenForSort = new Felt[antalFelterFrem];
            Felt[] felterIVejenForHvid = new Felt[antalFelterFrem];
            for(int i = 0; i < antalFelterFrem; i++){
                felterIVejenForSort[i] = new Felt(brik.getFelt().getX() + i+1, brik.getFelt().getY());
                felterIVejenForHvid[i] = new Felt(brik.getFelt().getX() + i-1, brik.getFelt().getY());
            }
            boolean svar = false;
            if (slutfelt.getX() >= 0 & slutfelt.getX() < 8) {
                if(antalFelterFrem < 3){
                    if (brik.isErSort()) {
                        for (int i = 0; i < felterIVejenForSort.length; i++) {
                            if (erFeltetTomt(felterIVejenForSort[i])){
                                svar = true;
                            }
                        }
                     }
                      if (!brik.isErSort()) {
                        for (int i = 0; i<felterIVejenForHvid.length; i++) {
                            if (erFeltetTomt(felterIVejenForHvid[i])) {
                                svar = true;
                            }
                        }
                    } }
            }
        return svar;
    }

    public boolean muligtAtSlaaBonde(Felt slutfelt, Brik brik) {

            int forskelX = slutfelt.getX() - brik.getFelt().getX();
            int forskelY = slutfelt.getY() - brik.getFelt().getY();

            if (slutfelt.getX() >= 0 & slutfelt.getX() < 8) {
                if (brik.isErSort()) {
                    if (forskelX == 1 && (forskelY == -1 || forskelY == 1)) {
                        if (!this.staarDerSammeFarve(slutfelt, brik)) {
                            return true;
                        } } }
                    if (!brik.isErSort()) {
                    if (forskelX == -1 && (forskelY == -1 || forskelY == 1)) {
                        if (!this.staarDerSammeFarve(slutfelt, brik)) {
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

         /*Den tidlige version for sikkerheds skyld
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
    }*/

    /**
     * Er det muligt at slaa?
     * Slutfelt inde i braettet?
     * Hvis bonden sort: x maa vaere 1 stoerre, y maa vaere 1 mindre eller 1 stoerre (slaa skraadt)
     * Er det en modstander, som staar på feltet? Metoden indeholder først tjek, om feltet er tomt. Ellers kan man ikke slaa.
     * @param slutfelt feltet, hvor brikken vil gaa hen
     * @return boolean, om det er mulidt at slaa
     */
    }





