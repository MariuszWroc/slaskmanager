/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Mariusz
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    public abstract Long getId();

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final AbstractEntity abstractEntity = (AbstractEntity) object;
        if (this.getId() != abstractEntity.getId() && (this.getId() == null
                || !this.getId().equals(abstractEntity.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), getId());
    }
}
