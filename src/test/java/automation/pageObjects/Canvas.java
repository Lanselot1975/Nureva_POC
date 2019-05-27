package automation.pageObjects;


public class Canvas {
    //    public final static String Create_Canvas = "common-button.common-button-blue.add-Canvas-button";
    public final static String Create_Canvas = "//*[contains(text(), 'Create canvas')]";
    public final static String Canvas_UnTitle_name = "rdCanvasNameInput";
    public final static String Add_to_Canvas = "toolbar-show-button common-button common-button-blue common-button-float ng-scope";
    public final static String Add_Note = "//li[@ng-click='createCtrl.addNote()']";
    public final static String editNote = "note-content";
    public final static String complete_note = "//div[@class='done-button']";
    public final static String noteFrame = "//div[@class='needsclick rd-noteContent ng-binding ng-scope']";
    public final static String backgroundImg = "svgViewPort";
    public final static String chevron = "//div[@class='span-svg-icon ng-isolate-scope' and @icon='chevron-icon']";
    public final static String closeCanvas = "//div[@class='span-svg-icon ng-isolate-scope' and @icon='home-icon']";
    public final static String dots = "//div[@class='span-svg-icon ng-isolate-scope' and @icon='3dots-icon']";
    public final static String share = "//li[@ng-click='ctrl.onShareClicked()']";
    public final static String addUser = "//*[contains(text(), 'Users')]";
    public final static String addQAUser = "//*[contains(text(), 'QA Consultant')]";
    public final static String addButton = "//button[contains(text(), 'Add')]";
    public final static String shareButton = "//button[contains(text(), 'Share')]";
    public final static String duplicate = "//*[contains(text(), 'Duplicate')]";
    public final static String checkBox = "//input[@class='rd-input-field ng-pristine ng-untouched ng-valid ng-empty']";
    public final static String duplicateButton = "//button[@class='common-button common-button-dialog ng-binding ng-scope' and contains(text(), 'Duplicate')]";
   // public final static String verifyShareUser = "//div[@class='member-list-name' and @span='ctrl.onShareButtonClicked()' and contains(text(), 'QA Consultant')]";
    public final static String verifyShareUser = "//*[contains(text(), 'QA Consultant')]";
    public final static String cancelButton = "//button[contains(text(), 'Cancel')]";
    public final static String getNoteFromCanvas = "//*[contains(text(), 'Hello world')]";
    public final static String moveToTrashButton = "//*[contains(text(), 'Move to trash')]";
    public final static String canvasTest = "//*[contains(text(), 'Test')]";
    public final static String createSketch = "//li[@ng-click='createCtrl.addSketch()']";
    public final static String doneButton = "//div[@class='done-button']";
    public final static String sketchFrame = "//div[@class='rd-inkPage ng-scope']";
    public final static String sketchOnCanvas = "//rect{@id='ddbc9a82-abfb-979d-5e51-d75bd3ded6ab-selected']";
    public final static String sketchOnCanvasDots = "//div[@class='quick-button common-button-icon' and @ng-click='ctrl.toggleContextMenu()']";
    public final static String sketchDots = "//div[@class='rd-item-editor-menu-container ng-isolate-scope']";
    public final static String sketchMenuDuplicate = "//*[contains(text(), 'Duplicate')]";
    public final static String sketchMenuCopt = "//li[@ng-click='ctrl.onCopy()']";
    public final static String sketchMenuAddLink = "//*[contains(text(), 'Add link')]";
    public final static String sketchMenuEdit =  "//div[@class='span-svg-icon ng-isolate-scope' and @icon='edit-icon']";
    public final static String sketchThinPen = "//div[@ng-if='isThinStroke' and @class='ink-tool-container ng-scope']";
    public final static String sketchThickPen = "//div[@ng-if='isThickStroke' and @class='ink-tool-container ng-scope']";
    public final static String sketchEraser = "//div[@ng-if='isEraser' and @class='ink-tool-container ng-scope']";
    public final static String sketchDotsOnCanvas = "//div[@class='quick-button common-button-icon' and @ng-click='ctrl.toggleContextMenu()']";
    public final static String sketchCanvas = "//*[name()='div']//*[name()='canvas' and @class='rd-ink-canvas-component ng-isolate-scope']";
    public final static String sketchBlueColor = "//div[@class='color-outter ink-color-outter' and @style='background-color: rgb(66, 165, 245);']";
    public final static String sketchMenuDuplicateIcon =  "//li[@ng-if='quickops.hasDuplicate()']";
    public final static String createGroup = "//li[@ng-click='createCtrl.addGroup()']";
    public final static String createGroupName = "title-text-field";
    public final static String addGroup = "//div[@class='queue rd-sliding-thumb needsclick rd-span-thumbnail-wrap ng-isolate-scope']";
    public final static String groupOnCanavas = "//*[name()='svg']//*[name()='foreignObject' and @ng-if='ctrl.item.Title && !ctrl.hasHideTitle()']";
    public final static String sketchManualZoom = "//input[@ng-model='ctrl.zoomValue']";
    public final static String sketchCircleZoom ="//*[name()='svg']//*[name()='circle' and @ng-show='ctrl.hasResizeHandle()']";
    public final static String sketchZoomIn = "//*[name()='svg']//*[name()='rect' and @ng-click='ctrl.onItemZoom(ctrl.getItemZoomInValues)']";
    public final static String sketchZoomOut = "//*[name()='svg']//*[name()='rect' and @ng-click='ctrl.onItemZoom(ctrl.getItemZoomOutValues)']";
    public final static String sketchMenuDelete = "//*[contains(text(), 'Delete')]";
    public final static String sketchFocus = "//*[name()='svg']//*[name()='g' and @svg-controller='svg']";
    public final static String aboutClose = "//div[@class='rd-svg-icon-small common-button common-button-icon rd-close-icon span-svg-icon ng-isolate-scope' and @icon='close-icon']";
}


