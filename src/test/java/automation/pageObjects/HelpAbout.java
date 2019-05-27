package automation.pageObjects;

public class HelpAbout {
    public final static String questionMarkButton = "//div[@class='span-svg-icon ng-isolate-scope' and @icon='help-icon']";
    public final static String getttingStartedPage = "//div[@class='rd-dialog-title rd-truncate-text ng-binding ng-scope' and @ng-if='headerText.length > 0']";
    public final static String closeGettingStarted = "//div[@class='rd-svg-icon-small common-button common-button-icon rd-close-icon span-svg-icon ng-isolate-scope' and @icon='close-icon']";
    public final static String gettinStarted = "//li[@ng-click='ctrl.showGettingStarted()']";
    public final static String customerSupport = "Customer Support";
    public final static String showAbout = "//li[@ng-click='ctrl.showAbout()']";
    public final static String getSpanWorkspaceInformation = "http://www.nureva.com/privacy-policy";
    public final static String swLicense = "//*[contains(text(), 'Software license and general terms of use')]";
    public final static String radioFrench = "//input[@id='french']";
    public final static String radioEnglish = "//input[@id='english']";
    public final static String intellectualProperty = "//*[contains(text(), 'Intellectual property statement')]";
    public final static String statement = "//span[@class='ip=subtitle']";
}
