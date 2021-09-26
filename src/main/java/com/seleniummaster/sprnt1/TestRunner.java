package com.seleniummaster.sprnt1;

public class TestRunner extends TestBase {
    public static void main(String[] args) {
        browserSetUp();
        LoginUser user = new LoginUser("AbduShukur", "Hakan!@#88");
        LoginPage loginPage = new LoginPage();
        loginPage.login(user);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickMainMenu();
        dashBoardPage.clickOnEngageLink();
        dashBoardPage.clickOnGroupsLink();
        dashBoardPage.clickGroupsLink();
        dashBoardPage.groupName();
        dashBoardPage.groupDescription();
        dashBoardPage.friendInvitationsButton();
        dashBoardPage.publiclyViewableGroupButton();
        dashBoardPage.participationReportButton();
        dashBoardPage.saveGroupButton();
        dashBoardPage.verifyGroup();
        closeBrowser();
    }
}
