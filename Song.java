/**
 * A class that represents a song in a playlist. Each song has
 * a name, an artist, an album, and a length.
 *
 * @author
 * Nicole Niemiec
 * #112039349
 * nicole.niemiec@stonybrook.edu
 * CSE 214 R08 FELIX
 * SEPTEMBER 24TH, HW #2
 *
 * @version 1
 */

public class Song {
    private String name;
    private String artist;
    private String album;
    private int length;

    /**
     * Creates an instance of a Song object with parameters.
     * @param name
     *      The title of the song.
     * @param artist
     *      The artist of the song.
     * @param album
     *      The album in which the song belongs to.
     * @param length
     *      The length of the audio clip.
     */
    public Song(String name, String artist, String album, int length) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }

    /**
     * Creates an instance of a Song object without parameters.
     */
    public Song(){
        name = null;
        artist = null;
        album = null;
        length = 0;
    }

    /**
     * An accessor method to return the title of the song.
     * @return
     *      A String of the song's title.
     */
    public String getName() {
        return name;
    }

    /**
     * A mutator method that sets the name of the song.
     * @param name
     *      The title of the song to be changed.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * An accessor method that returns a String of the artist's name.
     * @return
     *      A String of the artist's name.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * A mutator method that
     * @param artist
     *      The name of the artist to be set.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * An accessor method that returns the song's album name.
     * @return
     *      A String of the song's album name.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * A mutator method that sets the song's album name.
     * @param album
     *      The name of the album to be set.
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * An accessor method that returns the length of the song as an int.
     * @return
     *      Returns the length of the song as an int.
     */
    public int getLength() {
        return length;
    }

    /**
     * A mutator method that sets the length of the song.
     * @param length
     *      The length of the song to set.
     */
    public void setLength(int length) {
        this.length = length;
    }

    
}
