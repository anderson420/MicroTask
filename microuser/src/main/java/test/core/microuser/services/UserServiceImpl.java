package test.core.microuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.core.microuser.domain.User;
import test.core.microuser.exception.UserNoFoundException;
import test.core.microuser.exception.UserNullIdException;
import test.core.microuser.mappers.UserMapper;
import test.core.microuser.persistance.entities.UserEntity;
import test.core.microuser.persistance.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userMapper.toDTOs(userEntities);

        return users;

    }

    @Override
    public User getUser(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        userEntity.orElseThrow(() -> new UserNoFoundException("no se ha encontrado usuario con id: "+id));
        User user = userMapper.toDTO(userEntity.get());
        return user;
    }

    @Override
    public User saveUser(User user) {
        user.setId(null);
        UserEntity userEntity = userMapper.toEntity(user);
        return userMapper.toDTO(userRepository.save(userEntity));
    }

    @Override
    public User updateUser(User user) {
        Optional.ofNullable(user.getId())
                .orElseThrow(() -> new UserNullIdException("El ID del usuario no puede ser nulo"));
        userRepository.findById(user.getId()).orElseThrow(()-> new UserNoFoundException("no se ha encontrado usuario con id: "+user.getId()) );

        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public void deleteUser(Long id) {
        Optional<UserEntity> opUserEntity =  userRepository.findById(id);
        opUserEntity.orElseThrow(()-> new UserNoFoundException("no se ha encontrado usuario con id: "+id) );
        userRepository.deleteById(id);
    }
}
