// Compute RAM[1] = 1 + 2 + ... + n
// Program usage: put a number n in RAM[0]

// n = R0
@R0
D=M
@n
M=D    // n=R0 (number up to which the sum has to be computed)

// i = 1; accumulator to keep track of current number
@i
M=1

// sum = 0; sum accumulator
@sum
M=0

(LOOP)
@i
D=M      // D=value of i (starting value is 1)
@n
D=D-M    // D = i-n
@STOP
D;JGT    // if i>n, goto STOP

@sum
D=M      // D=sum
@i       // M=RAM[i]
D=D+M    // D=sum+i
@sum
M=D      // sum = sum + i

@i
M=M+1
@LOOP
0;JMP

(STOP)
@sum
D=M
@R1
M=D     // RAM[1] = sum

(END)
@END
0;JMP

