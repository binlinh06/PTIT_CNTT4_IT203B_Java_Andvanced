package session12.hw05.service;

import session12.hw05.dao.PatientDAO;
import session12.hw05.model.Patient;

import java.util.List;

public class PatientService {
    private PatientDAO dao = new PatientDAO();

    public void showAll() {
        List<Patient> list = dao.getAll();
        if (list.isEmpty()) {
            System.out.println("Không có bệnh nhân!");
        } else {
            for (Patient p : list) {
                System.out.println(p.getId() + " | " + p.getName() + " | "
                        + p.getAge() + " | " + p.getDepartment());
            }
        }
    }

    public void add(Patient p) {
        dao.add(p);
    }

    public void update(int id, String disease) {
        dao.updateDisease(id, disease);
    }

    public void discharge(int id) {
        dao.discharge(id);
    }
}
