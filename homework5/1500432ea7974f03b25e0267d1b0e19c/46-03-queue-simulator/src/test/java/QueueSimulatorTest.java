import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * QueueSimulator 公开测试。
 */
public class QueueSimulatorTest {

    // ==================== hotPotato 测试 ====================

    @Test
    public void 击鼓传花_五人每轮传3次() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        assertEquals("D", QueueSimulator.hotPotato(names, 3));
    }

    @Test
    public void 击鼓传花_两人每轮传1次() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B"));
        assertEquals("B", QueueSimulator.hotPotato(names, 1));
    }

    @Test
    public void 击鼓传花_一人直接返回() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("X"));
        assertEquals("X", QueueSimulator.hotPotato(names, 5));
    }

    @Test
    public void 击鼓传花_三人每轮传2次() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B", "C"));
        // A->队尾, B淘汰 -> [C,A]
        // C->队尾, A淘汰 -> [C]
        assertEquals("C", QueueSimulator.hotPotato(names, 2));
    }

    @Test
    public void 击鼓传花_四人每轮传1次() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        // num=1: 每轮直接淘汰队首
        // A淘汰 -> [B,C,D]
        // B淘汰 -> [C,D]
        // C淘汰 -> [D]
        assertEquals("D", QueueSimulator.hotPotato(names, 1));
    }

    // ==================== josephus 测试 ====================

    @Test
    public void 约瑟夫环_5人每2个淘汰() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 1, 5, 3));
        assertEquals(expected, QueueSimulator.josephus(5, 2));
    }

    @Test
    public void 约瑟夫环_1人() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));
        assertEquals(expected, QueueSimulator.josephus(1, 1));
    }

    @Test
    public void 约瑟夫环_3人每1个淘汰() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(expected, QueueSimulator.josephus(3, 1));
    }

    @Test
    public void 约瑟夫环_6人每3个淘汰() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 6, 4, 2, 5, 1));
        assertEquals(expected, QueueSimulator.josephus(6, 3));
    }

    @Test
    public void 约瑟夫环_4人每2个淘汰() {
        // [1,2,3,4] -> 1->队尾, 2出列 -> [3,4,1]
        // 3->队尾, 4出列 -> [1,3]
        // 1->队尾, 3出列 -> [1]
        // 1出列
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 3, 1));
        assertEquals(expected, QueueSimulator.josephus(4, 2));
    }

    // ==================== generateSequence 测试 ====================

    @Test
    public void 生成序列_7个元素() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(expected, QueueSimulator.generateSequence(7));
    }

    @Test
    public void 生成序列_1个元素() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));
        assertEquals(expected, QueueSimulator.generateSequence(1));
    }

    @Test
    public void 生成序列_4个元素() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(expected, QueueSimulator.generateSequence(4));
    }

    @Test
    public void 生成序列_0个元素返回空列表() {
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals(expected, QueueSimulator.generateSequence(0));
    }

    @Test
    public void 生成序列_3个元素() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(expected, QueueSimulator.generateSequence(3));
    }

    @Test
    public void 生成序列_10个元素() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertEquals(expected, QueueSimulator.generateSequence(10));
    }
}
