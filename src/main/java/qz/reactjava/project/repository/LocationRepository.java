package qz.reactjava.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qz.reactjava.project.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
