package Library;

import java.util.List;

public interface SearchEmployee {
    public Employee SearchId(List<Employee> e, int idToFind);
    public Employee SearchByDesk(List<Employee> e, int desk);
    public Employee SearchByOffice(List<Employee> e, int office);

}
