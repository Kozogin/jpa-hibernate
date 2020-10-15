package ua.lviv.lgs.dao;

import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface MagazineUsersDao extends AbstractCRUD <MagazineUsers>{
	
	public MagazineUsers read(String id);
	public void delete(String id);
}
