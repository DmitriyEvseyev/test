package importFile.downloadType;

import com.fasterxml.jackson.databind.ObjectMapper;
import importFile.ImportExeption;
import importFile.ImportStrategyDownloads;
import model.Person;
import validation.ImportValidStategyHelper;
import validation.ValidStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ImportFromFile implements ImportStrategyDownloads {
    @Override
    public List<Object> store(Integer typeClass, Integer arraySize) throws IOException {
        System.out.print("Enter the file name: ");
        Scanner scanner = new Scanner(System.in);
        String nameFile = scanner.nextLine();
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(nameFile);

        ValidStrategy validStrategy = ImportValidStategyHelper.getInstance().resolveValidStrategy(typeClass);

        List<Object> objectList = null;
        try {
            objectList = validStrategy.isValidImport(jsonFile);
            System.out.println(objectList);
        } catch (ImportExeption e) {
            System.out.println(e.getMessage());
        }
//        if (validStrategy.isValidImport(jsonFile)) {
//            objectList = Arrays.asList(objectMapper.readValue(jsonFile, Object[].class));
//            System.out.println("Person.class - " + objectList);
//        } else {
//            try {
//                throw new ImportExeption("Import error!");
//            } catch (ImportExeption e) {
//                System.out.println(e.getMessage());
//            }
//        }
        return objectList;
    }
}
