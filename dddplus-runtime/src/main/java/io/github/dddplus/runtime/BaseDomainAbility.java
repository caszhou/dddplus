/*
 * Copyright DDDplus Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.dddplus.runtime;

import javax.validation.constraints.NotNull;

import io.github.dddplus.ext.IDomainExtension;
import io.github.dddplus.model.IDomainModel;
import io.github.dddplus.model.IDomainService;
import io.github.dddplus.runtime.registry.InternalIndexer;

/**
 * 基础领域能力，是一种业务多态能力：业务扩展能力.
 * <p>
 * <p>
 * {@code BaseDomainAbility}是最小粒度的{@link IDomainService}，只负责一个扩展点的编排
 * </p>
 *
 * @param <Model>
 *            领域模型
 * @param <Ext>
 *            领域能力扩展点
 */
public abstract class BaseDomainAbility<Model extends IDomainModel, Ext extends IDomainExtension>
    implements IDomainService {
    /**
     * 定位指定的扩展点实例.
     * <p>
     * <p>
     * 可以通过{@link IReducer}实现多个扩展点的执行
     * </p>
     *
     * @param model
     *            领域模型
     * @param reducer
     *            扩展点执行的归约器 如果为空，则等同于{@link #firstExtension(IDomainModel)}
     * @param <R>
     *            扩展点方法的返回值类型
     * @return null if not found
     */
    protected <R> Ext getExtension(@NotNull Model model, IReducer<R> reducer) {
        Class<? extends IDomainExtension> extClazz = InternalIndexer.getDomainAbilityExtDeclaration(this.getClass());
        return findExtension((Class<Ext>)extClazz, model, reducer, defaultExtension(model), 0);
    }

    /**
     * 找到第一个符合条件的扩展点实例.
     * <p>
     * <p>
     * 这表示：扩展点实例之间是互斥的，无法叠加的
     * </p>
     * <p>
     * 如果需要根据扩展点执行结果来找第一个匹配的扩展点实例，请使用{@link #getExtension(IDomainModel, IReducer)}
     * </p>
     *
     * @param model
     *            领域模型
     * @return null if not found
     */
    protected Ext firstExtension(@NotNull Model model) {
        return firstExtension(model, 0);
    }

    /**
     * 找到第一个符合条件的扩展点实例，并指定扩展点最大执行时长，超时抛出{@link java.util.concurrent.TimeoutException}.
     * <p>
     * <p>
     * 这表示：扩展点实例之间是互斥的，无法叠加的
     * </p>
     * <p>
     * 如果需要根据扩展点执行结果来找第一个匹配的扩展点实例，请使用{@link #getExtension(IDomainModel, IReducer)}
     * </p>
     *
     * @param model
     *            领域模型
     * @param timeoutInMs
     *            执行扩展点的超时时间，in ms；如果超时，会强行终止扩展点的执行
     * @return null if not found
     */
    protected Ext firstExtension(@NotNull Model model, int timeoutInMs) {
        Class<? extends IDomainExtension> extClazz = InternalIndexer.getDomainAbilityExtDeclaration(this.getClass());
        return findExtension((Class<Ext>)extClazz, model, null, defaultExtension(model), timeoutInMs);
    }

    public abstract Ext defaultExtension(@NotNull Model model);

    private <Ext extends IDomainExtension, R> Ext findExtension(@NotNull Class<Ext> extClazz, @NotNull Model model,
        IReducer<R> reducer, Ext defaultExt, int timeoutInMs) {
        ExtensionInvocationHandler<Ext, R> proxy =
            new ExtensionInvocationHandler<>(extClazz, model, reducer, defaultExt, timeoutInMs);
        return proxy.createProxy();
    }
}
