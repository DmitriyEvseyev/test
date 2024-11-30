import com.fasterxml.jackson.databind.ObjectMapper;
import importFile.ImportStrategyDownloads;
import importFile.ImportStrategyHelper;
import model.Animal;
import model.Barrel;
import model.Person;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("sdc");

        //  ImportStrategyDownloads importStrategyDownloads = ImportStrategyDownloads

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person.Builder().
                gender("male").
                age(20).
                lastName("dfd").
                build();

        Person person2 = new Person.Builder().
                age(30).
                gender("male").
                lastName("FFF").
                build();

        List<Person> pl = new ArrayList<>();
        pl.add(person);
        pl.add(person2);
        System.out.println(pl);

        Animal animal = new Animal.Builder().
                eyeColor("grey").
                species("fish").
                hasFur(false).
                build();

        List<Animal> anL = new ArrayList<>();
        anL.add(animal);

        Barrel barrel = new Barrel.Builder().
                material("plastic").
                storedMaterial("liqid").
                volume(200).build();

        List<Barrel> barL = new ArrayList<>();
        barL.add(barrel);

        objectMapper.writeValue(new File("animal.json"), anL);

        String nameFile = "person1.json";
        Integer obj = 1;
        ImportStrategyDownloads imp = ImportStrategyHelper.getInstance().resolveDownloadsStrategy(1);

        imp.store(obj, 2);


    }
}
