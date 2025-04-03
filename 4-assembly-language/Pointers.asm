// int[] arr = new int[15];
// initialize array values...
// int n = 10;
// for (int i=0; i<n; i++) {
//     arr[i] = -1;
// }
// When a compiler translates high level code into machine language, the notion or abstraction
// of arrays gets lost. Array entries are simply values in memory registers starting at some
// base address e.g. at R100
// Assembly code to manipulate first 10 entries of an array whose base address in memory is R100

// arr = 100
@100    // A=100, M=RAM[100]
D=A
@arr
M=D     // arr variable stores base address of array

// n = 10
@10
D=A
@n
M=D    // n=10; the number of array entries i.e. memory registers we want to manipulate; R100 onwards

// i = 0
@i
M=0

(LOOP)
// if (i==n), goto END, else continue
@i
D=M
@n
D=D-M
@END
D;JEQ      // goto END if i > n => if i-n equals 0

// set RAM[arr+i] to -1
@arr
D=M       // contains base address of array
@i
A=D+M     // set contents of A register to address of memory register arr+i; M=RAM[A]
M=-1

// increment i - i++
@i
M=M+1

@LOOP
0;JMP

(END)
0;JMP

