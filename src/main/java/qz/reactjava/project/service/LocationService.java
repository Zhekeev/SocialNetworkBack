package qz.reactjava.project.service;

import qz.reactjava.project.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> allLocation();

    Location getLocationById(Long id);

    void save(Location location);

    Location update(Location location);

    void delete(Location location);
}
