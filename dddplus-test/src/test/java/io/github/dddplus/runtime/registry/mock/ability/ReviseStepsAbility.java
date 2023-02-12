package io.github.dddplus.runtime.registry.mock.ability;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.github.dddplus.annotation.DomainAbility;
import io.github.dddplus.runtime.BaseDomainAbility;
import io.github.dddplus.runtime.registry.mock.domain.FooDomain;
import io.github.dddplus.runtime.registry.mock.ext.IReviseStepsExt;
import io.github.dddplus.runtime.registry.mock.model.FooModel;

@DomainAbility(domain = FooDomain.CODE, value = "mockReviseStepsAbility", tags = AbilityTag.reviseSteps)
public class ReviseStepsAbility extends BaseDomainAbility<FooModel, IReviseStepsExt> {
    public List<String> revisedSteps(@NotNull FooModel model) {
        return firstExtension(model).reviseSteps(model);
    }

    @Override
    public IReviseStepsExt defaultExtension(@NotNull FooModel model) {
        return null;
    }
}
