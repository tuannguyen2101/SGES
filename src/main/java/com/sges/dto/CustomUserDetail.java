package com.sges.dto;
import com.sges.entity.User;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class CustomUserDetail implements UserDetails, OAuth2User {

    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String avatar;
    private String fullname;
    private String email;
    private String phone;
    private Integer gender;
    private Integer status;
    private Collection<? extends GrantedAuthority> authorities;

    private Map<String, Object> attributes;

    public CustomUserDetail(Integer id, String username, String password, String avatar, String fullname, String email, String phone, Integer gender, Integer status, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.authorities = authorities;
    }

    public static CustomUserDetail build(User user){
        List<GrantedAuthority>authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());

        return new CustomUserDetail(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getAvatar(),
                user.getFullname(),
                user.getEmail(),
                user.getPhone(),
                user.getGender(),
                user.getStatus(),
                authorities);
    }
    public static CustomUserDetail create(User user, Map<String, Object> attributes) {
        CustomUserDetail userPrincipal = CustomUserDetail.build(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomUserDetail user = (CustomUserDetail) o;
        return Objects.equals(id, user.id);
    }

}
