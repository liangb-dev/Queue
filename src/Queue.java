import java.util.EmptyStackException;

/**
 * @project: Queue
 * @author: liangb.dev
 * @version: 1.0
 * @date: 6/22/2017
 *
 * FIFO
 */
public class Queue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> last;
    private QueueNode<T> first;

    public void add(T data) {
        QueueNode<T> nd = new QueueNode<T>(data);
        if (last != null) {
            last.next = nd;
        }
        last = nd;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new EmptyStackException();
        T nd = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return nd;
    }

    public T peek() {
        if (first == null) throw new EmptyStackException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }


}
