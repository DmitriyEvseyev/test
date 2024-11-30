package model.factort.impl;

import model.Person;
import model.factort.ObjectFactory;
import model.factort.ObjectsCreated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonFactory implements ObjectFactory {

    private Random random = new Random();

    @Override
    public ObjectsCreated create() {

        return new Person.Builder()
                .gender(getGender())
                .age(getAge())
                .lastName((getGender().equals("Женский")) ? getLastName() + "a" : getLastName())
                .build();
    }

    private String getGender() {

        List<String> genders  = new ArrayList<>(
                Arrays.asList(
                        "Мужской", "Женский"
                )
        );
        int ind = random.nextInt(genders.size());
        return genders.get(ind);
    }

    private int getAge() {
        return random.nextInt(90) + 1;
    }

    private String getLastName() {
        List<String> lastNames = new ArrayList<>(
                Arrays.asList(
                        "Иванов","Петров","Сидоров",
                        "Ефремов","Толстов"
                )
        );
        int ind = random.nextInt(lastNames.size());
        return lastNames.get(ind);
    }
}

