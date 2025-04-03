// Examples of typical operations involving working with registers and memory

// D = 10
@10   // sets A=10, also selects M=RAM[10]
D=A

// D++
D=D+1

// D = RAM[17]
@17   // sets A=10, selects M=RAM[17]
D=M

// RAM[17] = D
@17
M=D

// RAM[17] = 10
@10   // sets A=10, selects M=RAM[10]
D=A   // stores the value of A=10 in D register
@17   // sets A=17, selects M=RAM[17]
M=D

// RAM[5] = RAM[3]
@3    // sets A=3, selects M=RAM[3]
D=M   // store value of M=RAM[3] in D register
@5    // sets A=5, selects M=RAM[5]
M=D

// RAM[11] = 10
@10     // sets A=10, M=RAM[10]
D=A     // sets D=10
A=D+1   // sets A=11 (can also write A=A+1), M=RAM[11]
M=D 