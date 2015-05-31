package com.home.management.service.user.model;

import com.home.management.service.common.AbstractEntityModel;
import com.home.management.service.task.model.TaskModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:32 PM
 */

@Entity
@SequenceGenerator(name = "sequence_generator", sequenceName = "user_seq", initialValue = 1)
@Table(name = "user")
public class UserModel extends AbstractEntityModel {

    private static final long serialVersionUID = 3718608522932831823L;

    /* Properties */

    @Column(name = "user_name",  unique = true)
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private Short gender;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    private Set<TaskModel> userTasks;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Set<TaskModel> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(Set<TaskModel> userTasks) {
        this.userTasks = userTasks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        UserModel rhs = (UserModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getUserName(), rhs.getUserName())
                .append(this.getFirstName(), rhs.getFirstName())
                .append(this.getSecondName(), rhs.getSecondName())
                .append(this.getPassword(), rhs.getPassword())
                .append(this.getGender(), rhs.getGender())
                .append(this.getUserTasks(), rhs.getUserTasks())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getUserName())
                .append(getFirstName())
                .append(getSecondName())
                .append(getPassword())
                .append(getGender())
                .append(getUserTasks())
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("userName", getUserName())
                .append("firstName", getFirstName())
                .append("secondName", getSecondName())
                .append("password", getPassword())
                .append("gender", getGender())
                .append("userTasks", getUserTasks())
                .toString();
    }
}
