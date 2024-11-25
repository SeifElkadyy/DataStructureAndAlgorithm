package Stacks;

public class StackDecompose {
    public static ArrayStack decompose(ArrayStack x) {
        ArrayStack y = new ArrayStack(x.size()/2);
        ArrayStack even = new ArrayStack(x.size()/2 +1);
        ArrayStack odd = new ArrayStack(x.size()/2);

        while(!x.isEmpty()){
            odd.push(x.pop());
            if(!x.isEmpty()){
                even.push(x.pop());
            }
        }
        while (!even.isEmpty()){
            y.push(even.pop());
        }
        while (!odd.isEmpty()){
            x.push(odd.pop());
        }
        return y;
    }
    public static void main(String[] args) {
        ArrayStack x = new ArrayStack(10);
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(4);
        x.push(5);
        x.push(6);
        x.push(7);
        x.push(8);
        x.push(9);
        x.push(10);

        x.printStack();

        ArrayStack y = decompose(x);
        x.printStack();
        System.out.print("");
        y.printStack();

    }
}
