package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class OddEvenLinkedListTest {

    @ParameterizedTest
    @MethodSource("argumentSourceProvider")
    void oddEvenList(OddEvenLinkedList.ListNode values, OddEvenLinkedList.ListNode expected) {
        OddEvenLinkedList.ListNode result = OddEvenLinkedList.oddEvenList(values);
        while (result != null) {
            Assertions.assertEquals(expected.val, result.val);
            result = result.next;
            expected = expected.next;
        }
    }

    private static Stream<Arguments> argumentSourceProvider() {
        return Stream.of(
                Arguments.of(generateListNode(new int[]{1, 2, 3, 4, 5}), generateListNode(new int[]{1, 3, 5, 2, 4})),
                Arguments.of(generateListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), generateListNode(new int[]{1, 3, 5, 7, 2, 4, 6, 8})),
                Arguments.of(generateListNode(new int[]{}), generateListNode(new int[]{})),
                Arguments.of(generateListNode(new int[]{2, 1, 3, 5, 6, 4, 7}), generateListNode(new int[]{2, 3, 6, 7, 1, 5, 4}))
        );
    }

    private static OddEvenLinkedList.ListNode generateListNode(int[] values) {
        if (values.length == 0) {
            return new OddEvenLinkedList.ListNode();
        }
        if (values.length == 1) {
            return new OddEvenLinkedList.ListNode(values[0]);
        }
        return new OddEvenLinkedList.ListNode(values[0], generateListNode(Arrays.copyOfRange(values, 1, values.length)));
    }
}