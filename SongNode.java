/**
 * A class that acts as a node wrapper around a Song object.
 * in a playlist. It represents a node in the linked list and contains
 * SongNode references to the previous and next nodes. It also contains
 * a Song variable that represents the object/data being stored in the node.
 *
 * @author
 * Nicole Niemiec
 * CSE 214 R08 FELIX
 * SEPTEMBER 24TH, HW #2
 *
 * @version 1
 */

public class SongNode {
    private SongNode prev;
    private SongNode next;
    private Song data;

    /**
     * A constructor that creates a SongNode node.
     */
    public SongNode() {
        prev = null;
        next = null;
        data = null;
    }

    /**
     * A constructor that creates a SongNode node and takes
     * in one parameter, defining the Song object data it contains.
     * @param data
     *      The Song object that the SongNode contains.
     */
    public SongNode(Song data){
        prev = null;
        next = null;
        this.data = data;
    }

    /**
     * A constructor that creates a SongNode node and takes in
     * three parameters, defining the two nodes that the SongNode links to,
     * as well as defining the Song object data that is contains.
     * @param prev
     *      The SongNode linked to the current node from the front of
     *      the list.
     * @param next
     *      The SongNode linked to the current node from the end of
     *      the list.
     * @param data
     *      The Song object that the current node contains.
     */
    public SongNode(SongNode prev, SongNode next, Song data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    /**
     * An accessor method for retrieving the SongNode linked
     * to the current node from the front of the list.
     * @return
     *      The SongNode linked to the current node from
     *      the beginning of the list.
     */
    public SongNode getPrev() {
        return prev;
    }

    /**
     * A mutator method for linking the current node to a node before
     * it in the list.
     * @param prev
     *      The node being linked to the current node from the
     *      front of the list.
     */
    public void setPrev(SongNode prev) {
        this.prev = prev;
    }

    /**
     * An accessor method for retrieving the SongNode linked
     * to the current node from the end of the list.
     * @return
     *      Returns the SongNode linked to the current node
     *      from the end of the list.
     */
    public SongNode getNext() {
        return next;
    }

    /**
     * A mutator method for linking the current node to a node after
     * it in the list.
     * @param next
     *      The node being linked to the current node from the
     *      end of the list.
     */
    public void setNext(SongNode next) {
        this.next = next;
    }

    /**
     * An accessor method for retrieving the Song object data that
     * the current SongNode holds.
     * @return
     *      The Song object that the SongNode holds.
     */
    public Song getData() {
        return data;
    }

    /**
     * A mutator method for setting the Song object that the SongNode
     * holds.
     * @param data
     *      The Song object that the current node will hold.
     */
    public void setData(Song data) {
        this.data = data;
    }
}
