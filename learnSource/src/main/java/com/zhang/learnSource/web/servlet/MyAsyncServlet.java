package com.zhang.learnSource.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 说明：
 *
 * @author zhangyu
 * @since 2021/1/13
 */
@WebServlet(
        asyncSupported = true,
        urlPatterns = {
                "/myAsync/servlet"
        }
)
public class MyAsyncServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 开启异步
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start( () ->{
            try {
                resp.getWriter().println(" is my asyncServlet");
            } catch (IOException e) {
                e.printStackTrace();
            }
            asyncContext.complete();
        });

    }
}
