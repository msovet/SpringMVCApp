package kz.msovet.springmvc.dao;

import kz.msovet.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom",18,"toma@tom"));
        people.add(new Person(++PEOPLE_COUNT, "Kexx",11,"ggg@ggg"));
        people.add(new Person(++PEOPLE_COUNT, "Canelo", 13,"qqq@q"));
        people.add(new Person(++PEOPLE_COUNT, "GGG", 21, "qweqwe@qweqwe"));
    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }
    public void delete(int id) {
//        Person personToBeDeleted = show(id);
        people.removeIf(p -> p.getId() == id);
    }
}
