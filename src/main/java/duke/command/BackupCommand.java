package duke.command;

import duke.storage.BudgetStorage;
import duke.storage.ContactStorage;
import duke.storage.PriorityStorage;
import duke.storage.Storage;
import duke.task.BudgetList;
import duke.task.ContactList;
import duke.task.PriorityList;
import duke.task.TaskList;
import duke.ui.Ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

//@@author maxxyx96
/**
 * Represents a command that updates the current data file, and shows the folder
 * that the file is contained in to the user.
 */
public class BackupCommand extends Command {

    protected static File filePath = new File("./data");

    // Solution adapted from https://stackoverflow.com/questions/7357969/how-to-use-java-code-to-open-windows-file-explorer-and-highlight-the-specified-f/39445156
    /**
     * Opens the stored data file in the user's computer.
     *
     * @throws IOException  If there is an error reading the file.
     */
    public static void openBackupFolder() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(filePath);
    }

    /**
     * Executes a command using task list and outputs the result (GUI).
     * (Not in use)
     *
     * @param items The task list that contains a list of tasks.
     * @param ui To tell the user that it is executed successfully.
     * @return String to be outputted to the user.
     */
    @Override
    public String executeGui(TaskList items, Ui ui) {
        return null;
    }

    /**
     * Executes a command that overwrites existing storage with the updated task list.
     *
     * @param items The task list that contains a list of tasks.
     * @param ui To tell the user that the program is exiting.
     * @param storage The storage to be overwritten.
     * @throws IOException  If there is an error reading the file.
     */
    @Override
    public void executeStorage(TaskList items, Ui ui, Storage storage) throws IOException {
    }

    /**
     * Executes a command that overwrites existing storage with the all task list.
     *
     * @param items Task list that contains a list of tasks.
     * @param ui To tell user that it is executed successfully.
     * @param storage Storage that stores and handles taskLists.
     * @param budgetStorage Storage that stores and handles budgets.
     * @param budgetList Budget list that contains the budget information.
     * @param contactStorage Storage that stores and handles contact list.
     * @param contactList Contact list that contains a list of Contacts.
     * @param priorityStorage Storage that stores and handles priority list.
     * @param priorityList Priority list that contains a list of Priorities.
     * @throws IOException If there is an error reading the file.
     */
    public void executeStorage(TaskList items, Ui ui, Storage storage,
                               BudgetStorage budgetStorage, BudgetList budgetList,
                               ContactStorage contactStorage, ContactList contactList,
                               PriorityStorage priorityStorage, PriorityList priorityList) throws IOException {
        priorityStorage.write(priorityList);
        budgetStorage.write(budgetList);
        contactStorage.write(contactList);
        storage.write(items);
        openBackupFolder();
        ui.showBackupMessage();
    }
}
//@@author