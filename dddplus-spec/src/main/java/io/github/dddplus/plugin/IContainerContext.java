/*
 * Copyright DDDplus Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.dddplus.plugin;

import javax.validation.constraints.NotNull;

/**
 * 容器提供给插件的上下文信息.
 */
public interface IContainerContext {
    /**
     * Return the bean instance that uniquely matches the given object type, if any.
     *
     * @param requiredType
     *            type the bean must match; can be an interface or superclass
     * @param <T>
     * @return an instance of the single bean matching the required type
     * @throws RuntimeException
     */
    <T> T getBean(@NotNull Class<T> requiredType) throws RuntimeException;

    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     *
     * @param name
     *            the name of the bean to retrieve
     * @param requiredType
     *            type the bean must match; can be an interface or superclass
     * @param <T>
     * @return an instance of the bean
     * @throws RuntimeException
     */
    <T> T getBean(@NotNull String name, @NotNull Class<T> requiredType) throws RuntimeException;
}
