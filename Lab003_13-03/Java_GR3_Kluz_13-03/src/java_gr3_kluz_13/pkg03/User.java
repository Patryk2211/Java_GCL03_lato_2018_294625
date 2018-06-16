/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gr3_kluz_13.pkg03;

import java.util.Objects;

/**
 *
 * @author pkluz
 */
public class User
{
    long id;
    String name;
    long createdAt;
    int numberOfSentMessages;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public int getNumberOfSentMessages() {
        return numberOfSentMessages;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setNumberOfSentMessages(int numberOfSentMessages) {
        this.numberOfSentMessages = numberOfSentMessages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + (int) (this.createdAt ^ (this.createdAt >>> 32));
        hash = 41 * hash + this.numberOfSentMessages;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.createdAt != other.createdAt) {
            return false;
        }
        if (this.numberOfSentMessages != other.numberOfSentMessages) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", numberOfSentMessages=" + numberOfSentMessages + '}';
    }
    
    
}