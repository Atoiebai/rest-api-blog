package net.sublime.rest.mapper;

import net.sublime.rest.dto.user.UserDTO;
import net.sublime.rest.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mappings({
            @Mapping(target="password", source="user.passwordKey"),
            @Mapping(target="username", source="user.userName")
    })
    public abstract UserDTO toDTO(User user);

    @Mappings({
            @Mapping(target="passwordKey", source="userDTO.password"),
            @Mapping(target="userName", source="userDTO.username")
    })
    public abstract User toUser(UserDTO userDTO);
}
