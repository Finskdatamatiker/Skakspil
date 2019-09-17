public class ReglerHandler {

    private Brik[][] braetMedBrikker;

    public ReglerHandler(Brik[][] braetMedBrikker) {
        this.braetMedBrikker = braetMedBrikker;
    }

    /**
     * Er det muligt at gaa 1 eller 2 felter frem uden at slaa nogen?
     * Tjek: er det en Bonde?
     * Slutfelt inde i braettet?
     * Er forskellen fra start til slut 1 eller 2?
     * Hvis brikken er hvid, tjek om feltet lige foran er tomt
     * Else er brikken sort, så tjek, om feltet lige foran er tomt
     * Der er forskel, fordi kommer fra forskellige retninger
     * @param slutfelt feltet hvor brikken vil gaa
     * @param brik
     * @return
     */
    public boolean muligtGaaFremUdenAtSlaaBonde(Felt slutfelt, Brik brik) {
        if (brik instanceof Bonde) {
            Felt iVejenForSort = new Felt(brik.getFelt().getX() + 1, brik.getFelt().getY());
            Felt iVejenForHvid = new Felt(brik.getFelt().getX() - 1, brik.getFelt().getY());
            int forskel = Math.abs(slutfelt.getX() - brik.getFelt().getX());

            if (slutfelt.getX() > 0 & slutfelt.getX() < 8) {
                if (forskel > 0 && forskel < 3) {
                      if(!brik.isErSort()) return this.erFeltetTomt(iVejenForHvid);
                      else return this.erFeltetTomt(iVejenForSort);
              }
            }
         }
        return false;
    }

    /**
     * Er det muligt at slaa?
     * Tjek:er det en Bonde?
     * Tager bonden et skridt frem og et til venster / til hoejre?
     * Slutfeltet inde i braettet?
     * Er det en modstander, som staar på feltet? Metoden indeholder først tjek, om feltet er tomt. Ellers kan man ikke slaa.
     * @param slutfelt feltet, hvor brikken vil gaa hen
     * @return
     */
    public boolean muligtAtSlaaBonde(Felt slutfelt, Brik brik) {
        if (brik instanceof Bonde) {
            int forskelX = Math.abs(slutfelt.getX() - brik.getFelt().getX());
            int forskelY = Math.abs(slutfelt.getY() - brik.getFelt().getY());
            if (forskelX == 1 && forskelY == 1) {
                if (slutfelt.getX() > 0 & slutfelt.getX() < 8) {
                        if (!this.staarDerSammeFarve(slutfelt, brik)) {
                            return true;
                        }
                }
            }
        }
        return false;
    }

        //tjekker, om feltet er tomt
        public boolean erFeltetTomt (Felt slutfelt){
            if (braetMedBrikker[slutfelt.getX()][slutfelt.getY()] instanceof Tom) return true;
            return false;
        }

        //staar der modstander på slutfeltet? Forudsaetter foerst test, om feltet er tomt
        //slutfelt = der, hvor modstander staar
        public boolean staarDerSammeFarve (Felt slutfelt, Brik brik) {
            if (!this.erFeltetTomt(slutfelt)) {
                boolean erModstanderSort = braetMedBrikker[slutfelt.getX()][slutfelt.getY()].isErSort();
                return erModstanderSort == brik.isErSort();
            }
                return false;
        }
}

