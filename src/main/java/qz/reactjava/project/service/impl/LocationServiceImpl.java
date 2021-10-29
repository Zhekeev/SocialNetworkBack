package qz.reactjava.project.service.impl;

import org.springframework.stereotype.Service;
import qz.reactjava.project.model.Location;
import qz.reactjava.project.repository.LocationRepository;
import qz.reactjava.project.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location>allLocation(){
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long id){
        return locationRepository.getById(id);
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location update(Location location) {
        Location locationFromDB = locationRepository.getById(location.getId());
        locationFromDB.setCity(location.getCity());
        locationFromDB.setCountry(location.getCountry());
        return locationFromDB;
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }
}
