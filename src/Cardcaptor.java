public class Cardcaptor {

    static final int MELLY_CARD = 7763;
    static final int MOOP_CARD = 9704;
    static final int MOOP_CARD_1 = 6025;
    static final int MOOP_CARD_2 = 8307;
    static final int MEEP_CARD = 1684;
    static final int RAI_CARD = 7398;

    public static Name getName(int card) {
        return switch (card) {
            case MELLY_CARD -> Name.melly;
            case MOOP_CARD, MOOP_CARD_1, MOOP_CARD_2 -> Name.moopy;
            case MEEP_CARD -> Name.chelly;
            case RAI_CARD -> Name.rai;
            default -> Name.GUEST;
        };
    }
}
