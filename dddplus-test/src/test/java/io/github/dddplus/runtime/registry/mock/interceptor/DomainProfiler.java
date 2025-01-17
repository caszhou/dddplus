package io.github.dddplus.runtime.registry.mock.interceptor;

import java.lang.annotation.*;

/**
 * 领域能力或领域步骤方法上的自动监控、拦截机制演示.
 * <p>
 * <p>
 * 应用在{@link io.github.dddplus.runtime.BaseDomainAbility}或{@link io.github.dddplus.step.IDomainStep}的公共方法上.
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DomainProfiler {}
