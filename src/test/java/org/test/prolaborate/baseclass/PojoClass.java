package org.test.prolaborate.baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.PageFactory.*;

public class PojoClass extends BaseClass {
	public static Select s;

	public PojoClass() {
		initElements(driver, this);
	}
// Muja Pojo class 

	// Elements

	@FindBy(xpath = "//*[@id='emailid']")
	private WebElement loginUserName;

	@FindBy(xpath = "//span[text()='Sync Users']")
	private WebElement syncUsers;

	@FindBy(xpath = "//input[@id='LoginPassword']")
	private WebElement loginPassword;

	@FindBy(xpath = "//input[@if='firstName']")
	private WebElement signUpFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement signUpLastname;

	@FindBy(xpath = "//div[5]/div/div/div[2]/app-dropdown/div/a")
	private WebElement Reviewdata;

	@FindBy(xpath = "//tr[1]/td[1]//a//span")
	private WebElement RepoName;

	@FindBy(xpath = "//span[text()='Stats']")
	private WebElement reviewStats;

	@FindBy(xpath = "(//span[starts-with(@class,'action-icon')])[1]")
	private WebElement ActionButtonInDiscussion;

	@FindBy(xpath = "(//span[text()='Download PDF'])[1]")
	private WebElement export_Discussion;

	@FindBy(xpath = "(//span[text()='Share'])[1]")
	private WebElement share_Discussion;

	@FindBy(xpath = "(//span[2]/app-dropdown/div/a/span)[1]")
	private WebElement replied_ActionButtonInDiscussion;

	@FindBy(xpath = "//app-start-discussion/div[2]/app-select/ng-select/div/span")
	private WebElement Discussion_Priority_Change;

	@FindBy(xpath = "//div/div/div[3]/app-select[1]/ng-select/div/span")
	private WebElement Edit_Discussion_Priority_DropDown;

	@FindBy(xpath = "(//app-single-discussion/div/div/div[2]/div)[1]")
	private WebElement Discussion_Posted_data;

	@FindBy(xpath = "//div/div/div[2]/div/div[2]/div/div[1]/p")
	private WebElement replied_Discussion_Posted_data;

	@FindBy(xpath = "//div/table/tbody/tr[2]/td")
	private WebElement Discussion_RestrictedAccess;

	@FindBy(xpath = "//div[@class='popover-body']")
	private WebElement Discussion_RestrictedAccessMessage;

	@FindBy(xpath = "//ngb-alert[contains(text(),'empty')]")
	private WebElement Discussion_EmptyMessage;

	@FindBy(xpath = "//ngb-alert[contains(text(),'edit mode')]")
	private WebElement Discussion_EditModeMessage;

	@FindBy(xpath = "//ngb-alert[contains(text(),'deleted')]")
	private WebElement Discussion_deletedMessage;

	@FindBy(xpath = "//div/div/div[1]/div[2]/span/span[1]/span")
	private WebElement Discussion_Priority;

	@FindBy(xpath = "(//div[1]/strong/a[2])[1]")
	private WebElement Discussion_Prefix_identifier;

	@FindBy(xpath = "//span[starts-with(text(),'Diagrams ')]")
	private WebElement reviewDiagrams;

	@FindBy(xpath = "(//a[starts-with(@class,'position')])[1]")
	private WebElement reviewDiagram1;

	@FindBy(xpath = "//span[text()='Approve']")
	private WebElement actionApprove;

	@FindBy(xpath = "(//span[text()='Approve'])[3]")
	private WebElement actionApprove1;

	@FindBy(xpath = "(//span[text()='Reviewed'])[1]")
	private WebElement actionReview1;

	@FindBy(xpath = "//span[text()='Review']")
	private WebElement actionReview;

	@FindBy(xpath = "//span[starts-with(text(),' Portable')]")
	private WebElement portableAudio_element;

	@FindBy(xpath = "(//span[text()='Approve'])[4]")
	private WebElement actionApprove2;

	@FindBy(xpath = "(//span[text()='Approve'])[1]")
	private WebElement actionApproveInfo;

	@FindBy(xpath = "//span[text()='Reject']")
	private WebElement actionReject;

	@FindBy(xpath = "//span[starts-with(text(),'Items ')]")
	private WebElement reviewItems;

	@FindBy(xpath = "//div[1]/div/div[1]/fa-icon")
	private WebElement packageDropdownInReviewItemsTab;

	@FindBy(xpath = "//span[text()='Summary']")
	private WebElement Summary;

	@FindBy(xpath = "//span[text()='Tree']")
	private WebElement TreeView;

	@FindBy(xpath = "(//label)[1]")
	private WebElement TreeViewbutton;

	@FindBy(xpath = "(//label)[2]")
	private WebElement ListViewbutton;

	@FindBy(xpath = "//span[starts-with(text(),'Change Profile')]")
	private WebElement changeAuthorProfilePic;

	@FindBy(xpath = "//app-image-cropper/div[2]/app-input/input")
	private WebElement chooseAuthorProfilePic;

	@FindBy(xpath = "//div/div[5]/div/div/div[2]/app-dropdown/div/div/div[4]/div/a[2]")
	private WebElement CreateRev;

	@FindBy(xpath = "(//span[text()='Create'])[1]")
	private WebElement createdashboard;

	@FindBy(xpath = "//p[starts-with(text(),'Email is')]")
	private WebElement ExistingUserMessage;

	@FindBy(xpath = "//div[1]/app-reactiveforminput/input")
	private WebElement RevName;

	@FindBy(xpath = "//div/div[1]/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]")
	private WebElement RevStartMon;

	@FindBy(xpath = "//div/div[1]/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[2]")
	private WebElement RevStartYear;

	@FindBy(xpath = "//div[1]/div/div[1]/div/app-reactive-date-picker/div/div/div/div[2]/app-button/button")
	private WebElement RevStartDate;

	@FindBy(xpath = "//div/div[1]/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]")
	private WebElement RevEndMon;

	@FindBy(xpath = "//div/div[1]/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[2]")
	private WebElement RevEndYear;

	@FindBy(xpath = "//div[1]/div/div[2]/div/app-reactive-date-picker/div/div/div/div[2]/app-button/button")
	private WebElement RevEndDate;

	// @FindBy(xpath="//label[@for='reviewWorkFlow']")
	// private WebElement ApprEnable;
	
	@FindBy(xpath = "//app-reactive-date-picker[@controlname='approveStartDate']//button[@type='button']")
	private WebElement ApprStartDate;

	@FindBy(xpath = "//select[@title='Select month']")
	private WebElement ApprStartMon;

	@FindBy(xpath = "//select[@title='Select year']")
	private WebElement ApprStartYear;

	@FindBy(xpath = "//select[@title='Select month']")
	private WebElement ApprEndMon;
	
	@FindBy(xpath = "//select[@title='Select year']")
	private WebElement ApprEndYear;
	
	@FindBy(xpath = "//app-reactive-date-picker[@controlname='approveEndDate']//button[@type='button']")
	private WebElement ApprEndDate;
	
	@FindBy(xpath = "//textarea")
	private WebElement Description;

	@FindBy(xpath = "//app-button-theme/app-button/button")
	private WebElement Next;

	@FindBy(xpath = "//app-checkbox/div/input")
	private WebElement SelectAll;

	@FindBy(xpath = "(//span[starts-with(@class,'select-option-label')])[2]")
	private WebElement TypeName;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement checkBox2;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement SelectRevItems;

	@FindBy(xpath = "//div[1]/div/div[3]/app-button-theme/app-button/button/span")
	private WebElement AddCon;

	@FindBy(xpath = "//button//span[text()='Add']")
	private WebElement AddGroupCon;

	@FindBy(xpath = "(//div[@class='text-sm1 cursor-pointer'])[2]")
	private WebElement administrator;

	@FindBy(xpath = "(//span[starts-with(text(),'Administrator')])[1]")
	private WebElement administrator_UserGroup;

	@FindBy(xpath = "//span[text()='test']")
	private WebElement test_UserGroup;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[1]")
	private WebElement dropDown1;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[2]")
	private WebElement dropDown2;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[3]")
	private WebElement dropDown3;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[4]")
	private WebElement dropDown4;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[5]")
	private WebElement dropDown5;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[6]")
	private WebElement dropDown6;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[7]")
	private WebElement dropDown7;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[8]")
	private WebElement dropDown8;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[9]")
	private WebElement dropDown9;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted'][normalize-space()='Reviewer'][1]")
	private WebElement SelectRoleRev;

	@FindBy(xpath = "//span[contains(text(),'Reviewers')]")
	private WebElement inviteReviewer;

	@FindBy(xpath = "//span[starts-with(text(),'Invite')]")
	private WebElement InviteOption;
	
	@FindBy(xpath = "//app-type-head/div/div/input")
	private WebElement Invite_collaborator;

	@FindBy(xpath = "//input[@id='invite']")
	private WebElement Review_InviteUser_toggle;

	@FindBy(xpath = "//input[@id='notification']")
	private WebElement Review_EmailNotification_toggle;

	@FindBy(xpath = "(//span[normalize-space()='Approver'])[1]")
	private WebElement SelectRoleAppr;

	@FindBy(xpath = "(//span[text()='Approver'])[2]")
	private WebElement SelectRoleAppr2;

	@FindBy(xpath = "//span[normalize-space()='None'][1]")
	private WebElement SelectRoleNone;

	@FindBy(xpath = "(//span[normalize-space()='None'])[2]")
	private WebElement SelectRoleNone2;

	@FindBy(xpath = "//span[contains(text(),'Invited')]")
	private WebElement invitedCollaboratorsList;

	@FindBy(xpath = "//*[starts-with(@id,'49ef9259')]")
	private WebElement SelectRoleModerator;

	@FindBy(xpath = "//app-create-review-all-steps/div/div/div/app-button-theme/app-button/button/span")
	private WebElement CreateRevSaveButton;

	@FindBy(xpath = "//span[normalize-space()='Open Review']")
	private WebElement OpenRev;

	@FindBy(xpath = "//span[contains(text(),'List')]")
	private WebElement OpenRevList;

	@FindBy(xpath = "//img[@class='d-inline-block rounded-circle user-icon']")
	private WebElement profile;

	@FindBy(xpath = "//input[@id='invite']")
	private WebElement InviteChkBox;

	@FindBy(xpath = "//app-create-review-left-section/div/div[1]//app-button/button")
	private WebElement inviteContributor;

	@FindBy(xpath = "//input[@id='notification']")
	private WebElement emailNotificationChkBox;

	@FindBy(xpath = "//a[@class='dropdown-toggle btn btn-theme-alt']")
	private WebElement FilterDropdown;

	@FindBy(xpath = "//input[@id='includearchivedreviews']")
	private WebElement archievedRev;

	@FindBy(xpath = "//span[normalize-space()='Apply']")
	private WebElement filterApply;

	@FindBy(xpath = "(//span[contains(text(),'Archived')])[1]")
	private WebElement achivetext;

	@FindBy(xpath = "//div[@class='right-section']//div[2]")
	private WebElement removeItems;

	@FindBy(xpath = "(//span[starts-with(@class,'ng-arrow-wrapper')])[1]")
	private WebElement dropdownInShare;

	@FindBy(xpath = "//span[text()='Embed']")
	private WebElement embedSelectionInShare;
	
	@FindBy(xpath = "(//span[text()='Public'])[2]")
	private WebElement public_SelectionInShare;

	@FindBy(xpath = "//span[text()=' Activity ']")
	private WebElement ActivityPackage;

	@FindBy(xpath = "//li/ul/p-treenode[1]/li/ul/p-treenode[2]/li/div/div/div")
	private WebElement AnalysisPackage;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[2]")
	private WebElement item1;
	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[3]")
	private WebElement item2;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[4]")
	private WebElement item3;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[5]")
	private WebElement item4;

	@FindBy(xpath = "(//div[@class='p-checkbox-box'])[6]")
	private WebElement item5;

	@FindBy(xpath = "//p-treenode[22]/li/div/div/div")
	private WebElement item6;

	@FindBy(xpath = "//div[@aria-label='Example Model']//button[@type='button']")
	private WebElement itemsDropDown;

	@FindBy(xpath = "//li/ul/p-treenode[1]/li/div/button")
	private WebElement allTypeOfDiagramDropDown;

	@FindBy(xpath = "//app-create-review-step-two-right-section/div/div[2]/div/div[1]/div[2]/div/div[2]")
	private WebElement removeItem1;

	@FindBy(xpath = "//app-create-review-step-two-right-section/div/div[2]/div/div[2]/div[2]/div/div[2]")
	private WebElement removeItem2;

	@FindBy(xpath = "//app-create-review-step-two-right-section/div/div[2]/div/div[3]/div[2]/div/div[2]")
	private WebElement removeItem3;

	@FindBy(xpath = "//app-create-review-step-two-right-section/div/div[2]/div/div[4]/div[2]/div/div[2]")
	private WebElement removeItem4;

	@FindBy(xpath = "//div/div[1]/app-review-management-single-card/div/div[4]/div[2]")
	private WebElement incompleteRev;

	@FindBy(xpath = "(//div[3]/div[2]/div/div[1])[1]")
	private WebElement myStatus_review;

	@FindBy(xpath = "(//span[text()=' All Type Of Diagram '])[1]")
	private WebElement alltypeofDiagram;

	@FindBy(xpath = "//div[2]/app-select[2]/ng-select/div/span")
	private WebElement reviews_DropDown_in_Discussion;

	@FindBy(xpath = "//div[1]/app-review-management-single-card/div/div[4]/div[2]/span")
	private WebElement NotYetToStartRev;

	@FindBy(xpath = "//span[2]/span/span")
	private WebElement itemText;

	@FindBy(xpath = "//div[@class='tooltip-inner']")
	private WebElement disableText;

	@FindBy(xpath = "//*[@id='ngb-nav-0']/span")
	private WebElement ItemsListCheck;

	@FindBy(xpath = "//label[text()=' List ']")
	private WebElement List;

	@FindBy(xpath = "//p[starts-with(text(),'You')]")
	private WebElement inviteExisting_User_ErrorMessage;

	@FindBy(xpath = "(   //div[1]/div[1]/div/span/app-validation/span)[1]")
	private WebElement RevUnameErrMsg;

	@FindBy(xpath = "//div[@class='ngb-dp-day ngb-dp-today ng-star-inserted']")
	private WebElement RevDefaultStartDate;

	@FindBy(xpath = "//span[contains(text(),'Review start date should not be earlier than today')]")
	private WebElement RevPastStartDate;

	@FindBy(xpath = "//span[contains(text(),'End Date should not be blank')]")
	private WebElement endDateErrMsg;

	@FindBy(xpath = "//span[contains(text(),'End date should not be before Start date')]")
	private WebElement endDatePriorErrMsg;

	@FindBy(xpath = "(//span[contains(text(),'Not')])[2]")
	private WebElement notReviewed;

