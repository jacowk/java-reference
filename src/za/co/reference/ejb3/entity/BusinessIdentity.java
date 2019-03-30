package za.co.reference.ejb3.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BusinessIdentity{
	
	String bidProperty() default "";
	NameProperty[] nameProperties() default {};
	
}