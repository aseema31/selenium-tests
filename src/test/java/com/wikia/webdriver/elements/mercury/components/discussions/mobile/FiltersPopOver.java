package com.wikia.webdriver.elements.mercury.components.discussions.mobile;

import com.wikia.webdriver.elements.mercury.components.discussions.common.SortOption;
import com.wikia.webdriver.elements.mercury.components.discussions.common.category.CategoriesFieldset;
import com.wikia.webdriver.elements.mercury.pages.discussions.BasePage;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersPopOver extends BasePage {

  @Getter(lazy = true)
  private final CategoriesFieldset categoriesFieldset = new CategoriesFieldset();

  @FindBy(css = ".discussion-header .wds-icon.filter-default")
  private WebElement filterButton;

  @Getter
  @FindBy(css = ".discussion-filters .discussion-sort")
  private WebElement sortingFilter;

  @FindBy(css = ".pop-over-container .sortby-fieldset .sort-trending")
  private WebElement trendingOptionInSortMenu;

  @FindBy(css = ".pop-over-container .sortby-fieldset .sort-latest")
  private WebElement latestOptionInSortMenu;

  @FindBy(css = ".pop-over-container .filters-apply-container .filters-apply")
  private WebElement applyButtonInSortMenu;

  @FindBy(css = ".pop-over-container")
  private WebElement sortOptionsMobile;

  public FiltersPopOver click() {
    waitAndClick(filterButton);
    return this;
  }

  public FiltersPopOver chooseSortingOption(SortOption option) {
    if (option == SortOption.LATEST) {
      scrollAndClick(latestOptionInSortMenu);
    } else if (option == SortOption.TRENDING) {
      scrollAndClick(trendingOptionInSortMenu);
    } else {
      throw new IllegalArgumentException(String.format(
          "Option %s not supported by sorting",
          option
      ));
    }
    return this;
  }

  public FiltersPopOver clickApplyButton() {
    scrollAndClick(applyButtonInSortMenu);
    return this;
  }

  public boolean isSortingFilterEnabled() {
    return isElementEnabled(getSortingFilter());
  }
}
