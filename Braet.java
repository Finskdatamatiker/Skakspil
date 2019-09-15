
public class Braet {

    private Brik[][] braetMedBrikker = new Brik[8][8];
    public Braet() { }

   public void startOpstilling(){
        startOpstillingBonde();
        startOpstillingTomme();
        startOpstillingTaarn();
        startOpstillingSpringer();
        startOpstillingLoeber();
        startOpstillingDronning();
        startOpstillingKonge();
    }

    public void startOpstillingBonde() {
        for (int i = 0; i < 8; i++) {
            braetMedBrikker[1][i] = new Bonde('B', true);
        }
        for (int i = 0; i < 8; i++) {
            braetMedBrikker[6][i] = new Bonde('B',false);
        }
    }

    public void startOpstillingTomme() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                braetMedBrikker[i][j] = new Tom();
            }
        }
    }

    public void startOpstillingTaarn() {
        braetMedBrikker[0][0] = new Taarn('T',true);
        braetMedBrikker[7][0] = new Taarn('T',false);
        braetMedBrikker[0][7] = new Taarn('T',true);
        braetMedBrikker[7][7] = new Taarn('T',false);
    }

    public void startOpstillingSpringer() {
        braetMedBrikker[0][1] = new Springer('S',true);
        braetMedBrikker[7][1] = new Springer('S',false);
        braetMedBrikker[0][6] = new Springer('S',true);
        braetMedBrikker[7][6] = new Springer('S',false);
    }

    public void startOpstillingLoeber() {
        braetMedBrikker[0][2] = new Loeber('L',true);
        braetMedBrikker[7][2] = new Loeber('L',false);
        braetMedBrikker[0][5] = new Loeber('L',true);
        braetMedBrikker[7][5] = new Loeber('L',false);
    }

    public void startOpstillingDronning() {
        braetMedBrikker[0][4] = new Dronning('D',true);
        braetMedBrikker[7][4] = new Dronning('D',false);
    }
    public void startOpstillingKonge() {
        braetMedBrikker[0][3] = new Konge('K',true);
        braetMedBrikker[7][3] = new Konge('K',false);
    }

    public void printBraet(){
        for (int i = 0; i < braetMedBrikker.length; i++) {
            for (int j = 0; j < braetMedBrikker[i].length; j++) {
                System.out.print(braetMedBrikker[i][j] + "\t|\t");
            }
            System.out.println("\n______________________________________________________________________________________________");
        }
    }
    public void printForkortelser(){
        String forkortelse = "\nB = bonde\n";
        forkortelse += "T = taarn\n";
        forkortelse += "S = springer\n";
        forkortelse += "L = loeber\n";
        forkortelse += "K = konge\n";
        forkortelse += "D = dronning\n";
        System.out.println(forkortelse);
    }
}

