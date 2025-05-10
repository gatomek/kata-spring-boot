package pl.gatomek.customrestconverter.model;

public enum Sex {
    Male("male"),
    Female("female");

    private final String desc;

    Sex(String desc) {
        this.desc = desc;
    }

    public static Sex fromDesc(String desc) {
        String key = desc.toLowerCase();

        for (Sex sex : Sex.values()) {
            if (sex.desc.equals(key))
                return sex;
        }

        throw new UnsupportedOperationException("Enum value not found for desc: " + desc);
    }
}
