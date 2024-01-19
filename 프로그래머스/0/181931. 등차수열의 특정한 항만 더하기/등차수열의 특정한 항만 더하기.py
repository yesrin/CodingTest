def solution(a, d, included):
    total = 0
    for i in range(len(included)):
        if included[i]: # included[i]가 True일 때
            total += a + d * i # 등차수열의 i+1항을 더한다.
    return total