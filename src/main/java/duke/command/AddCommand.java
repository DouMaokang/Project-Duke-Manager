package duke.command;

import duke.storage.Storage;
import duke.task.PriorityList;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

//@@author talesrune
/**
 * Represents a command that adds a new task.
 */
public class AddCommand extends Command {
    protected Task task;

    /**
     * Creates a command with the specified task.
     *
     * @param task The task to be added.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes a command that adds the task into task list and outputs the result together with its priority (Gui).
     *
     * @param items The task list that contains a list of tasks.
     * @param ui To tell the user that it is deleted successfully.
     * @param priorities The list of priorities.
     */
    @Override
    public String executeGui(TaskList items, PriorityList priorities, Ui ui) {
        items.add(task);
        priorities.addDefaultPriority();
        String str = Ui.showAddGui(items);
        return str;
    }

    /**
     * Executes a command that adds the task into task list and outputs the result (GUI).
     *
     * @param items The task list that contains a list of tasks.
     * @param ui To tell the user that it is added successfully.
     * @return String to be outputted to the user.
     */
    @Override
    public String executeGui(TaskList items, Ui ui) {
        items.add(task);
        String str = Ui.showAddGui(items);
        return str;
    }

    /**
     * Executes a command that overwrites existing storage with the updated task list.
     * (Not in use)
     *
     * @param items The task list that contains a list of tasks.
     * @param ui To tell the user that it is executed successfully.
     * @param storage The storage to be overwritten.
     */
    @Override
    public void executeStorage(TaskList items, Ui ui, Storage storage) {
    }
}