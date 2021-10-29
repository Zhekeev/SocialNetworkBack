package qz.reactjava.project.model.dto;

import lombok.Data;
import qz.reactjava.project.model.Location;
import qz.reactjava.project.model.User;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String status;
    private Location location;
    private Boolean followed;
    private String photoUrl;
    private Integer totalCount;

    public static UserDto fromUser (User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setStatus(user.getStatus());
        userDto.setLocation(user.getLocation());
        userDto.setFollowed(user.getFollowed());
        userDto.setPhotoUrl(user.getPhotoUrl());
        return userDto;
    }
}
