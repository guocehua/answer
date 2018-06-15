package com.chris.guo.domain;

import javax.persistence.Entity;
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
    private Question question;
    @OneToMany
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

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


}
