package shop;

import java.util.Date;
import java.util.Objects;

public class Worker {
    String name, password, login;
    //Shop currentWorkPlace;
    Date start;

    public Worker(String name, String password, String login) {
        this.name = name;
        this.password = password;
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Worker other = (Worker) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    public boolean logIn(String log,String pas){
    boolean result=false;
    return result; 
    }
    
    
    public void makeOrder(){}
    
}
