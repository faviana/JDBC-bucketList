package com.ironyard.servlet;

import com.ironyard.data.Bucket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by favianalopez on 9/23/16.
 */
public class EditBucketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String when =  req.getParameter("when");
        String where = req.getParameter("where");
        String howMuch = req.getParameter("howMuch");
        String id = req.getParameter("id");

        HttpSession session = req.getSession();
        List<Bucket> bucketList = (List<Bucket>) session.getAttribute("theBucketList");

        if (bucketList == null){
            bucketList = new ArrayList<Bucket>();
        }

        Bucket foundBucket = null;

        for (Bucket b:bucketList){
            if(b.getId()== Long.parseLong(id)){
                foundBucket=b;
                break;
            }
        }
        if (foundBucket == null){
            Bucket myNewBucket = new Bucket(when,where, howMuch, Long.parseLong(id));
            bucketList.add(myNewBucket);
        }else{
            foundBucket.setWhere(where);
            foundBucket.setWhen(when);
            foundBucket.setHowMuch(howMuch);
        }

        session.setAttribute("theBucketList", bucketList);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);
    }
}