	@FindBy(xpath = "//div[text()='Review Created Successfully']")
	private WebElement revCreatedMsg;

	@FindBy(xpath = "//span[text()='Start Date should not be blank']")
	private WebElement ApprStrtErrMsg;

	@FindBy(xpath = "//span[text()='End Date should not be blank']")
	private WebElement ApprEndErrMsg;

	@FindBy(xpath = "//span[contains(text(),'End date should not be less than Approve Start date')]")
	private WebElement ApprEndPriorErrMsg;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[1]/div[3]/app-button-clear[1]/app-button[1]")
	private WebElement deleteConAdmin;

	@FindBy(xpath = "//div[1]/app-review-management-single-card/div/div[2]/h4/span")
	private WebElement UName;

	@FindBy(xpath = "(//strong/fa-icon[@class='ng-fa-icon icon-hover-style'])[3]")
	private WebElement notificationBox;

	@FindBy(xpath = "(//span[contains(text(),'Low')])[2]")
	private WebElement lowPriority;

	@FindBy(xpath = "//app-select[2]/ng-select/div/span")
	private WebElement discussionStatus_dropDown;

	@FindBy(xpath = "//div[starts-with(text(),'Show')]")
	private WebElement Discussion_bubble;

	@FindBy(xpath = "//div[starts-with(text(),'Hide')]")
	private WebElement hideDiscussion_bubble;

	@FindBy(xpath = "//span/app-dropdown/div/div/div[2]/div/a[1]/span/span[2]")
	private WebElement invited_Discussion;

	@FindBy(xpath = "//div[contains(text(),'Sections')]")
	private WebElement Sections;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	private WebElement signUp;

	@FindBy(xpath = "//app-user-profile-view/div[2]/div[1]/div/a/fa-icon")
	private WebElement authorProfileEdit;

	@FindBy(xpath = "//img[@class='w-100']")
	private WebElement authorProfile;

	@FindBy(xpath = "//div[@aria-label='Example Model']/button")
	private WebElement ExPackageScroll;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement createProfileTextarea;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement addAllRepositoryToAccessProfile;

	@FindBy(xpath = "//a//div[normalize-space()='User and License Management']")
	private WebElement UserLicenseAct_InAct;

	@FindBy(xpath = "//div/div[2]/div/div[3]/app-button-clear")
	private WebElement deleteAllWithAdminCon;

	@FindBy(xpath = "//span[text()='  AD10151']//following::span[16]")
	private WebElement UserLicenseEdit;

	@FindBy(xpath = "//p-treenode/li/ul/p-treenode[1]/li/ul/p-treenode[5]/li/div/button")
	private WebElement compositeDropDown;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement UserSave;

	@FindBy(xpath = "//*[@id='ngb-nav-0-panel']/app-repository-user-list/div[2]/app-datatable/div/p-table/div/div[2]/table/tbody/tr[1]/td[8]/app-datatables-action/div/div[1]/app-button-clear/app-button/button/span")
	private WebElement ADUserStatusEdit;

	@FindBy(xpath = "//div[normalize-space()='General Settings']")
	private WebElement generalSetting;

	@FindBy(xpath = "//div[contains(text(),'Enable')]")
	private WebElement hoveringMsg;


	@FindBy(xpath = "(//input[starts-with(@class,'form-check-input')])[4]")
	private WebElement group_reviewsCheckbox;

	@FindBy(xpath = "(//span[text()='Save'])[2]")
	private WebElement htmlWidgetSave;

	@FindBy(xpath = "//span[(text()='Save')]")
	private WebElement Save;

	@FindBy(xpath = "//span[text()='Add Groups']")
	private WebElement addGroupInAD;

	@FindBy(xpath = "//span[text()='Add Users']")
	private WebElement addUsersInAD;

	@FindBy(xpath = "(//span[text()='Add'])[2]")
	private WebElement Add;

	@FindBy(xpath = "//span[starts-with(@class,'d-inline-block align-bottom')]")
	private WebElement listOfADgroup;

	@FindBy(xpath = "(//div[@class='ng-value ng-star-inserted'])[1]")
	private WebElement timeZoneSearchbox;

	@FindBy(xpath = "//div[text()='No items found']")
	private WebElement noItemsFound;

	@FindBy(xpath = "//div[text()=' Mailer Configuration ']")
	private WebElement mailerConfiguration;

	@FindBy(xpath = "//div[text()=' Embeddable Link Defaults ']")
	private WebElement embeddedLinks;

	@FindBy(xpath = "//div[text()=' Theme Settings ']")
	private WebElement themeSetting;

	@FindBy(xpath = "//img[@src='/VirtualAssets/Images/logo.png']")
	private WebElement prolaborateLogo;

	@FindBy(xpath = "(//a[starts-with(@class,'dropdown-toggle ')])[2]")
	private WebElement dashboardArrow;
	
	@FindBy(xpath = "(//span[text()='View All'])[2]")
	private WebElement dashboard_viewAll;

	@FindBy(xpath = "//div[text()=' Repository Settings ']")
	private WebElement repoSetting;

	@FindBy(xpath = "//app-notes-block/div/div/div/p")
	private WebElement Notes;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SettingSave;

	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//a/fa-icon[@class='ng-fa-icon ng-star-inserted']//*[name()='svg']")
	private WebElement repoSettingHome;

	@FindBy(xpath = "//a[@class='dropdown-toggle btn btn-theme-alt']")
	private WebElement shareDropDown;

	@FindBy(xpath = "//button[@class='btn btn-clear text-xxs text-muted ng-star-inserted']")
	private WebElement packageArrow;

	@FindBy(xpath = "//ul/p-treenode/li/div/button")
	private WebElement packageDropDown;

	@FindBy(xpath = "//input[@placeholder='Search for...']")
	private WebElement searchRepositoryItems;

	@FindBy(xpath = "//div[text()='Invite Users via Email']")
	private WebElement inviteCollaborators;

	@FindBy(xpath = "//span[starts-with(text(),'Invite &')]")
	private WebElement inviteContributorEmail;

	@FindBy(xpath = "//*[@id='pills-links-tab']")
	private WebElement mailinator_Links;

	@FindBy(xpath = "//table/tbody/tr/td[2]/a")
	private WebElement links_url;

	@FindBy(xpath = "(//label[contains(text(),'Copy Link to Share')])[1]")
	private WebElement copyLinkToShare;

	@FindBy(xpath = "(//div[contains(text(),'Share disabled! Please enable sharing from Reposit')])[1]")
	private WebElement disableShare;

	@FindBy(xpath = "//span[text()='Diagrams']")
	private WebElement diagrams;

	@FindBy(xpath = "//div[@class='diag-list row mt-4']//div[1]//app-diagrams-list-item[1]//div[1]//a[1]")
	private WebElement diagram1;

	@FindBy(xpath = "//div[1]/app-diagrams-list-item/div/div[5]/div/app-button-theme-bordered[1]/app-button/button")
	private WebElement diagram_Discussion_Bubble;

	@FindBy(xpath = "//span[text()='Actions']")
	private WebElement Actions;

	@FindBy(xpath = "//span[text()='Load more']")
	private WebElement LoadMore;

	@FindBy(xpath = "(//span[contains(text(),'Load more')])[2]")
	private WebElement repliedDiscussion_LoadMore;

	@FindBy(xpath = "//span[text()='Share Diagram']")
	private WebElement shareDaigram;

	@FindBy(xpath = "//label[text()='Copy Diagram Link to Share']")
	private WebElement copyDaigram;

	@FindBy(xpath = "//div[1]//div[3]/app-button-clear//button")
	private WebElement copyLink_icon;

	@FindBy(xpath = "//div/div[1]/div/div[2]/app-button-clear/app-button/button")
	private WebElement eachDiscussion_copyLink;

	@FindBy(xpath = "//div[@class='col-5']//span[@class='ng-arrow-wrapper']")
	private WebElement homePageDropDown;

	@FindBy(xpath = "//span[text()='Prolaborate - Start Here']")
	private WebElement homePageDashboard;

	@FindBy(xpath = "//span[text()='My Diagrams']")
	private WebElement homePageDiagrams;

	@FindBy(xpath = "//span[text()='Discard']")
	private WebElement Discard;

	@FindBy(xpath = "(//*[starts-with(text(),'Completed')])[4]")
	private WebElement revChartCompleted;

	@FindBy(xpath = "(//*[starts-with(text(),'In Progress')])[3]")
	private WebElement revChartInprogress;

	@FindBy(xpath = "//app-inputtwowaybind//input[@type='text']")
	private WebElement discussionDefaultText;

	@FindBy(xpath = "//span[text()='Discard']")
	private WebElement cancelPopupDiscard;

	@FindBy(xpath = "//span[text()='Go Back']")
	private WebElement cancelPopupBack;

	@FindBy(xpath = "//span[contains(text(),'High')]")
	private WebElement highPriority;

	@FindBy(xpath = "//span[contains(text(),'Medium')]")
	private WebElement mediumPriority;
	
	@FindBy(xpath = "(//span[contains(text(),'Discuss')])[1]")
	private WebElement createdDiscuss;

	@FindBy(xpath = "//div[1]/app-select/ng-select/div/span")
	private WebElement accessPermission_DropDown;

	@FindBy(xpath = "//div/div[3]/div[1]/app-select/ng-select/div/span")
	private WebElement accessPermission_Users_DropDown;

	@FindBy(xpath = "//div/div[3]/div[2]/app-select/ng-select/div/span")
	private WebElement accessPermission_CollaborateAccess_DropDown;

	@FindBy(xpath = "(//span[text()='Collaborate'])[1]")
	private WebElement collaborate_access;

	@FindBy(xpath = "//*[@id=\"repositorySettingsService\"]/div/div[4]/div/div/div/div[2]/app-inputtwowaybind/input")
	private WebElement Discussion_Identifier_Prefix;

	@FindBy(xpath = "//div[1]/div[2]/span/span[3]/span[3]/span/span[1]")
	private WebElement thumbsUp_icon_Discussion;

	@FindBy(xpath = "//div[2]/span/span[3]/span[3]/span/span[2]")
	private WebElement Count_Discussion;

	@FindBy(xpath = "//div/div[2]/div/div[2]/div/span/span/span[2]")
	private WebElement replied_DiscussionCount;

	@FindBy(xpath = "//div[contains(text(),'Notification Settings')]")
	private WebElement notificationSetting;

	@FindBy(xpath = "//div[starts-with(text(),'This action')]")
	private WebElement actionMessage;

	@FindBy(xpath = "//div[starts-with(text(),'Not Allowed')]")
	private WebElement actionMessage2;

	@FindBy(xpath = "//input[starts-with(@placeholder,'Enter')]")
	private WebElement enterMailInvite;

	@FindBy(xpath = "//input[starts-with(@placeholder,'Press')]")
	private WebElement enterMailToInvite;

	@FindBy(xpath = "//div[contains(text(),'Active Directory Single')]")
	private WebElement activeDirectorySSO;

	@FindBy(xpath = "//div[contains(text(),'User and License')]")
	private WebElement UserAndLicenseManagement;

	@FindBy(xpath = "//div[contains(text(),'Access Control')]")
	private WebElement accessControlProfileSet;

	@FindBy(xpath = "//span[contains(text(),'Sign Up Settings')]")
	private WebElement signUpSettingHeaderText;

	@FindBy(xpath = "//h3[contains(text(),'Access')]")
	private WebElement AccessConProfile;

	@FindBy(xpath = "//label[contains(text(),'Enable')]")
	private WebElement Enable;

	@FindBy(xpath = "//label[contains(text(),'Disable')]")
	private WebElement Disable;

	@FindBy(xpath = "//h4[contains(text(),'Summary Emails')]")
	private WebElement summaryMails;

	@FindBy(xpath = "//a[normalize-space()='Learn more']")
	private WebElement learnMore;

	@FindBy(xpath = "//*[@id='dropdownManual']/fa-icon")
	public WebElement menuButton;

	@FindBy(xpath = "//a//div[contains(text(),'Reviews')]")
	private WebElement Reviews;

	@FindBy(xpath = "//span[contains(text(),'Reviews')]")
	private WebElement allReviews;

	@FindBy(xpath = "(//app-review-management-single-card/div/div[4])[1]")
	private WebElement daysCount;

	@FindBy(xpath = "//span[contains(text(),'Day')]")
	private WebElement daysCount_InReviewPage;

	@FindBy(xpath = "//div[starts-with(@class,'invite-reviewers-dialog ')]")
	private WebElement Invite_DialogueBox;

	@FindBy(xpath = "//div[1]/app-review-management-single-card/div/div[2]/h4/span")
	private WebElement clickExistRev;

	@FindBy(xpath = "//div[text()=' Review Defaults ']")
	private WebElement reviewSettings;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	private WebElement reviewSettings_ApprovalProcess;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement reviewSettings_ArchiveProcessToggle;

	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	private WebElement reviewSettings_InviteContributorToggle;

	@FindBy(xpath = "(//input[@type='checkbox'])[4]")
	private WebElement reviewSettings_EmailNotificationToggle;

	@FindBy(xpath = "//app-button-success/app-button")
	private WebElement actionbutton;

	@FindBy(xpath = "(//span[contains(text(),'Mark')])[1]")
	private WebElement markAsReviewed;

	@FindBy(xpath = "(//span[contains(text(),'Mark')])[2]")
	private WebElement markAsRejected;

	@FindBy(xpath = "(//h4)[3]")
	private WebElement StatusApprove_Reject;

	@FindBy(xpath = "(//a[contains(@class,'rounded')])[13]")
	private WebElement markAsReviewedDropDown;

	@FindBy(xpath = "//span[contains(text(),'Edit Review')]")
	private WebElement EditRev;

	@FindBy(xpath = "//a[contains(text(),'Reviews')]")
	private WebElement Reviewslist;

	@FindBy(xpath = "//div/app-create-review-all-steps/div/div/div/app-button-theme/app-button/button")
	private WebElement updateRev;

	@FindBy(xpath = "(//span[contains(text(),'Mujahiddin')])[1]")
	private WebElement updateRevDisplay;

	@FindBy(xpath = "//span[contains(text(),'End date should not be before Start date')]")
	private WebElement revWarningMsg;

	@FindBy(xpath = "//span[contains(text(),'End date should not be earlier than Review End Date')]")
	private WebElement apprWarningMsg;

	@FindBy(xpath = "//span[contains(text(),'Change Status')]")
	private WebElement revChangeStatus;

	@FindBy(xpath = "(//input[@type='checkbox'])[7]")
	private WebElement chkBoxStatus;

	@FindBy(xpath = "(//input[@type='checkbox'])[8]")
	private WebElement chkBoxStatus2;

	@FindBy(xpath = "//span[contains(text(),'Review Items')]")
	private WebElement StatusOf_ReviewItems;

	@FindBy(xpath = "//span[contains(text(),'Contributors')]")
	private WebElement StatusOf_ReviewContributors;

	@FindBy(xpath = "//span[contains(text(),'On Hold')]")
	private WebElement RevOnHold;

