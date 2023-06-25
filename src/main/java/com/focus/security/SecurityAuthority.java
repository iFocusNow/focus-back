package com.focus.security;

import com.focus.model.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private Authority authority;
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
