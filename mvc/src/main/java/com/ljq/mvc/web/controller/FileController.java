package com.ljq.mvc.web.controller;

import com.ljq.mvc.dto.FileDetail;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author : LJQ
 * @date : 2019/6/7 15:01
 */
@RestController
@RequestMapping("/file")
public class FileController {
    String folder = "E://Java/mvc/src/main/java/com/ljq/mvc/dto";

    @PostMapping
    public FileDetail upload(MultipartFile file) throws IOException {
        System.out.println(file.getName() + "\t" + file.getOriginalFilename() + "\t" + file.getSize());


        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);
        return new FileDetail(localFile.getAbsolutePath());

    }

    @GetMapping("/{id}")

    public void download(@PathVariable String id, MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();

        ) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }

    }
}
