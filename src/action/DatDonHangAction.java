package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHang;
import model.bean.GioHangTam;
import model.bo.DonHangBO;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DatDonHangForm;
import form.LoginForm;

public class DatDonHangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DatDonHangForm DatDonHangForm = (DatDonHangForm) form;
		// Lay Username va quyen
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		int quyen = loginForm.getQuyenHan();

		// System.out.println("thoi gian dat hang" + showTime);
		String tensanpham = DatDonHangForm.getGhichu();
		String submit = DatDonHangForm.getSubmit();
		String phanloai= DatDonHangForm.getPhanloai();
		if("1".equals(phanloai)){
			//System.out.println("dai ca hieu+ Phan loai"+ phanloai);
		}
		if ("Dat Hang".equals(submit)) {
			httpSession = request.getSession();
			SanPhamBO sanphamBO = new SanPhamBO();
			// GioHangTam giohangtam= new GioHangTam();
			GioHang GioHang = new GioHang();
			ArrayList<GioHangTam> listGH;
			// Lay session tu chi tiet
			ArrayList orders = new ArrayList();
			if (httpSession.getAttribute("Orders") != null) {
				orders = (ArrayList) (httpSession.getAttribute("Orders"));
			}
			int i = 0;
			String chuoi = "";
			int count = orders.size() - 1;
			int MaSanPham[] = new int[100];
			int SoLuong[] = new int[100];
			System.out.println("no trong noi ba con oi" + count);
			if (count != -1) {
				String username = loginForm.getUserName();
				// Lay thoi gian ngay dat
				// Lay gio he thong
				Date thoiGian = new Date();
				// Khai bao dinh dang ngay thang
				SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat(
						"MM/dd/yyyy HH:mm:ss");

				// parse ngay thang sang dinh dang va chuyen thanh string.
				String thoigiandat = dinhDangThoiGian
						.format(thoiGian.getTime());
				// lay dia chi giao hang
				String diachigiaohang = DatDonHangForm.getDiachigiaohang();
				// Lay Ghi chu
				String ghichu = DatDonHangForm.getGhichu();
				System.out.println("thoi giann dat" + thoigiandat);
				String matrangthai = "TT01";
				DonHangBO DonHangBO = new DonHangBO();
				// them don hang
				DonHangBO.themDonHangDCH(username, thoigiandat, username,
						diachigiaohang, ghichu, matrangthai);
				// Lay ma don hang
				int madonhang = DonHangBO
						.layMaDonHangDCH(username, thoigiandat);
				System.out.println("Ma don hang da lay ra" + madonhang);
				// Them vao chi tiet san pham

				int tong = 0;
				// System.out.println("Sdasdasd" + count);
				while (count >= 0) {
					GioHang = (model.bean.GioHang) orders.get(count);
					MaSanPham[i] = GioHang.getMasanpham();
					SoLuong[i] = GioHang.getSoluong();
					System.out.println("Ma don hang cua dai ca hieu"
							+ GioHang.getMasanpham());
					i++;
					count--;
				}

				DonHangBO.themChiTietDonHang(MaSanPham, SoLuong, madonhang, i);
				httpSession.removeAttribute("Orders");
			}

		} else if ("Xoa Gio Hang".equals(submit)) {
			httpSession.removeAttribute("Orders");
			return mapping.findForward("home");
		}
		return mapping.findForward("datdon");

	}
}
