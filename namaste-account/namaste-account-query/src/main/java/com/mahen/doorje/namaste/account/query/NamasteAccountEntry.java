package com.mahen.doorje.namaste.account.query;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class NamasteAccountEntry {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountId;
    private String email;
    private String password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "namaste_accounts_roles",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<NamasteAccountRoleEntry> roles;

    @SuppressWarnings("unused")
    private NamasteAccountEntry() {
    }

    public NamasteAccountEntry(String accountId, String email, String password) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.enabled = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
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
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NamasteAccountEntry account = (NamasteAccountEntry) obj;
        if (!email.equals(account.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("NamasteAccount [id=").append(id).append(", email=").append(email).append(", password=").append(password).append(", enabled=").append(enabled).append(", roles=").append(roles).append("]");
        return builder.toString();
    }
}
