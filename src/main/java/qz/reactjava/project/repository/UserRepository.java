package qz.reactjava.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import qz.reactjava.project.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User>findAll(Pageable pageable);

    List<User> findAll();
}
