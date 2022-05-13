package test.com.model;

import java.util.List;

public interface TravelDAO {
	public int insert(TravelVO vo);

	public int update(TravelVO vo);

	public int delete(TravelVO vo);

	public int myDelete(TravelVO vo);

	public TravelVO selectOne(TravelVO vo);

	public List<TravelVO> selectAll();

	public List<TravelVO> searchLIst(String searchWord);

	public int myInsert(TravelVO vo);

	public TravelVO jLogin(TravelVO vo);

	public List<TravelVO> mySelectAll(String sess_id);

	public List<TravelVO> mySelectAll_admin();
	
}
