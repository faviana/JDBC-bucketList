package com.ironyard.servlet;

import com.ironyard.data.Bucket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by favianalopez on 9/23/16.
 */
public class DeleteBucketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deleteThisId = req.getParameter("delete");
        long deleteId = Long.parseLong(deleteThisId);

        List<Bucket> theBucketList= (List<Bucket>) req.getSession().getAttribute("theBucketList");

        for (Bucket b:theBucketList){
            if (b.getId()== deleteId){
                theBucketList.remove(b);
                break;
            }
        }

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);

    }
}
