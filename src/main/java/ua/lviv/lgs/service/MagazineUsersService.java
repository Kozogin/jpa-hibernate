package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface MagazineUsersService extends AbstractCRUD <MagazineUsers>{
	
	public MagazineUsers read(String id);
	public void delete(String id);

}
