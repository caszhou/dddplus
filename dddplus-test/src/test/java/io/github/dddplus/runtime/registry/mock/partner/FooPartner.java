package io.github.dddplus.runtime.registry.mock.partner;

import javax.validation.constraints.NotNull;

import io.github.dddplus.annotation.Partner;
import io.github.dddplus.ext.IIdentityResolver;
import io.github.dddplus.runtime.registry.mock.model.FooModel;

@Partner(code = FooPartner.CODE, name = "BP::foo")
public class FooPartner implements IIdentityResolver<FooModel> {
    public static final String CODE = "ddd.cn.ka";

    @Override
    public boolean match(@NotNull FooModel model) {
        return CODE.equals(model.getPartnerCode());
    }
}
