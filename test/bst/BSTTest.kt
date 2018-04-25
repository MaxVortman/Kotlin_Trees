import main.bst.BST
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BSTTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun insert() {
        //arrange
        val bst = BST<Int, Int>()
        //act
        bst.insert(2, 1)
        bst.insert(4, 2)
        bst.insert(1, 3)
        //assert
        assertEquals(1, bst.find(2))
        assertEquals(2, bst.find(4))
        assertEquals(3, bst.find(1))
    }

    @Test
    fun remove(){
        //arrange
        val bst = BST<Int, Int>()
        bst.insert(2, 1)
        bst.insert(4, 2)
        bst.insert(1, 3)
        //act
        bst.remove(2)
        //assert
        assertEquals(null, bst.find(2))
    }
}