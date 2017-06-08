package todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public class TodoDaoMock implements TodoDao {

    private List<TodoModel> todos;

    private void init() {
        todos.add(new TodoModel("Zadanie domowe", "Do zrobienia mam zadanie 1 ze strony 5", false, 2, LocalDate.now()));
        todos.add(new TodoModel("Spotkanie", "Idziemy na kregle", false, 3, LocalDate.now().minusDays(5)));
        todos.add(new TodoModel("Sprawunki", "Zakupy", false, 1, LocalDate.now()));
    }

    public TodoDaoMock() {
        todos = new ArrayList<>();
        init();
    }

    @Override
    public List<TodoModel> getAllTodos() {
        return todos;
    }

    @Override
    public void addTodo(TodoModel todoModel) {
        todos.add(todoModel);
    }
}
