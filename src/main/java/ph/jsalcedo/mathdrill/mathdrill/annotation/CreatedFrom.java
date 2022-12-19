package ph.jsalcedo.mathdrill.mathdrill.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatedFrom {
    String source();
}
