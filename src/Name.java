import java.util.Locale;

/**
 * Name enum stores and enumerates various names used throughout the program
 **/

public enum Name {
    chelly,
    melly,
    moopy,
    libby,
    rai,
    GUEST;

    public Name getName(String name) {
        return switch (name.toLowerCase(Locale.ROOT)) {
            case "chelly", "meep", "chel" -> chelly;
            case "melly", "mel" -> melly;
            case "moop", "alvin" -> moopy;
            case "raina", "rai" -> rai;
            case "olivia", "libby" -> libby;
            default -> GUEST;
        };
    }

    public String getString(Name name) {
        return switch (name) {
            case melly -> "Melly";
            case chelly -> "Chelly";
            case moopy -> "Moopy";
            case libby -> "Libby";
            case rai -> "Rai";
            case GUEST -> "Anonymous";
        };
    }

    public static boolean isGnome(Name name) {
        return (name == chelly || name == melly || name == moopy);
    }
}
