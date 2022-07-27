package model;

import dao.MutterDAO;

public class DeleteMutterLogic {

	public void execute(String strId) {
		//idをintに変換
		int id = Integer.parseInt(strId);
		MutterDAO dao = new MutterDAO();
		dao.delete(id);
	}

}
