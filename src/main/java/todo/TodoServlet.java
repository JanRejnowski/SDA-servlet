package todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RENT on 2017-06-08.
 */
public class TodoServlet extends HttpServlet {

   private TodoDao todoDao;
   private TodoView todoView;
   private TodoChain todoChain;
    @Override
    public void init() throws ServletException {
//        todoDao = new TodoDaoMock();
        todoDao = new TodoDaoFile(getServletContext(), "/todo/data");
        todoView = new TodoViewHtml();
        todoChain = new TodoChain(todoView, todoDao);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
//        List<TodoModel> allTodos = todoDao.getAllTodos();
//        String todosAsHtml = todosView.show(allTodos);
//        writer.println(todosAsHtml);
//        writer.println("<ul>");
//        for(TodoModel model : allTodos) {
//            writer.println("<li>");
//            writer.println("<h3>" + model.getDate().toString() + "</h3>");
//            writer.println("<h1>" + model.getName() + "</h1>");
//            writer.println("<p>" + model.getDescription() + "</p>");
//            writer.println("<p>");
//            for (int i = 0; i < model.getPriority(); i++) {
//                writer.println("X");
//            }
//            writer.println("</p>");
//            writer.println("</li>");
//        }
//        writer.println("</ul>");
        writer.println(todoChain.invoke(req,resp));
    }


}
