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
 * Created by favianalopez on 9/22/16.
 */
public class CreateBucketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String where = req.getParameter("where");
        String when = req.getParameter("when");
        String howMuch = req.getParameter("howMuch");
        String id = req.getParameter("id");

        HttpSession session = req.getSession();
        List<Bucket> bucketList = (List<Bucket>) session.getAttribute("theBucketList");

        if (bucketList == null) {
            bucketList = new ArrayList<Bucket>();
        }

        //acquire id info from session
        Bucket foundBucket = null;

        //if found display info
        for (Bucket bucket:bucketList){
            if(bucket.getId()== Long.parseLong(id)){
                foundBucket=bucket;
                break;
            }
        }

        //send info back
        if (foundBucket==null) {


            //if not found create a new one
            Bucket myBucket = new Bucket(where, when, howMuch, Long.parseLong(id));
            bucketList.add(myBucket);

        } else{
            //if found update info

            foundBucket.setWhere(where);
            foundBucket.setWhen(when);
            foundBucket.setHowMuch(howMuch);

        }

        session.setAttribute("theBucketList", bucketList);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}





