package by.byportal.repository;

import by.byportal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // TODO: ?

        //PUT
        void updateEmployee(String firstName, String lastName, int age, int id);





}
