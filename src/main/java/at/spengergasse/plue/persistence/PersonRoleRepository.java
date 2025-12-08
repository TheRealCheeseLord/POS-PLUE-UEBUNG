package at.spengergasse.plue.persistence;

import at.spengergasse.plue.domain.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRoleRepository extends JpaRepository<PersonRole, PersonRole.PersonRoleId> {
}
