package learn.alg.stack;

/**
 * @author: heisenberg 2021-06-04
 **/
public class StackTest {
    public static void main(String[] args) {
        Stack155 stackTest = new Stack155();
        stackTest.push(9);
        stackTest.push(6);
        stackTest.push(3);
        stackTest.push(2);
        stackTest.push(9);
        System.out.println(stackTest.getMin());
    }
}
