package leetcode.editor.datastructure.queue;

import java.util.stream.IntStream;

public class QueueTest {

    public static void main(String[] args) {
        /*SeqQueue<Integer> seqQueue = new SeqQueue<>(8);
        IntStream.rangeClosed(1, 8).forEach(seqQueue::add);
        IntStream.rangeClosed(1, 8).forEach(i -> {
            System.out.println(seqQueue.delete());
        });*/

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        IntStream.rangeClosed(1, 8).forEach(linkedQueue::add);
        IntStream.rangeClosed(1, 8).forEach(i -> System.out.println(linkedQueue.delete()));
    }
}
