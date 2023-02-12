package io.github.dddplus.runtime.registry.mock.step;

import org.springframework.stereotype.Component;

import io.github.dddplus.runtime.StepsExecTemplate;
import io.github.dddplus.runtime.registry.mock.model.FooModel;

@Component
public class SubmitStepsExec extends StepsExecTemplate<SubmitStep, FooModel> {}
