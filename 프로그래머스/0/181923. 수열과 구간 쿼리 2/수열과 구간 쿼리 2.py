def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        # k보다 큰 첫 번째 원소를 찾고, 없다면 -1을 추가
        for num in sorted(arr[s:e+1]):
            if num > k:
                answer.append(num)
                break
        else:
            answer.append(-1)
    return answer