package com.adobe.aem.wknd.core.models;

import com.adobe.aem.wknd.core.models.dto.NavigationItem;

import java.util.List;

public interface AemPracticeModel {
    String getImagePath();

    boolean isBackgroundImage();

    List<NavigationItem> getNavigationItems();

}
