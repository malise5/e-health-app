// The code is defining a custom annotation called `DbTable`. Annotations in Java are a way to add
// metadata to classes, methods, or fields.
package com.malise.database.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DbTable {

  String nameOfTable();

}
