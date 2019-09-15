public class Traek {
    Felt startfelt;
    Felt slutfelt;
    boolean brikIVejen;
    boolean forTaetPaaKant;

    public Traek() { }

    public Traek(Felt startfelt, Felt slutfelt, boolean brikIVejen, boolean forTaetPaaKant) {
        this.startfelt = startfelt;
        this.slutfelt = slutfelt;
        this.brikIVejen = brikIVejen;
        this.forTaetPaaKant = forTaetPaaKant;
    }
    @Override
    public String toString() {
        return startfelt + "-" + slutfelt;
    }
}
