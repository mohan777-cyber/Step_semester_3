package week7_assignment;

import java.util.Arrays;

class Playlist {
    private String[] songs;       // private array to store songs
    private int count;            // how many songs have been added

    // Constructor with maximum size
    public Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    // Add a song
    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        } else {
            System.out.println("Playlist is full. Cannot add more songs.");
        }
    }

    // Return a safe copy of the songs added so far
    public String[] getSongs() {
        return Arrays.copyOf(songs, count); // copy only the filled portion
    }

    // Read-only count of songs
    public int getSongCount() {
        return count;
    }
}

public class PlaylistDemo {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        // Get a copy of the songs
        String[] copy = p.getSongs();

        // Modify the copy
        copy[0] = "Hacked";

        // Print original playlist contents
        System.out.println("Original Playlist:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        System.out.println("Song count: " + p.getSongCount());
    }
}
