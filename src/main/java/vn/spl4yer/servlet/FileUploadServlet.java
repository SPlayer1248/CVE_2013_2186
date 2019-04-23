package vn.spl4yer.servlet;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "E:\\viettel\\Java_Deserialize\\CVE_2013_2186\\src\\main\\webapp";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String uploadResult = uploadFile(request);
        request.setAttribute("message", uploadResult);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }


    public String uploadFile(HttpServletRequest request) throws IOException {
        // Directory where files will be saved
        File uploadDir = new File(UPLOAD_DIRECTORY);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        FileItemFactory fileItemFactory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);

        // Parse the request
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            return "Upload failed due to " + e.toString();
        }

        for (Iterator it = items.iterator(); it.hasNext(); ) {
            DiskFileItem diskFileItem = (DiskFileItem) it.next();
            if (diskFileItem.isFormField()) {
                continue;
            }
            byte[] fileBytes = diskFileItem.get();
            File file = new File(uploadDir, diskFileItem.getName());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(fileBytes);
            fileOutputStream.flush();
        }

        return "Upload success";
    }

    public User getData() {
        User user = new User();

        return user;
    }
}