	@FindBy(xpath = "//span[contains(text(),'Closed')]")
	private WebElement RevOnClosed;

	@FindBy(xpath = "//span[text()='Close']")
	private WebElement ADlistViewMemberClose;

	@FindBy(xpath = "//span[contains(text(),'Archived')]")
	private WebElement RevOnArchived;

	@FindBy(xpath = "(//span[contains(text(),'Active')])[1]")
	public WebElement RevActive;

	@FindBy(xpath = "(//span[contains(text(),'Close')])[1]")
	public WebElement RevClosed;

	@FindBy(xpath = "(//span[contains(text(),'Close')])[2]")
	public WebElement Closed2;

	@FindBy(xpath = "(//span[contains(text(),'Open')])[2]")
	public WebElement Open2;

	@FindBy(xpath = "(//span[contains(text(),'Open')])[1]")
	public WebElement Open1;

	@FindBy(xpath = "(//fa-icon[starts-with(@class,'ng-fa-icon text-white')])[1]")
	public WebElement discussion_on_Review_item;

	@FindBy(xpath = "(//span[contains(text(),'Close')])[3]")
	public WebElement Closed3;

	@FindBy(xpath = "(//span[contains(text(),'On Hold')])[1]")
	public WebElement revHold;

	@FindBy(xpath = "//div/div[1]/app-review-management-single-card/div/div[2]/app-dropdown/div/a/span")
	public WebElement EdtDeleIcon;

	@FindBy(xpath = "(//span[contains(text(),'Delete')])[1]")
	public WebElement DeleIcon;

	@FindBy(xpath = "(//span[contains(text(),'Delete')])[2]")
	public WebElement Delete_repliedDiscussion;

	@FindBy(xpath = "//div[@class='modal-content']")
	public WebElement Delete_Confirmation_Popup;

	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	public WebElement removeUser;

	@FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
	public WebElement EditIcon;

	@FindBy(xpath = "(//div[@class='disable-section form-group m-0'])[1]")
	public WebElement DisableDate;

	@FindBy(xpath = "//input[@id='reviewWorkFlow']")
	public WebElement ApprChkBox;

	@FindBy(xpath = "//input[starts-with(@placeholder,'What do you want to')]")
	public WebElement discussText;

	@FindBy(xpath = "//div[@class='ck ck-labeled-field-view__input-wrapper']/input")
	public WebElement discuss_link_input;

	@FindBy(xpath = "(//div[@aria-label='Rich Text Editor, main'])[1]")
	public WebElement discussTextTyping;

	@FindBy(xpath = "//div[1]/div[2]/span/span[2]/span")
	public WebElement AfterPost_DiscussionStatus;

	@FindBy(xpath = "(//app-single-reply/div[1]/a/figure/img)[1]")
	public WebElement repliedUser_ProfileIcon;

	@FindBy(xpath = "//span[text()='Post']")
	public WebElement discussTextPost;

	@FindBy(xpath = "//app-button-clear[2]/app-button/button")
	public WebElement discussion_BubbleIcon;
	
	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']")
	public WebElement Discussion_StatusTypes;

	@FindBy(xpath = "//app-select/ng-select/div/span[2]")
	public WebElement Discussion_StatusFilter_dropDown;

	@FindBy(xpath = "//button[starts-with(@class,'btn text-light')]")
	public WebElement closeDiscussion;

	@FindBy(xpath = "//ngb-modal-window/div/div/div[1]/app-button-clear")
	public WebElement close_SharePopUp;

	@FindBy(xpath = "//div[text()='Users']")
	public WebElement userSetting;

	@FindBy(xpath = "//input[@placeholder='Add a reply...']")
	public WebElement discussionAddReply;

	@FindBy(xpath = "//span[contains(text(),'Like')]")
	public WebElement discussionLike;

	@FindBy(xpath = "//label[text()=' All ']")
	public WebElement discussionAll;

	@FindBy(xpath = "//label[text()=' Participated ']")
	public WebElement Participated;

	@FindBy(xpath = "//div[@class='form-group m-0']//span[@class='ng-arrow-wrapper']")
	public WebElement SignUpSelectDropDown;

	@FindBy(xpath = "(//div[starts-with(@class,'ng-value')])[1]")
	public WebElement getselectProfileExistprofile;

	@FindBy(xpath = "(//span[contains(text(),'Groups')])[1]")
	public WebElement activeDirectoryGroups;

	@FindBy(xpath = "(//span[contains(text(),'Add Group')])[1]")
	public WebElement addADGroup;

	@FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
	public WebElement AD_Group_Dropdown;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[2]")
	public WebElement AD_Group_profile_Dropdown;

	@FindBy(xpath = "//span[contains(text(),'Users')]")
	public WebElement usersAD_Group;

	@FindBy(xpath = "//input[@id=\"ad-user-list\"]")
	public WebElement userRadioButton;

	@FindBy(xpath = "//span[text()='Dashboards']")
	public WebElement dashboradIcon;

	@FindBy(xpath = "//form/div[1]/div[1]/div[1]/app-reactiveforminput[1]/input[1]")
	public WebElement ADdomainTextName;

	@FindBy(xpath = "//span[starts-with(@class,'d-table-cell align')]")
	public WebElement ADgroupviewUserDetails;

	@FindBy(xpath = "//a[starts-with(@class,'ng-tns')]")
	public WebElement viewOption;

	@FindBy(xpath = "//ngb-modal-window//button[starts-with(@class,'btn btn-danger')]")
	public WebElement PopupWindowDeleteOption;

	@FindBy(xpath = "//input[@id='userStatus']")
	public WebElement userStatus;

	@FindBy(xpath = "//span[contains(text(),'Add AD')]")
	public WebElement addADconfiguration;

	@FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
	public WebElement ADedit;

	@FindBy(xpath = "(//button[@type='button'])[26]")
	public WebElement closePopup;

	@FindBy(xpath = "//div[text()=' Repositories ']")
	public WebElement Repositories;

	@FindBy(xpath = "//app-dashboard-view-html-widget/div/iframe")
	public WebElement border;

	@FindBy(xpath = "(//fa-icon[starts-with(@class,'ng-fa-icon text-xl')])[2]")
	public WebElement addDashboardWidget;

	@FindBy(xpath = "//ul[1]/li[2]//h4/fa-icon")
	public WebElement createDashboard_TextWidget;

	@FindBy(xpath = "(//fa-icon[starts-with(@class,'ng-fa-icon float-')])[3]")
	public WebElement htmlpageAdd;

	@FindBy(xpath = "(//app-dropdown/div/div/div[3]/a[1])[2]")
	public WebElement addNewWidget;

	@FindBy(xpath = "//textarea")
	public WebElement htmlWidgetTextArea;

	@FindBy(xpath = "//button[@class='color-pick-btn']")
	public WebElement borderColorArrow;

	@FindBy(xpath = "//div[starts-with(@class,'color-picker')]")
	public WebElement borderColorPicker;

	@FindBy(xpath = "//div[text()=' Integrated Applications ']")
	public WebElement integrationApplications;

	@FindBy(xpath = "//div[text()=' Modeling Languages ']")
	public WebElement modelingLanguage;

	@FindBy(xpath = "(//span[text()='Modeling Languages'])[2]")
	public WebElement insideModelingLanguage;

	@FindBy(xpath = "//span[text()='Manage Application Projects']")
	public WebElement manageApplicationProject;

	@FindBy(xpath = "//span[text()='Add Project']")
	public WebElement addProject;

	@FindBy(xpath = "//span[text()='Validate Connection']")
	public WebElement validaConnection;

	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[2]")
	public WebElement projectArrow;

	@FindBy(xpath = "(//span[text()='Properties'])[1]")
	public WebElement integrationApplicationProperties;

	@FindBy(xpath = "//span[text()='Custom Properties']")
	public WebElement customProperties;

	@FindBy(xpath = "//span[text()='Add Property']")
	public WebElement addProperty;

	@FindBy(xpath = "//span[text()='Add Integration Property']")
	public WebElement addIntegrationProperty;

	@FindBy(xpath = "//span[text()='Add Custom Property']")
	public WebElement addCustomProperty;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	public WebElement integrationPropertyName;

	@FindBy(xpath = "//app-element-view//span[text()='Properties']")
	public WebElement properties;

	@FindBy(xpath = "//span[contains(text(),'Open Form')]")
	public WebElement openFormDesigner;

	@FindBy(xpath = "//span[text()='ArchiMate2']")
	public WebElement archiMate2;

	@FindBy(xpath = "//span[text()='Default Profile']")
	public WebElement defaultProfile;

	@FindBy(xpath = "//span[text()='ArchiMate_ApplicationComponent']")
	public WebElement archimate_applicationComponent;

	@FindBy(xpath = "//app-button-secondary/app-button/button")
	public WebElement ok;
	
	@FindBy(xpath = "//span[text()='Default']")
	public WebElement default_text;
	
	@FindBy(xpath = "//span[text()=' Example Model ']")
	public WebElement ex_model_package;
	
	
	
	@FindBy(xpath = "//span[text()='Change Logo']")
	public WebElement change_Logo;

	@FindBy(xpath = "//span[text()='Crop']")
	public WebElement logo_Crop;
	
	@FindBy(xpath = "//app-image-cropper/app-input/input")
	public WebElement ChosenFile_input;
	
	@FindBy(xpath = "//span[text()='Dashboards']")
	private WebElement default_DashboardPage;
	
	@FindBy(xpath = "//gridster-item[1]/div/div[2]/app-dashboard-widget-view/div")
	private WebElement Dashboard_Widget;

	@FindBy(xpath = "//gridster-item[1]/div/span/span[2]/app-button/button")
	private WebElement Dashboard_Widget_Discussion;
	
	@FindBy(xpath = "(//div/button/fa-icon)[1]")
	private WebElement primary_color;
	
	@FindBy(xpath = "(//div/button/fa-icon)[2]")
	private WebElement secondary_color;
	
	
	@FindBy(xpath = "//div/div[9]/div[2]/div[4]")
	private WebElement color_Pink;
	
	@FindBy(xpath = "//div/div[9]/div[2]/div[3]")
	private WebElement color_skyBlue;
	
	@FindBy(xpath = "//div[text()=' Licenses ']")
	private WebElement License;
	
	@FindBy(xpath = "//div/div[2]/app-input/input")
	private WebElement LicenseKey_choosefile;
	
	@FindBy(xpath = "//span[text()='Activate License']")
	private WebElement Activate_LicenseKey_button;
	
	@FindBy(xpath = "//div[contains(text(),'Sign Up Settings')]")
	private WebElement signUpSetting;
	
	@FindBy(xpath = "//span[contains(text(),'Analyser')]")
	private WebElement analyser;
	
	@FindBy(xpath = "//span[contains(text(),'Create View')]")
	private WebElement analyser_create_view;
	
	@FindBy(xpath = "//*[@id='browserBarTabs']/div[1]/div/a[1]")
	private WebElement analyser_General_settings;
	
	@FindBy(xpath = "//*[@id='browserBarTabs']/div[1]/div/a[2]")
	private WebElement analyser_Node_settings;
	
	@FindBy(xpath = "//*[@id='browserBarTabs']/div[1]/div/a[3]")
	private WebElement analyser_Connector_settings;
	
	@FindBy(xpath = "//span[text()='Advanced Search']")
	private WebElement AD_advanceSearch;
	
	@FindBy(xpath = "//div[3]/app-inputtwowaybind/input")
	private WebElement AD_advanceSearch_inputField;
	
	@FindBy(xpath = "//button[@id='FormSubmitAdFilter']")
	private WebElement AD_advanceSearch_submitButton;
	
	@FindBy(xpath = "(//li/ul/p-treenode[1]/li/div/button)[2]")
	private WebElement activityPackage_Dropdown;
	
	@FindBy(xpath = "(//span[text()='Private'])[1]")
	private WebElement Private_SelectionInShare;
	
	
	@FindBy(xpath = "//div[text()=' Manage Application Restrictions ']")
	private WebElement domainAccessManagement;
	
	@FindBy(xpath = "//a[starts-with(text(),'Group')]")
	private WebElement groups;
	
	@FindBy(xpath = "(//span[text()='Cancel'])[2]")
	private WebElement cancelButton2;
	
	@FindBy(xpath = "//div[text()=' User Groups ']")
	private WebElement userGroups;
	
	@FindBy(xpath = "//div[contains(text(),'Access Permissions')]")
	private WebElement accessPermission;
	
	@FindBy(xpath = "//div[text()=' Users ']")
	private WebElement users;
	
	@FindBy(xpath = "//span[text()='Add User']")
	private WebElement addUser;
	
	@FindBy(xpath = "//div[text()=' User and License Management ']")
	private WebElement usersAndLicenseMangement;
	
	@FindBy(xpath = "//label[text()='Email *']/following::input[1]")
	private WebElement addUserEmail;

	@FindBy(xpath = "//label[text()='First Name *']/following::input[1]")
	private WebElement addUserFirstName;

	@FindBy(xpath = "//label[text()='Last Name *']/following::input[1]")
	private WebElement addUserLastname;

	@FindBy(xpath = "//label[text()='Password *']/following::input[1]")
	private WebElement addUserPassword;
	
	@FindBy(id = "userIsAdmin")
	private WebElement makeSuperAdmin;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//span[text()='Create User Group']")
	private WebElement createUserGroup;
	
	@FindBy(xpath = "//label[text()='Name']/following::input[1]")
	private WebElement groupName;
	
	@FindBy(xpath = "//span[contains(text(),'Add Active Directory User')]")
	private WebElement addADuser;
	
	@FindBy(xpath = "//div[contains(text(),'Dashboards')]")
	private WebElement menuDashboard;
	
	@FindBy(xpath = "//ngb-modal-window//span[text()='Remove']")
	private WebElement confirmRemove;
	
	@FindBy(xpath = "//span[contains(text(),'Create Dashboard')]")
	private WebElement createDashboard;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle btn btn-theme']")
	private WebElement addWidgetButton;
	
	@FindBy(xpath = "//input[@id='Customized']")
	private WebElement customizedaccess;
	//////////////
	@FindBy(xpath = "//div[contains(text(),' Integrated Application Projects ')]")
	private WebElement integratedApplictionProjects;

	@FindBy(xpath = "//span[text()='Refresh Chart Preview']")
	private WebElement refreshChartPreview;
	
	@FindBy(xpath = "//p[text()='Bubble']")
	private WebElement Bubble;

	@FindBy(xpath = "//p[text()='Landscape']")
	private WebElement Landscape;
	
	@FindBy(xpath = "//p[text()='Bar']")
	private WebElement Bar;

	@FindBy(xpath = "//p[text()='Nested Pie']")
	private WebElement NestedPie;

	@FindBy(xpath = "//p[text()='Heat Map']")
	private WebElement HeatMap;

	@FindBy(xpath = "//p[text()='Pie']")
	private WebElement Pie;

