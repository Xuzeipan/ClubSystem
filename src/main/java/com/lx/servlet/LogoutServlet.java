package com.lx.servlet;

import com.alibaba.fastjson.JSON;
import com.lx.dto.Result;
import com.lx.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("User");
        req.getSession().removeAttribute("adminUser");
        Result result = new Result(0,"退出成功",null);
        JsonUtil.ReturnJson(resp,result);
    }
}
