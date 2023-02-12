package io.github.dddplus.runtime.registry.mock.ability;

import javax.validation.constraints.NotNull;

import io.github.dddplus.annotation.DomainAbility;
import io.github.dddplus.runtime.BaseDomainAbility;
import io.github.dddplus.runtime.registry.mock.domain.FooDomain;
import io.github.dddplus.runtime.registry.mock.ext.IPartnerExt;
import io.github.dddplus.runtime.registry.mock.model.FooModel;

@DomainAbility(domain = FooDomain.CODE, name = "partner")
public class PartnerAbility extends BaseDomainAbility<FooModel, IPartnerExt> {
    public String submit(FooModel model) {
        return String.valueOf(firstExtension(model).execute(model));
    }

    @Override
    public IPartnerExt defaultExtension(@NotNull FooModel model) {
        return null;
    }
}
