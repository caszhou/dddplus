package io.github.dddplus.runtime.registry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DomainArtifactsTest {
    @Test
    public void instanceIsSingleton() {
        assertSame(DomainArtifacts.getInstance(), DomainArtifacts.getInstance());
    }

    @Test
    public void neverNPEafterExport() {
        DomainArtifacts instance = DomainArtifacts.getInstance();
        instance.export();

        assertNotNull(instance);
        assertNotNull(instance.getSteps());
        assertNotNull(instance.getSpecifications());
        assertNotNull(instance.getDomains());
        assertNotNull(instance.getExtensions());
    }

    @Test
    public void testPartnerEqualsAndHashcode() {
        DomainArtifacts.Partner partner1 = new DomainArtifacts.Partner("code", "name");
        DomainArtifacts.Partner partner2 = new DomainArtifacts.Partner("code", "name");
        assertEquals(partner1, partner2);
        assertEquals(partner1.hashCode(), partner2.hashCode());

        List<DomainArtifacts.Partner> partnerList = new ArrayList<>();
        partnerList.add(partner1);
        assertTrue(partnerList.contains(partner2));

        // the negative test
        DomainArtifacts.Partner partner3 = new DomainArtifacts.Partner("a", "b");
        assertNotEquals(partner1, partner3);
        assertNotEquals(partner1.hashCode(), partner3.hashCode());
        assertFalse(partnerList.contains(partner3));
    }
}
