package vn.spl4yer.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class HandleFileUpload extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "E:\\viettel\\Java_Deserialize\\CVE_2013_2186\\src\\main\\webapp\\uploads";
    private String username;
    private String fullname;
    private int age;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                File uploadDir = new File(UPLOAD_DIRECTORY);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                List<DiskFileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (DiskFileItem item : multiparts) {
                    if (!item.isFormField()) {

                        File file = new File(uploadDir + "\\" + item.getName());
                        item.write(file);
                        getData(file);
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
                request.setAttribute("username", this.username);
                request.setAttribute("age", this.age);
                request.setAttribute("fullname", this.fullname);
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    public void getData(File file) {
        User user = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
            this.username = user.getUsername();
            this.age = user.getAge();
            this.fullname = user.getFullname();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Khong tim thay lop Employee");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");

    }
}
