package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.LoaiBaiViet;
import model.bo.BaiVietBO;
import model.bo.LoaiBaiVietBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.BaiVietForm;
import form.LoginForm;

public class ThemBaiViet extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaiVietForm bvForm = (BaiVietForm) form;
		String submit = bvForm.getSubmit();
		System.out.println("Value button Submit: "+submit);
		if ("".equals(submit)){
			
			LoaiBaiVietBO loaiBaiVietBO = new LoaiBaiVietBO();
			ArrayList<LoaiBaiViet> listLoaiBaiViet = loaiBaiVietBO.getListLoaiBaiViet();
			
			bvForm.setListLoaiBaiViet(listLoaiBaiViet);
			
			return mapping.findForward("goThemBaiViet");
		}
		
		if ("Submit".equals(submit)){
			System.out.println("Bat dau them bai viet vao DB....");
			
			String tieuDeBaiViet = bvForm.getTieuDeBaiViet();
			String maLoaiBaiViet = bvForm.getMaLoaiBaiViet().trim();
			
			HttpSession httpSession = request.getSession();
			LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
			
			String userName = loginForm.getUserName();
			String noiDungBaiViet = bvForm.getNoiDungBaiViet();
			
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String thoiGian = sim.format(date);
			
			SimpleDateFormat sim2 = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
			String thoiGian2 = sim2.format(date);
			
			
			System.out.println("Thoi gian:"+ thoiGian);
			
			String fileName = bvForm.getImage().getFileName();
			String filenameNew="";
			OutputStream bos = null;
			InputStream stream = null;
			System.out.println("duong dan project"
					+ System.getProperty("user.dir"));
			String directory = request.getRealPath("/") + "images/baiviet";
			File file = new File(directory);
			if(!file.exists()){
				file.mkdir();
			}
			try {
				if (!"".equals(fileName)) {
					String ext = fileName.substring(fileName.lastIndexOf("."));
					if (".jpg".equals(ext) || ".png".equals(ext)) {

						filenameNew = userName+"_"+thoiGian2;

						// ----------------------------------------------
						stream = bvForm.getImage().getInputStream();
						String path = directory + "\\" + filenameNew + ext;
						bos = new FileOutputStream(path );
						System.out.println(directory + "\\" + filenameNew);
						int bytesRead = 0;
						byte[] buffer = new byte[8192];
						while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}
						bos.close();
						stream.close();
						
						filenameNew = "images\\baiviet\\"+filenameNew+ext;
						System.out.println("Image path to DB: "+filenameNew);
						//System.out.println("da toi day");
					}
					//System.out.println("da toi day 2");
				} else {
					filenameNew = "images\\baiviet\\default_bv.jpg";
				} 

			} catch (Exception e) {
				e.printStackTrace();
				bos.close();
				stream.close();
				System.out.println("exxxxx");
			}
			
			BaiVietBO baiVietBO = new BaiVietBO();
			if (baiVietBO.themBaiViet(tieuDeBaiViet, maLoaiBaiViet, userName, noiDungBaiViet, thoiGian, filenameNew)){
				return mapping.findForward("themBaiVietThanhCong");
			}else{ 
				bvForm.setSubmit("");
				//return mapping.findForward("themBaiVietThatBai");
			}
		}
		return super.execute(mapping, form, request, response);
	}
}
