package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteMutterLogic;

/**
 * Servlet implementation class DeleteMutter
 */
@WebServlet("/DeleteMutter")
public class DeleteMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターからIDを取得
		String id = request.getParameter("id");

		//DeleteMutterLogicインスタンスの生成
		DeleteMutterLogic delMutterLogic = new DeleteMutterLogic();

		//DeleteMutterLogicの処理を実行
		delMutterLogic.execute(id);

		// リダイレクト
		response.sendRedirect("/docoTsubu3/Main");

	}

}
