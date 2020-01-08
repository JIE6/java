package annotation;

import java.lang.annotation.*;

/**
 * @author JIE
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {

    String column();

    String type();
}
