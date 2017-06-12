package todo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by RENT on 2017-06-09.
 */
public interface TodoChainElement {
    boolean isMyResponsibility(String path);

    String action(HttpServletRequest req, HttpServletResponse resp);
}
