package io.github.badcase.pattern;

import javax.validation.constraints.NotNull;

import io.github.dddplus.annotation.Pattern;
import io.github.dddplus.ext.IIdentityResolver;
import io.github.dddplus.model.IDomainModel;

@Pattern(code = InvalidPriorityPattern.CODE, name = "B2B模式", priority = -1)
public class InvalidPriorityPattern implements IIdentityResolver<IDomainModel> {
    public static final String CODE = "invalid";

    @Override
    public boolean match(@NotNull IDomainModel model) {
        return false;
    }
}
