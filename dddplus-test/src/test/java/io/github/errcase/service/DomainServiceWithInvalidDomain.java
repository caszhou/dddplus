package io.github.errcase.service;

import io.github.dddplus.annotation.DomainService;
import io.github.dddplus.model.IDomainService;
import io.github.dddplus.runtime.DDD;
import io.github.dddplus.runtime.registry.mock.ability.FooDomainAbility;
import io.github.dddplus.runtime.registry.mock.model.FooModel;
import lombok.extern.slf4j.Slf4j;

@DomainService(domain = "non-exist")
@Slf4j
public class DomainServiceWithInvalidDomain implements IDomainService {
    public void submitOrder(FooModel model) {
        FooDomainAbility ability = DDD.findAbility(FooDomainAbility.class);
        log.info(ability.submit(model));
    }
}
