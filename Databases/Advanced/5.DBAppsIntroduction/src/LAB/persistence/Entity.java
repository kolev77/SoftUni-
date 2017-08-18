package LAB.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Rostislav Kolev on 18-Jul-17.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // only for classes
public @interface Entity {
    String name();
}
