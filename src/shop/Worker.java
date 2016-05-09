package shop;

import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Worker implements Comparable<Worker>{
    String name, password, login;
    //Shop currentWorkPlace;
    Date start;
    boolean isCurrentlyWorking = false;
    private final static Set<Worker>  KATALOG_WORKER=new TreeSet<>();

    public Worker(String name, String password, String login) {
        this.name = name;
        this.password = password;
        this.login = login;
        KATALOG_WORKER.add(this);
    }

    public static Set<Worker> getKATALOG_WORKER() {
        return KATALOG_WORKER;
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

    public static boolean logIn(String log,String pas){
    boolean result=false;
    for(Worker temp : KATALOG_WORKER){
    result=(temp.login.compareTo(log)==0)&&(temp.password.compareTo(pas)==0)?true:false;
    if(result)
        break;
    }
    return result; 
    }
    
    
    
    
    public void showRecepts(){
    // выводит список составленных менеджером рецептов на экран работника
    }

    @Override
    public String toString() {
        return "Worker{" + "name=" + name + ", start=" + start + '}';
    }

    @Override
    public int compareTo(Worker o) {
      return name.compareToIgnoreCase(o.name);
    }
    
}