	@FindBy(xpath = "//p[text()='Road Map']")
	private WebElement RoadMap;

	@FindBy(xpath = "(//div/div/h4/fa-icon[1])[6]")
	private WebElement chartWidget;
	
	@FindBy(xpath = "//a[text()='Landscape Level Settings']")
	private WebElement landscapeLevelSettings;

	@FindBy(xpath = "//a[text()='Landscape General Settings']")
	private WebElement landscapeGeneralSettings;

	@FindBy(xpath = "//span[text()='Chart Settings']")
	private WebElement chartSettings;

	@FindBy(xpath = "//span[text()='Test Repository']")
	private WebElement testRepository;

	@FindBy(xpath = "(//div/div/h4/fa-icon[1])[6]")
	private WebElement charts;

	@FindBy(xpath = "//span[text()='Skip to Query']")
	private WebElement skiptoQuery;

	@FindBy(xpath = "//textarea[@placeholder='Enter Query here']")
	private WebElement enterQuery;

	@FindBy(xpath = "//span[text()='FETCH RESULT QUERY']")
	private WebElement fetchResultQuery;

	@FindBy(xpath = "//span[text()='Set Placeholder Values']")
	private WebElement setPlaceholderValues;

	@FindBy(xpath = "//input[@placeholder='Enter Placeholder value here']")
	private WebElement enterPlaceholderValue;

	@FindBy(xpath = "//ngb-modal-window[2]//div//span[text()='Save']")
	private WebElement savePlaceholder;

	@FindBy(id = "stereotypeFqName")
	private WebElement stereotypeFqName;

	@FindBy(xpath = "//textarea[@placeholder='Enter Result Query here']")//created on - 24/11/2022 
	private WebElement enterResultQueryhere;

	@FindBy(xpath = "//div[contains(text(),'Report Configurations')]")//created on - 25/11/2022
	private WebElement reportConfigurations;

	@FindBy(xpath = "//span[text()='Create Report']")//created on - 25/11/2022
	private WebElement createReport;

	@FindBy(xpath = "//input[@placeholder='Enter a Report Name']")//created on - 25/11/2022
	private WebElement enterReportName;

	@FindBy(xpath = "//span[text()='Import']")//created on - 01/12/2022
	private WebElement importButton;

	@FindBy(xpath = "//span[text()='Color Palette Configuration']")//created on - 19/12/2022
	private WebElement colorPaletteConfiguration;
	
	@FindBy(xpath = "//span[text()='ADD']")//created on - 19/12/2022
	private WebElement customColorsAddButton;

	@FindBy(xpath = "//span[text()='Save as Pallette']")//created on - 19/12/2022
	private WebElement saveAsPallette;

	@FindBy(xpath = "//input[@placeholder='Enter a Palette Name']")//created on - 19/12/2022
	private WebElement enterPaletteName;
	
	@FindBy(id = "chooseCustomColors")//created on - 19/12/2022
	private WebElement chooseCustomColorsRedioButton;

	@FindBy(xpath = "//ngb-modal-window//span[text()='Save']")//created on - 20/12/2022
	private WebElement customColorsPaletteConfigurationSave;

	@FindBy(id = "choosePredefinedColors")//created on - 20/12/2022
	private WebElement choosePredefinedColorsRedioButton;

	@FindBy(xpath = "//span[text()='Color Configuration']")//created on - 28/12/2022
	private WebElement mdgColorConfiguration;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signIn;
	
	 //Define Functions
	
	public WebElement getDropDown1() {
		return dropDown1;
	}

	public WebElement getDropDown2() {
		return dropDown2;
	}

	public WebElement getDropDown3() {
		return dropDown3;
	}

	public WebElement getDropDown4() {
		return dropDown4;
	}

	public WebElement getDropDown5() {
		return dropDown5;
	}

	public WebElement getDropDown6() {
		return dropDown6;
	}

	public WebElement getDropDown7() {
		return dropDown7;
	}

	public WebElement getDropDown8() {
		return dropDown8;
	}

	public WebElement getDropDown9() {
		return dropDown9;
	}
	
	public WebElement getSignIn() {
		return signIn;
	}
	
	public WebElement getHeatMap() {
		return HeatMap;
	}
	
	public WebElement getPie() {
		return Pie;
	}
	
	public WebElement getRoadMap() {
		return RoadMap;
	}
	
	public WebElement getLandscapeLevelSettings() {
		return landscapeLevelSettings;
	}
	
	public WebElement getLandscapeGeneralSettings() {
		return landscapeGeneralSettings;
	}
	
	public WebElement getChartWidget() {
		return chartWidget;
	}
	
	public WebElement getChartSettings() {
		return chartSettings;
	}
	
	public WebElement getTestRepository() {
		return testRepository;
	}
	
	public WebElement getCharts() {
		return charts;
	}
	
	public WebElement getSkiptoQuery() {
		return skiptoQuery;
	}
	
	public WebElement getEnterQuery() {
		return enterQuery;
	}
	
	public WebElement getFetchResultQuery() {
		return fetchResultQuery;
	}
	
	public WebElement getSetPlaceholderValues() {
		return setPlaceholderValues;
	}
	
	public WebElement getEnterPlaceholderValue() {
		return enterPlaceholderValue;
	}
	
	public WebElement getSavePlaceholder() {
		return savePlaceholder;
	}
	
	public WebElement getStereotypeFqName() {
		return stereotypeFqName;
	}
	
	public WebElement getEnterResultQueryhere() {
		return enterResultQueryhere;
	}
	
	public WebElement getReportConfigurations() {
		return reportConfigurations;
	}
	
	public WebElement getCreateReport() {
		return createReport;
	}
	
	public WebElement getEnterReportName() {
		return enterReportName;
	}
	
	public WebElement getImportButton() {
		return importButton;
	}
	
	public WebElement getColorPaletteConfiguration() {
		return colorPaletteConfiguration;
	}
	
	public WebElement getCustomColorsAddButton() {
		return customColorsAddButton;
	}
	
	public WebElement getSaveAsPallette() {
		return saveAsPallette;
	}
	
	public WebElement getEnterPaletteName() {
		return enterPaletteName;
	}
	
	public WebElement getChooseCustomColorsRedioButton() {
		return chooseCustomColorsRedioButton;
	}
	
	public WebElement getCustomColorsPaletteConfigurationSave() {
		return customColorsPaletteConfigurationSave;
	}
	
	public WebElement getChoosePredefinedColorsRedioButton() {
		return choosePredefinedColorsRedioButton;
	}
	
	public WebElement getBar() {
		return Bar;
	}
	
	public WebElement getRefreshChartPreview() {
		return refreshChartPreview;
	}
	
	public WebElement getIntegratedApplictionProjects() {
		return integratedApplictionProjects;
	}
	
	public WebElement getBubble() {
		return Bubble;
	}
	
	public WebElement getLandscape() {
		return Landscape;
	}
	
	public WebElement getNestedPie() {
		return NestedPie;
	}
	
	public WebElement getMdgColorConfiguration() {
		return mdgColorConfiguration;
	}

	public WebElement getCustomizedaccess() {
		return customizedaccess;
	}

	public WebElement getAddWidgetButton() {
		return addWidgetButton;
	}

	public WebElement getCreateDashboard() {
		return createDashboard;
	}

	public WebElement getConfirmRemove() {
		return confirmRemove;
	}

	public WebElement getMenuDashboard() {
		return menuDashboard;
	}

	public WebElement getAddADuser() {
		return addADuser;
	}
	
	public WebElement getGroupName() {
		return groupName;
	}

