package com.anlu.secrity.service.impl;

import com.anlu.secrity.dao.UserDao;
import com.anlu.secrity.model.User;
import com.anlu.secrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User findById(int id) {
        return dao.findById(id);
    }

    public User findBySSO(String sso) {
        return dao.findBySSO(sso);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }

    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }
}
