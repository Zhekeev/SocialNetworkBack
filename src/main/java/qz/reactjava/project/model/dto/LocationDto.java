package qz.reactjava.project.model.dto;

import lombok.Data;
import qz.reactjava.project.model.Location;

@Data
public class LocationDto {
    private Long id;
    private String city;
    private String country;

    public static LocationDto fromLocation(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setCity(location.getCity());
        locationDto.setCountry(location.getCountry());
        return locationDto;
    }
}
