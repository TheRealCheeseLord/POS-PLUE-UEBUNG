package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.PersonRole;
import at.spengergasse.plue.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, PersonRole.PersonRoleId> {
}
