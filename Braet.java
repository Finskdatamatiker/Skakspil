/**
 * @author Paivi
 * @since 18.9.19
 */
public class Braet {

    private Brik[][] braetMedBrikker = new Brik[8][8];
    public Braet() { this.startOpstilling();}

    public Brik[][] getBraetMedBrikker() {
        return braetMedBrikker;
    }

    public void setBraetMedBrikker(Brik[][] braetMedBrikker) {
        this.braetMedBrikker = braetMedBrikker;
    }

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
            braetMedBrikker[1][i] = new Bonde('B', true, new Felt(1,i));
        }
        for (int i = 0; i < 8; i++) {
            braetMedBrikker[6][i] = new Bonde('B',false, new Felt(6,i));
        }
    }

    public void startOpstillingTomme() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                braetMedBrikker[i][j] = new Tom(' ', false, new Felt(i, j));
            }
        }
      }


    public void startOpstillingTaarn() {
        braetMedBrikker[0][0] = new Taarn('T',true, new Felt(0,0));
        braetMedBrikker[7][0] = new Taarn('T',false, new Felt(7,0));
        braetMedBrikker[0][7] = new Taarn('T',true, new Felt(0,7));
        braetMedBrikker[7][7] = new Taarn('T',false, new Felt(7,7));
    }

    public void startOpstillingSpringer() {
        braetMedBrikker[0][1] = new Springer('S',true, new Felt(0,1));
        braetMedBrikker[7][1] = new Springer('S',false, new Felt(7,1));
        braetMedBrikker[0][6] = new Springer('S',true, new Felt(0,6));
        braetMedBrikker[7][6] = new Springer('S',false, new Felt(7, 6));
    }

    public void startOpstillingLoeber() {
        braetMedBrikker[0][2] = new Loeber('L',true, new Felt(0,2));
        braetMedBrikker[7][2] = new Loeber('L',false, new Felt(7,2));
        braetMedBrikker[0][5] = new Loeber('L',true, new Felt(0,5));
        braetMedBrikker[7][5] = new Loeber('L',false, new Felt(7,5));
    }

    public void startOpstillingDronning() {
        braetMedBrikker[0][4] = new Dronning('D',true, new Felt(0,4));
        braetMedBrikker[7][4] = new Dronning('D',false, new Felt(7,4));
    }
    public void startOpstillingKonge() {
        this.braetMedBrikker[0][3] = new Konge('K',true, new Felt(0,3));
        this.braetMedBrikker[7][3] = new Konge('K',false, new Felt(7,3));
    }


    public void printBraet(){
        for (int i = 0; i < braetMedBrikker.length; i++) {
            for (int j = 0; j < braetMedBrikker[i].length; j++) {
                System.out.print(braetMedBrikker[i][j] + "\t|\t");
            }
            System.out.println("\n__________________________________________________________________________________________________");
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

