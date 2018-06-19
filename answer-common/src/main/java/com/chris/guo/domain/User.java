package com.chris.guo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 */
@Entity
public class User extends LongIdEntity {
    private String name;
    private String password;
    private String eamil;
    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "user")
    private List<Question> question=new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Answer> answer=new ArrayList<>();

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

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }


    public List<Answer> getAnswer() {
        return answer;
    }


    public List<Question> getQuestion() {
        return question;
    }


}
