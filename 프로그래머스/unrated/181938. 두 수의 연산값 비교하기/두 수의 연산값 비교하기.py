def solution(a, b):
    str_ab=str(a)+str(b)
    int_2ab=2*a*b
    answer=max(int(str_ab),int_2ab)
    return answer