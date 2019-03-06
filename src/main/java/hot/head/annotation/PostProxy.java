package hot.head.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * работает только на интерфейсах
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostProxy {
}
