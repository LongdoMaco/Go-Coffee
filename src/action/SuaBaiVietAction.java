package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BaiViet;
import model.bean.LoaiBaiViet;
import model.bo.BaiVietBO;
import model.bo.LoaiBaiVietBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;

public class SuaBaiVietAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BaiVietForm baiVietForm = (BaiVietForm) form;
		int maBaiViet = baiVietForm.getMaBaiViet();
		System.out.println("Id bai viet de sua: "+baiVietForm.getMaBaiViet());
		System.out.println("-----------------------------------------------");
		String submit = baiVietForm.getSubmit();
		
		if("".equals(submit)){
			LoaiBaiVietBO loaiBaiVietBO = new LoaiBaiVietBO();
			ArrayList<LoaiBaiViet> listLoaiBaiViet = loaiBaiVietBO.getListLoaiBaiViet();
			
			BaiVietBO baiVietBO = new BaiVietBO();
			BaiViet baiViet = baiVietBO.getBaiViet(maBaiViet);
			
			baiVietForm.setMaBaiViet(maBaiViet);
			baiVietForm.setTieuDeBaiViet(baiViet.getTieuDeBaiViet());
			baiVietForm.setMaLoaiBaiViet(baiViet.getMaLoaiBaiViet());
			//baiVietForm.setTenLoaiBaiViet(baiViet.getTenLoaiBaiViet());
			baiVietForm.setUserName(baiViet.getUserName());
			baiVietForm.setNoiDungBaiViet(baiViet.getNoiDungBaiViet());
			baiVietForm.setThoiGian(baiViet.getThoiGian());
			baiVietForm.setListLoaiBaiViet(listLoaiBaiViet);
			baiVietForm.setHinhAnh(baiViet.getHinhAnh());
			
			return mapping.findForward("goSuaBaiViet");
		} else {
			System.out.println("Submit sua bai viet: "+submit);
			String tieuDeBaiViet = baiVietForm.getTieuDeBaiViet();
			String maLoaiBaiViet = baiVietForm.getMaLoaiBaiViet();
			String userName = baiVietForm.getUserName();
			String noiDungBaiViet = baiVietForm.getNoiDungBaiViet();
			System.out.println("Tieu de da sua: "+tieuDeBaiViet);
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String thoiGian = sim.format(date);
			SimpleDateFormat sim2 = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
			String thoiGian2 = sim2.format(date);
			String hinhAnh = "";
			String fileName = baiVietForm.getImage().getFileName();
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
						stream = baiVietForm.getImage().getInputStream();
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
					}else{
					filenameNew =  baiVietForm.getHinhAnh();
					}
				} else {
					filenameNew = baiVietForm.getHinhAnh();
				} 
				
			} catch (Exception e) {
				e.printStackTrace();
				bos.close();
				stream.close();
				System.out.println("exxxxx");
			}
			
			BaiVietBO bo = new BaiVietBO();
			if(bo.editBaiViet(maBaiViet, tieuDeBaiViet, maLoaiBaiViet,userName, noiDungBaiViet, thoiGian, filenameNew)){
				return mapping.findForward("suathanhcong");
			}else {
				baiVietForm.setSubmit("");
				return mapping.findForward("goSuaBaiViet");
			}
		}
		
	}

}
