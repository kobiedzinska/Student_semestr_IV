import numpy as np
import random


# hamming code (15,11)
def createMessageVector(message):
    print("\nMessage vector")
    tablica = [int(znak) for znak in message]
    print(tablica)
    return np.array(tablica)

def create_generatorMatrix(k, n, q):
    Gmatrix = np.zeros((k, n))

    for i in range(k):
        Gmatrix[i][i] = 1

    for j in range(k):
        counter1s = 0
        while counter1s < 2:
            rand = random.randint(11, 14)
            if Gmatrix[j][rand] == 0:
                counter1s += 1
            Gmatrix[j][rand] = 1
        x = random.randint(0, 1)
        if x == 0:
            rand = random.randint(11, 14)
            Gmatrix[j][rand] = 1

    print(Gmatrix)
    return Gmatrix

def create_codeVector(matrix, msg):
    print("\nCode vector")
    code_vector = msg.dot(matrix) % 2
    print(code_vector)

def encode_hamming(message, codeword_bits, msg_bits):
    # Parameters
    check_bits = codeword_bits - msg_bits  # additional bits
    code_rate = msg_bits / codeword_bits

    if len(message) != msg_bits:
        print("Wrong size of message")
    else:
        print("Good size. Let's start coding")
        gMatrix = create_generatorMatrix(msg_bits, codeword_bits, check_bits)
        msg_vector = createMessageVector(message)
        create_codeVector(gMatrix, msg_vector)

        g1=[[1,0,0,0,0,0,0,0,0,0,0,0,0,1,1],
            [0,1,0,0,0,0,0,0,0,0,0,1,0,1,0],
            [0,0,1,0,0,0,0,0,0,0,0,0,1,1,0],
            [0,0,0,1,0,0,0,0,0,0,0,1,1,1,0],
            [0,0,0,0,1,0,0,0,0,0,0,1,0,0,1],
            [0,0,0,0,0,1,0,0,0,0,0,0,1,0,1],
            [0,0,0,0,0,0,1,0,0,0,0,1,1,0,1],
            [0,0,0,0,0,0,0,1,0,0,0,0,0,1,1],
            [0,0,0,0,0,0,0,0,1,0,0,1,0,1,1],
            [0,0,0,0,0,0,0,0,0,1,0,0,1,1,1],
            [0,0,0,0,0,0,0,0,0,0,1,1,1,1,1]]
        create_codeVector(g1,msg_vector)

encode_hamming("01010101010", 15, 11)