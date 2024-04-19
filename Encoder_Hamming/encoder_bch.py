import komm
import divisionBinary


def addZeros(string):
    while len(string) < 15:
        string += "0"
    return string


def stringToPoly(message):
    indexes = []  # wystąpienia jedynek

    for i, char in enumerate(message):
        if char == '1':
            indexes.append(i)
    return komm.BinaryPolynomial.from_exponents(indexes)


def stringToArr(message):
    indexes = []  # wystąpienia jedynek

    for i, char in enumerate(message):
        if char == '1':
            indexes.append(i)
    return indexes


# formatujemy wielomian do string, np. [1,1,0,1] 1+x+x^3
def polyToString(code):
    returned = str(code)
    new_string = returned[2:]
    reversed_string = new_string[::-1]
    return reversed_string


def encode_BCH(message):
    tab = stringToArr(message)
    k = 15 - 7  # shift k-n
    xK = [k]
    tabG = "100010111"  # x^8 + x^7 + x^6 + x^4 + 1; generating polynomial

    # polyM - polynomial with our message
    # polyX - polynomial by which we multiply
    polyM = komm.BinaryPolynomial.from_exponents(tab)
    polyX = komm.BinaryPolynomial.from_exponents(xK)

    dividend = polyM * polyX
    h_xK = polyToString(dividend)

    remainder, quotient = divisionBinary.divide(h_xK, tabG)
    rem = divisionBinary.arrayToString(remainder)
    r = stringToPoly(rem)

    divSumRem = polyToString(dividend + r)
    encoded_message = addZeros(divSumRem)

    return encoded_message


msg = "0100110"
encoded_msg = encode_BCH(msg)
print(msg)
print(encoded_msg)
