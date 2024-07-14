
import family_tree.HumanComparatorByName;
import human.Gender;
import human.Human;
import service.Service;



import java.time.LocalDate;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Service service = testTree();
        System.out.println(service.getHumanListInfo());
        //service.saveTree("src/saved_tree/familyTree.txt");
        //Service loadTree = Service.readTree("src/saved_tree/familyTree.txt");
        //System.out.println(loadTree.getHumanListInfo());
        //service.sortByName();
        //System.out.println(service.getHumanListInfo());
        //service.sortByBirthDate();
        //System.out.println(service.getHumanListInfo());

        String  d = service.findHumanById(4);
        System.out.println(d);
        String f = service.findHumanByName("Наумов Алексей");
        System.out.println(f);
    }



    private static Service testTree() {

        Service service = new Service();

        Human father = service.addHuman("Наумов Алексей", LocalDate.of(1977, 12, 31), Gender.Male);
        Human mother = service.addHuman("Наумова Ольга", LocalDate.of(1980, 8, 12), Gender.Female);
        Human daughter = service.addHuman("Наумова Марина", LocalDate.of(2000, 6, 21), Gender.Female);
        Human son = service.addHuman("Наумов Павел", LocalDate.of(2008, 5, 10), Gender.Male);
        //
        service.setMother(daughter, mother);
        service.setFather(daughter, father);
        service.setMother(son, mother);
        service.setFather(son, father);


        Human grandmother = service.addHuman("Наумова Раиса", LocalDate.of(1932, 5, 31), Gender.Female);
        service.setMother(father, grandmother);


        return service;
    }

}