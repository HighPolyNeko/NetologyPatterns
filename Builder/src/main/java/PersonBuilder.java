public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Возраст недопустимый");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null){
            throw new IllegalStateException("Не хватает обяхательных полей");
        }

        if (age != -1) {
            return new Person(name, surname, age, address);
        } else {
            return new Person(name, surname, address);
        }
    }
}