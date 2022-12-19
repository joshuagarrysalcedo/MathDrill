package ph.jsalcedo.mathdrill.mathdrill.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Retrieve {
    String value() default "";
}
