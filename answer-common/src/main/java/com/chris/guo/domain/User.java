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
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Question> question = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Answer> answer = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Answer> getAnswer() {
        return answer;
    }


    public List<Question> getQuestion() {
        return question;
    }


}
