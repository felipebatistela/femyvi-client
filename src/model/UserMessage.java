
package model;

import java.io.Serializable;

public class UserMessage implements Serializable {
    
    private String name;
    
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserMessage{" + "name=" + name + ", password=" + password + '}';
    }
    
}