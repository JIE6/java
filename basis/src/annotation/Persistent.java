package annotation;

import java.lang.annotation.*;

/**
 * @author JIE
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Persistent {

    String table();
}
