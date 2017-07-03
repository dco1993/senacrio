package service;

import java.sql.SQLException;

import entity.Admin;
import persistence.AdminDAO;

public class AdminService {
	
	AdminDAO adm = new AdminDAO();
	
	public boolean save(Admin A) {
		try {
			adm.save(A);
			return Boolean.TRUE;
		} catch (SQLException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}

}
