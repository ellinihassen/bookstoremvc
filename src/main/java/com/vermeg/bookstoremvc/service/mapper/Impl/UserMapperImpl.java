package com.vermeg.bookstoremvc.service.mapper.Impl;

import com.vermeg.bookstoremvc.dao.entity.User;
import com.vermeg.bookstoremvc.model.UserDTO;
import com.vermeg.bookstoremvc.service.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl extends GenericMapperImpl<UserDTO, User> implements UserMapper {

    private final ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO mapToDto(User entity) {
        UserDTO userDTO = new UserDTO();
        modelMapper.typeMap(User.class, UserDTO.class)
                .addMappings(mapper -> mapper.skip(UserDTO::setPassword))
                .map(entity,userDTO);
        return userDTO;
    }

    @Override
    public User mapToEntity(UserDTO dto) {
       User user = new User();
       modelMapper.map(dto,user);
       return user;
    }
}
