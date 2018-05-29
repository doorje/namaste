package com.mahen.doorje.namaste.account.query;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class NamasteAccountRoleEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<NamasteAccountEntry> accounts;

    @ManyToMany
    @JoinTable(name = "namaste_account_roles_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<NamasteAccountPrivilegeEntry> privileges;

    @SuppressWarnings("unused")
    private NamasteAccountRoleEntry() {
    }

    public NamasteAccountRoleEntry(final String name) {
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

    public Collection<NamasteAccountEntry> getAccounts() {
        return accounts;
    }

    public void setAccounts(final Collection<NamasteAccountEntry> accounts) {
        this.accounts = accounts;
    }

    public Collection<NamasteAccountPrivilegeEntry> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(final Collection<NamasteAccountPrivilegeEntry> privileges) {
        this.privileges = privileges;
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
        NamasteAccountRoleEntry other = (NamasteAccountRoleEntry) obj;
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
        builder.append("NamasteAccountRole [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}
