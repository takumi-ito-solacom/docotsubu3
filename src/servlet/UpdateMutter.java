package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UpdateMutterLogic;

/**
 * Servlet implementation class UpdateMutter
 */
@WebServlet("/UpdateMutter")
public class UpdateMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターからIDを取得
		String id = request.getParameter("id");

		//リクエストスコープにidを保存
		request.setAttribute("id", id);

		//編集画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/updateMutter.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターからIDとテキストを取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String text = request.getParameter("text");

		//UpdateMutterLogicインスタンスの生成
		UpdateMutterLogic updMutter = new UpdateMutterLogic();

		//updMutterを利用して処理を実行
		updMutter.execute(id, text);

		// リダイレクト
		response.sendRedirect("/docoTsubu3/Main");
	}

}
