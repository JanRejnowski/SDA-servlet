package todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RENT on 2017-06-09.
 */
public class TodoChain {
    private List<TodoChainElement> chainElements;

    private TodoView todoView;

    private TodoDao todoDao;

    public TodoChain(TodoView todoView, TodoDao todoDao ) {
        this.chainElements = new ArrayList<>();
        this.todoView = todoView;
        this.todoDao = todoDao;
        init();
    }

    public String invoke(HttpServletRequest req, HttpServletResponse resp) {
//        Iterator<ChainsElement> iterator = chain.iterator();
//        ChainElement chainElement = null;
//        boolean flag = false;
//        while (iterator.hasNext()) {
//            ChainElement next = iterator.next();
//            if(next.isMyResponsibility(phoneNumber)) {
//                chainElement = next;
//                flag = true;
//            }
//        }
//        invoke(chainElement, phoneNumber);
        Iterator<TodoChainElement> iterator = chainElements.iterator();
        TodoChainElement finalElement = null;
        boolean flag = false;
        while (!flag & iterator.hasNext()) {
            TodoChainElement next = iterator.next();
            if(next.isMyResponsibility(req.getPathInfo())) {
                finalElement = next;
                flag = true;
            }
        }
//        String result = null;
//        if(finalElement == null) {
//            result = "<h1>Cannot find page</h1>";
//        } else {
//            result = finalElement.action(HttpServletRequest req, HttpServletResponse resp);
//        }
        return finalElement != null ? finalElement.action(req, resp) : "<h1>Cannot find page</h1>";
    }

    private void init() {
        chainElements.add(new AllTodosChainElement("/all",todoDao, todoView));
        chainElements.add(new AddTodoChainElement("/add", todoDao, todoView));
    }

}
