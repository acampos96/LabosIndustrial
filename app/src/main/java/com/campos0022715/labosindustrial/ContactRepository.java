package com.campos0022715.labosindustrial;

/**
 * Created by Rafael on 26/6/2017.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ContactRepository {


    private HashMap<Integer, Contact> infcontact = new HashMap<>();

    public ContactRepository(){
        saveContact(new Contact(1,"Gerardo Morales", "Catedratico", "gmorales@uca.edu.sv"));
        saveContact(new Contact(2,"Ana del Pilar Letona", "Catedratica", "aletona@uca.edu.sv"));
        saveContact(new Contact(3,"Emilio Campos", "Jefe del departamento y catedratico", "ecampos@uca.edu.sv"));
        saveContact(new Contact(4,"Fernando José Gomez", "Docente", "fgomez@uca.edu.sv"));
        saveContact(new Contact(5,"Maria Alicia Rauda", "Secretaria", "arauda@uca.edu.sv"));
        saveContact(new Contact(6,"Laura Orellana", "Catedratica", "lorellana@uca.edu.sv"));
        saveContact(new Contact(7,"Fernando Rivas", "Catedratico", "frivas@uca.edu.sv"));
        saveContact(new Contact(8,"Cesar Edgardo Melara", "Catedratico", "cmelara@uca.edu.sv"));
        saveContact(new Contact(9,"German Pocasangre", "Catedratico", "gpocasangre@uca.edu.sv"));

    }

    private void saveContact(Contact country) {
        infcontact.put(country.getId(), country);
    }

    public ArrayList<Contact> getList() {
        Map<Integer,Contact> map = new TreeMap<>(infcontact);
        return new ArrayList<>(map.values());
    }

    public class Contact {
        int id;
        String name;
        String rol;
        String correo;
        //Constructor
        public Contact(int id, String name, String rol, String correo){
            this.id=id;
            this.name=name;
            this.rol=rol;
            this.correo=correo;
        }
        //Getters
        public int getId() { return id; }
        public String getName() {
            return name;
        }
        public String getRol() {
            return rol;
        }
        public String getCorreo() {
            return correo;
        }
    }


}
