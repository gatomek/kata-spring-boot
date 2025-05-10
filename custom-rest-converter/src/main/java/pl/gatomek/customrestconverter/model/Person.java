package pl.gatomek.customrestconverter.model;

public record Person(String name, int age, Sex sex) {
    public static Person of(String name, int age, Sex sex) {
        return new Person(name, age, sex);
    }
}
