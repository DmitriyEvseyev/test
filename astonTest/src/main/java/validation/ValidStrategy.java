package validation;

import importFile.ImportExeption;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ValidStrategy <T> {

  List<T> isValidImport (File file) throws IOException, ImportExeption;
}