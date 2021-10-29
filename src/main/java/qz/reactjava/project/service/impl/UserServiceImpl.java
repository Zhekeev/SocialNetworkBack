package qz.reactjava.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import qz.reactjava.project.model.User;
import qz.reactjava.project.repository.UserRepository;
import qz.reactjava.project.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LocationServiceImpl locationServiceImpl;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LocationServiceImpl locationServiceImpl) {
        this.userRepository = userRepository;
        this.locationServiceImpl = locationServiceImpl;
    }

    @Override
    public void save(User user, Long id) {
        user.setLocation(locationServiceImpl.getLocationById(id));
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User userFromDB = userRepository.getById(user.getId());
        User updatedUser = userFromDB;
        updatedUser.setPhotoUrl(user.getPhotoUrl());
        updatedUser.setLocation(user.getLocation());
        updatedUser.setStatus(user.getStatus());
        updatedUser.setFollowed(user.getFollowed());
        updatedUser.setFullName(user.getFullName());
        return updatedUser;
    }

    @Override
    public Page<User> allUsersWithPageParameter(int page) {
        return userRepository.findAll(PageRequest.of(page, 4));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
