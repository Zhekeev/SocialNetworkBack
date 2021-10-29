package qz.reactjava.project.service;

import org.springframework.data.domain.Page;
import qz.reactjava.project.model.User;

import java.util.List;

public interface UserService {
    void save(User user, Long id);

    User update(User user);

    Page<User> allUsersWithPageParameter(int page);

    List<User> getAllUser();

    void delete(User user);
}
