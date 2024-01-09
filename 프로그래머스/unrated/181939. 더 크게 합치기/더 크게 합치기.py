def solution(a, b):
    str_a=str(a)
    str_b=str(b)
    
    int_ab=int(str_a+str_b)
    int_ba=int(str_b+str_a)
    
    if(int_ab >= int_ba):
        return int_ab
    else:
        return int_ba
    return answer