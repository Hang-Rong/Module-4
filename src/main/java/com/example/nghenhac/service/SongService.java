package com.example.nghenhac.service;

import com.example.nghenhac.model.Song;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
    private final List<Song> songs;

    public SongService() {
        songs = new ArrayList<>();
    }


    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void update(int id, Song song) {
        int index = songs.indexOf(findById(id));
        songs.set(index, song);
    }

    @Override
    public void remove(int id) {
        songs.remove(id);
    }
}
