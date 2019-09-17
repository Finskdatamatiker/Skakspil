
public class SkakSystem {

    public static void main(String[] args) {
        Braet braet = new Braet();
        braet.startOpstilling();
        braet.printBraet();
        braet.printForkortelser();
        ReglerHandler reglerHandler = new ReglerHandler(braet.getBraetMedBrikker());
        Brik brik = braet.getBraetMedBrikker()[1][2];
        System.out.println("Brikken hentet fra brættet: " + brik);
        System.out.println("Brikken staar på feltet: " + brik.getFelt().getX() + "," + brik.getFelt().getY());

        Felt slutfelt = new Felt(3,2);
        System.out.println("Brikken vil gaa til felt: " + slutfelt.getX() + "," + slutfelt.getY());
        System.out.println("Muligt at gaa: " + reglerHandler.muligtGaaFremUdenAtSlaaBonde(slutfelt,brik));
        System.out.println("Muligt at slaa:  " + reglerHandler.muligtAtSlaaBonde(slutfelt,brik));

    }
}
