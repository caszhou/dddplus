package io.github.dddplus.runtime.registry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.github.dddplus.plugin.IPlugin;

public class PluginTest {
    @Test
    public void testToString() {
        IPlugin plugin = new Plugin("foo", "v1", null, null, null);
        assertEquals("Plugin:foo:v1", plugin.toString());
    }
}
