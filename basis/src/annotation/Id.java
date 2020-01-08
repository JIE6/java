package annotation;

import java.lang.annotation.*;

/**
 * @author JIE
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Id {

    String column();

    String type();

    String generator();
}
