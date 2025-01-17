package io.github.dddplus.runtime.registry.mock.step;

import javax.validation.constraints.NotNull;

import io.github.dddplus.annotation.Step;
import io.github.dddplus.runtime.registry.mock.exception.FooException;
import io.github.dddplus.runtime.registry.mock.model.FooModel;
import lombok.extern.slf4j.Slf4j;

@Step
@Slf4j
public class EggStep extends CancelStep {
    @Override
    public void execute(@NotNull FooModel model) throws FooException {
        log.info("submit: {}", model);
    }

    @Override
    public String stepCode() {
        return Steps.Cancel.EggStep;
    }
}
