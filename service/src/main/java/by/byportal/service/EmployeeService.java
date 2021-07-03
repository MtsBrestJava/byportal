package by.byportal.service;

import by.byportal.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public List<Employee> findAllEmployees() {
        List<Employee> allEmployees = new ArrayList<Employee>();
        // TODO: Implement returning List from DAO

        return allEmployees;
    }
    @Override
    public void deleteProfile(int id) {
        Profile profile = profileDao.getProfileById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
        profileDao.deleteProfileById(profile.getId());


}
