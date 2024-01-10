def solution(my_string, overwrite_string, s):
    int_overlen=len(overwrite_string)
    my_string[:s]+overwrite_string
    return my_string[:s]+overwrite_string+my_string[s+int_overlen:]