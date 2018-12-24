package tatun;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.awt.AppContext;
import tatun.service.CategoryService;

public class TestConfig {

    @Test
    public void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        CategoryService c = context.getBean(CategoryService.class);
       // javax/persistence/ValidationMode
    }
}
