package org.example;






import org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;


import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public App() throws IOException {
    }

    public static void main(String[] args ) throws IOException {
        System.out.println("Hello World!");// фигня
        JSONObject jsonOb = new JSONObject();// создали объект
        Map employees = new HashMap();//создали карту
        employees.put(1, new Employee("Adithya", "Jai", 30));
        employees.put(2, new Employee("Vamsi", "Krishna", 28));
        employees.put(3, new Employee("Chaitanya", "Sai", 30));
        employees.put(4, new Employee("Anastashia", "Kubast", 11));
       //заполнили карту и положили её в объект
        jsonOb.put("1", employees);
        // проверили, что в объекте
        System.out.println(jsonOb.toString()); // pretty print JSON
        // записали информацию в файл (файл перезаписывается) и нет пробелм , что он открыт в IDEA
        try (PrintWriter out = new PrintWriter(new FileWriter("F:\\JavaRush\\test\\test\\src\\main\\java\\resourses\\customer.json"))) {
            out.write(jsonOb.toString());
        } catch (Exception e) {

        }

        // объект файл
        File file = new File("F:\\JavaRush\\test\\test\\src\\main\\java\\resourses\\customer.json");
        // создали поток чтения из файла
        JsonReader jsReader = Json.createReader(new FileReader(file));
         // создали объект и записали туда поток из файла
        JsonObject jsObj = jsReader.readObject();
        // закрыли поток
        jsReader.close();
        //создали Json строку из  объекта
        String str=jsObj.toString();
        // проверка
        System.out.println(str);
        //делаем ссылку jsonOb на  новый объект из Json строки
        jsonOb = new JSONObject(str);
        // преобразуем еёв карту
        Map<String,Object> stringObjectMap =jsonOb.toMap();
        // проверка
        System.out.println(stringObjectMap);

//

    }

   public static class Employee {
        private String firstName, lastName;
        private int age;
        public Employee(String firstName, String lastName, int age) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public int getAge() {
            return age;
        }
    }

}
