package tatun;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import tatun.service.UserService;

public class Bootstrap implements InitializingBean {

    @Autowired
    private UserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //userService.createUser("admin", "admin");
    }
}
