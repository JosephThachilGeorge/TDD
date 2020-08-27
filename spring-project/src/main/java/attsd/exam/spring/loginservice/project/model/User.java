package attsd.exam.spring.loginservice.project.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Document(collection = "user")
public class User implements UserDetails {

	@Id
    private BigInteger id;
	private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private String username;
    private String usernumber;
    private boolean enabled;

    
    public User() {
		super();
	}
   

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usernumber == null) ? 0 : usernumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (usernumber == null) {
			if (other.usernumber != null)
				return false;
		} else if (!usernumber.equals(other.usernumber))
			return false;
		return true;
	}


	public String getUsernumber() {
		return usernumber;
	}


	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}


}