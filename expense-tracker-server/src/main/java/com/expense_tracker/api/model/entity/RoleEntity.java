package com.expense_tracker.api.model.entity;

import com.expense_tracker.api.model.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    public RoleEntity() {
    }

    public RoleEntity(RoleEnum role) {
        this.role = role;
    }

    public RoleEnum getName() {
        return role;
    }

    public void setName(RoleEnum role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, super.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleEntity that = (RoleEntity) o;
        return super.equals(o) && Objects.equals(role, that.role);
    }
}
