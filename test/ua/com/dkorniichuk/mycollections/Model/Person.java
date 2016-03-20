package ua.com.dkorniichuk.mycollections.Model;

public class Person implements Comparable {
    private String firstName;
    private String lastName;
    private int age;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "{" + firstName +
                "," + lastName +
                "," + age +
                "}";
    }

    @Override
    public int compareTo(Object o) {
        Person entry = (Person) o;
        if (lastName.compareTo(entry.lastName) > 0)
            return 1;
        if (lastName.compareTo(entry.lastName) < 0)
            return -1;
        else {
            if (firstName.compareTo(entry.firstName) > 0)
                return 1;
            if (firstName.compareTo(entry.firstName) < 0)
                return -1;
            else {
                if (age > entry.age)
                    return 1;
                if (age < entry.age)
                    return -1;
            }
            return 0;
        }
    }
}


