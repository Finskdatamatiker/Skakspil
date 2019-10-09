import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    Scanner console = new Scanner(System.in);
    Braet braet = new Braet();
    Brik bonde1 = braet.getBraetMedBrikker()[0][0];
    ReglerHandler reglerHandler = new ReglerHandler(braet.getBraetMedBrikker());

    boolean koer = true;

    public void koermenu() {

        while (koer) {
            System.out.println(visMenu());
            tjekAtErInt();

            int valg = console.nextInt();

            if (valg == 0) {
                System.out.println("Afslutter programmet");
                koer = false;
            } else if (valg == 1) {
                //det er kun i første omgang, at vi spørger, hvor bonden står
                if (bonde1.getFelt().getX() == 0 && bonde1.getFelt().getY() == 0) {
                    braet.printBraet();
                    braet.printForkortelser();
                    System.out.println("Omgang 1: hvilket felt din bonde står på? Indtast x-koordinat i heltal");
                    tjekAtErInt();
                    int x = console.nextInt();
                    bonde1.getFelt().setX(x);

                    System.out.println("Indtast y-koordinat i heltal.");
                    tjekAtErInt();
                    int y = console.nextInt();
                    bonde1.getFelt().setY(y);
                    bonde1 = braet.getBraetMedBrikker()[x][y];
                }

                braet.printBraet();
                //her ved vi, hvor bonden står
                System.out.println("Brikken, som skal rykkes : " + bonde1 + " , som staar paa feltet: " + bonde1.getFelt().getX() + "," + bonde1.getFelt().getY());
                System.out.println("Hvilket felt vil du rykke til? Indtast x-koordinat i heltal");

                tjekAtErInt();
                int x2 = console.nextInt();

                System.out.println("Indtast y-koordinat i heltal");
                tjekAtErInt();
                int y2 = console.nextInt();

                Felt slutfelt = new Felt(x2, y2);

                System.out.println("Brikken vil gaa til feltet: " + slutfelt.getX() + "," + slutfelt.getY());

                boolean muligtAtGaa = reglerHandler.erMuligtAtGaa(slutfelt, bonde1);
                boolean muligtAtSlaa = reglerHandler.erMuligtAtSlaaBonde(slutfelt, bonde1);
                System.out.println("Er det muligt at gaa til slutfeltet? " + muligtAtGaa);
                System.out.println("Er det muligt at slaa?  " + muligtAtSlaa);
                boolean hvadGoerDu = true;
                while (hvadGoerDu) {
                    if (muligtAtGaa) {
                        System.out.println("Vil du gå? 1 = ja, 2 = nej");
                        tjekAtErInt();
                        int svar = console.nextInt();
                        if (svar == 1) {
                            Brik brikPaaSlutfelt = braet.getBraetMedBrikker()[slutfelt.getX()][slutfelt.getY()];
                            reglerHandler.bytToBrikker(braet.getBraetMedBrikker(), bonde1, brikPaaSlutfelt);
                            System.out.println("\nVi gaar \n");
                            braet.printBraet();
                            hvadGoerDu = false;
                        } else {
                            hvadGoerDu = false;
                        }
                    }
                    if (!muligtAtGaa) {
                        System.out.println("Du kan ikke gaa");
                        hvadGoerDu = false;
                    }
                    if (muligtAtSlaa) {
                        System.out.println("Vil du slå? 1 = ja, 2 = nej");
                        tjekAtErInt();
                        int svar = console.nextInt();
                        if (svar == 1) {
                            Brik brikPaaSlutfelt = braet.getBraetMedBrikker()[slutfelt.getX()][slutfelt.getY()];
                            //reglerHandler.brikkenDoer(braet.getBraetMedBrikker(),brikPaaSlutfelt);
                            reglerHandler.bytToBrikker(braet.getBraetMedBrikker(), bonde1, brikPaaSlutfelt);
                            reglerHandler.brikkenDoer(braet.getBraetMedBrikker(), brikPaaSlutfelt);
                            reglerHandler.lavBondeTilDronning(braet.getBraetMedBrikker(), bonde1);
                            System.out.println("\nVi slaar \n");
                            braet.printBraet();
                            hvadGoerDu = false;

                        } else hvadGoerDu = false;
                    }
                    if (!muligtAtSlaa) {
                        System.out.println("Du kan ikke slå");
                        hvadGoerDu = false;
                    }
                }
            } else {
                System.out.println("Vælg et af menupunkterne.\n");
            }
        }
    }

    public void spoergHvilkenBonde(Brik bonde1) {
        braet.printBraet();
        braet.printForkortelser();
        System.out.println("Omgang 1: hvilket felt din bonde står på? Indtast x-koordinat i heltal");

        while (!console.hasNextInt()) {
            String enter = console.next();
            String forkertIndtastning = console.nextLine();
            System.out.println("Skriv et heltal.");
        }
        int x = console.nextInt();
        bonde1.getFelt().setX(x);

        System.out.println("Indtast y-koordinat i heltal");
        while (!console.hasNextInt()) {
            String enter = console.next();
            String forkertIndtastning = console.nextLine();
            System.out.println("Skriv et heltal.");
        }
        int y = console.nextInt();
        bonde1.getFelt().setY(y);

    }

    public void tjekAtErInt() {
        while (!console.hasNextInt()) {
            String enter = console.next();
            String forkertIndtastning = console.nextLine();
            System.out.println("Skriv et heltal.");
        }
    }
    public String visMenu() {
        String menu = "\nVelkommen til programmet!\n";
        menu += "1. Træk bonde nr. 1\n";
        menu += "0. Sluk programmet\n";
        return menu;
    }
}
