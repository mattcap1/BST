/**
 * 
 */
package binarySearchTree;

import student.TestCase;

/**
 * @author Matt Capone (matt4222)
 * @version (2019.05.02)
 *
 */
public class BinarySearchTreeTest extends TestCase {
    private Lab14BinarySearchTree<String> tree;


    /**
     * Sets up the test tree
     */
    public void setUp() {
        tree = new Lab14BinarySearchTree<String>();
    }


    /**
     * Tests the insert() method
     */
    public void testInsert() {
        tree.insert("apple");
        tree.insert("act");
        tree.insert("bagel");

        try {
            tree.insert("apple");
        }
        catch (DuplicateItemException e) {
            assertNotNull(e);
        }
    }


    /**
     * Tests the remove() method
     */
    public void testRemove() {
        tree.insert("apple");
        tree.insert("act");
        tree.insert("bagel");

        tree.remove("apple");
        tree.remove("bagel");

        tree.insert("ab");
        tree.remove("ab");

        try {
            tree.remove("apple");
        }
        catch (ItemNotFoundException e) {
            assertNotNull(e);
        }
    }


    /**
     * Tests the findMin() method
     */
    public void testFindMin() {
        assertNull(tree.findMin());
        tree.insert("apple");
        tree.insert("act");
        assertEquals("act", tree.findMin());
        tree.remove("act");
        assertEquals("apple", tree.findMin());
    }


    /**
     * Tests the findMax() method
     */
    public void testFindMax() {
        assertNull(tree.findMax());
        tree.insert("apple");
        tree.insert("bagel");
        assertEquals("bagel", tree.findMax());
        tree.remove("bagel");
        assertEquals("apple", tree.findMax());
    }


    /**
     * Tests the find() method
     */
    public void testFind() {
        assertNull(tree.find("apple"));
        tree.insert("apple");
        tree.insert("act");
        tree.insert("bagel");
        assertEquals("act", tree.find("act"));
        assertEquals("apple", tree.find("apple"));
        assertEquals("bagel", tree.find("bagel"));
    }


    /**
     * Tests the makeEmpty()
     */
    public void testMakeEmpty() {
        tree.insert("apple");
        tree.makeEmpty();
        assertNull(tree.find("apple"));
    }


    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.insert("apple");
        assertFalse(tree.isEmpty());
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        tree.insert("act");
        tree.insert("apple");
        tree.insert("bagel");

        assertEquals("(act, apple, bagel)", tree.toString());
        Lab14BinarySearchTree<String> tree2 =
            new Lab14BinarySearchTree<String>();
        assertEquals("()", tree2.toString());
    }
}
