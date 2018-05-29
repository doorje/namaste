package com.mahen.doorje.namaste.security;

import com.mahen.doorje.namaste.account.query.NamasteAccountEntry;
import com.mahen.doorje.namaste.account.query.NamasteAccountPrivilegeEntry;
import com.mahen.doorje.namaste.account.query.NamasteAccountRepository;
import com.mahen.doorje.namaste.account.query.NamasteAccountRoleEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class NamasteUserDetailsService implements UserDetailsService {

    @Autowired
    private NamasteAccountRepository namasteAccountRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        try {
            final NamasteAccountEntry namasteAccount = namasteAccountRepository.findByEmail(email);
            if (namasteAccount == null) {
                throw new UsernameNotFoundException("User not found with username: " + email);
            }

            return new User(
                    namasteAccount.getAccountId(),
                    namasteAccount.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    getAuthorities(namasteAccount.getRoles()));
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private final Collection<? extends GrantedAuthority> getAuthorities(final Collection<NamasteAccountRoleEntry> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private final List<String> getPrivileges(final Collection<NamasteAccountRoleEntry> roles) {
        final List<String> privileges = new ArrayList<String>();
        final List<NamasteAccountPrivilegeEntry> collection = new ArrayList<NamasteAccountPrivilegeEntry>();
        for (final NamasteAccountRoleEntry role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (final NamasteAccountPrivilegeEntry item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
