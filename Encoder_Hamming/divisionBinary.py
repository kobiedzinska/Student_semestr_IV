def count(text):
    reversed_text = text[::-1]
    index_of_1 = reversed_text.find('1')
    if index_of_1 != -1:
        index_of_1 = len(
            text) - index_of_1 - 1  # Przekształcamy indeks z odwróconego tekstu na indeks w oryginalnym tekście
        return index_of_1
    else:
        return -1


def stringToArray(text):  # zamienia stringa na tablice intów
    char_array = []

    for char in text:
        char_array.append(int(char))

    return char_array


def arrayToString(array):  # zamiana tablice intów na stringa

    arr = [str(element) for element in array]
    string = "".join(arr)

    return string


# uzupełnianie jednej tabeli, drugą tabelą, od pewnego miejsca
# tab 1 - tablica uzupełniana, tab 2 - tablica, którą uzupełniamy
# step - miejsce w tab 1, od którego zaczynamy
def fill_table(tab1, tab2, step):
    tab1 = [0] * len(tab1)
    if step < 0 or step >= len(tab1):
        return "Issue: index out of tab1. fill_table problem"

    for i in range(len(tab2)):
        if step + i < len(tab1):
            tab1[step + i] = tab2[i]
        else:
            return "Issue with appending tab2 to tab 1. fill_table problem"
    return tab1


# summing 2 tables with the same size mod 2
def sum_tables(arr1, arr2):
    a = len(arr1)
    b = len(arr2)

    if a == 0 or b == 0:
        return "Issue: empty tab 1 or tab 2"

    for i in range(a):
        arr1[i] = (arr1[i] + arr2[i]) % 2

    return arr1


def divide(dividend, divisor):
    k = 0
    n = 0

    # zamieniamy nasze liczby na tablice int
    numerator = stringToArray(dividend)
    denominator = stringToArray(divisor)

    k = count(dividend)  # order of number
    n = count(divisor)  # order of denominator
    r = k - n

    # if order of number is 0, then :
    if r > 0 or k == 0:

        xd = [0] * len(numerator)

        counter = r
        size_N = len(numerator) - 1
        quotient = [0] * (counter + 1)
        quotient[counter] = numerator[size_N]

        while counter >= 0:

            b = fill_table(xd, denominator, counter)  # x^(k-n-1) * d == x^4 * d

            if numerator[size_N] == 1:
                numerator = sum_tables(numerator, b)

            size_N -= 1

            if counter - 1 >= 0:
                quotient[counter - 1] = numerator[size_N]
            counter -= 1

        # the last numerator is our remainder
        return numerator, quotient
    else:
        return dividend, "0"



