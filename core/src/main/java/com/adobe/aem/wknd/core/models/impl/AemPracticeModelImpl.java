package com.adobe.aem.wknd.core.models.impl;

import com.adobe.aem.wknd.core.models.AemPracticeModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.aem.wknd.core.models.dto.NavigationItem;
import org.apache.sling.settings.SlingSettingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

@Model(
    adaptables = { Resource.class },
    adapters = { AemPracticeModel.class },
    resourceType = { AemPracticeModelImpl.RESOURCE_TYPE },
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AemPracticeModelImpl implements AemPracticeModel{

    private static final Logger LOG = LoggerFactory.getLogger(AemPracticeModelImpl.class);
    protected static final String RESOURCE_TYPE = "wknd/components/AemPractice";

    @ChildResource(name = "navigationItems")
    private List<NavigationItem> navigationItems;

    @ValueMapValue
    private String imagePath;

    public List<NavigationItem> getNavigationItems() {
        return navigationItems;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isBackgroundImage() {
        List<String> allowedExtensions = Arrays.asList("png", "jpg", "jpeg", "gif");
        String imageExtension;
        if (imagePath.lastIndexOf(".") != -1) {
            imageExtension = imagePath.substring(imagePath.lastIndexOf(".") + 1);
            if(allowedExtensions.contains(imageExtension)){
                return true;
            };
        }
        return false;
    }

}
