package shop.mtcoding.sercurityapp.env;

import org.hibernate.annotations.SourceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

public class EnvVarTest {

    @Test
    public void property_test() {
        String name = System.getProperty("meta.name");
        System.out.println(name);
    }

    @Test
    public void secret_test() {
        String key = System.getenv("HS512_SECRET");
        System.out.println(key);
    }
}
