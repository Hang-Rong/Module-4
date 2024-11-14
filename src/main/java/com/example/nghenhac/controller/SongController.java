package com.example.nghenhac.controller;

import com.example.nghenhac.model.Song;
import com.example.nghenhac.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    private static final String UPLOAD_DIRECTORY = "I:\\Code Gym\\Module 4\\Bai tap\\SS4\\NgheNhac\\src\\main\\webapp\\WEB-INF\\songs\\";

    @GetMapping("/songs/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("song", new Song());
        return "upload";
    }

    @PostMapping("/songs/upload")
    public String uploadSong(@ModelAttribute("song") Song song, Model model) {
        MultipartFile file = song.getFilePath();

        String fileName = file.getOriginalFilename();
        if (fileName != null && !fileName.matches(".*\\.(mp3|wav|ogg|m4p)$")) {
            model.addAttribute("error", "Chỉ chấp nhận các file có đuôi .mp3, .wav, .ogg, .m4p");
            return "upload";
        }

        try {
            file.transferTo(new File(UPLOAD_DIRECTORY + fileName));
            song.setFilePath(null);
            songService.save(song);
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi lưu file: " + e.getMessage());
            return "upload";
        }

        return "redirect:/songs/list";
    }

    @GetMapping("/songs/list")
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
}