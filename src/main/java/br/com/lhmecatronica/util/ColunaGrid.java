/*
 */
package br.com.lhmecatronica.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.METHOD, ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ColunaGrid {

    boolean mostraColuna() default true;

    boolean podeEditar() default false;

    String nome() default "";

    int lenght() default 0;

    int largura() default 50;

    String metodoGet() default "";

}
