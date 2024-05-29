import java.util.*;
public class BitwiseOp {
    public static void main(String[] args) {
        int a ,b;
	Scanner s =new Scanner(System.in);
	try{
	System.out.println("Enter two numbers:");
	a=s.nextInt();
	b=s.nextInt();
        // Bitwise AND (&) Operator
        int resultAnd = a & b;
        System.out.println("a & b = " + resultAnd); // Output: 1 (0000 0001)

        // Bitwise OR (|) Operator
        int resultOr = a | b;
        System.out.println("a | b = " + resultOr); // Output: 7 (0000 0111)

        // Bitwise XOR (^) Operator
        int resultXor = a ^ b;
        System.out.println("a ^ b = " + resultXor); // Output: 6 (0000 0110)

        // Bitwise Complement (~) Operator
        int resultComplementA = ~a;
        System.out.println("~a = " + resultComplementA); // Output: -6 (1111 1010)

        // Left Shift (<<) Operator
        int resultLeftShift = a << 2; // shifting 'a' left by 2 positions
        System.out.println("a << 2 = " + resultLeftShift); // Output: 20 (0001 0100)

        // Right Shift (>>) Operator
        int resultRightShift = a >> 1; // shifting 'a' right by 1 position
        System.out.println("a >> 1 = " + resultRightShift); // Output: 2 (0000 0010)
	}
	catch(Exception e){}
    }
}
