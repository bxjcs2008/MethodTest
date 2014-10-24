package View;

import java.io.File;

public class CopyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CopyFile cf = new CopyFile();
		cf.moveFile("/E:/H5/workspace/webpage/page/404.html"
				,"/E:/H5/workspace/webpage/page_backup_20141020/404.html");
	}

	private void moveFile(String fromPath, String toPath) {
		if(fromPath==null||toPath==null){
			return;
		}
		File oldFile = new File(fromPath);
		File newFile = new File(toPath);
		File newPath = new File(newFile.getParent());
		if(oldFile.exists()&&oldFile.isFile()){
			if (!newPath.exists()) {
				new File(newFile.getParent()).mkdirs();
			}
			if(newFile.exists()){
				newFile.delete();
			}
			oldFile.renameTo(newFile);
		}
	}
}
