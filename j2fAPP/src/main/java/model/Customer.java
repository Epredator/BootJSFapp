package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @Column(name = "SURNAME", unique = true, nullable = false)
    private String surname;

    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("id: ").append(getId());
        strBuff.append(", name: ").append(getName());
        strBuff.append(", surname: ").append(getSurname());
        return strBuff.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
