def solution(numLog):
    answer = ""  # 결과를 저장할 문자열 초기화
    for i in range(1, len(numLog)):  # 범위를 1부터 len(numLog)까지로 수정
        if numLog[i] - numLog[i-1] == 1:
            answer += "w"
        elif numLog[i] - numLog[i-1] == -1:
            answer += "s"
        elif numLog[i] - numLog[i-1] == 10:
            answer += "d"
        elif numLog[i] - numLog[i-1] == -10:
            answer += "a"
    return answer