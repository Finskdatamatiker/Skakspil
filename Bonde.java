public class Bonde extends Brik {

    public Bonde(char forkortelse, boolean erSort) {
        super(forkortelse, erSort);
    }

    Felt startfelt;// = new Felt(6,0);

    //TRAEK FOR HVIDE
    //rykker 1 frem
    Felt slutfelt1 = new Felt(startfelt.getX()-1, startfelt.getY());
    Traek traek1 = new Traek(startfelt,slutfelt1,false, false);
    //rykker 2 frem
    Felt slutfelt2 = new Felt(startfelt.getX()-2, startfelt.getY());
    Traek traek2 = new Traek(startfelt,slutfelt2,false, false);
    //rykker 1 til side mod hoejre og slaar
    Felt slutfelt3 = new Felt(startfelt.getX()-1, startfelt.getY() +1);
    Traek traek3 = new Traek(startfelt,slutfelt3,false,false);
    //rykker 1 til side mod venstre og slaar
    Felt slutfelt4 = new Felt(startfelt.getX()-1, startfelt.getY() -1);
    Traek traek4 = new Traek(startfelt,slutfelt3,false,false);

    Traek[] muligeTraekUdenAtSlaaHvide = {traek1, traek2};
    Traek[] muligeTraekOgSlaaHvide = {traek3, traek4};

    //TRAEK FOR SORTE
    //rykker 1 frem
    Felt slutfelt5 = new Felt(startfelt.getX()+1, startfelt.getY());
    Traek traek5 = new Traek(startfelt,slutfelt5,false, false);
    //rykker 2 frem
    Felt slutfelt6 = new Felt(startfelt.getX()+2, startfelt.getY());
    Traek traek6 = new Traek(startfelt,slutfelt6,false, false);
    //rykker 1 til side mod hoejre og slaar
    Felt slutfelt7 = new Felt(startfelt.getX()+1, startfelt.getY() -1);
    Traek traek7 = new Traek(startfelt,slutfelt7,false,false);
    //rykker 1 til side mod venstre og slaar
    Felt slutfelt8 = new Felt(startfelt.getX()+1, startfelt.getY() +1);
    Traek traek8 = new Traek(startfelt,slutfelt8,false,false);

    Traek[] muligeTraekUdenAtSlaaSorte = {traek5, traek6};
    Traek[] muligeTraekOgSlaaSorte = {traek7, traek8};






}
