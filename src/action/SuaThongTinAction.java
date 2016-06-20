package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.KhachHangForm;
import form.LoginForm;

public class SuaThongTinAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		KhachHangForm khachHangForm = (KhachHangForm) form;
		KhachHangBO khbo = new KhachHangBO();

		HttpSession session = request.getSession();
		LoginForm loginForm = new LoginForm();
		loginForm = (LoginForm)session.getAttribute("loginForm");
		String user;
		int quyen = 0;
		if (loginForm != null) {
			quyen = loginForm.getQuyenHan();
			user = loginForm.getUserName();
			System.out.println("quyen = "+quyen + " user:" +loginForm.getUserName());
		}else{
			return mapping.findForward("home");
		}
		if ("submit".equals(khachHangForm.getSubmit())) {
			KhachHang khachHang = new KhachHang();
			khachHang.setUserName(khachHangForm.getUserName());
			khachHang.setTenKhachHang(khachHangForm.getTenKhachHang());
			khachHang.setsDT(khachHangForm.getsDT());
			khachHang.setDiaChi(khachHangForm.getDiaChi());
			khachHang.setGioiTinh(khachHangForm.getGioiTinh());
			khachHang.setEmail(khachHangForm.getEmail());
			khachHang.setNgaySinh(khachHangForm.getNgaySinh());
			khachHang.setBlock(khachHangForm.getBlock());
			khachHang.setQuyenhan(khachHangForm.getQuyenhan());
			if(quyen == 1 && !user.equals(khachHangForm.getUserName())){
				khachHang.setMucDoSua(1);
			}else if(quyen == 2 && user.equals(khachHangForm.getUserName()) || quyen == 1 && user.equals(khachHangForm.getUserName())){
				khachHang.setMucDoSua(2);
			}else if(quyen == 3 && user.equals(khachHangForm.getUserName())){
				khachHang.setMucDoSua(3);
			}else{
				return mapping.findForward("home");
			}
			String fileName = khachHangForm.getImage().getFileName();

			OutputStream bos = null;
			InputStream stream = null;
			String directory = request.getRealPath("/") + "images/avatar";
			try {
				if (!"".equals(fileName)) {
					String ext = fileName.substring(fileName.lastIndexOf("."));
					if (".jpg".equals(ext.toLowerCase()) || ".png".equals(ext.toLowerCase())) {

						khachHang.setHinhAnh(khachHangForm.getUserName() + ext);

						// ----------------------------------------------
						stream = khachHangForm.getImage().getInputStream();
						String path = directory + "/"
								+ khachHangForm.getUserName();
						bos = new FileOutputStream(path + ext);
						System.out.println(directory + "/" + fileName);
						int bytesRead = 0;
						byte[] buffer = new byte[8192];
						while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}

						bos.close();
						stream.close();

					} else {
						khachHang.setHinhAnh(khachHangForm.getHinhAnh());
					}

				} else {
					khachHang.setHinhAnh(khachHangForm.getHinhAnh());
				}

			} catch (Exception e) {
				e.printStackTrace();
				bos.close();
				stream.close();
			}

			// ----------------------------------------------

			Boolean check = khbo.updateTT(khachHang);
			if (check == true) {
				return mapping.findForward("home");
			} else {
				ActionErrors er = new ActionErrors();
				er.add("updateError", new ActionMessage("error.updateTT"));
				saveErrors(request, er);
				return mapping.findForward("home");
			}
		} else {
			String Username = khachHangForm.getUserName();
			System.out.println(Username);
			KhachHang kh = new KhachHang();
			kh = khbo.getKH(Username);

			khachHangForm.setUserName(kh.getUserName());
			khachHangForm.setTenKhachHang(kh.getTenKhachHang());
			khachHangForm.setsDT(kh.getsDT());
			khachHangForm.setDiaChi(kh.getDiaChi());
			khachHangForm.setGioiTinh(kh.getGioiTinh());
			khachHangForm.setEmail(kh.getEmail());
			khachHangForm.setNgaySinh(kh.getNgaySinh());
			khachHangForm.setQuyenhan(kh.getQuyenhan());
			khachHangForm.setBlock(kh.getBlock());
			khachHangForm.setHinhAnh(kh.getHinhAnh());
			if(quyen == 1 && !user.equals(khachHangForm.getUserName())){
				khachHangForm.setMucDoSua(1);
			}else if(quyen == 2 && user.equals(khachHangForm.getUserName()) || quyen == 1 && user.equals(khachHangForm.getUserName())){
				khachHangForm.setMucDoSua(2);
			}else if(quyen == 3 && user.equals(khachHangForm.getUserName())){
				khachHangForm.setMucDoSua(3);
			}else{
				return mapping.findForward("home");
			}
			return mapping.findForward("suatt");
		}

	}
}
