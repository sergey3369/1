package appCrud.repository;

import appCrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repository")
public interface UserRepository extends JpaRepository<User, Long> {
}
