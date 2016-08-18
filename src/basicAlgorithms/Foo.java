package basicAlgorithms;

/**
 * Created by Shaun on 7/28/2016.
 */
public class Foo {

    //static initializer
    static {
        System.out.println("static initializer called");
    }

    //instance variable initializer
    // instance initializers and instance variable initializers are pretty much the same
    String s = "abc";

    //instance initializer
    {
        System.out.println("instance initializer called");
    }

    //constructor
    public Foo() {
        System.out.println("constructor called");
    }

    public static void main(String[] args) {
        new Foo();
        new Foo();
        new Foo();
    }
}