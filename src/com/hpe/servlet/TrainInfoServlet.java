package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.po.TrainInfo;
import com.hpe.service.TrainService;
import com.hpe.service.TrainServiceImpl;

/**
 * Servlet implementation class TrainListServlet
 */
@WebServlet("/trainListServlet")
public class TrainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TrainService trainService = new TrainServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		if (method.endsWith("findtrain")) {
			String train_no = request.getParameter("trainInfo");
			TrainInfo trainInfo = new TrainInfo();
			trainInfo = trainService.findTrain(train_no);
			request.setAttribute("findtrain", trainInfo);

			request.getRequestDispatcher("/detail.jsp").forward(request, response);
		} else if (method.endsWith("getalltrain")) {

			// 用户信息展示
			// 当前用户的信息
			List<TrainInfo> list = trainService.getAllTrain();
			request.setAttribute("trainList", list);
			// 需要把page对象通过request域，传递数据。
			// 转发
			request.getRequestDispatcher("/trainList.jsp").forward(request, response);
		}else if(method.endsWith("deltrain")){
			String train_no = request.getParameter("del");
			String[] del = train_no.split(",");
			//删除车次信息
			boolean delTrain = false;
			try {
				delTrain = trainService.delTrainInfo(del);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//跳转到/trainsInfoServlet
			PrintWriter out = response.getWriter();
			if (delTrain == true) {
				//window.location.href=""表示alert窗口确认后的跳转地址
				out.print("<script language=\"javascript\">alert(\"删除成功\");"
						+ "window.location.href=\"" + request.getContextPath() + "/trainListServlet?method=getalltrain\";"
						+ "</script>");
			} else {
				out.print("<script language=\"javascript\">alert(\"删除失败\");"
						+ "window.location.href=\"" + request.getContextPath() + "/trainListServlet?method=getalltrain\";"
						+ "</script>");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
