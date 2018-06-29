package entities;

public enum KittenBreed {
    STREET_ASCENDED,
    MUNCHKIN,
    SIAMESE,
    AMERICAN_SHORTHAIR;

    public static KittenBreed parseValue(String string) {
        if (string.equals("Munchkin")) return MUNCHKIN;
        else if (string.equals("Street Ascended")) return STREET_ASCENDED;
        else if (string.equals("Siamese")) return SIAMESE;
        else if (string.equals("American Shorthair")) return AMERICAN_SHORTHAIR;
        return null;
    }

    public static String getSimpleValue(KittenBreed breed) {
        return breed.toString().toLowerCase().replace("_", "-");
    }

    public static String getComplexValue(KittenBreed breed) {
        if (breed.equals(MUNCHKIN)) return "Munchkin";
        else if (breed.equals(STREET_ASCENDED)) return "Street Ascended";
        else if (breed.equals(SIAMESE)) return "Siamese";
        else if (breed.equals(AMERICAN_SHORTHAIR)) return "American Shorthair";
        return null;
    }
}
