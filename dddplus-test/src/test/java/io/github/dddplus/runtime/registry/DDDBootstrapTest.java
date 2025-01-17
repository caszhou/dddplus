package io.github.dddplus.runtime.registry;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import io.github.dddplus.runtime.registry.mock.MockStartupListener;
import io.github.dddplus.testing.AloneRunner;
import io.github.dddplus.testing.AloneWith;
import io.github.dddplus.testing.LogAssert;

@RunWith(AloneRunner.class)
@AloneWith(JUnit4.class)
public class DDDBootstrapTest {
    @Test
    public void reload() throws IOException {
        final String expectedLogEvent = "register applicationContext more than once, ignored!";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
        assertNotNull(DDDBootstrap.applicationContext());
        assertSame(applicationContext, DDDBootstrap.applicationContext());
        LogAssert.assertNotContains(expectedLogEvent, "Spring reloaded complete!");

        DDDBootstrap dddBootstrap = applicationContext.getBean(DDDBootstrap.class);

        dddBootstrap.setApplicationContext(applicationContext);
        LogAssert.assertContains(expectedLogEvent);

        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.setParent(applicationContext);
        ContextRefreshedEvent contextRefreshedEvent = new ContextRefreshedEvent(genericApplicationContext);
        dddBootstrap.onApplicationEvent(contextRefreshedEvent);
        LogAssert.assertContains("Spring reloaded complete!");

        applicationContext.close();
    }

    public void startupListenerCalledOnlyOnce() throws IOException {
        MockStartupListener.reset();

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-test.xml");
        LogAssert.assertContains("Spring started complete!", "calling IStartupListener");
        assertEquals(1, MockStartupListener.getCalled());

        // assure that after Spring application context refresh, the startup listener will not be triggered
        applicationContext.refresh();
        LogAssert.assertContains("Spring reloaded complete!");
        assertEquals(1, MockStartupListener.getCalled());

        applicationContext.close();
    }
}
