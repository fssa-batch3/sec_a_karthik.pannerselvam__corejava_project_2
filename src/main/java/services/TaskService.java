package services;

import java.util.List;

import dao.TaskDao;
import dao.exception.DAOException;
import model.Task;
import services.exception.ServiceException;
import validation.TaskValidation;
import validation.exception.InvalidTaskException;

/**
 * The TaskService class provides services for managing tasks, including creating, updating, and retrieving tasks.
 * It handles business logic related to tasks and interacts with the TaskDao and TaskValidation classes for data access
 * and validation.
 */
public class TaskService {

    /**
     * Creates a new task.
     *
     * @param task The task to be created.
     * @return True if the task is successfully created, false otherwise.
     * @throws ServiceException If there is an issue with creating the task or validating its data.
     */
    public boolean newTask(Task task) throws ServiceException {
        TaskDao taskdao = new TaskDao();
        TaskValidation taskvalidation = new TaskValidation();
        try {
            taskvalidation.taskName(task.getTaskName());
            if (taskdao.createTask(task)) {
                return true;
            } else {
                return false;
            }
        } catch (InvalidTaskException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Updates an existing task.
     *
     * @param task The task to be updated.
     * @return True if the task is successfully updated, false otherwise.
     * @throws ServiceException If there is an issue with updating the task or validating its data.
     */
    public boolean updateTask(Task task) throws ServiceException {
        TaskDao taskdao = new TaskDao();
        TaskValidation taskvalidation = new TaskValidation();

        try {
            // Validate the task
            taskvalidation.validateNewTask(task);
            // Update the task
          return taskdao.updateTask(task);
        } catch (InvalidTaskException | DAOException e) {
            throw new ServiceException(e);
        }
    }

//    public static void main(String[] args) {
//		TaskService taskService = new TaskService();
//		Task task = new Task();
//		task.setTaskName("finish the project");
//		task.setTaskDesc("heloo sdfsndjubn");
//		task.setTaskStatus("PENDING");
//		task.setId(2);
//		try {
//		boolean u =	taskService.updateTask(task);
//			System.out.println(u);
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
    /**
     * Retrieves a list of all tasks associated with a user.
     *
     * @param user_email The email of the user for whom tasks are to be retrieved.
     * @return A list of tasks associated with the specified user.
     * @throws ServiceException If there is an issue with retrieving tasks from the database.
     */
    public List<Task> getAllTasks(String user_email) throws ServiceException {
        List<Task> tasksFromDB;
        try {
            tasksFromDB = TaskDao.getAllTasks(user_email);
            for (Task task : tasksFromDB) {
                System.out.println(task.toString());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return tasksFromDB;
    }
}
