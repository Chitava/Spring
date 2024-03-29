package ru.chitava.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.chitava.server.model.Student;

/**
 * Интерфейс для работы с хранилищем записей студентов
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
