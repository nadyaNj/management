package com.home.management.service.common;

import com.home.management.service.common.converter.PersistentLocalDateTimeConverter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:09 PM
 */

@MappedSuperclass
public class AbstractEntityModel implements Serializable {

    private static final long serialVersionUID = -8918144551668547548L;


    /*Properties*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @Column(name = "id")
    private Long id;

    @Convert(converter = PersistentLocalDateTimeConverter.class)
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Convert(converter = PersistentLocalDateTimeConverter.class)
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Convert(converter = PersistentLocalDateTimeConverter.class)
    @Column(name = "removed", nullable = true)
    private LocalDateTime removed;


    /* Constructor */
    public AbstractEntityModel() {
        setCreated(LocalDateTime.now());
        setUpdated(getCreated());
    }


     /* Getter and Setter */
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(final LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getRemoved() {
        return removed;
    }

    public void setRemoved(final LocalDateTime removed) {
        this.removed = removed;
    }

    /* Hashcode, equals and toString */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final AbstractEntityModel rhs = (AbstractEntityModel) obj;
        return new EqualsBuilder()
                .append(this.getId(), rhs.getId())
                .append(this.getCreated(), rhs.getCreated())
                .append(this.getUpdated(), rhs.getUpdated())
                .append(this.getRemoved(), rhs.getRemoved())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getCreated())
                .append(getUpdated())
                .append(getRemoved())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("created", getCreated())
                .append("updated", getUpdated())
                .append("removed", getRemoved())
                .toString();
    }
}
