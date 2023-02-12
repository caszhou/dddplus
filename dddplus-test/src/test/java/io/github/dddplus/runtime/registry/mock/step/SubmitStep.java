package io.github.dddplus.runtime.registry.mock.step;

import javax.validation.constraints.NotNull;

import io.github.dddplus.runtime.registry.mock.exception.FooException;
import io.github.dddplus.runtime.registry.mock.model.FooModel;
import io.github.dddplus.step.IRevokableDomainStep;

public abstract class SubmitStep implements IRevokableDomainStep<FooModel, FooException> {
    @Override
    public String activityCode() {
        return Steps.Submit.Activity;
    }

    @Override
    public void rollback(@NotNull FooModel model, @NotNull FooException cause) {}
}
