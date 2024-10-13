package com.project.rentAcar.dao;
import com.project.rentAcar.entities.User;
import com.project.rentAcar.exceptions.RessourceAlreadyExistsException;
import com.project.rentAcar.exceptions.RessourceNotFoundException;

/**
 * This interface defines user dao method.
 */
public interface UserDao {
    public User saveUser(User user) throws RessourceNotFoundException;
    public User findUserbyId(int id) throws RessourceNotFoundException;
    public User findUserByEmail(String mail) throws RessourceNotFoundException;
    public void existsByEmail(String mail) throws RessourceAlreadyExistsException;
    public int findUserIdByEmail(String email) throws RessourceNotFoundException;

    

}
