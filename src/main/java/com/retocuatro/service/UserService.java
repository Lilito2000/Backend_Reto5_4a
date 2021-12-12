package com.retocuatro.service;

import com.retocuatro.model.User;
import com.retocuatro.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Reto 4 web
 * @author Liliana Torres
 * versión 1.0
 * fecha 11-12-2021
 */
@Service
public class UserService {
    /*
    * Atributo de relación
    */
    @Autowired
    private UserRepository userRepository;
    /**
     *  Método para listar los usuarios registrados
     * @return Users
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
     * Método para traer información del usuario
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
                return userRepository.getUser(id);
    }
    /** 
     *  Método para crear usuario
     * @param user
     * @return
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;            
        }else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }           
        }
    }

    /**
     * Método para modificar usuario
     * @param user
     * @return user
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
               
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    /**
     * Método para borrar un usuario
     * @param userId
     * @return true or false
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Método para identificar un usuario existente
     * @param email
     * @return email
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    /**
     * Método para autenticar relación entre email y password de un usuario
     * @param email
     * @param password
     * @return usuario
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}
