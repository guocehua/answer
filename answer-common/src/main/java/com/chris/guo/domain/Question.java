package com.chris.guo.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 */
@Entity
public class Question extends LongIdEntity {
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private Integer like;
    private List<Answer> answers=new ArrayList<>();
}
