package test.core.microuser.mappers;

import org.mapstruct.Mapper;
import test.core.microuser.domain.User;
import test.core.microuser.persistance.entities.UserEntity;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDTO(UserEntity userEntity);
    UserEntity toEntity(User user);
    List<User> toDTOs(List<UserEntity> users);
    List<UserEntity> toEntities(List<User> users);

}
