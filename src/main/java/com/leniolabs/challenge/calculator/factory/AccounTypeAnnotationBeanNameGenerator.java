package com.leniolabs.challenge.calculator.factory;

import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.lang.Nullable;

/**
 * An extension of {@code AnnotationBeanNameGenerator} that uses the value of
 * {@code AccountType} annotation as the default bean name for every {@code FeeCalculatorIF}
 * implementation.
 * 
 * @author Miguel
 *
 */
public class AccounTypeAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator {

	private static final String ACCOUNT_TYPE_ANNOTATION_CLASSNAME = "com.leniolabs.challenge.custom.AccountType";

	public static final FullyQualifiedAnnotationBeanNameGenerator INSTANCE = new FullyQualifiedAnnotationBeanNameGenerator();

	/**
	 * 
	 */
	protected boolean isStereotypeWithNameValue(String annotationType, Set<String> metaAnnotationTypes,
			@Nullable Map<String, Object> attributes) {

		boolean isStereotype = super.isStereotypeWithNameValue(annotationType, metaAnnotationTypes, attributes)
				|| annotationType.equals(ACCOUNT_TYPE_ANNOTATION_CLASSNAME);

		return (isStereotype && attributes != null && attributes.containsKey("value"));
	}
}
