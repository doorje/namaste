package com.mahen.doorje.namaste.account.query;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class NamasteAccountPrivilegeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<NamasteAccountRoleEntry> roles;

    @SuppressWarnings("unused")
    private NamasteAccountPrivilegeEntry() {
    }

    public NamasteAccountPrivilegeEntry(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Collection<NamasteAccountRoleEntry> getRoles() {
        return roles;
    }

    public void setRoles(final Collection<NamasteAccountRoleEntry> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NamasteAccountPrivilegeEntry other = (NamasteAccountPrivilegeEntry) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("NamasteAccountPrivilege [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}
