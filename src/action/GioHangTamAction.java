package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ChiTietDonHang;
import model.bean.GioHang;
import model.bean.GioHangTam;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.GioHangTamForm;

public class GioHangTamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GioHangTamForm fff= (GioHangTamForm) form;
		HttpSession httpSession = request.getSession();
		SanPhamBO sanphamBO = new SanPhamBO();
		GioHang GioHang = new GioHang();
		ArrayList<GioHangTam> listGH;
		//Lay session tu chi tiet
		ArrayList orders = new ArrayList();
		int masanpham=fff.getMaSanPham();
		//Mua ngay

		if(masanpham!=0){
			ArrayList<GioHang> orders1;
			int soluong =1;
			HttpSession session = request.getSession();
			if (session.getAttribute("Orders") != null) {
	            orders1 = (ArrayList<GioHang>) (session.getAttribute("Orders"));
	        }
			else
			{
				orders1 = new ArrayList<GioHang>();
			}
			boolean check=true;;
			for(int i1 = 0 ; i1< orders1.size();i1++)
			{
				if(masanpham == orders1.get(i1).getMasanpham())
				{
					orders1.get(i1).setSoluong(orders1.get(i1).getSoluong()+soluong);
					check = false;
					break;
				}
			}
			if(check)
			{
				GioHang.setMasanpham(masanpham);
				GioHang.setSoluong(soluong);
				orders1.add(GioHang);	
			}
	        session.setAttribute("Orders", orders1);
	       
		}
		//GioHangTam giohangtam= new GioHangTam();
		
		if (httpSession.getAttribute("Orders") != null) {
            orders = (ArrayList) (httpSession.getAttribute("Orders"));
        }
		int i=0;
		String chuoi ="";
        int count = orders.size()-1;
        int MaSanPham[]= new int[100];
        int SoLuong[]= new int[100];
        int tong=0;
        //System.out.println("Sdasdasd" + count);
        while (count >= 0) {
        	GioHang = (model.bean.GioHang) orders.get(count);
        	MaSanPham[i]=GioHang.getMasanpham();
        	SoLuong[i]=GioHang.getSoluong();
        	System.out.println("Ma don hang cua dai ca hieu"+ GioHang.getMasanpham());
        	i++;
        	count--;
        }
        listGH=sanphamBO.getThongTinGioHang(MaSanPham,SoLuong,i);
		fff.setListGH(listGH);
		//tinh tong tien
		GioHangTam ght= sanphamBO.layTongTienGioHang(MaSanPham,SoLuong,i);
		fff.setTongthanhtien(ght.getTongthanhtien());
		
		//System.out.println("MA san pham"+ masanpham);
		return mapping.findForward("danhsach");
	}
}
