package model;

import model.factort.ObjectsCreated;


public class Person implements ObjectsCreated {
    private   String gender;
    private   int age;
    private   String lastName;

    private static Long count = 0L;
    private Long id;

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.lastName = builder.lastName;

        count++;
        this.id = getCount();
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static class Builder {
        private String gender;
        private int age;
        private String lastName;

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    private Long getCount() {
        return count;
    }
}

