package com.tictactoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //новая сессия, true - созадем сессию, если ее нет, false - не делаем этого
        HttpSession currentSession = req.getSession(true);

        //содано игровое поле
        Field field = new Field();
        Map<Integer, Sign> fieldData = field.getField();

        //получены значения полей
        List<Sign> data = field.getFieldData();

        //добавили в сессию параметры поля(номер поля-знаечние) и значения полей
        currentSession.setAttribute("field", field);
        currentSession.setAttribute("data", data);

        //перенаправили запрос на index.jsp через сервер
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
