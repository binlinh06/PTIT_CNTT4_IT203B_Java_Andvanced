package session11.hw05.service;

import session11.hw05.dao.DoctorDAO;
import session11.hw05.model.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public void showAll() {
        List<Doctor> list = dao.getAllDoctors();
        if (list.isEmpty()) {
            System.out.println("Không có bác sĩ!");
        } else {
            for (Doctor d : list) {
                System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty());
            }
        }
    }

    public void add(Doctor d) {
        if (dao.addDoctor(d)) {
            System.out.println("✅ Thêm thành công!");
        }
    }

    public void statistics() {
        dao.countBySpecialty();
    }
}