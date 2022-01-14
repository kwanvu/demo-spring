package web.demospringboot.service;

import web.demospringboot.dto.UserDTO;

public interface IUserService {
    UserDTO save(UserDTO userDTO);
}
