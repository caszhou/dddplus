package io.github.dddplus.runtime.registry.mock.ability;

import javax.validation.constraints.NotNull;

import io.github.dddplus.annotation.DomainAbility;
import io.github.dddplus.runtime.BaseDomainAbility;
import io.github.dddplus.runtime.registry.mock.domain.FooDomain;
import io.github.dddplus.runtime.registry.mock.ext.INotImplementedExt1;
import io.github.dddplus.runtime.registry.mock.model.FooModel;
import lombok.extern.slf4j.Slf4j;

@DomainAbility(domain = FooDomain.CODE)
@Slf4j
public class NotImplementedAbility1 extends BaseDomainAbility<FooModel, INotImplementedExt1> {
    public void ping(FooModel model) {
        firstExtension(model).doSth();
    }

    @Override
    public INotImplementedExt1 defaultExtension(@NotNull FooModel model) {
        return null;
    }
}
