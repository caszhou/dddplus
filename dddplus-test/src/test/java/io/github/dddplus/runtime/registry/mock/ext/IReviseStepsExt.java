package io.github.dddplus.runtime.registry.mock.ext;

import java.util.List;

import io.github.dddplus.ext.IDomainExtension;
import io.github.dddplus.runtime.registry.mock.model.FooModel;

public interface IReviseStepsExt extends IDomainExtension {
    List<String> reviseSteps(FooModel model);
}
