package action;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bean.SanPham;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;
import form.SanPhamForm;

public class updateSanPhamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		HttpSession session = request.getSession();
		LoginForm loginForm = new LoginForm();
		loginForm = (LoginForm)session.getAttribute("loginForm");
		String user;
		int quyen = 0;
		if (loginForm != null) {
			if(loginForm.getQuyenHan() != 1){
				return mapping.findForward("home");
			}
		}else{
			return mapping.findForward("home");
		}
		SanPhamBO spbo = new SanPhamBO();
		if("submit".equals(sanPhamForm.getSubmit())){
			SanPham sanPham = new SanPham();
			sanPham.setMaSanPham(sanPhamForm.getMaSanPham());
			sanPham.setTenSanPham(sanPhamForm.getTenSanPham());
			sanPham.setGiaBan(sanPhamForm.getGiaBan());
			sanPham.setMaLoaiSP(sanPhamForm.getMaLoaiSP());
			String fileName = sanPhamForm.getImage().getFileName();

			OutputStream bos = null;
			InputStream stream = null;
			String directory = request.getRealPath("/") + "images/imagesp";
			try {
				if (!"".equals(fileName)) {
					String ext = fileName.substring(fileName.lastIndexOf("."));
					if (".jpg".equals(ext.toLowerCase()) || ".png".equals(ext.toLowerCase())) {
						sanPham.setHinhAnh(sanPhamForm.getMaSanPham() + ext);
						// ----------------------------------------------
						stream = sanPhamForm.getImage().getInputStream();
						String path = directory + "/"
								+ sanPhamForm.getMaSanPham();
						bos = new FileOutputStream(path + ext);
						System.out.println(directory + "/" + fileName);
						System.out.println(path + ext);
						int bytesRead = 0;
						byte[] buffer = new byte[8192];
						while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}
						bos.close();
						stream.close();
					} else {
						sanPham.setHinhAnh(sanPhamForm.getHinhAnh());
					}
				} else {
					sanPham.setHinhAnh(sanPhamForm.getHinhAnh());
				}
				System.out.println("hinh anh"+ sanPham.getHinhAnh());
			} catch (Exception e) {
				e.printStackTrace();
				bos.close();
				stream.close();
				sanPham.setHinhAnh(sanPhamForm.getHinhAnh());
			}
			spbo.updateSP(sanPham);
			return mapping.findForward("home");
		} else{
			int maSanPham = sanPhamForm.getMaSanPham();
			System.out.println(maSanPham);
			SanPham sp  = spbo.getSP(maSanPham);
			sanPhamForm.setMaSanPham(sp.getMaSanPham());
			sanPhamForm.setTenSanPham(sp.getTenSanPham());
			sanPhamForm.setGiaBan(sp.getGiaBan());
			sanPhamForm.setMaLoaiSP(sp.getMaLoaiSP());
			sanPhamForm.setListMaLoai(sp.getListMaLoai());
			sanPhamForm.setHinhAnh(sp.getHinhAnh());
			return mapping.findForward("suasp");
		}
	}
}
	