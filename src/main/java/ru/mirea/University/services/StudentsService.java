package ru.mirea.University.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.University.models.Student;
import ru.mirea.University.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StudentsService {
    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> findAll() {
        return studentsRepository.findAll();
    }

    public Student findOne(int id) {
        Optional<Student> foundStudent = studentsRepository.findById(id);
        return foundStudent.orElse(null);
    }

    @Transactional
    public void save(Student student){
        studentsRepository.save(student);
    }

    @Transactional
    public void delete(int id){
        studentsRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Student updatedStudent){
        studentsRepository.updateStudent(id, updatedStudent.getFullName(), updatedStudent.getCardNumber());
    }
}
