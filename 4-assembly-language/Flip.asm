// Flip the values of RAM[0] and RAM[1]
// temp = R1
// R1 = R0
// R0 = temp

@R1      // M=RAM[1]
D=M
@temp    // finds first available memory register, selects it (M=RAM[temp])
M=D      // temp = R1

@R0
D=M
@R1
M=D      // R1 = R0

@temp
D=M
@R0
M=D      // R0 = temp