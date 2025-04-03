// Add 2 numbers
// RAM[2] = RAM[0] + RAM[1]
// Program usage: put values in RAM[0] and RAM[1]

@R0    // translated to @0, selects M=RAM[0], sets A=10
D=M    // stores value of RAM[0] in D

@R1      // M=RAM[1], A=10
D=D+M    // D = D(RAM[0]) + RAM[1]

@R2     // M=RAM[2]
M=D

@6
0;JMP