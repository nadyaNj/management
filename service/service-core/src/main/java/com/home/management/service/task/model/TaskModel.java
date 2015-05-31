package com.home.management.service.task.model;

import com.home.management.service.common.AbstractEntityModel;
import com.home.management.service.user.model.UserModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:33 PM
 */

@Entity
@SequenceGenerator(name = "sequence_generator", sequenceName = "user_seq", initialValue = 1)
@Table(name = "task")
public class TaskModel extends AbstractEntityModel {

    private static final long serialVersionUID = 7518867054292521163L;

    /* properties */

    @Column(name = "content")
    private String content;

    @Column(name = "task_status")
    private String taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel userModel;


    /*Getter and Setter*/

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    /* Equals, HashCode and toString */

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
        TaskModel rhs = (TaskModel) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.getContent(), rhs.getContent())
                .append(this.getTaskStatus(), rhs.getTaskStatus())
                .append(this.getUserModel(), rhs.getUserModel())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(getContent())
                .append(getTaskStatus())
                .append(getUserModel())
                .toHashCode();
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("content", getContent())
                .append("taskStatus", getTaskStatus())
                .append("userModel", getUserModel())
                .toString();
    }
}
