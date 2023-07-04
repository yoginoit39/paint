package controller;


import model.Commands.CommandManager;
import model.Commands.RedoCommand;
import model.Commands.UndoCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import view.EventName;
import view.interfaces.IUiModule;



public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ShapeList shapeList;
    private final CommandManager commandManager;



    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.commandManager = new CommandManager();

        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, applicationState::setActiveShape);
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, applicationState::setActivePrimaryColor);
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, applicationState::setActiveSecondaryColor);
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, applicationState::setActiveShadingType);
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, applicationState::setActiveStartAndEndPointMode);
        uiModule.addEvent(EventName.UNDO, this::undo);
        uiModule.addEvent(EventName.REDO, this::redo);
        uiModule.addEvent(EventName.COPY, this::copy);
        uiModule.addEvent(EventName.PASTE, this::paste);
        uiModule.addEvent(EventName.DELETE, this::delete);
        uiModule.addEvent(EventName.GROUP, this::group);
        uiModule.addEvent(EventName.UNGROUP, this::ungroup);
    }

    private void undo() {
//        ICommand undoCommand = new UndoCommand();
//        undoCommand.run();
//            System.out.println("undo");
        boolean success = commandManager.undo();
        if (success) {
            System.out.println("Undo successful");
        } else {
            System.out.println("Nothing to undo");
        }
    }

    private void redo() {
      ICommand redoCommand = new RedoCommand();
      redoCommand.run();
        System.out.println("redo");
    }

    private void copy() {
    }

    private void paste() {
    }

    private void delete() {
    }

    private void group() {
    }

    private void ungroup() {
    }
}
