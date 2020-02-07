/**
 * A driver class that runs the program relying on user input and
 * the various Song, SongNode, and SongLinkedList classes. Users can add songs,
 * remove songs, play songs, and shuffle their playlist
 * from this class.
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

import java.util.Scanner;

public class Player {

    private static Scanner input = new Scanner(System.in);
    private static SongLinkedList playlist = new SongLinkedList();
    //private static SongLinkedList tempPlaylist = new SongLinkedList();

    /**
     * Where Song, SongNode, and SongLinkedList are all implemented.
     * @param args
     *      The program being run.
     */
    public static void main(String[] args){

        main_menu();

    }

    /**
     * Method where user can control which action to perform on their
     * playlist. A "menu" of different methods.
     */
    public static void main_menu(){
        String command;

        do {

            System.out.println("Main Menu");
            System.out.println("(A) \t Add Song to Playlist");
            System.out.println("(F) \t Go to Next Song");
            System.out.println("(B) \t Go to Previous Song");
            System.out.println("(R) \t Remove Song from Playlist");
            System.out.println("(L) \t Play Song");
            System.out.println("(C) \t Clear the Playlist");
            System.out.println("(S) \t Shuffle Playlist");
            System.out.println("(Z) \t Random Song");
            System.out.println("(P) \t Print Playlist");
            System.out.println("(T) \t Get Size");
            System.out.println("(Q) \t Quit");


            //Scanner input = new Scanner(System.in);

            System.out.println("Enter an option: ");
            command = input.nextLine().toUpperCase();

            switch (command){
                case "A" :
                    main_addSong();
                    break;
                case "F":
                    main_nextSong();
                    break;
                case "B" :
                    main_previousSong();
                    break;
                case "R" :
                    main_removeSong();
                    break;
                case "L":
                    main_playSong();
                    break;
                case "C" :
                    main_clearPlaylist();
                    break;
                case "S" :
                    main_shufflePlaylist();
                    break;
                case "Z" :
                    main_randomSong();
                    break;
                case "P" :
                    main_printPlaylist();
                    break;
                case "T" :
                    main_getSize();
                    break;
                case "Q" :
                    System.out.println("Program terminated.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    //main_menu();
            }

        }
        while(!command.equalsIgnoreCase("Q"));

        input.close();
    }

    /**
     * Calls the method to insert a song into the playlist
     * wherever the cursor is currently located.
     */
    public static void main_addSong() throws IllegalArgumentException{
        try {
            String name, artist, album;
            int length;
            System.out.println("Enter song title: ");
            name = input.nextLine();
            while (name.equals("")) {
                System.out.println("Name cannot be blank.");
                System.out.println("Enter song title: ");
                name = input.nextLine();
            }
            System.out.println("Enter artists of the song: ");
            artist = input.nextLine();
            System.out.println("Enter album: ");
            album = input.nextLine();
            System.out.println("Enter length (in seconds): ");
            length = input.nextInt();
            input.nextLine();

            Song addSong = new Song(name, artist, album, length);
            playlist.insertAfterCursor(addSong);
            System.out.println("\'" + addSong.getName() + "\' by " + addSong.getArtist() + " has been added.");
        } catch (IllegalArgumentException ex){
            System.out.println("Input was not valid.");
        }

    }

    /**
     * Calls the method to move the cursor to the
     * next SongNode.
     */
    public static void main_nextSong(){

        playlist.cursorForwards();
        //System.out.println("Cursor moved forward.");

    }

    /**
     * Calls the method to move the cursor to the
     * previous SongNode.
     */
    public static void main_previousSong(){

        playlist.cursorBackwards();
        //System.out.println("Cursor moved backward.");

    }

    /**
     * Calls the method to remove the Song at
     * the current position of the cursor.
     */
    public static void main_removeSong(){

        Song removeSong = new Song();
        removeSong = playlist.getCursor().getData();

        playlist.removeCursor();

        System.out.println("\'" + removeSong.getName() + "\' by " + removeSong.getArtist() +
                " was removed from the playlist.");

    }

    /**
     * Calls the method to play the Song
     * called by the user.
     */
    public static void main_playSong(){

        System.out.println("Enter name of song to play: ");
        String name = input.nextLine();
        playlist.play(name);

        //String name = playlist.getCursor().getData().getName();
        //playlist.play(name);

    }

    /**
     * Calls the method to delete all Songs
     * and clear the current playlist.
     */
    public static void main_clearPlaylist(){

        playlist.deleteAll();
        System.out.println("Playlist has been cleared.");

    }

    /**
     * Calls the method to shuffle the order of the current playlist.
     */
    public static void main_shufflePlaylist(){

        playlist.shuffle();

    }

    /**
     * Calls the method to play a random song
     * on the playlist.
     */
    public static void main_randomSong(){

        //playlist.random();
        String name = playlist.random().getName();
                //playlist.getCursor().getData().getName() + ".wav";
        playlist.play(name);

    }

    /**
     * Calls the method to print the playlist in
     * a tabular format.
     */
    public static void main_printPlaylist(){

        playlist.printPlayerList();

    }

    /**
     * Calls the method to retrieve the current size of the playlist.
     */
    public static void main_getSize(){

        System.out.println("Your playlist contains " + playlist.getSize() + " songs.");

    }
}
