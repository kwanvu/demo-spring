package web.demospringboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.demospringboot.dto.UserDTO;
import web.demospringboot.entity.UserEntity;

@Component
public class UserConverter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUser(dto.getUser());
        String encodedPass = passwordEncoder.encode(dto.getPass());
        entity.setPass(encodedPass);
        entity.setName(dto.getName());
        entity.setMoney(dto.getMoney());
        entity.setStatus(dto.getStatus());
        entity.setRole(dto.getRole());
        return entity;
    }

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        if(entity.getId() != null){
            dto.setId(entity.getId());
        }
        dto.setUser(entity.getUser());
        dto.setPass(entity.getPass());
        dto.setName(entity.getName());
        dto.setMoney(entity.getMoney());
        dto.setStatus(entity.getStatus());
        dto.setRole(entity.getRole());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

}
