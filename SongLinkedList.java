/**
 * A class that implements a Doubly-Linked List. This list acts as a playlist
 * and contains SongNode references to the head, tail, and cursor. These are null
 * until the first Song is added to the list. There is also a size variable that
 * tracks the current number of songs in the playlist.
 *
 * @author
 * Nicole Niemiec
 * CSE 214 R08 FELIX
 * SEPTEMBER 24TH, HW #2
 *
 * @version 1
 */

import java.io.File;
import java.util.*;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SongLinkedList {
    private SongNode head;
    private SongNode tail;
    private SongNode cursor;
    private int size;

    /**
     * Creates an instance of the SongLinkedList with no Song objects in it.
     * <b> Postconditions: </b>
     *      The SongLinkedList has been initialized to an empty linked list.
     *      Head, tail, and cursor are set to null.
     *      Size is set to 0.
     */
    public SongLinkedList(){
        head = null;
        tail = null;
        cursor = null;
        size = 0;
    }

    /**
     * An accessor method for retrieving the first node of the linked list.
     * @return
     *      Returns the first node of the linked list.
     */
    public SongNode getHead() {
        return head;
    }

    /**
     * A mutator method for setting the first node of the linked list
     * to a different node.
     * @param head
     *      The node being set to the head.
     */
    public void setHead(SongNode head) {
        this.head = head;
    }

    /**
     * An accessor method for retrieving the last node of the linked list.
     * @return
     *      Returns the last node of the linked list.
     */
    public SongNode getTail() {
        return tail;
    }

    /**
     * A mutator method for setting the last node of the linked list
     * to a different node.
     * @param tail
     *      The node being set to the tail.
     */
    public void setTail(SongNode tail) {
        this.tail = tail;
    }

    /**
     * An accessor method for retrieving node where the cursor is
     * currently pointing.
     * @return
     *      Returns the SongNode where the cursor is currently
     *      pointing.
     */
    public SongNode getCursor() {
        return cursor;
    }

    /**
     * A mutator method that sets the cursor to point at a specified node.
     * @param cursor
     *      The node the cursor will be set to.
     */
    public void setCursor(SongNode cursor) {
        this.cursor = cursor;
    }

    /**
     * An accessor method for returning the size of the playlist.
     * @return
     *      Returns the size of the playlist as an int. Also considered
     *      to be the number of songs currently in the playlist.
     */
    public int getSize() {
        return size;
    }

    /**
     * A mutator method for setting the size of the playlist.
     * @param size
     *      The size the list is being set to.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Plays the song that matches the name parameter. The song must be in the current
     * working directory in order to play.
     * <b>Preconditions: </b>
     *      The name must match an actual song name in the playlist. There also must
     *      be a file associated with the name.
     * <b>Postconditions: </b>
     *      The song is now playing.
     * @param name
     *      The name of the song the user wants to play.
     * @throws IllegalArgumentException
     *      The method throws an IllegalArgumentException if the name
     *      doesn't match any of the songs in the directory, or the .wav
     *      file couldn't be found.
     */
    public void play(String name) throws IllegalArgumentException{

        try {

            AudioInputStream AIS = AudioSystem.getAudioInputStream(new File(name + ".wav"));

            SongNode tempCursor = cursor;
            String artist = "";

            cursor = head;

            int x = 1;

            boolean inPlaylist = false;

            while(x != size){
                if(!cursor.getData().getName().equals(name)) {
                    x++;
                    cursor = cursor.getNext();
                }
                else {
                    x = size;
                    inPlaylist = true;
                }
            }


            artist = cursor.getData().getArtist();
            int length = cursor.getData().getLength();

            cursor = tempCursor;

            //while loop to find the artist of the song and save it in another string to print out later.

            //AudioInputStream AIS = AudioSystem.getAudioInputStream(this.getClass().getResource(name));

// starting the clip

            if(inPlaylist) {
                Clip c = AudioSystem.getClip();
                c.open(AIS);
                c.start();
                System.out.println("\'" + name + "\'" + " by " + artist + " is now playing.");
                Thread.sleep(length * 1000);
                //use length * 1000 in there
                //Thread.interrupted();
                System.out.println("Stop reached.");
                c.stop();
            }
            else{
                System.out.println("Song is not in the playlist.");
            }
        }
        catch (Exception ex) {
            System.out.println("Cannot find audio.");
        }

    }

    /**
     * A method to move the cursor to point to the following SongNode.
     * <b>Preconditions: </b>
     *      The list is not empty.
     *<b> Postconditions: </b>
     *      The cursor has moved to the next SongNode,
     *      or remains at the end of the list.
     */
    public void cursorForwards(){
        if(cursor != null && cursor != tail){
            cursor = cursor.getNext();
            System.out.println("Cursor moved to next song.");
        }
        else if(cursor == null){
            System.out.println("No songs in the playlist.");
        }
        else {

            System.out.println("Already at end of playlist.");
        }

        //System.out.println(cursor.getData());
        /*
         * Set two different print statements for both.
         */
    }

    /**
     * Moves the cursor to point at the previous SongNode.
     * <b>Preconditions: </b>
     *      The list is not empty.
     * <b>Postconditions: </b>
     *      The cursor has been moved back to the previous SongNode,
     *      or it remains at the head of the list.
     */
    public void cursorBackwards(){
        if(cursor != null && cursor != head){
            cursor = cursor.getPrev();
            System.out.println("Cursor moved to previous song.");
        }
        else if(cursor == null){
            System.out.println("No songs in the playlist.");
        }
        else {
            System.out.println("Already at beginning of playlist.");
        }

        //System.out.println(cursor.getData());

    }

    /**
     * Inserts a song into the playlist after the cursor's current position.
     * <b>Preconditions: </b>
     *      The newSong object has been instantiated.
     * <b>Postconditions: </b>
     *      newSong is inserted into the playlist after the position
     *      of the cursor.
     *      All Song objects previously in the playlist are still in
     *      the playlist.
     *      The order of the playlist is preserved.
     *      The cursor now points to the inserted node.
     * @param newSong
     *      The Song object being inserted into the paragraph.
     * @throws IllegalArgumentException
     *      Throws an IllegalArgumentException if newSong is null.
     */
    public void insertAfterCursor(Song newSong) throws IllegalArgumentException {

        if(cursor == null) {
            SongNode newNode = new SongNode(newSong);
            cursor = newNode;
            head = newNode;
            tail = newNode;
            size++;
        }
        else if(cursor != tail){
            SongNode newNode = new SongNode(cursor, cursor.getNext(), newSong);
            cursor.setNext(newNode);
            newNode.getNext().setPrev(newNode);
            cursor = newNode;
            size++;
        }
        else{
            SongNode newNode = new SongNode(cursor, null, newSong);
            cursor.setNext(newNode);
            tail = newNode;
            cursor = newNode;
            size++;
        }
    }

    /**
     * The method removes the SongNode that the cursor is currently
     * pointing to, and returns the Song within that node.
     * <b>Preconditions: </b>
     *      The cursor is not null.
     * <b>Postconditions: </b>
     *      The SongNode referenced by the cursor has now been removed from the playlist.
     *      The cursor now references the next node, or the previous node if the next node
     *      does not exist.
     * @return
     *      Returns the Song that the SongNode was holding.
     */
    public Song removeCursor(){

        if(cursor == null){
            System.out.println("No songs to remove.");
            return null;
        }
        else if(cursor == head){
            Song removeSong = head.getData();
            if(size == 1)
                head = null;
            else {
                head = cursor.getNext();
                head.setPrev(null);
            }
            cursor = head;
            size--;
            return removeSong;
        }
        else if(cursor == tail){
            Song removeSong = tail.getData();
            tail = cursor.getPrev();
            tail.setNext(null);
            cursor = tail;
            size--;
            return removeSong;
        }
        else{
            Song removeSong = cursor.getData();
            cursor.getNext().setPrev(cursor.getPrev());
            cursor.getPrev().setNext(cursor.getNext());
            cursor = cursor.getNext();
            size--;
            return removeSong;
        }
    }

    /**
     * The method that selects a song in the playlist and plays it at random.
     * This does not change the order of the playlist.
     * <b>Postconditions: </b>
     *      The randomly selected song is now playing.
     * @return
     *      Returns the Song that was randomly selected.
     */
    public Song random(){

        SongNode tempCursor = head;

        int random = (int)(1 + Math.random()*size);

        int x = 1;

        while(x != random){
            tempCursor = tempCursor.getNext();
            x++;
        }

        return tempCursor.getData();
    }

    /**
     * The method randomly shuffles the order of the songs contained within the playlist.
     * <b>Postconditions: </b>
     *      The playlist is randomly reordered.
     *      The cursor references the SongNode which contains the same Song
     *      as when this method was entered.
     */
    public void shuffle(){

        Song saveCursor = cursor.getData();

        SongLinkedList tempList = new SongLinkedList();


        do {
            cursor = head;
            int random = (int) (1 + Math.random() * size);

            int x = 1;
            while(x != random){
                cursor = cursor.getNext();
                x++;
            }

            tempList.insertAfterCursor(removeCursor());

        }while(size > 0);

        head = tempList.getHead();
        tail = tempList.getTail();
        size = tempList.size;
        cursor = head;

        int x = 1;
        while(x != size){
            if(!cursor.getData().equals(saveCursor)){
                cursor = cursor.getNext();
                x++;
            }
            else
                break;
        }

        System.out.println("Playlist shuffled.");

        //tempList.

        //cursor = tempList.cursor;

    }

    /**
     * Prints the playlist in a formatted table.
     */
    public void printPlayerList(){

        SongNode tempCursor = cursor;

        System.out.println("Playlist: ");

        System.out.printf("%-30s%-18s%-20s%-10s", "| Song","| Artist", "| Album", "| Length (s)");
        System.out.println();

        System.out.println("-------------------------------------------" +
                "-----------------------------------------------------------");

        cursor = head;

        for (int x = 0; x < size; x++) {

            System.out.printf("%-30s%-18s%-20s%-10d", cursor.getData().getName(),
                    cursor.getData().getArtist(), cursor.getData().getAlbum(),
                    cursor.getData().getLength());

            if(tempCursor == cursor){
                System.out.print("   <--");
            }

            cursor = cursor.getNext();

            System.out.println();
        }
        System.out.println();

        cursor = tempCursor;
    }

    /**
     * This will delete all of the songs from the playlist.
     * <b>Postconditions: </b>
     *      All songs have been removed.
     */
    public void deleteAll(){

        head = null;
        cursor = null;
        tail = null;
        size = 0;

    }

    /**
     * Returns a neatly formatted String representation of the playlist.
     * @return
     *      A neatly formatted String representing the playlist in tabular form.
     */
    @Override
    public String toString() {
        SongNode tempCursor = cursor;
        cursor = head;

        String list = "";
        for(int x = 0; x < size; x++) {

            list += "%30s" + cursor.getData().getName() + "%-18s"
                    + cursor.getData().getArtist() + "%-20s" + cursor.getData().getAlbum()
                    + "%-10d" + cursor.getData().getLength() + "\n";
            if (tempCursor == cursor) {
                System.out.print("   <--");
            }

            cursor = cursor.getNext();
        }

        return list;
    }
}
