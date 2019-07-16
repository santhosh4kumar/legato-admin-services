/**
 * 
 */
package com.legato.admin.services.jwt.security.dto;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.legato.admin.services.model.UserProfile;

/**
 * @author af83580
 *
 */
public class AppUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
    private String username;
    private String password;
    private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private int gender;
	private boolean active;
    private Collection<? extends GrantedAuthority> authorities;

    public AppUser() {
		// Auto-generated constructor stub
	}
    public AppUser(Long id, String firstName, String lastName,  
			    		String username, String email, String mobile, int gender, String password, 
			    		Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.password = password;
        this.authorities = authorities;
    }

    public static AppUser build(UserProfile user) {
        List<GrantedAuthority> authorities = user.getAuthorities().stream().map(role ->
                new SimpleGrantedAuthority(role.getAuthorityName())
        ).collect(Collectors.toList());

        return new AppUser(
                user.getId(),
                user.getFirstName(), 
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getMobile(), 
                user.getGender(), 
                user.getPassword(),
                authorities
        );
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AppUser user = (AppUser) o;
        return Objects.equals(id, user.id);
    }
    
    @Override
    public int hashCode() {
    	return super.hashCode();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}   
}