package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.PersonRole;
import at.spengergasse.plue.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, PersonRole.PersonRoleId> {
}
