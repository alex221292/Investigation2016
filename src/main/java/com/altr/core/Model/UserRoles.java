package com.altr.core.Model;

import javax.persistence.*;

/**
 * Created by Алексей on 21.05.2016.
 */
@Entity
@Table(name = "user_roles")
@AssociationOverrides({
        @AssociationOverride(name = "id.userId", joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "id.roleId", joinColumns = @JoinColumn(name = "role_id"))
})
public class UserRoles implements java.io.Serializable {

    @Id
    private UserRolesPK id;

    public UserRolesPK getId() {
        return id;
    }

    public void setId(UserRolesPK id) {
        this.id = id;
    }

    @Transient
    public Integer getUserId(){
        return getId().getUserId();
    }

    public void setUserId(int id){
        getId().setUserId(id);
    }

    @Transient
    public Integer getRoleId(){
        return getId().getRoleId();
    }

    public void setRoleId(int id){
        getId().setRoleId(id);
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                '}';
    }
}
