package todo;

import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public class TodoViewHtml implements TodoView {

    @Override
    public String show(List<TodoModel> todos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"/hello-servlets-1.0-SNAPSHOT/todo/all\">All</a></br>");
        stringBuilder.append("<a href=\"/hello-servlets-1.0-SNAPSHOT/todo/add\">Add</a></br>");
        stringBuilder.append("<ol>\n");
//        for (TodoModel todo: todos) {
//            stringBuilder.append(show(todo));
//        }
//        stringBuilder.append("</ol>");
        todos.stream()
                .map(e -> show(e))
                .forEach(e -> stringBuilder.append(e));
        return stringBuilder.toString();
    }

    @Override
    public String show(TodoModel model) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<li>\n");
        stringBuilder.append("<h3>" + model.getDate().toString() + "</h3>\n");
        stringBuilder.append("<h1>" + model.getName() + "</h1>\n");
        stringBuilder.append("<p>" + model.getDescription() + "</p>\n");
        stringBuilder.append("<p>");
        for (int i = 0; i < model.getPriority(); i++) {
            stringBuilder.append("X");
        }
        stringBuilder.append("</p>\n");
        stringBuilder.append("</li>\n");
        return stringBuilder.toString();
    }


    @Override
    public String showAddForm() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<form method=\"get\" action=\"/hello-servlets-1.0-SNAPSHOT/todo/add\"></br>\n");
        stringBuilder.append("<input type=\"text\" name=\"name\" /></br>\n");
        stringBuilder.append("<input type=\"text\" name=\"description\" /></br>\n");
        stringBuilder.append("<input type=\"checkbox\" name=\"checked\" /></br>\n");
        stringBuilder.append("<input type=\"number\" name=\"priority\" /></br>\n");
        stringBuilder.append("<input type=\"date\" name=\"date\" /></br>\n");
        stringBuilder.append("<input type=\"submit\"/></br>\n");
        stringBuilder.append("</form></br>\n");
        return stringBuilder.toString();
    }
}

