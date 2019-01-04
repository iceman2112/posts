package tatun;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tatun.enums.Roles;
import tatun.service.UserService;

@Component
public class Bootstrap implements InitializingBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        userService.createUser("admin", "admin", Roles.ADMIN);
    }
}
