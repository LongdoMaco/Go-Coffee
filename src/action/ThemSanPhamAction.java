package action;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.LoaiSanPham;
import model.bean.SanPham;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.SanPhamForm;

public class ThemSanPhamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		SanPhamBO sanPhamBO = new SanPhamBO();
		System.out.println("sadasdasdwsd");
		if(!"Submit".equals(sanPhamForm.getSubmit())){
			System.out.println("else");
			ArrayList<LoaiSanPham> listMaLoaiSP = sanPhamBO.getListMaLoai();
			sanPhamForm.setListMaLoai(listMaLoaiSP);
			System.out.println(sanPhamForm.getListMaLoai());
			return mapping.findForward("tsp");
		}else{
			
			String fileName = sanPhamForm.getImage().getFileName();
			SanPham sp = new SanPham();
			OutputStream bos = null;
			InputStream stream = null;
			String directory = request.getRealPath("/") + "images/imagesp";
			try {
				if (!"".equals(fileName)) {
					String ext = fileName.substring(fileName.lastIndexOf("."));
					if (".jpg".equals(ext) || ".png".equals(ext)) {
						SimpleDateFormat sim = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
						Date now = new Date();
						String thoigian = sim.format(now);
						
						sp.setHinhAnh(thoigian + ext);
						System.out.println(thoigian);
						// ----------------------------------------------
						stream = sanPhamForm.getImage().getInputStream();
						String path = directory +"/"+ thoigian + ext ;
						bos = new FileOutputStream(path);
						int bytesRead = 0;
						byte[] buffer = new byte[8192];
						while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}
						bos.close();
						stream.close();
						sp.setTenSanPham(sanPhamForm.getTenSanPham());
						sp.setGiaBan(sanPhamForm.getGiaBan());
						sp.setMaLoaiSP(sanPhamForm.getMaLoaiSP());
						SanPhamBO spbo = new SanPhamBO();
						spbo.insertSanPham(sp);
						ActionErrors er = new ActionErrors();
						er.add("loiaddsp",new ActionMessage("error.addsptc"));
						saveErrors(request, er);
						return mapping.findForward("tsp");
					}
				} 
				ActionErrors er = new ActionErrors();
				er.add("loiaddsp",new ActionMessage("error.khongadddcsp"));
				saveErrors(request, er);
				return mapping.findForward("tsp");
			} catch (Exception e) {
				e.printStackTrace();
				bos.close();
				stream.close();
				ActionErrors er = new ActionErrors();
				er.add("loiaddsp",new ActionMessage("error.khongadddcsp"));
				saveErrors(request, er);
				return mapping.findForward("tsp");
			}
			
		}
	}
}
