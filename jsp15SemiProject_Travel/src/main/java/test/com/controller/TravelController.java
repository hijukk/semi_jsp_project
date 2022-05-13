package test.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import test.com.model.TravelDAO;
import test.com.model.TravelDAOImpl;
import test.com.model.TravelVO;

//ORA-00001: unique constraint (HJ.MYTRAVEL_PK) violated ->exception 발생
/**
 * Servlet implementation class TravelController
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", "/selectAll.do", "/update.do", "/updateOK.do", "/selectOne.do",
		"/searchList.do", "/mySelectAll.do", "/myInsertOK.do", "/mySelectOne.do", "/delete.do", "/deleteOK.do",
		"/myDelete.do", "/myDeleteOK.do", "/myUpdate.do", "/myUpdateOK.do" })
public class TravelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TravelDAO dao = new TravelDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TravelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath: " + sPath);

		if (sPath.compareTo("/index.do") == 0) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (sPath.compareTo("/insert.do") == 0) {
			String sess_id = (String) request.getSession().getAttribute("session_id");
			System.out.println("session_id: " + sess_id);
			if (sess_id.equals("admin")) {
				request.getRequestDispatcher("travel/insert.jsp").forward(request, response);
			} else {
				response.getWriter().append("no access right");
			}
		} else if (sPath.compareTo("/update.do") == 0) {
			String sess_id = (String) request.getSession().getAttribute("session_id");
			System.out.println("session_id: " + sess_id);
			if (sess_id.equals("admin")) {

				String attraction = request.getParameter("attraction");
				TravelVO vo = new TravelVO();
				vo.setAttraction(attraction);

				TravelVO vo2 = dao.selectOne(vo);
				request.setAttribute("vo2", vo2);
				System.out.println("TravelController myselectOne:" + vo2);
				request.getRequestDispatcher("travel/update.jsp").forward(request, response);

			} else {
				response.getWriter().append("no access right");
			}

		} else if (sPath.compareTo("/myUpdate.do") == 0) {
			String attraction = request.getParameter("attraction");
			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);

			TravelVO vo2 = dao.selectOne(vo);
			request.setAttribute("vo2", vo2);
			System.out.println("TravelController myselectOne:" + vo2);
			request.getRequestDispatcher("travel/myUpdate.jsp").forward(request, response);
		} else if (sPath.compareTo("/selectAll.do") == 0) {

			List<TravelVO> vos = dao.selectAll();

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("travel/selectAll.jsp").forward(request, response);
		} else if (sPath.compareTo("/searchList.do") == 0) {

			String searchWord = request.getParameter("tdate");
			System.out.println("TravelController searchList: " + searchWord);

			List<TravelVO> vos = dao.searchLIst(searchWord);

			request.setAttribute("vos", vos);

			request.getRequestDispatcher("travel/selectAll.jsp").forward(request, response);
		} else if (sPath.compareTo("/selectOne.do") == 0) {
			String attraction = request.getParameter("attraction");
			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);

			TravelVO vo2 = dao.selectOne(vo);
			System.out.println("TravelController selectOne: " + vo2);
			request.setAttribute("vo2", vo2);

			request.getRequestDispatcher("travel/selectOne.jsp").forward(request, response);
		} else if (sPath.compareTo("/mySelectAll.do") == 0) {
			String sess_id = (String) request.getSession().getAttribute("session_id");
			System.out.println("TravelController mySelectAll session_id: " + sess_id);
			List<TravelVO> vos = new ArrayList<TravelVO>();

			if (sess_id.equals("admin")) {
				vos = dao.mySelectAll_admin();
			} else {
				vos = dao.mySelectAll(sess_id);
			}

			request.setAttribute("vos", vos);
			request.getRequestDispatcher("travel/mySelectAll.jsp").forward(request, response);
		} else if (sPath.compareTo("/mySelectOne.do") == 0) {
			String attraction = request.getParameter("attraction");
			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);

			TravelVO vo2 = dao.selectOne(vo);
			System.out.println("TravelController myselectOne: " + vo2);
			request.setAttribute("vo2", vo2);

			request.getRequestDispatcher("travel/mySelectOne.jsp").forward(request, response);
		} else if (sPath.compareTo("/delete.do") == 0) {
			String sess_id = (String) request.getSession().getAttribute("session_id");
			System.out.println("session_id: " + sess_id);
			if (sess_id.equals("admin")) {
				request.getRequestDispatcher("travel/delete.jsp").forward(request, response);

			} else {
				response.getWriter().append("no access right");
			}

		} else if (sPath.compareTo("/deleteOK.do") == 0) {
			String attraction = request.getParameter("attraction");

			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);

			int result = dao.delete(vo);

			if (result == 1)
				response.sendRedirect("selectAll.do");
			else
				response.sendRedirect("delete.do");
		} else if (sPath.compareTo("/myDelete.do") == 0) {
			request.getRequestDispatcher("travel/myDelete.jsp").forward(request, response);
		} else if (sPath.compareTo("/myDeleteOK.do") == 0) {
			String attraction = request.getParameter("attraction");
			String sess_id = (String) request.getSession().getAttribute("session_id");
			System.out.println("controller attraction:" + attraction);

			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);
			vo.setId(sess_id);

			int result = dao.myDelete(vo);

			if (result == 1)
				response.sendRedirect("mySelectAll.do");
			else
				response.sendRedirect("myDelete.do");
		} else if (sPath.compareTo("/myInsertOK.do") == 0) {
			String attraction = request.getParameter("attraction");
			String sess_id = (String) request.getSession().getAttribute("session_id");

			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);
			vo.setId(sess_id);

			int result = dao.myInsert(vo);
			System.out.println("result: " + result);
			if (result == 1)
				response.sendRedirect("mySelectAll.do");
			else
				response.sendRedirect("selectOne.do");

		}
	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String sPath = request.getServletPath();
		System.out.println("sPath: " + sPath);

		if (sPath.compareTo("/insertOK.do") == 0) {
			// 1.이미지 저장될 폴더 path 설정
			String dir = request.getServletContext().getRealPath("uploadimg");
			System.out.println("file...getRealPath>>" + request.getServletContext().getRealPath("uploadimg"));

			// 2. 최대 크기
			int max = 10 * 1024 * 1024;

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println("isMultipart: " + isMultipart);

			String attraction = "";
			String location = "";
			String content = "";
			String tdate = "";
			String saveFileName = "";
			String originalName = "";

			if (isMultipart == true) {

				File temporaryDir = new File(dir);
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(max);
				factory.setRepository(temporaryDir);
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = null;

				try {
					items = upload.parseRequest(request);
					System.out.println("items.size():" + items.size());

					for (FileItem fi : items) {
						String fieldName = fi.getFieldName();
						System.out.println("fieldName:" + fieldName);

						if (fieldName.equals("attraction")) {
							attraction = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("attraction : " + attraction);
						}
						if (fieldName.equals("location")) {
							location = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("location : " + location);
						}
						if (fieldName.equals("content")) {
							content = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("content : " + content);
						}
						if (fieldName.equals("tdate")) {
							String str = new String(fi.getString().getBytes("8859_1"), "utf-8");
							tdate += str + " ";
							System.out.println("tdate:" + tdate);
						}
						if (fieldName.equals("file")) {
							System.out.println("file:" + fi.getName());
							originalName = fi.getName();

							long nowTime = System.currentTimeMillis();
							String format = originalName.substring(originalName.indexOf("."));
							saveFileName = nowTime + format;
							System.out.println("saveFileName" + saveFileName);

							try {
								File uploadedFile = new File(dir, saveFileName);
								fi.write(uploadedFile);
							} catch (Exception e) {
								System.out.println(e);
							}
						} // end file if

					} // end for

				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} // end if

			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);
			vo.setLocation(location);
			vo.setContent(content);
			vo.setTdate(tdate);
			vo.setSave_file_name(saveFileName);

			int result = dao.insert(vo);
			System.out.println("result: " + result);
			if (result == 1)
				response.sendRedirect("selectAll.do");
			else
				response.sendRedirect("insert.do");
		} else if (sPath.compareTo("/updateOK.do") == 0) {
			// 1.이미지 저장될 폴더 path 설정
			String dir = request.getServletContext().getRealPath("uploadimg");
			System.out.println("file...getRealPath>>" + request.getServletContext().getRealPath("uploadimg"));

			// 2. 최대 크기
			int max = 10 * 1024 * 1024;

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println("isMultipart: " + isMultipart);

			String attraction = "";
			String location = "";
			String content = "";
			String tdate = "";
			String saveFileName = "";
			String originalName = "";

			if (isMultipart == true) {

				File temporaryDir = new File(dir);
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(max);
				factory.setRepository(temporaryDir);
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = null;

				try {
					items = upload.parseRequest(request);
					System.out.println("items.size():" + items.size());

					for (FileItem fi : items) {
						String fieldName = fi.getFieldName();
						System.out.println("fieldName:" + fieldName);

						if (fieldName.equals("attraction")) {
							attraction = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("attraction : " + attraction);
						}
						if (fieldName.equals("location")) {
							location = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("location : " + location);
						}
						if (fieldName.equals("content")) {
							content = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("content : " + content);
						}
						if (fieldName.equals("tdate")) {
							String str = new String(fi.getString().getBytes("8859_1"), "utf-8");
							tdate += str + " ";
							System.out.println("tdate:" + tdate);
						}
						if (fieldName.equals("file")) {
							System.out.println("file:" + fi.getName());
							originalName = fi.getName();

							long nowTime = System.currentTimeMillis();
							String format = originalName.substring(originalName.indexOf("."));
							saveFileName = nowTime + format;
							System.out.println("saveFileName: " + saveFileName);

							try {
								File uploadedFile = new File(dir, saveFileName);
								fi.write(uploadedFile);
							} catch (Exception e) {
								System.out.println(e);
							}
						} // end file if

					} // end for

				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} // end if

			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);
			vo.setLocation(location);
			vo.setContent(content);
			vo.setTdate(tdate);
			vo.setSave_file_name(saveFileName);

			int result = dao.update(vo);
			System.out.println("result: " + result);
			if (result == 1)
				response.sendRedirect("selectAll.do");
			else
				response.sendRedirect("update.do?attraction=" + attraction);
		} else if (sPath.compareTo("/myUpdateOK.do") == 0) {
			// 1.이미지 저장될 폴더 path 설정
			String dir = request.getServletContext().getRealPath("uploadimg");
			System.out.println("file...getRealPath>>" + request.getServletContext().getRealPath("uploadimg"));

			// 2. 최대 크기
			int max = 10 * 1024 * 1024;

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println("isMultipart: " + isMultipart);

			String attraction = "";
			String location = "";
			String content = "";
			String tdate = "";
			String saveFileName = "";
			String originalName = "";

			if (isMultipart == true) {

				File temporaryDir = new File(dir);
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(max);
				factory.setRepository(temporaryDir);
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = null;

				try {
					items = upload.parseRequest(request);
					System.out.println("items.size():" + items.size());

					for (FileItem fi : items) {
						String fieldName = fi.getFieldName();
						System.out.println("fieldName:" + fieldName);

						if (fieldName.equals("attraction")) {
							attraction = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("attraction : " + attraction);
						}
						if (fieldName.equals("location")) {
							location = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("location : " + location);
						}
						if (fieldName.equals("content")) {
							content = new String(fi.getString().getBytes("8859_1"), "utf-8");
							System.out.println("content : " + content);
						}
						if (fieldName.equals("tdate")) {
							String str = new String(fi.getString().getBytes("8859_1"), "utf-8");
							tdate += str + " ";
							System.out.println("tdate:" + tdate);
						}
						if (fieldName.equals("file")) {
							System.out.println("file:" + fi.getName());
							originalName = fi.getName();

							long nowTime = System.currentTimeMillis();
							String format = originalName.substring(originalName.indexOf("."));
							saveFileName = nowTime + format;
							System.out.println("saveFileName: " + saveFileName);

							try {
								File uploadedFile = new File(dir, saveFileName);
								fi.write(uploadedFile);
							} catch (Exception e) {
								System.out.println(e);
							}
						} // end file if

					} // end for

				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} // end if

			TravelVO vo = new TravelVO();
			vo.setAttraction(attraction);
			vo.setLocation(location);
			vo.setContent(content);
			vo.setTdate(tdate);
			vo.setSave_file_name(saveFileName);

			int result = dao.update(vo);
			System.out.println("result: " + result);
			if (result == 1)
				response.sendRedirect("mySelectAll.do");
			else
				response.sendRedirect("myUpdate.do?attraction=" + attraction);
		}
		doGet(request, response);
	}

}
