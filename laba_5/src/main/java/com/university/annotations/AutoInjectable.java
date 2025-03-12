package com.university.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для пометки полей
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {}