package com.adobe.aem.wknd.core.models.dto;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationItem {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String path;

    public String getTitle() {
        return "TEST_"+title;
    }

    public String getPath() {
        return path;
    }
}
