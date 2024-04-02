package ru.mirea.University.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mirea.University.models.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {
    @Modifying
    @Query("UPDATE Student s SET s.fullName = :fullName, s.cardNumber = :cardNumber WHERE s.id = :id")
    void updateStudent(@Param("id") int id,
                      @Param("fullName") String fullName,
                      @Param("cardNumber") String cardNumber);

}
