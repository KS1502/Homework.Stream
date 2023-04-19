package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Anna", 20, "Bonn");
        Person person1 = new Person("John", 18, "Berlin");
        Person person2 = new Person("Jack", 19, "München");
        Person person3 = new Person("Tim", 17, "Nürnberg");
        Person person4 = new Person("Helen", 16, "Hamburg");


        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        Map<String, List<Person>> name = personList.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println(name);

        /*{John=[Person{name='John', age=18, address='Berlin'}], Tim=[Person{name='Tim', age=17, address='Nürnberg'}], Jack=[Person{name='Jack', age=19, address='München'}], Helen=[Person{name='Helen', age=16, address='Hamburg'}], Anna=[Person{name='Anna', age=20, address='Bonn'}]} */

        List<Person> names = List.of(person, person1, person2, person3, person4);
        names.stream()
                .filter(p -> p.getAge() > 18)
                .forEach(p -> System.out.println("in Germany " +p.getName()+  " is of legal age " + p.getAge()));

        /* in Germany Anna is of legal age 20
          in Germany Jack is of legal age 19
                                             */

        List<Person> names1 = List.of(person, person1, person2, person3, person4);
        names1.stream()
                .filter(p -> p.getAge() > 17)
                .forEach(p -> System.out.println(p.getName()));
          /* Anna
             John
           Jack */


    }


    }

/*Задача1
Есть класс Person с полями
String name
int age
String address

Используя стримы, написать метод, принимающий список персонов и возвращающий мапу,
 где возраст является ключом, а список персонов этого возраста значением

Задача2
Используя тот же класс Person, написать метод, принимающий список персонов и возвращающий общий возраст тех,
 кто старше 17 лет.

Задача 3
Написать метод, принимающий список персонов и возвращающий имена тех, кто является совершеннолетним в Германии
(старше 18 лет). Должна быть возвращена примерно следующая строка:
in Germany Jack and John are of legal age (имена по вашему выбору, это пример)*/