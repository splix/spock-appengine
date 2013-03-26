package com.the6hours.spockappengine

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 *
 * @author Igor Artamonov (http://igorartamonov.com)
 * @since 16.03.13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.METHOD])
@ExtensionAnnotation(GaeExtension)
public @interface WithGae {

}