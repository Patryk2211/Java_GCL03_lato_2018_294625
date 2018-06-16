/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gr3_kluz_13.pkg03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pkluz
 */
public class ChatEngine {
    
    Map<Integer, User> users = new HashMap<Integer, User>();
    Set<String> zbiorBanow = new HashSet<String>();
    
    void addUser(User user) throws UserAddException
    {
        if(users.containsKey((int)user.getId()))
            {
                if(zbiorBanow.contains(user.getName()))
                {
                    throw new UserAddException("Obiekt jest na liscie banow!");
                }
                throw new UserAddException("Obiekt już istnieje!");
            }
            else
                users.put((int)user.getId(), user); 
    }
    
    void removeUser(long userId) throws UserRemoveException
    {
       if(users.containsKey(userId))
       {
           users.remove(userId);
       }
       else
        throw new UserRemoveException("Obiekt nie istnieje");
    }
    
    int getNumberOfUsers()
    {
        return users.size();
    }
    
    void createBan(String userName)
    {
        
        if(users.containsValue(userName))
        {
            zbiorBanow.add(userName);
        }   
    }
    
    void removeBan(String userName)
    {
        zbiorBanow.remove(userName);
    }
    
    boolean hasUser(long userId)
    {
        if(users.containsKey(userId))
        {
            return true;
        }
        else return false;
    }
    
    boolean hasUser(String userName)
    {
      if(users.containsKey(userName))
        {
            return true;
        }
        else return false;  
    }
    
    boolean broadcastMessage(long userId, String message)
    {
        for(Map.Entry<Integer, User> mapa : users.entrySet())
        {
            System.out.println(mapa);
            System.out.println(userId);
            System.out.println(message);
        }
        return true;
    }
}
