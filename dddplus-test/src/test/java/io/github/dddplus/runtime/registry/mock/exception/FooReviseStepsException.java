package io.github.dddplus.runtime.registry.mock.exception;

import java.util.List;

import io.github.dddplus.step.IReviseStepsException;
import lombok.Setter;

public class FooReviseStepsException extends RuntimeException implements IReviseStepsException {
    public FooReviseStepsException() {
        super();
    }

    public FooReviseStepsException(String message) {
        super(message);
    }

    @Setter
    private List<String> steps;

    public FooReviseStepsException withSubsequentSteps(List<String> subsequentSteps) {
        this.steps = subsequentSteps;
        return this;
    }

    @Override
    public List<String> subsequentSteps() {
        return steps;
    }
}
