package javamarathon10kn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javamarathon10km.constant.Constant;
import javamarathon10km.dao.DBmanager;
import javamarathon10km.domain.Hotel;
import net.arnx.jsonic.JSON;


/**
 * Servlet implementation class Javamarathon10kmservelet
 */
@WebServlet("/Javamarathon10kmServlet")
public class Javamarathon10kmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得したJsonをPOJOにデコードする
		Hotel hotel=JSON.decode(request.getParameter("price"),Hotel.class);

		// DBmanagerインスタンス作成
		DBmanager dbm = new DBmanager();

		//値をJson形式にして格納				
		String jsonValue = JSON.encode(dbm.serchResult(hotel.getPrice()));

		//Javaのストリームの「Content-Type」を設定
		response.setContentType(Constant.CONTENT_TYPE); 
		//設定したJavaのストリームを取得
		PrintWriter out = response.getWriter();
		//Javaのストリームを利用しJsonの値を出力
		out.print(jsonValue);		
	}
}
