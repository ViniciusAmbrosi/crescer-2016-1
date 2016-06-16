package br.com.crescer.controllers;

import br.com.crescer.filters.User;
import br.com.crescer.utils.FacesUtils;
import br.com.crescer.utils.UserDetails;
import static br.com.crescer.utils.UserDetails.USER_AUTH;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class LoginController implements Serializable {

    private User user;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoggedUsername() {
        final UserDetails userDetails;
        userDetails = (UserDetails)FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getUsername();
    }
    
    public String login() {
        FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
        return "home";
    }
    
    public String logout() {
        FacesUtils.getSession().invalidate();
        return "logout";
    }
}
