import java.util.*;

class NI implements NestedInteger {
    private boolean isInteger;
    private int val;
    private List<NestedInteger> list;
    @Override
    public boolean isInteger() {
        return this.isInteger;
    }

    @Override
    public Integer getInteger() {
        return this.val;
    }

    @Override
    public List<NestedInteger> getList() {
        return this.list;
    }
}

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        addToStack(nestedList);
    }
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            addToStack(list); // 将嵌套的列表中的元素push到stack中，直到下一个元素不是列表而是一个数
        }
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return stack.pop().getInteger();
    }

    private void addToStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1;i >= 0;i--) {
            stack.push(nestedList.get(i));
        }
    }
}
