package pl.mariuszczarny.slask.controller.utils;

public enum StringConstants {

    SAVE_SUCCESS("Zapis poprawny."),
    SAVE_ERROR("Błąd zapisu.");

    private final String value;

    private StringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
