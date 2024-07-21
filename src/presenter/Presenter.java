package presenter;

import model.human.Gender;
import model.service.FileHandler;
import model.service.Service;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private static final long serialVersionUID = 1L;
    private View view;
    private Service service;
    private FileHandler fileHandler;



    public Presenter(View view) {
        this.view = view;
        service = new Service();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        service.addHuman(name, birthDate, gender);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByBirthDate() {
        service.sortByName();
        getHumanListInfo();
    }


    public void saveTree() {
        fileHandler.save(service);
    }

    public void readTree() {
        Service loadedService = (Service) fileHandler.read();
        if (loadedService != null) {
            this.service = loadedService;
            view.printAnswer("Дерево успешно загружено.");
        } else {
            view.printAnswer("Ошибка при загрузке дерева.");
        }
    }

    public void setParentId(long childId, long parentId) {
        service.setParentId(childId,parentId);
    }

    public int familyTreeSize() {
        return service.familyTreeSize();
    }
}
