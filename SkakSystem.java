/**
 * @author Paivi
 * @since 18.9.19
 */
public class SkakSystem {

    public static void main(String[] args) {
        /**
        * Der mangler stadig menu, hvor man kan spoerge spilleren, hvordan hun/han vil traekke. 
        */

        Braet braet = new Braet();
        braet.printBraet();
        braet.printForkortelser();
        Brik brik = braet.getBraetMedBrikker()[1][2];
        System.out.println("Omgang 1\n");
        System.out.println("Brikken, som skal rykkes : " + brik + " , som staar paa feltet: "+ brik.getFelt().getX() + "," + brik.getFelt().getY());
        ReglerHandler reglerHandler = new ReglerHandler(braet.getBraetMedBrikker());

        Felt slutfelt = new Felt(3,2);
        System.out.println("Brikken vil gaa til feltet: " + slutfelt.getX() + "," + slutfelt.getY());
        System.out.println("Er det muligt at gaa? " + reglerHandler.muligtGaaFremUdenAtSlaaBonde(slutfelt,brik));
        System.out.println("Er det muligt at slaa?  " + reglerHandler.muligtAtSlaaBonde(slutfelt,brik));
        Brik brikPaaSlutfelt = braet.getBraetMedBrikker()[3][2];
        reglerHandler.bytToBrikker(braet.getBraetMedBrikker(),brik,brikPaaSlutfelt);
        System.out.println("\nVi gaar \n");
        braet.printBraet();

        System.out.println("\nOmgang 2\n");

        slutfelt.setX(4);
        slutfelt.setY(2);
        brikPaaSlutfelt = braet.getBraetMedBrikker()[4][2];
        System.out.println("Brikken, som skal rykkes : " + brik + " , som staar paa feltet: "+ brik.getFelt().getX() + "," + brik.getFelt().getY());
        System.out.println("Muligt at gaa? " + reglerHandler.muligtGaaFremUdenAtSlaaBonde(slutfelt, brik));
        System.out.println("Muligt at slaa?  " + reglerHandler.muligtAtSlaaBonde(slutfelt,brik));
        reglerHandler.bytToBrikker(braet.getBraetMedBrikker(),brik, brikPaaSlutfelt);
        System.out.println("\nVi gaar\n");
        braet.printBraet();

        System.out.println("\nOmgang 3");

        slutfelt.setX(5);
        slutfelt.setY(2);
        brikPaaSlutfelt = braet.getBraetMedBrikker()[5][2];
        System.out.println("Brikken som skal rykkes " + brik.getFelt().getX() + "," + brik.getFelt().getY() + " | " + brik.toString());
        System.out.println("Muligt at gaa? " + reglerHandler.muligtGaaFremUdenAtSlaaBonde(slutfelt, brik));
        System.out.println("Muligt at slaa?  " + reglerHandler.muligtAtSlaaBonde(slutfelt,brik));
        reglerHandler.bytToBrikker(braet.getBraetMedBrikker(),brik, brikPaaSlutfelt);
        System.out.println("\nVi slaar\n");
        braet.printBraet();

        System.out.println("\nOmgang 4\n");

        slutfelt.setX(6);
        slutfelt.setY(1);
        brikPaaSlutfelt = braet.getBraetMedBrikker()[6][1];
        System.out.println("Brikken som skal rykkes " + brik.getFelt().getX() + "," + brik.getFelt().getY() + "|" + brik.toString());
        System.out.println("Muligt at gaa? " + reglerHandler.muligtGaaFremUdenAtSlaaBonde(slutfelt, brik));
        System.out.println("Muligt at slaa?  " + reglerHandler.muligtAtSlaaBonde(slutfelt,brik));
        reglerHandler.brikkenDoer(braet.getBraetMedBrikker(),brikPaaSlutfelt);
        reglerHandler.bytToBrikker(braet.getBraetMedBrikker(),brik, brikPaaSlutfelt);

        System.out.println("\nVi slaar\n");

        braet.printBraet();

       System.out.println("\nOmgang 5\n");

        slutfelt.setX(7);
        slutfelt.setY(2);
        brikPaaSlutfelt = braet.getBraetMedBrikker()[7][2];
        System.out.println("Brikken som skal rykkes " + brik.getFelt().getX() + "," + brik.getFelt().getY() + " | " + brik.toString());
        System.out.println("Muligt at gaa? " + reglerHandler.muligtGaaFremUdenAtSlaaBonde(slutfelt, brik));
        System.out.println("Muligt at slaa?  " + reglerHandler.muligtAtSlaaBonde(slutfelt,brik));


        reglerHandler.brikkenDoer(braet.getBraetMedBrikker(),brikPaaSlutfelt);
        reglerHandler.bytToBrikker(braet.getBraetMedBrikker(),brik, brikPaaSlutfelt);
        reglerHandler.lavBondeTilDronning(braet.getBraetMedBrikker(),brik);

        System.out.println("\nVi slaar\n");
        braet.printBraet();

    }
}
