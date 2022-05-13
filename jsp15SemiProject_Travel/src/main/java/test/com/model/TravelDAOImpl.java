package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelDAOImpl implements TravelDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public TravelDAOImpl() {
		try {
			Class.forName(TravelDB.DRIVER_NAME);
			System.out.println("driver successed..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(TravelVO vo) {
		System.out.println("TravelDAOImpl insert().." + vo);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_INSERT);
			pstmt.setString(1, vo.getAttraction());
			pstmt.setString(2, vo.getLocation());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getTdate());
			pstmt.setString(5, vo.getSave_file_name());

			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public int update(TravelVO vo) {
		System.out.println("TravelDAOImpl update().." + vo);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_UPDATE);
			pstmt.setString(1, vo.getLocation());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getTdate());
			pstmt.setString(4, vo.getSave_file_name());
			pstmt.setString(5, vo.getAttraction());

			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public int delete(TravelVO vo) {
		System.out.println("TravelDAOImpl delete().." + vo);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_DELETE);
			pstmt.setString(1, vo.getAttraction());

			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public TravelVO selectOne(TravelVO vo) {
		System.out.println("TravelDAOImpl selectOne().." + vo);
		TravelVO vo2 = new TravelVO();

		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_SELECT_ONE);
			pstmt.setString(1, vo.getAttraction());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setAttraction(rs.getString("attraction"));
				vo2.setLocation(rs.getString("location"));
				vo2.setContent(rs.getString("content"));
				vo2.setTdate(rs.getString("tdate"));
				vo2.setSave_file_name(rs.getString("save_file_name"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return vo2;
	}

	@Override
	public List<TravelVO> selectAll() {
		System.out.println("TravelDAOImpl selectAll()..");
		List<TravelVO> vos = new ArrayList<TravelVO>();
		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TravelVO vo = new TravelVO();
				vo.setAttraction(rs.getString("attraction"));
				vo.setLocation(rs.getString("location"));
				vo.setContent(rs.getString("content"));
				vo.setTdate(rs.getString("tdate"));
				vo.setSave_file_name(rs.getString("save_file_name"));

				vos.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return vos;
	}

	@Override
	public List<TravelVO> searchLIst(String searchWord) {
		System.out.println("TravelDAOImpl searchLIst()..");
		System.out.println("TravelDAOImpl searchWord: " + searchWord);
		List<TravelVO> vos = new ArrayList<TravelVO>();
		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_SEARCH_LIST);
			pstmt.setString(1, "%" + searchWord + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TravelVO vo = new TravelVO();
				vo.setAttraction(rs.getString("attraction"));
				vo.setLocation(rs.getString("location"));
				vo.setContent(rs.getString("content"));
				vo.setTdate(rs.getString("tdate"));
				vo.setSave_file_name(rs.getString("save_file_name"));

				vos.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return vos;
	}

	@Override
	public int myInsert(TravelVO vo) {
		System.out.println("TravelDAOImpl myInsert().." + vo);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_MY_INSERT);
			pstmt.setString(1, vo.getAttraction());
			pstmt.setString(2, vo.getId());
			// DB에서 date형식으로 설정시 : ORA-01861: literal does not match format string
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public List<TravelVO> mySelectAll(String sess_id) {
		System.out.println("TravelDAOImpl myselectAll()..");
		List<TravelVO> vos = new ArrayList<TravelVO>();
		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_MY_SELECT_ALL);
			pstmt.setString(1, sess_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TravelVO vo = new TravelVO();
				vo.setAttraction(rs.getString("attraction"));
				vo.setId(rs.getString("id"));
				vo.setSave_date(rs.getDate("save_date"));

				vos.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return vos;
	}

	@Override
	public TravelVO jLogin(TravelVO vo) {
		System.out.println("TravelDAOImpl().." + vo);
		TravelVO vo2 = new TravelVO();
		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");
			pstmt = conn.prepareStatement(TravelDB.SQL_JLOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs = pstmt.executeQuery();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				vo2.setId(rs.getString("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vo2;
	}

	

	@Override
	public int myDelete(TravelVO vo) {
		System.out.println("TravelDAOImpl myDelete().." + vo);
		int flag = 0;

		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_MY_DELETE);
			pstmt.setString(1, vo.getAttraction());
			pstmt.setString(2, vo.getId());

			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public List<TravelVO> mySelectAll_admin() {
		System.out.println("TravelDAOImpl myselectAll()..");
		List<TravelVO> vos = new ArrayList<TravelVO>();
		try {
			conn = DriverManager.getConnection(TravelDB.URL, TravelDB.USER_ID, TravelDB.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(TravelDB.SQL_MY_SELECT_ALL_ADMIN);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TravelVO vo = new TravelVO();
				vo.setAttraction(rs.getString("attraction"));
				vo.setId(rs.getString("id"));
				vo.setSave_date(rs.getDate("save_date"));

				vos.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					// rs는 무조건 닫고 try/catch
					rs.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					// rs는 무조건 닫고 try/catch
					pstmt.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					// rs는 무조건 닫고 try/catch
					conn.close(); // 원래 전역변수는 초기화하지 않으면 . 찍고 쓸수있음(현재는 지역변수) //null에 점찍으면 nullPointerException
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return vos;
	}


}
