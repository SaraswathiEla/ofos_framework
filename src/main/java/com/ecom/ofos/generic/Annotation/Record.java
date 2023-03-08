package com.ecom.ofos.generic.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * user defined method level annotation to set the autor and catagory.
 * @author Saraswathi B
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Record {
	public String author();
	public String[]  category() default"regression";
	

}