	public WebElement getCreateUserGroup() {
		return createUserGroup;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getMakeSuperAdmin() {
		return makeSuperAdmin;
	}

	public static Select getS() {
		return s;
	}

	public WebElement getLoginUserName() {
		return loginUserName;
	}

	public WebElement getLoginPassword() {
		return loginPassword;
	}

	public WebElement getSignUpFirstName() {
		return signUpFirstName;
	}

	public WebElement getReviewdata() {
		return Reviewdata;
	}

	public WebElement getTreeViewbutton() {
		return TreeViewbutton;
	}

	public WebElement getCreatedashboard() {
		return createdashboard;
	}

	public WebElement getRevStartMon(String mon) {
		s = new Select(RevStartMon);
		s.selectByVisibleText(mon); 
		return RevStartMon;
	}


	public WebElement getProlaborateLogo() {
		return prolaborateLogo;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getMenuButton() {
		return menuButton;
	}


	public WebElement getCancelButton2() {
		return cancelButton2;
	}

	public WebElement getAddUserEmail() {
		return addUserEmail;
	}

	public WebElement getAddUserFirstName() {
		return addUserFirstName;
	}

	public WebElement getAddUserLastname() {
		return addUserLastname;
	}

	public WebElement getAddUserPassword() {
		return addUserPassword;
	}


	public WebElement getUsersAndLicenseMangement() {
		return usersAndLicenseMangement;
	}

	public WebElement getAddUser() {
		return addUser;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getAccessPermission() {
		return accessPermission;
	}
	
	public WebElement getUserGroups() {
		return userGroups;
	}


	public WebElement getDomainAccessManagement() {
		return domainAccessManagement;
	}


	public WebElement getPrivate_SelectionInShare() {
		return Private_SelectionInShare;
	}
	
	
	public WebElement getPublic_SelectionInShare() {
		return public_SelectionInShare;
	}

	
	public WebElement getActivityPackage_Dropdown() {
		return activityPackage_Dropdown;
	}

	public WebElement getAD_advanceSearch_submitButton() {
		return AD_advanceSearch_submitButton;
	}
	
	public WebElement getAD_advanceSearch_inputField() {
		return AD_advanceSearch_inputField;
	}
	
	public WebElement getAD_advanceSearch() {
		return AD_advanceSearch;
	}
	
	
	public WebElement getAnalyser_Connector_settings() {
		return analyser_Connector_settings;
	}
	
	public WebElement getAnalyser_General_settings() {
		return analyser_General_settings;
	}
	
	public WebElement getAnalyser_Node_settings() {
		return analyser_Node_settings;
	}

	public WebElement getAnalyser_create_view() {
		return analyser_create_view;
	}

	public WebElement getAnalyser() {
		return analyser;
	}

	public WebElement getSignUpSetting() {
		return signUpSetting;
	}
	
	public WebElement getClose_SharePopUp() {
		return close_SharePopUp;
	}
	
	public WebElement getLicense() {
		return License;
	}

	public WebElement getLicenseKey_choosefile() {
		return LicenseKey_choosefile;
	}

	public WebElement getActivate_LicenseKey_button() {
		return Activate_LicenseKey_button;
	}

	public WebElement getDashboard_Widget() {
		return Dashboard_Widget;
	}

	public WebElement getPrimary_color() {
		return primary_color;
	}

	public WebElement getSecondary_color() {
		return secondary_color;
	}

	public WebElement getColor_skyBlue() {
		return color_skyBlue;
	}

	public WebElement getColor_Pink() {
		return color_Pink;
	}

	public WebElement getDashboard_Widget_Discussion() {
		return Dashboard_Widget_Discussion;
	}

	public WebElement getDefault_DashboardPaged() {
		return default_DashboardPage;
	}
	
	public WebElement getLogo_Crop() {
		return logo_Crop;
	}
	
	public WebElement getChange_Logo() {
		return change_Logo;
	}

	public WebElement getChosenFile_input() {
		return ChosenFile_input;
	}

	public WebElement getEx_model_package() {
		return ex_model_package;
	}

	public WebElement getDefault_text() {
		return default_text;
	}

	public WebElement getAccessConProfile() {
		return AccessConProfile;
	}

	public WebElement getChkBoxStatus2() {
		return chkBoxStatus2;
	}

	public WebElement getOpen1() {
		return Open1;
	}

	public WebElement getDiscussion_BubbleIcon() {
		return discussion_BubbleIcon;
	}

	public WebElement getDiscussion_bubble() {
		return Discussion_bubble;
	}

	public WebElement getDiagram_Discussion_Bubble() {
		return diagram_Discussion_Bubble;
	}

	public WebElement getHideDiscussion_bubble() {
		return hideDiscussion_bubble;
	}

	public WebElement getLowPriority() {
		return lowPriority;
	}

	public WebElement getAccessControlProfileSet() {
		return accessControlProfileSet;
	}

	public WebElement getAdministrator_UserGroup() {
		return administrator_UserGroup;
	}

	public WebElement getTest_UserGroup() {
		return test_UserGroup;
	}
	
	public WebElement getChooseAuthorProfilePic() {
		return chooseAuthorProfilePic;
	}

	public WebElement getAchivetext() {
		return achivetext;
	}

	public WebElement getGroup_reviewsCheckbox() {
		return group_reviewsCheckbox;
	}

	public WebElement getCheckBox2() {
		return checkBox2;
	}
	
	public WebElement getInvite_collaborator() {
		return Invite_collaborator;
	}
	
	public WebElement getAlltypeofDiagram() {
		return alltypeofDiagram;
	}

	public WebElement getRepliedDiscussion_LoadMore() {
		return repliedDiscussion_LoadMore;
	}

	public WebElement getDiscussion_Prefix_identifier() {
		return Discussion_Prefix_identifier;
	}

	public WebElement getHighPriority() {
		return highPriority;
	}

	public WebElement getMediumPriority() {
		return mediumPriority;
	}
	
	public WebElement getAddGroupCon() {
		return AddGroupCon;
	}

	public WebElement getRevChartCompleted() {
		return revChartCompleted;
	}

	public WebElement getRevChartInprogress() {
		return revChartInprogress;
	}

	public WebElement getInviteReviewer() {
		return inviteReviewer;
	}

	public WebElement getDiscussion_Posted_data() {
		return Discussion_Posted_data;
	}

	public WebElement getReplied_Discussion_Posted_data() {
		return replied_Discussion_Posted_data;
	}

	public WebElement getEdit_Discussion_Priority_DropDown() {
		return Edit_Discussion_Priority_DropDown;
	}

	public WebElement getInviteOption() {
		return InviteOption;
	}

	public WebElement getStatusOf_ReviewItems() {
		return StatusOf_ReviewItems;
	}

	public WebElement getStatusOf_ReviewContributors() {
		return StatusOf_ReviewContributors;
	}

	public WebElement getAccessPermission_DropDown() {
		return accessPermission_DropDown;
	}

	public WebElement getAccessPermission_Users_DropDown() {
		return accessPermission_Users_DropDown;
	}

	public WebElement getAccessPermission_CollaborateAccess_DropDown() {
		return accessPermission_CollaborateAccess_DropDown;
	}

	public WebElement getCollaborate_access() {
		return collaborate_access;
	}

	public WebElement getReviewStats() {
		return reviewStats;
	}

	public WebElement getActionApprove1() {
		return actionApprove1;
	}

	public WebElement getActionReview1() {
		return actionReview1;
	}

	public WebElement getCreateDashboard_TextWidget() {
		return createDashboard_TextWidget;
	}

	public WebElement getActionReview() {
		return actionReview;
	}

	public WebElement getDiscussionStatus_dropDown() {
		return discussionStatus_dropDown;
	}

	public WebElement getActionApprove() {
		return actionApprove;
	}

	public WebElement getActionApprove2() {
		return actionApprove2;
	}

	public WebElement getThumbsUp_icon_Discussion() {
		return thumbsUp_icon_Discussion;
	}

	public WebElement getCompositeDropDown() {
		return compositeDropDown;
	}

	public WebElement getActionApproveInfo() {
		return actionApproveInfo;
	}

	public WebElement getActionReject() {
		return actionReject;
	}

	public WebElement getADlistViewMemberClose() {
		return ADlistViewMemberClose;
	}

	public WebElement getNotReviewed() {
		return notReviewed;
	}

	public WebElement getDiscussion_RestrictedAccess() {
		return Discussion_RestrictedAccess;
	}

	public WebElement getDiscussion_RestrictedAccessMessage() {
		return Discussion_RestrictedAccessMessage;
	}

	public WebElement getDiscussion_EmptyMessage() {
		return Discussion_EmptyMessage;
	}

	public WebElement getDiscussion_EditModeMessage() {
		return Discussion_EditModeMessage;
	}

	public WebElement getDiscussion_deletedMessage() {
		return Discussion_deletedMessage;
	}

	public WebElement getActions() {
		return Actions;
	}

	public WebElement getActionMessage() {
		return actionMessage;
	}

	public WebElement getActionMessage2() {
		return actionMessage2;
	}

	public WebElement getMarkAsReviewed() {
		return markAsReviewed;
	}

	public WebElement getDiscussion_Identifier_Prefix() {
		return Discussion_Identifier_Prefix;
	}

	public WebElement getAuthorProfile() {
		return authorProfile;
	}

	public WebElement getInvited_Discussion() {
		return invited_Discussion;
	}

	public WebElement getList() {
		return List;
	}

	public WebElement getChangeAuthorProfilePic() {
		return changeAuthorProfilePic;
	}

	public WebElement getAuthorProfileEdit() {
		return authorProfileEdit;
	}

	public WebElement getActiveDirectoryGroups() {
		return activeDirectoryGroups;
	}

	public WebElement getDashboradIcon() {
		return dashboradIcon;
	}

	public WebElement getItem6() {
		return item6;
	}

	public WebElement getInviteExisting_User_ErrorMessage() {
		return inviteExisting_User_ErrorMessage;
	}

	public WebElement getExistingUserMessage() {
		return ExistingUserMessage;
	}

	public WebElement getReviews_DropDown_in_Discussion() {
		return reviews_DropDown_in_Discussion;
	}

	public WebElement getActiveDirectorySSO() {
		return activeDirectorySSO;
	}

	// label[@for='reviewWorkFlow']

	public WebElement getAD_Group_Dropdown() {
		return AD_Group_Dropdown;
	}

	public WebElement getAD_Group_profile_Dropdown() {
		return AD_Group_profile_Dropdown;
	}

	public WebElement getAddADconfiguration() {
		return addADconfiguration;
	}

	public WebElement getAddADGroup() {
		return addADGroup;
	}

	public WebElement getDiscuss_link_input() {
		return discuss_link_input;
	}

	public WebElement getSearchRepositoryItems() {
		return searchRepositoryItems;
	}

	public WebElement getReplied_DiscussionCount() {
		return replied_DiscussionCount;
	}

	public WebElement getAdd() {
		return Add;
	}

	public WebElement getReviewDiagrams() {
		return reviewDiagrams;
	}

	public WebElement getReviewItems() {
		return reviewItems;
	}

	public WebElement getPackageDropdownInReviewItemsTab() {
		return packageDropdownInReviewItemsTab;
	}

	public WebElement getSummary() {
		return Summary;
	}

	public WebElement getTreeView() {
		return TreeView;
	}


	public WebElement getListViewbutton() {
		return ListViewbutton;
	}

	public WebElement getAddAllRepositoryToAccessProfile() {
		return addAllRepositoryToAccessProfile;
	}

	public WebElement getReviewDiagram1() {
		return reviewDiagram1;
	}

	public WebElement getCount_Discussion() {
		return Count_Discussion;
	}

	public WebElement getAddCon() {
		return AddCon;
	}

	public WebElement getDaysCount() {
		return daysCount;
	}

	public WebElement getDaysCount_InReviewPage() {
		return daysCount_InReviewPage;
	}

	public WebElement getAddCustomProperty() {
		return addCustomProperty;
	}

	public WebElement getAddDashboardWidget() {
		return addDashboardWidget;
	}

	public WebElement getAddGroupInAD() {
		return addGroupInAD;
	}

	public WebElement getDiscussion_StatusTypes() {
		return Discussion_StatusTypes;
	}

	public WebElement getActionbutton() {
		return actionbutton;
	}

	public WebElement getItem5() {
		return item5;
	}

	public WebElement getSelectRoleAppr2() {
		return SelectRoleAppr2;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getActionButtonInDiscussion() {
		return ActionButtonInDiscussion;
	}

	public WebElement getExport_Discussion() {
		return export_Discussion;
	}

	public WebElement getShare_Discussion() {
		return share_Discussion;
	}

	public WebElement getEachDiscussion_copyLink() {
		return eachDiscussion_copyLink;
	}

	public WebElement getReplied_ActionButtonInDiscussion() {
		return replied_ActionButtonInDiscussion;
	}

	public WebElement getDiscussion_Priority_Change() {
		return Discussion_Priority_Change;
	}

	public WebElement getDiscussion_Priority() {
		return Discussion_Priority;
	}

	public WebElement getAddIntegrationProperty() {
		return addIntegrationProperty;
	}

	public WebElement getAddNewWidget() {
		return addNewWidget;
	}

	public WebElement getADdomainTextName() {
		return ADdomainTextName;
	}

	public WebElement getAddProject() {
		return addProject;
	}

	public WebElement getLoadMore() {
		return LoadMore;
	}

	public WebElement getAddProperty() {
		return addProperty;
	}

	public WebElement getADedit() {
		return ADedit;
	}

	public WebElement getADgroupviewUserDetails() {
		return ADgroupviewUserDetails;
	}

	public WebElement getADUserStatusEdit() {
		return ADUserStatusEdit;
	}

	public WebElement getMarkAsReviewedDropDown() {
		return markAsReviewedDropDown;
	}

	public WebElement getInvite_DialogueBox() {
		return Invite_DialogueBox;
	}

	public WebElement getDashboard_viewAll() {
		return dashboard_viewAll;
	}

	public WebElement getDiscussion_StatusFilter_dropDown() {
		return Discussion_StatusFilter_dropDown;
	}

	public WebElement getEnterMailToInvite() {
		return enterMailToInvite;
	}

	public WebElement getAddUsersInAD() {
		return addUsersInAD;
	}

	public WebElement getSyncUsers() {
		return syncUsers;
	}

	public WebElement getApprChkBox() {
		return ApprChkBox;
	}

	//
	//
	public WebElement getApprEndDate() {
		return ApprEndDate;
	}

	public WebElement getApprEndErrMsg() {
		return ApprEndErrMsg;
	}

	//
	//
	public WebElement getApprEndMon(String mon) {
		s = new Select(ApprEndMon);
		s.selectByVisibleText(mon);
		return ApprEndMon;
	}

	public WebElement getApprEndPriorErrMsg() {
		return ApprEndPriorErrMsg;
	}

	public WebElement getPortableAudio_element() {
		return portableAudio_element;
	}

	public WebElement getApprEndYear(String year) {
		s = new Select(ApprEndYear);
		s.selectByVisibleText(year);
		return ApprEndYear;
	}

	public WebElement getApprStartDate() {
		return ApprStartDate;
	}

	public WebElement getApprStartMon(String mon) {
		s = new Select(ApprStartMon);
		s.selectByVisibleText(mon);
		return ApprStartMon;
	}

	public WebElement getApprStartYear(String year) {
		s = new Select(ApprStartYear);
		s.selectByVisibleText(year);
		return ApprStartYear;
	}

	public WebElement getApprStrtErrMsg() {
		return ApprStrtErrMsg;
	}

	public WebElement getApprWarningMsg() {

		return apprWarningMsg;
	}

	public WebElement getArchievedRev() {
		return archievedRev;
	}

	public WebElement getArchimate_applicationComponent() {
		return archimate_applicationComponent;
	}

	public WebElement getArchiMate2() {
		return archiMate2;
	}

	public WebElement getBorder() {
		return border;
	}

	public WebElement getBorderColorArrow() {
		return borderColorArrow;
	}

	public WebElement getBorderColorPicker() {
		return borderColorPicker;
	}

	public WebElement getCancelPopupBack() {
		return cancelPopupBack;
	}

	public WebElement getCancelPopupDiscard() {
		return cancelPopupDiscard;
	}

	public WebElement getChkBoxStatus() {

		return chkBoxStatus;
	}

	public WebElement getClickExistRev() {
		return clickExistRev;
	}

	public WebElement getReviewSettings() {
		return reviewSettings;
	}

	public WebElement getDiscussion_on_Review_item() {
		return discussion_on_Review_item;
	}

	public WebElement getReviewSettings_ApprovalProcess() {
		return reviewSettings_ApprovalProcess;
	}

	public WebElement getReviewSettings_ArchiveProcessToggle() {
		return reviewSettings_ArchiveProcessToggle;
	}

	public WebElement getReviewSettings_InviteContributorToggle() {
		return reviewSettings_InviteContributorToggle;
	}

	public WebElement getReviewSettings_EmailNotificationToggle() {
		return reviewSettings_EmailNotificationToggle;
	}

	public WebElement getReview_InviteUser_toggle() {
		return Review_InviteUser_toggle;
	}

	public WebElement getReview_EmailNotification_toggle() {
		return Review_EmailNotification_toggle;
	}

	public WebElement getClosePopup() {
		return closePopup;
	}

	public WebElement getCopyDaigram() {
		return copyDaigram;
	}

	public WebElement getEnterMailInvite() {
		return enterMailInvite;
	}

	public WebElement getCopyLinkToShare() {
		return copyLinkToShare;
	}


	public WebElement getCreatedDiscuss() {
		return createdDiscuss;
	}

	public WebElement getCreateProfileTextarea() {
		return createProfileTextarea;
	}

	public WebElement getCreateRev() {
		return CreateRev;
	}

	public WebElement getCreateRevSaveButton() {
		return CreateRevSaveButton;
	}

	public WebElement getCustomProperties() {
		return customProperties;
	}

	public WebElement getDashboardArrow() {
		return dashboardArrow;
	}

	public WebElement getDefaultProfile() {
		return defaultProfile;
	}

	public WebElement getDeleIcon() {
		return DeleIcon;
	}

	public WebElement getDelete_repliedDiscussion() {
		return Delete_repliedDiscussion;
	}

	public WebElement getDelete_Confirmatio_Popup() {
		return Delete_Confirmation_Popup;
	}

	public WebElement getDeleteAllWithAdminCon() {
		return deleteAllWithAdminCon;
	}

	public WebElement getDeleteConAdmin() {
		return deleteConAdmin;
	}

	public WebElement getAllReviews() {
		return allReviews;
	}

	public WebElement getGroups() {
		return groups;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getDiagram1() {
		return diagram1;
	}

	public WebElement getDiagrams() {
		return diagrams;
	}

	public WebElement getDisable() {
		return Disable;
	}

	public WebElement getDisableDate() {
		return DisableDate;
	}

	public WebElement getDisableShare() {
		return disableShare;
	}

	public WebElement getDisableText() {
		return disableText;
	}

	public WebElement getDiscard() {
		return Discard;
	}

	public WebElement getDiscussionAddReply() {
		return discussionAddReply;
	}

	public WebElement getDiscussionAll() {
		return discussionAll;
	}

	public WebElement getDiscussionDefaultText() {
		return discussionDefaultText;
	}

	public WebElement getDiscussionLike() {
		return discussionLike;
	}

	public WebElement getDiscussionParticipated() {
		return Participated;
	}

	public WebElement getDiscussText() {
		return discussText;
	}

	public WebElement getDiscussTextPost() {
		return discussTextPost;
	}

	public WebElement getAfterPost_DiscussionStatus() {
		return AfterPost_DiscussionStatus;
	}

	public WebElement getRepliedUser_ProfileIcon() {
		return repliedUser_ProfileIcon;
	}

	public WebElement getDiscussTextTyping() {
		return discussTextTyping;
	}

	public WebElement getDropdownInShare() {
		return dropdownInShare;
	}

	public WebElement getEditIcon() {
		return EditIcon;
	}

	public WebElement getEditRev() {
		return EditRev;
	}

	public WebElement getEdtDeleIcon() {
		return EdtDeleIcon;
	}

	public WebElement getEmailNotificationChkBox() {
		return emailNotificationChkBox;
	}

	public WebElement getEmbeddedLinks() {
		return embeddedLinks;
	}

	public WebElement getEmbedSelectionInShare() {
		return embedSelectionInShare;
	}

	public WebElement getEnable() {
		return Enable;
	}

	public WebElement getEndDateErrMsg() {
		return endDateErrMsg;
	}

	public WebElement getEndDatePriorErrMsg() {
		return endDatePriorErrMsg;
	}

	public WebElement getUserRadioButton() {
		return userRadioButton;
	}

	public WebElement getExPackageScroll() {
		return ExPackageScroll;
	}

	public WebElement getFilterApply() {
		return filterApply;
	}

	public WebElement getFilterDropdown() {
		return FilterDropdown;
	}

	public WebElement getGeneralSetting() {
		return generalSetting;
	}

	public WebElement getCloseDiscussion() {
		return closeDiscussion;
	}

	public WebElement getHomePageDashboard() {
		return homePageDashboard;
	}

	public WebElement getMarkAsRejected() {
		return markAsRejected;
	}

	public WebElement getStatusApprove_Reject() {
		return StatusApprove_Reject;
	}

	public WebElement getHomePageDiagrams() {
		return homePageDiagrams;
	}

	public WebElement getHomePageDropDown() {
		return homePageDropDown;
	}

	public WebElement getHoveringMsg() {
		return hoveringMsg;
	}

	public WebElement getHtmlpageAdd() {
		return htmlpageAdd;
	}

	public WebElement getHtmlWidgetSave() {
		return htmlWidgetSave;
	}

	public WebElement getHtmlWidgetTextArea() {
		return htmlWidgetTextArea;
	}

	public WebElement getIncompleteRev() {
		return incompleteRev;
	}

	public WebElement getMyStatus_review() {
		return myStatus_review;
	}

	public WebElement getInsideModelingLangua() {
		return insideModelingLanguage;
	}

	public WebElement getIntegrationApplicationProperties() {
		return integrationApplicationProperties;
	}

	public WebElement getIntegrationApplications() {
		return integrationApplications;
	}

	public WebElement getIntegrationPropertyName() {
		return integrationPropertyName;
	}

	public WebElement getInviteChkBox() {
		return InviteChkBox;
	}

	public WebElement getInviteCollaborators() {
		return inviteCollaborators;
	}

	public WebElement getInviteContributor() {
		return inviteContributor;
	}

	public WebElement getInvitedCollaboratorsList() {
		return invitedCollaboratorsList;
	}

	public WebElement getActivityPackage() {
		return ActivityPackage;
	}

	public WebElement getAnalysisPackage() {
		return AnalysisPackage;
	}

	public WebElement getItem1() {
		return item1;
	}

	public WebElement getItem2() {
		return item2;
	}

	public WebElement getItem3() {
		return item3;
	}

	public WebElement getItem4() {
		return item4;
	}

	public WebElement getItemDropDown() {
		return itemsDropDown;
	}

	public WebElement getAllTypeOfDiagramDropDown() {
		return allTypeOfDiagramDropDown;
	}

	public WebElement getItemsListCheck() {
		return ItemsListCheck;
	}

	public WebElement getItemText() {
		return itemText;
	}

	public WebElement getRemoveUser() {
		return removeUser;
	}

	public WebElement getLearnMore() {
		return learnMore;
	}

	public WebElement getListOfADgroup() {
		return listOfADgroup;
	}

	public WebElement getMailerConfiguration() {
		return mailerConfiguration;
	}

	public WebElement getManageApplicationProject() {
		return manageApplicationProject;
	}


	public WebElement getModelingLanguage() {
		return modelingLanguage;
	}

	public WebElement getNext() {
		return Next;
	}

	public WebElement getNoItemsFound() {
		return noItemsFound;
	}

	public WebElement getNotes() {
		return Notes;
	}

	public WebElement getNotificationBox() {
		return notificationBox;
	}

	public WebElement getNotificationSetting() {
		return notificationSetting;
	}

	public WebElement getNotYetToStartRev() {
		return NotYetToStartRev;
	}

	public WebElement getOpenFormDesigner() {
		return openFormDesigner;
	}

	public WebElement getOpenRev() {
		return OpenRev;
	}

	public WebElement getOpenRevList() {
		return OpenRevList;
	}

	public WebElement getPackageArrow() {
		return packageArrow;
	}

	public WebElement getPackageDropDown() {
		return packageDropDown;
	}

	public WebElement getPopupWindowDeleteOption() {
		return PopupWindowDeleteOption;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getProjectArrow() {
		return projectArrow;
	}


	public WebElement getProperties() {
		return properties;
	}


	public WebElement getRemoveItem1() {
		return removeItem1;
	}

	public WebElement getRemoveItem2() {
		return removeItem2;
	}

	public WebElement getRemoveItem3() {
		return removeItem3;
	}

	public WebElement getRemoveItem4() {
		return removeItem4;
	}

	public WebElement getRemoveItems() {
		return removeItems;
	}

	public WebElement getRepoName() {
		return RepoName;
	}

	public WebElement getRepoSetting() {
		return repoSetting;
	}

	public WebElement getRepoSettingHome() {
		return repoSettingHome;
	}

	public WebElement getRepositories() {
		return Repositories;
	}

	public WebElement getRevActive() {
		return RevActive;
	}

	public WebElement getRevChangeStatus() {

		return revChangeStatus;
	}

	public WebElement getRevClosed() {
		return RevClosed;
	}

	public WebElement getClosed2() {
		return Closed2;
	}

	public WebElement getOpen2() {
		return Open2;
	}

	public WebElement getClosed3() {
		return Closed3;
	}

	public WebElement getRevCreatedMsg() {
		return revCreatedMsg;
	}

	public WebElement getRevDefaultSartDate() {
		return RevDefaultStartDate;
	}

	public WebElement getRevEndDate() {
		return RevEndDate;
	}

	public WebElement getRevEndMon(String mon) {
		s = new Select(RevEndMon);
		s.selectByVisibleText(mon);
		return RevEndMon;
	}

	public WebElement getRevEndYear(String year) {
		s = new Select(RevEndYear);
		s.selectByVisibleText(year);
		return RevEndYear;
	}

	public WebElement getRevHold() {
		return revHold;
	}


	public WebElement getInviteContributorEmail() {
		return inviteContributorEmail;
	}

	public WebElement getMailinator_Links() {
		return mailinator_Links;
	}

	public WebElement getLinks_url() {
		return links_url;
	}

	public WebElement getReviews() {
		return Reviews;
	}

	public WebElement getReviewslist() {
		return Reviewslist;
	}

	public WebElement getRevName() {
		return RevName;
	}

	public WebElement getRevOnArchived() {

		return RevOnArchived;
	}

	public WebElement getRevOnClosed() {

		return RevOnClosed;
	}

	public WebElement getRevOnHold() {

		return RevOnHold;
	}

	public WebElement getRevPastStartDate() {
		return RevPastStartDate;
	}

	public WebElement getRevStartDate() {
		return RevStartDate;
	}


	public WebElement getRevStartYear(String year) {
		s = new Select(RevStartYear);
		s.selectByVisibleText(year);
		return RevStartYear;
	}

	public WebElement getRevUnameErrMsg() {
		return RevUnameErrMsg;
	}

	public WebElement getrevWarningMsg() {
		return revWarningMsg;
	}

	public WebElement getSave() {
		return Save;
	}

	public WebElement getSections() {
		return Sections;
	}

	public WebElement getSelectAll() {
		return SelectAll;
	}

	public WebElement getTypeName() {
		return TypeName;
	}

	public WebElement getSelectProfileExistprofile() {
		return getselectProfileExistprofile;
	}

	public WebElement getSelectRevItems() {
		return SelectRevItems;
	}

	public WebElement getSelectRoleAppr() {
		return SelectRoleAppr;
	}

	public WebElement getOk() {
		return ok;
	}

	public WebElement getSelectRoleModerator() {
		return SelectRoleModerator;
	}

	public WebElement getSelectRoleNone() {
		return SelectRoleNone;
	}

	public WebElement getSelectRoleNone2() {
		return SelectRoleNone2;
	}

	public WebElement getSelectRoleRev() {
		return SelectRoleRev;
	}


	public WebElement getSettingSave() {
		return SettingSave;
	}

	public WebElement getShareDaigram() {
		return shareDaigram;
	}

	public WebElement getCopyLink_icon() {
		return copyLink_icon;
	}

	public WebElement getShareDropDown() {
		return shareDropDown;
	}

	public WebElement getSignUp() {
		return signUp;
	}

	public WebElement getSignUpLastname() {
		return signUpLastname;
	}

	public WebElement getSignUpSelectDropDown() {
		return SignUpSelectDropDown;
	}

	public WebElement getSignUpSettingHeaderText() {
		return signUpSettingHeaderText;
	}

	public WebElement getSummaryMails() {
		return summaryMails;
	}

	public WebElement getThemeSetting() {
		return themeSetting;
	}

	public WebElement getTimeZoneSearchbox() {
		return timeZoneSearchbox;
	}


	public WebElement getUName() {
		return UName;
	}

	public WebElement getUpdateRev() {
		return updateRev;
	}

	public WebElement getUpdateRevDisplay() {
		return updateRevDisplay;
	}

	public WebElement getUserAndLicenseManagement() {
		return UserAndLicenseManagement;
	}

	public WebElement getUserLicenseAct_InAct() {
		return UserLicenseAct_InAct;
	}

	public WebElement getUserLicenseEdit() {
		return UserLicenseEdit;
	}

	public WebElement getUsersAD_Group() {
		return usersAD_Group;
	}

	public WebElement getUserSave() {
		return UserSave;
	}

	public WebElement getUserSetting() {
		return userSetting;
	}

	public WebElement getUserStatus() {
		return userStatus;
	}

	public WebElement getValidaConnection() {
		return validaConnection;
	}

	public WebElement getViewOption() {
		return viewOption;
	}

	// Gopi pojo class

			@FindBy(id = "email")
			private WebElement textEmail;

			@FindBy(id = "Password")
			private WebElement textPass;

			@FindBy(xpath = "//span[contains(text(),'Discard')]")
			private WebElement editDiscard;

			@FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
			private WebElement repoEdit;

			@FindBy(xpath = "//input[@placeholder='Enter a suitable name']")
			private WebElement reponame;

			@FindBy(xpath = "//input[@placeholder='Enter Alias Name']")
			private WebElement aliasName;

			@FindBy(xpath = "//input[@placeholder='Enter the Model Name']")
			private WebElement modelName;

			@FindBy(xpath = "//input[@placeholder='Enter the Server DNS or IP address']")
			private WebElement serverName;

			@FindBy(xpath = "//input[@placeholder='Enter the Port']")
			private WebElement portNo;

			@FindBy(xpath = "(//span[text()='Active'])[1]")
			private WebElement statusActive;

			@FindBy(xpath = "(//div[@class='ng-input'])[1]")
			private WebElement protocolName;

			@FindBy(xpath = "//input[@placeholder='Enter UserID']")
			private WebElement eaLogin;

			@FindBy(xpath = "//input[@placeholder='Enter Password']")
			private WebElement eaPassword;

			@FindBy(xpath = "//textarea[@placeholder='Give a summary of this repository to your users (Optional)']")
			private WebElement repoDescription;

			@FindBy(xpath = "//span[contains(text(),'Cancel')]")
			private WebElement repoCancel;

			@FindBy(xpath = "//span[contains(text(),'Delete')]")
			private WebElement repoDelete;

			@FindBy(xpath = "//a[contains(text(),'Repositories')]")
			private WebElement repoBreadcrumbs;

			@FindBy(xpath = "//span[contains(text(),'Add Repository')]")
			private WebElement addRepoBtn;

			@FindBy(xpath = "//img[@class='d-inline-block rounded-circle user-icon']")
			private WebElement profileIcon;

			@FindBy(xpath = "(//span[@class='p-treenode-label'])[1]") // path of Sections page in repository
			private WebElement sectionsExMod;

			@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
			private WebElement signout;

			@FindBy(xpath = "(//span[contains(text(),'More')])[1]")
			private WebElement more1;

			@FindBy(xpath = "(//span[contains(text(),'More')])[2]")
			private WebElement more2;

			@FindBy(xpath = "//span[contains(text(),'Make Default')]")
			private WebElement makeDefault1;

			@FindBy(xpath = "//span[contains(text(),'Configure Manually')]")
			private WebElement manualConfig;

			@FindBy(xpath = "//span[contains(text(),'Configure Automatically')]")
			private WebElement autoConfig;

			@FindBy(xpath = "//span[contains(text(),'Go Back')]")
			private WebElement editGoBack;

			@FindBy(xpath = "//input[@id='activeRepository']")
			private WebElement statusBtn;

			@FindBy(xpath = "//ngb-alert[contains(text(),'Invalid Pro Cloud Server details! Please check the details in the Application Server')]")
			private WebElement invalidPCS;

			@FindBy(xpath = "//input[@id='enableRequiredAuthendication']")
			private WebElement enableSecurity;

			@FindBy(xpath = "//a[text()='LOG IN WITH SSO']")
			private WebElement sso;

			@FindBy(id = "okta-signin-username")
			private WebElement oktaUsername;

			@FindBy(xpath = "//input[@class='button button-primary']")
			private WebElement oktaNext;

			@FindBy(id = "okta-signin-password")
			private WebElement oktaPassword;

			@FindBy(id = "okta-signin-submit")
			private WebElement oktaSubmit;

			public WebElement getOktaSubmit() {
				return oktaSubmit;
			}

			@FindBy(xpath = "//div//h3[text()='Password']/following::div//a[text()='Select']")
			private WebElement passwordSelect;

			@FindBy(xpath = "(//div//h3[text()='Enter a code']/following::div//a[text()='Select'])[1]")
			private WebElement enterCodeSelect;

			@FindBy(xpath = "//div[contains(text(),'SAML Single Sign On')]")
			private WebElement samlsso;

			@FindBy(xpath = "//label[contains(text(),'Enable')]")
			private WebElement samlEnable;

			@FindBy(xpath = "//label[contains(text(),'Disable')]")
			private WebElement samlDisable;

			@FindBy(xpath = "//input[@autocomplete='new-idPSigninUrl']")
			private WebElement IDPSignInUrl;

			@FindBy(xpath = "//input[@autocomplete='new-SignOuURL']")
			private WebElement IDPSignOutUrl;

			@FindBy(xpath = "//div[contains(text(),'Users')]")
			private WebElement reporUser;

			@FindBy(xpath = "//div[contains(text(),'Access Control Profiles')]")
			private WebElement accessControlProfile;

			@FindBy(xpath = "//input[@name='email']")
			private WebElement jumpcloudEmail;

			@FindBy(xpath = "//input[@name='password']")
			private WebElement jumpcloudPassword;

			@FindBy(id = "username")
			private WebElement pingUsername;

			@FindBy(id = "password")
			private WebElement pingPassword;

			@FindBy(xpath = "//button[text()='Sign On']")
			private WebElement pingSignon;
			
			@FindBy(xpath = "//span[contains(text(),'Create Dashboard')]")
			private WebElement createDash;

			@FindBy(xpath = "//div[contains(text(),'User Groups')]")
			private WebElement repoUserGroup;

			@FindBy(xpath = "//span[(text()='Templates')]")
			private WebElement templateBtn;

			@FindBy(xpath = "//span[contains(text(),'Create New')]")
			private WebElement newDash;

			@FindBy(xpath = "//input[@id='dashStatus']")
			private WebElement dashStatus;

			@FindBy(xpath = "//input[@id='dashTemplate']")
			private WebElement dashTemplate;

			@FindBy(xpath = "//input[@placeholder='Give a self-explanatory name to the Dashboard']")
			private WebElement dashName;

			@FindBy(xpath = "//span[contains(text(),'Make Template')]")
			private WebElement makeTemplate;

			@FindBy(xpath = "//span[contains(text(),'Remove Template')]")
			private WebElement removeTemplate;

			@FindBy(xpath = "(//input[@placeholder='Search'])[8]")
			private WebElement dashTemplaSearch;

			@FindBy(xpath = "//span[contains(text(),'Create Profile')]")
			private WebElement createProfile;

			@FindBy(xpath = "//input[@placeholder='Enter a Name']")
			private WebElement accessControlProfileName;

			@FindBy(xpath = "//span[contains(text(),'Remove Default')]")
			private WebElement removeDefault;

			@FindBy(xpath = "//div[contains(text(),'Sections')]")
			private WebElement menuSections;

			@FindBy(id = "userNameInput")
			private WebElement adfsUsername;

			@FindBy(id = "submitButton")
			private WebElement adfsSigninButton;

			public WebElement getAdfsSigninButton() {
				return adfsSigninButton;
			}

			@FindBy(id = "passwordInput")
			private WebElement adfsPassword;

			@FindBy(xpath = "//span[contains(text(),'Remove')]")
			private WebElement remove;

			@FindBy(xpath = "//div[contains(text(),'User and License Management')]")
			private WebElement userAndLicenseManage;

			@FindBy(xpath = "(//span[text()='Dashboards']/following::a[@class='dropdown-toggle rounded-end'])[1]")
			private WebElement dashboardDropdown;

			@FindBy(id = "i0116")
			private WebElement azureEmail;

			@FindBy(id = "i0118")
			private WebElement azurePass;

			@FindBy(xpath = "//input[@id='idSIButton9']")
			private WebElement azureNext;

			@FindBy(xpath = "//input[@type='submit']")
			private WebElement azureSignIn;

			@FindBy(xpath = "//input[@id='idSIButton9']")
			private WebElement azureYes;

			@FindBy(xpath = "//span[contains(text(),'Make  Default')]")
			private WebElement makeDefault;

			@FindBy(xpath = "//span[contains(text(),'Change Default Group')]")
			private WebElement chngeDeflGrp;

			@FindBy(xpath = "(//span[contains(text(),'Edit')])[2]")
			private WebElement Edit2;
			
			@FindBy(xpath = "//div[contains(text(),'Users')]")
			private WebElement repoUser;

			@FindBy(xpath = "//span[contains(text(),'Add User')]")
			private WebElement repoAdduser;

			@FindBy(xpath = "//span[contains(text(),'ADtest')]")
			private WebElement adTest;

			@FindBy(xpath = "//span[contains(text(),'Active Directory Groups')]")
			private WebElement ADGroups;

			@FindBy(xpath = "//span[contains(text(),'Add Widget')]")
			private WebElement addwidget;

			@FindBy(xpath = "(//div[@class='row mb-3'])[1]//button[@class='color-pick-btn']")
			private WebElement titleBackgrondColor;

			@FindBy(xpath = "(//div[@class='row mb-3'])[2]//button[@class='color-pick-btn']")
			private WebElement titleTextColor;

			@FindBy(xpath = "(//div[@class='row mb-3'])[3]//button[@class='color-pick-btn']")
			private WebElement bodyBackgrondColor;

			@FindBy(xpath = "(//div[@class='row mb-3'])[4]//button[@class='color-pick-btn']")
			private WebElement borderColor;

			@FindBy(xpath = "//div[@class='hex-text ng-star-inserted']//input")
			private WebElement hexaCode;

			@FindBy(xpath = "//input[@id='widgetMaximize']")
			private WebElement maxWidget;

			@FindBy(xpath = "//input[@id='widgetTemplate']")
			private WebElement widgetTemplate;

			@FindBy(xpath = "//button[@type='button']//span[contains(text(),'Add')]")
			private WebElement widgetAdd;

			@FindBy(xpath = "(//span[text()='Save'])[2]")
			private WebElement save2;

			@FindBy(xpath = "//input[@id='requireStatus']")
			private WebElement userGroupStatus;

			@FindBy(xpath = "//span[contains(text(),'SSO Login')]")
			private WebElement jumpcloudSSOLogin;

			

			@FindBy(xpath = "//label[contains(text(),'Single Access')]")
			private WebElement singleAccess;

			@FindBy(xpath="//span[text()='Create Integration Property']")
			private WebElement createIntegrationProperty;
			
			@FindBy(xpath="//input[@placeholder='Enter a self-explanatory name']")
			private WebElement integrationName;
			//fa-icon[contains(@class,'ng-fa-icon')]//*[@role='img' and @class='svg-inline--fa fa-home fa-w-18']
			@FindBy(xpath="//fa-icon[contains(@class,'ng-fa-icon')]//*[@data-icon='house' ]")
			private WebElement homeIcon;
			
			@FindBy(xpath="//span[contains(text(),'Import')]")
			private WebElement customPropertyImport;
			
			@FindBy(xpath="(//span[contains(text(),'Add Modeling Language')])")
			private WebElement addModelingLanguageButton;
			
			@FindBy(xpath="//input[@placeholder='Enter the Name of the MDG']")
			private WebElement mdgName;
			
			@FindBy(id="MDGInherited")
			private WebElement inheritedButton;
			
			@FindBy(id="MDGTechnology")
			private WebElement technologyButton;
			
			@FindBy(xpath="//input[@placeholder='Give a name to the Profile']")
			private WebElement profileName;
			
			@FindBy(xpath="//button[contains(@class,'close')]")
			private WebElement popupCloseIcon;
			
			@FindBy(xpath="//input[@placeholder='Describe the usage of this profile']")
			private WebElement profileDescription;
			
			@FindBy(id="mdgTechnologyProperties")
			private WebElement profileTechnologyButton;
			
			@FindBy(id="mdgProfilesInheritedProperties")
			private WebElement profilesInheritedProperties;
			
			@FindBy(id="mdgPropertiesBaseStereotype")
			private WebElement profileBaseStereotype;
			
			@FindBy(xpath="//h3//span[contains(text(),'Import Profiles from other Repositories')]")
			private WebElement importProfilePageText;
			
			@FindBy(xpath="//button//span[contains(text(),' Import Profile')]")
			private WebElement importProfileButton;
			
			@FindBy(xpath="//button//span[text()='Import']")
			private WebElement profileImportButton;
			
			@FindBy(xpath="//span[text()='General Properties']")
			private WebElement mdgGeneralProperties;
			
			@FindBy(xpath="//app-mdg-basic-attributes//span[text()='Element']")
			private WebElement mdgGeneralPropElement;
			
			@FindBy(xpath="//ngb-modal-window//span[text()=' Configure Stereotypes']")
			private WebElement profileConfigureStereotypes;
			
			@FindBy(xpath="(//span[text()='Modeling Languages'])")
			private WebElement moldelingLangTab;
			
			
			@FindBy(xpath="//app-mdg-basic-attributes//span[text()='Attribute']")
			private WebElement mdgGeneralPropAttribute;
			
			
			@FindBy(xpath="//app-mdg-basic-attributes//span[text()='Operation']")
			private WebElement mdgGeneralPropOperation;

			@FindBy(xpath="//app-mdg-basic-attributes//span[text()='Connector']")
			private WebElement mdgGeneralPropConnector;
			
			@FindBy(xpath="(//p-treenode//div//button[@type='button'])[1]")
			private WebElement clickingFirstPackage;
			
			@FindBy(xpath="(//p-treenode//div//button[@type='button'])[2]")
			private WebElement clickingSecondPackage;
			
			@FindBy(xpath="(//p-treenode//div//button[@type='button'])[3]")
			private WebElement clickingThirdPackage;
			
			@FindBy(xpath="//span[contains(text(),'Traceability')]")
			private WebElement propertiesTraceability;
			
			@FindBy(xpath = "//span[text()='Add Connector Property']")
			public WebElement addConnectorProperty;
			
			@FindBy(xpath = "//ngb-modal-window//span[text()='Skip Report']")//22-11-2022 16:06
			public WebElement popupSkipReport;
			
			@FindBy(xpath = "//span[contains(text(),'Next')]")//22-11-2022 17:47
			public WebElement nextButton;
			
			@FindBy(xpath = "//label[contains(text(),'Connector Stereotype')]//following::input[1]")//23-11-2022 10:47
			public WebElement connectorStereotypeInput;
			
			@FindBy(xpath = "//span[contains(text(),'Type')]//following::input[1]")//23-11-2022 12:34 
			public WebElement specificTypeInput;
			
			@FindBy(xpath = "//span[contains(text(),'Stereotype')]//following::input[2]")//23-11-2022 14:14 
			public WebElement specificStereotypeInput;
			
			
			@FindBy(xpath = "//app-basic-properties//h4//span[text()='Connector Properties']")//25-11-2022 12:09 
			public WebElement propertiesTitleConnectorProperties;
			
			@FindBy(xpath = "//div//h4[text()='Traceability']//following::td//a[contains(text(),'SequenceFlow')]")//25-11-2022 12:30
			public WebElement traceabilitySequenceFlow;
			
			@FindBy(xpath = "//ng-dropdown-panel//span[text()='Basic Properties']")//25-11-2022 16:13
			public WebElement basicProperties;
			
			@FindBy(xpath = "//ng-dropdown-panel//span[text()='Name']")//25-11-2022 16:17
			public WebElement basicPropertiesNames;
			
			@FindBy(xpath = "//input[@placeholder='Enter values']")//25-11-2022 16:36
			public WebElement basicPropertiesFilterValues;
					
			@FindBy(xpath = "(//app-helpicon//fa-icon)[1]")//28-11-2022 14:39
			public WebElement targetSelectionHelpIcon;
			
			@FindBy(xpath = "(//app-helpicon//fa-icon)[2]")//28-11-2022 15:09
			public WebElement filterByPropertyHelpIcon;
			
			@FindBy(xpath = "//app-mdg-create-connector-add-edit-form-page//input[@placeholder='Enter a self-explanatory name']")//28-11-2022 16:03
			public WebElement connectorName;
			
			
			@FindBy(xpath = "//ng-select//span[text()='Write']//preceding::span[1]")//29-11-2022 10:35
			public WebElement removeSingleAccessWrite;
			
			@FindBy(xpath = "//ng-select//span[text()='Write']")//29-11-2022 10:59
			public WebElement singleAccessWrite;
			
			@FindBy(xpath = "//ngb-modal-window//span[contains(text(),'Cancel')]")//29-11-2022 15:04
			public WebElement popupWindowCancelButton;
			
			@FindBy(xpath = "(//app-property-window//span[@class='ng-arrow-wrapper'])[1]")//30-11-2022 10:45
			public WebElement propertiesDropdownButton;
			
			@FindBy(xpath = "(//ng-dropdown-panel//span[text()='Properties'])")//30-11-2022 10:55
			public WebElement propertiesDropdownPropertiesButton;
					
			@FindBy(xpath = "//ngb-modal-window//h4")//30-11-2022 17:06
			public WebElement chooseReportListWindow;
			
			@FindBy(xpath = "//ngb-modal-window//button//span[text()='Use Report']")//30-11-2022 17:06
			public WebElement useReportListWindow;
			
			@FindBy(xpath = "//app-query-configuration//textarea[@placeholder='Name, EA_GUID, Type, and Stereotype columns should be present in the query']")//01-12-2022 12:54
			public WebElement enterConnectorQuery;
			
			@FindBy(xpath = "(//app-query-configuration//div/label[text()='Query']//following::button//span[text()='Execute'])[1]")//01-12-2022 14:20
			public WebElement queryExecuteButton;
			
			@FindBy(xpath = "(//ngb-modal-window//ngb-accordion//span[text()='Execute'])")//01-12-2022 14:24
			public WebElement popupExecuteButton;
			
			@FindBy(xpath = "//ngb-modal-window//button/span[text()='Save Query']")//01-12-2022 14:39
			public WebElement popupSaveQueryButton;
			
			
			@FindBy(xpath = "//ngb-modal-window//span[text()='Save Value']")//01-12-2022 14:54
			public WebElement popupSaveValueButton;
			
			@FindBy(xpath = "//ngb-modal-window//button/span[text()='Close']")//01-12-2022 15:03
			public WebElement popupCloseButton;

			@FindBy(xpath = "//div[@class='form-group']//label[text()='Selected Report Name:']//following::span[1]")//02-12-2022 15:22
			public WebElement selectedReportName;
			
			
			@FindBy(xpath = "//ngb-modal-window//label[text()='Filter configured from']//following::a[1]")//02-12-2022 15:49
			public WebElement filterConfiguredType;
			
			
			@FindBy(xpath = "//div//h4[text()='Traceability']//following::td//a[contains(text(),'Connected')]")//05-12-2022 14:47
			public WebElement traceabilityConnected;
			
			@FindBy(xpath = "//h4[text()=' Reports ']/fa-icon[1]")//05-12-2022 16:26
			public WebElement addReportWidgetPlus;
			
			
			@FindBy(xpath = "//input[@placeholder='Enter Chart Name']")//05-12-2022 16:35
			public WebElement enterChartName;
			
			
			@FindBy(xpath = "(//app-query-configuration//div/label[text()='Subreport']//following::button//span[text()='Execute'])[1]")//05-12-2022 16:57
			public WebElement subreportExecueButton;
			
			@FindBy(xpath = "//app-nodata//div[text()='No search results found! Alter your search term and try again']")//07-12-2022 10:27
			public WebElement noSearchResult;
			
			@FindBy(xpath = "//app-show-more//span[text()='[Show More]']")//07-12-2022 11:36
			public WebElement showMore;
			
			@FindBy(xpath = "//span[text()='Export']")//07-12-2022 11:49
			public WebElement exportOption;
			
			@FindBy(xpath = "//app-bulk-action//span[text()='Export']")//07-12-2022 12:35
			public WebElement bulkExportOption;
			
			
			@FindBy(xpath = "//ngb-modal-window//span[contains(text(),'Import')]")//07-12-2022 16:05
			public WebElement popupImportButton;
			
			@FindBy(xpath = "//span[text()='Remove All']")//08-12-2022 10:34
			public WebElement sectionsRemoveAll;
			
			@FindBy(xpath="//ngb-modal-window// button[text()=' View Connector Details ']")//08-12-2022 12:39
			public WebElement viewConnectorDetailsButton;
			
			@FindBy(xpath="//ngb-modal-window//label[text()='Connector Direction']//following::span[1]")
			public WebElement ConnectorDirection;
			
			@FindBy(xpath = "//span[text()='Add Query Property']")//12-12-2022 18:20
			public WebElement addQueryProperty;
			
			
			@FindBy(xpath = "//app-mdg-query-attribute-add-edit-page//input[@placeholder='Enter a self-explanatory name']")//13-12-2022 14:20
			public WebElement queryName;
			
			@FindBy(xpath = "(//app-datatable//tr//th//input)[2]")//14-12-2022 15:13
			public WebElement searchCustomPropName;
			
			@FindBy(xpath = "//ngb-modal-window//button[contains(text(),'Close')]")//14-12-2022 18:21
			public WebElement reportPopuoCloseButton;
			
			@FindBy(xpath = "//ngb-modal-window//div[contains(@class,'modal-footer')]//app-button//span[contains(text(),'Select')]")//22-12-2022 12:09
			public WebElement popuoSelectButton;
		
		
			@FindBy(xpath = "//ngb-modal-window//span[contains(text(),'Next')]")//23-12-2022 12:29
			public WebElement reportPopuoNextButton;
		
			@FindBy(xpath="//app-reactiveforminput[@controlname='idPName']//input[1]")//27-12-2022 12:09
			private WebElement idPName;
			
			@FindBy(xpath="//app-switchbtn//label[contains(text(),'Default')]")//27-12-2022 14:45
			private WebElement idPAttributeMappingDefault;
			
			@FindBy(xpath="//app-switchbtn//label[contains(text(),'Custom')]")//27-12-2022 15:25
			private WebElement idPAttributeMappingCustom;
			
			@FindBy(xpath="//input[@id='undefined' and @type='checkbox']")//27-12-2022 16:30
			private WebElement samlGroupToggleSwitch;
			
			@FindBy(xpath="//app-saml-access-control-profile//app-reactiveforminput/input[@placeholder='Enter the Saml Group Name']")//28-12-2022 15:30
			private WebElement samlGroupName;
			
			//app-dropdown//div[contains(@class,'dropdown-content')]//a//span[text()='My Profile']
			@FindBy(xpath="//app-dropdown//div[contains(@class,'dropdown-content')]//a//span[text()='My Profile']")//29-12-2022 10:30
			private WebElement myProfile;
			
			@FindBy(xpath="//span[contains(text(),'Administrator Login')]")//29-12-2022 11:06
			private WebElement jumpcloudAdminLogin;
			
			@FindBy(xpath="//button/span[contains(text(),'Continue')]")//29-12-2022 12:24
			private WebElement jumpcloudContinue;

			@FindBy(xpath="(//app-saml-access-control-profile//app-reactiveforminput/input[@placeholder='Enter the Saml Group Name'])[2]")//29-12-2022 15:58
			private WebElement samlGroupName2;

			@FindBy(xpath="(//app-button-clear//button)[2]")//29-12-2022 16:02
			private WebElement samlDelteButton1;

			@FindBy(xpath="(//p-table//input)[1]")//04-01-2023 15:07
			private WebElement reportConfigSearch;
			
//			gopistart
			
			public WebElement getOktaPassword() {
				return oktaPassword;
			}
			
			public WebElement getReportConfigSearch() {
				return reportConfigSearch;
			}

			public WebElement getSamlDelteButton1() {
				return samlDelteButton1;
			}

			public WebElement getSamlGroupName2() {
				return samlGroupName2;
			}

			public WebElement getJumpcloudContinue() {
				return jumpcloudContinue;
			}

			public WebElement getJumpcloudAdminLogin() {
				return jumpcloudAdminLogin;
			}

			public WebElement getMyProfile() {
				return myProfile;
			}

			public WebElement getSamlGroupName() {
				return samlGroupName;
			}

			public WebElement getSamlGroupToggleSwitch() {
				return samlGroupToggleSwitch;
			}

			public WebElement getIdPAttributeMappingCustom() {
				return idPAttributeMappingCustom;
			}

			public WebElement getIdPAttributeMappingDefault() {
				return idPAttributeMappingDefault;
			}

			public WebElement getIdPName() {
				return idPName;
			}

			public WebElement getReportPopuoNextButton() {
			return reportPopuoNextButton;
			}

			public WebElement getPopuoSelectButton() {
			return popuoSelectButton;
			}
			
			public WebElement getReportPopuoCloseButton() {
				return reportPopuoCloseButton;
			}

			public WebElement getSearchCustomPropName() {
				return searchCustomPropName;
			}

			public WebElement getQueryName() {
				return queryName;
			}

			public WebElement getAddQueryProperty() {
				return addQueryProperty;
			}

			public WebElement getConnectorDirection() {
				return ConnectorDirection;
			}

			public WebElement getViewConnectorDetailsButton() {
				return viewConnectorDetailsButton;
			}

			public WebElement getSectionsRemoveAll() {
				return sectionsRemoveAll;
			}

			public WebElement getPopupImportButton() {
				return popupImportButton;
			}

			public WebElement getBulkExportOption() {
				return bulkExportOption;
			}

			public WebElement getExportOption() {
				return exportOption;
			}

			public WebElement getShowMore() {
				return showMore;
			}

			public WebElement getNoSearchResult() {
				return noSearchResult;
			}

			public WebElement getSubreportExecueButton() {
				return subreportExecueButton;
			}

			public WebElement getEnterChartName() {
				return enterChartName;
			}

			public WebElement getAddReportWidgetPlus() {
				return addReportWidgetPlus;
			}

			public WebElement getTraceabilityConnected() {
				return traceabilityConnected;
			}

			public WebElement getFilterConfiguredType() {
				return filterConfiguredType;
			}

			public WebElement getSelectedReportName() {
				return selectedReportName;
			}

			public WebElement getPopupCloseButton() {
				return popupCloseButton;
			}

			public WebElement getPopupSaveValueButton() {
				return popupSaveValueButton;
			}

			public WebElement getPopupSaveQueryButton() {
				return popupSaveQueryButton;
			}

			public WebElement getPopupExecuteButton() {
				return popupExecuteButton;
			}

			public WebElement getQueryExecuteButton() {
				return queryExecuteButton;
			}

			public WebElement getEnterConnectorQuery() {
				return enterConnectorQuery;
			}

			public WebElement getUseReportListWindow() {
				return useReportListWindow;
			}

			public WebElement getChooseReportListWindow() {
				return chooseReportListWindow;
			}

			public WebElement getPropertiesDropdownPropertiesButton() {
				return propertiesDropdownPropertiesButton;
			}

			public WebElement getPropertiesDropdownButton() {
				return propertiesDropdownButton;
			}

			public WebElement getPopupWindowCancelButton() {
				return popupWindowCancelButton;
			}

			public WebElement getSingleAccessWrite() {
				return singleAccessWrite;
			}

			public WebElement getRemoveSingleAccessWrite() {
				return removeSingleAccessWrite;
			}

			public WebElement getConnectorName() {
				return connectorName;
			}

			public WebElement getFilterByPropertyHelpIcon() {
				return filterByPropertyHelpIcon;
			}

			public WebElement getTargetSelectionHelpIcon() {
				return targetSelectionHelpIcon;
			}

			public WebElement getBasicPropertiesFilterValues() {
				return basicPropertiesFilterValues;
			}

			public WebElement getBasicPropertiesNames() {
				return basicPropertiesNames;
			}

			public WebElement getBasicProperties() {
				return basicProperties;
			}

			public WebElement getTraceabilitySequenceFlow() {
				return traceabilitySequenceFlow;
			}

			public WebElement getPropertiesTitleConnectorProperties() {
				return propertiesTitleConnectorProperties;
			}

			public WebElement getSpecificStereotypeInput() {
				return specificStereotypeInput;
			}

			public WebElement getSpecificTypeInput() {
				return specificTypeInput;
			}

			public WebElement getConnectorStereotypeInput() {
				return connectorStereotypeInput;
			}

			public WebElement getNextButton() {
				return nextButton;
			}

			public WebElement getPopupSkipReport() {
				return popupSkipReport;
			}

			public WebElement getAddConnectorProperty() {
				return addConnectorProperty;
			}

			public WebElement getPropertiesTraceability() {
				return propertiesTraceability;
			}

			public WebElement getClickingFirstPackage() {
				return clickingFirstPackage;
			}

			public WebElement getClickingSecondPackage() {
				return clickingSecondPackage;
			}

			public WebElement getClickingThirdPackage() {
				return clickingThirdPackage;
			}

			public WebElement getMdgGeneralPropConnector() {
				return mdgGeneralPropConnector;
			}

			public WebElement getMdgGeneralPropOperation() {
				return mdgGeneralPropOperation;
			}

			public WebElement getMdgGeneralPropAttribute() {
				return mdgGeneralPropAttribute;
			}

			public WebElement getMoldelingLangTab() {
				return moldelingLangTab;
			}

			public WebElement getProfileConfigureStereotypes() {
				return profileConfigureStereotypes;
			}

			public WebElement getMdgGeneralPropElement() {
				return mdgGeneralPropElement;
			}

			public WebElement getMdgGeneralProperties() {
				return mdgGeneralProperties;
			}

			public WebElement getProfileImportButton() {
				return profileImportButton;
			}

			public WebElement getImportProfileButton() {
				return importProfileButton;
			}

			public WebElement getImportProfilePageText() {
				return importProfilePageText;
			}

			public WebElement getProfileBaseStereotype() {
				return profileBaseStereotype;
			}

			public WebElement getProfilesInheritedProperties() {
				return profilesInheritedProperties;
			}

			public WebElement getProfileTechnologyButton() {
				return profileTechnologyButton;
			}

			public WebElement getProfileDescription() {
				return profileDescription;
			}

			public WebElement getPopupCloseIcon() {
				return popupCloseIcon;
			}

			public WebElement getProfileName() {
				return profileName;
			}

			public WebElement getTechnologyButton() {
				return technologyButton;
			}

			public WebElement getInheritedButton() {
				return inheritedButton;
			}

			public WebElement getMdgName() {
				return mdgName;
			}

			public WebElement getAddModelingLanguageButton() {
				return addModelingLanguageButton;
			}

			public WebElement getCustomPropertyImport() {
				return customPropertyImport;
			}

			public WebElement getHomeIcon() {
				return homeIcon;
			}

			public WebElement getIntegrationName() {
				return integrationName;
			}

			public WebElement getCreateIntegrationProperty() {
				return createIntegrationProperty;
			}

			public WebElement getSingleAccess() {
				return singleAccess;
			}


			public WebElement getAdfsUsername() {
				return adfsUsername;
			}

			public WebElement getAdfsPassword() {
				return adfsPassword;
			}

			public WebElement getMenuSections() {
				return menuSections;
			}
			

			public WebElement getRemoveDefault() {
				return removeDefault;
			}

			public WebElement getEaPassword() {
				return eaPassword;
			}

			public WebElement getEaLogin() {
				return eaLogin;
			}

			public WebElement getAccessControlProfileName() {
				return accessControlProfileName;
			}

			public WebElement getCreateProfile() {
				return createProfile;
			}

			public WebElement getMakeTemplate() {
				return makeTemplate;
			}

			public WebElement getRemoveTemplate() {
				return removeTemplate;
			}

			public WebElement getDashTemplaSearch() {
				return dashTemplaSearch;
			}

			public WebElement getNewDash() {
				return newDash;
			}

			public WebElement getDashStatus() {
				return dashStatus;
			}

			public WebElement getDashTemplate() {
				return dashTemplate;
			}

			public WebElement getDashName() {
				return dashName;
			}

			public WebElement getTemplateBtn() {
				return templateBtn;
			}

			public WebElement getRepoUserGroup() {
				return repoUserGroup;
			}

			public WebElement getCreateDash() {
				return createDash;
			}

			public WebElement getPingUsername() {
				return pingUsername;
			}

			public WebElement getPingPassword() {
				return pingPassword;
			}

			public WebElement getPingSignon() {
				return pingSignon;
			}

			public WebElement getJumpcloudEmail() {
				return jumpcloudEmail;
			}

			public WebElement getJumpcloudPassword() {
				return jumpcloudPassword;
			}

			public WebElement getJumpcloudSSOLogin() {
				return jumpcloudSSOLogin;
			}

			public WebElement getAccessControlProfile() {
				return accessControlProfile;
			}

			public WebElement getUserAndLicenseManage() {
				return userAndLicenseManage;
			}

			public WebElement getUserGroupStatus() {
				return userGroupStatus;
			}

			public WebElement getTitleBackgrondColor() {
				return titleBackgrondColor;
			}

			public WebElement getTitleTextColor() {
				return titleTextColor;
			}

			public WebElement getBodyBackgrondColor() {
				return bodyBackgrondColor;
			}

			public WebElement getBorderColor() {
				return borderColor;
			}

			public WebElement getHexaCode() {
				return hexaCode;
			}

			public WebElement getMaxWidget() {
				return maxWidget;
			}

			public WebElement getWidgetTemplate() {
				return widgetTemplate;
			}

			public WebElement getWidgetAdd() {
				return widgetAdd;
			}

			public WebElement getSave2() {
				return save2;
			}

			public WebElement getEdit2() {
				return Edit2;
			}

			public WebElement getAddwidget() {
				return addwidget;
			}

			public WebElement getRepoUser() {
				return repoUser;
			}

			public WebElement getRepoAdduser() {
				return repoAdduser;
			}


			public WebElement getAdTest() {
				return adTest;
			}

			public WebElement getADGroups() {
				return ADGroups;
			}

			public WebElement getMakeDefault() {
				return makeDefault;
			}

			public WebElement getChngeDeflGrp() {
				return chngeDeflGrp;
			}

			public WebElement getAzureSignIn() {
				return azureSignIn;
			}

			public WebElement getAzureYes() {
				return azureYes;
			}

			public WebElement getAzureEmail() {
				return azureEmail;
			}

			public WebElement getAzurePass() {
				return azurePass;
			}

			public WebElement getAzureNext() {
				return azureNext;
			}

			public WebElement getDashboardDropdown() {
				return dashboardDropdown;
			}


			public WebElement getRemove() {
				return remove;
			}

			public WebElement getReporUser() {
				return reporUser;
			}

			public WebElement getIDPSignInUrl() {
				return IDPSignInUrl;
			}

			public WebElement getIDPSignOutUrl() {
				return IDPSignOutUrl;
			}

			public WebElement getSamlEnable() {
				return samlEnable;
			}

			public WebElement getSamlDisable() {
				return samlDisable;
			}

			public WebElement getEnterCodeSelect() {
				return enterCodeSelect;
			}

			public WebElement getSamlsso() {
				return samlsso;
			}

			public WebElement getPasswordSelect() {
				return passwordSelect;
			}

			public WebElement getOktaNext() {
				return oktaNext;
			}


			public WebElement getOktaUsername() {
				return oktaUsername;
			}

			public WebElement getSso() {
				return sso;
			}

			public WebElement getEnableSecurity() {
				return enableSecurity;
			}

			public WebElement getInvalidPCS() {
				return invalidPCS;
			}

			public WebElement getStatusBtn() {
				return statusBtn;
			}

			public WebElement getRepoDelete() {
				return repoDelete;
			}

			public WebElement getManualConfig() {
				return manualConfig;
			}

			public WebElement getAutoConfig() {
				return autoConfig;
			}

			public WebElement getStatusActive() {
				return statusActive;
			}

			public WebElement getServerName() {
				return serverName;
			}

			public WebElement getPortNo() {
				return portNo;
			}

			public WebElement getProtocolName() {
				return protocolName;
			}

			public WebElement getModelName() {
				return modelName;
			}

			public WebElement getSectionsExMod() {
				return sectionsExMod;
			}


			public WebElement getRepoDescription() {
				return repoDescription;
			}

			public WebElement getAliasName() {
				return aliasName;
			}

			public WebElement getMore2() {
				return more2;
			}


			public WebElement getMakeDefault1() {
				return makeDefault1;
			}

			public WebElement getMore1() {
				return more1;
			}

			public WebElement getSignout() {
				return signout;
			}

			public WebElement getProfileIcon() {
				return profileIcon;
			}

			public WebElement getAddRepoBtn() {
				return addRepoBtn;
			}

			public WebElement getRepoBreadcrumbs() {
				return repoBreadcrumbs;
			}

			public WebElement getRepoEdit() {
				return repoEdit;
			}

			public WebElement getRepoCancel() {
				return repoCancel;
			}

			public WebElement getReponame() {
				return reponame;
			}

			public WebElement getEditDiscard() {
				return editDiscard;
			}

			public WebElement getEditGoBack() {
				return editGoBack;
			}

			public WebElement getTextEmail() {
				return textEmail;
			}

			public WebElement getTextPass() {
				return textPass;
			}
		//gopiend


			

}