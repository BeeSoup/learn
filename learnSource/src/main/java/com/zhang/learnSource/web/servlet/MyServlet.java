/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/6  zhang  新增
 * ========    =======  ============================================
 */

package com.zhang.learnSource.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MyServlet
 *
 * @author zhang
 * @Date 2020/08/06
 */
// 映射地址
@WebServlet(
        urlPatterns = "/my/servlet"
)
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("myServlet");
    }
}
