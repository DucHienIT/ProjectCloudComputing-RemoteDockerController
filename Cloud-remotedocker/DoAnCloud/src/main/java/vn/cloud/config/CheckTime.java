package vn.cloud.config;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.jcraft.jsch.JSchException;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.DetailModel;

public class CheckTime {
	public void checkTimeContainner(String name, String ec2ip) throws IOException {
		HomeDao hd = new HomeDao();
		try {
			List<DetailModel> list;
			list = hd.getDetail(name, ec2ip);
			Date nowTime = new Date();
			for (DetailModel detail : list) {
				Date pastTime = hd.checktime(detail.getName());
				if (pastTime != null) {
					if (TimeUnit.MILLISECONDS.toSeconds(nowTime.getTime() - pastTime.getTime()) >= 120) 
					{
						hd.stopContainer(detail.getId(), ec2ip);
					}
				}
			}

		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

}
