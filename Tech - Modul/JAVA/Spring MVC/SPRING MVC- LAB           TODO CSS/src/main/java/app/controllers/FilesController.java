package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.nio.file.Files;

@Controller
public class FilesController {
    @RequestMapping("/files")
    public String listFiles(
            Model m,
            @RequestParam(value = "dir", defaultValue = "c:/")
                    String dir){
        File[] files = new File(dir).listFiles();
        m.addAttribute("files",files);

        return "files";
    }
}
