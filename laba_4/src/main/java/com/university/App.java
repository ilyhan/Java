package com.university;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.university.enums.Gender;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.university.models.Department;
import com.university.models.Person;

/**
 * Главный класс для чтения данных о людях из CSV-файла
 */
public class App {
    /**
     * Точка входа в приложение
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        String filePath = "foreign_names.csv";
        char separator = ';';

        List<Person> persons = readFromFile(filePath, separator);

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }

    /**
     * Читает данные о людях из CSV-файла и возвращает список объектов Person
     *
     * @param filePath  путь к CSV-файлу
     * @param separator разделитель, используемый для парсинга CSV-файла
     * @return список объектов Person
     */
    private static List<Person> readFromFile(String filePath, char separator) {
        List<Person> persons = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();

        try (InputStream in = App.class.getClassLoader().getResourceAsStream(filePath);
                CSVReader reader = in == null ? null
                        : new CSVReaderBuilder(new InputStreamReader(in, StandardCharsets.UTF_8))
                                .withCSVParser(new CSVParserBuilder()
                                        .withSeparator(separator)
                                        .build())
                                .build()) {
            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }

            String[] nextLine;
            boolean isHeader = true;

            while ((nextLine = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Пропустить заголовок
                }

                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                Gender gender = Gender.getGender(nextLine[2]);
                Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(nextLine[3]);
                String departmentName = nextLine[4];
                double salary = Double.parseDouble(nextLine[5]);

                // Создание или получение подразделения
                Department department = departmentMap.get(departmentName);
                if (department == null) {
                    department = new Department(departmentName);
                    departmentMap.put(departmentName, department);
                }

                Person person = new Person(id, name, gender, department, salary, birthDate);
                persons.add(person);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }

        return persons;
    }
}
